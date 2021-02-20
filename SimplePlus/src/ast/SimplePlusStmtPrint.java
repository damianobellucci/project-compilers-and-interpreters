package ast;

import java.util.List;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTPrint;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.SymbolTable;

public class SimplePlusStmtPrint extends SimplePlusStmt {

	private SimplePlusExp exp;

	public SimplePlusStmtPrint(SimplePlusExp exp) {
		
		this.exp = exp;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		
		return exp.checkSemantics(e);
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		
		return new BTPrint(exp.getValue(e));
	}
	
	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {
		
		//generazione della tabella dei simboli dell'espressione della print
		symbolTable = exp.symbolTableGeneration(symbolTable);
				
		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {
		
		String res = new String("");
		
		//la valutazione dell'espressione salva il risultato in $a0
		res = res + exp.codeGeneration(nestingLevel);
		res = res + "print $a0\n";
		
		return res;
	}
}
