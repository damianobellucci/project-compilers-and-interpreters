package ast;

import java.util.LinkedList;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Variable;

import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import util_analysis.Environment;
import util_analysis.ScopeVariable;
import util_analysis.SemanticError;
import util_analysis.Strings;
import util_analysis.SymbolTable;
import util_analysis.TypeError;

public class SimplePlusDecVar extends SimplePlusStmt {
	String id;
	SimplePlusExp exp;
	String type;

	private SymbolTable symbolTable;

	public SimplePlusDecVar(String id, SimplePlusExp exp, String type) {
		this.id = id;
		this.exp = exp;
		this.type = type;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> res = new LinkedList<SemanticError>();
		
		// si controlla che il tipo non sia void
		if (this.type.equals("void")) {
			res.add(new SemanticError(Strings.ErrorCannotUseTypeVoid));
		} else {
			// si controlla se il nome di variabile è già usato nello scope locale
			if (e.containsLocalVariable(this.id)) {
				res.add(new SemanticError(Strings.ErrorVariableAlreadyDeclared + this.id));
			} else {
				// si aggiunge la variabile allo scope locale, exp sarà null se non c'è
				if (this.exp != null) {
					res = exp.checkSemantics(e);
					e.addVariable(new ScopeVariable().setInizialized(true).setId(this.id));
				} else
					e.addVariable(new ScopeVariable().setId(this.id));
			}
		}
		return res;
	}

	@Override
	public String checkType(Environment e) throws TypeError {
		// si controlla se il nome di variabile è già usato nello scope locale
		
		if (e.containsLocalVariable(this.id)) {
			TypeError typeError = new TypeError(Strings.ErrorVariableAlreadyDeclared + this.id);
			throw (typeError);
		} else {
			// si aggiunge la variabile allo scope locale, exp sarà null se non c'è
			if (this.exp != null) {
				if (!type.equals(exp.checkType(e))) {
					TypeError typeError = new TypeError(Strings.ErrorTypeMismatch + this.id);
					throw (typeError);
				}
				e.addVariable(new ScopeVariable().setInizialized(true).setId(this.id).setType(type));
				
				
			} else
				e.addVariable(new ScopeVariable().setId(this.id).setType(type));
		}
		return type;
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		// aggiungo la variabile allo scope
		symbolTable.addVariable(id, false);

		// System.out.println("varDec: " + symbolTable.toString());

		// faccio una copia della tabella dei simboli nel momento in cui viene aggiunta
		// la variabile, non mi interessa quello che viene dopo
		this.symbolTable = symbolTable.clone();

		// se è presente un'espressione da assegnare alla variabile genero la tabella
		// dei simboli
		if (exp != null)
			symbolTable = exp.symbolTableGeneration(symbolTable);

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {

		String res = new String("");

		// fa un assegnamento nel punto in cui è scritta l'istruzione di dichiarazione
		// della variabile se è presente l'espressione
		if (exp != null) {

			res = res + exp.codeGeneration(nestingLevel);
			res = res + "sw $a0 " + symbolTable.getVariableOffset(id) + "($fp)\n";
		}

		return res;
	}

}
