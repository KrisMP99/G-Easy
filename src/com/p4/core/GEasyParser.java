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
		LP=8, RP=9, IF=10, ELSE=11, FOR=12, TO=13, POS=14, VOID=15, RETURN=16, 
		LINE_COMMENT=17, WHITESPACE=18, TYPE=19, BOOL_T=20, BOOL=21, TRUE=22, 
		FALSE=23, COMPARER_OP=24, LESS_THAN=25, GREATER_THAN=26, LESS_THAN_EQ=27, 
		GREATER_THAN_EQ=28, IS_EQ=29, NOT_EQ=30, OR=31, AND=32, NEGATION=33, ASSIGN_OP=34, 
		MINUS=35, MOD=36, PLUS=37, MULT=38, DIV=39, NUMBER=40, ID=41;
	public static final int
		RULE_prog = 0, RULE_dcl = 1, RULE_var_dcl = 2, RULE_num_dcl = 3, RULE_pos_dcl = 4, 
		RULE_bool_dcl = 5, RULE_array_dcl = 6, RULE_assign = 7, RULE_pos_assign = 8, 
		RULE_array_access = 9, RULE_logical_expr = 10, RULE_comp_expr = 11, RULE_expr = 12, 
		RULE_term_expr = 13, RULE_term = 14, RULE_val_expr = 15, RULE_func_call = 16, 
		RULE_actual_param = 17, RULE_stmt = 18, RULE_selection = 19, RULE_iterative = 20, 
		RULE_func_dcl = 21, RULE_formal_param = 22, RULE_block = 23, RULE_return_expr = 24, 
		RULE_val = 25, RULE_comment = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcl", "var_dcl", "num_dcl", "pos_dcl", "bool_dcl", "array_dcl", 
			"assign", "pos_assign", "array_access", "logical_expr", "comp_expr", 
			"expr", "term_expr", "term", "val_expr", "func_call", "actual_param", 
			"stmt", "selection", "iterative", "func_dcl", "formal_param", "block", 
			"return_expr", "val", "comment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "';'", "'['", "']'", "'{'", "'}'", "'('", "')'", 
			"'if'", "'else'", "'for'", "'to'", "'pos'", "'void'", "'return'", null, 
			null, null, "'bool'", null, "'true'", "'false'", null, "'<'", "'>'", 
			"'<='", "'>='", "'=='", "'!='", "'||'", "'&&'", "'!'", "'='", "'-'", 
			"'%'", "'+'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COLON", "COMMA", "SEMICOLON", "L_BRACKET", "R_BRACKET", "L_BRACE", 
			"R_BRACE", "LP", "RP", "IF", "ELSE", "FOR", "TO", "POS", "VOID", "RETURN", 
			"LINE_COMMENT", "WHITESPACE", "TYPE", "BOOL_T", "BOOL", "TRUE", "FALSE", 
			"COMPARER_OP", "LESS_THAN", "GREATER_THAN", "LESS_THAN_EQ", "GREATER_THAN_EQ", 
			"IS_EQ", "NOT_EQ", "OR", "AND", "NEGATION", "ASSIGN_OP", "MINUS", "MOD", 
			"PLUS", "MULT", "DIV", "NUMBER", "ID"
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IF) | (1L << FOR) | (1L << POS) | (1L << VOID) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << BOOL_T) | (1L << BOOL) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(57);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(54);
					dcl();
					}
					break;
				case 2:
					{
					setState(55);
					stmt();
					}
					break;
				case 3:
					{
					setState(56);
					func_call();
					}
					break;
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(64);
				assign();
				}
				break;
			case 2:
				{
				setState(65);
				var_dcl();
				}
				break;
			case 3:
				{
				setState(66);
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
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(69);
				num_dcl();
				}
				break;
			case 2:
				{
				setState(70);
				pos_dcl();
				}
				break;
			case 3:
				{
				setState(71);
				array_dcl();
				}
				break;
			case 4:
				{
				setState(72);
				bool_dcl();
				}
				break;
			}
			setState(75);
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
			setState(77);
			match(TYPE);
			setState(78);
			match(ID);
			setState(79);
			match(ASSIGN_OP);
			setState(80);
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
			setState(82);
			match(POS);
			setState(83);
			match(ID);
			setState(84);
			match(ASSIGN_OP);
			setState(85);
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
			setState(87);
			match(BOOL_T);
			setState(88);
			match(ID);
			setState(89);
			match(ASSIGN_OP);
			setState(90);
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
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
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
			setState(92);
			match(TYPE);
			setState(93);
			match(ID);
			setState(94);
			match(L_BRACKET);
			setState(95);
			match(R_BRACKET);
			setState(96);
			match(ASSIGN_OP);
			setState(97);
			match(L_BRACE);
			{
			setState(98);
			term();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(99);
				match(COMMA);
				setState(100);
				term();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(106);
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
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(108);
				match(ID);
				}
				break;
			case 2:
				{
				setState(109);
				array_access();
				}
				break;
			}
			setState(112);
			match(ASSIGN_OP);
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LP:
			case BOOL:
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(113);
				expr();
				}
				break;
			case L_BRACE:
				{
				setState(114);
				pos_assign();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(117);
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
		public List<TerminalNode> ID() { return getTokens(GEasyParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GEasyParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(GEasyParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(GEasyParser.COLON, i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(GEasyParser.COMMA, 0); }
		public TerminalNode R_BRACE() { return getToken(GEasyParser.R_BRACE, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(119);
			match(L_BRACE);
			setState(120);
			match(ID);
			setState(121);
			match(COLON);
			setState(122);
			term();
			setState(123);
			match(COMMA);
			setState(124);
			match(ID);
			setState(125);
			match(COLON);
			setState(126);
			term();
			setState(127);
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
			setState(129);
			match(ID);
			setState(130);
			match(L_BRACKET);
			setState(131);
			expr();
			setState(132);
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

	public static class Logical_exprContext extends ParserRuleContext {
		public List<Comp_exprContext> comp_expr() {
			return getRuleContexts(Comp_exprContext.class);
		}
		public Comp_exprContext comp_expr(int i) {
			return getRuleContext(Comp_exprContext.class,i);
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
		enterRule(_localctx, 20, RULE_logical_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			comp_expr();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==AND) {
				{
				{
				setState(135);
				_la = _input.LA(1);
				if ( !(_la==OR || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(136);
				comp_expr();
				}
				}
				setState(141);
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
		enterRule(_localctx, 22, RULE_comp_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			expr();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMPARER_OP) {
				{
				setState(143);
				match(COMPARER_OP);
				setState(144);
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
		public List<Term_exprContext> term_expr() {
			return getRuleContexts(Term_exprContext.class);
		}
		public Term_exprContext term_expr(int i) {
			return getRuleContext(Term_exprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(GEasyParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(GEasyParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(GEasyParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(GEasyParser.MINUS, i);
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
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			term_expr();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MINUS || _la==PLUS) {
				{
				{
				setState(148);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==PLUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(149);
				term_expr();
				}
				}
				setState(154);
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

	public static class Term_exprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
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
		public Term_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).enterTerm_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GEasyListener ) ((GEasyListener)listener).exitTerm_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GEasyVisitor ) return ((GEasyVisitor<? extends T>)visitor).visitTerm_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Term_exprContext term_expr() throws RecognitionException {
		Term_exprContext _localctx = new Term_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			term();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << MULT) | (1L << DIV))) != 0)) {
				{
				{
				setState(156);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << MULT) | (1L << DIV))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(157);
				term();
				}
				}
				setState(162);
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
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
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
		enterRule(_localctx, 28, RULE_term);
		int _la;
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				val_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(164);
					match(MINUS);
					}
				}

				setState(167);
				match(LP);
				setState(168);
				logical_expr();
				setState(169);
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
		enterRule(_localctx, 30, RULE_val_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(173);
				match(MINUS);
				}
			}

			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(176);
				val();
				}
				break;
			case 2:
				{
				setState(177);
				array_access();
				}
				break;
			case 3:
				{
				setState(178);
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
		public TerminalNode RP() { return getToken(GEasyParser.RP, 0); }
		public List<Actual_paramContext> actual_param() {
			return getRuleContexts(Actual_paramContext.class);
		}
		public Actual_paramContext actual_param(int i) {
			return getRuleContext(Actual_paramContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GEasyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GEasyParser.COMMA, i);
		}
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
		enterRule(_localctx, 32, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(ID);
			setState(182);
			match(LP);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(183);
				actual_param();
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(184);
					match(COMMA);
					setState(185);
					actual_param();
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(193);
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
		enterRule(_localctx, 34, RULE_actual_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(ID);
			setState(196);
			match(COLON);
			setState(197);
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
		enterRule(_localctx, 36, RULE_stmt);
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				assign();
				setState(200);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				expr();
				setState(203);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				func_call();
				setState(206);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				selection();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				iterative();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(210);
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
		enterRule(_localctx, 38, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(IF);
			setState(214);
			match(LP);
			setState(215);
			logical_expr();
			setState(216);
			match(RP);
			setState(217);
			block();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(218);
				match(ELSE);
				setState(219);
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
		enterRule(_localctx, 40, RULE_iterative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(FOR);
			setState(223);
			match(LP);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(224);
				match(MINUS);
				}
			}

			setState(227);
			val();
			setState(228);
			match(TO);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(229);
				match(MINUS);
				}
			}

			setState(232);
			val();
			setState(233);
			match(RP);
			setState(234);
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
		enterRule(_localctx, 42, RULE_func_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << TYPE) | (1L << BOOL_T))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(237);
			match(ID);
			setState(238);
			match(LP);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(239);
				formal_param();
				}
			}

			setState(242);
			match(RP);
			setState(243);
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
		enterRule(_localctx, 44, RULE_formal_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(TYPE);
			setState(246);
			match(ID);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(247);
				match(COMMA);
				setState(248);
				match(TYPE);
				setState(249);
				match(ID);
				}
				}
				setState(254);
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
		enterRule(_localctx, 46, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(L_BRACE);
			setState(259); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(259);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(256);
					dcl();
					}
					break;
				case 2:
					{
					setState(257);
					stmt();
					}
					break;
				case 3:
					{
					setState(258);
					return_expr();
					}
					break;
				}
				}
				setState(261); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IF) | (1L << FOR) | (1L << POS) | (1L << VOID) | (1L << RETURN) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << BOOL_T) | (1L << BOOL) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0) );
			setState(263);
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
		enterRule(_localctx, 48, RULE_return_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(RETURN);
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(266);
				expr();
				}
				break;
			case 2:
				{
				setState(267);
				match(BOOL);
				}
				break;
			}
			setState(270);
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
		public TerminalNode BOOL() { return getToken(GEasyParser.BOOL, 0); }
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
		enterRule(_localctx, 50, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << NUMBER) | (1L << ID))) != 0)) ) {
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
		enterRule(_localctx, 52, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u0117\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3\2"+
		"\3\2\3\3\3\3\3\3\5\3F\n\3\3\4\3\4\3\4\3\4\5\4L\n\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\7\bh\n\b\f\b\16\bk\13\b\3\b\3\b\3\t\3\t\5\tq\n\t\3\t\3"+
		"\t\3\t\5\tv\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\7\f\u008c\n\f\f\f\16\f\u008f\13\f\3\r\3"+
		"\r\3\r\5\r\u0094\n\r\3\16\3\16\3\16\7\16\u0099\n\16\f\16\16\16\u009c\13"+
		"\16\3\17\3\17\3\17\7\17\u00a1\n\17\f\17\16\17\u00a4\13\17\3\20\3\20\5"+
		"\20\u00a8\n\20\3\20\3\20\3\20\3\20\5\20\u00ae\n\20\3\21\5\21\u00b1\n\21"+
		"\3\21\3\21\3\21\5\21\u00b6\n\21\3\22\3\22\3\22\3\22\3\22\7\22\u00bd\n"+
		"\22\f\22\16\22\u00c0\13\22\5\22\u00c2\n\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d6"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00df\n\25\3\26\3\26\3\26"+
		"\5\26\u00e4\n\26\3\26\3\26\3\26\5\26\u00e9\n\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\5\27\u00f3\n\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\7\30\u00fd\n\30\f\30\16\30\u0100\13\30\3\31\3\31\3\31\3\31\6\31"+
		"\u0106\n\31\r\31\16\31\u0107\3\31\3\31\3\32\3\32\3\32\5\32\u010f\n\32"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\34\2\2\35\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\66\2\7\3\2!\"\4\2%%\'\'\4\2&&()\4\2\21"+
		"\21\25\26\4\2\27\27*+\2\u011f\2=\3\2\2\2\4E\3\2\2\2\6K\3\2\2\2\bO\3\2"+
		"\2\2\nT\3\2\2\2\fY\3\2\2\2\16^\3\2\2\2\20p\3\2\2\2\22y\3\2\2\2\24\u0083"+
		"\3\2\2\2\26\u0088\3\2\2\2\30\u0090\3\2\2\2\32\u0095\3\2\2\2\34\u009d\3"+
		"\2\2\2\36\u00ad\3\2\2\2 \u00b0\3\2\2\2\"\u00b7\3\2\2\2$\u00c5\3\2\2\2"+
		"&\u00d5\3\2\2\2(\u00d7\3\2\2\2*\u00e0\3\2\2\2,\u00ee\3\2\2\2.\u00f7\3"+
		"\2\2\2\60\u0101\3\2\2\2\62\u010b\3\2\2\2\64\u0112\3\2\2\2\66\u0114\3\2"+
		"\2\28<\5\4\3\29<\5&\24\2:<\5\"\22\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<?\3"+
		"\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\2\2\3A\3\3\2\2\2BF"+
		"\5\20\t\2CF\5\6\4\2DF\5,\27\2EB\3\2\2\2EC\3\2\2\2ED\3\2\2\2F\5\3\2\2\2"+
		"GL\5\b\5\2HL\5\n\6\2IL\5\16\b\2JL\5\f\7\2KG\3\2\2\2KH\3\2\2\2KI\3\2\2"+
		"\2KJ\3\2\2\2LM\3\2\2\2MN\7\5\2\2N\7\3\2\2\2OP\7\25\2\2PQ\7+\2\2QR\7$\2"+
		"\2RS\5\32\16\2S\t\3\2\2\2TU\7\20\2\2UV\7+\2\2VW\7$\2\2WX\5\22\n\2X\13"+
		"\3\2\2\2YZ\7\26\2\2Z[\7+\2\2[\\\7$\2\2\\]\5\26\f\2]\r\3\2\2\2^_\7\25\2"+
		"\2_`\7+\2\2`a\7\6\2\2ab\7\7\2\2bc\7$\2\2cd\7\b\2\2di\5\36\20\2ef\7\4\2"+
		"\2fh\5\36\20\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2"+
		"\2\2lm\7\t\2\2m\17\3\2\2\2nq\7+\2\2oq\5\24\13\2pn\3\2\2\2po\3\2\2\2qr"+
		"\3\2\2\2ru\7$\2\2sv\5\32\16\2tv\5\22\n\2us\3\2\2\2ut\3\2\2\2vw\3\2\2\2"+
		"wx\7\5\2\2x\21\3\2\2\2yz\7\b\2\2z{\7+\2\2{|\7\3\2\2|}\5\36\20\2}~\7\4"+
		"\2\2~\177\7+\2\2\177\u0080\7\3\2\2\u0080\u0081\5\36\20\2\u0081\u0082\7"+
		"\t\2\2\u0082\23\3\2\2\2\u0083\u0084\7+\2\2\u0084\u0085\7\6\2\2\u0085\u0086"+
		"\5\32\16\2\u0086\u0087\7\7\2\2\u0087\25\3\2\2\2\u0088\u008d\5\30\r\2\u0089"+
		"\u008a\t\2\2\2\u008a\u008c\5\30\r\2\u008b\u0089\3\2\2\2\u008c\u008f\3"+
		"\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\27\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0093\5\32\16\2\u0091\u0092\7\32\2\2\u0092\u0094"+
		"\5\32\16\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\31\3\2\2\2\u0095"+
		"\u009a\5\34\17\2\u0096\u0097\t\3\2\2\u0097\u0099\5\34\17\2\u0098\u0096"+
		"\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\33\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u00a2\5\36\20\2\u009e\u009f\t\4"+
		"\2\2\u009f\u00a1\5\36\20\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\35\3\2\2\2\u00a4\u00a2\3\2\2"+
		"\2\u00a5\u00ae\5 \21\2\u00a6\u00a8\7%\2\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\7\n\2\2\u00aa\u00ab\5\26\f\2"+
		"\u00ab\u00ac\7\13\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a5\3\2\2\2\u00ad\u00a7"+
		"\3\2\2\2\u00ae\37\3\2\2\2\u00af\u00b1\7%\2\2\u00b0\u00af\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b5\3\2\2\2\u00b2\u00b6\5\64\33\2\u00b3\u00b6\5"+
		"\24\13\2\u00b4\u00b6\5\"\22\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2"+
		"\u00b5\u00b4\3\2\2\2\u00b6!\3\2\2\2\u00b7\u00b8\7+\2\2\u00b8\u00c1\7\n"+
		"\2\2\u00b9\u00be\5$\23\2\u00ba\u00bb\7\4\2\2\u00bb\u00bd\5$\23\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00b9\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\13\2\2\u00c4#\3\2\2\2"+
		"\u00c5\u00c6\7+\2\2\u00c6\u00c7\7\3\2\2\u00c7\u00c8\5\32\16\2\u00c8%\3"+
		"\2\2\2\u00c9\u00ca\5\20\t\2\u00ca\u00cb\7\5\2\2\u00cb\u00d6\3\2\2\2\u00cc"+
		"\u00cd\5\32\16\2\u00cd\u00ce\7\5\2\2\u00ce\u00d6\3\2\2\2\u00cf\u00d0\5"+
		"\"\22\2\u00d0\u00d1\7\5\2\2\u00d1\u00d6\3\2\2\2\u00d2\u00d6\5(\25\2\u00d3"+
		"\u00d6\5*\26\2\u00d4\u00d6\5\66\34\2\u00d5\u00c9\3\2\2\2\u00d5\u00cc\3"+
		"\2\2\2\u00d5\u00cf\3\2\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d4\3\2\2\2\u00d6\'\3\2\2\2\u00d7\u00d8\7\f\2\2\u00d8\u00d9\7\n\2\2"+
		"\u00d9\u00da\5\26\f\2\u00da\u00db\7\13\2\2\u00db\u00de\5\60\31\2\u00dc"+
		"\u00dd\7\r\2\2\u00dd\u00df\5\60\31\2\u00de\u00dc\3\2\2\2\u00de\u00df\3"+
		"\2\2\2\u00df)\3\2\2\2\u00e0\u00e1\7\16\2\2\u00e1\u00e3\7\n\2\2\u00e2\u00e4"+
		"\7%\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e6\5\64\33\2\u00e6\u00e8\7\17\2\2\u00e7\u00e9\7%\2\2\u00e8\u00e7\3"+
		"\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\5\64\33\2\u00eb"+
		"\u00ec\7\13\2\2\u00ec\u00ed\5\60\31\2\u00ed+\3\2\2\2\u00ee\u00ef\t\5\2"+
		"\2\u00ef\u00f0\7+\2\2\u00f0\u00f2\7\n\2\2\u00f1\u00f3\5.\30\2\u00f2\u00f1"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7\13\2\2"+
		"\u00f5\u00f6\5\60\31\2\u00f6-\3\2\2\2\u00f7\u00f8\7\25\2\2\u00f8\u00fe"+
		"\7+\2\2\u00f9\u00fa\7\4\2\2\u00fa\u00fb\7\25\2\2\u00fb\u00fd\7+\2\2\u00fc"+
		"\u00f9\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2"+
		"\2\2\u00ff/\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0105\7\b\2\2\u0102\u0106"+
		"\5\4\3\2\u0103\u0106\5&\24\2\u0104\u0106\5\62\32\2\u0105\u0102\3\2\2\2"+
		"\u0105\u0103\3\2\2\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105"+
		"\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\7\t\2\2\u010a"+
		"\61\3\2\2\2\u010b\u010e\7\22\2\2\u010c\u010f\5\32\16\2\u010d\u010f\7\27"+
		"\2\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0111\7\5\2\2\u0111\63\3\2\2\2\u0112\u0113\t\6\2\2\u0113\65\3\2\2\2\u0114"+
		"\u0115\7\23\2\2\u0115\67\3\2\2\2\34;=EKipu\u008d\u0093\u009a\u00a2\u00a7"+
		"\u00ad\u00b0\u00b5\u00be\u00c1\u00d5\u00de\u00e3\u00e8\u00f2\u00fe\u0105"+
		"\u0107\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}