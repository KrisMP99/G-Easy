package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IntDclNode extends AstNode{
    public String id;
    public IntDclNode(String ID){
        this.id = ID;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
