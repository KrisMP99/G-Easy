package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IterativeNode extends AstNode {
    private String type;
    private String for_to;

    public IterativeNode(String type, String TO) {
        this.type = type;
        this.for_to = TO;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFor_to() {
        return for_to;
    }

    public void setFor_to(String for_to) {
        this.for_to = for_to;
    }
}
