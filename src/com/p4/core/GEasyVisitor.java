// Generated from C:/Users/Kristian/Desktop/GEasyCompiler/src/com/p4/core\GEasy.g4 by ANTLR 4.9.1
package com.p4.core;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GEasyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GEasyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GEasyParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(GEasyParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(GEasyParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#var_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_dcl(GEasyParser.Var_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#num_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum_dcl(GEasyParser.Num_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#pos_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos_dcl(GEasyParser.Pos_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#array_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_dcl(GEasyParser.Array_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(GEasyParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#pos_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos_assign(GEasyParser.Pos_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#array_access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_access(GEasyParser.Array_accessContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GEasyParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(GEasyParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#actual_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActual_param(GEasyParser.Actual_paramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(GEasyParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(GEasyParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#iterative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterative(GEasyParser.IterativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_expr(GEasyParser.Logical_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#func_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_dcl(GEasyParser.Func_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#formal_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_param(GEasyParser.Formal_paramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GEasyParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#return_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_expr(GEasyParser.Return_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(GEasyParser.ValContext ctx);
	/**
	 * Visit a parse tree produced by {@link GEasyParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(GEasyParser.CommentContext ctx);
}