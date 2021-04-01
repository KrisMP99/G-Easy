package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;

public class LineCommentNode extends AstNode{
    private String comment;

    public LineCommentNode(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment + "\n";
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
