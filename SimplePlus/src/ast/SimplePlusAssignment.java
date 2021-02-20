package ast;

import java.util.LinkedList;
import java.util.List;

import behavioural_analysis.BTAtom;
import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;
import util_analysis.SymbolTable;
import util_analysis.TypeError;
import util_analysis.ScopeVariable;

public class SimplePlusAssignment extends SimplePlusStmt {

	String id;
	SimplePlusExp exp;
	private SymbolTable symbolTable;

	public SimplePlusAssignment(String id, SimplePlusExp exp) {
		this.id = id;
		this.exp = exp;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> res = new LinkedList<SemanticError>();
		if (!e.containsVariable(id)) {
			res.add(new SemanticError(Strings.ErrorVariableDoesntExist + id));
		}

		if (res.size() == 0) {
			res.addAll(exp.checkSemantics(e));
			if (res.size() == 0)
				e.updateVariableInizialization(id, true);
		}
		return res;
	}

	@Override
	public String checkType(Environment e) throws TypeError {
		String lhs = e.getVariableType(id);
		String rhs = exp.checkType(e);
		
		if (lhs.equals(rhs))
			return new String("void");
		else
			throw new TypeError(Strings.ErrorTypeMismatch+id);
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		int cost;
		// if the variable doesn't exist in the current scope then
		// it has a cost equals to 1
		if (e.getVariableValueLocal(id) == null)
			cost = 1;
		else
			cost = 0;

		// put the variable in the current scope with the current value
		// e.addVariable(id, exp.getValue(e));

		return new BTAtom(cost);
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		// salvo una copia della tabella dei simboli attuale, non mi interessano le
		// modifiche future
		this.symbolTable = symbolTable.clone();

		// generazione della tabella dei simboli dell'espressione da assegnare alla
		// variabile
		symbolTable = exp.symbolTableGeneration(symbolTable);

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {

		String res = new String("");

		// generazione del codice da assegnare alla variabile
		// il risultato della valutazione dell'espressione è salvato in $a0
		res = res + exp.codeGeneration(nestingLevel);

		// se la variabile si trova in un blocco funzione ed è passata per riferimento
		// carico il valore usando l'indirizzo di memoria
		if (symbolTable.isVariableReference(id)) {

			// System.out.println("-----------reference assignment " + id);

			// se mi trovo in un blocco più interno della funzione devo risalire degli
			// access link
			if (nestingLevel != symbolTable.getVariableNestingLevel(id)) {

				res = res + "lw $al 0($fp)\n";

				// TODO: forse i = 0
				for (int i = 1; i < nestingLevel - symbolTable.getVariableNestingLevel(id); i++)
					res = res + "lw $al 0($al)\n";

				res = res + "smem $a0 " + symbolTable.getVariableOffset(id) + "($al)\n";
			} else
				// se mi trovo nel blocco della funzione il valore si trova a un offset da $fp
				res = res + "smem $a0 " + symbolTable.getVariableOffset(id) + "($fp)\n";
		} else {

			// la variabile è passata per copia
			// se mi trovo in un blocco più interno rispetto alla dichiarazione devo
			// risalire degli access link
			if (nestingLevel != symbolTable.getVariableNestingLevel(id)) {

				res = res + "lw $al 0($fp)\n";

				// TODO: forse i = 0
				for (int i = 1; i < nestingLevel - symbolTable.getVariableNestingLevel(id); i++)
					res = res + "lw $al 0($al)\n";

				res = res + "sw $a0 " + symbolTable.getVariableOffset(id) + "($al)\n";
			} else
				// se mi trovo nel blocco della dichiarazione il valore si trova a un offset da
				// $fp
				res = res + "sw $a0 " + symbolTable.getVariableOffset(id) + "($fp)\n";
		}

		return res;
	}
}
