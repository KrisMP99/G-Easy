package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class CommentNode extends AstNode {

    private final String comment;

    public CommentNode(String comment) {
        this.comment = comment;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    public String getComment() {
        return this.comment + "\n";
    }

}
