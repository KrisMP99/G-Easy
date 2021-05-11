package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IntNode extends AstNode {
    public boolean isNegative;

    public IntNode(int value, boolean isNegative) {
        this.isNegative = isNegative;
        setValue(Integer.toString(value));
    }

    @Override
    public String toString(){
        return getValue();
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
