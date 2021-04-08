// Generated from C:/Users/Kristian/IdeaProjects/G-Easy/src/com/p4/core\GEasy.g4 by ANTLR 4.9.1
package com.p4.core;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GEasyParser extends Parser {
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
		RULE_prog = 0, RULE_dcl = 1, RULE_var_dcl = 2, RULE_num_dcl = 3, RULE_pos_dcl = 4, 
		RULE_array_dcl = 5, RULE_assign = 6, RULE_pos_assign = 7, RULE_array_access = 8, 
		RULE_expr = 9, RULE_func_call = 10, RULE_actual_param = 11, RULE_stmt = 12, 
		RULE_selection = 13, RULE_iterative = 14, RULE_logical_expr = 15, RULE_func_dcl = 16, 
		RULE_formal_param = 17, RULE_block = 18, RULE_return_expr = 19, RULE_val = 20, 
		RULE_comment = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcl", "var_dcl", "num_dcl", "pos_dcl", "array_dcl", "assign", 
			"pos_assign", "array_access", "expr", "func_call", "actual_param", "stmt", 
			"selection", "iterative", "logical_expr", "func_dcl", "formal_param", 
			"block", "return_expr", "val", "comment"
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
	public String getGrammarFileName() { return "GEasy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GEasyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GEasyParser.EOF, 0); }
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitProg(this);
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
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << POS) | (1L << VOID) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << BOOL_T) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(47);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(44);
					dcl();
					}
					break;
				case 2:
					{
					setState(45);
					stmt();
					}
					break;
				case 3:
					{
					setState(46);
					func_call();
					}
					break;
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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
		public TerminalNode SEMICOLON() { return getToken(GEasyParser.SEMICOLON, 0); }
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public Var_dclContext var_dcl() {
			return getRuleContext(Var_dclContext.class,0);
		}
		public Func_dclContext func_dcl() {
			return getRuleContext(Func_dclContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitDcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitDcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(54);
				assign();
				}
				break;
			case 2:
				{
				setState(55);
				var_dcl();
				}
				break;
			case 3:
				{
				setState(56);
				func_dcl();
				}
				break;
			}
			setState(59);
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
		public Num_dclContext num_dcl() {
			return getRuleContext(Num_dclContext.class,0);
		}
		public Pos_dclContext pos_dcl() {
			return getRuleContext(Pos_dclContext.class,0);
		}
		public Array_dclContext array_dcl() {
			return getRuleContext(Array_dclContext.class,0);
		}
		public Var_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterVar_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitVar_dcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitVar_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_dclContext var_dcl() throws RecognitionException {
		Var_dclContext _localctx = new Var_dclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(61);
				num_dcl();
				}
				break;
			case 2:
				{
				setState(62);
				pos_dcl();
				}
				break;
			case 3:
				{
				setState(63);
				array_dcl();
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

	public static class Num_dclContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(GEasyParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(GEasyParser.ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Num_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterNum_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitNum_dcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitNum_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Num_dclContext num_dcl() throws RecognitionException {
		Num_dclContext _localctx = new Num_dclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_num_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(TYPE);
			setState(67);
			match(ID);
			setState(68);
			match(ASSIGN_OP);
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(69);
				expr();
				}
				break;
			case 2:
				{
				setState(70);
				func_call();
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
		public TerminalNode POS() { return getToken(GEasyParser.POS, 0); }
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(GEasyParser.ASSIGN_OP, 0); }
		public Pos_assignContext pos_assign() {
			return getRuleContext(Pos_assignContext.class,0);
		}
		public Pos_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterPos_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitPos_dcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitPos_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pos_dclContext pos_dcl() throws RecognitionException {
		Pos_dclContext _localctx = new Pos_dclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pos_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(POS);
			setState(74);
			match(ID);
			setState(75);
			match(ASSIGN_OP);
			setState(76);
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
		public TerminalNode TYPE() { return getToken(GEasyParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode L_BRACKET() { return getToken(GEasyParser.L_BRACKET, 0); }
		public TerminalNode R_BRACKET() { return getToken(GEasyParser.R_BRACKET, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(GEasyParser.ASSIGN_OP, 0); }
		public TerminalNode L_BRACE() { return getToken(GEasyParser.L_BRACE, 0); }
		public TerminalNode R_BRACE() { return getToken(GEasyParser.R_BRACE, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GEasyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GEasyParser.COMMA, i);
		}
		public Array_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterArray_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitArray_dcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitArray_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_dclContext array_dcl() throws RecognitionException {
		Array_dclContext _localctx = new Array_dclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_array_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(TYPE);
			setState(79);
			match(ID);
			setState(80);
			match(L_BRACKET);
			setState(81);
			match(R_BRACKET);
			setState(82);
			match(ASSIGN_OP);
			setState(83);
			match(L_BRACE);
			{
			setState(84);
			val();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(85);
				match(COMMA);
				setState(86);
				val();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(92);
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
		public TerminalNode ASSIGN_OP() { return getToken(GEasyParser.ASSIGN_OP, 0); }
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Pos_assignContext pos_assign() {
			return getRuleContext(Pos_assignContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(94);
				match(ID);
				}
				break;
			case 2:
				{
				setState(95);
				array_access();
				}
				break;
			}
			setState(98);
			match(ASSIGN_OP);
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(99);
				expr();
				}
				break;
			case 2:
				{
				setState(100);
				func_call();
				}
				break;
			case 3:
				{
				setState(101);
				pos_assign();
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

	public static class Pos_assignContext extends ParserRuleContext {
		public TerminalNode L_BRACE() { return getToken(GEasyParser.L_BRACE, 0); }
		public TerminalNode XCOORD() { return getToken(GEasyParser.XCOORD, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(GEasyParser.COMMA, 0); }
		public TerminalNode YCOORD() { return getToken(GEasyParser.YCOORD, 0); }
		public TerminalNode R_BRACE() { return getToken(GEasyParser.R_BRACE, 0); }
		public List<TerminalNode> MINUS() { return getTokens(GEasyParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(GEasyParser.MINUS, i);
		}
		public Pos_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterPos_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitPos_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitPos_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pos_assignContext pos_assign() throws RecognitionException {
		Pos_assignContext _localctx = new Pos_assignContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pos_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(104);
			match(L_BRACE);
			setState(105);
			match(XCOORD);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(106);
				match(MINUS);
				}
			}

			setState(109);
			val();
			setState(110);
			match(COMMA);
			setState(111);
			match(YCOORD);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(112);
				match(MINUS);
				}
			}

			setState(115);
			val();
			setState(116);
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

	public static class Array_accessContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode L_BRACKET() { return getToken(GEasyParser.L_BRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode R_BRACKET() { return getToken(GEasyParser.R_BRACKET, 0); }
		public Array_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterArray_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitArray_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitArray_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_accessContext array_access() throws RecognitionException {
		Array_accessContext _localctx = new Array_accessContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_array_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(ID);
			setState(119);
			match(L_BRACKET);
			setState(120);
			expr();
			setState(121);
			match(R_BRACKET);
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
		public List<Array_accessContext> array_access() {
			return getRuleContexts(Array_accessContext.class);
		}
		public Array_accessContext array_access(int i) {
			return getRuleContext(Array_accessContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(GEasyParser.MINUS, 0); }
		public List<TerminalNode> ARITHMETIC_OP() { return getTokens(GEasyParser.ARITHMETIC_OP); }
		public TerminalNode ARITHMETIC_OP(int i) {
			return getToken(GEasyParser.ARITHMETIC_OP, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(123);
				match(MINUS);
				}
			}

			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(126);
				val();
				}
				break;
			case 2:
				{
				setState(127);
				array_access();
				}
				break;
			}
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARITHMETIC_OP) {
				{
				setState(130);
				match(ARITHMETIC_OP);
				setState(133);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(131);
					val();
					}
					break;
				case 2:
					{
					setState(132);
					array_access();
					}
					break;
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARITHMETIC_OP) {
					{
					setState(135);
					match(ARITHMETIC_OP);
					setState(136);
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
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode LP() { return getToken(GEasyParser.LP, 0); }
		public Actual_paramContext actual_param() {
			return getRuleContext(Actual_paramContext.class,0);
		}
		public TerminalNode RP() { return getToken(GEasyParser.RP, 0); }
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterFunc_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitFunc_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_func_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(ID);
			setState(142);
			match(LP);
			setState(143);
			actual_param();
			setState(144);
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

	public static class Actual_paramContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode COLON() { return getToken(GEasyParser.COLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(GEasyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GEasyParser.COMMA, i);
		}
		public List<Actual_paramContext> actual_param() {
			return getRuleContexts(Actual_paramContext.class);
		}
		public Actual_paramContext actual_param(int i) {
			return getRuleContext(Actual_paramContext.class,i);
		}
		public Actual_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actual_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterActual_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitActual_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitActual_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Actual_paramContext actual_param() throws RecognitionException {
		Actual_paramContext _localctx = new Actual_paramContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_actual_param);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(146);
				match(ID);
				setState(147);
				match(COLON);
				setState(148);
				expr();
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(149);
						match(COMMA);
						setState(150);
						actual_param();
						}
						} 
					}
					setState(155);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class StmtContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GEasyParser.SEMICOLON, 0); }
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
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				assign();
				setState(159);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				expr();
				setState(162);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				func_call();
				setState(165);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				selection();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(168);
				iterative();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(169);
				comment();
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
		public TerminalNode IF() { return getToken(GEasyParser.IF, 0); }
		public TerminalNode LP() { return getToken(GEasyParser.LP, 0); }
		public TerminalNode RP() { return getToken(GEasyParser.RP, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(GEasyParser.BOOL, 0); }
		public TerminalNode ELSE() { return getToken(GEasyParser.ELSE, 0); }
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(IF);
			setState(173);
			match(LP);
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(174);
				logical_expr();
				}
				break;
			case BOOL:
				{
				setState(175);
				match(BOOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(178);
			match(RP);
			setState(179);
			block();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(180);
				match(ELSE);
				setState(181);
				block();
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
		public TerminalNode FOR() { return getToken(GEasyParser.FOR, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode TO() { return getToken(GEasyParser.TO, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> MINUS() { return getTokens(GEasyParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(GEasyParser.MINUS, i);
		}
		public IterativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterIterative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitIterative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitIterative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterativeContext iterative() throws RecognitionException {
		IterativeContext _localctx = new IterativeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_iterative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(FOR);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(185);
				match(MINUS);
				}
			}

			setState(188);
			val();
			setState(189);
			match(TO);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(190);
				match(MINUS);
				}
			}

			setState(193);
			val();
			setState(194);
			block();
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
		public TerminalNode COMPARER_OP() { return getToken(GEasyParser.COMPARER_OP, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode AND() { return getToken(GEasyParser.AND, 0); }
		public TerminalNode OR() { return getToken(GEasyParser.OR, 0); }
		public Logical_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterLogical_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitLogical_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitLogical_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_exprContext logical_expr() throws RecognitionException {
		Logical_exprContext _localctx = new Logical_exprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logical_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			expr();
			setState(197);
			match(COMPARER_OP);
			setState(198);
			expr();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR || _la==AND) {
				{
				setState(199);
				_la = _input.LA(1);
				if ( !(_la==OR || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(200);
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

	public static class Func_dclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode LP() { return getToken(GEasyParser.LP, 0); }
		public TerminalNode RP() { return getToken(GEasyParser.RP, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(GEasyParser.TYPE, 0); }
		public TerminalNode VOID() { return getToken(GEasyParser.VOID, 0); }
		public TerminalNode BOOL_T() { return getToken(GEasyParser.BOOL_T, 0); }
		public Formal_paramContext formal_param() {
			return getRuleContext(Formal_paramContext.class,0);
		}
		public Func_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterFunc_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitFunc_dcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitFunc_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_dclContext func_dcl() throws RecognitionException {
		Func_dclContext _localctx = new Func_dclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_func_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << TYPE) | (1L << BOOL_T))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(204);
			match(ID);
			setState(205);
			match(LP);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(206);
				formal_param();
				}
			}

			setState(209);
			match(RP);
			setState(210);
			block();
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

	public static class Formal_paramContext extends ParserRuleContext {
		public List<TerminalNode> TYPE() { return getTokens(GEasyParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(GEasyParser.TYPE, i);
		}
		public List<TerminalNode> ID() { return getTokens(GEasyParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GEasyParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GEasyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GEasyParser.COMMA, i);
		}
		public Formal_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterFormal_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitFormal_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitFormal_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_paramContext formal_param() throws RecognitionException {
		Formal_paramContext _localctx = new Formal_paramContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_formal_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(TYPE);
			setState(213);
			match(ID);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(214);
				match(COMMA);
				setState(215);
				match(TYPE);
				setState(216);
				match(ID);
				}
				}
				setState(221);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode L_BRACE() { return getToken(GEasyParser.L_BRACE, 0); }
		public TerminalNode R_BRACE() { return getToken(GEasyParser.R_BRACE, 0); }
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
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(L_BRACE);
			setState(226); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(223);
					dcl();
					}
					break;
				case 2:
					{
					setState(224);
					stmt();
					}
					break;
				case 3:
					{
					setState(225);
					return_expr();
					}
					break;
				}
				}
				setState(228); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << POS) | (1L << VOID) | (1L << RETURN) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << BOOL_T) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0) );
			setState(230);
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
		public TerminalNode RETURN() { return getToken(GEasyParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(GEasyParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(GEasyParser.BOOL, 0); }
		public Return_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterReturn_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitReturn_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitReturn_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_exprContext return_expr() throws RecognitionException {
		Return_exprContext _localctx = new Return_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_return_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(RETURN);
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(233);
				expr();
				}
				break;
			case BOOL:
				{
				setState(234);
				match(BOOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(237);
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
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(GEasyParser.NUMBER, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode LINE_COMMENT() { return getToken(GEasyParser.LINE_COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(LINE_COMMENT);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00f6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\2\3\2\3\3\3\3\3\3\5\3<\n\3\3\3\3\3\3\4\3\4\3\4"+
		"\5\4C\n\4\3\5\3\5\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\7\7Z\n\7\f\7\16\7]\13\7\3\7\3\7\3\b\3\b\5\bc"+
		"\n\b\3\b\3\b\3\b\3\b\5\bi\n\b\3\t\3\t\3\t\5\tn\n\t\3\t\3\t\3\t\3\t\5\t"+
		"t\n\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\5\13\177\n\13\3\13\3\13\5\13"+
		"\u0083\n\13\3\13\3\13\3\13\5\13\u0088\n\13\3\13\3\13\5\13\u008c\n\13\5"+
		"\13\u008e\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r\u009a\n\r\f"+
		"\r\16\r\u009d\13\r\5\r\u009f\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\5\16\u00ad\n\16\3\17\3\17\3\17\3\17\5\17\u00b3"+
		"\n\17\3\17\3\17\3\17\3\17\5\17\u00b9\n\17\3\20\3\20\5\20\u00bd\n\20\3"+
		"\20\3\20\3\20\5\20\u00c2\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00cc\n\21\3\22\3\22\3\22\3\22\5\22\u00d2\n\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\7\23\u00dc\n\23\f\23\16\23\u00df\13\23\3\24\3"+
		"\24\3\24\3\24\6\24\u00e5\n\24\r\24\16\24\u00e6\3\24\3\24\3\25\3\25\3\25"+
		"\5\25\u00ee\n\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\2\2\30\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,\2\5\3\2!\"\4\2\23\23\27\30\3\2+,\2"+
		"\u0104\2\63\3\2\2\2\4;\3\2\2\2\6B\3\2\2\2\bD\3\2\2\2\nK\3\2\2\2\fP\3\2"+
		"\2\2\16b\3\2\2\2\20j\3\2\2\2\22x\3\2\2\2\24~\3\2\2\2\26\u008f\3\2\2\2"+
		"\30\u009e\3\2\2\2\32\u00ac\3\2\2\2\34\u00ae\3\2\2\2\36\u00ba\3\2\2\2 "+
		"\u00c6\3\2\2\2\"\u00cd\3\2\2\2$\u00d6\3\2\2\2&\u00e0\3\2\2\2(\u00ea\3"+
		"\2\2\2*\u00f1\3\2\2\2,\u00f3\3\2\2\2.\62\5\4\3\2/\62\5\32\16\2\60\62\5"+
		"\26\f\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2"+
		"\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\2\2\3\67\3\3\2"+
		"\2\28<\5\16\b\29<\5\6\4\2:<\5\"\22\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<=\3"+
		"\2\2\2=>\7\5\2\2>\5\3\2\2\2?C\5\b\5\2@C\5\n\6\2AC\5\f\7\2B?\3\2\2\2B@"+
		"\3\2\2\2BA\3\2\2\2C\7\3\2\2\2DE\7\27\2\2EF\7,\2\2FI\7$\2\2GJ\5\24\13\2"+
		"HJ\5\26\f\2IG\3\2\2\2IH\3\2\2\2J\t\3\2\2\2KL\7\20\2\2LM\7,\2\2MN\7$\2"+
		"\2NO\5\20\t\2O\13\3\2\2\2PQ\7\27\2\2QR\7,\2\2RS\7\6\2\2ST\7\7\2\2TU\7"+
		"$\2\2UV\7\b\2\2V[\5*\26\2WX\7\4\2\2XZ\5*\26\2YW\3\2\2\2Z]\3\2\2\2[Y\3"+
		"\2\2\2[\\\3\2\2\2\\^\3\2\2\2][\3\2\2\2^_\7\t\2\2_\r\3\2\2\2`c\7,\2\2a"+
		"c\5\22\n\2b`\3\2\2\2ba\3\2\2\2cd\3\2\2\2dh\7$\2\2ei\5\24\13\2fi\5\26\f"+
		"\2gi\5\20\t\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\17\3\2\2\2jk\7\b\2\2km\7"+
		"\21\2\2ln\7&\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\5*\26\2pq\7\4\2\2qs\7"+
		"\22\2\2rt\7&\2\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\5*\26\2vw\7\t\2\2w\21"+
		"\3\2\2\2xy\7,\2\2yz\7\6\2\2z{\5\24\13\2{|\7\7\2\2|\23\3\2\2\2}\177\7&"+
		"\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0082\3\2\2\2\u0080\u0083\5*\26\2\u0081"+
		"\u0083\5\22\n\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u008d\3"+
		"\2\2\2\u0084\u0087\7%\2\2\u0085\u0088\5*\26\2\u0086\u0088\5\22\n\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u008a\7%"+
		"\2\2\u008a\u008c\5\24\13\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u0084\3\2\2\2\u008d\u008e\3\2\2\2\u008e\25\3\2\2"+
		"\2\u008f\u0090\7,\2\2\u0090\u0091\7\n\2\2\u0091\u0092\5\30\r\2\u0092\u0093"+
		"\7\13\2\2\u0093\27\3\2\2\2\u0094\u0095\7,\2\2\u0095\u0096\7\3\2\2\u0096"+
		"\u009b\5\24\13\2\u0097\u0098\7\4\2\2\u0098\u009a\5\30\r\2\u0099\u0097"+
		"\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u0094\3\2\2\2\u009e\u009f\3\2"+
		"\2\2\u009f\31\3\2\2\2\u00a0\u00a1\5\16\b\2\u00a1\u00a2\7\5\2\2\u00a2\u00ad"+
		"\3\2\2\2\u00a3\u00a4\5\24\13\2\u00a4\u00a5\7\5\2\2\u00a5\u00ad\3\2\2\2"+
		"\u00a6\u00a7\5\26\f\2\u00a7\u00a8\7\5\2\2\u00a8\u00ad\3\2\2\2\u00a9\u00ad"+
		"\5\34\17\2\u00aa\u00ad\5\36\20\2\u00ab\u00ad\5,\27\2\u00ac\u00a0\3\2\2"+
		"\2\u00ac\u00a3\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\33\3\2\2\2\u00ae\u00af\7\f\2\2\u00af"+
		"\u00b2\7\n\2\2\u00b0\u00b3\5 \21\2\u00b1\u00b3\7\31\2\2\u00b2\u00b0\3"+
		"\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\7\13\2\2\u00b5"+
		"\u00b8\5&\24\2\u00b6\u00b7\7\r\2\2\u00b7\u00b9\5&\24\2\u00b8\u00b6\3\2"+
		"\2\2\u00b8\u00b9\3\2\2\2\u00b9\35\3\2\2\2\u00ba\u00bc\7\16\2\2\u00bb\u00bd"+
		"\7&\2\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bf\5*\26\2\u00bf\u00c1\7\17\2\2\u00c0\u00c2\7&\2\2\u00c1\u00c0\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\5*\26\2\u00c4"+
		"\u00c5\5&\24\2\u00c5\37\3\2\2\2\u00c6\u00c7\5\24\13\2\u00c7\u00c8\7\32"+
		"\2\2\u00c8\u00cb\5\24\13\2\u00c9\u00ca\t\2\2\2\u00ca\u00cc\5 \21\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc!\3\2\2\2\u00cd\u00ce\t\3\2\2"+
		"\u00ce\u00cf\7,\2\2\u00cf\u00d1\7\n\2\2\u00d0\u00d2\5$\23\2\u00d1\u00d0"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7\13\2\2"+
		"\u00d4\u00d5\5&\24\2\u00d5#\3\2\2\2\u00d6\u00d7\7\27\2\2\u00d7\u00dd\7"+
		",\2\2\u00d8\u00d9\7\4\2\2\u00d9\u00da\7\27\2\2\u00da\u00dc\7,\2\2\u00db"+
		"\u00d8\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de%\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e4\7\b\2\2\u00e1\u00e5"+
		"\5\4\3\2\u00e2\u00e5\5\32\16\2\u00e3\u00e5\5(\25\2\u00e4\u00e1\3\2\2\2"+
		"\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\7\t\2\2\u00e9"+
		"\'\3\2\2\2\u00ea\u00ed\7\24\2\2\u00eb\u00ee\5\24\13\2\u00ec\u00ee\7\31"+
		"\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\7\5\2\2\u00f0)\3\2\2\2\u00f1\u00f2\t\4\2\2\u00f2+\3\2\2\2\u00f3"+
		"\u00f4\7\25\2\2\u00f4-\3\2\2\2\36\61\63;BI[bhms~\u0082\u0087\u008b\u008d"+
		"\u009b\u009e\u00ac\u00b2\u00b8\u00bc\u00c1\u00cb\u00d1\u00dd\u00e4\u00e6"+
		"\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}