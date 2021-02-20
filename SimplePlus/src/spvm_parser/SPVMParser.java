// Generated from SimplePlus\src\spvmParser\SPVM.g4 by ANTLR 4.6
package spvm_parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SPVMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, LABEL=36, NUMBER=37, REGISTER=38, 
		WS=39, LINECOMMENTS=40, BLOCKCOMMENTS=41;
	public static final int
		RULE_program = 0, RULE_assembly = 1;
	public static final String[] ruleNames = {
		"program", "assembly"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'push'", "'pop'", "'top'", "'add'", "'sub'", "'mult'", "'div'", 
		"'neg'", "'and'", "'or'", "'not'", "'eq'", "'neq'", "'geq'", "'leq'", 
		"'gr'", "'ls'", "'sw'", "'('", "')'", "'lw'", "'smem'", "'lmem'", "':'", 
		"'b'", "'beq'", "'bleq'", "'bgeq'", "'addi'", "'li'", "'move'", "'jal'", 
		"'jr'", "'print'", "'halt'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"LABEL", "NUMBER", "REGISTER", "WS", "LINECOMMENTS", "BLOCKCOMMENTS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SPVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SPVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<AssemblyContext> assembly() {
			return getRuleContexts(AssemblyContext.class);
		}
		public AssemblyContext assembly(int i) {
			return getRuleContext(AssemblyContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPVMListener ) ((SPVMListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPVMListener ) ((SPVMListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPVMVisitor ) return ((SPVMVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << LABEL))) != 0)) {
				{
				{
				setState(4);
				assembly();
				}
				}
				setState(9);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssemblyContext extends ParserRuleContext {
		public Token instr;
		public Token arg1;
		public Token arg2;
		public Token arg3;
		public Token offset;
		public List<TerminalNode> REGISTER() { return getTokens(SPVMParser.REGISTER); }
		public TerminalNode REGISTER(int i) {
			return getToken(SPVMParser.REGISTER, i);
		}
		public TerminalNode NUMBER() { return getToken(SPVMParser.NUMBER, 0); }
		public TerminalNode LABEL() { return getToken(SPVMParser.LABEL, 0); }
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPVMListener ) ((SPVMListener)listener).enterAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPVMListener ) ((SPVMListener)listener).exitAssembly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPVMVisitor ) return ((SPVMVisitor<? extends T>)visitor).visitAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assembly);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				((AssemblyContext)_localctx).instr = match(T__0);
				setState(11);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				((AssemblyContext)_localctx).instr = match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(13);
				((AssemblyContext)_localctx).instr = match(T__2);
				setState(14);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(15);
				((AssemblyContext)_localctx).instr = match(T__3);
				setState(16);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(17);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(18);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(19);
				((AssemblyContext)_localctx).instr = match(T__4);
				setState(20);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(21);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(22);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(23);
				((AssemblyContext)_localctx).instr = match(T__5);
				setState(24);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(25);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(26);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(27);
				((AssemblyContext)_localctx).instr = match(T__6);
				setState(28);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(29);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(30);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 8);
				{
				setState(31);
				((AssemblyContext)_localctx).instr = match(T__7);
				setState(32);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(33);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 9);
				{
				setState(34);
				((AssemblyContext)_localctx).instr = match(T__8);
				setState(35);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(36);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(37);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 10);
				{
				setState(38);
				((AssemblyContext)_localctx).instr = match(T__9);
				setState(39);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(40);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(41);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 11);
				{
				setState(42);
				((AssemblyContext)_localctx).instr = match(T__10);
				setState(43);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(44);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 12);
				{
				setState(45);
				((AssemblyContext)_localctx).instr = match(T__11);
				setState(46);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(47);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(48);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 13);
				{
				setState(49);
				((AssemblyContext)_localctx).instr = match(T__12);
				setState(50);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(51);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(52);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 14);
				{
				setState(53);
				((AssemblyContext)_localctx).instr = match(T__13);
				setState(54);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(55);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(56);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 15);
				{
				setState(57);
				((AssemblyContext)_localctx).instr = match(T__14);
				setState(58);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(59);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(60);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 16);
				{
				setState(61);
				((AssemblyContext)_localctx).instr = match(T__15);
				setState(62);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(63);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(64);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 17);
				{
				setState(65);
				((AssemblyContext)_localctx).instr = match(T__16);
				setState(66);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(67);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(68);
				((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 18);
				{
				setState(69);
				((AssemblyContext)_localctx).instr = match(T__17);
				setState(70);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(71);
				((AssemblyContext)_localctx).offset = match(NUMBER);
				setState(72);
				match(T__18);
				setState(73);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(74);
				match(T__19);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 19);
				{
				setState(75);
				((AssemblyContext)_localctx).instr = match(T__20);
				setState(76);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(77);
				((AssemblyContext)_localctx).offset = match(NUMBER);
				setState(78);
				match(T__18);
				setState(79);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(80);
				match(T__19);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 20);
				{
				setState(81);
				((AssemblyContext)_localctx).instr = match(T__21);
				setState(82);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(83);
				((AssemblyContext)_localctx).offset = match(NUMBER);
				setState(84);
				match(T__18);
				setState(85);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(86);
				match(T__19);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 21);
				{
				setState(87);
				((AssemblyContext)_localctx).instr = match(T__22);
				setState(88);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(89);
				((AssemblyContext)_localctx).offset = match(NUMBER);
				setState(90);
				match(T__18);
				setState(91);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(92);
				match(T__19);
				}
				break;
			case LABEL:
				enterOuterAlt(_localctx, 22);
				{
				setState(93);
				((AssemblyContext)_localctx).instr = match(LABEL);
				setState(94);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 23);
				{
				setState(95);
				((AssemblyContext)_localctx).instr = match(T__24);
				setState(96);
				((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 24);
				{
				setState(97);
				((AssemblyContext)_localctx).instr = match(T__25);
				setState(98);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(99);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(100);
				((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 25);
				{
				setState(101);
				((AssemblyContext)_localctx).instr = match(T__26);
				setState(102);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(103);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(104);
				((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 26);
				{
				setState(105);
				((AssemblyContext)_localctx).instr = match(T__27);
				setState(106);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(107);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(108);
				((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 27);
				{
				setState(109);
				((AssemblyContext)_localctx).instr = match(T__28);
				setState(110);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(111);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(112);
				((AssemblyContext)_localctx).arg3 = match(NUMBER);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 28);
				{
				setState(113);
				((AssemblyContext)_localctx).instr = match(T__29);
				setState(114);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(115);
				((AssemblyContext)_localctx).arg2 = match(NUMBER);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 29);
				{
				setState(116);
				((AssemblyContext)_localctx).instr = match(T__30);
				setState(117);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(118);
				((AssemblyContext)_localctx).arg2 = match(REGISTER);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 30);
				{
				setState(119);
				((AssemblyContext)_localctx).instr = match(T__31);
				setState(120);
				((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 31);
				{
				setState(121);
				((AssemblyContext)_localctx).instr = match(T__32);
				setState(122);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 32);
				{
				setState(123);
				((AssemblyContext)_localctx).instr = match(T__33);
				setState(124);
				((AssemblyContext)_localctx).arg1 = match(REGISTER);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 33);
				{
				setState(125);
				((AssemblyContext)_localctx).instr = match(T__34);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u0083\4\2\t\2\4"+
		"\3\t\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3\u0081\n\3\3\3\2\2\4\2\4\2\2\u00a1\2\t\3\2\2\2\4\u0080"+
		"\3\2\2\2\6\b\5\4\3\2\7\6\3\2\2\2\b\13\3\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2"+
		"\n\3\3\2\2\2\13\t\3\2\2\2\f\r\7\3\2\2\r\u0081\7(\2\2\16\u0081\7\4\2\2"+
		"\17\20\7\5\2\2\20\u0081\7(\2\2\21\22\7\6\2\2\22\23\7(\2\2\23\24\7(\2\2"+
		"\24\u0081\7(\2\2\25\26\7\7\2\2\26\27\7(\2\2\27\30\7(\2\2\30\u0081\7(\2"+
		"\2\31\32\7\b\2\2\32\33\7(\2\2\33\34\7(\2\2\34\u0081\7(\2\2\35\36\7\t\2"+
		"\2\36\37\7(\2\2\37 \7(\2\2 \u0081\7(\2\2!\"\7\n\2\2\"#\7(\2\2#\u0081\7"+
		"(\2\2$%\7\13\2\2%&\7(\2\2&\'\7(\2\2\'\u0081\7(\2\2()\7\f\2\2)*\7(\2\2"+
		"*+\7(\2\2+\u0081\7(\2\2,-\7\r\2\2-.\7(\2\2.\u0081\7(\2\2/\60\7\16\2\2"+
		"\60\61\7(\2\2\61\62\7(\2\2\62\u0081\7(\2\2\63\64\7\17\2\2\64\65\7(\2\2"+
		"\65\66\7(\2\2\66\u0081\7(\2\2\678\7\20\2\289\7(\2\29:\7(\2\2:\u0081\7"+
		"(\2\2;<\7\21\2\2<=\7(\2\2=>\7(\2\2>\u0081\7(\2\2?@\7\22\2\2@A\7(\2\2A"+
		"B\7(\2\2B\u0081\7(\2\2CD\7\23\2\2DE\7(\2\2EF\7(\2\2F\u0081\7(\2\2GH\7"+
		"\24\2\2HI\7(\2\2IJ\7\'\2\2JK\7\25\2\2KL\7(\2\2L\u0081\7\26\2\2MN\7\27"+
		"\2\2NO\7(\2\2OP\7\'\2\2PQ\7\25\2\2QR\7(\2\2R\u0081\7\26\2\2ST\7\30\2\2"+
		"TU\7(\2\2UV\7\'\2\2VW\7\25\2\2WX\7(\2\2X\u0081\7\26\2\2YZ\7\31\2\2Z[\7"+
		"(\2\2[\\\7\'\2\2\\]\7\25\2\2]^\7(\2\2^\u0081\7\26\2\2_`\7&\2\2`\u0081"+
		"\7\32\2\2ab\7\33\2\2b\u0081\7&\2\2cd\7\34\2\2de\7(\2\2ef\7(\2\2f\u0081"+
		"\7&\2\2gh\7\35\2\2hi\7(\2\2ij\7(\2\2j\u0081\7&\2\2kl\7\36\2\2lm\7(\2\2"+
		"mn\7(\2\2n\u0081\7&\2\2op\7\37\2\2pq\7(\2\2qr\7(\2\2r\u0081\7\'\2\2st"+
		"\7 \2\2tu\7(\2\2u\u0081\7\'\2\2vw\7!\2\2wx\7(\2\2x\u0081\7(\2\2yz\7\""+
		"\2\2z\u0081\7&\2\2{|\7#\2\2|\u0081\7(\2\2}~\7$\2\2~\u0081\7(\2\2\177\u0081"+
		"\7%\2\2\u0080\f\3\2\2\2\u0080\16\3\2\2\2\u0080\17\3\2\2\2\u0080\21\3\2"+
		"\2\2\u0080\25\3\2\2\2\u0080\31\3\2\2\2\u0080\35\3\2\2\2\u0080!\3\2\2\2"+
		"\u0080$\3\2\2\2\u0080(\3\2\2\2\u0080,\3\2\2\2\u0080/\3\2\2\2\u0080\63"+
		"\3\2\2\2\u0080\67\3\2\2\2\u0080;\3\2\2\2\u0080?\3\2\2\2\u0080C\3\2\2\2"+
		"\u0080G\3\2\2\2\u0080M\3\2\2\2\u0080S\3\2\2\2\u0080Y\3\2\2\2\u0080_\3"+
		"\2\2\2\u0080a\3\2\2\2\u0080c\3\2\2\2\u0080g\3\2\2\2\u0080k\3\2\2\2\u0080"+
		"o\3\2\2\2\u0080s\3\2\2\2\u0080v\3\2\2\2\u0080y\3\2\2\2\u0080{\3\2\2\2"+
		"\u0080}\3\2\2\2\u0080\177\3\2\2\2\u0081\5\3\2\2\2\4\t\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}