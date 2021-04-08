package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IntNode extends AstNode {
    public int value;
    public IntNode(int value) {
        this.value = value;
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
