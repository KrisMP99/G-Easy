package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class DoubleNode extends AstNode{
    public double value;

    public DoubleNode(double value) {
        this.value = value;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
