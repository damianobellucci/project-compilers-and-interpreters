package main;
//gruppo composto da: Bellucci Damiano, Contini Nicolo', Harrati Soukaina

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.BitSet;
import java.util.List;
import util_analysis.Environment;
import util_analysis.LexerParserException;
import util_analysis.SemanticError;
import util_analysis.SymbolTable;
import ast.SimplePlusBlock;
import ast.SimplePlusVisitorImpl;
import behavioural_analysis.BTBlock;
import interpreter.BytecodeException;
import interpreter.Interpreter;
import interpreter.Node;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import parser.SimplePlusLexer;
import parser.SimplePlusParser;
import spvm_ast.SVMProgram;
import spvm_ast.SVMVisitorImpl;
import spvm_parser.SPVMLexer;
import spvm_parser.SPVMParser;
import java.io.File;

public class AnalyseDebug {

	public static void main(String[] args) {

		String[] pathnames;
		File f = new File("./testStack");
		pathnames = f.list();

		for (String pathname : pathnames) {
			String fileName = "testStack/" + pathname;

			try {

				FileWriter errorWriter = null;

				try {

					// output file for errors
					errorWriter = new FileWriter("out.txt");

					FileWriter codeWriter = new FileWriter("code.btc");

					FileInputStream is = new FileInputStream(fileName);
					ANTLRInputStream input = new ANTLRInputStream(is);

					// create lexer
					SimplePlusLexer lexer = new SimplePlusLexer(input);

					// remove default error listeners
					lexer.removeErrorListeners();

					// add new error listener
					lexer.addErrorListener(new BaseErrorListener() {

						@Override
						public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4,
								RecognitionException arg5) {

							throw new LexerParserException(new String("line " + arg2 + ":" + arg3 + " " + arg4 + "\n"));
						}
					});

					// create parser
					CommonTokenStream tokens = new CommonTokenStream(lexer);
					SimplePlusParser parser = new SimplePlusParser(tokens);

					// remove default error listeners
					parser.removeErrorListeners();

					// add new error listener
					parser.addErrorListener(new BaseErrorListener() {

						@Override
						public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4,
								RecognitionException arg5) {

							throw new LexerParserException(new String("line " + arg2 + ":" + arg3 + " " + arg4 + "\n"));
						}
					});

					// tell the parser to build the AST
					parser.setBuildParseTree(true);

					// build custom visitor
					SimplePlusVisitorImpl visitor = new SimplePlusVisitorImpl();

					SimplePlusBlock mainBlock = null;

					// visit the root, this will recursively visit the whole tree
					mainBlock = (SimplePlusBlock) visitor.visitBlock(parser.block());

					System.out.println(pathname + ": " + "Check lexical/syntactic succeded");

					// check semantics
					// give a fresh environment, no need to make it persist
					List<SemanticError> errors = mainBlock.checkSemantics(new Environment());

					// this means the semantic checker found some errors
					if (errors.size() > 0) {
						System.out.println(pathname + ": " + "Check semantics FAILED");
						System.out.println(errors.get(0).toString());
						break;
					} else {
						// controllo tipi
						mainBlock.checkType(new Environment());

						System.out.println(pathname + ": " + "Check semantics succeded\n");

						codeWriter.close();

						// interpretation();
					}
				} catch (LexerParserException e) {

					System.out.println(pathname + ": " + "Check lexical/syntactic FAILED");
				

					errorWriter.write(e.toString());
					break;

				} catch (SemanticError e) {
					System.out.println(pathname + ": " + "Check type FAILED");
					errorWriter.write(e.toString());
				}

				errorWriter.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	public static boolean checkDoubleDeclarations(List<SemanticError> errors) {

		if (errors.size() > 0) {
			for (SemanticError err : errors)
				if (err.toString().contains("Double declaration of same variable name in one block:"))
					return false;
		}

		return true;
	}

	public static void interpretation() {

		String fileName = "code.btc";

		try {
			FileInputStream is = new FileInputStream(fileName);
			ANTLRInputStream input = new ANTLRInputStream(is);

			// output file for errors
			FileWriter myWriter = new FileWriter("bytecodeErrors.txt");

			// create lexer
			SPVMLexer lexer = new SPVMLexer(input);

			// remove default error listeners
			lexer.removeErrorListeners();

			// add new error listener
			lexer.addErrorListener(new BaseErrorListener() {

				@Override
				public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4,
						RecognitionException arg5) {

					throw new BytecodeException(new String("" + arg2 + ":" + arg3), new String(arg4));
				}
			});

			// create parser
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			SPVMParser parser = new SPVMParser(tokens);

			// remove default error listeners
			parser.removeErrorListeners();

			// add new error listener
			parser.addErrorListener(new BaseErrorListener() {

				@Override
				public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2, int arg3, String arg4,
						RecognitionException arg5) {

					throw new BytecodeException(new String("" + arg2 + ":" + arg3), new String(arg4));
				}
			});

			// tell the parser to build the AST
			parser.setBuildParseTree(true);

			// build custom visitor
			SVMVisitorImpl visitor = new SVMVisitorImpl();

			SVMProgram program = (SVMProgram) visitor.visitProgram(parser.program());

			List<Node> code = program.buildNodes();

			Interpreter interpreter = new Interpreter(code);

			interpreter.prepareCode();

			interpreter.run(true);

			myWriter.close();

		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (BytecodeException bytecodeException) {
			try {
				// output file for errors
				FileWriter myWriter = new FileWriter("bytecodeErrors.txt");

				myWriter.write(bytecodeException.toString());

				myWriter.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}
}