package com.p4.core.visitors;

import com.p4.core.nodes.*;

public interface INodeVisitor {
    void visitChildren(AstNode node);

    void visit(ProgNode node);

    void visit(DclNode node);
    void visit(FuncDclNode node);
    void visit(FuncCallNode node);

    void visit(AssignNode node);
    void visit(ArrayDclNode node);
    void visit(PosDclNode node);

    void visit(ArrayAccessNode node);

    void visit(SelectionNode node);
    void visit(IterativeNode node);
    void visit(LogicalExprNode node);

    void visit(FormalParamNode node);
    void visit(ActualParamNode node);
    void visit(BlockNode node);
    void visit(ReturnExprNode node);

    void visit(ArithmeticNode node);
    void visit(CompNode node);
    void visit(BoolDclNode node);
    void visit(BoolExprNode node);
    void visit(CompExprNode node);

    void visit(IDNode node);
    void visit(BoolNode node);
    void visit(IntDclNode node);
    void visit(IntNode node);
    void visit(DoubleDclNode node);
    void visit(DoubleNode node);
    void visit(PosNode node);
    void visit(LogicalOPNode node);

    void visit(AddNode node);
    void visit(SubNode node);
    void visit(DivNode node);
    void visit(MultNode node);
    void visit(ModNode node);

    void visit(LineCommentNode node);

}
