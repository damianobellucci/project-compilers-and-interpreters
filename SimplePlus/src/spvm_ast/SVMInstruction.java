package spvm_ast;

import interpreter.Node;

public class SVMInstruction extends SVMElementBase {
	private String instr;
	private String arg1;
	private Integer offset;
	private String arg2;
	private String arg3;
	
	public SVMInstruction(String instr, String arg1, Integer offset, String arg2, String arg3) {
		
		this.instr = instr;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.offset = offset;
	}
	
	public Node buildNode() {
		
		return new Node(instr, arg1, offset, arg2, arg3);
	}
}
