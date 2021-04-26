package com.p4.core.visitors;

import com.p4.core.nodes.*;
import com.p4.core.symbolTable.SymbolAttributes;
import com.p4.core.symbolTable.SymbolTable;

import java.util.HashMap;
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

            // If the returntype is void, a return statement is not needed.
            if (funcReturnType != "void"){


                for (AstNode blockNode : node.children.get(0).children){
                    if (blockNode instanceof ReturnExprNode){
                        if (!isEqualFunctionType(funcReturnType, blockNode.type)){
                            System.out.println("Wrong return type");
                        }
                    }
                }
            }
        }
        this.symbolTable.leaveScope();
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

    private boolean isEqualFunctionType(String type1, String type2){

        if (type1.equals(type2)){
            return true;
        }
        //if you have a double function, you can return an int
        else if (type1.equals("double") && type2.equals("int")){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void visit(FuncCallNode node) {
        this.visitChildren(node);
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
        node.type = node.children.get(0).type;
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
    public void visit(LogicalExprNode node) {
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
    public void visit(ReturnExprNode node) {
        this.visitChildren(node);
        node.type = node.children.get(0).type;
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
        Map<String, SymbolAttributes> params = symbolTable.getCurrentScope().getParams();
        SymbolAttributes paramAttributes = params.get(node.id);
        node.type = paramAttributes.getDataType();

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


    //Not sure what to do here
    @Override
    public void visit(LineCommentNode node) {
        this.visitChildren(node);
    }
}
