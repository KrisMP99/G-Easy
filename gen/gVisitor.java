// Generated from C:/Users/Kristian/Desktop/P4\g.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(gParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(gParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#var_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_dcl(gParser.Var_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#pos_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos_dcl(gParser.Pos_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#array_dcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_dcl(gParser.Array_dclContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(gParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#pos_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos_assign(gParser.Pos_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#array_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_assign(gParser.Array_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(gParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_call(gParser.Func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(gParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(gParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#iterative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterative(gParser.IterativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#logical_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_expr(gParser.Logical_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(gParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(gParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#blok}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlok(gParser.BlokContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#return_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_expr(gParser.Return_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link gParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal(gParser.ValContext ctx);
}