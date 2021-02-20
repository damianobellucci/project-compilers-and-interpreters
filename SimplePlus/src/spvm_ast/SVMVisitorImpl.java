package spvm_ast;

import java.util.LinkedList;
import java.util.List;

import spvm_parser.SPVMBaseVisitor;
import spvm_parser.SPVMParser.AssemblyContext;
import spvm_parser.SPVMParser.ProgramContext;

public class SVMVisitorImpl extends SPVMBaseVisitor<SVMElementBase> {
	
	@Override
	public SVMElementBase visitProgram(ProgramContext ctx) {
		
		List<SVMInstruction> children = new LinkedList<SVMInstruction>();
	
		for(AssemblyContext assemblyCtx : ctx.assembly())
			children.add((SVMInstruction) visitAssembly(assemblyCtx));
		
		return new SVMProgram(children);
	}
	
	@Override
	public SVMElementBase visitAssembly(AssemblyContext ctx) {
		String instruction = ctx.instr.getText();
		
		switch(instruction) {
			case "push":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, null, null);
			case "pop":
				return new SVMInstruction(instruction, null, null, null, null);
			case "top":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, null, null);
			case "add":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "sub":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "mult":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "div":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "neg":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), null);
			case "and":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "or":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "not":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), null);
			case "eq":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "neq":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "geq":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "leq":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "gr":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "ls":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "sw":
				return new SVMInstruction(instruction, ctx.arg1.getText(), Integer.parseInt(ctx.offset.getText()), ctx.arg2.getText(), null);
			case "lw":
				return new SVMInstruction(instruction, ctx.arg1.getText(), Integer.parseInt(ctx.offset.getText()), ctx.arg2.getText(), null);
			case "smem":
				return new SVMInstruction(instruction, ctx.arg1.getText(), Integer.parseInt(ctx.offset.getText()), ctx.arg2.getText(), null);
			case "lmem":
				return new SVMInstruction(instruction, ctx.arg1.getText(), Integer.parseInt(ctx.offset.getText()), ctx.arg2.getText(), null);
			case "b":
				return new SVMInstruction(instruction, null, null, null, ctx.arg3.getText());
			case "beq":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "bleq":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "bgeq":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "addi":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), ctx.arg3.getText());
			case "li":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), null);
			case "move":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, ctx.arg2.getText(), null);
			case "jal":
				return new SVMInstruction(instruction, null, null, null, ctx.arg3.getText());
			case "jr":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, null, null);
			case "print":
				return new SVMInstruction(instruction, ctx.arg1.getText(), null, null, null);
			case "halt":
				return new SVMInstruction(instruction, null, null, null, null);
			default:	//label
				return new SVMInstruction(instruction, null, null, null, null);
		}
	}
}
