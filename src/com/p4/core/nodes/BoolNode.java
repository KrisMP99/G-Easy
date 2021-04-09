package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class BoolNode extends AstNode {
    boolean type;

    public BoolNode(boolean value) {
        type = value;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
