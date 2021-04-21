package com.p4.core.visitors;

import com.p4.core.nodes.*;
import com.p4.core.symbolTable.SymbolAttributes;
import com.p4.core.symbolTable.SymbolTable;
import jdk.incubator.foreign.LibraryLookup;

import javax.swing.plaf.synth.SynthButtonUI;

public class SymbolTableVisitor implements INodeVisitor {
    SymbolTable symbolTable;

    public SymbolTableVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public void visitChildren(AstNode node) {
        for(AstNode child : node.children) {
            child.accept(this);
        }
    }

    @Override
    public void visit(PosDclNode node) {
        declareVarNode(node);
    }

    @Override
    public void visit(BoolDclNode node) {
        declareVarNode(node);
    }

    @Override
    public void visit(IntDclNode node) {
        declareVarNode(node);

    }

    @Override
    public void visit(DoubleDclNode node) {
        declareVarNode(node);

    }


    // Method to declare a var node (var_dcl node)
    private void declareVarNode(VarDclNode<?> node) {
        if(!isNodeDeclared(node)) {
            SymbolAttributes attributes = new SymbolAttributes("dcl", node.type);
            symbolTable.insertSymbol(node.getID(), attributes);
        }

    }

    private boolean isNodeDeclared(VarDclNode<?> node) {
        // We enter here, if the variable is already declared
        if(symbolTable.lookupSymbol(node.getID()) != null) {
            // Error handling here...
            return true;
        }

        return false;
    }


    @Override
    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(DclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FuncDclNode node) {
        // Enter if the function is already declared
        if(symbolTable.lookupSymbol(node.getID()) != null) {
            // Error handling here ...
        }

        // Create the function and add it to the symbol table
        SymbolAttributes attributes = new SymbolAttributes("function", node.getReturnType());
        symbolTable.insertSymbol(node.getID(), attributes);

        // Add the function's scope and its children
        symbolTable.addScope(node.getScopeHash());
        this.visitChildren(node);
        symbolTable.leaveScope();
    }

    @Override
    public void visit(FuncCallNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);
    }


    // Missing a check for if the node already exists
    @Override
    public void visit(ArrayDclNode node) {
        this.visitChildren(node);

        int arrayLength = node.children.size();

        SymbolAttributes attributes = new SymbolAttributes("array", node.getType(), arrayLength);
        symbolTable.insertSymbol(node.getID(), attributes);

    }

    @Override
    public void visit(VarDclNode node) {

    }

    @Override
    public void visit(PosAssignNode node) {

    }

    @Override
    public void visit(ArrayAccessNode node) {

    }

    @Override
    public void visit(ExprNode node) {

    }

    @Override
    public void visit(SelectionNode node) {

    }

    @Override
    public void visit(IterativeNode node) {

    }

    @Override
    public void visit(LogicalExprNode node) {

    }

    @Override
    public void visit(FormalParamNode node) {

    }

    @Override
    public void visit(ActualParamNode node) {

    }

    @Override
    public void visit(BlockNode node) {

    }

    @Override
    public void visit(ReturnExprNode node) {

    }

    @Override
    public void visit(ArithmeticNode node) {

    }

    @Override
    public void visit(CompNode node) {

    }

    @Override
    public void visit(BoolExprNode node) {

    }

    @Override
    public void visit(CompExprNode node) {

    }

    @Override
    public void visit(IDNode node) {

    }

    @Override
    public void visit(BoolNode node) {

    }

    @Override
    public void visit(IntNode node) {

    }

    @Override
    public void visit(DoubleNode node) {

    }

    @Override
    public void visit(PosNode node) {

    }

    @Override
    public void visit(LogicalOPNode node) {

    }

    @Override
    public void visit(LineCommentNode node) {

    }
}
