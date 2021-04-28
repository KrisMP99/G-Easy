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
        Assertions.assertEquals(GEasyLexer.ARITHMETIC_OP, tokens.get(1).getType());
        Assertions.assertEquals(GEasyLexer.NUMBER, tokens.get(2).getType());
    }

    @Test
    public void testBoolDecl() {
        var tokens = getTokensFromText("bool t = true");

        assertEquals(8, tokens.size()); // includes EOF
        Assertions.assertEquals(GEasyLexer.BOOL_T, tokens.get(0).getType());
        Assertions.assertEquals(GEasyLexer.WHITESPACE, tokens.get(1).getType());
        Assertions.assertEquals(GEasyLexer.ID, tokens.get(2).getType());
        Assertions.assertEquals(GEasyLexer.WHITESPACE, tokens.get(3).getType());
        Assertions.assertEquals(GEasyLexer.ASSIGN_OP, tokens.get(4).getType());
        Assertions.assertEquals(GEasyLexer.WHITESPACE, tokens.get(5).getType());
        Assertions.assertEquals(GEasyLexer.BOOL, tokens.get(6).getType());
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