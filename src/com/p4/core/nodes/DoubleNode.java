package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class DoubleNode extends AstNode{
    public double value;
    public boolean isNegative;
    private boolean parentheses = false;

    public DoubleNode(double value, boolean isNegative) {
        this.value = value;
        this.isNegative = isNegative;
        setValue(Double.toString(value));
    }

    @Override
    public String toString(){
        return Double.toString(value);
    }

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
