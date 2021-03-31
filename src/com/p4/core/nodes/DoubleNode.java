package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class DoubleNode extends LiteralNode{

    public DoubleNode(Object value, boolean isNegative) {
        super(value, isNegative);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
