package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class FuncCallNode extends AstNode {
    private String id;
    private boolean isNegative;

    public FuncCallNode(String id, boolean isNegative) {
        this.id = id;
        this.isNegative = isNegative;
    }

    public String getID(){
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
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
}
