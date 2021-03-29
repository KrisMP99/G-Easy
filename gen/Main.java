import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.gui.TreeViewer;

public class Main {
    public static void main(String[] args) throws Exception {
        gLexer lexer = new gLexer(new ANTLRFileStream("test.g"));
        gParser parser = new gParser(new CommonTokenStream(lexer));
        ParseTree parseTree = parser.prog();

        // Text in console
        System.out.println(parseTree.toStringTree(parser));

        //AST in GUI
        //TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()),parseTree);
        //viewr.open();
    }
}