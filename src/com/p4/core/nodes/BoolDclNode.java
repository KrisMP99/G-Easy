package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class BoolDclNode extends VarDclNode<Boolean> {
    public BoolDclNode(String id, String type) {
        super(id);
        this.type = type;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
