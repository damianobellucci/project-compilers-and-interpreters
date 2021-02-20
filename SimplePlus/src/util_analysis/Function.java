package util_analysis;

import java.util.List;

public class Function {
	
	String label;
	Integer nestingLevel;
	List<Variable> paramsRef;
	Integer variablesNumber;
	
	public Function(String label, Integer nestingLevel, List<Variable> paramsRef, Integer variablesNumber) {
		
		this.label = label;
		this.nestingLevel = nestingLevel;
		this.paramsRef = paramsRef;
		this.variablesNumber = variablesNumber;
	}
	
	@Override
	public String toString() {
		
		return new String(label + " " + nestingLevel + " " + paramsRef);
	}
	
	public List<Variable> getParamsRef() {
		
		return paramsRef;
	}
	
	public Integer getVariablesNumber() {
		
		return variablesNumber;
	}
}