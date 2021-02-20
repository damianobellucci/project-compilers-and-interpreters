package ast;

import java.util.LinkedList;
import java.util.List;
import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import util_analysis.Environment;
import util_analysis.LabelGenerator;
import util_analysis.ScopeVariable;
import util_analysis.SemanticError;
import util_analysis.Strings;
import util_analysis.SymbolTable;
import util_analysis.TypeError;
import util_analysis.Variable;

public class SimplePlusDecFun extends SimplePlusStmt {
	String id;
	List<SimplePlusArg> args;
	SimplePlusBlock block;
	String returnType;
	SymbolTable symbolTable;

	String functionLabel;

	public SimplePlusDecFun(String id, List<SimplePlusArg> args, SimplePlusBlock block, String returnType) {
		this.id = id;
		this.args = args;
		this.block = block;
		this.returnType = returnType;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> result = new LinkedList<SemanticError>();

		for (SimplePlusArg el : args) {
			System.out.println(el.id + " " + el.reference);
		}
		if (e.getNestingLevel() > 1) {
			result.add(new SemanticError(Strings.ErrorFunctionDeclarationWrongNestingLevel));
		} else if (e.containsVariable(id)) {
			result.add(new SemanticError(Strings.functionAlreadyExists + id));
		} else {
			e.setLastFunctionId(id);
			e.addVariable(new ScopeVariable().setId(id).setType(returnType));
			result.addAll(block.checkSemanticsFunctionBlock(e, args));
		}

		return result;
	}

	@Override
	public String checkType(Environment e) throws TypeError {
		// devo fare anche il function checktype, come per la checkSemantics

		e.setLastFunctionId(id);
		e.addVariable(new ScopeVariable().setId(id).setType(returnType));
		e.functionsArgs.put(id, args);
		block.checkTypeFunctionBlock(e, args);
		return null;
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		// si tiene traccia anche della tabella dei simboli visibile dall'esterno della
		// funzione in modo da poter aggiungere altre informazioni in seguito
		// che siano visibili da fuori la funzione
		this.symbolTable = symbolTable;

		// si crea un nuovo scope per il blocco funzione
		symbolTable.openScope();

		// informazioni sul tipo di passaggio dei parametri formali
		List<Variable> paramsRef = new LinkedList<Variable>();

		// salvataggio delle informazioni sui parametri formali nella tabella dei
		// simboli
		for (int i = 0; i < args.size(); i++) {

			// aggiunta alla tabella dei simboli delle informazioni sui parametri
			symbolTable = args.get(i).symbolTableGeneration(symbolTable);

			// creazione di una variabile per ogni parametro della funzione
			Variable variable = new Variable(args.get(i).id, null, args.get(i).reference, null, null);

			paramsRef.add(variable);
		}

		// generazione della tabella dei simboli per il blocco funzione
		symbolTable = block.symbolTableGenerationFunctionBlock(symbolTable);

		// generazione di una nuova etichetta per la funzione
		functionLabel = LabelGenerator.newFunction();

		// la funzione è aggiunta all'elenco di funzioni della tabella dei simboli
		symbolTable.addFunction(id, functionLabel, paramsRef, symbolTable.getVariablesNumberLastBlock());

		symbolTable.closeScope();

		// System.out.println("decfun: " + symbolTable.toString());
		// System.out.println("---------------Numero variabili: " +
		// this.symbolTable.getVariablesNumber());

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {

		String res = new String("");

		// generazione di una nuova etichetta per saltare il codice della dichiarazione
		// di funzione
		String skipFunction = LabelGenerator.newLabel();

		// aggiornamento del livello di annidamento della funzione
		symbolTable.setFunctionNestingLevel(id, functionLabel, nestingLevel);

		res = res + "b " + skipFunction + "\n";

		res = res + functionLabel + ":\n";

		res = res + "move $fp $sp\n";
		res = res + "push $ra\n";

		// generazione del codice del blocco della funzione
		res = res + block.codeGenerationFunctionBlock(nestingLevel);

		// TODO: il return deve sempre essere presente.
		// TODO: Generare due volte le istruzioni per la chiusura della funzione in modo
		// da non essere obbligati a inserire il return?

		res = res + skipFunction + ":\n";

		return res;
	}
}
