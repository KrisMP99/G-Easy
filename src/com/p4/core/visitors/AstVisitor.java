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
    public AstNode visitLogical_expr(GEasyParser.Logical_exprContext ctx) {
        // only one child
        if(ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }
        else {
            return visitLogicalExprChildren(ctx, ctx.getChild(1), 1);
        }
    }

    private AstNode visitLogicalExprChildren(GEasyParser.Logical_exprContext parent, ParseTree child, int operatorIndex) {
        LogicalExprNode node = new LogicalExprNode();

        int nextOperator = operatorIndex + 2;

        switch(child.getText()) {
            case "&&":
                node.setToken(GEasyParser.AND);
                break;
            case "||":
                node.setToken(GEasyParser.OR);
                break;
            case "<":
                node.setToken(GEasyParser.LESS_THAN);
                break;
            case ">":
                node.setToken(GEasyParser.GREATER_THAN);
                break;
            case "<=":
                node.setToken(GEasyParser.LESS_THAN_EQ);
                break;
            case ">=":
                node.setToken(GEasyParser.GREATER_THAN_EQ);
                break;
            case "==":
                node.setToken(GEasyParser.IS_EQ);
                break;
            case "!=":
                node.setToken(GEasyParser.NOT_EQ);
                break;
            default:
                return null;
        }

        if(parent.getChild(nextOperator) != null) {
            node.children.add(visit(parent.getChild(operatorIndex - 1)));
            node.children.add(visitLogicalExprChildren(parent, parent.getChild(nextOperator), nextOperator));

        }
        else {
            node.children.add(visit(parent.getChild(operatorIndex - 1)));
            node.children.add(visit(parent.getChild(operatorIndex + 1)));
        }

        return node;
    }

    @Override
    public AstNode visitComp_expr(GEasyParser.Comp_exprContext ctx) {

        // If there is only one child
        if(ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }

        CompExprNode compExprNode = new CompExprNode();

        switch (ctx.getChild(1).getText()) {
            case "<":
                compExprNode.setToken(GEasyParser.LESS_THAN);
                break;
            case ">":
                compExprNode.setToken(GEasyParser.GREATER_THAN);
                break;
            case "<=":
                compExprNode.setToken(GEasyParser.LESS_THAN_EQ);
                break;
            case ">=":
                compExprNode.setToken(GEasyParser.GREATER_THAN_EQ);
                break;
            case "==":
                compExprNode.setToken(GEasyParser.IS_EQ);
                break;
            case "!=":
                compExprNode.setToken(GEasyParser.NOT_EQ);
                break;
            default:
                return null;
        }

        // Add the children
        compExprNode.children.add(visit(ctx.getChild(0)));
        compExprNode.children.add(visit(ctx.getChild(2)));

        return compExprNode;
    }

    @Override
    public AstNode visitExpr(GEasyParser.ExprContext ctx) {
        // only one term
        if(ctx.getChildCount() == 1) {
            return visit(ctx.term(0));
        }
        else {
            // Multiple terms
            return visitExprChildren(ctx, ctx.getChild(1),1);

        }
    }

    private AstNode visitExprChildren(GEasyParser.ExprContext parent, ParseTree child, int operatorIndex){
        AstNode node;

        int termIndex = (operatorIndex - 1) / 2;
        int nextOperator = operatorIndex + 2;

        switch(child.getText()) {
            case "+":
                node = new AddNode();
                break;
            case "-":
                node = new SubNode();
                break;
            case "*":
                node = new MultNode();
                break;
            case "/":
                node = new DivNode();
                break;
            case "%":
                node = new ModNode();
                break;
            default:
                return null;
        }

        if(parent.getChild(nextOperator) != null) {
            node.children.add(visitTerm(parent.term(termIndex)));
            node.children.add(visitExprChildren(parent, parent.getChild(nextOperator), nextOperator));

        }
        else {
            node.children.add(visitTerm(parent.term(termIndex)));
            node.children.add(visitTerm(parent.term(termIndex + 1)));
        }

        return node;
    }

    @Override
    public AstNode visitTerm(GEasyParser.TermContext ctx){
        if(ctx.val_expr() != null) {
            return visit(ctx.val_expr());
        }
        else if(ctx.expr() != null) {
            return visit(ctx.expr());
        }

        return null;
    }

    @Override
    public AstNode visitVal_expr(GEasyParser.Val_exprContext ctx) {
        if(ctx.val() != null) {
            return visit(ctx.val());
        }
        else if(ctx.array_access() != null) {
            return visit(ctx.array_access());
        }
        else if(ctx.func_call() != null) {
            return visit(ctx.func_call());
        }

        return null;
    }

    @Override
    public AstNode visitFunc_call(GEasyParser.Func_callContext ctx) {
        boolean isNegative = false;

        if(ctx.getParent().getChild(0).getText().equals("-")) {
            isNegative = true;
        }

        FuncCallNode funcCallNode = new FuncCallNode(ctx.ID().toString(), isNegative);

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
        ActualParamNode actualParamNode;

        if(ctx.XCOORD() != null) {
            actualParamNode = new ActualParamNode(ctx.XCOORD().toString());
        }
        else if(ctx.YCOORD() != null) {
            actualParamNode = new ActualParamNode(ctx.YCOORD().toString());
        }
        else if (ctx.ID() != null) {
            actualParamNode = new ActualParamNode(ctx.ID().toString());
        }
        else {
            return null;
        }


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
    public AstNode visitFunc_dcl(GEasyParser.Func_dclContext ctx) {
        String ID = ctx.ID().toString();

        FuncDclNode funcDclNode;

        if(ctx.TYPE() != null) {
            funcDclNode = new FuncDclNode(ID, ctx.TYPE().toString());
        }
        else if(ctx.VOID() != null) {
            funcDclNode = new FuncDclNode(ID, ctx.VOID().toString());
        }
        else if(ctx.BOOL_T() != null) {
            funcDclNode = new FuncDclNode(ID, ctx.BOOL_T().toString());
        } else {
            return null;
        }

        // Visit children
        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if((child instanceof GEasyParser.ValContext) || (child instanceof GEasyParser.BlockContext) || (child instanceof  GEasyParser.Formal_paramContext) ) {
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
            BoolNode boolNode = new BoolNode(Boolean.parseBoolean(ctx.BOOL().toString()), "bool");
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
        boolean isNeg = false;

        ParseTree parent = ctx.getParent();
        if(parent.getChild(0).getText().equals("-")) {
            isNeg = true;
        }

        if(ctx.NUMBER() != null) {
            // Check if double
            if(ctx.NUMBER().getText().contains(".")) {
                return new DoubleNode(Double.parseDouble(ctx.getText()), isNeg);
            } else {
                // If not a double, it is an int
                return new IntNode(Integer.parseInt(ctx.getText()), isNeg);
            }
        } else if (ctx.ID() != null){
            return new IDNode(ctx.getText(), isNeg);
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
