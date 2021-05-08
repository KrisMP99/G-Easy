package com.p4.core.visitors;

import com.p4.core.CuttingHead;
import com.p4.core.GEasyParser;
import com.p4.core.nodes.*;
import com.p4.core.symbolTable.SymbolAttributes;
import com.p4.core.symbolTable.SymbolTable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//This is the class that generates G code corresponding to the GEasy
public class CodeVisitor implements INodeVisitor {

    private String filepath = "src/com/p4/output.GE";
    private String dirpath = "src/com/p4";

    //String builder is used to construct the G code file -- output.GE
    private StringBuilder stringBuilder = new StringBuilder();
    private ArrayList<String> output = new ArrayList<>();
    private SymbolTable symbolTable;
    private CuttingHead cuttingHead = new CuttingHead(-10,0);
    private ProgNode progNode;


    public CodeVisitor(SymbolTable symbolTable, ProgNode ast){
        this.symbolTable = symbolTable;
        this.progNode = ast;

        //sets the default values
        stringBuilder.append("G17 G21 G90 G94 G54\n");
        output.add(getLine());
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
        this.visitChildren(node);

        double iCord = cuttingHead.getXCord() * (-1);;
        double jCord = cuttingHead.getYCord() * (-1);
        double speed;

        String funcName = node.getID().toLowerCase();
        List<Double> params = getActualParamValues(node);

        if (funcName.equals("cut_line")){
            cutLine(params.get(0), params.get(1), params.get(2));
        }
        else if(funcName.equals("cut_clockwise_circular")){
            speed = Double.parseDouble(params.get(2).toString());
            cutClockwiseCircular(params.get(0), params.get(1), iCord, jCord, speed);
        }
        else if (funcName.equals("rapid_move")){
            rapidMove(params.get(0), params.get(1));
        }
        else { //If they've written their own functions

        }
    }

    private List<Double> getActualParamValues(FuncCallNode node){
        List<AstNode> params = getParamsForBuildInFunction(node);
        List<Double> paramValues = new ArrayList<>();

        for (AstNode child : params) {
            if (child instanceof IntDclNode || child instanceof DoubleDclNode){
                paramValues.add(Double.parseDouble(child.children.get(0).toString()));
            }
            else if (child instanceof IntNode || child instanceof DoubleNode) {
                paramValues.add(Double.parseDouble(child.toString()));
            }
            else if (child instanceof PosDclNode) {
                String[] posValues = node.getValue().split(" ");
                paramValues.add(Double.parseDouble(posValues[0]));
                paramValues.add(Double.parseDouble(posValues[1]));
            }
        }
        return paramValues;
    }

    private List<AstNode> getParamsForBuildInFunction(FuncCallNode node) {
        List<AstNode> params = new ArrayList<>();

        for (AstNode paramChild : node.children){
            for (AstNode childNode : paramChild.children){
                if (childNode instanceof IDNode){
                    params.add(lookupAstNode(childNode.getID()));
                }
                else {
                    params.add(childNode);
                }
            }
        }
        return params;
    }

    private AstNode lookupAstNode(String id){
        for (AstNode child : progNode.children){
            if(child.getID().equals(id)){
                return child;
            }
        }
        return null;
    }

    private void rapidMove(double x, double y) {
        stringBuilder.append("G00 X" + x
                + " Y" + y
                + "\n");
        output.add(getLine());
        cuttingHead.updateHeadPosition(x, y);
    }

    private void cutClockwiseCircular(double x, double y, double i, double j, double speed){
        stringBuilder.append("G2 X" + x
                + " Y" + y
                + " I" + i
                + " J" + j
                + " F" + speed
                + "\n");
        output.add(getLine());
        cuttingHead.updateHeadPosition(x, y);
    }

