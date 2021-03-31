package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

import java.util.ArrayList;
import java.util.List;

public abstract class AstNode {
    public List<AstNode> children = new ArrayList<>();
    public int lineNumber = 0;
    public String type;

    public List<AstNode> getChildren() {
        return children;
    }

    public abstract void accept(INodeVisitor visitor);

}