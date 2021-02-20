package ast;

import java.util.LinkedList;
import java.util.List;
import util_analysis.Variable;
import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;
import util_analysis.SymbolTable;
import util_analysis.TypeError;

public class SimplePlusCall extends SimplePlusStmt {
	String id;
	List<SimplePlusExp> args;

	private SymbolTable symbolTable;

	public SimplePlusCall(String id, List<SimplePlusExp> args) {
		this.id = id;
		this.args = args;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> result = new LinkedList<SemanticError>();

		if (!e.containsVariable(id)) {
			result.add(new SemanticError(Strings.functionNotDeclared + id));
		} else if (e.functionsArgs.get(id).size() != args.size()) {
			result.add(new SemanticError(Strings.functionDifferentNumberOfParameters + id));
		} else {
			// aliasing
			List<SimplePlusArg> formalArgs = e.functionsArgs.get(e.getLastFunctionId());
			for (int i = 0; i < args.size(); i++) {
				if (args.get(i) instanceof SimplePlusExpVar) {
					System.out.println(((SimplePlusExpVar) args.get(i)).id + " " + formalArgs.get(i).id);
					e.lastFunctionArgsAliasing.put(formalArgs.get(i).id, ((SimplePlusExpVar) args.get(i)).id.toString());
				}
				else {
					//caso in cui variabile sia una espressione				
					e.lastFunctionArgsAliasing.put(formalArgs.get(i).id, null);
				}
			}

			for (SimplePlusExp arg : args) {
				result.addAll(arg.checkSemantics(e));
			}

		}
		return result;
	}

	@Override
	public String checkType(Environment e) throws TypeError {
		// devo controllare che i tipi dei parametri siano uguali a quelli deli passaggi
		List<SimplePlusArg> functionDefinitionParameters = e.functionsArgs.get(id);
		int i = 0;

		for (SimplePlusExp exp : args) {
			if (!functionDefinitionParameters.get(i).type.equals(exp.checkType(e)))
				throw new TypeError(Strings.ErrorBetweenFunctionParameters + id);
		}

		return e.getVariableType(id);
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		// riferimento alla tabella dei simboli per poter accedere in seguito a
		// informazioni attualmente non disponibili
		this.symbolTable = symbolTable;

		// System.out.println("call " + symbolTable.toString());

		// generazione del codice per le espressioni nella chiamata alla funzione
		for (int i = 0; i < args.size(); i++)
			symbolTable = args.get(i).symbolTableGeneration(symbolTable);

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {

		String res = new String("");

		res = res + "push $fp\n";

		// riservo spazio sullo stack per le variabili locali della funzione prima di
		// mettere i parametri
		/*
		 * In questo modo, per esempio in: void f(int x) {int y; return;} gli offset
		 * rispetto a $fp sono: x offset 1 y offset 2
		 */
		for (int i = 0; i < symbolTable.getFunctionVariablesNumber(id) - args.size(); i++) {
			res = res + "li $a0 0\n";
			res = res + "push $a0\n";
		}

		// carico i parametri della funzione sullo stack
		for (int i = args.size() - 1; i >= 0; i--) {

			if (args.get(i) instanceof SimplePlusExpVar) {

				List<Variable> paramsRef = symbolTable.getFunctionParamsRef(id);

				if (paramsRef.get(i).isReference())
					// se il parametro è una variabile passata per riferimento salvo nella pila
					// l'indirizzo di memoria invece del valore
					res = res + ((SimplePlusExpVar) args.get(i)).codeGenerationReference(nestingLevel);
				else
					// se il parametro è una variabile ma non è passata per riferimento calcolo il
					// valore dell'espressione
					res = res + args.get(i).codeGeneration(nestingLevel);

			} else
				// se il parametro non è una variabile genero il codice dell'espressione
				// normalmente
				res = res + args.get(i).codeGeneration(nestingLevel);

			res = res + "push $a0\n";
		}

		// calcolo il valore dell'access link della funzione
		res = res + "lw $al 0($fp)\n";

		if (nestingLevel != symbolTable.getFunctionNestingLevel(id)) {

			// TODO: forse i = 0
			for (int i = 1; i < nestingLevel - symbolTable.getFunctionNestingLevel(id); i++)
				res = res + "lw $al 0($al)\n";
		}

		// salvo per ultimo il valore dell'access link
		res = res + "push $al\n";

		// salto all'etichetta della funzione
		res = res + "jal " + symbolTable.getFunctionLabel(id) + "\n";

		return res;
	}
}