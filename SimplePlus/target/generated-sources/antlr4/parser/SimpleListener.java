// Generated from Simple.g4 by ANTLR 4.4
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParser}.
 */
public interface SimpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBaseExp(@NotNull SimpleParser.BaseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBaseExp(@NotNull SimpleParser.BaseExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinExp(@NotNull SimpleParser.BinExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinExp(@NotNull SimpleParser.BinExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#ifThenElse}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElse(@NotNull SimpleParser.IfThenElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#ifThenElse}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElse(@NotNull SimpleParser.IfThenElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull SimpleParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull SimpleParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(@NotNull SimpleParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(@NotNull SimpleParser.BoolExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valBExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterValBExp(@NotNull SimpleParser.ValBExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valBExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitValBExp(@NotNull SimpleParser.ValBExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(@NotNull SimpleParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(@NotNull SimpleParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFunExp(@NotNull SimpleParser.FunExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFunExp(@NotNull SimpleParser.FunExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNotExp(@NotNull SimpleParser.NotExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNotExp(@NotNull SimpleParser.NotExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(@NotNull SimpleParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(@NotNull SimpleParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVarExp(@NotNull SimpleParser.VarExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVarExp(@NotNull SimpleParser.VarExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(@NotNull SimpleParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(@NotNull SimpleParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#deletion}.
	 * @param ctx the parse tree
	 */
	void enterDeletion(@NotNull SimpleParser.DeletionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#deletion}.
	 * @param ctx the parse tree
	 */
	void exitDeletion(@NotNull SimpleParser.DeletionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#callArgs}.
	 * @param ctx the parse tree
	 */
	void enterCallArgs(@NotNull SimpleParser.CallArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#callArgs}.
	 * @param ctx the parse tree
	 */
	void exitCallArgs(@NotNull SimpleParser.CallArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVoidExp(@NotNull SimpleParser.VoidExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVoidExp(@NotNull SimpleParser.VoidExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(@NotNull SimpleParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(@NotNull SimpleParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(@NotNull SimpleParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(@NotNull SimpleParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(@NotNull SimpleParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(@NotNull SimpleParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull SimpleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull SimpleParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterValExp(@NotNull SimpleParser.ValExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitValExp(@NotNull SimpleParser.ValExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNegExp(@NotNull SimpleParser.NegExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link SimpleParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNegExp(@NotNull SimpleParser.NegExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull SimpleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull SimpleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(@NotNull SimpleParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(@NotNull SimpleParser.DefinitionContext ctx);
}