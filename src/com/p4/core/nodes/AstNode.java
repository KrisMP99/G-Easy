package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

import java.util.ArrayList;
import java.util.List;

public abstract class AstNode {
    public List<AstNode> children = new ArrayList<>();
    public int lineNumber = 0;
    public String type;
    private String ID = "";
    private String value;

    public List<AstNode> getChildren() {
        return children;
    }


    public String getNodesHash(){
        return String.valueOf(this.hashCode());
    }


    public abstract void accept(INodeVisitor visitor);

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
