package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IDNode extends AstNode {
    public boolean isNegative;

    public IDNode(String id){
        setID(id);
    }
    public IDNode(String id, boolean isNegative){
        setID(id);
        this.isNegative = isNegative;
    }

    // Used in param
    public IDNode(String id, String type){
        setID(id);
        setType(type);
    }

    @Override
    public String toString(){
        return getID();
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
