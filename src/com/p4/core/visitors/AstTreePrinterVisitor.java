package com.p4.core.visitors;

import com.p4.core.nodes.*;

// Used to visit our Ast and print it to the console
public class AstTreePrinterVisitor {
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
                    this.print(localIndent, "(ArrayAccess) " + ((ArrayAccessNode)node).getID());
                    break;
                case "class com.p4.core.nodes.FuncCallNode":
                    this.print(localIndent, "(FuncCall) " + ((FuncCallNode)node).getID());
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
                    this.print(localIndent, "(Pos) " + ((PosNode)node).getxID() + ": " + ((PosNode)node).p1.getX() + " " + ((PosNode)node).getyID() + ": " + ((PosNode)node).p1.getY());
                    break;
                case "class com.p4.core.nodes.SelectionNode":
                    String isElse = ((SelectionNode)node).isElse() ? " else " : "";
                    this.print(localIndent, "(Selection) " + ((SelectionNode)node).getType() + isElse);
                    break;
                case "class com.p4.core.nodes.LogicalOPNode":
                    this.print(localIndent, "(LogicalOPNode) " + ((LogicalOPNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.LogicalExprNode":
                    this.print(localIndent, "(LogicalExpr) " + ((LogicalExprNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.CompNode":
                    this.print(localIndent, "(Comp) " + ((CompNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.CompExprNode":
                    this.print(localIndent, "(CompExpr) " + ((CompExprNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.BoolNode":
                    this.print(localIndent, "(Bool) " + ((BoolNode)node).getValue());
                    break;
                case "class com.p4.core.nodes.IDNode":
                    this.print(localIndent, "(ID) " + ((IDNode)node).getID());
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
                    this.print(localIndent, "(FuncDcl) " + ((FuncDclNode)node).getReturnType() + " " + ((FuncDclNode)node).getID());
                    break;
                case "class com.p4.core.nodes.ReturnExprNode":
                    this.print(localIndent, "(ReturnExpr)");
                    break;
                case "class com.p4.core.nodes.ProgNode":
                    this.print(localIndent, "(prog)");
                    break;
                case "class com.p4.core.nodes.BoolDclNode":
                    this.print(localIndent, "(BoolDcl) " + ((BoolDclNode)node).getType() + " " + ((BoolDclNode)node).getID());
                    break;
                case "class com.p4.cores.node.BoolNode":
                    this.print(localIndent, "(Bool)" + ((BoolNode)node).getType());
                    break;
                case "class com.p4.core.nodes.FormalParamNode":
                    this.print(localIndent, "(Formal Param)");
                    break;
                case "class com.p4.core.nodes.AddNode":
                    this.print(localIndent, "(Add)");
                    break;
                case "class com.p4.core.nodes.SubNode":
                    this.print(localIndent, "(Sub)");
                    break;
                case "class com.p4.core.nodes.ModNode":
                    this.print(localIndent, "(Mod)");
                    break;
                case "class com.p4.core.nodes.MultNode":
                    this.print(localIndent, "(Mult)");
                    break;
                case "class com.p4.core.nodes.DivNode":
                    this.print(localIndent, "(Div)");
                    break;
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