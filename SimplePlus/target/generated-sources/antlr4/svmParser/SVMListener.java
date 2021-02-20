// Generated from SVM.g4 by ANTLR 4.4
package svmParser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SVMParser}.
 */
public interface SVMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterAssembly(@NotNull SVMParser.AssemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitAssembly(@NotNull SVMParser.AssemblyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SVMParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull SVMParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull SVMParser.ProgramContext ctx);
}