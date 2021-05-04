package com.p4.core.tests;

import com.p4.core.GEasyLexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GEasyLexerTest {

    @Test
    public void testBool() {
        var tokens = getTokensFromText("true");

        assertEquals(2, tokens.size()); // includes EOF
        Assertions.assertEquals(GEasyLexer.BOOL, tokens.get(0).getType());
    }

    @Test
    public void testInt() {
        var tokens = getTokensFromText("1");

        assertEquals(2, tokens.size()); // includes EOF
        Assertions.assertEquals(GEasyLexer.NUMBER, tokens.get(0).getType());
    }

    @Test
    public void testDouble() {
        var tokens = getTokensFromText("1.1");

        assertEquals(2, tokens.size()); // includes EOF
        Assertions.assertEquals(GEasyLexer.NUMBER, tokens.get(0).getType());
    }

    @Test
    public void testExpression() {
        var tokens = getTokensFromText("1+1");

        assertEquals(4, tokens.size()); // includes EOF
        Assertions.assertEquals(GEasyLexer.NUMBER, tokens.get(0).getType());
        Assertions.assertEquals(GEasyLexer.PLUS, tokens.get(1).getType());
        Assertions.assertEquals(GEasyLexer.NUMBER, tokens.get(2).getType());
    }

    @Test
    public void testAnd() {
        var tokens = getTokensFromText("&&");

        assertEquals(2, tokens.size()); // includes EOF
        Assertions.assertEquals(GEasyLexer.AND, tokens.get(0).getType());
    }

    @Test
    public void testOr() {
        var tokens = getTokensFromText("||");

        assertEquals(2, tokens.size()); // includes EOF
        Assertions.assertEquals(GEasyLexer.OR, tokens.get(0).getType());
    }

    @Test
    public void testBoolExprAnd() {
        var tokens = getTokensFromText("true && true");

        assertEquals(6, tokens.size()); // includes EOF
        Assertions.assertEquals(GEasyLexer.BOOL, tokens.get(0).getType());
        Assertions.assertEquals(GEasyLexer.WHITESPACE, tokens.get(1).getType());
        Assertions.assertEquals(GEasyLexer.AND, tokens.get(2).getType());
        Assertions.assertEquals(GEasyLexer.WHITESPACE, tokens.get(3).getType());
        Assertions.assertEquals(GEasyLexer.BOOL, tokens.get(4).getType());
    }

    @Test
    public void testBoolExprOr() {
        var tokens = getTokensFromText("true || true");

        assertEquals(6, tokens.size()); // includes EOF
        Assertions.assertEquals(GEasyLexer.BOOL, tokens.get(0).getType());
        Assertions.assertEquals(GEasyLexer.WHITESPACE, tokens.get(1).getType());
        Assertions.assertEquals(GEasyLexer.OR, tokens.get(2).getType());
        Assertions.assertEquals(GEasyLexer.WHITESPACE, tokens.get(3).getType());
        Assertions.assertEquals(GEasyLexer.BOOL, tokens.get(4).getType());
    }

    @Test
    public void testNumberAndBool_ExpectsFail() {
        var tokens = getTokensFromText("1 && TRUE");

        assertEquals(6, tokens.size()); // includes EOF
        Assertions.fail();
    }

    @Test
    public void testLtAndLt_ExpectsFail() {
        var tokens = getTokensFromText("< && <");

        assertEquals(6, tokens.size()); // includes EOF
        Assertions.fail();
    }

    @Test
    public void testRandomInput_ExpectsFail() {
        var tokens = getTokensFromText("<>21321zz>");

        assertEquals(6, tokens.size()); // includes EOF
        Assertions.fail();
    }



    private List<Token> getTokensFromText(String txt) {
        CharStream charStream = CharStreams.fromString(txt);
        Lexer lexer = new GEasyLexer(charStream);
        //lexer.addErrorListener(errorListener);

        var tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        return tokenStream.getTokens();
    }
}