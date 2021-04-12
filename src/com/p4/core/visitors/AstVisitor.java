package com.p4.core.visitors;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyParser;
import com.p4.core.nodes.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;

public class AstVisitor<T> extends GEasyBaseVisitor<AstNode> {
    // The ProgNode is a the top of our grammar, and we keep this as our entry point, always.
    @Override
    public AstNode visitProg(GEasyParser.ProgContext ctx) {
        ProgNode progNode = new ProgNode();

        // We visit all the children prog has (which is the whole program)
        return visitChildren(progNode, ctx.children.toArray(ParseTree[]::new));
    }

    // Helper function to visit all the children of a particular ParseTree
    private AstNode visitChildren(AstNode node, ParseTree[] children) {
        // Iterates through all the node's children
        for(ParseTree child : children) {

            // Skip leaves/terminals
            if(child.getPayload() instanceof CommonToken) {
                continue;
            }

            node.children.add(visit(child));
        }

        return node;
    }

    // We won't add dcl as a node in our Ast, as it contains only non-terminals
    // Basically, it will only clutter the Ast with an unecessary node
    @Override
    public AstNode visitDcl(GEasyParser.DclContext ctx) {
        // A dcl can be one of the following non-terminals:
        // assign, var_dcl, func_dcl
        GEasyParser.AssignContext assign = ctx.assign();
        GEasyParser.Var_dclContext var_dcl = ctx.var_dcl();
        GEasyParser.Func_dclContext func_dcl = ctx.func_dcl();

        // Figure out which dcl we're dealing with
        if(assign != null) {
            return visit(assign);
        }
        else if(var_dcl != null) {
            return visit(var_dcl);

        } else if(func_dcl != null) {
            return visit(func_dcl);
        }

        // Does not contain a DCL (error)
        return null;
    }

    @Override
    public AstNode visitVar_dcl(GEasyParser.Var_dclContext ctx) {
        GEasyParser.Num_dclContext num_dcl = ctx.num_dcl();
        GEasyParser.Pos_dclContext pos_dcl = ctx.pos_dcl();
        GEasyParser.Array_dclContext array_dcl = ctx.array_dcl();
        GEasyParser.Bool_dclContext bool_dcl = ctx.bool_dcl();

        if(num_dcl != null) {
            return visit(num_dcl);
        }
        else if(pos_dcl != null) {
            return visit(pos_dcl);

        }
        else if(array_dcl != null) {
            return visit(array_dcl);
        }
        else if(bool_dcl != null) {
            return visit(bool_dcl);
        }

        // No var_dcl (error)
        return null;
    }

    @Override
    public AstNode visitNum_dcl(GEasyParser.Num_dclContext ctx) {
        String type = ctx.TYPE().toString();
        String ID = ctx.ID().toString();

        GEasyParser.ExprContext expr = ctx.expr();
        GEasyParser.Func_callContext func_call = ctx.func_call();

        // Find what kind of var_dcl we're dealing with
        // Should we add pos here somehow? (Requires a change in our grammar)
        AstNode dclNode;
        switch (type) {
            case "int":
                dclNode = new IntDclNode(ID);
                break;
            case "double":
                dclNode = new DoubleDclNode(ID);
                break;
            default:
                return null;
        }

        // A variable can be initialized to either an expression or func call
        // If it's an expr/func_call we visit the given node and add it as a child to our dclNode
        if(expr != null) {
            AstNode exprNode = visit(ctx.expr());
            dclNode.children.add(exprNode);
            return dclNode;
        }
        else if(func_call != null) {
            AstNode funcCallNode = visit(ctx.func_call());
            dclNode.children.add(funcCallNode);
            return dclNode;
        }

        // No var_dcl (error)
        return null;
    }

    @Override
    public AstNode visitArray_dcl(GEasyParser.Array_dclContext ctx) {
        String id = ctx.ID().toString();
        String type = ctx.TYPE().toString();

        ArrayDclNode arrayDclNode = new ArrayDclNode(id, type);

        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if(child instanceof GEasyParser.ValContext) {
                AstNode childNode = visit(child);
                arrayDclNode.children.add(childNode);
            }
        }