    private void cutLine(double x, double y, double speed){
        stringBuilder.append("G1 X" + x
                + " Y" + y
                + " F" + speed
                + "\n");
        output.add(getLine());
        cuttingHead.updateHeadPosition(x, y);
    }

    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PosAssignNode node) {

    }

    @Override
    public void visit(ArrayDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PosDclNode node) {
        this.visitChildren(node);

        if(node.children.get(0).getType().equals("pos")) {
            node.setValue(node.children.get(0).getValue());
        } else {
            node.setValue(node.children.get(0).getValue() + " " + node.children.get(1).getValue());
        }
    }

    @Override
    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);
        // Get the dcl node when the array was declared
        AstNode arrayDclNode = lookupAstNode(node.getID());

        // Get the index
        // The index might be represented as an int or as an ID
        AstNode indexNode = node.children.get(0);
        int index;

        if(indexNode instanceof IDNode) {
            index = Integer.parseInt(indexNode.getValue());
        }
        else {
            index = Integer.parseInt(indexNode.toString());
        }

        // Get the child node in the array by the index
        AstNode indexChild = arrayDclNode.children.get(index);

        // The child can either be an ID, int or double
        // If is an int or double we can just look up the value on the node itself
        if(indexChild instanceof IntNode || indexChild instanceof DoubleNode) {
            node.setValue(indexChild.getValue());
            System.out.println("Int/double: " + indexChild.getValue());
        }
        else if (indexChild instanceof IDNode) {
            // Get the ID node:
            //AstNode idNode = lookupAstNode(indexChild.getID());
            node.setValue(indexChild.getValue());
            System.out.println("IDnode: " + indexChild.getValue());
        }

        // test
        System.out.println("ArrayAccess value: " + node.getValue());

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
        Boolean leftSide = Boolean.parseBoolean(node.children.get(0).getValue());
        Boolean rightSide = Boolean.parseBoolean(node.children.get(1).getValue());
        boolean result;

        switch (node.getToken()) {
            case GEasyParser.OR -> {
                result = leftSide || rightSide;
            }
            case GEasyParser.AND -> {
                result = leftSide && rightSide;
            }
            default -> result = false;
        }
        node.setValue(Boolean.toString(result));
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
    public void visit(BoolDclNode node) {
        this.visitChildren(node);
    }
  
    @Override
    public void visit(CompExprNode node) {
        this.visitChildren(node);
        double leftSide = Double.parseDouble(node.children.get(0).getValue());
        double rightSide = Double.parseDouble(node.children.get(1).getValue());
        boolean result;

        switch (node.getToken()) {
            case GEasyParser.LESS_THAN -> {
                result = leftSide < rightSide;
            }
            case GEasyParser.GREATER_THAN -> {
                result = leftSide > rightSide;
            }
            case GEasyParser.LESS_THAN_EQ -> {
                result = leftSide <= rightSide;
            }
            case GEasyParser.GREATER_THAN_EQ -> {
                result = leftSide >= rightSide;
            }
            case GEasyParser.IS_EQ -> {
                result = leftSide == rightSide;
            }
            case GEasyParser.NOT_EQ -> {
                result = leftSide != rightSide;
            }
            default -> result = false;
        }
        node.setValue(Boolean.toString(result));
    }

    @Override
    public void visit(IDNode node) {
        this.visitChildren(node);

        AstNode idDclNode = lookupAstNode(node.getID());

        // If it's null we check if it's a formal parameter
        if(idDclNode == null) {


            SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
            String scopeName = attributes.getScope();
            System.out.println(scopeName);

            // Now we need to see if the function has been called some where, so we can set it's value.


        }

        // Handle the case if position
        if(node.getType().equals("pos")) {
            node.setValue(idDclNode.getValue());
        } else {
            node.setValue(idDclNode.children.get(0).toString());
        }
    }

    @Override
    public void visit(BoolNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IntDclNode node) {
        this.visitChildren(node);
        node.setValue(node.children.get(0).getValue());
    }

    @Override
    public void visit(IntNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(DoubleDclNode node) {
        this.visitChildren(node);
        node.setValue(node.children.get(0).getValue());
    }

    @Override
    public void visit(DoubleNode node) {
        this.visitChildren(node);
    }

    // Only used in PosNode (for now)
    // Returns true if the given node CLASS NAME is of type IntNode or DoubleNode
    private boolean isNumberNode(String nodeType) {
        if(nodeType.equals("IntNode") || nodeType.equals("DoubleNode")){
            return true;
        }

        return false;
    }

    @Override
    public void visit(LogicalOPNode node) {
        this.visitChildren(node);

    }

    @Override
    public void visit(AddNode node) {
        this.visitChildren(node);
        double result = 0.0;
        double rightSide = Double.parseDouble(node.children.get(0).getValue());
        double leftSide = Double.parseDouble(node.children.get(1).getValue());

        result = rightSide + leftSide;
        node.setValue(Double.toString(result));
    }

    @Override
    public void visit(SubNode node) {
        this.visitChildren(node);
        double result = 0.0;
        double rightSide = Double.parseDouble(node.children.get(0).getValue());
        double leftSide = Double.parseDouble(node.children.get(1).getValue());

        result = rightSide - leftSide;
        node.setValue(Double.toString(result));
    }

    @Override
    public void visit(DivNode node) {
        this.visitChildren(node);
        double result = 0.0;
        double rightSide = Double.parseDouble(node.children.get(0).getValue());
        double leftSide = Double.parseDouble(node.children.get(1).getValue());

        result = rightSide / leftSide;
        node.setValue(Double.toString(result));
    }

    @Override
    public void visit(MultNode node) {
        this.visitChildren(node);

        // Handle if pos
        if(node.children.get(0).getType().equals("pos")) {
            String[] stringValues = node.children.get(0).getValue().split(" ");
            double xCordValue = Double.parseDouble(stringValues[0]);
            double yCordValue = Double.parseDouble(stringValues[1]);
            double rightSide = Double.parseDouble(node.children.get(1).getValue());
            String posResult = xCordValue * rightSide + " " + yCordValue * rightSide;

            node.setValue(posResult);

        } else if(node.children.get(1).getType().equals("pos")) {
            String[] stringValues = node.children.get(1).getValue().split(" ");
            double xCordValue = Double.parseDouble(stringValues[0]);
            double yCordValue = Double.parseDouble(stringValues[1]);
            double leftSide = Double.parseDouble(node.children.get(0).getValue());
            String posResult = xCordValue * leftSide + " " + yCordValue * leftSide;

            node.setValue(posResult);

        } else {
            double result = 0.0;
            double rightSide = Double.parseDouble(node.children.get(0).getValue());
            double leftSide = Double.parseDouble(node.children.get(1).getValue());

            result = rightSide * leftSide;
            node.setValue(Double.toString(result));
        }
    }

    @Override
    public void visit(ModNode node) {
        this.visitChildren(node);
        double result = 0.0;
        double rightSide = Double.parseDouble(node.children.get(0).getValue());
        double leftSide = Double.parseDouble(node.children.get(1).getValue());

        result = rightSide % leftSide;
        node.setValue(Double.toString(result));
    }

    @Override
    public void visit(LineCommentNode node) {
        this.visitChildren(node);
    }
}
