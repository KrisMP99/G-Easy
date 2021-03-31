package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class ArrayDclNode extends AstNode {
    public ArrayDclNode(String type) {
        this.type = type;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
