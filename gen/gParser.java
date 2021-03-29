// Generated from C:/Users/Kristian/Desktop/P4\g.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMA=2, SEMICOLON=3, L_BRACKET=4, R_BRACKET=5, L_BRACE=6, R_BRACE=7, 
		LP=8, RP=9, IF=10, ELSE=11, FOR=12, TO=13, POS=14, XCOORD=15, YCOORD=16, 
		VOID=17, RETURN=18, LINE_COMMENT=19, WHITESPACE=20, TYPE=21, BOOL_T=22, 
		BOOL=23, COMPARER_OP=24, LESS_THAN=25, GREATHER_THAN=26, LESS_THAN_EQ=27, 
		GREATER_THAN_EQ=28, IS_EQ=29, NOT_EQ=30, OR=31, AND=32, NEGATION=33, ASSIGN_OP=34, 
		ARITHMETIC_OP=35, MINUS=36, MOD=37, PLUS=38, MULTIPLICATION=39, DIVISION=40, 
		NUMBER=41, ID=42;
	public static final int
		RULE_prog = 0, RULE_dcl = 1, RULE_var_dcl = 2, RULE_pos_dcl = 3, RULE_array_dcl = 4, 
		RULE_assign = 5, RULE_pos_assign = 6, RULE_array_assign = 7, RULE_expr = 8, 
		RULE_func_call = 9, RULE_stmt = 10, RULE_selection = 11, RULE_iterative = 12, 
		RULE_logical_expr = 13, RULE_func = 14, RULE_param = 15, RULE_blok = 16, 
		RULE_return_expr = 17, RULE_val = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcl", "var_dcl", "pos_dcl", "array_dcl", "assign", "pos_assign", 
			"array_assign", "expr", "func_call", "stmt", "selection", "iterative", 
			"logical_expr", "func", "param", "blok", "return_expr", "val"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "';'", "'['", "']'", "'{'", "'}'", "'('", "')'", 
			"'if'", "'else'", "'for'", "'to'", "'pos'", "'x:'", "'y:'", "'void'", 
			"'return'", null, null, null, "'bool'", null, null, "'<'", "'>'", "'<='", 
			"'>='", "'=='", "'!='", "'||'", "'&&'", "'!'", "'='", null, "'-'", "'%'", 
			"'+'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COLON", "COMMA", "SEMICOLON", "L_BRACKET", "R_BRACKET", "L_BRACE", 
			"R_BRACE", "LP", "RP", "IF", "ELSE", "FOR", "TO", "POS", "XCOORD", "YCOORD", 
			"VOID", "RETURN", "LINE_COMMENT", "WHITESPACE", "TYPE", "BOOL_T", "BOOL", 
			"COMPARER_OP", "LESS_THAN", "GREATHER_THAN", "LESS_THAN_EQ", "GREATER_THAN_EQ", 
			"IS_EQ", "NOT_EQ", "OR", "AND", "NEGATION", "ASSIGN_OP", "ARITHMETIC_OP", 
			"MINUS", "MOD", "PLUS", "MULTIPLICATION", "DIVISION", "NUMBER", "ID"
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

	@Override
	public String getGrammarFileName() { return "g.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(gParser.EOF, 0); }
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public List<Func_callContext> func_call() {
			return getRuleContexts(Func_callContext.class);
		}
		public Func_callContext func_call(int i) {
			return getRuleContext(Func_callContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << POS) | (1L << VOID) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << BOOL_T) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(42);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(38);
					dcl();
					}
					break;
				case 2:
					{
					setState(39);
					stmt();
					}
					break;
				case 3:
					{
					setState(40);
					func();
					}
					break;
				case 4:
					{
					setState(41);
					func_call();
					}
					break;
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
			match(EOF);
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

	public static class DclContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(gParser.SEMICOLON, 0); }
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public Array_dclContext array_dcl() {
			return getRuleContext(Array_dclContext.class,0);
		}
		public Pos_dclContext pos_dcl() {
			return getRuleContext(Pos_dclContext.class,0);
		}
		public Var_dclContext var_dcl() {
			return getRuleContext(Var_dclContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(49);
				assign();
				}
				break;
			case 2:
				{
				setState(50);
				array_dcl();
				}
				break;
			case 3:
				{
				setState(51);
				pos_dcl();
				}
				break;
			case 4:
				{
				setState(52);
				var_dcl();
				}
				break;
			}
			setState(55);
			match(SEMICOLON);
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

	public static class Var_dclContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(gParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(gParser.ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Array_assignContext array_assign() {
			return getRuleContext(Array_assignContext.class,0);
		}
		public Var_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_dcl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitVar_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_dclContext var_dcl() throws RecognitionException {
		Var_dclContext _localctx = new Var_dclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(TYPE);
			setState(58);
			match(ID);
			setState(59);
			match(ASSIGN_OP);
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(60);
				expr();
				}
				break;
			case 2:
				{
				setState(61);
				func_call();
				}
				break;
			case 3:
				{
				setState(62);
				array_assign();
				}
				break;
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

	public static class Pos_dclContext extends ParserRuleContext {
		public TerminalNode POS() { return getToken(gParser.POS, 0); }
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(gParser.ASSIGN_OP, 0); }
		public Pos_assignContext pos_assign() {
			return getRuleContext(Pos_assignContext.class,0);
		}
		public Pos_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos_dcl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitPos_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pos_dclContext pos_dcl() throws RecognitionException {
		Pos_dclContext _localctx = new Pos_dclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pos_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(POS);
			setState(66);
			match(ID);
			setState(67);
			match(ASSIGN_OP);
			setState(68);
			pos_assign();
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

	public static class Array_dclContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(gParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode L_BRACKET() { return getToken(gParser.L_BRACKET, 0); }
		public TerminalNode R_BRACKET() { return getToken(gParser.R_BRACKET, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(gParser.ASSIGN_OP, 0); }
		public TerminalNode L_BRACE() { return getToken(gParser.L_BRACE, 0); }
		public TerminalNode R_BRACE() { return getToken(gParser.R_BRACE, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gParser.COMMA, i);
		}
		public Array_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_dcl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitArray_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_dclContext array_dcl() throws RecognitionException {
		Array_dclContext _localctx = new Array_dclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_array_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(TYPE);
			setState(71);
			match(ID);
			setState(72);
			match(L_BRACKET);
			setState(73);
			match(R_BRACKET);
			setState(74);
			match(ASSIGN_OP);
			setState(75);
			match(L_BRACE);
			{
			setState(76);
			val();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(77);
				match(COMMA);
				setState(78);
				val();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(84);
			match(R_BRACE);
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(gParser.ASSIGN_OP, 0); }
		public Pos_assignContext pos_assign() {
			return getRuleContext(Pos_assignContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(ID);
			setState(87);
			match(ASSIGN_OP);
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(90);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(88);
					expr();
					}
					break;
				case 2:
					{
					setState(89);
					func_call();
					}
					break;
				}
				}
				break;
			case L_BRACE:
				{
				setState(92);
				pos_assign();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Pos_assignContext extends ParserRuleContext {
		public TerminalNode L_BRACE() { return getToken(gParser.L_BRACE, 0); }
		public TerminalNode XCOORD() { return getToken(gParser.XCOORD, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(gParser.COMMA, 0); }
		public TerminalNode YCOORD() { return getToken(gParser.YCOORD, 0); }
		public TerminalNode R_BRACE() { return getToken(gParser.R_BRACE, 0); }
		public List<TerminalNode> MINUS() { return getTokens(gParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(gParser.MINUS, i);
		}
		public Pos_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitPos_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pos_assignContext pos_assign() throws RecognitionException {
		Pos_assignContext _localctx = new Pos_assignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pos_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(95);
			match(L_BRACE);
			setState(96);
			match(XCOORD);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(97);
				match(MINUS);
				}
			}

			setState(100);
			val();
			setState(101);
			match(COMMA);
			setState(102);
			match(YCOORD);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(103);
				match(MINUS);
				}
			}

			setState(106);
			val();
			setState(107);
			match(R_BRACE);
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

	public static class Array_assignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode L_BRACKET() { return getToken(gParser.L_BRACKET, 0); }
		public TerminalNode R_BRACKET() { return getToken(gParser.R_BRACKET, 0); }
		public TerminalNode NUMBER() { return getToken(gParser.NUMBER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Array_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitArray_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_assignContext array_assign() throws RecognitionException {
		Array_assignContext _localctx = new Array_assignContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_array_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(ID);
			setState(110);
			match(L_BRACKET);
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(111);
				match(NUMBER);
				}
				break;
			case 2:
				{
				setState(112);
				expr();
				}
				break;
			}
			setState(115);
			match(R_BRACKET);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(116);
				expr();
				}
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

	public static class ExprContext extends ParserRuleContext {
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(gParser.MINUS, 0); }
		public List<TerminalNode> ARITHMETIC_OP() { return getTokens(gParser.ARITHMETIC_OP); }
		public TerminalNode ARITHMETIC_OP(int i) {
			return getToken(gParser.ARITHMETIC_OP, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(119);
				match(MINUS);
				}
			}

			setState(122);
			val();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARITHMETIC_OP) {
				{
				setState(123);
				match(ARITHMETIC_OP);
				setState(124);
				val();
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARITHMETIC_OP) {
					{
					setState(125);
					match(ARITHMETIC_OP);
					setState(126);
					expr();
					}
				}

				}
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

	public static class Func_callContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(gParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(gParser.ID, i);
		}
		public TerminalNode LP() { return getToken(gParser.LP, 0); }
		public TerminalNode RP() { return getToken(gParser.RP, 0); }
		public List<TerminalNode> COLON() { return getTokens(gParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(gParser.COLON, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gParser.COMMA, i);
		}
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(ID);
			setState(132);
			match(LP);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(133);
				match(ID);
				setState(134);
				match(COLON);
				setState(135);
				expr();
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(136);
					match(COMMA);
					setState(137);
					match(ID);
					setState(138);
					match(COLON);
					setState(139);
					expr();
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(147);
			match(RP);
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

	public static class StmtContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(gParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public IterativeContext iterative() {
			return getRuleContext(IterativeContext.class,0);
		}
		public TerminalNode LINE_COMMENT() { return getToken(gParser.LINE_COMMENT, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				assign();
				setState(150);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				expr();
				setState(153);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				func_call();
				setState(156);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				selection();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				iterative();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(160);
				match(LINE_COMMENT);
				}
				break;
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

	public static class SelectionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(gParser.IF, 0); }
		public TerminalNode LP() { return getToken(gParser.LP, 0); }
		public TerminalNode RP() { return getToken(gParser.RP, 0); }
		public List<BlokContext> blok() {
			return getRuleContexts(BlokContext.class);
		}
		public BlokContext blok(int i) {
			return getRuleContext(BlokContext.class,i);
		}
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(gParser.BOOL, 0); }
		public TerminalNode ELSE() { return getToken(gParser.ELSE, 0); }
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(IF);
			setState(164);
			match(LP);
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(165);
				logical_expr();
				}
				break;
			case BOOL:
				{
				setState(166);
				match(BOOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(169);
			match(RP);
			setState(170);
			blok();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(171);
				match(ELSE);
				setState(172);
				blok();
				}
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

	public static class IterativeContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(gParser.FOR, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode TO() { return getToken(gParser.TO, 0); }
		public BlokContext blok() {
			return getRuleContext(BlokContext.class,0);
		}
		public List<TerminalNode> MINUS() { return getTokens(gParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(gParser.MINUS, i);
		}
		public IterativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterative; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitIterative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeContext iterative() throws RecognitionException {
		IterativeContext _localctx = new IterativeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_iterative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(FOR);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(176);
				match(MINUS);
				}
			}

			setState(179);
			val();
			setState(180);
			match(TO);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(181);
				match(MINUS);
				}
			}

			setState(184);
			val();
			setState(185);
			blok();
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

	public static class Logical_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMPARER_OP() { return getToken(gParser.COMPARER_OP, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode AND() { return getToken(gParser.AND, 0); }
		public TerminalNode OR() { return getToken(gParser.OR, 0); }
		public Logical_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitLogical_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_exprContext logical_expr() throws RecognitionException {
		Logical_exprContext _localctx = new Logical_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_logical_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			expr();
			setState(188);
			match(COMPARER_OP);
			setState(189);
			expr();
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR || _la==AND) {
				{
				setState(190);
				_la = _input.LA(1);
				if ( !(_la==OR || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(191);
				logical_expr();
				}
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

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode LP() { return getToken(gParser.LP, 0); }
		public TerminalNode RP() { return getToken(gParser.RP, 0); }
		public BlokContext blok() {
			return getRuleContext(BlokContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(gParser.TYPE, 0); }
		public TerminalNode VOID() { return getToken(gParser.VOID, 0); }
		public TerminalNode BOOL_T() { return getToken(gParser.BOOL_T, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << TYPE) | (1L << BOOL_T))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(195);
			match(ID);
			setState(196);
			match(LP);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(197);
				param();
				}
			}

			setState(200);
			match(RP);
			setState(201);
			blok();
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

	public static class ParamContext extends ParserRuleContext {
		public List<TerminalNode> TYPE() { return getTokens(gParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(gParser.TYPE, i);
		}
		public List<TerminalNode> ID() { return getTokens(gParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(gParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gParser.COMMA, i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(TYPE);
			setState(204);
			match(ID);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(205);
				match(COMMA);
				setState(206);
				match(TYPE);
				setState(207);
				match(ID);
				}
				}
				setState(212);
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

	public static class BlokContext extends ParserRuleContext {
		public TerminalNode L_BRACE() { return getToken(gParser.L_BRACE, 0); }
		public TerminalNode R_BRACE() { return getToken(gParser.R_BRACE, 0); }
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<Return_exprContext> return_expr() {
			return getRuleContexts(Return_exprContext.class);
		}
		public Return_exprContext return_expr(int i) {
			return getRuleContext(Return_exprContext.class,i);
		}
		public BlokContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blok; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitBlok(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlokContext blok() throws RecognitionException {
		BlokContext _localctx = new BlokContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_blok);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(L_BRACE);
			setState(217); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(217);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(214);
					dcl();
					}
					break;
				case 2:
					{
					setState(215);
					stmt();
					}
					break;
				case 3:
					{
					setState(216);
					return_expr();
					}
					break;
				}
				}
				setState(219); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << POS) | (1L << RETURN) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0) );
			setState(221);
			match(R_BRACE);
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

	public static class Return_exprContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(gParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(gParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(gParser.BOOL, 0); }
		public Return_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitReturn_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_exprContext return_expr() throws RecognitionException {
		Return_exprContext _localctx = new Return_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_return_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(RETURN);
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(224);
				expr();
				}
				break;
			case BOOL:
				{
				setState(225);
				match(BOOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(228);
			match(SEMICOLON);
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

	public static class ValContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(gParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(gParser.NUMBER, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gVisitor ) return ((gVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\7\2-\n\2\f\2\16\2\60\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\5\38\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6R\n\6\f\6\16\6"+
		"U\13\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7]\n\7\3\7\5\7`\n\7\3\b\3\b\3\b\5\be"+
		"\n\b\3\b\3\b\3\b\3\b\5\bk\n\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\tt\n\t\3\t"+
		"\3\t\5\tx\n\t\3\n\5\n{\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u0082\n\n\5\n\u0084"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008f\n\13\f\13"+
		"\16\13\u0092\13\13\5\13\u0094\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u00a4\n\f\3\r\3\r\3\r\3\r\5\r\u00aa\n\r\3\r"+
		"\3\r\3\r\3\r\5\r\u00b0\n\r\3\16\3\16\5\16\u00b4\n\16\3\16\3\16\3\16\5"+
		"\16\u00b9\n\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00c3\n\17"+
		"\3\20\3\20\3\20\3\20\5\20\u00c9\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\7\21\u00d3\n\21\f\21\16\21\u00d6\13\21\3\22\3\22\3\22\3\22\6\22"+
		"\u00dc\n\22\r\22\16\22\u00dd\3\22\3\22\3\23\3\23\3\23\5\23\u00e5\n\23"+
		"\3\23\3\23\3\24\3\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&\2\5\3\2!\"\4\2\23\23\27\30\3\2+,\2\u00fc\2.\3\2\2\2\4\67\3\2\2\2"+
		"\6;\3\2\2\2\bC\3\2\2\2\nH\3\2\2\2\fX\3\2\2\2\16a\3\2\2\2\20o\3\2\2\2\22"+
		"z\3\2\2\2\24\u0085\3\2\2\2\26\u00a3\3\2\2\2\30\u00a5\3\2\2\2\32\u00b1"+
		"\3\2\2\2\34\u00bd\3\2\2\2\36\u00c4\3\2\2\2 \u00cd\3\2\2\2\"\u00d7\3\2"+
		"\2\2$\u00e1\3\2\2\2&\u00e8\3\2\2\2(-\5\4\3\2)-\5\26\f\2*-\5\36\20\2+-"+
		"\5\24\13\2,(\3\2\2\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2"+
		"\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7\2\2\3\62\3\3\2\2\2\638\5"+
		"\f\7\2\648\5\n\6\2\658\5\b\5\2\668\5\6\4\2\67\63\3\2\2\2\67\64\3\2\2\2"+
		"\67\65\3\2\2\2\67\66\3\2\2\289\3\2\2\29:\7\5\2\2:\5\3\2\2\2;<\7\27\2\2"+
		"<=\7,\2\2=A\7$\2\2>B\5\22\n\2?B\5\24\13\2@B\5\20\t\2A>\3\2\2\2A?\3\2\2"+
		"\2A@\3\2\2\2B\7\3\2\2\2CD\7\20\2\2DE\7,\2\2EF\7$\2\2FG\5\16\b\2G\t\3\2"+
		"\2\2HI\7\27\2\2IJ\7,\2\2JK\7\6\2\2KL\7\7\2\2LM\7$\2\2MN\7\b\2\2NS\5&\24"+
		"\2OP\7\4\2\2PR\5&\24\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2"+
		"\2US\3\2\2\2VW\7\t\2\2W\13\3\2\2\2XY\7,\2\2Y_\7$\2\2Z]\5\22\n\2[]\5\24"+
		"\13\2\\Z\3\2\2\2\\[\3\2\2\2]`\3\2\2\2^`\5\16\b\2_\\\3\2\2\2_^\3\2\2\2"+
		"`\r\3\2\2\2ab\7\b\2\2bd\7\21\2\2ce\7&\2\2dc\3\2\2\2de\3\2\2\2ef\3\2\2"+
		"\2fg\5&\24\2gh\7\4\2\2hj\7\22\2\2ik\7&\2\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2"+
		"\2lm\5&\24\2mn\7\t\2\2n\17\3\2\2\2op\7,\2\2ps\7\6\2\2qt\7+\2\2rt\5\22"+
		"\n\2sq\3\2\2\2sr\3\2\2\2tu\3\2\2\2uw\7\7\2\2vx\5\22\n\2wv\3\2\2\2wx\3"+
		"\2\2\2x\21\3\2\2\2y{\7&\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|\u0083\5&\24"+
		"\2}~\7%\2\2~\u0081\5&\24\2\177\u0080\7%\2\2\u0080\u0082\5\22\n\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083}\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\23\3\2\2\2\u0085\u0086\7,\2\2\u0086\u0093\7\n\2\2"+
		"\u0087\u0088\7,\2\2\u0088\u0089\7\3\2\2\u0089\u0090\5\22\n\2\u008a\u008b"+
		"\7\4\2\2\u008b\u008c\7,\2\2\u008c\u008d\7\3\2\2\u008d\u008f\5\22\n\2\u008e"+
		"\u008a\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2"+
		"\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0087\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\13\2\2\u0096\25\3\2\2"+
		"\2\u0097\u0098\5\f\7\2\u0098\u0099\7\5\2\2\u0099\u00a4\3\2\2\2\u009a\u009b"+
		"\5\22\n\2\u009b\u009c\7\5\2\2\u009c\u00a4\3\2\2\2\u009d\u009e\5\24\13"+
		"\2\u009e\u009f\7\5\2\2\u009f\u00a4\3\2\2\2\u00a0\u00a4\5\30\r\2\u00a1"+
		"\u00a4\5\32\16\2\u00a2\u00a4\7\25\2\2\u00a3\u0097\3\2\2\2\u00a3\u009a"+
		"\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a2\3\2\2\2\u00a4\27\3\2\2\2\u00a5\u00a6\7\f\2\2\u00a6\u00a9\7\n\2"+
		"\2\u00a7\u00aa\5\34\17\2\u00a8\u00aa\7\31\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\13\2\2\u00ac\u00af\5"+
		"\"\22\2\u00ad\u00ae\7\r\2\2\u00ae\u00b0\5\"\22\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\31\3\2\2\2\u00b1\u00b3\7\16\2\2\u00b2\u00b4\7&\2"+
		"\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6"+
		"\5&\24\2\u00b6\u00b8\7\17\2\2\u00b7\u00b9\7&\2\2\u00b8\u00b7\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\5&\24\2\u00bb\u00bc\5\""+
		"\22\2\u00bc\33\3\2\2\2\u00bd\u00be\5\22\n\2\u00be\u00bf\7\32\2\2\u00bf"+
		"\u00c2\5\22\n\2\u00c0\u00c1\t\2\2\2\u00c1\u00c3\5\34\17\2\u00c2\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\35\3\2\2\2\u00c4\u00c5\t\3\2\2\u00c5"+
		"\u00c6\7,\2\2\u00c6\u00c8\7\n\2\2\u00c7\u00c9\5 \21\2\u00c8\u00c7\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7\13\2\2\u00cb"+
		"\u00cc\5\"\22\2\u00cc\37\3\2\2\2\u00cd\u00ce\7\27\2\2\u00ce\u00d4\7,\2"+
		"\2\u00cf\u00d0\7\4\2\2\u00d0\u00d1\7\27\2\2\u00d1\u00d3\7,\2\2\u00d2\u00cf"+
		"\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"!\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00db\7\b\2\2\u00d8\u00dc\5\4\3\2"+
		"\u00d9\u00dc\5\26\f\2\u00da\u00dc\5$\23\2\u00db\u00d8\3\2\2\2\u00db\u00d9"+
		"\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\7\t\2\2\u00e0#\3\2\2\2"+
		"\u00e1\u00e4\7\24\2\2\u00e2\u00e5\5\22\n\2\u00e3\u00e5\7\31\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7\5"+
		"\2\2\u00e7%\3\2\2\2\u00e8\u00e9\t\4\2\2\u00e9\'\3\2\2\2\35,.\67AS\\_d"+
		"jswz\u0081\u0083\u0090\u0093\u00a3\u00a9\u00af\u00b3\u00b8\u00c2\u00c8"+
		"\u00d4\u00db\u00dd\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}