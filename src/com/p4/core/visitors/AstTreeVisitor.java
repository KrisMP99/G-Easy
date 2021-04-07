package com.p4.core.visitors;

import com.p4.core.nodes.*;

public class AstTreeVisitor {
    public void visit(int localIndent, AstNode node) {
        if(node != null) {
            switch (node.getClass().toString()) {
                case "class com.p4.core.nodes.IntDclNode":
                    this.print(localIndent," IntDcl " + ((VarDclNode)node).getType() + " " + ((VarDclNode)node).getID());
                    break;
                case "class com.p4.core.nodes.DoubleDclNode":
                    this.print(localIndent," DoubleDcl " + ((VarDclNode)node).getType() + " " + ((VarDclNode)node).getID());
                    break;
                case "class com.p4.core.nodes.PosDclNode":
                    this.print(localIndent," PosDcl " + ((VarDclNode)node).getType() + " " + ((VarDclNode)node).getID());
                    break;
                case "class com.p4.core.nodes.ExprNode":
                    this.print(localIndent, "Expr ");
                    break;
                case "class com.p4.core.nodes.ArithmeticNode":
                    this.print(localIndent, "Arthm: " + ((ArithmeticNode)node).getToken());
                    break;
                case "class com.p4.core.nodes.DoubleNode":
                    this.print(localIndent, "Double: " + ((DoubleNode)node).value);
                    break;
                case "class com.p4.core.nodes.IntNode":
                    this.print(localIndent, "Int: " + ((IntNode)node).value);
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
