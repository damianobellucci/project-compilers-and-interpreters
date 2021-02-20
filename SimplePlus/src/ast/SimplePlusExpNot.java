package ast;

import java.util.LinkedList;
import java.util.List;

import util_analysis.SemanticError;
import util_analysis.SymbolTable;
import util_analysis.TypeError;
import util_analysis.Environment;

public class SimplePlusExpNot extends SimplePlusExp {
	
	SimplePlusExp exp;

	public SimplePlusExpNot(SimplePlusExp exp) {
		this.exp = exp;		
	}

	@Override
	public int getValue(Environment e) {
		return 1 - exp.getValue(e);
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> result = new LinkedList<SemanticError>();
		
		result.addAll(exp.checkSemantics(e));
			
		return result;
	}
	
	@Override
	public String checkType(Environment e) throws TypeError {
		return exp.checkType(e);
	}
	
	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {
		
		symbolTable = exp.symbolTableGeneration(symbolTable);
		
		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {
		
		String res = new String("");
		
		res = res + exp.codeGeneration(nestingLevel);
		res = res + "not $a0 $a0\n";
		
		return res;
	}
}
