package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class ArrayAccessNode extends AstNode {
    public String ID;

    public ArrayAccessNode(String id){
        this.ID = id;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
