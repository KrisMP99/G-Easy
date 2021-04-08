package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IDNode extends AstNode {
    public String id;

    public IDNode(String id){
        this.id = id;
    }

    // Used in param
    public IDNode(String id, String type){
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString(){
        return id;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
