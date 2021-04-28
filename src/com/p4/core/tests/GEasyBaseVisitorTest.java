package com.p4.core.tests;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GEasyBaseVisitorTest {

    private final GEasyBaseVisitor myVisitor = new GEasyBaseVisitor();

    @Test
    public void visitPlus_joinsOperatorsWithWordPLUSAsSeparator() throws Exception {
        // setup
        final GEasyParser.PlusContext plusNode = mock(GEasyParser.PlusContext.class);
        plusNode.left = mockForVisitorResult(DemoParser.ExpressionContext.class, "2");
        plusNode.right = mockForVisitorResult(DemoParser.ExpressionContext.class, "4");

        // execution
        final String actual = myVisitor.visitPlus(plusNode);

        // evaluation
        assertEquals(actual, "2 PLUS 4");
    }

}