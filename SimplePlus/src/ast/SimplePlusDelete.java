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

public class SimplePlusDelete extends SimplePlusStmt {

	private String id;

	private SymbolTable symbolTable;

	/**
	 * Creates a delete statement
	 * 
	 * @param id the variable we want to delete
	 */
	public SimplePlusDelete(String id) {
		this.id = id;
	}

	/*
	 * Checks if the variable in use exists. if it doesn't then add an error, if it
	 * does then remove it from the current scope
	 */
	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> result = new LinkedList<SemanticError>();

		// se la variabile non era nell'environment allora non si può cancellare, si
		// avrà errore
		if (!e.containsVariable(id)) {
			result.add(new SemanticError(Strings.ErrorVariableDoesntExist + id));
		}
		// nel caso in cui la variabile era presente nell'environment, allora si
		// cancellerà
		else {
			// stampa di debug prima la delete
			System.out.println("Debug stampa operazione delete: prima del delete");
			e.debugPrintEnvironment();
			e.deleteVariable(id);
			// stampa di debug dopo la delete
			System.out.println("Debug stampa operazione delete: dopo la delete");
			e.debugPrintEnvironment();
		}
		return result;
	}

	@Override
	public String checkType(Environment e) throws TypeError {
		e.deleteVariable(id);
		return new String("void");
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		int cost;
		// if the variable exist this will have a cost of -1
		if (e.containsVariable(id))
			cost = -1;
		else
			cost = 0;

		// put the variable in the current scope with the current value
		e.deleteVariable(id);

		return new BTAtom(cost);
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		// System.out.println("prima delete: " + symbolTable.toString());

		// faccio una copia della tabella dei simboli prima di cancellare la variabile
		// dallo scope, serve sapere l'offset nella generazione di codice
		this.symbolTable = symbolTable.clone();

		// aggiungo la variabile allo scope
		symbolTable.deleteVariable(id);

		// System.out.println("dopo delete: " + symbolTable.toString());

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {

		String res = new String("");

		// assegna simbolicamente 0 alla variabile nel punto in cui viene cancellata
		res = res + "li $a0 0\n";

		if (symbolTable.isVariableReference(id)) {
			System.out.println("-----------reference delete " + id);
			// se la variabile si trova in un blocco funzione ed è passata per riferimento
			// carico il valore usando l'indirizzo di memoria

			if (nestingLevel != symbolTable.getVariableNestingLevel(id)) {

				res = res + "lw $al 0($fp)\n";

				// TODO: forse i = 0
				for (int i = 1; i < nestingLevel - symbolTable.getVariableNestingLevel(id); i++)
					res = res + "lw $al 0($al)\n";

				res = res + "smem $a0 " + symbolTable.getVariableOffset(id) + "($al)\n";
			} else
				res = res + "smem $a0 " + symbolTable.getVariableOffset(id) + "($fp)\n";
		} else {

			if (nestingLevel != symbolTable.getVariableNestingLevel(id)) {

				res = res + "lw $al 0($fp)\n";

				// TODO: forse i = 0
				for (int i = 1; i < nestingLevel - symbolTable.getVariableNestingLevel(id); i++)
					res = res + "lw $al 0($al)\n";

				res = res + "sw $a0 " + symbolTable.getVariableOffset(id) + "($al)\n";
			} else
				res = res + "sw $a0 " + symbolTable.getVariableOffset(id) + "($fp)\n";
		}

		return res;
	}
}
