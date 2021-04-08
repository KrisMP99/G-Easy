package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import com.p4.core.datatypes.Pos;

public class PosNode<T> extends AstNode {
    public Pos p1;

    public PosNode(T x, T y){
        this.p1 = new Pos(x, y);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
