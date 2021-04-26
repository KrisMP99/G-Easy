package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class FuncDclNode extends AstNode {
    private String returnType;
    private String id;

    public FuncDclNode(String ID, String returnType) {
        this.id = ID;
        this.returnType = returnType;
    }

    public String getID() {
        return id;
    }

    public void setID(String type) {
        this.id = id;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    @Override
    public String getNodesHash() {
        return "Func: " + id;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

}
