package com.p4.core.visitors;

import com.p4.core.nodes.*;
import com.p4.core.symbolTable.Scope;
import com.p4.core.symbolTable.SymbolAttributes;
import com.p4.core.symbolTable.SymbolTable;

import java.util.List;
import java.util.Map;

public class SemanticsVisitor implements INodeVisitor {
    SymbolTable symbolTable;

    public SemanticsVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public void visitChildren(AstNode node) {
        for (AstNode child : node.children) {
            child.accept(this);
        }
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
        this.symbolTable.enterScope(node.getNodesHash());
        this.visitChildren(node);

        // Get the return type of the function
        String funcReturnType = symbolTable.lookupSymbol(node.getID()).getDataType();

        //Checks if the return type is a valid
        if (isValidReturnType(funcReturnType)){

            int childIndex = node.getChildren().size() > 1 ? 1 : 0;

            // Goes through all the children in the function block to check if they're well typed
            // Looks for a return statement as well.
            for(AstNode blockChild : node.children.get(childIndex).children) {
                if(blockChild instanceof ReturnExprNode) {

                    // If the return type is void, there must not be a return statement
                    if(funcReturnType.equals("void")) {
                        System.out.println("A function of type void cannot have a return statement");
                    }
                    // Check if the return type is well typed
                    else if(!blockChild.type.equals(funcReturnType)) {
                        // error!!!
                        System.out.println("Return type not valid!");
                    }
                }
            }
        }
        this.symbolTable.leaveScope();
    }

    @Override
    public void visit(ReturnExprNode node) {
        this.visitChildren(node);
        node.type = node.children.get(0).type;
    }

    private boolean isValidReturnType(String returnType){
        switch (returnType){
            case "int" :
            case "double":
            case "bool" :
            case "void":
                return true;
            default:
                return false;
        }
    }

    @Override
    public void visit(FuncCallNode node) {
        this.visitChildren(node);

        String functionID = node.getID();
        int child = 0;

        // First we check if the function has been declared
        if(symbolTable.declaredFunctions.contains(functionID)) {

            // Now we need to check if there are the same number of actual and formal parameters
            Scope funcScope = this.symbolTable.lookupScope("Func: " + functionID);

            // If the function is found:
            if (funcScope != null) {
                if(node.children.size() != funcScope.getParams().size()) {
                    // Error
                    System.out.println("Number of params does not correspond!");
                }
                else {
                    // Now we need to check if the parameters are valid
                    // We do this by going through all the parameters and compare each actual parameter with the formal parameters
                    for(Map.Entry<String, SymbolAttributes> formalParams : funcScope.getParams().entrySet()) {
                        String actualParamType = node.children.get(child).type;
                        String formalParamType = formalParams.getValue().getDataType();
                        String actualParamID = node.children.get(child).getID(); // Does this work?

                        if(actualParamType == null || actualParamType.equals("error")){
                            // error
                            System.out.println("The actual params has no valid type");
                        }
                        else if(formalParamType != null) {
                            if(!formalParamType.equals(actualParamType)){
                                // Error if they're not equal
                                System.out.println("Actual parameter does not match type of the formal parameter");
                            }
                        }
                        child++;
                    }
                }
            }
        }
    }

    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PosDclNode node) {
        this.visitChildren(node);
    }

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
    public void visit(LogicalExprNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(SelectionNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IterativeNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FormalParamNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ActualParamNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(BlockNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArithmeticNode node) {

    }

    @Override
    public void visit(CompNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(BoolDclNode node) {
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
        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
        if(attributes == null) {
            // Error handling here
            // The variable could not be found in the scope (local + global)
            System.out.println("Could not find variable: " + node.getID() + " in the scope");
        }
        else {
            node.type = attributes.getDataType();
        }
    }

    @Override
    public void visit(BoolNode node) {
        node.setType("bool");
    }

    @Override
    public void visit(IntDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IntNode node) {
        node.type = "int";
    }

    @Override
    public void visit(DoubleDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(DoubleNode node) {
        node.type = "double";
    }

    @Override
    public void visit(PosNode node) {
        node.type = "pos";
    }

    @Override
    public void visit(LogicalOPNode node) {
        this.visitChildren(node);

    }

    @Override
    public void visit(AddNode node) {

    }

    @Override
    public void visit(SubNode node) {

    }

    @Override
    public void visit(DivNode node) {

    }

    @Override
    public void visit(MultNode node) {

    }

    @Override
    public void visit(ModNode node) {

    }


    //Not sure what to do here
    @Override
    public void visit(LineCommentNode node) {
        this.visitChildren(node);
    }
}
