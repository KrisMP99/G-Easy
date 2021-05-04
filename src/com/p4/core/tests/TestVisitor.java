package com.p4.core.tests;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyParser;

public class TestVisitor extends GEasyBaseVisitor<String> {
    // https://stackoverflow.com/questions/25458342/unit-testing-the-semantic-analysis-visitors-of-an-antlr-based-tree

    @Override
    public String visitExpr(GEasyParser.ExprContext ctx) {
        return visit(ctx.val().get(0)) + " + " + visit(ctx.val().get(0));
    }
}
