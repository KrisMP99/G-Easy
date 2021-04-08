package com.p4.core.nodes;

import com.p4.core.visitors.INodeVisitor;
import org.antlr.v4.runtime.CommonToken;

public class LogicalNode extends AstNode {
    private CommonToken token;

    public int getToken() {
        return token.getType();
    }

    public void setToken(int tokenOperator) {
        this.token = new CommonToken(tokenOperator);
    }

    @Override
    public void accept(INodeVisitor visitor) {
        visitor.visit(this);
    }
}
