package ast;

import java.util.LinkedList;
import java.util.List;

import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.SymbolTable;


public class SimplePlusExpBool extends SimplePlusExp {

	private boolean value;

	public SimplePlusExpBool(boolean value) {
		this.value = value;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		return new LinkedList<SemanticError>();
	}
	
	@Override
	public String checkType(Environment e) {
		return new String("bool");
	}

	@Override
	public int getValue(Environment e) {
		if(value)
			return 1;
		else
			return 0;
	}
	
	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {
		
		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {
		String res = new String("");
		
		if(value)
			res = res + "li $a0 1\n";
		else
			res = res + "li $a0 0\n";
		
		return res;
	}
	
}
