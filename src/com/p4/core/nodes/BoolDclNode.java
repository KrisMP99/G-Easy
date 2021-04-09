package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class BoolDclNode extends AstNode {
    private String id;



    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
