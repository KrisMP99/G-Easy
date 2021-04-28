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
		BOOL=23, TRUE=24, FALSE=25, COMPARER_OP=26, LESS_THAN=27, GREATER_THAN=28, 
		LESS_THAN_EQ=29, GREATER_THAN_EQ=30, IS_EQ=31, NOT_EQ=32, OR=33, AND=34, 
		NEGATION=35, ASSIGN_OP=36, MINUS=37, MOD=38, PLUS=39, MULT=40, DIV=41, 
		NUMBER=42, ID=43;
	public static final int
		RULE_prog = 0, RULE_dcl = 1, RULE_var_dcl = 2, RULE_num_dcl = 3, RULE_pos_dcl = 4, 
		RULE_bool_dcl = 5, RULE_array_dcl = 6, RULE_assign = 7, RULE_pos_assign = 8, 
		RULE_array_access = 9, RULE_expr = 10, RULE_term = 11, RULE_val_expr = 12, 
		RULE_func_call = 13, RULE_actual_param = 14, RULE_stmt = 15, RULE_selection = 16, 
		RULE_iterative = 17, RULE_logical_expr = 18, RULE_logical_term = 19, RULE_logical_val = 20, 
		RULE_comp_expr = 21, RULE_bool_expr = 22, RULE_func_dcl = 23, RULE_formal_param = 24, 
		RULE_block = 25, RULE_return_expr = 26, RULE_val = 27, RULE_comment = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcl", "var_dcl", "num_dcl", "pos_dcl", "bool_dcl", "array_dcl", 
			"assign", "pos_assign", "array_access", "expr", "term", "val_expr", "func_call", 
			"actual_param", "stmt", "selection", "iterative", "logical_expr", "logical_term", 
			"logical_val", "comp_expr", "bool_expr", "func_dcl", "formal_param", 
			"block", "return_expr", "val", "comment"
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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IF) | (1L << FOR) | (1L << POS) | (1L << VOID) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << BOOL_T) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(61);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(58);
					dcl();
					}
					break;
				case 2:
					{
					setState(59);
					stmt();
					}
					break;
				case 3:
					{
					setState(60);
					func_call();
					}
					break;
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(68);
				assign();
				}
				break;
			case 2:
				{
				setState(69);
				var_dcl();
				}
				break;
			case 3:
				{
				setState(70);
				func_dcl();
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

	public static class Var_dclContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(GEasyParser.SEMICOLON, 0); }
		public Num_dclContext num_dcl() {
			return getRuleContext(Num_dclContext.class,0);
		}
		public Pos_dclContext pos_dcl() {
			return getRuleContext(Pos_dclContext.class,0);
		}
		public Array_dclContext array_dcl() {
			return getRuleContext(Array_dclContext.class,0);
		}
		public Bool_dclContext bool_dcl() {
			return getRuleContext(Bool_dclContext.class,0);
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
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(73);
				num_dcl();
				}
				break;
			case 2:
				{
				setState(74);
				pos_dcl();
				}
				break;
			case 3:
				{
				setState(75);
				array_dcl();
				}
				break;
			case 4:
				{
				setState(76);
				bool_dcl();
				}
				break;
			}
			setState(79);
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
			setState(81);
			match(TYPE);
			setState(82);
			match(ID);
			setState(83);
			match(ASSIGN_OP);
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(84);
				expr();
				}
				break;
			case 2:
				{
				setState(85);
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
			setState(88);
			match(POS);
			setState(89);
			match(ID);
			setState(90);
			match(ASSIGN_OP);
			setState(91);
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

	public static class Bool_dclContext extends ParserRuleContext {
		public TerminalNode BOOL_T() { return getToken(GEasyParser.BOOL_T, 0); }
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(GEasyParser.ASSIGN_OP, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public Bool_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterBool_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitBool_dcl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitBool_dcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_dclContext bool_dcl() throws RecognitionException {
		Bool_dclContext _localctx = new Bool_dclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bool_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(BOOL_T);
			setState(94);
			match(ID);
			setState(95);
			match(ASSIGN_OP);
			setState(96);
			logical_expr();
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
		enterRule(_localctx, 12, RULE_array_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(TYPE);
			setState(99);
			match(ID);
			setState(100);
			match(L_BRACKET);
			setState(101);
			match(R_BRACKET);
			setState(102);
			match(ASSIGN_OP);
			setState(103);
			match(L_BRACE);
			{
			setState(104);
			val();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(105);
				match(COMMA);
				setState(106);
				val();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(112);
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
		public TerminalNode SEMICOLON() { return getToken(GEasyParser.SEMICOLON, 0); }
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 14, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(114);
				match(ID);
				}
				break;
			case 2:
				{
				setState(115);
				array_access();
				}
				break;
			}
			setState(118);
			match(ASSIGN_OP);
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LP:
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(119);
				expr();
				}
				break;
			case L_BRACE:
				{
				setState(120);
				pos_assign();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(123);
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
		enterRule(_localctx, 16, RULE_pos_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(125);
			match(L_BRACE);
			setState(126);
			match(XCOORD);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(127);
				match(MINUS);
				}
			}

			setState(130);
			val();
			setState(131);
			match(COMMA);
			setState(132);
			match(YCOORD);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(133);
				match(MINUS);
				}
			}

			setState(136);
			val();
			setState(137);
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
		enterRule(_localctx, 18, RULE_array_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(ID);
			setState(140);
			match(L_BRACKET);
			setState(141);
			expr();
			setState(142);
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
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(GEasyParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(GEasyParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(GEasyParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(GEasyParser.MINUS, i);
		}
		public List<TerminalNode> MULT() { return getTokens(GEasyParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(GEasyParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(GEasyParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(GEasyParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(GEasyParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(GEasyParser.MOD, i);
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
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			term();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << MOD) | (1L << PLUS) | (1L << MULT) | (1L << DIV))) != 0)) {
				{
				{
				setState(145);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << MOD) | (1L << PLUS) | (1L << MULT) | (1L << DIV))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(146);
				term();
				}
				}
				setState(151);
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

	public static class TermContext extends ParserRuleContext {
		public Val_exprContext val_expr() {
			return getRuleContext(Val_exprContext.class,0);
		}
		public TerminalNode LP() { return getToken(GEasyParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(GEasyParser.RP, 0); }
		public TerminalNode MINUS() { return getToken(GEasyParser.MINUS, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_term);
		int _la;
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				val_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(153);
					match(MINUS);
					}
				}

				setState(156);
				match(LP);
				setState(157);
				expr();
				setState(158);
				match(RP);
				}
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

	public static class Val_exprContext extends ParserRuleContext {
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(GEasyParser.MINUS, 0); }
		public Val_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterVal_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitVal_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitVal_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Val_exprContext val_expr() throws RecognitionException {
		Val_exprContext _localctx = new Val_exprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_val_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(162);
				match(MINUS);
				}
			}

			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(165);
				val();
				}
				break;
			case 2:
				{
				setState(166);
				array_access();
				}
				break;
			case 3:
				{
				setState(167);
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
		enterRule(_localctx, 26, RULE_func_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(ID);
			setState(171);
			match(LP);
			setState(172);
			actual_param();
			setState(173);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode COLON() { return getToken(GEasyParser.COLON, 0); }
		public TerminalNode XCOORD() { return getToken(GEasyParser.XCOORD, 0); }
		public TerminalNode YCOORD() { return getToken(GEasyParser.YCOORD, 0); }
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
		enterRule(_localctx, 28, RULE_actual_param);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << XCOORD) | (1L << YCOORD) | (1L << ID))) != 0)) {
				{
				setState(179);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(175);
					match(ID);
					setState(176);
					match(COLON);
					}
					break;
				case XCOORD:
					{
					setState(177);
					match(XCOORD);
					}
					break;
				case YCOORD:
					{
					setState(178);
					match(YCOORD);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(181);
				expr();
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(182);
						match(COMMA);
						setState(183);
						actual_param();
						}
						} 
					}
					setState(188);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		enterRule(_localctx, 30, RULE_stmt);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				assign();
				setState(192);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				expr();
				setState(195);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				func_call();
				setState(198);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(200);
				selection();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				iterative();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(202);
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
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RP() { return getToken(GEasyParser.RP, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
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
		enterRule(_localctx, 32, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(IF);
			setState(206);
			match(LP);
			setState(207);
			logical_expr();
			setState(208);
			match(RP);
			setState(209);
			block();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(210);
				match(ELSE);
				setState(211);
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
		public TerminalNode LP() { return getToken(GEasyParser.LP, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode TO() { return getToken(GEasyParser.TO, 0); }
		public TerminalNode RP() { return getToken(GEasyParser.RP, 0); }
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
		enterRule(_localctx, 34, RULE_iterative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(FOR);
			setState(215);
			match(LP);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(216);
				match(MINUS);
				}
			}

			setState(219);
			val();
			setState(220);
			match(TO);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(221);
				match(MINUS);
				}
			}

			setState(224);
			val();
			setState(225);
			match(RP);
			setState(226);
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
		public List<Logical_termContext> logical_term() {
			return getRuleContexts(Logical_termContext.class);
		}
		public Logical_termContext logical_term(int i) {
			return getRuleContext(Logical_termContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(GEasyParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(GEasyParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(GEasyParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(GEasyParser.OR, i);
		}
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
		enterRule(_localctx, 36, RULE_logical_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			logical_term();
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==AND) {
				{
				{
				setState(229);
				_la = _input.LA(1);
				if ( !(_la==OR || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(230);
				logical_term();
				}
				}
				setState(235);
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

	public static class Logical_termContext extends ParserRuleContext {
		public Logical_valContext logical_val() {
			return getRuleContext(Logical_valContext.class,0);
		}
		public TerminalNode LP() { return getToken(GEasyParser.LP, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RP() { return getToken(GEasyParser.RP, 0); }
		public Logical_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterLogical_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitLogical_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitLogical_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_termContext logical_term() throws RecognitionException {
		Logical_termContext _localctx = new Logical_termContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_logical_term);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				logical_val();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(237);
				match(LP);
				setState(238);
				logical_expr();
				setState(239);
				match(RP);
				}
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

	public static class Logical_valContext extends ParserRuleContext {
		public Comp_exprContext comp_expr() {
			return getRuleContext(Comp_exprContext.class,0);
		}
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public Logical_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterLogical_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitLogical_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitLogical_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_valContext logical_val() throws RecognitionException {
		Logical_valContext _localctx = new Logical_valContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_logical_val);
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				comp_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				bool_expr();
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

	public static class Comp_exprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMPARER_OP() { return getToken(GEasyParser.COMPARER_OP, 0); }
		public Comp_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterComp_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitComp_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitComp_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comp_exprContext comp_expr() throws RecognitionException {
		Comp_exprContext _localctx = new Comp_exprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comp_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			expr();
			setState(248);
			match(COMPARER_OP);
			setState(249);
			expr();
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

	public static class Bool_exprContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(GEasyParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GEasyParser.ID, i);
		}
		public List<TerminalNode> BOOL() { return getTokens(GEasyParser.BOOL); }
		public TerminalNode BOOL(int i) {
			return getToken(GEasyParser.BOOL, i);
		}
		public TerminalNode COMPARER_OP() { return getToken(GEasyParser.COMPARER_OP, 0); }
		public Bool_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterBool_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitBool_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitBool_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_exprContext bool_expr() throws RecognitionException {
		Bool_exprContext _localctx = new Bool_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_bool_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_la = _input.LA(1);
			if ( !(_la==BOOL || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMPARER_OP) {
				{
				setState(252);
				match(COMPARER_OP);
				setState(253);
				_la = _input.LA(1);
				if ( !(_la==BOOL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
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
		enterRule(_localctx, 46, RULE_func_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << TYPE) | (1L << BOOL_T))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(257);
			match(ID);
			setState(258);
			match(LP);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(259);
				formal_param();
				}
			}

			setState(262);
			match(RP);
			setState(263);
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
		enterRule(_localctx, 48, RULE_formal_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(TYPE);
			setState(266);
			match(ID);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(267);
				match(COMMA);
				setState(268);
				match(TYPE);
				setState(269);
				match(ID);
				}
				}
				setState(274);
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
		enterRule(_localctx, 50, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(L_BRACE);
			setState(279); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(279);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(276);
					dcl();
					}
					break;
				case 2:
					{
					setState(277);
					stmt();
					}
					break;
				case 3:
					{
					setState(278);
					return_expr();
					}
					break;
				}
				}
				setState(281); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IF) | (1L << FOR) | (1L << POS) | (1L << VOID) | (1L << RETURN) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << BOOL_T) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0) );
			setState(283);
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
		enterRule(_localctx, 52, RULE_return_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(RETURN);
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LP:
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(286);
				expr();
				}
				break;
			case BOOL:
				{
				setState(287);
				match(BOOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(290);
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
		enterRule(_localctx, 54, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
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
		enterRule(_localctx, 56, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u012b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\7\2@\n"+
		"\2\f\2\16\2C\13\2\3\2\3\2\3\3\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\5\4P\n"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5Y\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bn\n\b\f\b\16\bq\13\b"+
		"\3\b\3\b\3\t\3\t\5\tw\n\t\3\t\3\t\3\t\5\t|\n\t\3\t\3\t\3\n\3\n\3\n\5\n"+
		"\u0083\n\n\3\n\3\n\3\n\3\n\5\n\u0089\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\7\f\u0096\n\f\f\f\16\f\u0099\13\f\3\r\3\r\5\r\u009d"+
		"\n\r\3\r\3\r\3\r\3\r\5\r\u00a3\n\r\3\16\5\16\u00a6\n\16\3\16\3\16\3\16"+
		"\5\16\u00ab\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u00b6"+
		"\n\20\3\20\3\20\3\20\7\20\u00bb\n\20\f\20\16\20\u00be\13\20\5\20\u00c0"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00ce\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00d7\n\22\3\23\3"+
		"\23\3\23\5\23\u00dc\n\23\3\23\3\23\3\23\5\23\u00e1\n\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\7\24\u00ea\n\24\f\24\16\24\u00ed\13\24\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u00f4\n\25\3\26\3\26\5\26\u00f8\n\26\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\5\30\u0101\n\30\3\31\3\31\3\31\3\31\5\31\u0107"+
		"\n\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\7\32\u0111\n\32\f\32\16"+
		"\32\u0114\13\32\3\33\3\33\3\33\3\33\6\33\u011a\n\33\r\33\16\33\u011b\3"+
		"\33\3\33\3\34\3\34\3\34\5\34\u0123\n\34\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\36\2\2\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:\2\7\3\2\'+\3\2#$\4\2\31\31--\4\2\23\23\27\30\3\2,-\2\u0137\2A\3"+
		"\2\2\2\4I\3\2\2\2\6O\3\2\2\2\bS\3\2\2\2\nZ\3\2\2\2\f_\3\2\2\2\16d\3\2"+
		"\2\2\20v\3\2\2\2\22\177\3\2\2\2\24\u008d\3\2\2\2\26\u0092\3\2\2\2\30\u00a2"+
		"\3\2\2\2\32\u00a5\3\2\2\2\34\u00ac\3\2\2\2\36\u00bf\3\2\2\2 \u00cd\3\2"+
		"\2\2\"\u00cf\3\2\2\2$\u00d8\3\2\2\2&\u00e6\3\2\2\2(\u00f3\3\2\2\2*\u00f7"+
		"\3\2\2\2,\u00f9\3\2\2\2.\u00fd\3\2\2\2\60\u0102\3\2\2\2\62\u010b\3\2\2"+
		"\2\64\u0115\3\2\2\2\66\u011f\3\2\2\28\u0126\3\2\2\2:\u0128\3\2\2\2<@\5"+
		"\4\3\2=@\5 \21\2>@\5\34\17\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@C\3\2\2\2A"+
		"?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\2\2\3E\3\3\2\2\2FJ\5\20\t"+
		"\2GJ\5\6\4\2HJ\5\60\31\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2J\5\3\2\2\2KP\5"+
		"\b\5\2LP\5\n\6\2MP\5\16\b\2NP\5\f\7\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON"+
		"\3\2\2\2PQ\3\2\2\2QR\7\5\2\2R\7\3\2\2\2ST\7\27\2\2TU\7-\2\2UX\7&\2\2V"+
		"Y\5\26\f\2WY\5\34\17\2XV\3\2\2\2XW\3\2\2\2Y\t\3\2\2\2Z[\7\20\2\2[\\\7"+
		"-\2\2\\]\7&\2\2]^\5\22\n\2^\13\3\2\2\2_`\7\30\2\2`a\7-\2\2ab\7&\2\2bc"+
		"\5&\24\2c\r\3\2\2\2de\7\27\2\2ef\7-\2\2fg\7\6\2\2gh\7\7\2\2hi\7&\2\2i"+
		"j\7\b\2\2jo\58\35\2kl\7\4\2\2ln\58\35\2mk\3\2\2\2nq\3\2\2\2om\3\2\2\2"+
		"op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\t\2\2s\17\3\2\2\2tw\7-\2\2uw\5\24\13"+
		"\2vt\3\2\2\2vu\3\2\2\2wx\3\2\2\2x{\7&\2\2y|\5\26\f\2z|\5\22\n\2{y\3\2"+
		"\2\2{z\3\2\2\2|}\3\2\2\2}~\7\5\2\2~\21\3\2\2\2\177\u0080\7\b\2\2\u0080"+
		"\u0082\7\21\2\2\u0081\u0083\7\'\2\2\u0082\u0081\3\2\2\2\u0082\u0083\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\58\35\2\u0085\u0086\7\4\2\2\u0086"+
		"\u0088\7\22\2\2\u0087\u0089\7\'\2\2\u0088\u0087\3\2\2\2\u0088\u0089\3"+
		"\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\58\35\2\u008b\u008c\7\t\2\2\u008c"+
		"\23\3\2\2\2\u008d\u008e\7-\2\2\u008e\u008f\7\6\2\2\u008f\u0090\5\26\f"+
		"\2\u0090\u0091\7\7\2\2\u0091\25\3\2\2\2\u0092\u0097\5\30\r\2\u0093\u0094"+
		"\t\2\2\2\u0094\u0096\5\30\r\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2"+
		"\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\27\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u009a\u00a3\5\32\16\2\u009b\u009d\7\'\2\2\u009c\u009b\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7\n\2\2\u009f\u00a0"+
		"\5\26\f\2\u00a0\u00a1\7\13\2\2\u00a1\u00a3\3\2\2\2\u00a2\u009a\3\2\2\2"+
		"\u00a2\u009c\3\2\2\2\u00a3\31\3\2\2\2\u00a4\u00a6\7\'\2\2\u00a5\u00a4"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00aa\3\2\2\2\u00a7\u00ab\58\35\2\u00a8"+
		"\u00ab\5\24\13\2\u00a9\u00ab\5\34\17\2\u00aa\u00a7\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\33\3\2\2\2\u00ac\u00ad\7-\2\2\u00ad"+
		"\u00ae\7\n\2\2\u00ae\u00af\5\36\20\2\u00af\u00b0\7\13\2\2\u00b0\35\3\2"+
		"\2\2\u00b1\u00b2\7-\2\2\u00b2\u00b6\7\3\2\2\u00b3\u00b6\7\21\2\2\u00b4"+
		"\u00b6\7\22\2\2\u00b5\u00b1\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3"+
		"\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00bc\5\26\f\2\u00b8\u00b9\7\4\2\2\u00b9"+
		"\u00bb\5\36\20\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3"+
		"\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00b5\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\37\3\2\2\2\u00c1\u00c2\5\20\t"+
		"\2\u00c2\u00c3\7\5\2\2\u00c3\u00ce\3\2\2\2\u00c4\u00c5\5\26\f\2\u00c5"+
		"\u00c6\7\5\2\2\u00c6\u00ce\3\2\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00c9\7"+
		"\5\2\2\u00c9\u00ce\3\2\2\2\u00ca\u00ce\5\"\22\2\u00cb\u00ce\5$\23\2\u00cc"+
		"\u00ce\5:\36\2\u00cd\u00c1\3\2\2\2\u00cd\u00c4\3\2\2\2\u00cd\u00c7\3\2"+
		"\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"!\3\2\2\2\u00cf\u00d0\7\f\2\2\u00d0\u00d1\7\n\2\2\u00d1\u00d2\5&\24\2"+
		"\u00d2\u00d3\7\13\2\2\u00d3\u00d6\5\64\33\2\u00d4\u00d5\7\r\2\2\u00d5"+
		"\u00d7\5\64\33\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7#\3\2\2"+
		"\2\u00d8\u00d9\7\16\2\2\u00d9\u00db\7\n\2\2\u00da\u00dc\7\'\2\2\u00db"+
		"\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\58"+
		"\35\2\u00de\u00e0\7\17\2\2\u00df\u00e1\7\'\2\2\u00e0\u00df\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\58\35\2\u00e3\u00e4\7\13"+
		"\2\2\u00e4\u00e5\5\64\33\2\u00e5%\3\2\2\2\u00e6\u00eb\5(\25\2\u00e7\u00e8"+
		"\t\3\2\2\u00e8\u00ea\5(\25\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\'\3\2\2\2\u00ed\u00eb\3\2\2\2"+
		"\u00ee\u00f4\5*\26\2\u00ef\u00f0\7\n\2\2\u00f0\u00f1\5&\24\2\u00f1\u00f2"+
		"\7\13\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f3\u00ef\3\2\2\2"+
		"\u00f4)\3\2\2\2\u00f5\u00f8\5,\27\2\u00f6\u00f8\5.\30\2\u00f7\u00f5\3"+
		"\2\2\2\u00f7\u00f6\3\2\2\2\u00f8+\3\2\2\2\u00f9\u00fa\5\26\f\2\u00fa\u00fb"+
		"\7\34\2\2\u00fb\u00fc\5\26\f\2\u00fc-\3\2\2\2\u00fd\u0100\t\4\2\2\u00fe"+
		"\u00ff\7\34\2\2\u00ff\u0101\t\4\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3"+
		"\2\2\2\u0101/\3\2\2\2\u0102\u0103\t\5\2\2\u0103\u0104\7-\2\2\u0104\u0106"+
		"\7\n\2\2\u0105\u0107\5\62\32\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2"+
		"\u0107\u0108\3\2\2\2\u0108\u0109\7\13\2\2\u0109\u010a\5\64\33\2\u010a"+
		"\61\3\2\2\2\u010b\u010c\7\27\2\2\u010c\u0112\7-\2\2\u010d\u010e\7\4\2"+
		"\2\u010e\u010f\7\27\2\2\u010f\u0111\7-\2\2\u0110\u010d\3\2\2\2\u0111\u0114"+
		"\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\63\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0115\u0119\7\b\2\2\u0116\u011a\5\4\3\2\u0117\u011a\5 "+
		"\21\2\u0118\u011a\5\66\34\2\u0119\u0116\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u011e\7\t\2\2\u011e\65\3\2\2\2\u011f\u0122"+
		"\7\24\2\2\u0120\u0123\5\26\f\2\u0121\u0123\7\31\2\2\u0122\u0120\3\2\2"+
		"\2\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\7\5\2\2\u0125\67"+
		"\3\2\2\2\u0126\u0127\t\6\2\2\u01279\3\2\2\2\u0128\u0129\7\25\2\2\u0129"+
		";\3\2\2\2!?AIOXov{\u0082\u0088\u0097\u009c\u00a2\u00a5\u00aa\u00b5\u00bc"+
		"\u00bf\u00cd\u00d6\u00db\u00e0\u00eb\u00f3\u00f7\u0100\u0106\u0112\u0119"+
		"\u011b\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}