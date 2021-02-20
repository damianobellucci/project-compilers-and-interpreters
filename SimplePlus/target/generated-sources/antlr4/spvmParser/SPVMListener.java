// Generated from SPVM.g4 by ANTLR 4.4
package spvmParser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SPVMParser}.
 */
public interface SPVMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SPVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterAssembly(@NotNull SPVMParser.AssemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitAssembly(@NotNull SPVMParser.AssemblyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPVMParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull SPVMParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPVMParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull SPVMParser.ProgramContext ctx);
}