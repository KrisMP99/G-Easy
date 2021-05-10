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

    private final String filepath = "src/com/p4/output.GE";
    private final String dirpath = "src/com/p4";

    //String builder is used to construct the G code file -- output.GE
    private StringBuilder stringBuilder = new StringBuilder();
    private ArrayList<String> output = new ArrayList<>();
    private SymbolTable symbolTable;
    private CuttingHead cuttingHead = new CuttingHead(-10,0, "G21", "G90", "G94");
    private ProgNode progNode;


    public CodeVisitor(SymbolTable symbolTable, ProgNode ast){
        this.symbolTable = symbolTable;
        this.progNode = ast;

        //sets the default values
        stringBuilder.append("G17 " +
                cuttingHead.getUnit() + " " +
                cuttingHead.getCutMode() + " " +
                cuttingHead.getFeedRateMode() + " G54");

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
        node.setValue(node.children.get(1).getValue());

    }

    //Calls builtin functions and their own functions
    @Override
    public void visit(FuncCallNode node) {

        if(!node.getID().equals("set_units") && !node.getID().equals("set_cut_mode") && !node.getID().equals("set_feed_rate_mode")){
            this.visitChildren(node);
        }

        double iCord = cuttingHead.getXCord() * (-1);;
        double jCord = cuttingHead.getYCord() * (-1);
        double speed;


        String funcName = node.getID();
        List<String> params = getActualParamValues(node);

        if (funcName.equals("cut_line")){
            speed = Double.parseDouble(params.get(2));
            cutLine(Double.parseDouble(params.get(0)),
                    Double.parseDouble(params.get(1)),
                    speed);
            node.setValue("void");
        }
        else if(funcName.equals("cut_clockwise_circular")){
            speed = Double.parseDouble(params.get(2));
            cutClockwiseCircular(
                    Double.parseDouble(params.get(0)),
                    Double.parseDouble(params.get(1)), iCord, jCord, speed);
            node.setValue("void");
        }
        else if (funcName.equals("rapid_move")){
            rapidMove(Double.parseDouble(params.get(0)),
                    Double.parseDouble(params.get(1)));
            node.setValue("void");
        }
        else if (funcName.equals("set_units")){
            setUnits(params.get(0));
            node.setValue("void");
        }
        else if (funcName.equals("set_cut_mode")){
            setCutMode(params.get(0));
            node.setValue("void");
        }
        else if (funcName.equals("set_feed_rate_mode")){
            setFeedRateMode(params.get(0));
            node.setValue("void");
        }
        else {
            AstNode dclNode = lookupAstNode(funcName);
            node.setValue(dclNode.getValue());
        }
    }

    private String getActualParamString(FuncCallNode node){
        return node.children.get(0).children.get(0).getID();
    }

    private List<String> getActualParamValues(FuncCallNode node){
        List<String> paramValues = new ArrayList<>();

        switch (node.getID()) {
            case "set_units":
            case "set_cut_mode":
            case "set_feed_rate_mode":
                paramValues.add(getActualParamString(node));
                return paramValues;
            default:
                break;
        }

        List<AstNode> params = getParamsForBuildInFunction(node);

        for (AstNode child : params) {
            if (child instanceof IntDclNode || child instanceof DoubleDclNode){
                paramValues.add(child.children.get(0).toString());
            }
            else if (child instanceof IntNode || child instanceof DoubleNode) {
                paramValues.add(child.toString());
            }
            else if (child instanceof PosDclNode) {
                String[] posValues = child.getValue().split(" ");
                paramValues.add(posValues[0]);
                paramValues.add(posValues[1]);
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

    // Note: Skal gøres rekursiv så vi kigger alle noderne i gennem, også på børnene
    private AstNode lookupAstNode(String id){
        for(AstNode child : progNode.children) {
            if(child.getID().equals(id)) {
                return child;
            }
        }
        return null;
    }

    private void rapidMove(double x, double y) {
        stringBuilder.append("\nG00 X" + x
                + " Y" + y);
        output.add(getLine());
        cuttingHead.updateHeadPosition(x, y);
    }

    private void cutClockwiseCircular(double x, double y, double i, double j, double speed){
        stringBuilder.append("\nG2 X" + x
                + " Y" + y
                + " I" + i
                + " J" + j
                + " F" + speed);
        output.add(getLine());
        cuttingHead.updateHeadPosition(x, y);
    }

    private void cutLine(double x, double y, double speed){
        stringBuilder.append("\nG1 X" + x
                + " Y" + y
                + " F" + speed);
        output.add(getLine());
        cuttingHead.updateHeadPosition(x, y);
    }

    private void setFeedRateMode(String mode) {
        //Only enters, if the mode isn't already actual
        if (!cuttingHead.returnGEasyEquivalent(cuttingHead.getFeedRateMode()).equals(mode)){
            //Checks whether a valid mode has been chosen
            if (cuttingHead.setFeedRateMode(mode)){
                stringBuilder.append(cuttingHead.getFeedRateMode() + " ");
                output.add(getLine());
            }
        }
    }

    private void setCutMode(String mode) {
        //Only enters, if the mode isn't already actual
        if (!cuttingHead.returnGEasyEquivalent(cuttingHead.getCutMode()).equals(mode)){
            //Checks whether a valid mode has been chosen
            if (cuttingHead.setCutMode(mode)){
                stringBuilder.append(cuttingHead.getCutMode() + " ");
                output.add(getLine());
            }
        }
    }

    private void setUnits(String unit) {
        //Only enters, if the mode isn't already actual
        if (!cuttingHead.returnGEasyEquivalent(cuttingHead.getUnit()).equals(unit)){
            //Checks whether a valid mode has been chosen
            if (cuttingHead.setUnit(unit)){
                stringBuilder.append(" " + cuttingHead.getUnit());
                output.add(getLine());
            }
        }
    }

    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);
        AstNode childNode = lookupAstNode(node.getID());
        childNode.setValue(node.children.get(0).getValue());
        node.setValue(node.children.get(0).getValue());
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
        }
        else if (indexChild instanceof IDNode) {
            // Get the ID node:
            //AstNode idNode = lookupAstNode(indexChild.getID());
            node.setValue(indexChild.getValue());
        }
    }

    @Override
    public void visit(SelectionNode node) {
        this.visitChild(node.children.get(0));
        boolean logicalExpression = Boolean.parseBoolean(node.children.get(0).getValue());
        node.setValue(Boolean.toString(logicalExpression));

        //If there's both an if and else statement
        if (node.children.size() > 2) {
            if (logicalExpression) {
                //Visits if
                visitChildren(node.children.get(1));
                node.children.remove(2);
            }
            //Visits else
            else {
                visitChildren(node.children.get(2));
                node.children.remove(1);
            }
        }
        //If there's only an if
        else {
            if (logicalExpression){
                visitChildren(node.children.get(1));
            }
        }
    }

    @Override
    public void visit(IterativeNode node) {
        int startValue = Integer.parseInt(node.children.get(0).getValue());
        int endValue = Integer.parseInt(node.children.get(1).getValue());

        // revisit later
        IntNode startNode = (IntNode)node.children.get(0);
        IntNode endNode = (IntNode)node.children.get(1);

        if(startNode.isNegative) {
            startValue = startValue * (-1);
        }
        if(endNode.isNegative) {
            endValue = endValue * (-1);
        }

        if(startValue < endValue && endValue > 0) {
            startValue -= 1;
            while(startValue < endValue) {
                this.visitChildren(node.children.get(2));
                startValue++;
            }
        }
        else if(endValue < 0 && startValue > endValue){
            while(startValue > endValue) {
                this.visitChildren(node.children.get(2));
                startValue--;
            }
        }

    }

    @Override
    public void visit(LogicalExprNode node) {
        this.visitChildren(node);
        Boolean leftSide = Boolean.parseBoolean(node.children.get(0).getValue());
        Boolean rightSide = Boolean.parseBoolean(node.children.get(1).getValue());
        boolean result;

        switch (node.getToken()) {
            case GEasyParser.OR:
                result = leftSide || rightSide;
                break;
            case GEasyParser.AND:
                result = leftSide && rightSide;
                break;
            default:
                result = false;
                break;
        }
        node.setValue(Boolean.toString(result));
    }

    @Override
    public void visit(FormalParamNode node) {
        this.visitChildren(node);
        node.setValue(node.children.get(0).getValue());
    }

    @Override
    public void visit(ActualParamNode node) {
        this.visitChildren(node);
        node.setValue(node.children.get(0).getValue());

        if(symbolTable.lookupSymbol(node.getID()) != null) {
            SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
            attributes.setValue(node.children.get(0).getValue());
        }
    }

    @Override
    public void visit(BlockNode node) {
        this.visitChildren(node);

        boolean hasFoundReturn = false;

        // Go through all the children and look for an return statement
        for(AstNode childNode : node.children) {

            // There might be a return statement inside of an if-statement
            if(childNode instanceof SelectionNode && !hasFoundReturn) {
                // We look inside the block node (it's always the second child)
                for(AstNode ifChild : childNode.children.get(1).children) {
                    // look for the return expression
                    if(ifChild instanceof ReturnExprNode) {
                        node.setValue(ifChild.getValue());
                        hasFoundReturn = true;
                        break;
                    }
                }
            }

            // Find the return statement
            else if(childNode instanceof ReturnExprNode && !hasFoundReturn) {
                // Visit the return expression
                this.visitChild(childNode);

                // Set the value of the child to the block value
                node.setValue(childNode.getValue());
                break;
            }
        }

    }

    @Override
    public void visit(ReturnExprNode node) {
        this.visitChildren(node);
        node.setValue(node.children.get(0).getValue());
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
        node.setValue(node.children.get(0).getValue());
        System.out.println("ID: " + node.getID() + " value: " + node.getValue());
    }
  
    @Override
    public void visit(CompExprNode node) {
        this.visitChildren(node);
        double leftSide = Double.parseDouble(node.children.get(0).getValue());
        double rightSide = Double.parseDouble(node.children.get(1).getValue());
        boolean result;

        // Kommentar til Cecilie: Benyt GEasyparser i stedet for tallene
        // F.eks. GEasyparser.LESS_THAN -> evaluerer til 24
        switch (node.getToken()) {
            case GEasyParser.LESS_THAN:
                result = leftSide < rightSide;
                break;
            case GEasyParser.GREATER_THAN:
                result = leftSide > rightSide;
                break;
            case GEasyParser.LESS_THAN_EQ:
                result = leftSide <= rightSide;
                break;
            case GEasyParser.GREATER_THAN_EQ:
                result = leftSide >= rightSide;
                break;
            case GEasyParser.IS_EQ:
                result = leftSide == rightSide;
                break;
            case GEasyParser.NOT_EQ:
                result = leftSide != rightSide;
                break;
            default:
                result = false;
                break;
        }
        node.setValue(Boolean.toString(result));
    }

    @Override
    public void visit(IDNode node) {
        this.visitChildren(node);

        AstNode valNode = lookupAstNode(node.getID());

        // If it's null we check if it's a parameter
        if(valNode == null) {
            SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
            node.setValue(attributes.getValue());
        }

        // Handle the case if position
        else if(node.getType().equals("pos")) {
            node.setValue(valNode.getValue());
        } else {
            node.setValue(valNode.children.get(0).toString());
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
        System.out.println(node.getValue());
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
