package ast;

import java.util.LinkedList;
import java.util.List;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.SymbolTable;
import util_analysis.TypeError;

public class SimplePlusExpLessEqual extends SimplePlusExp {
	
	SimplePlusExp leftSide, rightSide;

	public SimplePlusExpLessEqual(SimplePlusExp leftSide, SimplePlusExp rightSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}

	@Override
	public int getValue(Environment e) {
		if(leftSide.getValue(e) <= rightSide.getValue(e))
			return 1;
		else
			return 0;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> result = new LinkedList<SemanticError>();
		
		result.addAll(leftSide.checkSemantics(e));
		result.addAll(rightSide.checkSemantics(e));
		
		return result;
	}
	
	@Override
	public String checkType(Environment e) throws TypeError {
		if (!leftSide.checkType(e).equals("int") || !rightSide.checkType(e).equals("int")) {
			throw new TypeError("Type mismatch in binary operator");
		}
		return new String("bool");
	}
	
	
	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {
		
		symbolTable = leftSide.symbolTableGeneration(symbolTable);
		
		symbolTable = rightSide.symbolTableGeneration(symbolTable);
		
		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {
		
		String res = new String("");
		
		res = res + rightSide.codeGeneration(nestingLevel);
		res = res + "push $a0\n";
		res = res + leftSide.codeGeneration(nestingLevel);
		res = res + "top $t1\n";
		res = res + "pop\n";
		res = res + "leq $a0 $a0 $t1\n";
		
		return res;
	}
}
