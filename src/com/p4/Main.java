package com.p4;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyLexer;
import com.p4.core.GEasyParser;
import com.p4.core.errorHandling.ErrorCollector;
import com.p4.core.nodes.ProgNode;
import com.p4.core.symbolTable.SymbolTable;
import com.p4.core.visitors.AstTreePrinterVisitor;
import com.p4.core.visitors.AstVisitor;
import com.p4.core.visitors.SemanticsVisitor;
import com.p4.core.visitors.SymbolTableVisitor;
import com.p4.core.visitors.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream charStream = CharStreams.fromFileName("src/com/p4/SourceFile.GE");
        Lexer lexer = new GEasyLexer(charStream);
        GEasyParser parser = new GEasyParser(new CommonTokenStream(lexer));
        ParseTree parseTree = parser.prog();

        GEasyBaseVisitor<?> visitor = new AstVisitor<>();
        ProgNode ast = (ProgNode) visitor.visit(parseTree);

        AstTreePrinterVisitor astTreePrinterVisitor = new AstTreePrinterVisitor();
        astTreePrinterVisitor.visit(0, ast);


        // Filling symbol table
        SymbolTable symbolTable = new SymbolTable();
        SymbolTableVisitor symbolTableVisitor = new SymbolTableVisitor(symbolTable);
        symbolTableVisitor.visit(ast);

        //Semantic visitor
        ErrorCollector errorCollector = new ErrorCollector();
        SemanticsVisitor semanticsVisitor = new SemanticsVisitor(symbolTable, errorCollector);
        semanticsVisitor.visit(ast);

        // Print errors
        errorCollector.printErrors();

        // Text in console (parseTree)
        // System.out.println("ParseTree: ");
        // System.out.println(parseTree.toStringTree(parser));
        CodeVisitor codeVisitor = new CodeVisitor(symbolTable);

        codeVisitor.visit(ast);

        //ParseTree in GUI
        //TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()),parseTree);
        //viewer.open();
    }
}