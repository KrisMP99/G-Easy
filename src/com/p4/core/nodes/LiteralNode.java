package com.p4.core.nodes;

abstract class LiteralNode<T> extends AstNode {
    private T value;

    public LiteralNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue() {
        this.value = value;
    }

}
