package ast;

import java.util.LinkedList;
import java.util.List;
import util_analysis.Strings;
import util_analysis.SymbolTable;
import util_analysis.Environment;
import util_analysis.SemanticError;

public class SimplePlusExpVar extends SimplePlusExp {

	public String id;
	private SymbolTable symbolTable;

	public SimplePlusExpVar(String id) {
		this.id = id;
	}
		
	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> result = new LinkedList<SemanticError>();

		if(!e.containsVariable(id))
			result.add(new SemanticError(Strings.ErrorVariableDoesntExist + id));
		else {
			if(!e.variableInizialized(id))
				result.add(new SemanticError(Strings.ErrorVariableNotInizialized + id));
		}
		return result;
	}
	
	@Override
	public String checkType(Environment e) {
		//System.out.println(e.containsLocalVariable(id));
		return e.getVariableType(this.id);
	}


	@Override
	public int getValue(Environment e) {
		//if(e.getVariable(id)==null)  throw new IllegalAccessException();
		return e.getVariable(id);
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {
		
		//salvo una copia della tabella dei simboli attuale, non mi interessano le modifiche future
		this.symbolTable = symbolTable.clone();
		
		//System.out.println("expvar: " + id + " " + symbolTable.toString());
		
		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {
		
		String res = new String("");
		
		/*System.out.println("nestLvl param " + nestingLevel);
		System.out.println("nestLvl locale " + id + " " + symbolTable.getVariableNestingLevel(id));*/
		
		if(symbolTable.isVariableReference(id)) {
			
			System.out.println("-----------reference " + id);
			//se la variabile è passata per riferimento significa che si trova in una funzione
			//carico il valore usando l'indirizzo di memoria
			
			if(nestingLevel != symbolTable.getVariableNestingLevel(id)) {
				
				res = res + "lw $al 0($fp)\n";
				
				//forse i = 0
				for(int i = 1;i < nestingLevel - symbolTable.getVariableNestingLevel(id);i++)
					res = res + "lw $al 0($al)\n";
				
				res = res + "lmem $a0 " + symbolTable.getVariableOffset(id) + "($al)\n";
			} else
				res = res + "lmem $a0 " + symbolTable.getVariableOffset(id) + "($fp)\n";
		} else {
		
			//carico la variabile normalmente scorrendo tra i record di attivazione
			if(nestingLevel != symbolTable.getVariableNestingLevel(id)) {
				
				res = res + "lw $al 0($fp)\n";
				
				//forse i = 0
				for(int i = 1;i < nestingLevel - symbolTable.getVariableNestingLevel(id);i++)
					res = res + "lw $al 0($al)\n";
				
				res = res + "lw $a0 " + symbolTable.getVariableOffset(id) + "($al)\n";
			} else
				res = res + "lw $a0 " + symbolTable.getVariableOffset(id) + "($fp)\n";
		}
		
		return res;
	}
	
	public String codeGenerationReference(int nestingLevel) {
		
		String res = new String("");
		
		//calcolo dell'indirizzo della variabile per passare l'indirizzo alla funzione
		if(nestingLevel != symbolTable.getVariableNestingLevel(id)) {
			
			//la variabile si trova in un altro record di attivazione rispetto a quello della chiamata della funzione
			res = res + "lw $al 0($fp)\n";
			
			//forse i = 0
			for(int i = 1;i < nestingLevel - symbolTable.getVariableNestingLevel(id);i++)
				res = res + "lw $al 0($al)\n";
			
			res = res + "addi $a0 $al " + symbolTable.getVariableOffset(id) + "\n";
		} else
			//la variabile si trova nello stesso record di attivazione della chiamata alla funzione
			res = res + "addi $a0 $fp " + symbolTable.getVariableOffset(id) + "\n";
		
		return res;
	}
	
	//Metodo che serve nel caso in cui ho assegnamento di variabili, devo poter cononoscere il tipo per lanciare eventualmente errore di Mismatch
	public String getType(Environment e) {
		return e.getVariableType(id);
	}
}
