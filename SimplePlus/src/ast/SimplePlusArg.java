package ast;

import java.util.LinkedList;
import java.util.List;
import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.ScopeVariable;
import util_analysis.SemanticError;
import util_analysis.Strings;
import util_analysis.SymbolTable;
import util_analysis.TypeError;

public class SimplePlusArg extends SimplePlusElementBase {
	String type;
	String id;
	boolean reference;

	public SimplePlusArg(String type, String id, boolean reference) {
		this.type = type;
		this.id = id;
		this.reference = reference;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> result = new LinkedList<SemanticError>();

		if (type.equals("void")) {
			result.add(new SemanticError(Strings.errorVoidArg + id));
		} else if (!e.containsLocalVariable(id)) {
			if (!reference) {
				e.addVariable(new ScopeVariable().setId(id).setType(type).setInizialized(true));
			} else {
				e.addVariable(new ScopeVariable().setId(id).setType(type).setInizialized(true).setReference((true)));
			}
		} else {
			result.add(new SemanticError(Strings.ErrorVariableAlreadyDeclared + id));
		}
		return result;
	}

	@Override
	public String checkType(Environment e) throws TypeError {

		return type;
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		// aggiungo una nuova variabile allo scope (della funzione)
		symbolTable.addVariable(id, reference);

		// System.out.println("arg: " + id);

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {
		String res = new String("");

		// TODO: non viene generato nessun codice qua, la dichiarazione dei parametri è
		// gestita dalla chiamata di funzione

		return res;
	}

}
