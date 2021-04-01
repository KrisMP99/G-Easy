package com.p4.core.visitors;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyParser;
import com.p4.core.nodes.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AstVisitor<T> extends GEasyBaseVisitor<AstNode> {
    @Override
    public AstNode visitProg(GEasyParser.ProgContext ctx) {
        ProgNode progNode = new ProgNode();

        return visitChildren(progNode, ctx.children.toArray(ParseTree[]::new));
    }

    private AstNode visitChildren(AstNode node, ParseTree[] children) {
        // Iterates through all the node's children
        for(ParseTree child : children) {
            // Skip leaves/terminals, as they have no children
            if(child.getPayload() instanceof CommonToken) {
                continue;
            }
            node.children.add(visit(child));
        }

        return node;
    }

    @Override
    public AstNode visitDcl(GEasyParser.DclContext ctx) {
        GEasyParser.AssignContext assign = ctx.assign();
        GEasyParser.Array_dclContext array_dcl = ctx.array_dcl();
        GEasyParser.Pos_dclContext pos_dcl = ctx.pos_dcl();
        GEasyParser.Var_dclContext var_dcl = ctx.var_dcl();

        // find which type of dcl
        if(assign != null) {
            return visit(assign);
        }
        else if(array_dcl != null) {
            return visit(array_dcl);
        }
        else if(pos_dcl != null) {
            return visit(pos_dcl);
        }
        else { return visit(var_dcl); }
    }

    @Override
    public AstNode visitVar_dcl(GEasyParser.Var_dclContext ctx) {
        GEasyParser.ExprContext expr = ctx.expr();
        GEasyParser.Func_callContext func_call = ctx.func_call();

        VarDclNode varDclNode = new VarDclNode(ctx.ID().toString());
        varDclNode.setType(ctx.TYPE().toString());

        if(expr != null) {
            AstNode exprNode = visit(ctx.expr());
            varDclNode.children.add(exprNode);
            return varDclNode;
        }
        else if(func_call != null) {
            AstNode funcCallNode = visit(ctx.func_call());
            varDclNode.children.add(funcCallNode);
            return varDclNode;
        } else {
            /*AstNode dclNode;

            switch (ctx.TYPE().toString()){
                case "int":
                    dclNode = new IntDclNode(ctx.ID().toString());
                    break;
                case "double":
                    dclNode = new DoubleDclNode(ctx.ID().toString());
                    break;
                default:*/
                    return null;
            }
    }

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

            if(child instanceof TerminalNode){
                if(child == ctx.NUMBER()){
                    AstNode numChild = visit(child);
                    arrayAccessNode.children.add(numChild);
                }
            } else if(child instanceof GEasyParser.ExprContext){
                AstNode exprNode = visit(child);
                arrayAccessNode.children.add(exprNode);
            }
        }
        return arrayAccessNode;
    }

    @Override
    public AstNode visitExpr(GEasyParser.ExprContext ctx) {
        ExprNode exprNode = new ExprNode();
        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if((child instanceof GEasyParser.ExprContext) || (child instanceof GEasyParser.ValContext) || (child instanceof GEasyParser.Array_accessContext))  {
                AstNode childNode = visit(child);
                exprNode.children.add(childNode);
            }
        }

        return exprNode;
    }

    @Override
    public AstNode visitFunc_call(GEasyParser.Func_callContext ctx) {
        FuncCallNode funcCallNode = new FuncCallNode(ctx.ID().toString());

        int childCount = ctx.getChildCount();

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
        // Er lidt i tvivl her, siden stmt kun har 1 barn, så burde den vil ikke laves i en AST
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
        return super.visitLogical_expr(ctx);
    }

    @Override
    public AstNode visitFunc(GEasyParser.FuncContext ctx) {
        return super.visitFunc(ctx);
    }

    @Override
    public AstNode visitParam(GEasyParser.ParamContext ctx) {
        return super.visitParam(ctx);
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
        return super.visitReturn_expr(ctx);
    }

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
