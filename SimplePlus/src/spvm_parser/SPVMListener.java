// Generated from SimplePlus\src\spvmParser\SPVM.g4 by ANTLR 4.6
package spvm_parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SPVMParser}.
 */
public interface SPVMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SPVMParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SPVMParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPVMParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SPVMParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SPVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterAssembly(SPVMParser.AssemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SPVMParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitAssembly(SPVMParser.AssemblyContext ctx);
}