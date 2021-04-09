package com.p4.core.visitors;

import com.p4.core.nodes.*;

public interface INodeVisitor {
    void visitChildren(AstNode node);

    void visit(ProgNode node);

    void visit(DclNode node);
    void visit(StmtNode node);
    void visit(FuncDclNode node);
    void visit(FuncCallNode node);

    void visit(AssignNode node);
    void visit(ArrayDclNode node);
    void visit(PosDclNode node);
    void visit(VarDclNode node);

    void visit(PosAssignNode node);
    void visit(ArrayAssignNode node);
    void visit(ArrayAccessNode node);
    void visit(ExprNode node);

    void visit(SelectionNode node);
    void visit(IterativeNode node);
    void visit(LogicalExprNode node);

    void visit(ParamNode node);
    void visit(ActualParamNode node);
    void visit(BlockNode node);
    void visit(ReturnExprNode node);
    void visit(ValNode node);

    void visit(PlusNode node);
    void visit(MinusNode node);
    void visit(DivNode node);
    void visit(ModNode node);
    void visit(MultNode node);
    void visit(ArithmeticNode node);
    void visit(LogicalNode node);
    void visit(CompNode node);
    void visit(BoolDclNode node);
    void visit(BoolExprNode node);
    void visit(CompExprNode node);

    void visit(NumberNode node);
    void visit(IDNode node);
    void visit(BoolNode node);
    void visit(IntDclNode node);
    void visit(IntNode node);
    void visit(DoubleDclNode node);
    void visit(DoubleNode node);
    void visit(PosNode node);
    void visit(LogicalOPNode node);

    void visit(LineCommentNode node);
    void visit(CommentNode node);

}
