package ast;

import java.util.List;
import behavioural_analysis.BTBase;
import util_analysis.SemanticError;
import util_analysis.SymbolTable;
import util_analysis.TypeError;
import util_analysis.Environment;

public abstract class SimplePlusElementBase {

	/**performs a semantic check for controlling that all declared variables exist
	 * @param e is the current environment where the information about existent variables is stored
	 * @return a list of the semantic problems found
	 */
	public abstract List<SemanticError> checkSemantics(Environment e);
	
	/**
	 * performs behavioral type inference for Simple programs
	 * @param e is the current environment where the information about existent variables is stored
	 * @return the behavior of the expression
	 */
	public abstract BTBase inferBehavior(Environment e);
	
	public abstract SymbolTable symbolTableGeneration(SymbolTable symbolTable);
	
	public abstract String codeGeneration(Integer nestingLevel);
	
	//aggiunta
	public abstract String checkType(Environment e) throws TypeError;

}
