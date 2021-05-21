package com.p4.core.tests.integrationTests;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyLexer;
import com.p4.core.GEasyParser;
import com.p4.core.errorHandling.ErrorCollector;
import com.p4.core.nodes.ProgNode;
import com.p4.core.symbolTable.SymbolTable;
import com.p4.core.visitors.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

class IntegrationTests {

    public static void main(String[] args) throws Exception {
        doTest("IntAssignmentFail.GE");
    }

    private static void doTest(String fileName) throws IOException {
        CharStream charStream = CharStreams.fromFileName("src/com/p4/core/tests/integrationTests/" + fileName);
        Lexer lexer = new GEasyLexer(charStream);
        GEasyParser parser = new GEasyParser(new CommonTokenStream(lexer));
        ParseTree parseTree = parser.prog();

        GEasyBaseVisitor<?> visitor = new AstVisitor<>();
        ProgNode ast = (ProgNode) visitor.visit(parseTree);

        AstTreePrinterVisitor astTreePrinterVisitor = new AstTreePrinterVisitor();
        astTreePrinterVisitor.printTree(0, ast);

        // Filling symbol table
        SymbolTable symbolTable = new SymbolTable();
        SymbolTableVisitor symbolTableVisitor = new SymbolTableVisitor(symbolTable);
        symbolTableVisitor.visit(ast);

        //Semantic visitor
        ErrorCollector errorCollector = new ErrorCollector();
        SemanticsVisitor semanticsVisitor = new SemanticsVisitor(symbolTable, errorCollector);
        semanticsVisitor.visit(ast);


        // We can only generate code, if there are no error from the semantic analysis
        if (!errorCollector.hasErrors()) {
            CodeVisitor codeVisitor = new CodeVisitor(symbolTable);
            codeVisitor.visit(ast);

            try {
                codeVisitor.print();
                System.out.println("Code has been generated!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Print errors
            errorCollector.displayErrors();
        }
    }
}
