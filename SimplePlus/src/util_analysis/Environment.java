package util_analysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ast.SimplePlusArg;

public class Environment {

	// mappatura tra parametri formali e parametri attuali di una funzione
	String lastFunctionId;
	
	//coppia nomi parametro formale->attuale dell'ultima funzione, attuale è '' se è espressione
	public HashMap<String,String> lastFunctionArgsAliasing = new HashMap<String, String>();
	
	//coppia nome_funzione->parametri formali funzione
	public HashMap<String, List<SimplePlusArg>> functionsArgs = new HashMap<String, List<SimplePlusArg>>();
	// contains the stack of scopes. the last one is always the current active scope
	// this linked list is used as a stack with LIFO behavior
	LinkedList<HashMap<String, ScopeVariable>> scopes = new LinkedList<HashMap<String, ScopeVariable>>();
	int nestingLevel = 0;

	// si aggiunge una variabile allo scope locale
	public void addVariable(ScopeVariable variable) {
		scopes.peek().put(variable.getId(), variable);
	}

	/**
	 * Inserts a new scope into the environment. When a scope is inserted old scope
	 * is clone so previous defined variables still exist
	 */
	public void openScope() {
		this.nestingLevel++;
		scopes.push(new HashMap<String, ScopeVariable>());
	}

	/**
	 * Drops the current scope and returns to the outer scope removing all changes
	 * and additions done within this scope
	 */
	public void closeScope() {
		this.nestingLevel--;
		scopes.pop();
	}

	/**
	 * DA TOGLIERE? Con questo metodo si fa il check se la variabile è contenuta
	 * nello scope corrente (l'ultimo aperto)
	 */
	public boolean containsLocalVariable(String id) {
		if (scopes.peek().containsKey(id))
			return true;

		return false;
	}

	/**
	 * Given an id determines if the variable belongs to the environment this is to
	 * check the scopes from inner to outer looking for the variable
	 * 
	 * @param id
	 */
	public boolean containsVariable(String id) {
		for (HashMap<String, ScopeVariable> scope : scopes) {
			if (scope.containsKey(id))
				return true;
		}
		return false;
	}

	/**
	 * Remove the variable with the given id from the first scope that contains it
	 * notice that if the variable exists in an outer scope it will have that value
	 * 
	 * @param id
	 */
	public void deleteVariable(String id) {
		for (HashMap<String, ScopeVariable> scope : scopes) {
			if (scope.containsKey(id)) {
				scope.remove(id);
				return;
			}
		}
	}

	/**
	 * Check for variable
	 * 
	 * @param id of the variable
	 * @return variable value, null if the variable doesnt exist
	 */
	public Integer getVariable(String id) {
		for (HashMap<String, ScopeVariable> scope : scopes) {
			if (scope.containsKey(id)) {
				return scope.get(id).getValue();
			}
		}
		return null;
	}

	/**
	 * Check local scope for variable
	 * 
	 * @param id of the variable
	 * @return variable value in current scope, null otherwise
	 */
	public Integer getVariableValueLocal(String id) {

		return scopes.peek().get(id).getValue();

	}

	public void debugPrintEnvironment() {
		System.out.println("Inizio environment");
		for (HashMap<String, ScopeVariable> scope : scopes) {
			System.out.println("Inizio scope");
			Set<String> variables = scope.keySet();
			for (String var : variables) {
				ScopeVariable variable = scope.get(var);
				String tipo = variable.getType();
				String identificatore = variable.getId();
				Integer valore = variable.getValue();
				System.out.println("Type: " + tipo + " Id: " + identificatore + " Value: " + valore);
			}
			System.out.println("Fine scope");
		}
		System.out.println("Fine environment");
	}

	public String getVariableType(String id) {
		for (HashMap<String, ScopeVariable> scope : scopes) {
			if (scope.containsKey(id)) {
				return scope.get(id).getType();
			}
		}
		return null;
	}

	public void updateVariable(String id, Integer value) {
		for (HashMap<String, ScopeVariable> scope : scopes) {
			if (scope.containsKey(id)) {
				scope.get(id).setValue(value);
			}
		}
	}

	public void updateVariableInizialization(String id, Boolean inizialization) {
		for (HashMap<String, ScopeVariable> scope : scopes) {
			if (scope.containsKey(id)) {
				scope.get(id).setInizialized(inizialization);
			}
		}
	}

	public boolean variableInizialized(String id) {
		for (HashMap<String, ScopeVariable> scope : scopes) {
			if (scope.containsKey(id)) {
				return scope.get(id).getInizialized();
			}
		}
		return false;
	}

	public String getLastFunctionId() {
		return lastFunctionId;
	}

	public void setLastFunctionId(String lastFunctionId) {
		this.lastFunctionId = lastFunctionId;
	}

	public int getNestingLevel() {
		return nestingLevel;
	}

}