        return arrayDclNode;
    }

    @Override
    public AstNode visitBool_dcl(GEasyParser.Bool_dclContext ctx) {
        String ID = ctx.ID().toString();
        String type = ctx.BOOL_T().toString();

        BoolDclNode boolDclNode = new BoolDclNode(ID, type);

        GEasyParser.Logical_exprContext logicalExpr = ctx.logical_expr();

        if(logicalExpr != null) {
            boolDclNode.children.add(visit(logicalExpr));
            return boolDclNode;
        }

        // error
        return null;
    }


    @Override
    public AstNode visitAssign(GEasyParser.AssignContext ctx) {
        // A assign node can consist of either an array_access, expr, func_call or pos_assign
        GEasyParser.Array_accessContext array_access = ctx.array_access();
        GEasyParser.ExprContext expr = ctx.expr();
        GEasyParser.Func_callContext func_call = ctx.func_call();
        GEasyParser.Pos_assignContext pos_assign = ctx.pos_assign();


        // Find out which one
        if(array_access != null) {
            AstNode arrayAccessNode = visitArray_access(array_access);
            return arrayAccessNode;
        }
        else if(expr != null){
            String id = ctx.ID().toString();
            AssignNode assignNode = new AssignNode(id);

            AstNode exprNode = visitExpr(expr);
            assignNode.children.add(exprNode);

            return assignNode;
        }
        else if (func_call != null) {
            String id = ctx.ID().toString();
            AssignNode assignNode = new AssignNode(id);

            AstNode funcCallNode = visitFunc_call(func_call);
            assignNode.children.add(funcCallNode);

            return assignNode;
        }
        else if (pos_assign != null) {
            String id = ctx.ID().toString();
            AssignNode assignNode = new AssignNode(id);

            AstNode posAssignNode = visitPos_assign(pos_assign);
            assignNode.children.add(posAssignNode);

            return assignNode;
        } else {
            // error...
            return null;
        }
    }

    @Override
    public AstNode visitPos_dcl(GEasyParser.Pos_dclContext ctx) {
        String id = ctx.ID().toString();
        String pos = ctx.POS().toString();

        PosDclNode posDclNode = new PosDclNode(id);
        posDclNode.setType(pos);

        GEasyParser.Pos_assignContext assign = ctx.pos_assign();

        // Note: We need to add this as a child, right?
        if(assign != null){
            AstNode posAssignNode = visitPos_assign(ctx.pos_assign());
            posDclNode.children.add(posAssignNode);
            return posDclNode;
        }

        return null;
    }

    @Override
    public AstNode visitPos_assign(GEasyParser.Pos_assignContext ctx) {
        PosAssignNode posAssignNode = new PosAssignNode(ctx.toString());

        AstNode xCordVal = visit(ctx.val(0));
        AstNode yCordVal = visit(ctx.val(1));

        PosNode posNode = new PosNode<>(xCordVal, yCordVal);
        posAssignNode.children.add(posNode);

        return posAssignNode;
    }

    @Override
    public AstNode visitArray_access(GEasyParser.Array_accessContext ctx) {
        ArrayAccessNode arrayAccessNode = new ArrayAccessNode(ctx.ID().toString());

        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if(child instanceof GEasyParser.ExprContext){
                AstNode exprNode = visit(child);
                arrayAccessNode.children.add(exprNode);
            }
        }

        return arrayAccessNode;
    }

    @Override
    public AstNode visitExpr(GEasyParser.ExprContext ctx) {
        // Create empty ExprNode to add children to later
        ExprNode exprNode = new ExprNode();

        // Go through all the children of our expression
        // First we get the number of children, and then use it in the for-loop
        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            // We create a ParseTree from the child
            // We do this, so we travese it's children easily
            ParseTree child = ctx.getChild(childIndex);

            // Since we're not interested in all of the children in the expression, we only deal with those we neeed in our AST
            // In our case, it's the non-terminals: val, array_access and expr.
            if((child instanceof GEasyParser.ExprContext) || (child instanceof GEasyParser.ValContext) || (child instanceof GEasyParser.Array_accessContext))  {
                // We create a new AstNode where we visit the child
                // and add it as a child
                AstNode childNode = visit(child);
                exprNode.children.add(childNode);

                // We also need to grab all the arithmetic operators, as we need them when type checking
                // We add 1 to childIndex as, from our grammar, we know a value/array_access always will be followed by an arithmetic operator
                if(childIndex + 1 < childCount) {
                    // We use the helper function 'getArithmeticOPNode' to retrieve the operator we need
                    ParseTree nextChild = ctx.getChild(childIndex + 1);
                    AstNode arithmNode = VisitArithmeticOPNode(nextChild);

                    // If there is an arithmetic operator, we add it as a child to expr
                    if(arithmNode != null) {
                        exprNode.children.add(arithmNode);
                    }
                }
            }
        }
        return exprNode;
    }

    // Helper function to get the aritmethic operator
    public AstNode VisitArithmeticOPNode(ParseTree child) {
        if(child != null) {
            switch(child.getText()) {
                case "%":
                    return new ArithmeticNode(GEasyParser.MOD);
                case "+":
                    return new ArithmeticNode(GEasyParser.PLUS);
                case "-":
                    return new ArithmeticNode(GEasyParser.MINUS);
                case "*":
                    return new ArithmeticNode(GEasyParser.MULTIPLICATION);
                case "/":
                    return new ArithmeticNode(GEasyParser.DIVISION);
                default:
                    return null;
            }
        }
        return null;
    }

    @Override
    public AstNode visitFunc_call(GEasyParser.Func_callContext ctx) {
        FuncCallNode funcCallNode = new FuncCallNode(ctx.ID().toString());

        int childCount = ctx.getChildCount();

        // We go through all the children and add those we need for our Ast
        // In our case it's the non-terminal expr, and ...
        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if(child instanceof GEasyParser.Actual_paramContext) {
                AstNode childNode = visit(child);
                funcCallNode.children.add(childNode);
            }
        }

        return funcCallNode;
    }

    @Override
    public AstNode visitActual_param(GEasyParser.Actual_paramContext ctx) {
        String ID = ctx.ID().toString();

        ActualParamNode actualParamNode = new ActualParamNode(ID);

        int childCount = ctx.getChildCount();

        // We go through all the children and add those we need for our Ast
        // In our case it's the non-terminal expr
        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if((child instanceof GEasyParser.ExprContext) || (child instanceof GEasyParser.Actual_paramContext)) {
                AstNode childNode = visit(child);
                actualParamNode.children.add(childNode);
            }
        }

        return actualParamNode;
    }

    @Override
    public AstNode visitStmt(GEasyParser.StmtContext ctx) {
        // A stmtNode can be an assign, expr, func_call, selection, iterative or LINE_COMMENT
        GEasyParser.AssignContext assign = ctx.assign();
        GEasyParser.ExprContext expr = ctx.expr();
        GEasyParser.Func_callContext func_call = ctx.func_call();
        GEasyParser.SelectionContext selection = ctx.selection();
        GEasyParser.IterativeContext iterative = ctx.iterative();
        GEasyParser.CommentContext comment = ctx.comment();

        // Find out which one
        if(assign != null){
            return visit(assign);
        }
        else if(expr != null) {
            return visit(expr);
        }
        else if (func_call != null) {
            return visit(func_call);
        }
        else if (selection != null) {
            return visit(selection);

        } else if(iterative != null){
            return visit(iterative);

        } else if(comment != null) {
            return visit(comment);
        }

        // error
        return null;
    }

    @Override
    public AstNode visitSelection(GEasyParser.SelectionContext ctx) {
        SelectionNode selectionNode;

        if(ctx.ELSE() != null) {
            selectionNode = new SelectionNode(ctx.IF().toString(), true);
        } else {
            selectionNode = new SelectionNode(ctx.IF().toString(), false);
        }

        // Visit the condition
        // How do we handle the case of a bool here??
        // Maybe it's possible to make BOOL a part of logical_expr? (I moved it)
        selectionNode.children.add(visit(ctx.logical_expr()));

        // Visit the block, if there is an else present, it visits both blocks
        for(GEasyParser.BlockContext block : ctx.block()) {
            selectionNode.children.add(visitBlock(block));
        }

        return selectionNode;
    }

    @Override
    public AstNode visitIterative(GEasyParser.IterativeContext ctx) {
        String type = ctx.FOR().toString();
        String for_to = ctx.TO().toString();
        IterativeNode iterativeNode = new IterativeNode(type, for_to);

        // Visit children
        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if((child instanceof GEasyParser.ValContext) || (child instanceof GEasyParser.BlockContext)) {
                AstNode childNode = visit(child);
                iterativeNode.children.add(childNode);
            }
        }

        return iterativeNode;
    }

    @Override
    public AstNode visitLogical_expr(GEasyParser.Logical_exprContext ctx) {
        LogicalExprNode logicalExprNode = new LogicalExprNode();

        int childCount = ctx.getChildCount();

        // Go through all the children
        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if((child instanceof GEasyParser.Logical_exprContext) || (child instanceof GEasyParser.Comp_exprContext) || (child instanceof GEasyParser.Bool_exprContext)) {
                AstNode childNode = visit(child);
                logicalExprNode.children.add(childNode);
            }

            // If there is a comp operator we add it
            if(visitLogicalOperatorNode(child) != null) {
                logicalExprNode.children.add(visitLogicalOperatorNode(child));
            }
        }

        return logicalExprNode;
    }

    private AstNode visitLogicalOperatorNode(ParseTree child) {
        if(child != null) {
            switch (child.getText()) {
                case "&&":
                    return new LogicalOPNode(GEasyParser.AND);
                case "||":
                    return new LogicalOPNode(GEasyParser.OR);
                default:
                    return null;
            }
        }

        return null;
    }

    private AstNode getCompNode(ParseTree child) {
        if(child != null) {
            CompNode compNode = new CompNode();

            switch (child.getText()) {
                case "<":
                    compNode.setToken(GEasyParser.LESS_THAN);
                    return compNode;
                case ">":
                    compNode.setToken(GEasyParser.GREATER_THAN);
                    return compNode;
                case "<=":
                    compNode.setToken(GEasyParser.LESS_THAN_EQ);
                    return compNode;
                case ">=":
                    compNode.setToken(GEasyParser.GREATER_THAN_EQ);
                    return compNode;
                case "==":
                    compNode.setToken(GEasyParser.IS_EQ);
                    return compNode;
                case "!=":
                    compNode.setToken(GEasyParser.NOT_EQ);
                    return compNode;
                default:
                    // Error
                    return null;
            }
        }
        // error
        return null;
    }

    @Override
    public AstNode visitComp_expr(GEasyParser.Comp_exprContext ctx) {
        CompExprNode compExprNode = new CompExprNode();

        int childCount = ctx.getChildCount();
        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if(child instanceof GEasyParser.ExprContext) {
                AstNode childNode = visit(child);
                compExprNode.children.add(childNode);
            }

            if(getCompNode(child) != null) {
                compExprNode.children.add(getCompNode(child));
            }
        }

        return compExprNode;
    }

    @Override
    public AstNode visitBool_expr(GEasyParser.Bool_exprContext ctx) {
        BoolExprNode boolExprNode = new BoolExprNode();

        int childCount = ctx.getChildCount();
        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if(visitBoolNode(child) != null) {
                AstNode childNode = visitBoolNode(child);
                boolExprNode.children.add(childNode);
            }
            else if(getCompNode(child) != null) {
                boolExprNode.children.add(getCompNode(child));
            }
            else if(visitIDNode(child) != null) {
                boolExprNode.children.add(visitIDNode(child));
            }
        }
        // error
        return boolExprNode;
    }

    private AstNode visitIDNode(ParseTree child) {
        if(child != null) {
            return new IDNode(child.getText());
        }

        // error
        return null;
    }

    private AstNode visitBoolNode(ParseTree child) {
        if(child != null) {
            switch (child.getText()) {
                case "true":
                    return new BoolNode(true);
                case "false":
                    return new BoolNode(false);
                default:
                    return null;
            }
        }

        // error
        return null;
    }

    @Override
    public AstNode visitFunc_dcl(GEasyParser.Func_dclContext ctx) {
        String id = ctx.ID().toString();

        FuncDclNode funcDclNode;

        if(ctx.TYPE() != null) {
            funcDclNode = new FuncDclNode(id, ctx.TYPE().toString());
        }
        else if(ctx.VOID() != null) {
            funcDclNode = new FuncDclNode(id, ctx.VOID().toString());
        }
        else if(ctx.BOOL_T() != null) {
            funcDclNode = new FuncDclNode(id, ctx.BOOL_T().toString());
        } else {
            return null;
        }

        // Visit children
        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if((child instanceof GEasyParser.ValContext) || (child instanceof GEasyParser.BlockContext)) {
                AstNode childNode = visit(child);
                funcDclNode.children.add(childNode);
            }
        }

        return funcDclNode;
    }

    @Override
    public AstNode visitFormal_param(GEasyParser.Formal_paramContext ctx) {
        FormalParamNode formalParamNode = new FormalParamNode();

        int childrenCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childrenCount; childIndex++) {
            IDNode idNode;
            String type = ctx.getChild(childIndex).toString();

            switch (type) {
                case "int":
                    idNode = new IDNode(ctx.getChild(++childIndex).toStringTree(), "int");
                    break;
                case "double":
                    idNode = new IDNode(ctx.getChild(++childIndex).toStringTree(), "double");
                    break;
                default:
                    idNode = null;
                    break;
            }

            if(idNode != null) {
                formalParamNode.children.add(idNode);
            }
        }

        return formalParamNode;
    }

    @Override
    public AstNode visitBlock(GEasyParser.BlockContext ctx) {
        BlockNode blockNode = new BlockNode();

        // Since a block can contain a lot of different constructs,
        // we use the visitChildren() function
        return visitChildren(blockNode, ctx.children.toArray(ParseTree[]::new));
    }

    @Override
    public AstNode visitReturn_expr(GEasyParser.Return_exprContext ctx) {
        ReturnExprNode returnExprNode = new ReturnExprNode();

        GEasyParser.ExprContext expr = ctx.expr();

        if(expr != null) {
            returnExprNode.children.add(visit(expr));
            return returnExprNode;
        }
        else if (ctx.BOOL() != null) {
            BoolNode boolNode = new BoolNode(Boolean.parseBoolean(ctx.BOOL().toString()));
            returnExprNode.children.add(boolNode);
            return returnExprNode;
        }

        return null;
    }

    // Handles our non-terminal 'val'
    // Can be either an ID or number
    // A number can then be either an int or double (the only number types in G-Easy)
    @Override
    public AstNode visitVal(GEasyParser.ValContext ctx){
        if(ctx.NUMBER() != null) {
            // Check if double
            if(ctx.NUMBER().getText().contains(".")) {
                return new DoubleNode(Double.parseDouble(ctx.getText()));
            } else {
                // If not a double, it is an int
                return new IntNode(Integer.parseInt(ctx.getText()));
            }
        } else if (ctx.ID() != null){
            return new IDNode(ctx.getText());
        } else {
            return null;
        }
    }

    // Is this needed, as the parser ignores comments ...?
    @Override
    public AstNode visitComment(GEasyParser.CommentContext ctx) {
        String lineComment = ctx.LINE_COMMENT().toString();

        if(lineComment != null) {
            LineCommentNode commentNode = new LineCommentNode(lineComment);
            return commentNode;
        }
        // error
        return null;
    }

}
