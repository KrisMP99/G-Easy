// Generated from C:/Users/Kristian/IdeaProjects/G-Easy/src/com/p4/core\GEasy.g4 by ANTLR 4.9.1
package com.p4.core;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GEasyParser}.
 */
public interface GEasyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GEasyParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GEasyParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GEasyParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(GEasyParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(GEasyParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#var_dcl}.
	 * @param ctx the parse tree
	 */
	void enterVar_dcl(GEasyParser.Var_dclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#var_dcl}.
	 * @param ctx the parse tree
	 */
	void exitVar_dcl(GEasyParser.Var_dclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#num_dcl}.
	 * @param ctx the parse tree
	 */
	void enterNum_dcl(GEasyParser.Num_dclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#num_dcl}.
	 * @param ctx the parse tree
	 */
	void exitNum_dcl(GEasyParser.Num_dclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#pos_dcl}.
	 * @param ctx the parse tree
	 */
	void enterPos_dcl(GEasyParser.Pos_dclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#pos_dcl}.
	 * @param ctx the parse tree
	 */
	void exitPos_dcl(GEasyParser.Pos_dclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#array_dcl}.
	 * @param ctx the parse tree
	 */
	void enterArray_dcl(GEasyParser.Array_dclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#array_dcl}.
	 * @param ctx the parse tree
	 */
	void exitArray_dcl(GEasyParser.Array_dclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(GEasyParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(GEasyParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#pos_assign}.
	 * @param ctx the parse tree
	 */
	void enterPos_assign(GEasyParser.Pos_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#pos_assign}.
	 * @param ctx the parse tree
	 */
	void exitPos_assign(GEasyParser.Pos_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#array_access}.
	 * @param ctx the parse tree
	 */
	void enterArray_access(GEasyParser.Array_accessContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#array_access}.
	 * @param ctx the parse tree
	 */
	void exitArray_access(GEasyParser.Array_accessContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GEasyParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GEasyParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFunc_call(GEasyParser.Func_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFunc_call(GEasyParser.Func_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#actual_param}.
	 * @param ctx the parse tree
	 */
	void enterActual_param(GEasyParser.Actual_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#actual_param}.
	 * @param ctx the parse tree
	 */
	void exitActual_param(GEasyParser.Actual_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(GEasyParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(GEasyParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(GEasyParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(GEasyParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#iterative}.
	 * @param ctx the parse tree
	 */
	void enterIterative(GEasyParser.IterativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#iterative}.
	 * @param ctx the parse tree
	 */
	void exitIterative(GEasyParser.IterativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expr(GEasyParser.Logical_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expr(GEasyParser.Logical_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#func_dcl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_dcl(GEasyParser.Func_dclContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#func_dcl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_dcl(GEasyParser.Func_dclContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#formal_param}.
	 * @param ctx the parse tree
	 */
	void enterFormal_param(GEasyParser.Formal_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#formal_param}.
	 * @param ctx the parse tree
	 */
	void exitFormal_param(GEasyParser.Formal_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GEasyParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GEasyParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#return_expr}.
	 * @param ctx the parse tree
	 */
	void enterReturn_expr(GEasyParser.Return_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#return_expr}.
	 * @param ctx the parse tree
	 */
	void exitReturn_expr(GEasyParser.Return_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#val}.
	 * @param ctx the parse tree
	 */
	void enterVal(GEasyParser.ValContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#val}.
	 * @param ctx the parse tree
	 */
	void exitVal(GEasyParser.ValContext ctx);
	/**
	 * Enter a parse tree produced by {@link GEasyParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(GEasyParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GEasyParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(GEasyParser.CommentContext ctx);
}