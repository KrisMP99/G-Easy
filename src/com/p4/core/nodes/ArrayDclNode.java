package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class ArrayDclNode<T> extends DclNode<T> {
    public ArrayDclNode(String ID) {
        super(ID);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
