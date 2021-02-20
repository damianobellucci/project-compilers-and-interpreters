package ast;

import java.util.LinkedList;
import java.util.List;

import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.SymbolTable;


public class SimplePlusExpVal extends SimplePlusExp {

	private int value;

	public SimplePlusExpVal(int value) {
		this.value = value;
	}

	// No semantic errors here

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		return new LinkedList<SemanticError>();
	}
	
	@Override
	public String checkType(Environment e) {

		return new String("int");
	}

	@Override
	public int getValue(Environment e) {	
		return value;
	}
	
	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {
		
		String res = new String("");
		
		res = res + "li $a0 " + value + "\n";
		
		return res;
	}
}
