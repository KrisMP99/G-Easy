package com.p4.core.tests;

import com.p4.core.GEasyBaseVisitor;
import com.p4.core.GEasyLexer;
import com.p4.core.GEasyParser;
import com.p4.core.nodes.*;
import com.p4.core.visitors.AstVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;

import static org.junit.jupiter.api.Assertions.*;

class GEasyBaseVisitorTest {

    private final GEasyBaseVisitor myVisitor = new GEasyBaseVisitor();

    /**
     * These tests are most easily written by running something in debug and seeing if it gives a sensible output.
     * Then, build the same AST. Examples of this is seen in the setup part of the tests.
     * At last. Run the actual program, and then evaluate it. That's pretty easy, just copy + paste and
     * insert the statement in the getParseTreeFromText method.
     */

    @Test
    public void visitIntAssignment() throws Exception {
        // setup
        var root = new ProgNode();
        var child = new IntDclNode("x");
        root.children.add(child);
        child.children.add((new IntNode(1, false)));

        // Running actual code
        var parseTree = getParseTreeFromText("int x = 1;");
        GEasyBaseVisitor<?> visitor = new AstVisitor<>();
        ProgNode ast = (ProgNode) visitor.visit(parseTree);

        // evaluation
        assertAstTypes(root, ast);
    }

    @Test
    public void visitIdAssignment() throws Exception {
        // setup
        var root = new ProgNode();
        var child = new IntDclNode("x");
        root.children.add(child);
        child.children.add((new IDNode("y")));

        // Running actual code
        var parseTree = getParseTreeFromText("int x = y;");
        GEasyBaseVisitor<?> visitor = new AstVisitor<>();
        ProgNode ast = (ProgNode) visitor.visit(parseTree);

        // evaluation
        assertAstTypes(root, ast);
    }

    // This might not be the best unit testing behavior (this... is actually system testing)
    // The amount of work involved in building a parsetree is a little much and prone to errors
    // So assuming everything in the chain works, and proper parsetrees are produced, we just use whatever is before
    private ParseTree getParseTreeFromText(String input) {
        CharStream charStream = CharStreams.fromString(input);
        Lexer lexer = new GEasyLexer(charStream);
        GEasyParser parser = new GEasyParser(new CommonTokenStream(lexer));
        return parser.prog();
    }

    private void assertAstTypes(AstNode expected, AstNode actual) {
        assertEquals(expected.getClass(), actual.getClass());

        for (int i = 0; i < expected.children.size(); i++) {
            assertAstTypes(expected.children.get(i), actual.children.get(i));
        }
    }

}