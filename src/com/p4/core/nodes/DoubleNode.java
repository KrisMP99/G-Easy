package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class DoubleNode extends AstNode{
    public double value;
    public boolean isNegative;

    public DoubleNode(double value, boolean isNegative) {
        this.value = value;
        this.isNegative = isNegative;
    }

    @Override
    public String toString(){
        return Double.toString(value);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
