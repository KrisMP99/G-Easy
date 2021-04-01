package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class AssignNode extends AstNode {
    private String id;
    public AssignNode(String id) {
        this.id = id;
    }

    public String getID(){
        return this.id;
    }

    public void setID(){
        this.id = id;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
