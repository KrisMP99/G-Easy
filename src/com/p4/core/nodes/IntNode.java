package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IntNode extends DclNode<Integer>{
    public IntegerDclNode(String id) {
        super(id);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
