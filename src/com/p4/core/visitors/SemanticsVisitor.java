package com.p4.core.visitors;

import com.p4.core.GEasyParser;
import com.p4.core.errorHandling.ErrorCollector;
import com.p4.core.errorHandling.ErrorType;
import com.p4.core.nodes.*;
import com.p4.core.symbolTable.Scope;
import com.p4.core.symbolTable.SymbolAttributes;
import com.p4.core.symbolTable.SymbolTable;

import java.util.List;
import java.util.Map;

public class SemanticsVisitor implements INodeVisitor {
    SymbolTable symbolTable;
    ErrorCollector errorCollector;


    public SemanticsVisitor(SymbolTable symbolTable, ErrorCollector errorCollector) {
        this.symbolTable = symbolTable;
        this.errorCollector = errorCollector;
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
                        errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("void return", blockChild.getType(), funcReturnType), blockChild.lineNumber);
                    }
                    // Check if the function return type is valid with the actual return type
                    else if(!isReturnOK(funcReturnType, blockChild.type)) {
                        // error!!!
                        errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("return", blockChild.getType(), funcReturnType), blockChild.lineNumber);
                    }
                }
            }
        }
        this.symbolTable.leaveScope();
    }

    // Used to compare the return type of the function and its return statements
    // Also used in dcl
    private boolean isReturnOK(String funcReturnType, String actualReturnType) {
        if(funcReturnType.equals(actualReturnType)) {
            return true;
        }
        else if(funcReturnType.equals("double") && actualReturnType.equals("int")) {
            return true;
        }
        else {
            return false;
        }
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

        // First we check if the function has been declared
        if(symbolTable.declaredFunctions.contains(node.getID())) {
            SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
            node.setType(attributes.getDataType());

            // Check the functions params
            checkNumberOfFunctionParams(node);

        }
        else {
            errorCollector.addErrorEntry(ErrorType.UNDECLARED_FUNCTION, printErrorMessage("func dcl not found", node.getID()), node.lineNumber);
        }
    }

    private void checkNumberOfFunctionParams(FuncCallNode node) {
        // First we check if the scope is found
        Scope funcScope = this.symbolTable.lookupScope("Func: " + node.getID());

        if (funcScope != null) {
            // Check if the number of actual params corresponds with the number of formal params
            if(node.children.size() != funcScope.getParams().size()) {
                // Error
                errorCollector.addErrorEntry(ErrorType.PARAMETER_ERROR, printErrorMessage("number of params", node.getID()), node.lineNumber);
            }
            else {
                checkIfParamsAreValid(node, funcScope);
            }
        }
    }

    private void checkIfParamsAreValid(FuncCallNode node, Scope funcScope) {
        // Go through all the parameters and compare each actual parameter with the formal parameters
        int child = 0;
        for(Map.Entry<String, SymbolAttributes> formalParams : funcScope.getParams().entrySet()) {
            String actualParamType = node.children.get(child).type;
            String actualParamID = node.children.get(child).getID();

            String formalParamType = formalParams.getValue().getDataType();
            String formalParamID = formalParams.getKey();

            if(actualParamType == null || actualParamType.equals("error")){
                errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("non-valid type", actualParamType), node.lineNumber);
            }
            else if(formalParamType != null) {
                if(!isReturnOK(formalParams.getValue().getDataType(), node.children.get(child).type)) {
                    errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("actual parameter type", actualParamID, actualParamType, formalParamType), node.lineNumber);
                }
                else {
                    // Check the names of the parameters
                    checkParamID(formalParamID, actualParamID, node.lineNumber);
                }
            }
            child++;
        }
    }

    // Checks if the name of the actual parameter in a func call is the same as the name of the formal parameter in the func dcl
    private void checkParamID(String formalParamID, String actualParamID, int lineNumber) {
        // Make the two strings to lowercase
        String formalLower = formalParamID.toLowerCase();
        String actualLower = actualParamID.toLowerCase();

        // Check if they're equal
        if(!actualLower.equals(formalLower)) {
            // Error
            errorCollector.addErrorEntry(ErrorType.PARAMETER_ERROR, printErrorMessage("actual parameter name", actualParamID, formalParamID), lineNumber);
        }
    }


    @Override
    public void visit(AssignNode node) {
        this.visitChildren(node);

        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
        node.type = attributes.getDataType();
        String rightType = node.children.get(0).getType();

        if(!isReturnOK(node.type, rightType)) {
            errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("assign", node.getType(), rightType), node.lineNumber);
        }

    }

    @Override
    public void visit(ArrayDclNode node) {
        this.symbolTable.enterScope(node.getNodesHash());
        this.visitChildren(node);
        this.symbolTable.leaveScope();

        String leftType = node.getType();
        node.setType(leftType);

        // Get the array elements
        List<AstNode> arrayElements = node.getChildren();

        for(AstNode arrayElement : arrayElements) {
            String type = arrayElement.getType();

            if(!isReturnOK(leftType, type)) {
                errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("array assign", type, leftType), node.lineNumber);
            }
        }
    }

    @Override
    public void visit(PosDclNode node) {
        this.visitChildren(node);

        String leftType = node.type;
        String rightType = node.children.get(0).getType();

        checkIfTypeDCLisCorrect(leftType, rightType, node.lineNumber);

        if(node.children.get(0).getID() != null) {
            checkPosDclOperation(node);
        }
    }

    private void checkPosDclOperation(PosDclNode node) {
        String operation = node.children.get(0).getID(); // +, -, *, /, %
        String leftType = node.children.get(0).children.get(0).getType();     // Get the type of left operand
        String rightType = node.children.get(0).children.get(1).getType();    // Get the type of right operand


        // You can't multiply, divide or do mod on two posistions
        if(operation.equals("mult")) {
            if((leftType.equals("pos") && (rightType.equals("int") || rightType.equals("double"))) ||
                rightType.equals("pos") && (leftType.equals("int") || leftType.equals("double"))) {
                // Operation OK
            }
            else {
                // Operation not OK
                errorCollector.addErrorEntry(ErrorType.OPERATION_ERROR, printErrorMessage("pos multiply"), node.lineNumber);
            }
        }
        // You can only add or subtract to positions
        else if(operation.equals("add") || operation.equals("sub")) {
            if(leftType.equals("pos") && rightType.equals("pos")) {
                // Operation OK
            } else {
                errorCollector.addErrorEntry(ErrorType.OPERATION_ERROR, printErrorMessage("pos add-sub"), node.lineNumber);
            }
        }

    }

    @Override
    public void visit(PosNode node) {
        node.type = "pos";

        // We need to make sure that the ID of the x- and y-coordinate are 'x' and 'y'
        if(!(node.getxID().equalsIgnoreCase("x") && node.getyID().equalsIgnoreCase("y"))) {
            errorCollector.addErrorEntry(ErrorType.NAME_ERROR, printErrorMessage("pos illegal cord-name"), node.lineNumber);
        }
    }

    @Override
    public void visit(ArrayAccessNode node) {
        this.visitChildren(node);

        // Get the type of the array it's trying to access
        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
        node.type = attributes.getDataType();


        // Make sure the user is not trying to access an element that is out of bonds
        int arrayLength = attributes.getArrayLength() - 1;

        // Get the children index node
        AstNode indexNode = node.children.get(0);

        if(indexNode instanceof IntNode || indexNode instanceof DoubleNode) {
            double index = Double.parseDouble(indexNode.toString());

            // Check if the type of index is legal (you cannot access an array using a double
            String indexType = node.children.get(0).getType();
            if(!indexType.equals("int")) {
                errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("index type", indexType), node.lineNumber);
            }
            else if(index < 0) {
                errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("array index negative"), node.lineNumber);
            }
            else if(index > arrayLength) {
                errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("array out of bounds"), node.lineNumber);
            }
        }
        else if(indexNode instanceof IDNode) {
            // We need to get the value of the ID node
            // Fix later
        }

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
        this.visitChildren(node);
    }

    @Override
    public void visit(CompNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(LogicalExprNode node) {
        this.visitChildren(node);
        node.type = "bool";

        // All the children of a logical expr node must be a CompExpr
        // We check this by going through all the children and verifying their node type
        for(int child = 0; child < node.getChildren().size(); child++) {
            String currChildName = node.children.get(child).getClass().toString();
            if(!currChildName.equals("class com.p4.core.nodes.CompExprNode") && !currChildName.equals("class com.p4.core.nodes.LogicalExprNode")) {
                errorCollector.addErrorEntry(ErrorType.OPERATION_ERROR, printErrorMessage("illegal comparison"), node.lineNumber);
            }
        }
    }

    @Override
    public void visit(CompExprNode node) {
        this.visitChildren(node);
        node.type = "bool";

        // Get both children
        AstNode leftNode = node.children.get(0);
        AstNode rightNode = node.children.get(1);

        if(leftNode != null && rightNode != null) {
            if(!isComparisonOK(leftNode.getType(), rightNode.getType(), node.getToken())) {
                errorCollector.addErrorEntry(ErrorType.OPERATION_ERROR, printErrorMessage("illegal comparison"), node.lineNumber);
            }
        }
    }

    // Used to check if comparisons are OK (that is <, >, <=, >=, ==)
    private boolean isComparisonOK(String type1, String type2, int compOperator) {
        // First check if one of the sides are null
        if(type1 == null || type2 == null) {
            return false;
        }

        if(compOperator == GEasyParser.LESS_THAN || compOperator == GEasyParser.GREATER_THAN ||
           compOperator == GEasyParser.LESS_THAN_EQ || compOperator == GEasyParser.GREATER_THAN_EQ ||
           compOperator == GEasyParser.NOT_EQ || compOperator == GEasyParser.IS_EQ) {
            // True if both sides are of the same type, but not bool or pos
            if(type1.equals(type2) &&  !((type1.equals("bool") || type1.equals("pos")) && type2.equals("bool") || type2.equals("pos"))    ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void visit(IDNode node) {
        SymbolAttributes attributes = symbolTable.lookupSymbol(node.getID());
        if(attributes == null) {
            // Error handling here
            // The variable could not be found in the scope (local + global)
            errorCollector.addErrorEntry(ErrorType.UNDECLARED_VAR, printErrorMessage("no var dcl", node.getID()), node.lineNumber);
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

        String leftType = node.getType();
        String rightType = node.children.get(0).type;

        checkIfTypeDCLisCorrect(leftType, rightType, node.lineNumber);
    }

    // When declaring variables this checks if the type of the variable matches the type of the expression its being assigned to
    // Example: int x = true;    NOT OKAY
    // Example: int x = 22;      OKAY
    private void checkIfTypeDCLisCorrect(String dclType, String exprType, int lineNumber) {
        if(!isReturnOK(dclType, exprType)) {
            errorCollector.addErrorEntry(ErrorType.TYPE_ERROR, printErrorMessage("assign", dclType, exprType), lineNumber);
        }
    }

    @Override
    public void visit(IntNode node) {
        node.type = "int";
    }

    @Override
    public void visit(DoubleDclNode node) {
        this.visitChildren(node);

        String leftType = node.getType();
        String rightType = node.children.get(0).getType();

        checkIfTypeDCLisCorrect(leftType, rightType, node.lineNumber);
    }

    @Override
    public void visit(DoubleNode node) {
        node.type = "double";
    }

    @Override
    public void visit(BoolDclNode node) {
        this.visitChildren(node);

        String leftType = node.getType();
        String rightType = node.children.get(0).getType();

        checkIfTypeDCLisCorrect(leftType, rightType, node.lineNumber);
    }


    @Override
    public void visit(LogicalOPNode node) {
        this.visitChildren(node);
    }

    @Override
    public void visit(AddNode node) {
        this.visitChildren(node);
        node.setID("add");
        node.type = typeArithmeticOperationResult(node);
    }

    @Override
    public void visit(SubNode node) {
        this.visitChildren(node);
        node.setID("sub");
        node.type = typeArithmeticOperationResult(node);
    }

    // Gets the type result type of add, mins, div, mod and mult operations
    private String typeArithmeticOperationResult(AstNode node) {
        // Get the left and right child
        String leftType = node.children.get(0).getType();
        String rightType = node.children.get(1).getType();

        // Semantics rules for addition and minus
        if(leftType.equals(rightType)) {
            return leftType;
        }
        else if((leftType.equals("int") || leftType.equals("double")) && ((rightType.equals("double")) || rightType.equals("int"))) {
            return "double";
        }
        else if(((leftType.equals("int") || leftType.equals("double") || leftType.equals("pos")) &&
                ((rightType.equals("pos") || rightType.equals("int") || rightType.equals("double"))))) {
            return "pos";
        }
        else {
            return "error";
        }
    }

    @Override
    public void visit(DivNode node) {
        this.visitChildren(node);
        node.setID("div");
        node.type = typeArithmeticOperationResult(node);
    }

    @Override
    public void visit(MultNode node) {
        this.visitChildren(node);
        node.setID("mult");
        node.type = typeArithmeticOperationResult(node);
    }

    @Override
    public void visit(ModNode node) {
        this.visitChildren(node);
        node.setID("mod");
        node.type = typeArithmeticOperationResult(node);
    }

    //Not sure what to do here
    @Override
    public void visit(LineCommentNode node) {
        this.visitChildren(node);
    }


    public String printErrorMessage(String errorType, String ... info) {
        switch (errorType) {
            case "return": case "void return":
                return "Illegal return type: Cannot return " + info[0] + " from a function of type " + info[1];
            case "func dcl not found":
                return "Function '" + info[0] + "' hast not been declared";
            case "number of params":
                return "The number of actual parameters does not correspond with the number of formal parameters when calling the function '" + info[0] + "'";
            case "actual parameter type":
                return "Illegal parameter type: The actual param '" + info[0] + "' is of type " + info[1] + " but should be of type " + info[2] + " to match the corresponding formal parameter";
            case "non-valid type":
                return "Illegal type: The type '" + info[0] + "' is not valid";
            case "actual parameter name":
                return "Illegal parameter name: The actual parameter name '" + info[0] + "' does not match the name of the formal parameter '" + info[1] + "'";
            case "assign":
                return "Illegal type conversion: Cannot assign " + info[0] + " to " + info[1];
            case "array assign":
                return "Illegal type: Cannot insert type " + info[0] + " into an array of type " + info[1];
            case "pos multiply":
                return "Illegal operation: One of the operands is not a scalar";
            case "pos add-sub":
                return "Illegal operation: Cannot add/subtract a position";
            case "pos illegal cord-name":
                return "Illegal pos declaration: The coordinates must be named 'x' and 'y'";
            case "index type":
                return "Illegal indexing type: The index cannot be of type " + info[0];
            case "array index negative":
                return "Illegal index: The index cannot be negative";
            case "array out of bounds":
                return "Illegal index: The index is out of bounds";
            case "illegal comparison":
                return "Illegal operation: The comparison is not valid";
            case "no var dcl":
                return "Variable not declared: The variable '" + info[0] + "' has not been declared in an accessible scope";
            default:
                return "dunno fam";
        }
    }

}
