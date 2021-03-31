package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class VarDclNode extends AstNode {
    private String ID;

    public VarDclNode(String id) {
        this.ID = id;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
