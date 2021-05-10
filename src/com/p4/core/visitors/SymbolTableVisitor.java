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
        this.visitChildren(node);

        if(!isNodeDeclared(node)) {
            SymbolAttributes attributes = new SymbolAttributes("dcl", node.type);
            attributes.setScope(symbolTable.getCurrentScope().getScopeName());
            symbolTable.insertSymbol(node.getID(), attributes);
        }
    }

    private boolean isNodeDeclared(AstNode node) {
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
        if(symbolTable.declaredFunctions.contains(node.getID())) {
            // Error handling here ...
        }
        else {
            // Create the function and add it to the symbol table
            SymbolAttributes attributes = new SymbolAttributes("function", node.getReturnType());
            attributes.setScope(symbolTable.getCurrentScope().getScopeName());
            symbolTable.insertSymbol(node.getID(), attributes);

            // Insert it into the declared functions
            symbolTable.declaredFunctions.add(node.getID());

            // Add the function's scope and its children
            symbolTable.addScope(node.getNodesHash());
            this.visitChildren(node);
            symbolTable.leaveScope();
        }
    }

    private void addPredefinedFunction(FuncCallNode node) {
        symbolTable.calledFunctions.add(node.getID());

        // If the function has already been called once, we remove it and add it again, as the number of parameters might be different
        if(symbolTable.declaredFunctions.contains(node.getID())) {
            symbolTable.declaredFunctions.remove(node.getID());
        }

        symbolTable.declaredFunctions.add(node.getID());

        // They all have the void return type
        SymbolAttributes attributes = new SymbolAttributes("function", "void");
        attributes.setScope(symbolTable.getCurrentScope().getScopeName());

        // Insert symbol
        symbolTable.insertSymbol(node.getID(), attributes);

        // Insert the scopes
        symbolTable.addScope("Func: " + node.getID());
        addPredefinedFunctionParams(node);
        symbolTable.leaveScope();
    }

    private void addPredefinedFunctionParams(FuncCallNode node) {
        visitPredefinedFunctionParameters(node);
        String scopeName = symbolTable.getCurrentScope().getScopeName();

        for (AstNode child : node.children){
            SymbolAttributes attributes = new SymbolAttributes("Formal Param", child.getType());
            attributes.setScope(scopeName);
            symbolTable.insertParam(child.getID(), attributes);
        }
    }

    private void visitPredefinedFunctionParameters(AstNode node) {
        // actual param = child
        for(AstNode child : node.children) {
            for(AstNode idChild : child.children) {
                if(idChild instanceof IDNode) {
                    SymbolAttributes attributes = symbolTable.lookupSymbol(idChild.getID());
                    child.setType(attributes.getDataType());
                }
            }
        }
    }


    @Override
    public void visit(FuncCallNode node) {
        String functionID = node.getID();

        // Add predefined function names here
        switch (functionID) {
            case "cut_line": case "cut_clockwise_circular": case "rapid_move":
                addPredefinedFunction(node);
                symbolTable.calledFunctions.add(functionID);
                return;
            default:
                break;
        }

        symbolTable.calledFunctions.add(functionID);

        this.visitChildren(node);
    }

    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PosAssignNode node) {
        this.visitChildren(node);
    }


    // Missing a check for if the node already exists
    @Override
    public void visit(ArrayDclNode node) {
        this.visitChildren(node);

        int arrayLength = node.children.size();

        SymbolAttributes attributes = new SymbolAttributes("array", node.getType(), arrayLength);
        attributes.setScope(symbolTable.getCurrentScope().getScopeName());

        symbolTable.insertSymbol(node.getID(), attributes);

    }

    @Override
    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SelectionNode node) {
        symbolTable.addScope(node.getNodesHash());
        this.visitChildren(node);
        symbolTable.leaveScope(node.getNodesHash());
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

        for (AstNode child : node.children){
            IDNode param = (IDNode)child;
            SymbolAttributes attributes = new SymbolAttributes("Formal Param", param.type);
            attributes.setScope(scopeName);
            symbolTable.insertParam(param.getID(), attributes);
        }
    }

    @Override
    public void visit(ActualParamNode node) {
        this.visitChildren(node);

        String scopeName = symbolTable.getCurrentScope().getScopeName();

        for (AstNode child : node.children) {
            SymbolAttributes attributes = new SymbolAttributes("Actual Param", child.getType());
            attributes.setScope(scopeName);
            attributes.setValue(child.getValue());
            symbolTable.insertParam(node.getID(), attributes);
        }
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
    public void visit(CompExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IDNode node) {
        this.visitChildren(node);

        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
        node.setType(attributes.getDataType());
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
    public void visit(LogicalOPNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(AddNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SubNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(DivNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(MultNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ModNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(LineCommentNode node) {
        this.visitChildren(node);
    }
}
