package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class DclNode extends AstNode {
    private String ID;

    public DclNode(String id) {
        this.ID = id;
    }

    public String getID(){
        return ID;
    }

    public void setID(String id){
        this.ID = id;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
