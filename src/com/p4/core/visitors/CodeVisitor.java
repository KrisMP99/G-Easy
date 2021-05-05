package com.p4.core.visitors;

import com.p4.core.CuttingHead;
import com.p4.core.nodes.*;
import com.p4.core.symbolTable.Scope;
import com.p4.core.symbolTable.SymbolAttributes;
import com.p4.core.symbolTable.SymbolTable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

//This is the class that generates G code corresponding to the GEasy
public class CodeVisitor implements INodeVisitor {

    private String filepath = "src/com/p4/output.GE";
    private String dirpath = "src/com/p4";

    //String builder is used to construct the G code file
    private StringBuilder stringBuilder = new StringBuilder();
    private ArrayList<String> output = new ArrayList<>();
    private SymbolTable symbolTable;
    private CuttingHead cuttingHead = new CuttingHead(0,0);

    public CodeVisitor(SymbolTable symbolTable){
        this.symbolTable = symbolTable;
    }

    //Adds the string builder to the output file
    public void print() throws IOException {
        output.add(getLine());

        //adds the line to the string builder
        for (String line : output){
            stringBuilder.append(line);
        }

        File directory = new File(dirpath);

        //If the directory does not exist
        if (!directory.exists()){
            directory.mkdir();
        }

        File file = new File(filepath);

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        //Writes the string builder to the file. If none exist, it creates it.
        fileOutputStream.write(stringBuilder.toString().getBytes());
    }

    //Is able to get the string from the string builder, and afterward reset it
    private String getLine(){
        String line = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        return line;
    }
    

    @Override
    public void visitChildren(AstNode node) {
        for (AstNode child : node.children){
            child.accept(this);
        }
    }

    //calls the accept node on the given node
    public void visitChild(AstNode node){
        node.accept(this);
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
        this.visitChildren(node);
    }

    //Calls builtin functions and their own functions
    @Override
    public void visit(FuncCallNode node) {
        double xCord;
        double yCord;
        double iCord;
        double jCord;
        double speed;

        String funcName = node.getID().toLowerCase();
        List<Double> params = getParamsForBuildInFunction(node);

        if (funcName.equals("cut_line")){
            xCord = params.get(0);
            yCord = params.get(1);
            speed = params.get(2);

            cutLine(xCord, yCord, speed);
        }
        else if(funcName.equals("cut_clockwise_circular")){
            xCord = params.get(0);
            yCord = params.get(1);
            iCord = cuttingHead.getXCord() * -1;
            jCord = cuttingHead.getYCord() * -1;
            speed = params.get(2);

            cutclockwiseCircular(xCord, yCord, iCord, jCord, speed);
        }
        else if (funcName.equals("rapid_move")){
            xCord = params.get(0);
            yCord = params.get(1);

            rapidMove(xCord, yCord);
        }
        else { //If they've written their own functions

        }
    }

    private void rapidMove(double x, double y) {
        stringBuilder.append("G00 X" + x
                + " Y" + y
                + "\n");
        output.add(getLine());
    }

    private void cutclockwiseCircular(double x, double y, double i, double j, double speed){
        stringBuilder.append("G2 X" + x
                + " Y" + y
                + " I" + i
                + " J" + j
                + " F" + speed
                + "\n");
        output.add(getLine());
    }

    private void cutLine(double x, double y, double speed){
        stringBuilder.append("G1 X" + x
                + " Y" + y
                + " F" + speed
                + "\n");
        output.add(getLine());
    }

    private List<Double> getParamsForBuildInFunction(FuncCallNode node) {
        List<Double> params = new ArrayList<>();
        for (AstNode child : node.children){
            List<Double> childValues = getNodeValue(child);

            //child is a pos
            if (childValues.size() == 2){
                params.add(childValues.get(0));
                params.add(childValues.get(1));
            }

            //child is an int  or double
            else if (childValues.size() == 1){
                params.add(childValues.get(0));
            }
            else{
                return null;
            }
        }
        return params;
    }

    private List<Double> getNodeValue(AstNode node){
        List<Double> value = new ArrayList<>();
        String nodeType = getNodeType(node);

        switch (nodeType){
            case "int" :
            case "double" :
                value.add(Double.parseDouble(node.toString()));
                break;
            case "pos" :
                value.add(Double.parseDouble(node.children.get(0).toString()));
                value.add(Double.parseDouble(node.children.get(1).toString()));
                break;
            default:
                //error handling
        }
        return value;
    }

    private String getNodeType(AstNode node){
        return node.children.get(0).getType();
    }

    @Override
    public void visit(AssignNode node) {

    }

    @Override
    public void visit(ArrayDclNode node) {

        //SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
        //attributes.getArrayLength();

    }

    @Override
    public void visit(PosDclNode node) {

    }

    @Override
    public void visit(ArrayAccessNode node) {

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
    public void visit(CompExprNode node) {

    }

    @Override
    public void visit(IDNode node) {

    }

    @Override
    public void visit(BoolNode node) {

    }

    @Override
    public void visit(IntDclNode node) {

    }

    @Override
    public void visit(IntNode node) {

    }

    @Override
    public void visit(DoubleDclNode node) {

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

    @Override
    public void visit(LineCommentNode node) {

    }
}
