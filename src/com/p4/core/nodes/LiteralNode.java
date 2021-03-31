package com.p4.core.nodes;

abstract class LiteralNode<T> extends AstNode {
    private T value;
    private boolean isNegative;

    public LiteralNode(T value, boolean isNegative) {
        this.value = value;
        this.isNegative = isNegative;
    }

    public T getValue() {
        return value;
    }

    public void setValue() {
        this.value = value;
    }

    public boolean getIsNegative() {
        return isNegative;
    }

    public void setIsNegative() {
        this.isNegative = isNegative;
    }

}
