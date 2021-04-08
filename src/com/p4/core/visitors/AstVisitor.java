package com.p4.core.visitors;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyParser;
import com.p4.core.nodes.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

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

        if(num_dcl != null) {
            return visit(num_dcl);

        } else if(pos_dcl != null) {
            return visit(pos_dcl);

        } else if(array_dcl != null) {
            return visit(array_dcl);
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

    // Consider adding this to var_dcl somehow
    @Override
    public AstNode visitPos_dcl(GEasyParser.Pos_dclContext ctx) {
        String id = ctx.ID().toString();
        String type = ctx.POS().toString();

        AstNode posDclNode = new PosDclNode(id, type);

        // Add children (pos assign)
        posDclNode.children.add(visit(ctx.pos_assign()));

        return posDclNode;

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
    public AstNode visitAssign(GEasyParser.AssignContext ctx) {
        String id = ctx.ID().toString();
        AssignNode assignNode = new AssignNode(id);

        // A assign node can consist of either an expression, func_call or pos_assign
        GEasyParser.ExprContext expr = ctx.expr();
        GEasyParser.Func_callContext func_call = ctx.func_call();
        GEasyParser.Pos_assignContext pos_assign = ctx.pos_assign();

        // Find out which one
        if(expr != null){
            AstNode exprNode = visitExpr(ctx.expr());
            assignNode.children.add(exprNode);
            return assignNode;
        }
        else if (func_call != null) {
            AstNode funcCallNode = visitFunc_call(ctx.func_call());
            assignNode.children.add(funcCallNode);
            return assignNode;
        }
        else if (pos_assign != null) {
            AstNode posAssignNode = visitPos_assign(ctx.pos_assign());
            assignNode.children.add(posAssignNode);
            return assignNode;
        } else {
            // error...
            return null;
        }
    }

    @Override
    public AstNode visitPos_assign(GEasyParser.Pos_assignContext ctx) {
        PosAssignNode posAssignNode = new PosAssignNode();

        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if(child instanceof GEasyParser.ValContext) {
                AstNode childNode = visit(child);
                posAssignNode.children.add(childNode);
            }
        }

        return posAssignNode;
    }

    @Override
    public AstNode visitArray_access(GEasyParser.Array_accessContext ctx) {
        ArrayAccessNode arrayAccessNode = new ArrayAccessNode(ctx.ID().toString());

        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childCount++) {
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
                    AstNode arithmNode = getArithmeticOPNode(nextChild);

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
    public AstNode getArithmeticOPNode(ParseTree child) {
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

            if((child instanceof GEasyParser.ValContext) || (child instanceof GEasyParser.ExprContext)) {
                AstNode childNode = visit(child);
                funcCallNode.children.add(childNode);
            }
        }

        return funcCallNode;
    }

    @Override
    public AstNode visitStmt(GEasyParser.StmtContext ctx) {
        // Er lidt i tvivl her, siden stmt kun har 1 barn, så burde den vel ikke laves i en AST
        // Skips this node and goes directly to the next child
        return visit(ctx.getChild(0));

        /*StmtNode stmtNode = new StmtNode();

        // A stmtNode can be an assign, expr, func_call, selection, iterative or LINE_COMMENT
        GEasyParser.AssignContext assign = ctx.assign();
        GEasyParser.ExprContext expr = ctx.expr();
        GEasyParser.Func_callContext func_call = ctx.func_call();
        GEasyParser.SelectionContext selection = ctx.selection();
        GEasyParser.IterativeContext iterative = ctx.iterative();
        TerminalNode lineComment = ctx.LINE_COMMENT();

        // Find out which one
        if(assign != null){
            AstNode assignNode = visitAssign(ctx.assign());
            stmtNode.children.add(assignNode);
            return stmtNode;
        }
        else if(expr != null) {
            AstNode exprNode = visitExpr(ctx.expr());
            stmtNode.children.add(exprNode);
            return stmtNode;
        }
        else if (func_call != null) {
            AstNode funcCallNode = visitFunc_call(ctx.func_call());
            stmtNode.children.add(funcCallNode);
            return stmtNode;
        }
        else if (selection != null) {
            AstNode selectionNode = visitSelection(ctx.selection());
            stmtNode.children.add(selectionNode);
            return stmtNode;
        } else if(iterative != null){
            AstNode iterativeNode = visitIterative(ctx.iterative());
            stmtNode.children.add(iterativeNode);
            return stmtNode;
        } else if(lineComment != null) {
            ...
        }*/

    }

    @Override
    public AstNode visitSelection(GEasyParser.SelectionContext ctx) {
        SelectionNode selectionNode = new SelectionNode();

        // Visit the condition
        // How do we handle the case of a bool here??
        selectionNode.children.add(visit(ctx.logical_expr()));

        // Visit the block, if there is an else present, it visits both blocks
        for(GEasyParser.BlockContext blck : ctx.block()) {
            selectionNode.children.add(visitBlock(blck));
        }

        return selectionNode;
    }

    @Override
    public AstNode visitIterative(GEasyParser.IterativeContext ctx) {
        IterativeNode iterativeNode = new IterativeNode();

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

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if((child instanceof GEasyParser.Logical_exprContext) || (child instanceof GEasyParser.ExprContext)) {
                AstNode childNode = visit(child);
                logicalExprNode.children.add(childNode);
            }
        }

        return logicalExprNode;
    }

    @Override
    public AstNode visitFunc_dcl(GEasyParser.Func_dclContext ctx) {
        String id = ctx.ID().toString();
        String type_t = ctx.TYPE().toString();
        String void_t = ctx.VOID().toString();
        String bool_t = ctx.BOOL_T().toString();

        FuncNode funcNode;

        if(type_t != null) {
            funcNode = new FuncNode(id, type_t);
        }
        else if(void_t != null) {
            funcNode = new FuncNode(id, void_t);
        }
        else if(bool_t != null) {
            funcNode = new FuncNode(id, bool_t);
        } else {
            return null;
        }

        if(ctx.getChildCount() > 1) {
            funcNode.children.add(visit(ctx.getChild(0)));
            funcNode.children.add(visit(ctx.getChild(1)));
        } else {
            funcNode.children.add(visit(ctx.getChild(0)));
        }

        return funcNode;
    }

    @Override
    public AstNode visitFormal_param(GEasyParser.Formal_paramContext ctx) {
        ParamNode paramNode = new ParamNode();

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
                paramNode.children.add(idNode);
            }

        }

        return paramNode;
    }

    @Override
    public AstNode visitBlock(GEasyParser.BlockContext ctx) {
        BlockNode blockNode = new BlockNode();

        // Since a block can contain a lot of different constructs,
        // we use the visitChildren() function
        return visitChildren(blockNode, ctx.children.toArray(ParseTree[]::new));
    }

    // Revisit later
    public AstNode handleBlk(GEasyParser.BlockContext ctx, String id) {
        BlockNode blockNode = (BlockNode) visit(ctx);
        blockNode.setParentID(id);
        return blockNode;
    }

    @Override
    public AstNode visitReturn_expr(GEasyParser.Return_exprContext ctx) {
        ReturnExprNode returnExprNode = new ReturnExprNode();

        AstNode exprNode = visit(ctx.expr());

        if(exprNode != null) {
            returnExprNode.children.add(exprNode);
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

}
