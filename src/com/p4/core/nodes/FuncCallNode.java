package com.p4.core.nodes;

public abstract class FuncCallNode<T> extends AstNode {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
