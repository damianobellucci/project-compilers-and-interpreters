// Generated from SVM.g4 by ANTLR 4.4
package svmParser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('"
	};
	public static final String[] ruleNames = {
		"T__33", "T__32", "T__31", "T__30", "T__29", "T__28", "T__27", "T__26", 
		"T__25", "T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", 
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "CHAR", "LABEL", "DIGIT", "NUMBER", "REGISTER", "WS", "LINECOMMENTS", 
		"BLOCKCOMMENTS"
	};


	public SVMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u0116\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3\"\3"+
		"\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3%\3%\3%\7%\u00df\n%\f%\16%\u00e2\13%\3&"+
		"\3&\3\'\6\'\u00e7\n\'\r\'\16\'\u00e8\3(\3(\3(\3(\3(\3(\3(\3(\5(\u00f3"+
		"\n(\3)\3)\3)\3)\3*\3*\3*\3*\7*\u00fd\n*\f*\16*\u0100\13*\3*\3*\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\7+\u010d\n+\f+\16+\u0110\13+\3+\3+\3+\3+\3+\2\2,\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G\2I%K\2M&O\'Q(S)U*\3\2\b\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f"+
		"\f\17\17\4\2,,\61\61\3\2,,\3\2\61\61\u011c\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2I\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q"+
		"\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5\\\3\2\2\2\7_\3\2\2\2\td\3"+
		"\2\2\2\13h\3\2\2\2\rm\3\2\2\2\17q\3\2\2\2\21s\3\2\2\2\23x\3\2\2\2\25{"+
		"\3\2\2\2\27\u0081\3\2\2\2\31\u0086\3\2\2\2\33\u0089\3\2\2\2\35\u008d\3"+
		"\2\2\2\37\u0092\3\2\2\2!\u0095\3\2\2\2#\u0097\3\2\2\2%\u009b\3\2\2\2\'"+
		"\u009f\3\2\2\2)\u00a1\3\2\2\2+\u00a5\3\2\2\2-\u00a8\3\2\2\2/\u00ac\3\2"+
		"\2\2\61\u00b1\3\2\2\2\63\u00b5\3\2\2\2\65\u00b8\3\2\2\2\67\u00bd\3\2\2"+
		"\29\u00c0\3\2\2\2;\u00c4\3\2\2\2=\u00c8\3\2\2\2?\u00cb\3\2\2\2A\u00cd"+
		"\3\2\2\2C\u00d1\3\2\2\2E\u00d5\3\2\2\2G\u00d9\3\2\2\2I\u00db\3\2\2\2K"+
		"\u00e3\3\2\2\2M\u00e6\3\2\2\2O\u00f2\3\2\2\2Q\u00f4\3\2\2\2S\u00f8\3\2"+
		"\2\2U\u0103\3\2\2\2WX\7o\2\2XY\7w\2\2YZ\7n\2\2Z[\7v\2\2[\4\3\2\2\2\\]"+
		"\7u\2\2]^\7y\2\2^\6\3\2\2\2_`\7o\2\2`a\7q\2\2ab\7x\2\2bc\7g\2\2c\b\3\2"+
		"\2\2de\7n\2\2ef\7g\2\2fg\7s\2\2g\n\3\2\2\2hi\7d\2\2ij\7i\2\2jk\7g\2\2"+
		"kl\7s\2\2l\f\3\2\2\2mn\7p\2\2no\7g\2\2op\7s\2\2p\16\3\2\2\2qr\7d\2\2r"+
		"\20\3\2\2\2st\7c\2\2tu\7f\2\2uv\7f\2\2vw\7k\2\2w\22\3\2\2\2xy\7n\2\2y"+
		"z\7u\2\2z\24\3\2\2\2{|\7r\2\2|}\7t\2\2}~\7k\2\2~\177\7p\2\2\177\u0080"+
		"\7v\2\2\u0080\26\3\2\2\2\u0081\u0082\7r\2\2\u0082\u0083\7w\2\2\u0083\u0084"+
		"\7u\2\2\u0084\u0085\7j\2\2\u0085\30\3\2\2\2\u0086\u0087\7g\2\2\u0087\u0088"+
		"\7s\2\2\u0088\32\3\2\2\2\u0089\u008a\7p\2\2\u008a\u008b\7g\2\2\u008b\u008c"+
		"\7i\2\2\u008c\34\3\2\2\2\u008d\u008e\7n\2\2\u008e\u008f\7o\2\2\u008f\u0090"+
		"\7g\2\2\u0090\u0091\7o\2\2\u0091\36\3\2\2\2\u0092\u0093\7n\2\2\u0093\u0094"+
		"\7y\2\2\u0094 \3\2\2\2\u0095\u0096\7*\2\2\u0096\"\3\2\2\2\u0097\u0098"+
		"\7c\2\2\u0098\u0099\7f\2\2\u0099\u009a\7f\2\2\u009a$\3\2\2\2\u009b\u009c"+
		"\7u\2\2\u009c\u009d\7w\2\2\u009d\u009e\7d\2\2\u009e&\3\2\2\2\u009f\u00a0"+
		"\7<\2\2\u00a0(\3\2\2\2\u00a1\u00a2\7d\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4"+
		"\7s\2\2\u00a4*\3\2\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7k\2\2\u00a7,\3"+
		"\2\2\2\u00a8\u00a9\7l\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab\7n\2\2\u00ab"+
		".\3\2\2\2\u00ac\u00ad\7d\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af\7g\2\2\u00af"+
		"\u00b0\7s\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\7i\2\2\u00b2\u00b3\7g\2\2\u00b3"+
		"\u00b4\7s\2\2\u00b4\62\3\2\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7t\2\2\u00b7"+
		"\64\3\2\2\2\u00b8\u00b9\7j\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb\7n\2\2\u00bb"+
		"\u00bc\7v\2\2\u00bc\66\3\2\2\2\u00bd\u00be\7l\2\2\u00be\u00bf\7t\2\2\u00bf"+
		"8\3\2\2\2\u00c0\u00c1\7f\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7x\2\2\u00c3"+
		":\3\2\2\2\u00c4\u00c5\7r\2\2\u00c5\u00c6\7q\2\2\u00c6\u00c7\7r\2\2\u00c7"+
		"<\3\2\2\2\u00c8\u00c9\7i\2\2\u00c9\u00ca\7t\2\2\u00ca>\3\2\2\2\u00cb\u00cc"+
		"\7+\2\2\u00cc@\3\2\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0"+
		"\7f\2\2\u00d0B\3\2\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4"+
		"\7v\2\2\u00d4D\3\2\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8"+
		"\7r\2\2\u00d8F\3\2\2\2\u00d9\u00da\t\2\2\2\u00daH\3\2\2\2\u00db\u00e0"+
		"\5G$\2\u00dc\u00df\5G$\2\u00dd\u00df\5K&\2\u00de\u00dc\3\2\2\2\u00de\u00dd"+
		"\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"J\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\4\62;\2\u00e4L\3\2\2\2\u00e5"+
		"\u00e7\5K&\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2\2"+
		"\2\u00e8\u00e9\3\2\2\2\u00e9N\3\2\2\2\u00ea\u00eb\7&\2\2\u00eb\u00ec\5"+
		"G$\2\u00ec\u00ed\5K&\2\u00ed\u00f3\3\2\2\2\u00ee\u00ef\7&\2\2\u00ef\u00f0"+
		"\5G$\2\u00f0\u00f1\5G$\2\u00f1\u00f3\3\2\2\2\u00f2\u00ea\3\2\2\2\u00f2"+
		"\u00ee\3\2\2\2\u00f3P\3\2\2\2\u00f4\u00f5\t\3\2\2\u00f5\u00f6\3\2\2\2"+
		"\u00f6\u00f7\b)\2\2\u00f7R\3\2\2\2\u00f8\u00f9\7\61\2\2\u00f9\u00fa\7"+
		"\61\2\2\u00fa\u00fe\3\2\2\2\u00fb\u00fd\n\4\2\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2"+
		"\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\b*\2\2\u0102T\3\2\2\2\u0103\u0104"+
		"\7\61\2\2\u0104\u0105\7,\2\2\u0105\u010e\3\2\2\2\u0106\u010d\n\5\2\2\u0107"+
		"\u0108\7\61\2\2\u0108\u010d\n\6\2\2\u0109\u010a\7,\2\2\u010a\u010d\n\7"+
		"\2\2\u010b\u010d\5U+\2\u010c\u0106\3\2\2\2\u010c\u0107\3\2\2\2\u010c\u0109"+
		"\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\7,"+
		"\2\2\u0112\u0113\7\61\2\2\u0113\u0114\3\2\2\2\u0114\u0115\b+\2\2\u0115"+
		"V\3\2\2\2\n\2\u00de\u00e0\u00e8\u00f2\u00fe\u010c\u010e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}