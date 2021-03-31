package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import com.p4.core.datatypes.Pos;

public class PosDclNode extends AstNode {
    private String ID;

    public PosDclNode(String ID){
        this.ID = ID;
    }

    public String getID(){
        return this.ID;
    }

    public void setID(String id){
        this.ID = id;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
