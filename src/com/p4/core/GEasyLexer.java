// Generated from C:/Users/Kristian/IdeaProjects/G-Easy/src/com/p4/core\GEasy.g4 by ANTLR 4.9.1
package com.p4.core;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GEasyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMA=2, SEMICOLON=3, L_BRACKET=4, R_BRACKET=5, L_BRACE=6, R_BRACE=7, 
		LP=8, RP=9, IF=10, ELSE=11, FOR=12, TO=13, POS=14, XCOORD=15, YCOORD=16, 
		VOID=17, RETURN=18, LINE_COMMENT=19, WHITESPACE=20, TYPE=21, BOOL_T=22, 
		BOOL=23, TRUE=24, FALSE=25, COMPARER_OP=26, LESS_THAN=27, GREATER_THAN=28, 
		LESS_THAN_EQ=29, GREATER_THAN_EQ=30, IS_EQ=31, NOT_EQ=32, OR=33, AND=34, 
		NEGATION=35, ASSIGN_OP=36, MINUS=37, MOD=38, PLUS=39, MULT=40, DIV=41, 
		NUMBER=42, ID=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COLON", "COMMA", "SEMICOLON", "L_BRACKET", "R_BRACKET", "L_BRACE", "R_BRACE", 
			"LP", "RP", "IF", "ELSE", "FOR", "TO", "POS", "XCOORD", "YCOORD", "VOID", 
			"RETURN", "LINE_COMMENT", "WHITESPACE", "TYPE", "BOOL_T", "BOOL", "TRUE", 
			"FALSE", "COMPARER_OP", "LESS_THAN", "GREATER_THAN", "LESS_THAN_EQ", 
			"GREATER_THAN_EQ", "IS_EQ", "NOT_EQ", "OR", "AND", "NEGATION", "ASSIGN_OP", 
			"MINUS", "MOD", "PLUS", "MULT", "DIV", "NUMBER", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "';'", "'['", "']'", "'{'", "'}'", "'('", "')'", 
			"'if'", "'else'", "'for'", "'to'", "'pos'", "'x:'", "'y:'", "'void'", 
			"'return'", null, null, null, "'bool'", null, "'true'", "'false'", null, 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'||'", "'&&'", "'!'", 
			"'='", "'-'", "'%'", "'+'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COLON", "COMMA", "SEMICOLON", "L_BRACKET", "R_BRACKET", "L_BRACE", 
			"R_BRACE", "LP", "RP", "IF", "ELSE", "FOR", "TO", "POS", "XCOORD", "YCOORD", 
			"VOID", "RETURN", "LINE_COMMENT", "WHITESPACE", "TYPE", "BOOL_T", "BOOL", 
			"TRUE", "FALSE", "COMPARER_OP", "LESS_THAN", "GREATER_THAN", "LESS_THAN_EQ", 
			"GREATER_THAN_EQ", "IS_EQ", "NOT_EQ", "OR", "AND", "NEGATION", "ASSIGN_OP", 
			"MINUS", "MOD", "PLUS", "MULT", "DIV", "NUMBER", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public GEasyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GEasy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0101\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u0095"+
		"\n\24\f\24\16\24\u0098\13\24\3\24\3\24\3\25\6\25\u009d\n\25\r\25\16\25"+
		"\u009e\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00ac"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\5\30\u00b5\n\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\5\33\u00c8\n\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 "+
		"\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3"+
		")\3)\3*\3*\3+\6+\u00ef\n+\r+\16+\u00f0\3+\3+\6+\u00f5\n+\r+\16+\u00f6"+
		"\5+\u00f9\n+\3,\3,\7,\u00fd\n,\f,\16,\u0100\13,\2\2-\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-\3\2\7\4\2\f\f\17\17\5\2\13\f\17\17\"\"\3\2\62;\5\2C\\aac"+
		"|\6\2\62;C\\aac|\2\u010d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7]\3"+
		"\2\2\2\t_\3\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17e\3\2\2\2\21g\3\2\2\2\23i\3"+
		"\2\2\2\25k\3\2\2\2\27n\3\2\2\2\31s\3\2\2\2\33w\3\2\2\2\35z\3\2\2\2\37"+
		"~\3\2\2\2!\u0081\3\2\2\2#\u0084\3\2\2\2%\u0089\3\2\2\2\'\u0090\3\2\2\2"+
		")\u009c\3\2\2\2+\u00ab\3\2\2\2-\u00ad\3\2\2\2/\u00b4\3\2\2\2\61\u00b6"+
		"\3\2\2\2\63\u00bb\3\2\2\2\65\u00c7\3\2\2\2\67\u00c9\3\2\2\29\u00cb\3\2"+
		"\2\2;\u00cd\3\2\2\2=\u00d0\3\2\2\2?\u00d3\3\2\2\2A\u00d6\3\2\2\2C\u00d9"+
		"\3\2\2\2E\u00dc\3\2\2\2G\u00df\3\2\2\2I\u00e1\3\2\2\2K\u00e3\3\2\2\2M"+
		"\u00e5\3\2\2\2O\u00e7\3\2\2\2Q\u00e9\3\2\2\2S\u00eb\3\2\2\2U\u00ee\3\2"+
		"\2\2W\u00fa\3\2\2\2YZ\7<\2\2Z\4\3\2\2\2[\\\7.\2\2\\\6\3\2\2\2]^\7=\2\2"+
		"^\b\3\2\2\2_`\7]\2\2`\n\3\2\2\2ab\7_\2\2b\f\3\2\2\2cd\7}\2\2d\16\3\2\2"+
		"\2ef\7\177\2\2f\20\3\2\2\2gh\7*\2\2h\22\3\2\2\2ij\7+\2\2j\24\3\2\2\2k"+
		"l\7k\2\2lm\7h\2\2m\26\3\2\2\2no\7g\2\2op\7n\2\2pq\7u\2\2qr\7g\2\2r\30"+
		"\3\2\2\2st\7h\2\2tu\7q\2\2uv\7t\2\2v\32\3\2\2\2wx\7v\2\2xy\7q\2\2y\34"+
		"\3\2\2\2z{\7r\2\2{|\7q\2\2|}\7u\2\2}\36\3\2\2\2~\177\7z\2\2\177\u0080"+
		"\7<\2\2\u0080 \3\2\2\2\u0081\u0082\7{\2\2\u0082\u0083\7<\2\2\u0083\"\3"+
		"\2\2\2\u0084\u0085\7x\2\2\u0085\u0086\7q\2\2\u0086\u0087\7k\2\2\u0087"+
		"\u0088\7f\2\2\u0088$\3\2\2\2\u0089\u008a\7t\2\2\u008a\u008b\7g\2\2\u008b"+
		"\u008c\7v\2\2\u008c\u008d\7w\2\2\u008d\u008e\7t\2\2\u008e\u008f\7p\2\2"+
		"\u008f&\3\2\2\2\u0090\u0091\7\61\2\2\u0091\u0092\7\61\2\2\u0092\u0096"+
		"\3\2\2\2\u0093\u0095\n\2\2\2\u0094\u0093\3\2\2\2\u0095\u0098\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0099\u009a\b\24\2\2\u009a(\3\2\2\2\u009b\u009d\t\3\2\2\u009c\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\b\25\2\2\u00a1*\3\2\2\2\u00a2\u00a3\7k\2\2"+
		"\u00a3\u00a4\7p\2\2\u00a4\u00ac\7v\2\2\u00a5\u00a6\7f\2\2\u00a6\u00a7"+
		"\7q\2\2\u00a7\u00a8\7w\2\2\u00a8\u00a9\7d\2\2\u00a9\u00aa\7n\2\2\u00aa"+
		"\u00ac\7g\2\2\u00ab\u00a2\3\2\2\2\u00ab\u00a5\3\2\2\2\u00ac,\3\2\2\2\u00ad"+
		"\u00ae\7d\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7n\2\2"+
		"\u00b1.\3\2\2\2\u00b2\u00b5\5\61\31\2\u00b3\u00b5\5\63\32\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\60\3\2\2\2\u00b6\u00b7\7v\2\2\u00b7"+
		"\u00b8\7t\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7g\2\2\u00ba\62\3\2\2\2\u00bb"+
		"\u00bc\7h\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7u\2\2"+
		"\u00bf\u00c0\7g\2\2\u00c0\64\3\2\2\2\u00c1\u00c8\5\67\34\2\u00c2\u00c8"+
		"\59\35\2\u00c3\u00c8\5;\36\2\u00c4\u00c8\5=\37\2\u00c5\u00c8\5A!\2\u00c6"+
		"\u00c8\5? \2\u00c7\u00c1\3\2\2\2\u00c7\u00c2\3\2\2\2\u00c7\u00c3\3\2\2"+
		"\2\u00c7\u00c4\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\66"+
		"\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca8\3\2\2\2\u00cb\u00cc\7@\2\2\u00cc:\3"+
		"\2\2\2\u00cd\u00ce\7>\2\2\u00ce\u00cf\7?\2\2\u00cf<\3\2\2\2\u00d0\u00d1"+
		"\7@\2\2\u00d1\u00d2\7?\2\2\u00d2>\3\2\2\2\u00d3\u00d4\7?\2\2\u00d4\u00d5"+
		"\7?\2\2\u00d5@\3\2\2\2\u00d6\u00d7\7#\2\2\u00d7\u00d8\7?\2\2\u00d8B\3"+
		"\2\2\2\u00d9\u00da\7~\2\2\u00da\u00db\7~\2\2\u00dbD\3\2\2\2\u00dc\u00dd"+
		"\7(\2\2\u00dd\u00de\7(\2\2\u00deF\3\2\2\2\u00df\u00e0\7#\2\2\u00e0H\3"+
		"\2\2\2\u00e1\u00e2\7?\2\2\u00e2J\3\2\2\2\u00e3\u00e4\7/\2\2\u00e4L\3\2"+
		"\2\2\u00e5\u00e6\7\'\2\2\u00e6N\3\2\2\2\u00e7\u00e8\7-\2\2\u00e8P\3\2"+
		"\2\2\u00e9\u00ea\7,\2\2\u00eaR\3\2\2\2\u00eb\u00ec\7\61\2\2\u00ecT\3\2"+
		"\2\2\u00ed\u00ef\t\4\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f8\3\2\2\2\u00f2\u00f4\7\60"+
		"\2\2\u00f3\u00f5\t\4\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f2\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9V\3\2\2\2\u00fa\u00fe\t\5\2\2\u00fb\u00fd"+
		"\t\6\2\2\u00fc\u00fb\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ffX\3\2\2\2\u0100\u00fe\3\2\2\2\f\2\u0096\u009e\u00ab"+
		"\u00b4\u00c7\u00f0\u00f6\u00f8\u00fe\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}