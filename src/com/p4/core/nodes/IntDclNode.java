package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

import java.util.List;

public class IntDclNode extends VarDclNode<Integer> {
    public IntDclNode(String ID){
        super(ID);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
