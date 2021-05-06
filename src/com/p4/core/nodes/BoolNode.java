package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class BoolNode extends AstNode {
    private String type;
    private boolean boolValue;


    public BoolNode(boolean value, String type) {
        this.type = type;
        this.boolValue = value;
        setValue(Boolean.toString(value));
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

    public boolean getBoolValue() {
        return boolValue;
    }

    public void setValue(boolean value) {
        this.boolValue = value;
    }
}
