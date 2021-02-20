package ast;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.parse.ANTLRParser.throwsSpec_return;

import behavioural_analysis.BTBase;
import util_analysis.Environment;
import util_analysis.SemanticError;
import util_analysis.Strings;
import util_analysis.SymbolTable;
import util_analysis.TypeError;
import util_analysis.LabelGenerator;
import util_analysis.ScopeVariable;

public class SimplePlusStmtIte extends SimplePlusStmt {
	SimplePlusExp exp;
	SimplePlusStmt thenStmt;
	SimplePlusStmt elseStmt;

	public SimplePlusStmtIte(SimplePlusExp exp, SimplePlusStmt thenStmt, SimplePlusStmt elseStmt) {

		this.exp = exp;
		this.thenStmt = thenStmt;
		this.elseStmt = elseStmt;
	}

	@Override
	public List<SemanticError> checkSemantics(Environment e) {
		List<SemanticError> res = new LinkedList<SemanticError>();

		res.addAll(exp.checkSemantics(e));

		if (!thenStmt.getClass().getSimpleName().equals("SimplePlusBlock")
				|| (elseStmt != null && !elseStmt.getClass().getSimpleName().equals("SimplePlusBlock"))) {
			res.add(new SemanticError(Strings.errorThenOrElseNotBlocks));
		}

		else if (res.size() == 0) {
			res.addAll(thenStmt.checkSemantics(e));
			if (res.size() == 0 && elseStmt != null)
				res.addAll(elseStmt.checkSemantics(e));
		}

		return res;
	}

	@Override
	public String checkType(Environment e) throws TypeError {
		exp.checkType(e);
		if (!exp.checkType(e).equals("bool"))
			throw new TypeError(Strings.IfConditionNotBoolean);
		thenStmt.checkType(e);
		if (elseStmt != null) {
			elseStmt.checkType(e);
		}
		return null;
	}

	@Override
	public BTBase inferBehavior(Environment e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SymbolTable symbolTableGeneration(SymbolTable symbolTable) {

		// generazione della tabella dei simboli delle parti dell'if-then-else
		symbolTable = exp.symbolTableGeneration(symbolTable);

		symbolTable = thenStmt.symbolTableGeneration(symbolTable);

		if (elseStmt != null)
			symbolTable = elseStmt.symbolTableGeneration(symbolTable);

		return symbolTable;
	}

	@Override
	public String codeGeneration(Integer nestingLevel) {

		String res = new String("");

		// genero delle nuove etichette
		String elseLabel = LabelGenerator.newLabel();
		String endLabel = LabelGenerator.newLabel();

		res = res + exp.codeGeneration(nestingLevel);
		res = res + "li $t1 0\n";
		res = res + "beq $a0 $t1 " + elseLabel + "\n";
		res = res + thenStmt.codeGeneration(nestingLevel);
		res = res + "b " + endLabel + "\n";
		res = res + elseLabel + ":\n"; // genero comunque l'etichetta dell'else, se non c'è arrivo un'istruzione dopo
										// all'etichetta di fine if-then-else

		if (elseStmt != null)
			res = res + elseStmt.codeGeneration(nestingLevel);

		res = res + endLabel + ":\n";

		return res;
	}
}
