package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class ArrayAccessNode extends AstNode {
    private String ID;
    private boolean isNegative;

    public ArrayAccessNode(String id, boolean isNegative){
        this.ID = id;
        this.isNegative = isNegative;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isNegative() {
        return isNegative;
    }

    public void setNegative(boolean negative) {
        isNegative = negative;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }
}
