package com.p4;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyLexer;
import com.p4.core.GEasyParser;
import com.p4.core.nodes.AstNode;
import com.p4.core.nodes.ProgNode;
import com.p4.core.symbolTable.SymbolAttributes;
import com.p4.core.symbolTable.SymbolTable;
import com.p4.core.visitors.AstTreeVisitor;
import com.p4.core.visitors.AstVisitor;
import com.p4.core.visitors.SymbolTableVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream charStream = CharStreams.fromFileName("src/com/p4/SourceFile.GE");
        Lexer lexer = new GEasyLexer(charStream);
        GEasyParser parser = new GEasyParser(new CommonTokenStream(lexer));
        ParseTree parseTree = parser.prog();

        GEasyBaseVisitor<?> visitor = new AstVisitor<>();
        ProgNode ast = (ProgNode) visitor.visit(parseTree);

        AstTreeVisitor astTreeVisitor = new AstTreeVisitor();
        astTreeVisitor.visit(0, ast);

        SymbolTable symbolTable = new SymbolTable();
        SymbolTableVisitor symbolTableVisitor = new SymbolTableVisitor(symbolTable);
        symbolTableVisitor.visit(ast);

        // symboltable
        System.out.println("Symbol table: ");
        System.out.println(symbolTable.toString());

        HashMap<String, SymbolAttributes> symbols = symbolTable.getCurrentScope().getSymbols();
        symbols.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });


        // Text in console
        System.out.println("ParseTree: ");
        System.out.println(parseTree.toStringTree(parser));

        //ParseTree in GUI
        //TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),parseTree);
        //viewer.open();
    }
}