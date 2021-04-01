package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class ArrayDclNode extends AstNode {
    private String id;

    public ArrayDclNode(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getID(){
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
