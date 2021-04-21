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

    private List<Token> getTokensFromText(String txt) {
        CharStream charStream = CharStreams.fromString(txt);
        Lexer lexer = new GEasyLexer(charStream);
        //lexer.addErrorListener(errorListener);

        var tokenStream = new CommonTokenStream(lexer);
        tokenStream.fill();
        return tokenStream.getTokens();
    }
}