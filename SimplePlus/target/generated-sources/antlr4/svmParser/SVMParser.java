// Generated from SVM.g4 by ANTLR 4.4
package svmParser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__33=1, T__32=2, T__31=3, T__30=4, T__29=5, T__28=6, T__27=7, T__26=8, 
		T__25=9, T__24=10, T__23=11, T__22=12, T__21=13, T__20=14, T__19=15, T__18=16, 
		T__17=17, T__16=18, T__15=19, T__14=20, T__13=21, T__12=22, T__11=23, 
		T__10=24, T__9=25, T__8=26, T__7=27, T__6=28, T__5=29, T__4=30, T__3=31, 
		T__2=32, T__1=33, T__0=34, LABEL=35, NUMBER=36, REGISTER=37, WS=38, LINECOMMENTS=39, 
		BLOCKCOMMENTS=40;
	public static final String[] tokenNames = {
		"<INVALID>", "'mult'", "'sw'", "'move'", "'leq'", "'bgeq'", "'neq'", "'b'", 
		"'addi'", "'ls'", "'print'", "'push'", "'eq'", "'neg'", "'lmem'", "'lw'", 
		"'('", "'add'", "'sub'", "':'", "'beq'", "'li'", "'jal'", "'bleq'", "'geq'", 
		"'or'", "'halt'", "'jr'", "'div'", "'pop'", "'gr'", "')'", "'and'", "'not'", 
		"'top'", "LABEL", "NUMBER", "REGISTER", "WS", "LINECOMMENTS", "BLOCKCOMMENTS"
	};
	public static final int
		RULE_program = 0, RULE_assembly = 1;
	public static final String[] ruleNames = {
		"program", "assembly"
	};

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public AssemblyContext assembly(int i) {
			return getRuleContext(AssemblyContext.class,i);
		}
		public List<AssemblyContext> assembly() {
			return getRuleContexts(AssemblyContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitProgram(this);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__32) | (1L << T__31) | (1L << T__30) | (1L << T__29) | (1L << T__28) | (1L << T__27) | (1L << T__26) | (1L << T__25) | (1L << T__24) | (1L << T__23) | (1L << T__22) | (1L << T__21) | (1L << T__20) | (1L << T__19) | (1L << T__17) | (1L << T__16) | (1L << T__14) | (1L << T__13) | (1L << T__12) | (1L << T__11) | (1L << T__10) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__4) | (1L << T__2) | (1L << T__1) | (1L << T__0) | (1L << LABEL))) != 0)) {
				{
				{
				setState(4); assembly();
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
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public TerminalNode REGISTER(int i) {
			return getToken(SVMParser.REGISTER, i);
		}
		public List<TerminalNode> REGISTER() { return getTokens(SVMParser.REGISTER); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitAssembly(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_assembly);
		try {
			setState(120);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(10); ((AssemblyContext)_localctx).instr = match(T__23);
				setState(11); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(12); ((AssemblyContext)_localctx).instr = match(T__5);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(13); ((AssemblyContext)_localctx).instr = match(T__0);
				setState(14); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(15); ((AssemblyContext)_localctx).instr = match(T__17);
				setState(16); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(17); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(18); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(19); ((AssemblyContext)_localctx).instr = match(T__16);
				setState(20); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(21); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(22); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 6);
				{
				setState(23); ((AssemblyContext)_localctx).instr = match(T__33);
				setState(24); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(25); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(26); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(27); ((AssemblyContext)_localctx).instr = match(T__6);
				setState(28); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(29); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(30); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 8);
				{
				setState(31); ((AssemblyContext)_localctx).instr = match(T__21);
				setState(32); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(33); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 9);
				{
				setState(34); ((AssemblyContext)_localctx).instr = match(T__2);
				setState(35); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(36); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(37); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 10);
				{
				setState(38); ((AssemblyContext)_localctx).instr = match(T__9);
				setState(39); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(40); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(41); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 11);
				{
				setState(42); ((AssemblyContext)_localctx).instr = match(T__1);
				setState(43); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(44); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 12);
				{
				setState(45); ((AssemblyContext)_localctx).instr = match(T__22);
				setState(46); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(47); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(48); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 13);
				{
				setState(49); ((AssemblyContext)_localctx).instr = match(T__28);
				setState(50); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(51); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(52); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 14);
				{
				setState(53); ((AssemblyContext)_localctx).instr = match(T__10);
				setState(54); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(55); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(56); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 15);
				{
				setState(57); ((AssemblyContext)_localctx).instr = match(T__30);
				setState(58); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(59); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(60); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 16);
				{
				setState(61); ((AssemblyContext)_localctx).instr = match(T__4);
				setState(62); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(63); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(64); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 17);
				{
				setState(65); ((AssemblyContext)_localctx).instr = match(T__25);
				setState(66); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(67); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(68); ((AssemblyContext)_localctx).arg3 = match(REGISTER);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 18);
				{
				setState(69); ((AssemblyContext)_localctx).instr = match(T__32);
				setState(70); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(71); ((AssemblyContext)_localctx).offset = match(NUMBER);
				setState(72); match(T__18);
				setState(73); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(74); match(T__3);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 19);
				{
				setState(75); ((AssemblyContext)_localctx).instr = match(T__19);
				setState(76); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(77); ((AssemblyContext)_localctx).offset = match(NUMBER);
				setState(78); match(T__18);
				setState(79); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(80); match(T__3);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 20);
				{
				setState(81); ((AssemblyContext)_localctx).instr = match(T__20);
				setState(82); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(83); ((AssemblyContext)_localctx).offset = match(NUMBER);
				setState(84); match(T__18);
				setState(85); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(86); match(T__3);
				}
				break;
			case LABEL:
				enterOuterAlt(_localctx, 21);
				{
				setState(87); ((AssemblyContext)_localctx).instr = match(LABEL);
				setState(88); match(T__15);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 22);
				{
				setState(89); ((AssemblyContext)_localctx).instr = match(T__27);
				setState(90); ((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 23);
				{
				setState(91); ((AssemblyContext)_localctx).instr = match(T__14);
				setState(92); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(93); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(94); ((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 24);
				{
				setState(95); ((AssemblyContext)_localctx).instr = match(T__11);
				setState(96); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(97); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(98); ((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 25);
				{
				setState(99); ((AssemblyContext)_localctx).instr = match(T__29);
				setState(100); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(101); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(102); ((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 26);
				{
				setState(103); ((AssemblyContext)_localctx).instr = match(T__26);
				setState(104); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(105); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				setState(106); ((AssemblyContext)_localctx).arg3 = match(NUMBER);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 27);
				{
				setState(107); ((AssemblyContext)_localctx).instr = match(T__13);
				setState(108); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(109); ((AssemblyContext)_localctx).arg2 = match(NUMBER);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 28);
				{
				setState(110); ((AssemblyContext)_localctx).instr = match(T__31);
				setState(111); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				setState(112); ((AssemblyContext)_localctx).arg2 = match(REGISTER);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 29);
				{
				setState(113); ((AssemblyContext)_localctx).instr = match(T__12);
				setState(114); ((AssemblyContext)_localctx).arg3 = match(LABEL);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 30);
				{
				setState(115); ((AssemblyContext)_localctx).instr = match(T__7);
				setState(116); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 31);
				{
				setState(117); ((AssemblyContext)_localctx).instr = match(T__24);
				setState(118); ((AssemblyContext)_localctx).arg1 = match(REGISTER);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 32);
				{
				setState(119); ((AssemblyContext)_localctx).instr = match(T__8);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*}\4\2\t\2\4\3\t\3"+
		"\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3{\n\3\3\3\2\2"+
		"\4\2\4\2\2\u009a\2\t\3\2\2\2\4z\3\2\2\2\6\b\5\4\3\2\7\6\3\2\2\2\b\13\3"+
		"\2\2\2\t\7\3\2\2\2\t\n\3\2\2\2\n\3\3\2\2\2\13\t\3\2\2\2\f\r\7\r\2\2\r"+
		"{\7\'\2\2\16{\7\37\2\2\17\20\7$\2\2\20{\7\'\2\2\21\22\7\23\2\2\22\23\7"+
		"\'\2\2\23\24\7\'\2\2\24{\7\'\2\2\25\26\7\24\2\2\26\27\7\'\2\2\27\30\7"+
		"\'\2\2\30{\7\'\2\2\31\32\7\3\2\2\32\33\7\'\2\2\33\34\7\'\2\2\34{\7\'\2"+
		"\2\35\36\7\36\2\2\36\37\7\'\2\2\37 \7\'\2\2 {\7\'\2\2!\"\7\17\2\2\"#\7"+
		"\'\2\2#{\7\'\2\2$%\7\"\2\2%&\7\'\2\2&\'\7\'\2\2\'{\7\'\2\2()\7\33\2\2"+
		")*\7\'\2\2*+\7\'\2\2+{\7\'\2\2,-\7#\2\2-.\7\'\2\2.{\7\'\2\2/\60\7\16\2"+
		"\2\60\61\7\'\2\2\61\62\7\'\2\2\62{\7\'\2\2\63\64\7\b\2\2\64\65\7\'\2\2"+
		"\65\66\7\'\2\2\66{\7\'\2\2\678\7\32\2\289\7\'\2\29:\7\'\2\2:{\7\'\2\2"+
		";<\7\6\2\2<=\7\'\2\2=>\7\'\2\2>{\7\'\2\2?@\7 \2\2@A\7\'\2\2AB\7\'\2\2"+
		"B{\7\'\2\2CD\7\13\2\2DE\7\'\2\2EF\7\'\2\2F{\7\'\2\2GH\7\4\2\2HI\7\'\2"+
		"\2IJ\7&\2\2JK\7\22\2\2KL\7\'\2\2L{\7!\2\2MN\7\21\2\2NO\7\'\2\2OP\7&\2"+
		"\2PQ\7\22\2\2QR\7\'\2\2R{\7!\2\2ST\7\20\2\2TU\7\'\2\2UV\7&\2\2VW\7\22"+
		"\2\2WX\7\'\2\2X{\7!\2\2YZ\7%\2\2Z{\7\25\2\2[\\\7\t\2\2\\{\7%\2\2]^\7\26"+
		"\2\2^_\7\'\2\2_`\7\'\2\2`{\7%\2\2ab\7\31\2\2bc\7\'\2\2cd\7\'\2\2d{\7%"+
		"\2\2ef\7\7\2\2fg\7\'\2\2gh\7\'\2\2h{\7%\2\2ij\7\n\2\2jk\7\'\2\2kl\7\'"+
		"\2\2l{\7&\2\2mn\7\27\2\2no\7\'\2\2o{\7&\2\2pq\7\5\2\2qr\7\'\2\2r{\7\'"+
		"\2\2st\7\30\2\2t{\7%\2\2uv\7\35\2\2v{\7\'\2\2wx\7\f\2\2x{\7\'\2\2y{\7"+
		"\34\2\2z\f\3\2\2\2z\16\3\2\2\2z\17\3\2\2\2z\21\3\2\2\2z\25\3\2\2\2z\31"+
		"\3\2\2\2z\35\3\2\2\2z!\3\2\2\2z$\3\2\2\2z(\3\2\2\2z,\3\2\2\2z/\3\2\2\2"+
		"z\63\3\2\2\2z\67\3\2\2\2z;\3\2\2\2z?\3\2\2\2zC\3\2\2\2zG\3\2\2\2zM\3\2"+
		"\2\2zS\3\2\2\2zY\3\2\2\2z[\3\2\2\2z]\3\2\2\2za\3\2\2\2ze\3\2\2\2zi\3\2"+
		"\2\2zm\3\2\2\2zp\3\2\2\2zs\3\2\2\2zu\3\2\2\2zw\3\2\2\2zy\3\2\2\2{\5\3"+
		"\2\2\2\4\tz";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}