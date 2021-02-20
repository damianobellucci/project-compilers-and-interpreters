package ast;

import java.util.LinkedList;
import java.util.List;
import behavioural_analysis.BTBase;
import behavioural_analysis.BTBlock;
import util_analysis.Environment;
import util_analysis.ScopeVariable;
import util_analysis.SemanticError;
import util_analysis.Strings;
import util_analysis.SymbolTable;
import util_analysis.TypeError;

public class SimplePlusBlock extends SimplePlusStmt {

	List<SimplePlusStmt> children;

	private SymbolTable symbolTable;

	public SimplePlusBlock(List<SimplePlusStmt> children) {
		this.children = children;
	}

	/**
	 * It checks the semantic for every child in order item by item It creates a new
	 * scope for the elements that will be found inside Each element may add new
	 * elements to the environment inside the current scope After finishing drop the
	 * newly created scope
	 */

	public List<SemanticError> checkSemantics(Environment e) {
		// create scope for inner elements
		e.openScope();

		// initialize result variable
		LinkedList<SemanticError> result = new LinkedList<SemanticError>();

		// check children semantics
		if (children != null) {

			for (SimplePlusStmt el : children) {

				result.addAll(el.checkSemantics(e));

			}
		}

		e.closeScope();
		return result;
	}

	// è la checkSemantics per includere nel blocco della funzione i parametri della
	// funzione
	// da sistemare e rendere completamente ricorsiva
	Boolean thereIsReturn = false;

	Boolean ThereIsReturnStatement(SimplePlusBlock block) {
		for (SimplePlusStmt el : block.children) {
			if (el.getClass().getSimpleName().equals("SimplePlusStmtReturn")) {
				thereIsReturn = true;
			} else if (!thereIsReturn && el.getClass().getSimpleName().equals("SimplePlusBlock")) {
				ThereIsReturnStatement((SimplePlusBlock) el);
				// gestione caso return dentro if
			} else if (el.getClass().getSimpleName().equals("SimplePlusStmtIte")) {
				// devo fare distinzione se è un singolo statement

				// se il then dell'if è uno statement singolo e non un blocco, devo controllare
				// il singolo statement
				if ((((SimplePlusStmtIte) el).thenStmt).getClass().getSimpleName().equals("SimplePlusStmtReturn")) {
					thereIsReturn = true;
				}
				// sennò devo controllare in ricorsione il blocco
				else if ((((SimplePlusStmtIte) el).thenStmt).getClass().getSimpleName().equals("SimplePlusBlock")) {
					ThereIsReturnStatement((SimplePlusBlock) ((SimplePlusStmtIte) el).thenStmt);
				}

				// devo ora controllare l'else allo stesso modo, controllando però che prima sia
				// presente

				if ((((SimplePlusStmtIte) el).elseStmt) != null) {
					if ((((SimplePlusStmtIte) el).elseStmt).getClass().getSimpleName().equals("SimplePlusStmtReturn")) {
						thereIsReturn = true;
					}
					// sennò devo controllare in ricorsione il blocco
					else if ((((SimplePlusStmtIte) el).elseStmt).getClass().getSimpleName().equals("SimplePlusBlock")) {
						ThereIsReturnStatement((SimplePlusBlock) ((SimplePlusStmtIte) el).elseStmt);
					}
				}
			}
		}
		return thereIsReturn;
	}

	public List<SemanticError> checkSemanticsFunctionBlock(Environment e, List<SimplePlusArg> args) {
		// create scope for inner elements
		e.openScope();
		LinkedList<SemanticError> result = new LinkedList<SemanticError>();
	

		for (SimplePlusArg arg : args) {

			result.addAll(arg.checkSemantics(e));
		}
		if (result.size() == 0) {
			
				e.functionsArgs.put(e.getLastFunctionId(), args);
		}
		if (children != null) {
			// funzione ti tipo int/bool devono avere lo statement return
			if ((e.getVariableType(e.getLastFunctionId()).equals("int")
					|| e.getVariableType(e.getLastFunctionId()).equals("bool"))
					&& !ThereIsReturnStatement(new SimplePlusBlock(children))) {
				result.add(new SemanticError(Strings.ErrorNoStatementReturn + e.getLastFunctionId()));
			}
			int i = 1; // con questa variabile mi terrà traccia degli statement che ci sono dopo il
						// retrun
			for (SimplePlusStmt el : children) {
				// quando si incontra statement return dovrò controllare che la funzione non sia
				// void e che non ci sono altri statement dopo il return
				if (el.getClass().getSimpleName().equals("SimplePlusStmtReturn")) {
					// controllo semantica del return
					result.addAll(el.checkSemantics(e));
					// funzione di tipo void non può avere statement return
					if (e.getVariableType(e.getLastFunctionId()).equals("void")) {
						result.add(new SemanticError(Strings.CantReturnWithVoidFunction + e.getLastFunctionId()));
					} else if (children.size() - i > 0) {
						// se ci sono statement dopo il return si avrà errore
						result.add(new SemanticError(Strings.statementsAfterReturn));
					}
				} else {
					// se lo statement non era un return allora dovrò controllare semantica
					// statement ed andare avanti
					result.addAll(el.checkSemantics(e));
					i++;
				}

			}
		}
		e.closeScope();
		return result;
	}
	
