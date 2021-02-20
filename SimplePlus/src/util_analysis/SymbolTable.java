package util_analysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import util_analysis.Variable;

public class SymbolTable {

	//lista dell'offset da usare in caso di dichiarazione di una nuova funzione per ogni blocco
	private LinkedList<Integer> offsetCounter = new LinkedList<Integer>();
	
	//lista degli ambienti con collegamento nomeVariabile - datiVariabile
	private LinkedList<HashMap<String, Variable>> variables = new LinkedList<HashMap<String, Variable>>();
	
	//elenco delle funzioni del programma
	private HashMap<String, Function> functions = new HashMap<String, Function>();
	
	//id dell'ultima funzione dichiarata
	private String lastFunctionId;
	
	public SymbolTable() {}
	
	public SymbolTable(LinkedList<Integer> offsetCounter, LinkedList<HashMap<String, Variable>> variables, HashMap<String, Function> functions) {
		
		this.offsetCounter = offsetCounter;
		this.variables = variables;
		this.functions = functions;
	}
	
	/**
	 * Aggiunta di una nuova variabile allo scope
	 */
	public void addVariable(String id, boolean reference) {
		
		//se il blocco attuale contiene già la variabile id significa che è stata cancellata (se non così non fosse l'analisi semantica avrebbe già trovato l'errore)
		//e si sta definendo una nuova variabile con lo stesso nome
		//non si cambiano le informazioni su offset e livello di nesting, si aggiorna il tipo di passaggio (riferimento o valore)
		if(variables.peek().containsKey(id)) {			
			Variable oldVar = variables.peek().get(id);
			
			Variable var = new Variable(id, oldVar.getOffset(), reference, oldVar.getNestingLevel(), false);
			
			variables.peek().remove(id);
			
			variables.peek().put(id, var);
			
		} else {
			//caso in cui si dichiara una nuova variabile mai utilizzata prima
			
			int offset = offsetCounter.getFirst();
			
			offsetCounter.pop();
			
			//creazione di una nuova variabile, offset e livello di nesting sono calcolati dalla tabella dei simboli
			Variable var = new Variable(id, offset, reference, variables.size() - 1, false);
			
			variables.peek().put(id, var);
			
			offsetCounter.push(offset + 1);
		}
		
		return;
	}
	
	/**
	 * Cancellazione di una variabile dallo scope
	 * La variabile viene marcata come cancellata
	 * Per scopi di debugging, i controlli sono già stati fatti in fasi precedenti della compilazione
	 */
	public void deleteVariable(String id){
		
		for(HashMap<String, Variable> block : variables)
			if(block.containsKey(id))
				block.get(id).setDeleted(true);
			
		return;
	}
	
	/**
	 * Informazioni sul tipo di passaggio di una variabile (valore o riferimento)
	 */
	public Boolean isVariableReference(String id) {
		
		for(HashMap<String, Variable> block : variables)
			if(block.containsKey(id))
				return block.get(id).isReference();
		
		return null;
	}
	
	/**
	 * Informazioni sul livello di annidamento di una variabile
	 */
	public Integer getVariableNestingLevel(String id) {
		
		for(HashMap<String, Variable> block : variables)
			if(block.containsKey(id))
				return block.get(id).getNestingLevel();
		
		return null;
	}
	
	/**
	 * Informazioni sull'offset di una variabile rispetto al frame pointer
	 */
	public Integer getVariableOffset(String id) {
		
		for(HashMap<String, Variable> block : variables)
			if(block.containsKey(id))
				return block.get(id).getOffset();
		
		return null;
	}
	
	/**
	 * Informazioni sulle variabili dichiarate nell'ultimo scope definito
	 */
	public Integer getVariablesNumberLastBlock() {
		
		return variables.peek().size();
	}
	
	/**
	 * Informazioni sul numero di variabili dato il numero del blocco
	 * Usato nel return per sapere quante pop bisogna fare per i blocchi compresi tra il blocco del return e quello della funzione
	 * Il primo blocco è il blocco 0
	 */
	public Integer getVariablesNumberBlock(Integer index) {
		
		return variables.get(index).size();
	}
	
	/**
	 * Aggiunta di una funzione alla lista delle funzioni
	 * Le funzioni non appartengono a uno scope
	 */
	public void addFunction(String id, String label, List<Variable> paramsRef, Integer variablesNumber) {
		
		Function function = new Function(label, null, paramsRef, variablesNumber);
		
		functions.put(id, function);
		
		return;
	}
	
	/**
	 * Aggiornamento del livello di nesting di una funzione
	 */
	public void setFunctionNestingLevel(String id, String label, int nestingLevel) {
		
		List<Variable> paramsRef = functions.get(id).getParamsRef();
		Integer variablesNumber = functions.get(id).getVariablesNumber();
		
		//quando dichiaro una nuova funzione aggiorno l'id dell'ultima funzione dichiarata
		lastFunctionId = id;

		//aggiornamento del livello di annidamento della funzione
		Function function = new Function(label, nestingLevel, paramsRef, variablesNumber);
		
		functions.replace(id, function);
		
		return;
	}
	
	/**
	 * Richiesta dell'id dell'ultima funzione dichiarata
	 * Usato dal return per recuperare le informazioni della funzione da cui si sta uscendo
	 */
	public String getLastFunctionId() {
		
		return lastFunctionId;
	}
	
	/**
	 * Informazioni sul livello di annidamento di una funzione
	 * Usato dal return per recuperare le informazioni della funzione da cui si sta uscendo
	 */
	public int getFunctionNestingLevel(String id) {
		
		return functions.get(id).nestingLevel;
	}
	
	/**
	 * Informazioni sull'etichetta di una funzione dato l'id
	 * Usata dalla chiamata di funzione per la generazione di codice
	 */
	public String getFunctionLabel(String id) {
		
		return functions.get(id).label;
	}
	
	/**
	 * Informazioni sul numero di parametri di una funzione
	 * Usata dalla chiamata di funzione per la creazione del record di attivazione della funzione
	 */
	public Integer getFunctionVariablesNumber(String id) {
		
		return functions.get(id).variablesNumber;
	}	
	
	/**
	 * Informazioni sul tipo di passaggio dei parametri di una funzione 
	 */
	public List<Variable> getFunctionParamsRef(String id) {
		
		return functions.get(id).getParamsRef();
	}
	
	/** 
	 * Apertura di un nuovo scope
	 */
	public void openScope() {
		
		variables.push(new HashMap<String, Variable>());
		
		offsetCounter.push(1);	//inizializzo l'offset a 1 quando entro in un nuovo scope (a 0 c'è $al)
	}
	
	/**
	 * Uscita dallo scope attuale
	 */
	public void closeScope(){
			variables.pop();
		
		//si rimuove l'ultimo contatore per l'offset
		offsetCounter.pop();
		
		return;
	}
	
	/**
	 * Copia in profondità della tabella dei simboli nel caso in cui si volesse una copia della tabella attuale
	 */
	public SymbolTable clone() {
		
		return new SymbolTable(new LinkedList<Integer>(offsetCounter), new LinkedList<HashMap<String, Variable>>(variables), new HashMap<String, Function>(functions));
	}
	
	@Override
	public String toString() {
		
		return new String(variables.toString() + "   " + functions.toString());
	}
}
