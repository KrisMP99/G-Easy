package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class BoolNode extends AstNode {

    public BoolNode(String value) {
        type = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
