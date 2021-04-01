package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class FuncCallNode extends AstNode {
    private String id;

    public FuncCallNode(String id) {
        this.id = id;
    }

    public String getID(){
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
