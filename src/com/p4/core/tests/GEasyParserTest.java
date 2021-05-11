package com.p4.core.tests;

import com.p4.core.GEasyLexer;
import com.p4.core.GEasyParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.ListTokenSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GEasyParserTest {

    @Test
    public void testInt() {
        var noParam = createParserNoError(Arrays.asList(
                new TestToken("1", GEasyLexer.NUMBER),
                new TestToken(";", GEasyLexer.SEMICOLON)
        ));

        var f = noParam.prog();
        assertTrue(f.getText().contains("1;"));
    }

    @Test
    public void testNumberExpr() {
        var noParam = createParserNoError(Arrays.asList(
                new TestToken("1", GEasyLexer.NUMBER),
                new TestToken("+", GEasyLexer.PLUS),
                new TestToken("1", GEasyLexer.NUMBER),
                new TestToken(";", GEasyLexer.SEMICOLON)
        ));

        var f = noParam.prog();
        assertTrue(f.getText().contains("1+1;"));
    }

    //@Test
    //public void testAssignmentOfNumber() {
    //    var noParam = createParserNoError(Arrays.asList(
    //            new TestToken("int", GEasyLexer.TYPE),
    //            new TestToken(" ", GEasyLexer.WHITESPACE),
    //            new TestToken("x", GEasyLexer.ID),
    //           new TestToken("=", GEasyLexer.ASSIGN_OP),
    //            new TestToken("1", GEasyLexer.NUMBER),
    //            new TestToken(";", GEasyLexer.SEMICOLON)
    //    ));
    //
    //    var f = noParam.prog();
    //    assertTrue(f.getText().contains("int x=1;"));
    //}

    @Test
    public void testAssignmentOfVariable() {
        GEasyParser.ProgContext f = null;

            var noParam = createParserNoError(Arrays.asList(
                new TestToken("int", GEasyLexer.TYPE),
                new TestToken(" ", GEasyLexer.WHITESPACE),
                new TestToken("x", GEasyLexer.ID),
                new TestToken("=", GEasyLexer.ASSIGN_OP),
                new TestToken("y", GEasyLexer.ID),
                new TestToken(";", GEasyLexer.SEMICOLON)
        ));

        assertTrue(f.getText().contains("int x=y;"));
    }

    // It was discovered that 'intx=y;' was a valid expression.
    // As per good testing strategy, a negative test was developed
    // When this test passes, we know the bug is no longer present
    // By keeping this test in, we also know the bug isn't introduced back into the code
    // Good testing strategy = when you find a bug, write a test that (fails) and proves it exists.
    // When that test passes, the bug is removed, and the test will let you know if the bug appears again.
    @Test
    public void testErrorWhenAssignmentWithNoWhitespace() {
        var noParam = createParserNoError(Arrays.asList(
                new TestToken("int", GEasyLexer.TYPE),
                new TestToken("x", GEasyLexer.ID),
                new TestToken("=", GEasyLexer.ASSIGN_OP),
                new TestToken("y", GEasyLexer.ID),
                new TestToken(";", GEasyLexer.SEMICOLON)
        ));

        GEasyParser.ProgContext f = null;

        try {
            f = noParam.prog();
        }
        catch (Exception e) {
            Assertions.assertTrue(true);
            return;
        }

        // Exception was not thrown
        Assertions.fail();

    }

    private GEasyParser createParserNoError(List<TestToken> tokens) {
        var ts = new ListTokenSource(tokens);
        var c = new CommonTokenStream(ts);
        var p = new GEasyParser(c);
        p.addErrorListener(new NoErrorListener());
        return p;
    }
}