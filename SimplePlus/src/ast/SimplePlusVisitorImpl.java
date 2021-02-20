package ast;

import java.util.LinkedList;
import java.util.List;

import parser.SimplePlusBaseVisitor;
import parser.SimplePlusParser;
import parser.SimplePlusParser.ArgContext;
import parser.SimplePlusParser.AssignmentContext;
import parser.SimplePlusParser.BaseExpContext;
import parser.SimplePlusParser.BinExpContext;
import parser.SimplePlusParser.BlockContext;
import parser.SimplePlusParser.BoolExpContext;
import parser.SimplePlusParser.CallContext;
import parser.SimplePlusParser.CallExpContext;
import parser.SimplePlusParser.DecFunContext;
import parser.SimplePlusParser.DecVarContext;
import parser.SimplePlusParser.DeclarationContext;
import parser.SimplePlusParser.DeletionContext;
import parser.SimplePlusParser.ExpContext;
import parser.SimplePlusParser.IteContext;
import parser.SimplePlusParser.NegExpContext;
import parser.SimplePlusParser.NotExpContext;
import parser.SimplePlusParser.PrintContext;
import parser.SimplePlusParser.RetContext;
import parser.SimplePlusParser.StatementContext;
import parser.SimplePlusParser.ValExpContext;
import parser.SimplePlusParser.VarExpContext;

public class SimplePlusVisitorImpl extends SimplePlusBaseVisitor<SimplePlusElementBase> {
	
	@Override
	public SimplePlusElementBase visitBlock(BlockContext ctx) {

		List<SimplePlusStmt> children = new LinkedList<SimplePlusStmt>();

		for(StatementContext stmtCtx : ctx.statement())
			children.add((SimplePlusStmt) visitStatement(stmtCtx));

		return new SimplePlusBlock(children);
	}
	
	@Override
	public SimplePlusElementBase visitStatement(StatementContext ctx) {
		
		return visit(ctx.getChild(0));
	}
	
	@Override
	public SimplePlusElementBase visitDeclaration(DeclarationContext ctx) {
		
		return visit(ctx.getChild(0));
	}
	
	@Override
	public SimplePlusElementBase visitDecFun(DecFunContext ctx) {
		
		List<SimplePlusArg> args = new LinkedList<SimplePlusArg>();

		if(ctx.arg() != null)
			for(ArgContext argCtx : ctx.arg())
				args.add((SimplePlusArg) visitArg(argCtx));
			
		return new SimplePlusDecFun(
				ctx.ID().getText(),
				args,
				(SimplePlusBlock) visitBlock(ctx.block()),
				ctx.type().getText());
	}
	
	@Override
	public SimplePlusElementBase visitDecVar(DecVarContext ctx) {
		
		SimplePlusExp exp = null;
		
		if(ctx.exp() != null)
			exp = (SimplePlusExp) visit(ctx.exp());
			
		return new SimplePlusDecVar(
				ctx.ID().getText(),
				exp,
				ctx.type().getText());
	}
	
	//@Override public T visitType(SimplePlusParser.TypeContext ctx) { return visitChildren(ctx); }
	
	@Override
	public SimplePlusElementBase visitArg(ArgContext ctx) {
	
		boolean reference = false;
		
		if(ctx.ref() != null)
			reference = true;
		
		return new SimplePlusArg(ctx.type().getText(), ctx.ID().getText(), reference);
	}
	
	//@Override public T visitRef(SimplePlusParser.RefContext ctx) { return visitChildren(ctx); }
	
	@Override
	public SimplePlusElementBase visitAssignment(AssignmentContext ctx) {

		return new SimplePlusAssignment(ctx.ID().getText(), (SimplePlusExp) visit(ctx.exp())) ;
	}
	
	@Override
	public SimplePlusElementBase visitDeletion(DeletionContext ctx) {

		return new SimplePlusDelete(ctx.ID().getText());
	}
	
	@Override
	public SimplePlusElementBase visitPrint(PrintContext ctx) {

		SimplePlusExp exp = (SimplePlusExp) visit(ctx.exp());
		
		return new SimplePlusStmtPrint(exp);
	}
	
