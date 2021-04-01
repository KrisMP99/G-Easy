package com.p4;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream charStream = CharStreams.fromFileName("src/com/p4/SourceFile.GE");
        GEasyLexer lexer = new GEasyLexer(charStream);
        GEasyParser parser = new GEasyParser(new CommonTokenStream(lexer));
        ParseTree parseTree = parser.prog();

        // Text in console
        System.out.println(parseTree.toStringTree(parser));

        //AST in GUI
        //TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),parseTree);
        //viewer.open();
    }
}