package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class FuncDclNode extends AstNode {
    private String id;

    public FuncDclNode(String id, String type) {
        this.id = id;
        this.type = type;
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