	public List<SemanticError> checkSemanticsFunctionBlockCall(Environment e, List<SimplePlusArg> args) {

		//qua gestirò la checkSemantic del corpo della funzione dopo che è stata chiamata,
		//quindi devo guardare solo delete, controllare bene passaggi per riferimento ecc...
		
		e.openScope();
		
		LinkedList<SemanticError> result = new LinkedList<SemanticError>();

		e.closeScope();
		return result;
	}

	@Override
	public String checkType(Environment e) throws TypeError {
		e.openScope();

		if (children != null)
			for (SimplePlusStmt el : children) {

				el.checkType(e);
			}
		e.closeScope();
		return null;
	}

	public String checkTypeFunctionBlock(Environment e, List<SimplePlusArg> args) throws TypeError {
		e.openScope();

		for (SimplePlusArg arg : args) {

			arg.checkType(e);
			e.addVariable(new ScopeVariable().setId(arg.id).setType(arg.type));
		}

		if (children != null)
			for (SimplePlusStmt el : children) {

				el.checkType(e);
			}
		e.closeScope();
		return null;
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		// create scope for inner elements
		e.openScope();

		BTBlock current = null;

		LinkedList<BTBase> behaviors = new LinkedList<BTBase>();
		for (SimplePlusStmt el : children)
			behaviors.push(el.inferBehavior(e));

		for (BTBase b : behaviors) {
			current = BTBase.add(b, current);
		}

		// close scope for this block
		e.closeScope();

		return current;
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		// apertura di un nuovo scope per il blocco
		symbolTable.openScope();

		// generazione della tabella dei simboli per gli statement del blocco
		for (SimplePlusStmt child : children)
			symbolTable = child.symbolTableGeneration(symbolTable);

		// salvo una copia della tabella dei simboli dopo aver visitato il corpo del
		// blocco prima di chiudere lo scope
		// non mi interessa quello che succede dopo la chiusura del blocco all'interno
		// del blocco stesso
		this.symbolTable = symbolTable.clone();

		// System.out.println("blocco " + this.symbolTable.toString());

		symbolTable.closeScope();

		return symbolTable;
	}

	/*
	 * Funzione per visitare un blocco funzione, lo scope non viene aperto e chiuso
	 * perché si usa quello della funzione Non si salva la tabella dei simboli, non
	 * servono informazioni. Il blocco si limita a chiamare gli statement figli
	 */
	public SymbolTable symbolTableGenerationFunctionBlock(SymbolTable symbolTable) {

		for (SimplePlusStmt child : children)
			symbolTable = child.symbolTableGeneration(symbolTable);

		// System.out.println("function block: " + symbolTable.toString());

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {

		String res = new String("");

		// System.out.println(symbolTable.toString());

		// se non e' il blocco più esterno (nestingLevel == -1) salvo il valore del
		// frame pointer in $al e salvo $fp sulla pila
		// in modo che quando si chiude il blocco si possa tornare al vecchio record di
		// attivazione (control link)
		if (nestingLevel >= 0) {
			res = res + "move $al $fp\n";
			res = res + "push $fp\n";
		}

		// inizializzo tutte le variabili del blocco a 0
		for (int i = 0; i < symbolTable.getVariablesNumberLastBlock(); i++) {
			res = res + "li $a0 0\n";
			res = res + "push $a0\n";
		}

		// se è il blocco più esterno inizializzo l'access link in modo che punti a se
		// stesso ($al = $sp - 1)
		if (nestingLevel == -1) {
			res = res + "li $t1 1\n";
			res = res + "sub $al $sp $t1\n";
		}

		// salvo il valore dell'access link sulla pila (posizione 0($fp))
		res = res + "push $al\n";

		// aggiorno il frame pointer
		res = res + "move $fp $sp\n";

		// genero il codice per gli statement del blocco
		for (SimplePlusStmt child : children)
			res = res + child.codeGeneration(nestingLevel + 1);

		// faccio pop delle variabili del blocco e del valore di $al (il + 1) che è in
		// cima alla pila
		for (int i = 0; i < symbolTable.getVariablesNumberLastBlock() + 1; i++)
			res = res + "pop\n";

		// se è il blocco più esterno non devo gestire il control link, basta mettere
		// halt
		if (nestingLevel == -1)
			res = res + "halt\n";
		else {
			// tramite il control link rimetto il vecchio valore di $fp
			res = res + "top $fp\n";
			res = res + "pop\n";
		}

		return res;
	}

	/*
	 * Le operazioni di gestione del blocco sono gestite dalla funzione, il blocco
	 * deve solo chiamare gli statement figli
	 */
	public String codeGenerationFunctionBlock(Integer nestingLevel) {

		String res = new String("");

		for (SimplePlusStmt child : children)
			res = res + child.codeGeneration(nestingLevel + 1);

		return res;
	}
}
