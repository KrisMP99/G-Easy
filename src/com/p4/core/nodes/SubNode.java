package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class SubNode extends AstNode{
    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}