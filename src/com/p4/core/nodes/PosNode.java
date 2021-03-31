package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import com.p4.core.datatypes.Pos;

public class PosNode extends LiteralNode<Pos> {
    public PosNode(Pos p1) {
        super(p1, false);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
