package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import com.p4.core.datatypes.Pos;

public class PosNode<T> extends AstNode {
    public Pos p1;
    private String xID;
    private String yID;

    public PosNode(T x, T y){
        this.p1 = new Pos(x, y);
    }

    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    public String getxID() {
        return xID;
    }

    public void setxID(String xID) {
        this.xID = xID;
    }

    public String getyID() {
        return yID;
    }

    public void setyID(String yID) {
        this.yID = yID;
    }

    @Override
    public String toString(){
        return p1.getX() + " " + p1.getY();
    }
}
