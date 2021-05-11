package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class FuncDclNode extends AstNode {
    private String returnType;

    public FuncDclNode(String ID, String returnType) {
        setID(ID);
        this.returnType = returnType;
    }


    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    @Override
    public String getNodesHash() {
        return "Func: " + getID();
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

}
