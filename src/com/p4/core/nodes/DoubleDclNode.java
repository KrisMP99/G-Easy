package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class DoubleDclNode extends AstNode {
    public String id;

    public DoubleDclNode(String ID) {
        this.id = ID;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
