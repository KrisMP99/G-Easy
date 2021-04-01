package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class BlockNode extends AstNode{
    private String parentID = "";

    public String getParentID(){
        return this.parentID;
    }

    public void setParentID(String parentID){
        this.parentID = parentID;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
