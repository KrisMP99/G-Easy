package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import com.p4.core.datatypes.Pos;

public class PosDclNode extends VarDclNode<Pos> {
    public PosDclNode(String ID){
        super(ID);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
