package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class CompNode extends AstNode {
    private CommonToken token;

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }

    public int getToken() {
        return token.getType();
    }

    public void setToken(int tokenOperator) {
        this.token = new CommonToken(tokenOperator);
    }
}
