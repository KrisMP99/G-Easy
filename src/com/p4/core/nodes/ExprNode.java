package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class ExprNode extends AstNode {
    private boolean parentheses = false;
    private CommonToken token;

    public boolean getParentheses() {
        return parentheses;
    }

    public void setParentheses(boolean parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    public int getToken() {
        return token.getType();
    }

    public void setToken(int operator) {
        this.token = new CommonToken(operator);
    }
}
