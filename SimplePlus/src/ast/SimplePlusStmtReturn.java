package ast;

import java.util.LinkedList;
import java.util.List;
import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;
import util_analysis.SymbolTable;
import util_analysis.TypeError;

public class SimplePlusStmtReturn extends SimplePlusStmt {
	SimplePlusExp exp;

	private SymbolTable symbolTable;
	private SymbolTable globalSymbolTable;

	public SimplePlusStmtReturn(SimplePlusExp exp) {

		this.exp = exp;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> result = new LinkedList<SemanticError>();

		if (e.getLastFunctionId() == null) {
			result.add(new SemanticError(Strings.ErrorReturnOutsideFunctionDec));

		} else if (exp == null) {
			result.add(new SemanticError(Strings.ErrorEmptyReturnStatement + e.getLastFunctionId()));
		} else
			result.addAll(exp.checkSemantics(e));
		return result;
	}

	@Override
	public String checkType(Environment e) throws TypeError {

		if (!e.getVariableType(e.getLastFunctionId()).equals(exp.checkType(e)))
			throw new TypeError(Strings.MysmatchReturnAndTypeFunction + e.getLastFunctionId());
		else
			return exp.checkType(e);
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		// salvo una copia della tabella dei simboli attuale, non mi interessano le
		// modifiche future
		this.symbolTable = symbolTable.clone();

		// copio un riferimento alla tabella dei simboli per poter accedere alle
		// informazioni sulla funzione una volta disponibili
		this.globalSymbolTable = symbolTable;

		// System.out.println("return -------- " + symbolTable.toString());

		// genero la tabella dei simboli per l'espressione, se c'è
		if (exp != null)
			symbolTable = exp.symbolTableGeneration(symbolTable);

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {

		String res = new String("");

		// cerca l'id dell'ultima funzione aggiunta nella tabella dei simboli (cioè
		// quella in cui si trova il return)
		String funId = globalSymbolTable.getLastFunctionId();

		// recupera il livello di annidamento della funzione (il livello di annidamento
		// del blocco della funzione è functionNestingLevel + 1)
		Integer functionNestingLevel = globalSymbolTable.getFunctionNestingLevel(funId);

		// numero di pop da fare prima di uscire dal blocco della funzione
		Integer popNumber = 0;

		// se si esce dalla funzione bisogna fare pop dei blocchi in cui si è entrati
		// pop di ($fp + variabili locali del blocco interno alla funzione + $al) per
		// ogni blocco
		for (int i = 0; i < nestingLevel - functionNestingLevel - 1; i++)
			popNumber += symbolTable.getVariablesNumberBlock(i) + 2;

		// pop per uscire dai blocchi prima di uscire dalla funzione
		res = res + "addi $sp $sp " + popNumber + "\n";

		// il return salta all'indirizzo puntato da $ra

		// generazione del codice per l'espressione se c'è
		// il risultato è come da invariante salvato in $a0 e questo registro non è più
		// modificato fino all'uscita dalla funzione
		// in questo modo il chiamante può accedere al valore di ritorno tramite il
		// registro $a0 in modo conforme alle altre espressioni
		if (exp != null)
			res = res + exp.codeGeneration(nestingLevel);

		// recupero il valore di ritorno
		res = res + "top $ra\n";

		// devo fare pop delle variabili del blocco funzione (cioè il blocco che
		// racchiude tutti gli statement della funzione)
		// recupero il livello di annidamento del blocco della funzione rispetto al
		// blocco attuale (per getVariablesNumberBlock 0 è il blocco attuale e > 0 sono
		// quelli più esterni)
		// + 2 perché bisogna fare il pop di $ra e $al invece che solo di $ra
		popNumber = symbolTable.getVariablesNumberBlock(nestingLevel - (functionNestingLevel + 1)) + 2;

		res = res + "addi $sp $sp " + popNumber + "\n";

		res = res + "top $fp\n";
		res = res + "pop\n";
		res = res + "jr $ra\n";

		return res;
	}
}
