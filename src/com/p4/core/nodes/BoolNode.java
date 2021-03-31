package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class BoolNode extends LiteralNode<Boolean> {

    public BoolNode(Boolean value, boolean isNegative) {
        super(value, isNegative);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
