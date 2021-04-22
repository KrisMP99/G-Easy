package com.p4.core.visitors;

import com.p4.core.nodes.*;
import com.p4.core.symbolTable.SymbolTable;

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

        String funcReturnType = symbolTable.lookupSymbol(node.getID()).getDataType();

        //Checks if the return type is a valid
        if (isValidReturnType(funcReturnType)){

            if (funcReturnType != "void"){

                for (AstNode blockNode : node.children){
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

    }

    @Override
    public void visit(AssignNode node) {

    }

    @Override
    public void visit(ArrayDclNode node) {

    }

    @Override
    public void visit(PosDclNode node) {

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
    public void visit(BoolDclNode node) {

    }

    @Override
    public void visit(BoolExprNode node) {

    }

    @Override
    public void visit(CompExprNode node) {

    }

    @Override
    public void visit(IDNode node) {
        this.visitChildren(node);
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
