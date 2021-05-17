package com.p4.core.visitors;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyParser;
import com.p4.core.nodes.*;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.net.IDN;

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
        for (ParseTree child : children) {

            // Skip leaves/terminals
            if (child.getPayload() instanceof CommonToken) {
                continue;
            }

            node.children.add(visit(child));
        }

        return node;
    }

    // We won't add dcl as a node in our Ast, as it contains only non-terminals
    // Basically, it will only clutter the Ast with an unnecessary node
    @Override
    public AstNode visitDcl(GEasyParser.DclContext ctx) {
        return visit(ctx.children.get(0));
    }

    @Override
    public AstNode visitVar_dcl(GEasyParser.Var_dclContext ctx) {
        return visit(ctx.children.get(0));
    }

    @Override
    public AstNode visitNum_dcl(GEasyParser.Num_dclContext ctx) {
        String type = ctx.TYPE().toString();
        String ID = ctx.ID().toString();

        GEasyParser.ExprContext expr = ctx.expr();
        GEasyParser.Pos_assignContext pos_assign = ctx.pos_assign();

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
            case "pos":
                dclNode = new PosDclNode(ID);
                dclNode.setType("pos");
                break;
            default:
                return null;
        }

        // Add line number
        dclNode.lineNumber = ctx.start.getLine();

        // Find out if we assign it to an expression or pos
        if (expr != null) {
            dclNode.children.add(visit(ctx.expr()));
            return dclNode;
        } else if (pos_assign != null) {
            // Add the two coordinates as children
            dclNode.children.add(visit(ctx.pos_assign().expr(0)));
            dclNode.children.add(visit(ctx.pos_assign().expr(1)));
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
        arrayDclNode.lineNumber = ctx.start.getLine();

        int childCount = ctx.getChildCount();

        for (int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if (child instanceof GEasyParser.ExprContext) {
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
        boolDclNode.lineNumber = ctx.start.getLine();

        GEasyParser.Logical_exprContext logicalExpr = ctx.logical_expr();

        if (logicalExpr != null) {
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
        if (array_access != null) {
            AstNode arrayAccessNode = visitArray_access(array_access);
            AssignNode assignNode = new AssignNode(arrayAccessNode.getID());
            assignNode.setType("array");
            if (expr != null) {
                assignNode.children.add(visitExpr(expr));
            } else {
                assignNode.children.add(visitPos_assign(pos_assign));
            }

            assignNode.lineNumber = ctx.start.getLine();

            return assignNode;
        } else if (expr != null) {
            String id = ctx.ID().toString();
            AssignNode assignNode = new AssignNode(id);
            assignNode.setType("expr");

            assignNode.children.add(visitExpr(expr));
            assignNode.lineNumber = ctx.start.getLine();

            return assignNode;
        } else if (pos_assign != null) {
            String id = ctx.ID().toString();
            AssignNode assignNode = new AssignNode(id);
            assignNode.setType("pos");

            AstNode xCordNode = visit(pos_assign.expr(0));
            AstNode yCordNode = visit(pos_assign.expr(1));

            assignNode.children.add(xCordNode);
            assignNode.children.add(yCordNode);
            assignNode.lineNumber = ctx.start.getLine();

            return assignNode;
        } else {
            // error...
            return null;
        }
    }

    @Override
    public AstNode visitPos_assign(GEasyParser.Pos_assignContext ctx) {
        AstNode xCordVal = visit(ctx.expr(0));
        AstNode yCordVal = visit(ctx.expr(1));

        PosAssignNode posAssignNode = new PosAssignNode();
        posAssignNode.setType("pos");

        posAssignNode.children.add(xCordVal);
        posAssignNode.children.add(yCordVal);

        posAssignNode.lineNumber = ctx.start.getLine();

        return posAssignNode;
    }

    @Override
    public AstNode visitArray_access(GEasyParser.Array_accessContext ctx) {
        boolean isNegative = false;

        if (ctx.getParent().getChild(0).getText().equals("-")) {
            isNegative = true;
        }

        ArrayAccessNode arrayAccessNode = new ArrayAccessNode(ctx.ID().toString(), isNegative);
        arrayAccessNode.lineNumber = ctx.start.getLine();

        arrayAccessNode.children.add(visit(ctx.expr()));

        return arrayAccessNode;
    }

    @Override
    public AstNode visitLogical_expr(GEasyParser.Logical_exprContext ctx) {
        // only one child
        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        } else {
            return visitLogicalExprChildren(ctx, ctx.getChild(1), 1);
        }
    }

    private AstNode visitLogicalExprChildren(GEasyParser.Logical_exprContext parent, ParseTree child, int operatorIndex) {
        LogicalExprNode node = new LogicalExprNode();
        node.lineNumber = parent.start.getLine();

        int nextOperator = operatorIndex + 2;

        switch (child.getText()) {
            case "&&":
                node.setToken(GEasyParser.AND);
                break;
            case "||":
                node.setToken(GEasyParser.OR);
                break;
            default:
                return null;
        }

        if (parent.getChild(nextOperator) != null) {
            node.children.add(visit(parent.getChild(operatorIndex - 1)));
            node.children.add(visitLogicalExprChildren(parent, parent.getChild(nextOperator), nextOperator));

        } else {
            node.children.add(visit(parent.getChild(operatorIndex - 1)));
            node.children.add(visit(parent.getChild(operatorIndex + 1)));
        }

        return node;
    }

    @Override
    public AstNode visitComp_expr(GEasyParser.Comp_exprContext ctx) {

        // If there is only one child
        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }

        CompExprNode compExprNode = new CompExprNode();
        compExprNode.lineNumber = ctx.start.getLine();

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
        // only one term_expr
        if (ctx.getChildCount() == 1) {
            return visit(ctx.term_expr(0));
        } else {
            // Multiple term_exprs
            return visitExprChildren(ctx, ctx.getChild(1), 1);

        }
    }

    private AstNode visitExprChildren(GEasyParser.ExprContext parent, ParseTree child, int operatorIndex) {
        AstNode node;

        int termIndex = (operatorIndex - 1) / 2;
        int nextOperator = operatorIndex + 2;

        switch (child.getText()) {
            case "+":
                node = new AddNode();
                break;
            case "-":
                node = new SubNode();
                break;
            default:
                return null;
        }

        // If there are more than one operator
        // Uses recursion
        if (parent.getChild(nextOperator) != null) {
            node.children.add(visitTerm_expr(parent.term_expr(termIndex)));
            node.children.add(visitExprChildren(parent, parent.getChild(nextOperator), nextOperator));

        }
        // Only one child left
        else {
            node.children.add(visitTerm_expr(parent.term_expr(termIndex)));
            node.children.add(visitTerm_expr(parent.term_expr(termIndex + 1)));
        }

        node.lineNumber = parent.start.getLine();

        return node;
    }

    @Override
    public AstNode visitTerm_expr(GEasyParser.Term_exprContext ctx) {
        // If there is only one child
        if (ctx.getChildCount() == 1) {
            return visit(ctx.getChild(0));
        }
        // Multiple terms
        else {
            return visitTermExprChildren(ctx, ctx.getChild(1), 1);
        }
    }

    private AstNode visitTermExprChildren(GEasyParser.Term_exprContext parent, ParseTree child, int operatorIndex) {
        int termIndex = (operatorIndex - 1) / 2;
        int nextOperator = operatorIndex + 2;
        AstNode node;

        switch (child.getText()) {
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

        node.lineNumber = parent.start.getLine();

        // If there are more than one operator in the expression
        if (parent.getChild(nextOperator) != null) {
            node.children.add(visit(parent.term(termIndex)));
            node.children.add(visitTermExprChildren(parent, parent.getChild(nextOperator), nextOperator));
        }
        // If there is only one operator left
        else {
            node.children.add(visit(parent.term(termIndex)));
            node.children.add(visit(parent.term(termIndex + 1)));
        }

        return node;
    }

    @Override
    public AstNode visitTerm(GEasyParser.TermContext ctx) {
        // We need to know if the term has parenthesis
        ParseTree child = ctx.getChild(0);

        if (child instanceof GEasyParser.Val_exprContext) {
            return visit(ctx.val_expr());
        } else if (child instanceof TerminalNodeImpl) {
            if (child.getText().equals("(")) {
                AstNode node = visit(ctx.logical_expr());
                node.lineNumber = ctx.start.getLine();
                return addParen(node);
            }

        }
        return null;
    }

    private AstNode addParen(AstNode node) {
        String nodeClass = node.getClass().getSimpleName();

        switch (nodeClass) {
            case "AddNode":
                AddNode addNode = (AddNode) node;
                addNode.setParentheses(true);
                return addNode;
            case "MultNode":
                MultNode multNode = (MultNode) node;
                multNode.setParentheses(true);
                return multNode;
            case "DivNode":
                DivNode divNode = (DivNode) node;
                divNode.setParentheses(true);
                return divNode;
            case "SubNode":
                SubNode subNode = (SubNode) node;
                subNode.setParentheses(true);
                return subNode;
            case "IntNode":
                IntNode intNode = (IntNode) node;
                intNode.setParentheses(true);
                return intNode;
            case "DoublNode":
                DoubleNode doubleNode = (DoubleNode) node;
                doubleNode.setParentheses(true);
                return doubleNode;
            default:
                return node;
        }
    }

    @Override
    public AstNode visitVal_expr(GEasyParser.Val_exprContext ctx) {
        if (ctx.val() != null) {
            return visit(ctx.val());
        } else if (ctx.array_access() != null) {
            return visit(ctx.array_access());
        } else if (ctx.func_call() != null) {
            return visit(ctx.func_call());
        }

        return null;
    }

    @Override
    public AstNode visitFunc_call(GEasyParser.Func_callContext ctx) {
        boolean isNegative = false;

        if (ctx.getParent().getChild(0).getText().equals("-")) {
            isNegative = true;
        }

        FuncCallNode funcCallNode = new FuncCallNode(ctx.ID().toString(), isNegative);
        funcCallNode.lineNumber = ctx.start.getLine();

        int childCount = ctx.getChildCount();

        // We go through all the children and add those we need for our Ast
        // In our case it's the non-terminal expr, and ...
        for (int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if (child instanceof GEasyParser.Actual_paramContext) {
                AstNode childNode = visit(child);
                funcCallNode.children.add(childNode);
            }
        }

        return funcCallNode;
    }

    @Override
    public AstNode visitActual_param(GEasyParser.Actual_paramContext ctx) {
        ActualParamNode actualParamNode;

        if (ctx.ID() != null) {
            actualParamNode = new ActualParamNode(ctx.ID().toString());
        } else if (ctx.TYPE() != null) {
            actualParamNode = new ActualParamNode(ctx.TYPE().toString());
        } else {
            return null;
        }

        actualParamNode.children.add(visit(ctx.expr()));
        actualParamNode.setType(actualParamNode.children.get(0).getType());

        actualParamNode.lineNumber = ctx.start.getLine();

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
        if (assign != null) {
            return visit(assign);
        } else if (expr != null) {
            return visit(expr);
        } else if (func_call != null) {
            return visit(func_call);
        } else if (selection != null) {
            return visit(selection);

        } else if (iterative != null) {
            return visit(iterative);

        } else if (comment != null) {
            return visit(comment);
        }

        // error
        return null;
    }

    @Override
    public AstNode visitSelection(GEasyParser.SelectionContext ctx) {
        SelectionNode selectionNode;

        if (ctx.ELSE() != null) {
            selectionNode = new SelectionNode(ctx.IF().toString(), true);
        } else {
            selectionNode = new SelectionNode(ctx.IF().toString(), false);
        }

        // Visit the condition
        // How do we handle the case of a bool here??
        // Maybe it's possible to make BOOL a part of logical_expr? (I moved it)
        selectionNode.children.add(visit(ctx.logical_expr()));

        // Visit the block, if there is an else present, it visits both blocks
        for (GEasyParser.BlockContext block : ctx.block()) {
            selectionNode.children.add(visitBlock(block));
        }

        selectionNode.lineNumber = ctx.start.getLine();

        return selectionNode;
    }

    @Override
    public AstNode visitIterative(GEasyParser.IterativeContext ctx) {
        String type = ctx.FOR().toString();
        String for_to = ctx.TO().toString();

        IterativeNode iterativeNode = new IterativeNode(type, for_to);
        iterativeNode.lineNumber = ctx.start.getLine();

        // Visit children
        int childCount = ctx.getChildCount();

        for (int childIndex = 0; childIndex < childCount; childIndex++) {
            ParseTree child = ctx.getChild(childIndex);

            if ((child instanceof GEasyParser.ValContext) || (child instanceof GEasyParser.BlockContext)) {
                AstNode childNode = visit(child);
                iterativeNode.children.add(childNode);
            }
        }

        AstNode childVal1 = iterativeNode.children.get(0);
        AstNode childVal2 = iterativeNode.children.get(1);

        if (ctx.MINUS().size() == 2) {
            if(childVal1 instanceof IntNode) {
                IntNode val1 = (IntNode) childVal1;
                val1.isNegative = true;
            }
            else if (childVal1 instanceof DoubleNode) {
                DoubleNode val1 = (DoubleNode) childVal1;
                val1.isNegative = true;
            }
            else if (childVal1 instanceof IDNode) {
                IDNode val1 = (IDNode) childVal1;
                val1.isNegative = true;
            }

            if (childVal2 instanceof IntNode) {
                IntNode val2 = (IntNode) childVal2;
                val2.isNegative = true;
            }
            else if (childVal2 instanceof DoubleNode) {
                DoubleNode val2 = (DoubleNode) childVal2;
                val2.isNegative = true;
            }
            else if (childVal2 instanceof IDNode) {
                IDNode val2 = (IDNode) childVal2;
                val2.isNegative = true;
            }
        }
        else if(ctx.MINUS().size() == 1) {
            if(ctx.children.get(2) instanceof TerminalNodeImpl) {
                if(childVal1 instanceof IntNode) {
                    IntNode val1 = (IntNode)childVal1;
                    val1.isNegative = true;
                }
                else if(childVal1 instanceof DoubleNode) {
                    DoubleNode val1 = (DoubleNode)childVal1;
                    val1.isNegative = true;
                }
                else if (childVal1 instanceof IDNode) {
                    IDNode val1 = (IDNode)childVal1;
                    val1.isNegative = true;
                }
            } else {
                if (childVal2 instanceof IntNode) {
                    IntNode val2 = (IntNode) childVal2;
                    val2.isNegative = true;
                }
                else if (childVal2 instanceof DoubleNode) {
                    DoubleNode val2 = (DoubleNode) childVal2;
                    val2.isNegative = true;
                }
                else if (childVal2 instanceof IDNode) {
                    IDNode val2 = (IDNode) childVal2;
                    val2.isNegative = true;
                }
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

        funcDclNode.lineNumber = ctx.start.getLine();

        return funcDclNode;
    }

    @Override
    public AstNode visitFormal_param(GEasyParser.Formal_paramContext ctx) {
        FormalParamNode formalParamNode = new FormalParamNode();

        IDNode idNode;

        switch (ctx.TYPE().toString()) {
            case "int":
                idNode = new IDNode(ctx.ID().toString(), "int");
                break;
            case "double":
                idNode = new IDNode(ctx.ID().toString(), "double");
                break;
            case "pos":
                idNode = new IDNode(ctx.ID().toString(), "pos");
                break;
            default:
                idNode = null;
                break;
        }

        if(idNode != null) {
            formalParamNode.children.add(idNode);
        }

        formalParamNode.setID(ctx.ID().toString());
        formalParamNode.setType(formalParamNode.children.get(0).getType());

        formalParamNode.lineNumber = ctx.start.getLine();
        return formalParamNode;
    }

    @Override
    public AstNode visitBlock(GEasyParser.BlockContext ctx) {
        BlockNode blockNode = new BlockNode();
        blockNode.lineNumber = ctx.start.getLine();

        // Since a block can contain a lot of different constructs,
        // we use the visitChildren() function
        return visitChildren(blockNode, ctx.children.toArray(ParseTree[]::new));
    }

    @Override
    public AstNode visitReturn_expr(GEasyParser.Return_exprContext ctx) {
        ReturnExprNode returnExprNode = new ReturnExprNode();
        returnExprNode.lineNumber = ctx.start.getLine();

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
                DoubleNode doubleNode = new DoubleNode(Double.parseDouble(ctx.getText()), isNeg);
                doubleNode.setType("double");
                doubleNode.lineNumber = ctx.start.getLine();
                return doubleNode;
            }
            else {
                // If not a double, it is an int
                IntNode intNode = new IntNode(Integer.parseInt(ctx.getText()), isNeg);
                intNode.setType("int");
                intNode.lineNumber = ctx.start.getLine();
                return intNode;
            }
        }
        else if (ctx.ID() != null){
            IDNode idNode = new IDNode(ctx.getText(), isNeg);
            idNode.lineNumber = ctx.start.getLine();
            return idNode;
        }
        else if (ctx.BOOL() != null) {
            BoolNode boolNode = new BoolNode(Boolean.parseBoolean(ctx.getText()), "bool");
            boolNode.setType("bool");
            boolNode.lineNumber = ctx.start.getLine();
            return boolNode;
        }

        return null;
    }

    // Is this needed, as the parser ignores comments ...?
    @Override
    public AstNode visitComment(GEasyParser.CommentContext ctx) {
        String lineComment = ctx.LINE_COMMENT().toString();

        if(lineComment != null) {
            LineCommentNode commentNode = new LineCommentNode(lineComment);
            commentNode.lineNumber = ctx.start.getLine();
            return commentNode;
        }
        // error
        return null;
    }

}
