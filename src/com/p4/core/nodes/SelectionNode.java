package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class SelectionNode extends AstNode {
    private String type;
    public SelectionNode(String type) {
        this.type = type;
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
