// Generated from C:/Users/Krist/IdeaProjects/G-Easy/src/com/p4/core\GEasy.g4 by ANTLR 4.9.1
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
		LP=8, RP=9, IF=10, ELSE=11, FOR=12, TO=13, VOID=14, RETURN=15, LINE_COMMENT=16, 
		WHITESPACE=17, TYPE=18, BOOL_T=19, BOOL=20, TRUE=21, FALSE=22, COMPARER_OP=23, 
		LESS_THAN=24, GREATER_THAN=25, LESS_THAN_EQ=26, GREATER_THAN_EQ=27, IS_EQ=28, 
		NOT_EQ=29, OR=30, AND=31, NEGATION=32, ASSIGN_OP=33, MINUS=34, MOD=35, 
		PLUS=36, MULT=37, DIV=38, NUMBER=39, ID=40;
	public static final int
		RULE_prog = 0, RULE_dcl = 1, RULE_var_dcl = 2, RULE_num_dcl = 3, RULE_bool_dcl = 4, 
		RULE_array_dcl = 5, RULE_assign = 6, RULE_pos_assign = 7, RULE_array_access = 8, 
		RULE_logical_expr = 9, RULE_comp_expr = 10, RULE_expr = 11, RULE_term_expr = 12, 
		RULE_term = 13, RULE_val_expr = 14, RULE_func_call = 15, RULE_actual_param = 16, 
		RULE_stmt = 17, RULE_selection = 18, RULE_iterative = 19, RULE_func_dcl = 20, 
		RULE_formal_param = 21, RULE_block = 22, RULE_return_expr = 23, RULE_val = 24, 
		RULE_comment = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dcl", "var_dcl", "num_dcl", "bool_dcl", "array_dcl", "assign", 
			"pos_assign", "array_access", "logical_expr", "comp_expr", "expr", "term_expr", 
			"term", "val_expr", "func_call", "actual_param", "stmt", "selection", 
			"iterative", "func_dcl", "formal_param", "block", "return_expr", "val", 
			"comment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "','", "';'", "'['", "']'", "'{'", "'}'", "'('", "')'", 
			"'if'", "'else'", "'for'", "'to'", "'void'", "'return'", null, null, 
			null, "'bool'", null, "'true'", "'false'", null, "'<'", "'>'", "'<='", 
			"'>='", "'=='", "'!='", "'||'", "'&&'", "'!'", "'='", "'-'", "'%'", "'+'", 
			"'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COLON", "COMMA", "SEMICOLON", "L_BRACKET", "R_BRACKET", "L_BRACE", 
			"R_BRACE", "LP", "RP", "IF", "ELSE", "FOR", "TO", "VOID", "RETURN", "LINE_COMMENT", 
			"WHITESPACE", "TYPE", "BOOL_T", "BOOL", "TRUE", "FALSE", "COMPARER_OP", 
			"LESS_THAN", "GREATER_THAN", "LESS_THAN_EQ", "GREATER_THAN_EQ", "IS_EQ", 
			"NOT_EQ", "OR", "AND", "NEGATION", "ASSIGN_OP", "MINUS", "MOD", "PLUS", 
			"MULT", "DIV", "NUMBER", "ID"
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
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IF) | (1L << FOR) | (1L << VOID) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << BOOL_T) | (1L << BOOL) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(55);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(52);
					dcl();
					}
					break;
				case 2:
					{
					setState(53);
					stmt();
					}
					break;
				case 3:
					{
					setState(54);
					func_call();
					}
					break;
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
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
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(62);
				assign();
				}
				break;
			case 2:
				{
				setState(63);
				var_dcl();
				}
				break;
			case 3:
				{
				setState(64);
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
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(67);
				num_dcl();
				}
				break;
			case 2:
				{
				setState(68);
				array_dcl();
				}
				break;
			case 3:
				{
				setState(69);
				bool_dcl();
				}
				break;
			}
			setState(72);
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
		public Pos_assignContext pos_assign() {
			return getRuleContext(Pos_assignContext.class,0);
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
			setState(74);
			match(TYPE);
			setState(75);
			match(ID);
			setState(76);
			match(ASSIGN_OP);
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LP:
			case BOOL:
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(77);
				expr();
				}
				break;
			case L_BRACE:
				{
				setState(78);
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
		enterRule(_localctx, 8, RULE_bool_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(BOOL_T);
			setState(82);
			match(ID);
			setState(83);
			match(ASSIGN_OP);
			setState(84);
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
		enterRule(_localctx, 10, RULE_array_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(TYPE);
			setState(87);
			match(ID);
			setState(88);
			match(L_BRACKET);
			setState(89);
			match(R_BRACKET);
			setState(90);
			match(ASSIGN_OP);
			setState(91);
			match(L_BRACE);
			{
			setState(92);
			term();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(93);
				match(COMMA);
				setState(94);
				term();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(100);
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
		enterRule(_localctx, 12, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(102);
				match(ID);
				}
				break;
			case 2:
				{
				setState(103);
				array_access();
				}
				break;
			}
			setState(106);
			match(ASSIGN_OP);
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LP:
			case BOOL:
			case MINUS:
			case NUMBER:
			case ID:
				{
				setState(107);
				expr();
				}
				break;
			case L_BRACE:
				{
				setState(108);
				pos_assign();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(111);
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
		enterRule(_localctx, 14, RULE_pos_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(L_BRACE);
			setState(114);
			match(ID);
			setState(115);
			match(COLON);
			setState(116);
			term();
			setState(117);
			match(COMMA);
			setState(118);
			match(ID);
			setState(119);
			match(COLON);
			setState(120);
			term();
			setState(121);
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
			setState(123);
			match(ID);
			setState(124);
			match(L_BRACKET);
			setState(125);
			expr();
			setState(126);
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
		enterRule(_localctx, 18, RULE_logical_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			comp_expr();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR || _la==AND) {
				{
				{
				setState(129);
				_la = _input.LA(1);
				if ( !(_la==OR || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(130);
				comp_expr();
				}
				}
				setState(135);
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
		enterRule(_localctx, 20, RULE_comp_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			expr();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMPARER_OP) {
				{
				setState(137);
				match(COMPARER_OP);
				setState(138);
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
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			term_expr();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MINUS || _la==PLUS) {
				{
				{
				setState(142);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==PLUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(143);
				term_expr();
				}
				}
				setState(148);
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
		enterRule(_localctx, 24, RULE_term_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			term();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << MULT) | (1L << DIV))) != 0)) {
				{
				{
				setState(150);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOD) | (1L << MULT) | (1L << DIV))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				term();
				}
				}
				setState(156);
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
		enterRule(_localctx, 26, RULE_term);
		int _la;
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				val_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(158);
					match(MINUS);
					}
				}

				setState(161);
				match(LP);
				setState(162);
				logical_expr();
				setState(163);
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
		enterRule(_localctx, 28, RULE_val_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(167);
				match(MINUS);
				}
			}

			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(170);
				val();
				}
				break;
			case 2:
				{
				setState(171);
				array_access();
				}
				break;
			case 3:
				{
				setState(172);
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
		enterRule(_localctx, 30, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(ID);
			setState(176);
			match(LP);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE || _la==ID) {
				{
				setState(177);
				actual_param();
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(178);
					match(COMMA);
					setState(179);
					actual_param();
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(187);
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
		public TerminalNode COLON() { return getToken(GEasyParser.COLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(GEasyParser.TYPE, 0); }
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
		enterRule(_localctx, 32, RULE_actual_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if ( !(_la==TYPE || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(190);
			match(COLON);
			setState(191);
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
		enterRule(_localctx, 34, RULE_stmt);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				assign();
				setState(194);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				expr();
				setState(197);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				func_call();
				setState(200);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
				selection();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(203);
				iterative();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(204);
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
		enterRule(_localctx, 36, RULE_selection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(IF);
			setState(208);
			match(LP);
			setState(209);
			logical_expr();
			setState(210);
			match(RP);
			setState(211);
			block();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(212);
				match(ELSE);
				setState(213);
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
		enterRule(_localctx, 38, RULE_iterative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(FOR);
			setState(217);
			match(LP);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(218);
				match(MINUS);
				}
			}

			setState(221);
			val();
			setState(222);
			match(TO);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(223);
				match(MINUS);
				}
			}

			setState(226);
			val();
			setState(227);
			match(RP);
			setState(228);
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
		public List<Formal_paramContext> formal_param() {
			return getRuleContexts(Formal_paramContext.class);
		}
		public Formal_paramContext formal_param(int i) {
			return getRuleContext(Formal_paramContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GEasyParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GEasyParser.COMMA, i);
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
		enterRule(_localctx, 40, RULE_func_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << TYPE) | (1L << BOOL_T))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(231);
			match(ID);
			setState(232);
			match(LP);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(233);
				formal_param();
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(234);
					match(COMMA);
					setState(235);
					formal_param();
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(243);
			match(RP);
			setState(244);
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
		public TerminalNode TYPE() { return getToken(GEasyParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(GEasyParser.ID, 0); }
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
		enterRule(_localctx, 42, RULE_formal_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(TYPE);
			setState(247);
			match(ID);
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
		enterRule(_localctx, 44, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(L_BRACE);
			setState(253); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(253);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(250);
					dcl();
					}
					break;
				case 2:
					{
					setState(251);
					stmt();
					}
					break;
				case 3:
					{
					setState(252);
					return_expr();
					}
					break;
				}
				}
				setState(255); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LP) | (1L << IF) | (1L << FOR) | (1L << VOID) | (1L << RETURN) | (1L << LINE_COMMENT) | (1L << TYPE) | (1L << BOOL_T) | (1L << BOOL) | (1L << MINUS) | (1L << NUMBER) | (1L << ID))) != 0) );
			setState(257);
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
		enterRule(_localctx, 46, RULE_return_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(RETURN);
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(260);
				expr();
				}
				break;
			case 2:
				{
				setState(261);
				match(BOOL);
				}
				break;
			}
			setState(264);
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
		enterRule(_localctx, 48, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
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
		enterRule(_localctx, 50, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0111\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\5\3D\n\3\3\4\3\4\3\4\5\4I\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5R"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7b\n\7"+
		"\f\7\16\7e\13\7\3\7\3\7\3\b\3\b\5\bk\n\b\3\b\3\b\3\b\5\bp\n\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\7\13\u0086\n\13\f\13\16\13\u0089\13\13\3\f\3\f\3\f\5\f\u008e\n\f"+
		"\3\r\3\r\3\r\7\r\u0093\n\r\f\r\16\r\u0096\13\r\3\16\3\16\3\16\7\16\u009b"+
		"\n\16\f\16\16\16\u009e\13\16\3\17\3\17\5\17\u00a2\n\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00a8\n\17\3\20\5\20\u00ab\n\20\3\20\3\20\3\20\5\20\u00b0\n"+
		"\20\3\21\3\21\3\21\3\21\3\21\7\21\u00b7\n\21\f\21\16\21\u00ba\13\21\5"+
		"\21\u00bc\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00d0\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u00d9\n\24\3\25\3\25\3\25\5\25\u00de\n\25\3\25\3"+
		"\25\3\25\5\25\u00e3\n\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\7\26\u00ef\n\26\f\26\16\26\u00f2\13\26\5\26\u00f4\n\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\6\30\u0100\n\30\r\30\16\30\u0101"+
		"\3\30\3\30\3\31\3\31\3\31\5\31\u0109\n\31\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\33\2\2\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\2\b\3\2 !\4\2$$&&\4\2%%\'(\4\2\24\24**\4\2\20\20\24\25\4\2\26\26)*\2"+
		"\u011a\2;\3\2\2\2\4C\3\2\2\2\6H\3\2\2\2\bL\3\2\2\2\nS\3\2\2\2\fX\3\2\2"+
		"\2\16j\3\2\2\2\20s\3\2\2\2\22}\3\2\2\2\24\u0082\3\2\2\2\26\u008a\3\2\2"+
		"\2\30\u008f\3\2\2\2\32\u0097\3\2\2\2\34\u00a7\3\2\2\2\36\u00aa\3\2\2\2"+
		" \u00b1\3\2\2\2\"\u00bf\3\2\2\2$\u00cf\3\2\2\2&\u00d1\3\2\2\2(\u00da\3"+
		"\2\2\2*\u00e8\3\2\2\2,\u00f8\3\2\2\2.\u00fb\3\2\2\2\60\u0105\3\2\2\2\62"+
		"\u010c\3\2\2\2\64\u010e\3\2\2\2\66:\5\4\3\2\67:\5$\23\28:\5 \21\29\66"+
		"\3\2\2\29\67\3\2\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2"+
		"=;\3\2\2\2>?\7\2\2\3?\3\3\2\2\2@D\5\16\b\2AD\5\6\4\2BD\5*\26\2C@\3\2\2"+
		"\2CA\3\2\2\2CB\3\2\2\2D\5\3\2\2\2EI\5\b\5\2FI\5\f\7\2GI\5\n\6\2HE\3\2"+
		"\2\2HF\3\2\2\2HG\3\2\2\2IJ\3\2\2\2JK\7\5\2\2K\7\3\2\2\2LM\7\24\2\2MN\7"+
		"*\2\2NQ\7#\2\2OR\5\30\r\2PR\5\20\t\2QO\3\2\2\2QP\3\2\2\2R\t\3\2\2\2ST"+
		"\7\25\2\2TU\7*\2\2UV\7#\2\2VW\5\24\13\2W\13\3\2\2\2XY\7\24\2\2YZ\7*\2"+
		"\2Z[\7\6\2\2[\\\7\7\2\2\\]\7#\2\2]^\7\b\2\2^c\5\34\17\2_`\7\4\2\2`b\5"+
		"\34\17\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2f"+
		"g\7\t\2\2g\r\3\2\2\2hk\7*\2\2ik\5\22\n\2jh\3\2\2\2ji\3\2\2\2kl\3\2\2\2"+
		"lo\7#\2\2mp\5\30\r\2np\5\20\t\2om\3\2\2\2on\3\2\2\2pq\3\2\2\2qr\7\5\2"+
		"\2r\17\3\2\2\2st\7\b\2\2tu\7*\2\2uv\7\3\2\2vw\5\34\17\2wx\7\4\2\2xy\7"+
		"*\2\2yz\7\3\2\2z{\5\34\17\2{|\7\t\2\2|\21\3\2\2\2}~\7*\2\2~\177\7\6\2"+
		"\2\177\u0080\5\30\r\2\u0080\u0081\7\7\2\2\u0081\23\3\2\2\2\u0082\u0087"+
		"\5\26\f\2\u0083\u0084\t\2\2\2\u0084\u0086\5\26\f\2\u0085\u0083\3\2\2\2"+
		"\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\25"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008d\5\30\r\2\u008b\u008c\7\31\2\2"+
		"\u008c\u008e\5\30\r\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\27"+
		"\3\2\2\2\u008f\u0094\5\32\16\2\u0090\u0091\t\3\2\2\u0091\u0093\5\32\16"+
		"\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\31\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009c\5\34\17\2\u0098"+
		"\u0099\t\4\2\2\u0099\u009b\5\34\17\2\u009a\u0098\3\2\2\2\u009b\u009e\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\33\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a8\5\36\20\2\u00a0\u00a2\7$\2\2\u00a1\u00a0\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\n\2\2\u00a4"+
		"\u00a5\5\24\13\2\u00a5\u00a6\7\13\2\2\u00a6\u00a8\3\2\2\2\u00a7\u009f"+
		"\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a8\35\3\2\2\2\u00a9\u00ab\7$\2\2\u00aa"+
		"\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00af\3\2\2\2\u00ac\u00b0\5\62"+
		"\32\2\u00ad\u00b0\5\22\n\2\u00ae\u00b0\5 \21\2\u00af\u00ac\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00ae\3\2\2\2\u00b0\37\3\2\2\2\u00b1\u00b2\7*\2\2"+
		"\u00b2\u00bb\7\n\2\2\u00b3\u00b8\5\"\22\2\u00b4\u00b5\7\4\2\2\u00b5\u00b7"+
		"\5\"\22\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00b3"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\7\13\2\2"+
		"\u00be!\3\2\2\2\u00bf\u00c0\t\5\2\2\u00c0\u00c1\7\3\2\2\u00c1\u00c2\5"+
		"\30\r\2\u00c2#\3\2\2\2\u00c3\u00c4\5\16\b\2\u00c4\u00c5\7\5\2\2\u00c5"+
		"\u00d0\3\2\2\2\u00c6\u00c7\5\30\r\2\u00c7\u00c8\7\5\2\2\u00c8\u00d0\3"+
		"\2\2\2\u00c9\u00ca\5 \21\2\u00ca\u00cb\7\5\2\2\u00cb\u00d0\3\2\2\2\u00cc"+
		"\u00d0\5&\24\2\u00cd\u00d0\5(\25\2\u00ce\u00d0\5\64\33\2\u00cf\u00c3\3"+
		"\2\2\2\u00cf\u00c6\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0%\3\2\2\2\u00d1\u00d2\7\f\2\2"+
		"\u00d2\u00d3\7\n\2\2\u00d3\u00d4\5\24\13\2\u00d4\u00d5\7\13\2\2\u00d5"+
		"\u00d8\5.\30\2\u00d6\u00d7\7\r\2\2\u00d7\u00d9\5.\30\2\u00d8\u00d6\3\2"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9\'\3\2\2\2\u00da\u00db\7\16\2\2\u00db\u00dd"+
		"\7\n\2\2\u00dc\u00de\7$\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\5\62\32\2\u00e0\u00e2\7\17\2\2\u00e1\u00e3"+
		"\7$\2\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e5\5\62\32\2\u00e5\u00e6\7\13\2\2\u00e6\u00e7\5.\30\2\u00e7)\3\2\2"+
		"\2\u00e8\u00e9\t\6\2\2\u00e9\u00ea\7*\2\2\u00ea\u00f3\7\n\2\2\u00eb\u00f0"+
		"\5,\27\2\u00ec\u00ed\7\4\2\2\u00ed\u00ef\5,\27\2\u00ee\u00ec\3\2\2\2\u00ef"+
		"\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4\3\2"+
		"\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00eb\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\7\13\2\2\u00f6\u00f7\5.\30\2\u00f7+\3\2\2\2"+
		"\u00f8\u00f9\7\24\2\2\u00f9\u00fa\7*\2\2\u00fa-\3\2\2\2\u00fb\u00ff\7"+
		"\b\2\2\u00fc\u0100\5\4\3\2\u00fd\u0100\5$\23\2\u00fe\u0100\5\60\31\2\u00ff"+
		"\u00fc\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0104\7\t\2\2\u0104/\3\2\2\2\u0105\u0108\7\21\2\2\u0106\u0109\5\30\r"+
		"\2\u0107\u0109\7\26\2\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\7\5\2\2\u010b\61\3\2\2\2\u010c\u010d\t\7\2"+
		"\2\u010d\63\3\2\2\2\u010e\u010f\7\22\2\2\u010f\65\3\2\2\2\359;CHQcjo\u0087"+
		"\u008d\u0094\u009c\u00a1\u00a7\u00aa\u00af\u00b8\u00bb\u00cf\u00d8\u00dd"+
		"\u00e2\u00f0\u00f3\u00ff\u0101\u0108";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}