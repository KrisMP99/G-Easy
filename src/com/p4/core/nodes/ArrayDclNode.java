package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class ArrayDclNode extends AstNode {
    public ArrayDclNode(String id, String type) {
        setID(id);
        setType(type);
    }

    @Override
    public String getNodesHash(){
        return "Array: " + getID();
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
