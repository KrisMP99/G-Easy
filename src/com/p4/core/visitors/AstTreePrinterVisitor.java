package com.p4.core.visitors;

import com.p4.core.nodes.*;

// Prints the AST to the console
public class AstTreePrinterVisitor {
    public void printTree(int localIndent, AstNode node) {
        if(node != null) {
            switch (node.getClass().toString()) {
                case "class com.p4.core.nodes.IntDclNode":
                    this.printNode(localIndent,"(IntDcl) " + node.getType() + " " + node.getID());
                    break;
                case "class com.p4.core.nodes.DoubleDclNode":
                    this.printNode(localIndent,"(DoubleDcl) " + node.getType() + " " + node.getID());
                    break;
                case "class com.p4.core.nodes.PosDclNode":
                    this.printNode(localIndent,"(PosDcl) " + node.getType() + " " + node.getID());
                    break;
                case "class com.p4.core.nodes.ArithmeticNode":
                    this.printNode(localIndent, "(Arthm) " + ((ArithmeticNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.DoubleNode":
                    this.printNode(localIndent, "(Double) " + node.getValue());
                    break;
                case "class com.p4.core.nodes.IntNode":
                    this.printNode(localIndent, "(Int) " + node.getValue());
                    break;
                case "class com.p4.core.nodes.ArrayDclNode":
                    this.printNode(localIndent, "(ArrayDcl) " + node.getType() + " " + node.getID());
                    break;
                case "class com.p4.core.nodes.ArrayAccessNode":
                    this.printNode(localIndent, "(ArrayAccess) " + node.getID());
                    break;
                case "class com.p4.core.nodes.FuncCallNode":
                    this.printNode(localIndent, "(FuncCall) " + node.getID());
                    break;
                case "class com.p4.core.nodes.ActualParamNode":
                    this.printNode(localIndent, "(ActualParm) " + node.getID());
                    break;
                case "class com.p4.core.nodes.LineCommentNode":
                    this.printNode(localIndent, "(LineComment) " + ((LineCommentNode)node).getComment());
                    break;
                case "class com.p4.core.nodes.PosAssignNode":
                    this.printNode(localIndent, "(PosAssign) ");
                    break;
                case "class com.p4.core.nodes.SelectionNode":
                    String isElse = ((SelectionNode)node).isElse() ? " else " : "";
                    this.printNode(localIndent, "(Selection) " + node.getType() + isElse);
                    break;
                case "class com.p4.core.nodes.LogicalOPNode":
                    this.printNode(localIndent, "(LogicalOPNode) " + ((LogicalOPNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.LogicalExprNode":
                    this.printNode(localIndent, "(LogicalExpr) " + ((LogicalExprNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.CompNode":
                    this.printNode(localIndent, "(Comp) " + ((CompNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.CompExprNode":
                    this.printNode(localIndent, "(CompExpr) " + ((CompExprNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.BoolNode":
                    this.printNode(localIndent, "(Bool) " + ((BoolNode)node).getBoolValue());
                    break;
                case "class com.p4.core.nodes.IDNode":
                    this.printNode(localIndent, "(ID) " + node.getID());
                    break;
                case "class com.p4.core.nodes.AssignNode":
                    this.printNode(localIndent, "(Assign) " + node.getType() + " " + node.getID());
                    break;
                case "class com.p4.core.nodes.BlockNode":
                    this.printNode(localIndent, "(Block)");
                    break;
                case "class com.p4.core.nodes.IterativeNode":
                    this.printNode(localIndent, "(Iterative) " + node.getType() + " " + ((IterativeNode)node).getFor_to());
                    break;
                case "class com.p4.core.nodes.FuncDclNode":
                    this.printNode(localIndent, "(FuncDcl) " + ((FuncDclNode)node).getReturnType() + " " + node.getID());
                    break;
                case "class com.p4.core.nodes.ReturnExprNode":
                    this.printNode(localIndent, "(ReturnExpr)");
                    break;
                case "class com.p4.core.nodes.ProgNode":
                    this.printNode(localIndent, "(prog)");
                    break;
                case "class com.p4.core.nodes.BoolDclNode":
                    this.printNode(localIndent, "(BoolDcl) " + node.getType() + " " + node.getID());
                    break;
                case "class com.p4.cores.node.BoolNode":
                    this.printNode(localIndent, "(Bool)" + node.getType());
                    break;
                case "class com.p4.core.nodes.FormalParamNode":
                    this.printNode(localIndent, "(Formal Param) " + node.getID());
                    break;
                case "class com.p4.core.nodes.AddNode":
                    this.printNode(localIndent, "(Add)");
                    break;
                case "class com.p4.core.nodes.SubNode":
                    this.printNode(localIndent, "(Sub)");
                    break;
                case "class com.p4.core.nodes.ModNode":
                    this.printNode(localIndent, "(Mod)");
                    break;
                case "class com.p4.core.nodes.MultNode":
                    this.printNode(localIndent, "(Mult)");
                    break;
                case "class com.p4.core.nodes.DivNode":
                    this.printNode(localIndent, "(Div)");
                    break;
            }

            for(AstNode childNode : node.getChildren()) {
                printTree(localIndent + 1, childNode);
            }
        }
    }

    private void printNode(int indent, String string) {
        StringBuilder outputString = new StringBuilder();
        outputString.append("\t".repeat(Math.max(0, indent)));

        if(string != null) {
            outputString = new StringBuilder(outputString.toString().concat(string));
        } else {
            outputString = new StringBuilder(outputString.toString().concat("null"));
        }

        System.out.println(outputString);
    }
}
