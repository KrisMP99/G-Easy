package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class ActualParamNode extends AstNode {
    private String id;

    public ActualParamNode(String ID) {
        this.id = ID;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getID() {
        return this.id;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
