package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class ExprNode extends AstNode {
    private boolean parentheses = false;

    public boolean getParentheses() {
        return parentheses;
    }

    public void setParentheses(boolean parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
