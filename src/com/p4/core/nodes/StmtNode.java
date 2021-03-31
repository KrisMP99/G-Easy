package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public abstract class StmtNode<T> extends AstNode {
    private String id;

    public StmtNode(String id) {
        this.id = id;
    }

    public String getID(){
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
