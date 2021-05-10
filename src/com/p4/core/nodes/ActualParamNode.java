package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class ActualParamNode extends AstNode {

    public ActualParamNode(String ID) {
        setID(ID);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
