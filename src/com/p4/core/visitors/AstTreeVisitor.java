package com.p4.core.visitors;

import com.p4.core.nodes.*;

public class AstTreeVisitor {
    public void visit(int localIndent, AstNode node) {
        if(node != null) {
            switch (node.getClass().toString()) {
                case "class com.p4.core.nodes.VarDclNode":
                    this.print(localIndent, node.getClass().toString() + " vi er igang med at lave en int navn: " + ((VarDclNode)node).getID());
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
