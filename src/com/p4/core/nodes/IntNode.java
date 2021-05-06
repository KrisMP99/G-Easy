package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IntNode extends AstNode {
    public int value;
    public boolean isNegative;
    public IntNode(int value, boolean isNegative) {
        this.value = value;
        this.isNegative = isNegative;
        setValue(Integer.toString(value));
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
