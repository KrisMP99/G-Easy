package com.p4.core.visitors;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyParser;
import com.p4.core.datatypes.Pos;
import com.p4.core.nodes.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

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

        if(expr != null) {
            return visit(expr);
        }
        else if(func_call != null) {
            return visit(func_call);
        }
        else {
            return visit(array_assign);
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
    public AstNode visitPos_assign(GEasyParser.Pos_assignContext ctx) {
        AstNode posAssignNode = new PosAssignNode();
        posAssignNode.children.add(visitVal(ctx.val(0)));
        posAssignNode.children.add(visitVal(ctx.val(1)));

        return posAssignNode;

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
