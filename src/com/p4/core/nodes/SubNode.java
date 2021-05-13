package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class SubNode extends AstNode{
    private boolean parentheses = false;
    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isParentheses() {
        return parentheses;
    }

    public void setParentheses(boolean parentheses) {
        this.parentheses = parentheses;
    }
}
