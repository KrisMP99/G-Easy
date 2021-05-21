package com.p4.core.tests;

import com.p4.core.GEasyParser;
import com.p4.core.errorHandling.ErrorCollector;
import com.p4.core.errorHandling.ErrorType;
import com.p4.core.nodes.*;
import com.p4.core.symbolTable.SymbolAttributes;
import com.p4.core.symbolTable.SymbolTable;
import com.p4.core.visitors.SemanticsVisitor;
import org.junit.jupiter.api.Test;

class SemanticsTests {
    private SemanticsVisitor semanticsVisitor = new SemanticsVisitor(new SymbolTable(), new ErrorCollector());

    @Test
    void visitAddNode_ReceivesIntAndDouble_SetsTypeToDouble() {
        // Arrange
        IntNode child1 = new IntNode(5, false);
        DoubleNode child2 = new DoubleNode(2.5, false);
        AddNode addNode = new AddNode();

        addNode.children.add(child1);
        addNode.children.add(child2);

        // Act
        semanticsVisitor.visit(addNode);
        boolean result = addNode.getType().equals("double");

        // Assert
        assert(result);

    }

    @Test
    void visitLogicalExprNode_AndOperator_ReceivesTwoInt_GivesError() {
        // Arrange
        IntNode child1 = new IntNode(1, false);
        IntNode child2 = new IntNode(1, false);
        LogicalExprNode logicalExprNode = new LogicalExprNode();

        logicalExprNode.setToken(GEasyParser.AND);
        logicalExprNode.children.add(child1);
        logicalExprNode.children.add(child2);

        ErrorCollector errorCollector = new ErrorCollector();
        semanticsVisitor = new SemanticsVisitor(new SymbolTable(), errorCollector);

        // Act
        semanticsVisitor.visit(logicalExprNode);
        boolean result = errorCollector.getErrorType(0) == ErrorType.OPERATION_ERROR;

        // Assert
        assert(result);

    }

    @Test
    void visitLogicalExprNode_AndOperator_ReceivesTwoBool_SetTypeToBool() {
        // Arrange
        BoolNode child1 = new BoolNode(true, "bool");
        BoolNode child2 = new BoolNode(true, "bool");
        LogicalExprNode logicalExprNode = new LogicalExprNode();

        logicalExprNode.setToken(GEasyParser.AND);
        logicalExprNode.children.add(child1);
        logicalExprNode.children.add(child2);

        // Act
        semanticsVisitor.visit(logicalExprNode);
        boolean result = logicalExprNode.getType().equals("bool");

        // Assert
        assert(result);

    }
}