	@Override
	public SimplePlusElementBase visitRet(RetContext ctx) {
		
		SimplePlusExp exp = null;
		
		if(ctx.exp() != null)
			exp = (SimplePlusExp) visit(ctx.exp());
		
		return new SimplePlusStmtReturn(exp);
	}
	
	@Override
	public SimplePlusElementBase visitIte(IteContext ctx) {
		
		SimplePlusExp exp = (SimplePlusExp) visit(ctx.exp());
		
		SimplePlusStmt thenStmt = (SimplePlusStmt) visitStatement(ctx.statement(0));
		SimplePlusStmt elseStmt = null;
		
		if(ctx.statement(1) != null)
			elseStmt = (SimplePlusStmt) visitStatement(ctx.statement(1));
		
		return new SimplePlusStmtIte(exp, thenStmt, elseStmt);
	}
	
	@Override
	public SimplePlusElementBase visitCall(CallContext ctx) {
		
		List<SimplePlusExp> args = new LinkedList<SimplePlusExp>();
		
		if(ctx.exp() != null)
			for(ExpContext expCtx : ctx.exp())
				args.add((SimplePlusExp) visit(expCtx));
		
		return new SimplePlusCall(ctx.ID().getText(), args);
	}
	
	@Override
	public SimplePlusElementBase visitBaseExp(BaseExpContext ctx) {
		
		return visit(ctx.exp());
	}
	
	@Override
	public SimplePlusElementBase visitVarExp(VarExpContext ctx) {
		
		return new SimplePlusExpVar(ctx.ID().getText());
	}
	
	@Override
	public SimplePlusElementBase visitBinExp(BinExpContext ctx) {

		SimplePlusExp left = (SimplePlusExp) visit(ctx.left);

		SimplePlusExp right = (SimplePlusExp) visit(ctx.right);

		switch (ctx.op.getText()) {
			case "+":  return new SimplePlusExpSum(left, right);
			case "-":  return new SimplePlusExpDiff(left, right);
			case "*":  return new SimplePlusExpMult(left, right);
			case "/":  return new SimplePlusExpDiv(left, right);
			case ">":  return new SimplePlusExpGreater(left, right);
			case "<":  return new SimplePlusExpLess(left, right);
			case ">=": return new SimplePlusExpGreaterEqual(left, right);
			case "<=": return new SimplePlusExpLessEqual(left, right);
			case "==": return new SimplePlusExpEqual(left, right);
			case "!=": return new SimplePlusExpNotEqual(left, right);
			case "&&": return new SimplePlusExpAnd(left, right);
			case "||": return new SimplePlusExpOr(left, right);	
			default: return null; //this should not happen
		}
	}
	
	@Override
	public SimplePlusElementBase visitValExp(ValExpContext ctx) {
		
		return new SimplePlusExpVal(Integer.parseInt(ctx.NUMBER().getText()));
	}
	
	@Override
	public SimplePlusElementBase visitNegExp(NegExpContext ctx) {
		
		return new SimplePlusExpNeg((SimplePlusExp) visit(ctx.exp()));
	}
	
	@Override
	public SimplePlusElementBase visitBoolExp(BoolExpContext ctx) {

		return new SimplePlusExpBool(Boolean.parseBoolean(ctx.BOOL().getText()));
	}
	
	@Override
	public SimplePlusElementBase visitCallExp(CallExpContext ctx) {
		
		List<SimplePlusExp> args = new LinkedList<SimplePlusExp>();
		
		if(ctx.call().exp() != null)
			for(ExpContext expCtx : ctx.call().exp())
				args.add((SimplePlusExp) visit(expCtx));
		
		return new SimplePlusExpCall(ctx.call().ID().getText(), args);
	}
	
	@Override
	public SimplePlusElementBase visitNotExp(NotExpContext ctx) {
		
		return new SimplePlusExpNot((SimplePlusExp) visit(ctx.exp()));
	}
}
