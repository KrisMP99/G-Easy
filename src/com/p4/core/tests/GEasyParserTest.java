package com.p4.core.tests;

import com.p4.core.GEasyLexer;
import com.p4.core.GEasyParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ListTokenSource;
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
    public void testBoolDecl() {
        var noParam = createParserNoError(Arrays.asList(
                new TestToken("1", GEasyLexer.NUMBER),
                new TestToken("+", GEasyLexer.ARITHMETIC_OP),
                new TestToken("1", GEasyLexer.NUMBER),
                new TestToken(";", GEasyLexer.SEMICOLON)
        ));

        var f = noParam.prog();
        assertTrue(f.getText().contains("1+1;"));
    }

    private GEasyParser createParserNoError(List<TestToken> tokens) {
        var ts = new ListTokenSource(tokens);
        var c = new CommonTokenStream(ts);
        var p = new GEasyParser(c);
        p.addErrorListener(new NoErrorListener());
        return p;
    }
}