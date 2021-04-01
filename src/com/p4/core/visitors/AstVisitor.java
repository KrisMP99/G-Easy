package com.p4.core.visitors;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyParser;
import com.p4.core.nodes.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;

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
        GEasyParser.Array_assignContext array_assign = ctx.array_assign();

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
        }
        else if(array_assign != null){
            AstNode arrayAssignNode = visit(ctx.array_assign());
            varDclNode.children.add(arrayAssignNode);
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
        AstNode posDclNode = new PosDclNode(id);

        // Add children (pos assign)
        posDclNode.children.add(visit(ctx.pos_assign()));

        return posDclNode;

    }

    @Override
    public AstNode visitArray_dcl(GEasyParser.Array_dclContext ctx) {
        return super.visitArray_dcl(ctx);
    }

    @Override
    public AstNode visitAssign(GEasyParser.AssignContext ctx) {
        return super.visitAssign(ctx);
    }

    @Override
    public AstNode visitPos_assign(GEasyParser.Pos_assignContext ctx) {
        AstNode posAssignNode = new PosAssignNode();
        posAssignNode.children.add(visitVal(ctx.val(0)));
        posAssignNode.children.add(visitVal(ctx.val(1)));

        return posAssignNode;

    }

    @Override
    public AstNode visitArray_assign(GEasyParser.Array_assignContext ctx) {
        return super.visitArray_assign(ctx);
    }

    @Override
    public AstNode visitExpr(GEasyParser.ExprContext ctx) {
        ExprNode exprNode = new ExprNode();
        int childCount = ctx.getChildCount();

        for(int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if((child instanceof GEasyParser.ExprContext) || (child instanceof GEasyParser.ValContext))  {
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
        return super.visitStmt(ctx);
    }

    @Override
    public AstNode visitSelection(GEasyParser.SelectionContext ctx) {
        return super.visitSelection(ctx);
    }

    @Override
    public AstNode visitIterative(GEasyParser.IterativeContext ctx) {
        return super.visitIterative(ctx);
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
        return super.visitBlock(ctx);
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
