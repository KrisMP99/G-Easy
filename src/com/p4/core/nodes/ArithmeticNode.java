package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class ArithmeticNode extends AstNode {
    private CommonToken token;

    public ArithmeticNode(int operator) {
        this.token = new CommonToken(operator);
    }

    public int getToken() {
        return token.getType();
    }

    public void setToken(int operator) {
        this.token = new CommonToken(operator);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
