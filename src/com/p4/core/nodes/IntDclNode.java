package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class IntDclNode extends VarDclNode<Integer> {
    public IntDclNode(String ID){
        super(ID);
        setType("int");
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
