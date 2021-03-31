package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IDNode extends AstNode {
    public String name;

    public IDNode(String name){
        this.name = name;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
