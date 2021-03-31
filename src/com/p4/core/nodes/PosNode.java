package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import com.p4.core.datatypes.Pos;

public class PosNode extends AstNode {
    public Pos p1;

    public PosNode(double x, double y){
        this.p1 = new Pos(x, y);
    }

    public PosNode(String x, String y){
        this.p1 = new Pos(x, y);
    }


    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
