package com.p4.core;

import com.p4.core.nodes.ProgNode;
import com.p4.core.visitors.AstTreeVisitor;
import com.p4.core.visitors.AstVisitor;
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

        GEasyBaseVisitor<?> visitor = new AstVisitor<>();
        ProgNode ast = (ProgNode) visitor.visit(parseTree);

        AstTreeVisitor astTreeVisitor = new AstTreeVisitor();
        astTreeVisitor.visit(0, ast);

        // ast
        System.out.println(ast.toString());



        // Text in console
        System.out.println(parseTree.toStringTree(parser));

        //AST in GUI
        //TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),parseTree);
        //viewer.open();
    }
}