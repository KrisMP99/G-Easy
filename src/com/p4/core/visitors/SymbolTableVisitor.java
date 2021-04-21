package com.p4.core.visitors;

import com.p4.core.nodes.*;
import com.p4.core.symbolTable.SymbolAttributes;
import com.p4.core.symbolTable.SymbolTable;

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
        SymbolAttributes attributes = new SymbolAttributes("function call");

        this.visitChildren(node);
    }

    @Override
    public void visit(AssignNode node) {

    }

    @Override
    public void visit(ArrayDclNode node) {
    }

    //It's possible that this visit is not needed and therefore should be deleted
    @Override
    public void visit(VarDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PosAssignNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SelectionNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IterativeNode node) {
        symbolTable.addScope(node.getNodesHash());
        this.visitChildren(node);
        symbolTable.leaveScope(node.getNodesHash());
    }

    @Override
    public void visit(LogicalExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FormalParamNode node) {
        String scopeName = symbolTable.getCurrentScope().getScopeName();

        for (AstNode child : node.getChildren()){
            IDNode param = (IDNode)child;
            SymbolAttributes attributes = new SymbolAttributes("Formal Param", param.type);
            attributes.setScope(scopeName);
            symbolTable.insertParam(param.getID(), attributes);
        }
        this.visitChildren(node);
    }

    @Override
    public void visit(ActualParamNode node) {
        String scopeName = symbolTable.getCurrentScope().getScopeName();

        for (AstNode child : node.getChildren()){
            IDNode param = (IDNode)child;
            SymbolAttributes attributes = new SymbolAttributes("Actual Param", param.type);
            attributes.setScope(scopeName);
            symbolTable.insertParam(param.getID(), attributes);
        }
        this.visitChildren(node);
    }

    @Override
    public void visit(BlockNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ReturnExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArithmeticNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CompNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(BoolExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(CompExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IDNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(BoolNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IntNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(DoubleNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PosNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(LogicalOPNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(LineCommentNode node) {
        this.visitChildren(node);

    }
}
