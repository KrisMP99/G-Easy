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
    private final String dirpath = "src/com/p4/";

    //String builder is used to construct the G code file -- output.GE
    private StringBuilder stringBuilder = new StringBuilder();
    private ArrayList<String> output = new ArrayList<>();
    private SymbolTable symbolTable;
    private CuttingHead cuttingHead = new CuttingHead(0, 0, "G21", "G90", "G94");


    public CodeVisitor(SymbolTable symbolTable){
        this.symbolTable = symbolTable;

        //sets the default values
        stringBuilder.append("G17 " +
                cuttingHead.getUnit() + " " +
                cuttingHead.getCutMode() + " " +
                cuttingHead.getFeedRateMode() + " G54");

        output.add(getLine());
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
    public void visit(ProgNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(DclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(FuncDclNode node) {
    }

    //Calls built in functions and their own functions
    @Override
    public void visit(FuncCallNode node) {
        String id = node.getID();
        if(!id.equals("set_units") && !id.equals("set_cut_mode") && !id.equals("set_feed_rate_mode")) {
            this.visitChildren(node);
        }

        String funcName = node.getID();
        double speed;

        // First get the actual params in order they appear
        List<String> params = getActualParamValues(node);

        if (funcName.equals("cut_line")){
            speed = Double.parseDouble(params.get(2));
            cutLine(Double.parseDouble(params.get(0)),
                    Double.parseDouble(params.get(1)),
                    speed);
            node.setValue("void");
        }
        else if(funcName.equals("cut_clockwise_circular")){
            speed = Double.parseDouble(params.get(4));
            double iCord = Double.parseDouble(params.get(2));
            double jCord = Double.parseDouble(params.get(3));

            cutClockwiseCircular(
                    Double.parseDouble(params.get(0)),
                    Double.parseDouble(params.get(1)), iCord, jCord, speed);
            node.setValue("void");
        }
        else if (funcName.equals("rapid_move")){
            rapidMove(Double.parseDouble(params.get(0)), Double.parseDouble(params.get(1)));
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
            callFunction(node);
        }
    }

    private void callFunction(AstNode funcCallNode) {
        // First we look for the func dcl node
        SymbolAttributes attributes = symbolTable.lookupSymbol(funcCallNode.getID());
        AstNode funcDcl = attributes.getNode();

        List<AstNode> actualParamsList = new ArrayList<>();

        // Add the actual params to a list
        for(AstNode child : funcCallNode.children) {
            if(child instanceof ActualParamNode) {
                this.visitChild(child);
                actualParamsList.add(child);
            }
        }

        // We now replace the node's formal parameters with the values from the actual parameter
        for(int i = 0; i < funcDcl.children.size(); i++) {
            if(funcDcl.children.get(i) instanceof FormalParamNode) {
                this.symbolTable.enterScope(funcDcl.getNodesHash());
                // Look the parameter up in the symbol table
                SymbolAttributes attributesParam = symbolTable.lookupSymbol(funcDcl.children.get(i).getID());
                attributesParam.setValue(actualParamsList.get(i).getValue());
                this.symbolTable.leaveScope();
            }
        }

        // We can now call generate the function
        generateFunction(funcDcl);

        // Update the value of the func call node
        funcCallNode.setValue(funcDcl.getValue());

        // Update the value of the called function?
        SymbolAttributes attributesFuncCall = symbolTable.lookupSymbol(funcCallNode.getID());
        attributesFuncCall.setValue(funcDcl.getValue());

    }

    private void generateFunction(AstNode node) {
        // Enter the scope of the function
        this.symbolTable.enterScope(node.getNodesHash());

        // The block node has the return value of function
        for(int i = 0; i < node.children.size(); i++) {
            if(node.children.get(i) instanceof BlockNode) {
                this.visitChild(node.children.get(i));
                node.setValue(node.children.get(i).getValue());
            }
        }

        this.symbolTable.leaveScope();
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
                paramValues.add(child.children.get(0).getValue());
            }
            else if (child instanceof IntNode || child instanceof DoubleNode) {
                paramValues.add(child.getValue());
            }
            else if (child instanceof IDNode) {
                if(child.getType().equals("pos")) {
                    String[] posValues = child.getValue().split(" ");
                    paramValues.add(posValues[0]);
                    paramValues.add(posValues[1]);
                } else {
                    paramValues.add(child.getValue());
                }
            }
            else if(child instanceof ArrayDclNode) {
                paramValues.add(child.children.get(0).getValue());
            }
            else {
                paramValues.add(child.getValue());
            }
        }
        return paramValues;
    }

    private List<AstNode> getParamsForBuildInFunction(FuncCallNode node) {
        List<AstNode> params = new ArrayList<>();

        // ParamChild = actual params
        for (AstNode paramChild : node.children){
            for (AstNode childNode : paramChild.children){
                if (childNode instanceof IDNode){
                    params.add(childNode);
                }
                else if(childNode instanceof ArrayAccessNode) {
                    // Look up the node
                    SymbolAttributes attributes = symbolTable.lookupSymbol(childNode.getID());
                    AstNode arrayDclNode = attributes.getNode();

                    int valueToAccess;

                    valueToAccess = (int)Double.parseDouble(childNode.children.get(0).getValue());

                    AstNode arrayValueNode = arrayDclNode.children.get(valueToAccess);

                    params.add(arrayValueNode);
                }
                else {
                    params.add(childNode);
                }
            }
        }
        return params;
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
                output.set(0, "G17 " + cuttingHead.getUnit() + " " +
                cuttingHead.getCutMode() + " " +
                cuttingHead.getFeedRateMode() + " G54");
            }
        }
    }

    private void setCutMode(String mode) {
        //Only enters, if the mode isn't already actual
        if (!cuttingHead.returnGEasyEquivalent(cuttingHead.getCutMode()).equals(mode)){
            //Checks whether a valid mode has been chosen
            if (cuttingHead.setCutMode(mode)){
                output.set(0, "G17 " + cuttingHead.getUnit() + " " +
                cuttingHead.getCutMode() + " " +
                cuttingHead.getFeedRateMode() + " G54");
            }
        }
    }

    private void setUnits(String unit) {
        //Only enters, if the mode isn't already actual
        if (!cuttingHead.returnGEasyEquivalent(cuttingHead.getUnit()).equals(unit)){
            //Checks whether a valid mode has been chosen
            if (cuttingHead.setUnit(unit)){
                output.set(0, "G17 " + cuttingHead.getUnit() + " " +
                cuttingHead.getCutMode() + " " +
                cuttingHead.getFeedRateMode() + " G54");
            }
        }
    }

    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);
        node.setValue(node.children.get(0).getValue());
    }

    @Override
    public void visit(PosAssignNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(ArrayDclNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(PosDclNode node) {
        this.visitChildren(node);

        // Get the pos from the symbol table
        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());


        if(node.children.get(0).getType().equals("pos")) {
            attributes.setValue(node.children.get(0).getValue());
            node.setValue(node.children.get(0).getValue());
        } else {
            attributes.setValue(node.children.get(0).getValue() + " " + node.children.get(1).getValue());
            node.setValue(node.children.get(0).getValue() + " " + node.children.get(1).getValue());
        }
    }

    @Override
    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);

        // Get the dcl node when the array was declared
        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
        AstNode arrayDclNode = attributes.getNode();

        // Get the index
        // The index might be represented as an int or as an ID
        AstNode indexNode = node.children.get(0);
        int index;

        if(indexNode instanceof IDNode) {
            index = Integer.parseInt(indexNode.getValue());
        }
        else {
            index = (int)Math.round(Double.parseDouble(indexNode.getValue()));
        }

        // Get the child node in the array by the index
        AstNode indexChild = arrayDclNode.children.get(index);

        // The child can either be an ID, int or double
        // If is an int or double we can just look up the value on the node itself
        if(indexChild instanceof IntNode || indexChild instanceof DoubleNode) {
            node.setValue(indexChild.getValue());
        }
        else if (indexChild instanceof IDNode) {
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

                // we remove the else child, as it will not be run
                node.children.remove(2);
            }
            //Visits else
            else {
                visitChildren(node.children.get(2));

                // We remove the if child, as it will not be run
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
        this.symbolTable.enterScope(node.getNodesHash());
        AstNode startValueNode = node.children.get(0);
        AstNode endValueNode = node.children.get(1);

        this.visitChild(startValueNode);
        this.visitChild(endValueNode);


        int startValue = Integer.parseInt(startValueNode.getValue());
        int endValue = Integer.parseInt(endValueNode.getValue());

        if(startValue <= endValue) {
            while(startValue <= endValue) {
                this.visitChildren(node.children.get(2));
                startValue++;

                if(startValueNode instanceof IDNode) {
                    updateValue(startValueNode, startValue);
                }
            }
        }
        else if(startValue >= endValue) {
            while(startValue >= endValue) {
                this.visitChildren(node.children.get(2));
                startValue--;

                if(startValueNode instanceof IDNode) {
                    updateValue(startValueNode, startValue);
                }
            }
        }
        this.symbolTable.leaveScope();
    }

    private void updateValue(AstNode node, int value) {
        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
        attributes.setValue(Integer.toString(value));
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

        //if(symbolTable.lookupSymbol(node.getID()) != null) {
            //SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
            //attributes.setValue(node.children.get(0).getValue());
        //}
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

        if(node.children.get(0) instanceof IDNode) {
            SymbolAttributes attributes = symbolTable.lookupSymbol(node.children.get(0).getID());
            attributes.setValue(node.getValue());
        }

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
        double leftSide = Double.parseDouble(node.children.get(0).getValue());
        double rightSide = Double.parseDouble(node.children.get(1).getValue());
        boolean result;


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

        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());

        node.setValue(attributes.getValue());

    }

    @Override
    public void visit(BoolDclNode node) {
        this.visitChildren(node);
        // look up the node in the symbol table
        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());

        // If we could find it, we update it's value
        attributes.setValue(node.children.get(0).getValue());
        node.setValue(node.children.get(0).getValue());
    }

    @Override
    public void visit(BoolNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(IntDclNode node) {
        this.visitChildren(node);
        // look up the node in the symbol table
        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());

        // If we could find it, we update it's value
        attributes.setValue(node.children.get(0).getValue());
        node.setValue(node.children.get(0).getValue());
    }

    @Override
    public void visit(IntNode node) {
        // Check if the node is negative
        if(node.isNegative && !node.getValue().contains("-")) {
            node.setValue("-" + node.getValue());
        }
    }

    @Override
    public void visit(DoubleDclNode node) {
        this.visitChildren(node);
        // look up the node in the symbol table
        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());

        // If we could find it, we update it's value
        attributes.setValue(node.children.get(0).getValue());
        node.setValue(node.children.get(0).getValue());
    }

    @Override
    public void visit(DoubleNode node) {
        // Check if the node is negative
        if(node.isNegative && !node.getValue().contains("-")) {
            node.setValue("-" + node.getValue());
        }
    }

    @Override
    public void visit(LogicalOPNode node) {
        this.visitChildren(node);

    }

    @Override
    public void visit(AddNode node) {
        this.visitChildren(node);

        if (node.children.get(0).getType().equals("pos") && node.children.get(1).getType().equals("pos")) {
            String[] stringValues1 = node.children.get(0).getValue().split(" ");
            double xCordValue1 = Double.parseDouble(stringValues1[0]);
            double yCordValue1 = Double.parseDouble(stringValues1[1]);

            String[] stringValues2 = node.children.get(1).getValue().split(" ");
            double xCordValue2 = Double.parseDouble(stringValues2[0]);
            double yCordValue2 = Double.parseDouble(stringValues2[1]);

            String posResult = (xCordValue1 + xCordValue2) + " " + (yCordValue1 + yCordValue2);
            node.setValue(posResult);
        }
        else {
            double result = 0.0;
            double rightSide = Double.parseDouble(node.children.get(0).getValue());
            double leftSide = Double.parseDouble(node.children.get(1).getValue());

            result = rightSide + leftSide;
            node.setValue(Double.toString(result));
        }
    }

    @Override
    public void visit(SubNode node) {
        this.visitChildren(node);

        if(node.children.get(0).getType().equals("pos") && node.children.get(1).getType().equals("pos")) {
            String[] stringValues1 = node.children.get(0).getValue().split(" ");
            double xCordValue1 = Double.parseDouble(stringValues1[0]);
            double yCordValue1 = Double.parseDouble(stringValues1[1]);

            String[] stringValues2 = node.children.get(1).getValue().split(" ");
            double xCordValue2 = Double.parseDouble(stringValues2[0]);
            double yCordValue2 = Double.parseDouble(stringValues2[1]);

            String posResult = (xCordValue1 - xCordValue2) + " " + (yCordValue1 - yCordValue2);
            node.setValue(posResult);
        }
        else {
            double result = 0.0;
            double rightSide = Double.parseDouble(node.children.get(0).getValue());
            double leftSide = Double.parseDouble(node.children.get(1).getValue());

            result = rightSide - leftSide;
            node.setValue(Double.toString(result));
        }
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
