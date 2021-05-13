package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class DoubleDclNode extends VarDclNode<Double> {
    public DoubleDclNode(String ID) {
        super(ID);
        setType("double");
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
