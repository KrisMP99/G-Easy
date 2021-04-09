package com.p4.core.visitors;

import com.p4.core.nodes.*;

// Used to visit our Ast and print it to the console
public class AstTreeVisitor {
    public void visit(int localIndent, AstNode node) {
        if(node != null) {
            switch (node.getClass().toString()) {
                case "class com.p4.core.nodes.IntDclNode":
                    this.print(localIndent,"(IntDcl) " + ((VarDclNode)node).getType() + " " + ((VarDclNode)node).getID());
                    break;
                case "class com.p4.core.nodes.DoubleDclNode":
                    this.print(localIndent,"(DoubleDcl) " + ((VarDclNode)node).getType() + " " + ((VarDclNode)node).getID());
                    break;
                case "class com.p4.core.nodes.PosDclNode":
                    this.print(localIndent,"(PosDcl) " + ((VarDclNode)node).getType() + " " + ((VarDclNode)node).getID());
                    break;
                case "class com.p4.core.nodes.ExprNode":
                    this.print(localIndent, "(Expr) ");
                    break;
                case "class com.p4.core.nodes.ArithmeticNode":
                    this.print(localIndent, "(Arthm) " + ((ArithmeticNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.DoubleNode":
                    this.print(localIndent, "(Double) " + ((DoubleNode)node).value);
                    break;
                case "class com.p4.core.nodes.IntNode":
                    this.print(localIndent, "(Int) " + ((IntNode)node).value);
                    break;
                case "class com.p4.core.nodes.ArrayDclNode":
                    this.print(localIndent, "(ArrayDcl) " + ((ArrayDclNode)node).getType() + " " + ((ArrayDclNode)node).getID());
                    break;
                case "class com.p4.core.nodes.ArrayAccessNode":
                    this.print(localIndent, "(ArrayAccess) " + ((ArrayAccessNode)node).ID);
                    break;
                case "class com.p4.core.nodes.FuncCallNode":
                    this.print(localIndent, "(FunCall) " + ((FuncCallNode)node).getID());
                    break;
                case "class com.p4.core.nodes.ActualParamNode":
                    this.print(localIndent, "(ActualParm) " + ((ActualParamNode)node).getID());
                    break;
                case "class com.p4.core.nodes.LineCommentNode":
                    this.print(localIndent, "(LineComment) " + ((LineCommentNode)node).getComment());
                    break;
                case "class com.p4.core.nodes.PosAssignNode":
                    this.print(localIndent, "(PosAssign) ");
                    break;
                case "class com.p4.core.nodes.PosNode":
                    this.print(localIndent, "(Pos) x: " + ((PosNode)node).p1.getX() + " y: " + ((PosNode)node).p1.getY());
                    break;
                case "class com.p4.core.nodes.SelectionNode":
                    String isElse = ((SelectionNode)node).isElse() ? " else " : "";
                    this.print(localIndent, "(Selection) " + ((SelectionNode)node).getType() + isElse);
                    break;
                case "class com.p4.core.nodes.LogicalExprNode":
                    this.print(localIndent, "(LogicalExpr)");
                    break;
                case "class com.p4.core.nodes.LogicalNode":
                    this.print(localIndent, "(Logical) " + ((LogicalNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.CompNode":
                    this.print(localIndent, "(Comp) " + ((CompNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.IDNode":
                    this.print(localIndent, "(ID) " + ((IDNode)node).id);
                    break;
                case "class com.p4.core.nodes.AssignNode":
                    this.print(localIndent, "(Assign) " + ((AssignNode)node).getID());
                    break;
                case "class com.p4.core.nodes.BlockNode":
                    this.print(localIndent, "(Block)");
                    break;
                case "class com.p4.core.nodes.IterativeNode":
                    this.print(localIndent, "(Iterative) " + ((IterativeNode)node).getType() + " " + ((IterativeNode)node).getFor_to());
                    break;
                case "class com.p4.core.nodes.FuncDclNode":
                    this.print(localIndent, "(FuncDcl) " + ((FuncDclNode)node).getType() + " " + ((FuncDclNode)node).getID());
                    break;
                case "class com.p4.core.nodes.ReturnExprNode":
                    this.print(localIndent, "(ReturnExpr)");
                    break;
                case "class com.p4.core.nodes.BoolNode":
                    this.print(localIndent, "(Bool) " + ((BoolNode)node).getType());
                    break;
                case "class com.p4.core.nodes.ProgNode":
                    this.print(localIndent, "(prog)");
            }

            for(AstNode childNode : node.getChildren()) {
                this.visit(localIndent + 1, childNode);
            }
        }
    }

    private void print(int indent, String string) {
        StringBuilder output = new StringBuilder();
        output.append("\t".repeat(Math.max(0, indent)));

        if(string != null) {
            output = new StringBuilder(output.toString().concat(string));
        } else {
            output = new StringBuilder(output.toString().concat("null"));
        }

        System.out.println(output);
    }
}
