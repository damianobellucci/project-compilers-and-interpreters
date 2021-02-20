package util_analysis;

import ast.SimplePlusExp;

//questa classe è stata creata per essere usata come supporto, sia in checkSemantics, sia in checkTipe

public class ScopeVariable {
	private String id;
	private String type;
	private Integer value;
	private Boolean inizialized;
	private Boolean reference;

	public ScopeVariable() {
		this.id = null;
		this.type = null;
		this.value = null;
		this.inizialized = false;
	}

	public ScopeVariable setId(String id) {
		this.id = id;
		return this;
	}

	public Boolean getReference() {
		return reference;

	}

	public ScopeVariable setReference(Boolean reference) {
		this.reference = reference;
		return this;
	}

	public ScopeVariable setType(String type) {
		this.type = type;
		return this;
	}

	public ScopeVariable setValue(Integer exp) {
		this.value = exp;
		return this;
	}

	public String getId() {
		return this.id;
	}

	public String getType() {
		return this.type;
	}

	public Integer getValue() {
		return this.value;
	}

	public Boolean getInizialized() {
		return inizialized;
	}

	public ScopeVariable setInizialized(Boolean inizialized) {
		this.inizialized = inizialized;
		return this;
	}
}
