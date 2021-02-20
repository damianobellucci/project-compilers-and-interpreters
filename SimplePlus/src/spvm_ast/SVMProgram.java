package spvm_ast;

import java.util.ArrayList;
import java.util.List;

import interpreter.Node;

public class SVMProgram extends SVMElementBase {
	
	private List<SVMInstruction> children;
	
	public SVMProgram(List<SVMInstruction> children) {
		
		this.children = children;
	}
	
	public List<Node> buildNodes() {
		
		List<Node> nodes = new ArrayList<Node>();
		
		for(SVMInstruction instr : children) {
			nodes.add(instr.buildNode());
		}
		
		return nodes;
	}
}
