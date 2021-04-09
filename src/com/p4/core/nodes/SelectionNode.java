package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class SelectionNode extends AstNode {
    private String type;
    private Boolean isElse;

    public SelectionNode(String type, Boolean isElse) {
        this.type = type;
        this.isElse = isElse;
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

    public Boolean isElse() {
        return isElse;
    }

    public void setElse(Boolean isElse) {
        this.isElse = isElse;
    }
}
