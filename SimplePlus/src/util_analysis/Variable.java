package util_analysis;

public class Variable {
	private String name;
	private Integer offset;
	private Boolean reference;
	private Integer nestingLevel;
	private Boolean deleted;
	private Boolean inizialized;
	private String type;

	public Variable(String name, Integer offset, Boolean reference, Integer nestingLevel, Boolean deleted) {

		this.name = name;
		this.offset = offset;
		this.reference = reference;
		this.nestingLevel = nestingLevel;
		this.deleted = deleted;
	}

	public Boolean isReference() {

		return reference;
	}

	public Integer getNestingLevel() {

		return nestingLevel;
	}

	public Integer getOffset() {

		return offset;
	}

	/*
	 * public Boolean isDeleted() {
	 * 
	 * return deleted; }
	 */

	public void setDeleted(Boolean deleted) {

		this.deleted = deleted;
	}

	public void setReference(Boolean reference) {

		this.reference = reference;
	}

	@Override
	public String toString() {

		return new String(
				name + " ofs: " + offset + " ref: " + reference + " nLvl: " + nestingLevel + " del: " + deleted);
	}

	public Boolean getInizialized() {
		return inizialized;
	}

	public Variable setInizialized(Boolean inizialized) {
		this.inizialized = inizialized;
		return this;
	}

	public String getType() {
		return type;
	}

	public Variable setType(String type) {
		this.type = type;
		return this;
	}
}