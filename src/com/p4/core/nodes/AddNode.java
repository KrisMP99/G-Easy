package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class AddNode extends AstNode {
    private boolean parentheses = false;
    public int lineNumber = 0;

    public boolean isParentheses() {
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
