// Generated from Parser.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, WS=2, SINGLECOMMENT=3, MULTICOMMENT=4, INHERITS=5, CLASS=6, 
		TYPE=7, ID=8, INT=9, SEMICOLON=10, TRUE=11, FALSE=12, FI=13, IF=14, IN=15, 
		ISVOID=16, LET=17, LOOP=18, POOL=19, THEN=20, ELSE=21, WHILE=22, CASE=23, 
		ESAC=24, NEW=25, OF=26, NOT=27, LPAREN=28, RPAREN=29, LBRACE=30, RBRACE=31, 
		COLON=32, ASSIGN=33, DARROW=34, NEG=35, COMMA=36, PERIOD=37, AT=38, MUL=39, 
		ADD=40, MINUS=41, DIV=42, LT=43, LEQUALS=44, EQUALS=45, ERROR=46, STRING=47;
	public static final int
		RULE_program = 0, RULE_class = 1, RULE_feature = 2, RULE_param = 3, RULE_expr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class", "feature", "param", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "';'", "'true'", 
			"'false'", "'fi'", "'if'", "'in'", "'isvoid'", "'let'", "'loop'", "'pool'", 
			"'then'", "'else'", "'while'", "'case'", "'esac'", "'new'", "'of'", "'not'", 
			"'('", "')'", "'{'", "'}'", "':'", "'<-'", "'=>'", "'~'", "','", "'.'", 
			"'@'", "'*'", "'+'", "'-'", "'/'", "'<'", "'<='", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "WS", "SINGLECOMMENT", "MULTICOMMENT", "INHERITS", "CLASS", 
			"TYPE", "ID", "INT", "SEMICOLON", "TRUE", "FALSE", "FI", "IF", "IN", 
			"ISVOID", "LET", "LOOP", "POOL", "THEN", "ELSE", "WHILE", "CASE", "ESAC", 
			"NEW", "OF", "NOT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "COLON", 
			"ASSIGN", "DARROW", "NEG", "COMMA", "PERIOD", "AT", "MUL", "ADD", "MINUS", 
			"DIV", "LT", "LEQUALS", "EQUALS", "ERROR", "STRING"
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
	public String getGrammarFileName() { return "Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ParserParser.EOF, 0); }
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				class_();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
			setState(15);
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

	public static class ClassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(ParserParser.CLASS, 0); }
		public List<TerminalNode> TYPE() { return getTokens(ParserParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(ParserParser.TYPE, i);
		}
		public TerminalNode LBRACE() { return getToken(ParserParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ParserParser.RBRACE, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(ParserParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(ParserParser.SEMICOLON, i);
		}
		public TerminalNode INHERITS() { return getToken(ParserParser.INHERITS, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitClass(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			match(CLASS);
			setState(18);
			match(TYPE);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(19);
				match(INHERITS);
				setState(20);
				match(TYPE);
				}
			}

			setState(23);
			match(LBRACE);
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(24);
				feature();
				setState(25);
				match(SEMICOLON);
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			match(RBRACE);
			setState(33);
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

	public static class FeatureContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ParserParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ParserParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(ParserParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(ParserParser.TYPE, 0); }
		public TerminalNode LBRACE() { return getToken(ParserParser.LBRACE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ParserParser.RBRACE, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ParserParser.COMMA, i);
		}
		public TerminalNode ASSIGN() { return getToken(ParserParser.ASSIGN, 0); }
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitFeature(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_feature);
		int _la;
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(ID);
				setState(36);
				match(LPAREN);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(37);
					param();
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(38);
						match(COMMA);
						setState(39);
						param();
						}
						}
						setState(44);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(50);
				match(RPAREN);
				setState(51);
				match(COLON);
				setState(52);
				match(TYPE);
				setState(53);
				match(LBRACE);
				setState(54);
				expr(0);
				setState(55);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(ID);
				setState(58);
				match(COLON);
				setState(59);
				match(TYPE);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(60);
					match(ASSIGN);
					setState(61);
					expr(0);
					}
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ParserParser.ID, 0); }
		public TerminalNode COLON() { return getToken(ParserParser.COLON, 0); }
		public TerminalNode TYPE() { return getToken(ParserParser.TYPE, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(ID);
			setState(67);
			match(COLON);
			setState(68);
			match(TYPE);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileExprContext extends ExprContext {
		public TerminalNode WHILE() { return getToken(ParserParser.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOOP() { return getToken(ParserParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(ParserParser.POOL, 0); }
		public WhileExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterWhileExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitWhileExpr(this);
		}
	}
	public static class MulExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode MUL() { return getToken(ParserParser.MUL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitMulExpr(this);
		}
	}
	public static class StringExprContext extends ExprContext {
		public TerminalNode STRING() { return getToken(ParserParser.STRING, 0); }
		public StringExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitStringExpr(this);
		}
	}
	public static class TrueExprContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(ParserParser.TRUE, 0); }
		public TrueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterTrueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitTrueExpr(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(ParserParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitIdExpr(this);
		}
	}
	public static class IfThenExprContext extends ExprContext {
		public TerminalNode IF() { return getToken(ParserParser.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(ParserParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(ParserParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(ParserParser.FI, 0); }
		public IfThenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterIfThenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitIfThenExpr(this);
		}
	}
	public static class LetExprContext extends ExprContext {
		public TerminalNode LET() { return getToken(ParserParser.LET, 0); }
		public List<TerminalNode> ID() { return getTokens(ParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ParserParser.ID, i);
		}
		public List<TerminalNode> COLON() { return getTokens(ParserParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ParserParser.COLON, i);
		}
		public List<TerminalNode> TYPE() { return getTokens(ParserParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(ParserParser.TYPE, i);
		}
		public TerminalNode IN() { return getToken(ParserParser.IN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(ParserParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(ParserParser.ASSIGN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ParserParser.COMMA, i);
		}
		public LetExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterLetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitLetExpr(this);
		}
	}
	public static class NegExprContext extends ExprContext {
		public TerminalNode NEG() { return getToken(ParserParser.NEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterNegExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitNegExpr(this);
		}
	}
	public static class LtExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode LT() { return getToken(ParserParser.LT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LtExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterLtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitLtExpr(this);
		}
	}
	public static class AddExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode ADD() { return getToken(ParserParser.ADD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitAddExpr(this);
		}
	}
	public static class DotExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PERIOD() { return getToken(ParserParser.PERIOD, 0); }
		public TerminalNode ID() { return getToken(ParserParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ParserParser.RPAREN, 0); }
		public TerminalNode AT() { return getToken(ParserParser.AT, 0); }
		public TerminalNode TYPE() { return getToken(ParserParser.TYPE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ParserParser.COMMA, i);
		}
		public DotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterDotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitDotExpr(this);
		}
	}
	public static class IdParenExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(ParserParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ParserParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ParserParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ParserParser.COMMA, i);
		}
		public IdParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterIdParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitIdParenExpr(this);
		}
	}
	public static class AssignExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(ParserParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(ParserParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitAssignExpr(this);
		}
	}
	public static class BraceExprContext extends ExprContext {
		public TerminalNode LBRACE() { return getToken(ParserParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ParserParser.RBRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(ParserParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(ParserParser.SEMICOLON, i);
		}
		public BraceExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterBraceExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitBraceExpr(this);
		}
	}
	public static class IsvoidExprContext extends ExprContext {
		public TerminalNode ISVOID() { return getToken(ParserParser.ISVOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsvoidExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterIsvoidExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitIsvoidExpr(this);
		}
	}
	public static class FalseExprContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(ParserParser.FALSE, 0); }
		public FalseExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterFalseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitFalseExpr(this);
		}
	}
	public static class DivExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode DIV() { return getToken(ParserParser.DIV, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitDivExpr(this);
		}
	}
	public static class EqualsExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode EQUALS() { return getToken(ParserParser.EQUALS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualsExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterEqualsExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitEqualsExpr(this);
		}
	}
	public static class NewExprContext extends ExprContext {
		public TerminalNode NEW() { return getToken(ParserParser.NEW, 0); }
		public TerminalNode TYPE() { return getToken(ParserParser.TYPE, 0); }
		public NewExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitNewExpr(this);
		}
	}
	public static class LequalExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode LEQUALS() { return getToken(ParserParser.LEQUALS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LequalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterLequalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitLequalExpr(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(ParserParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitNotExpr(this);
		}
	}
	public static class IntExprContext extends ExprContext {
		public TerminalNode INT() { return getToken(ParserParser.INT, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitIntExpr(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(ParserParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ParserParser.RPAREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitParenExpr(this);
		}
	}
	public static class MinusExprContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode MINUS() { return getToken(ParserParser.MINUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).enterMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ParserListener ) ((ParserListener)listener).exitMinusExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(71);
				match(ID);
				setState(72);
				match(ASSIGN);
				setState(73);
				expr(24);
				}
				break;
			case 2:
				{
				_localctx = new IdParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				match(ID);
				setState(75);
				match(LPAREN);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << ISVOID) | (1L << LET) | (1L << WHILE) | (1L << NEW) | (1L << NOT) | (1L << LPAREN) | (1L << LBRACE) | (1L << NEG) | (1L << STRING))) != 0)) {
					{
					{
					setState(76);
					expr(0);
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(77);
						match(COMMA);
						setState(78);
						expr(0);
						}
						}
						setState(83);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(89);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new IfThenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(IF);
				setState(91);
				expr(0);
				setState(92);
				match(THEN);
				setState(93);
				expr(0);
				setState(94);
				match(ELSE);
				setState(95);
				expr(0);
				setState(96);
				match(FI);
				}
				break;
			case 4:
				{
				_localctx = new WhileExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(WHILE);
				setState(99);
				expr(0);
				setState(100);
				match(LOOP);
				setState(101);
				expr(0);
				setState(102);
				match(POOL);
				}
				break;
			case 5:
				{
				_localctx = new BraceExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				match(LBRACE);
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(105);
					expr(0);
					setState(106);
					match(SEMICOLON);
					}
					}
					setState(110); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << ISVOID) | (1L << LET) | (1L << WHILE) | (1L << NEW) | (1L << NOT) | (1L << LPAREN) | (1L << LBRACE) | (1L << NEG) | (1L << STRING))) != 0) );
				setState(112);
				match(RBRACE);
				}
				break;
			case 6:
				{
				_localctx = new LetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(LET);
				setState(115);
				match(ID);
				setState(116);
				match(COLON);
				setState(117);
				match(TYPE);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(118);
					match(ASSIGN);
					setState(119);
					expr(0);
					}
				}

				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(122);
					match(COMMA);
					setState(123);
					match(ID);
					setState(124);
					match(COLON);
					setState(125);
					match(TYPE);
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ASSIGN) {
						{
						setState(126);
						match(ASSIGN);
						setState(127);
						expr(0);
						}
					}

					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(IN);
				setState(136);
				expr(18);
				}
				break;
			case 7:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(NEW);
				setState(138);
				match(TYPE);
				}
				break;
			case 8:
				{
				_localctx = new NegExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(NEG);
				setState(140);
				expr(16);
				}
				break;
			case 9:
				{
				_localctx = new IsvoidExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				match(ISVOID);
				setState(142);
				expr(15);
				}
				break;
			case 10:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(LPAREN);
				setState(144);
				expr(0);
				setState(145);
				match(RPAREN);
				}
				break;
			case 11:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(NOT);
				setState(148);
				expr(6);
				}
				break;
			case 12:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(INT);
				}
				break;
			case 13:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(STRING);
				}
				break;
			case 14:
				{
				_localctx = new TrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(TRUE);
				}
				break;
			case 15:
				{
				_localctx = new FalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				match(FALSE);
				}
				break;
			case 16:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(199);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MulExprContext(new ExprContext(_parentctx, _parentState));
						((MulExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(156);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(157);
						match(MUL);
						setState(158);
						((MulExprContext)_localctx).right = expr(14);
						}
						break;
					case 2:
						{
						_localctx = new DivExprContext(new ExprContext(_parentctx, _parentState));
						((DivExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(160);
						match(DIV);
						setState(161);
						((DivExprContext)_localctx).right = expr(13);
						}
						break;
					case 3:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						((AddExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(163);
						match(ADD);
						setState(164);
						((AddExprContext)_localctx).right = expr(12);
						}
						break;
					case 4:
						{
						_localctx = new MinusExprContext(new ExprContext(_parentctx, _parentState));
						((MinusExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(166);
						match(MINUS);
						setState(167);
						((MinusExprContext)_localctx).right = expr(11);
						}
						break;
					case 5:
						{
						_localctx = new LequalExprContext(new ExprContext(_parentctx, _parentState));
						((LequalExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(169);
						match(LEQUALS);
						setState(170);
						((LequalExprContext)_localctx).right = expr(10);
						}
						break;
					case 6:
						{
						_localctx = new LtExprContext(new ExprContext(_parentctx, _parentState));
						((LtExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(171);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(172);
						match(LT);
						setState(173);
						((LtExprContext)_localctx).right = expr(9);
						}
						break;
					case 7:
						{
						_localctx = new EqualsExprContext(new ExprContext(_parentctx, _parentState));
						((EqualsExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(174);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(175);
						match(EQUALS);
						setState(176);
						((EqualsExprContext)_localctx).right = expr(8);
						}
						break;
					case 8:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(177);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(180);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==AT) {
							{
							setState(178);
							match(AT);
							setState(179);
							match(TYPE);
							}
						}

						setState(182);
						match(PERIOD);
						setState(183);
						match(ID);
						setState(184);
						match(LPAREN);
						setState(195);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << ISVOID) | (1L << LET) | (1L << WHILE) | (1L << NEW) | (1L << NOT) | (1L << LPAREN) | (1L << LBRACE) | (1L << NEG) | (1L << STRING))) != 0)) {
							{
							{
							setState(185);
							expr(0);
							setState(190);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(186);
								match(COMMA);
								setState(187);
								expr(0);
								}
								}
								setState(192);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							setState(197);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(198);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 22);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u00cd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0004\u0000\f\b\u0000\u000b\u0000\f\u0000\r\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0016\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001c\b\u0001"+
		"\n\u0001\f\u0001\u001f\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002)\b"+
		"\u0002\n\u0002\f\u0002,\t\u0002\u0005\u0002.\b\u0002\n\u0002\f\u00021"+
		"\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002?\b\u0002\u0003\u0002A\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"P\b\u0004\n\u0004\f\u0004S\t\u0004\u0005\u0004U\b\u0004\n\u0004\f\u0004"+
		"X\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0004\u0004m\b\u0004\u000b\u0004\f\u0004n\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004y\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0081\b\u0004\u0005"+
		"\u0004\u0083\b\u0004\n\u0004\f\u0004\u0086\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u009b\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u00b5\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u00bd\b\u0004\n\u0004"+
		"\f\u0004\u00c0\t\u0004\u0005\u0004\u00c2\b\u0004\n\u0004\f\u0004\u00c5"+
		"\t\u0004\u0001\u0004\u0005\u0004\u00c8\b\u0004\n\u0004\f\u0004\u00cb\t"+
		"\u0004\u0001\u0004\u0000\u0001\b\u0005\u0000\u0002\u0004\u0006\b\u0000"+
		"\u0000\u00ee\u0000\u000b\u0001\u0000\u0000\u0000\u0002\u0011\u0001\u0000"+
		"\u0000\u0000\u0004@\u0001\u0000\u0000\u0000\u0006B\u0001\u0000\u0000\u0000"+
		"\b\u009a\u0001\u0000\u0000\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001"+
		"\u0000\u0000\u0000\f\r\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000"+
		"\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000"+
		"\u000f\u0010\u0005\u0000\u0000\u0001\u0010\u0001\u0001\u0000\u0000\u0000"+
		"\u0011\u0012\u0005\u0006\u0000\u0000\u0012\u0015\u0005\u0007\u0000\u0000"+
		"\u0013\u0014\u0005\u0005\u0000\u0000\u0014\u0016\u0005\u0007\u0000\u0000"+
		"\u0015\u0013\u0001\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000"+
		"\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u001d\u0005\u001e\u0000\u0000"+
		"\u0018\u0019\u0003\u0004\u0002\u0000\u0019\u001a\u0005\n\u0000\u0000\u001a"+
		"\u001c\u0001\u0000\u0000\u0000\u001b\u0018\u0001\u0000\u0000\u0000\u001c"+
		"\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e \u0001\u0000\u0000\u0000\u001f\u001d"+
		"\u0001\u0000\u0000\u0000 !\u0005\u001f\u0000\u0000!\"\u0005\n\u0000\u0000"+
		"\"\u0003\u0001\u0000\u0000\u0000#$\u0005\b\u0000\u0000$/\u0005\u001c\u0000"+
		"\u0000%*\u0003\u0006\u0003\u0000&\'\u0005$\u0000\u0000\')\u0003\u0006"+
		"\u0003\u0000(&\u0001\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001"+
		"\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000"+
		",*\u0001\u0000\u0000\u0000-%\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u000002\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000023\u0005\u001d\u0000\u000034\u0005"+
		" \u0000\u000045\u0005\u0007\u0000\u000056\u0005\u001e\u0000\u000067\u0003"+
		"\b\u0004\u000078\u0005\u001f\u0000\u00008A\u0001\u0000\u0000\u00009:\u0005"+
		"\b\u0000\u0000:;\u0005 \u0000\u0000;>\u0005\u0007\u0000\u0000<=\u0005"+
		"!\u0000\u0000=?\u0003\b\u0004\u0000><\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@#\u0001\u0000\u0000\u0000"+
		"@9\u0001\u0000\u0000\u0000A\u0005\u0001\u0000\u0000\u0000BC\u0005\b\u0000"+
		"\u0000CD\u0005 \u0000\u0000DE\u0005\u0007\u0000\u0000E\u0007\u0001\u0000"+
		"\u0000\u0000FG\u0006\u0004\uffff\uffff\u0000GH\u0005\b\u0000\u0000HI\u0005"+
		"!\u0000\u0000I\u009b\u0003\b\u0004\u0018JK\u0005\b\u0000\u0000KV\u0005"+
		"\u001c\u0000\u0000LQ\u0003\b\u0004\u0000MN\u0005$\u0000\u0000NP\u0003"+
		"\b\u0004\u0000OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000TL\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000"+
		"\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000"+
		"\u0000\u0000XV\u0001\u0000\u0000\u0000Y\u009b\u0005\u001d\u0000\u0000"+
		"Z[\u0005\u000e\u0000\u0000[\\\u0003\b\u0004\u0000\\]\u0005\u0014\u0000"+
		"\u0000]^\u0003\b\u0004\u0000^_\u0005\u0015\u0000\u0000_`\u0003\b\u0004"+
		"\u0000`a\u0005\r\u0000\u0000a\u009b\u0001\u0000\u0000\u0000bc\u0005\u0016"+
		"\u0000\u0000cd\u0003\b\u0004\u0000de\u0005\u0012\u0000\u0000ef\u0003\b"+
		"\u0004\u0000fg\u0005\u0013\u0000\u0000g\u009b\u0001\u0000\u0000\u0000"+
		"hl\u0005\u001e\u0000\u0000ij\u0003\b\u0004\u0000jk\u0005\n\u0000\u0000"+
		"km\u0001\u0000\u0000\u0000li\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000pq\u0005\u001f\u0000\u0000q\u009b\u0001\u0000\u0000\u0000"+
		"rs\u0005\u0011\u0000\u0000st\u0005\b\u0000\u0000tu\u0005 \u0000\u0000"+
		"ux\u0005\u0007\u0000\u0000vw\u0005!\u0000\u0000wy\u0003\b\u0004\u0000"+
		"xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u0084\u0001\u0000"+
		"\u0000\u0000z{\u0005$\u0000\u0000{|\u0005\b\u0000\u0000|}\u0005 \u0000"+
		"\u0000}\u0080\u0005\u0007\u0000\u0000~\u007f\u0005!\u0000\u0000\u007f"+
		"\u0081\u0003\b\u0004\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082z\u0001"+
		"\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0088\u0005"+
		"\u000f\u0000\u0000\u0088\u009b\u0003\b\u0004\u0012\u0089\u008a\u0005\u0019"+
		"\u0000\u0000\u008a\u009b\u0005\u0007\u0000\u0000\u008b\u008c\u0005#\u0000"+
		"\u0000\u008c\u009b\u0003\b\u0004\u0010\u008d\u008e\u0005\u0010\u0000\u0000"+
		"\u008e\u009b\u0003\b\u0004\u000f\u008f\u0090\u0005\u001c\u0000\u0000\u0090"+
		"\u0091\u0003\b\u0004\u0000\u0091\u0092\u0005\u001d\u0000\u0000\u0092\u009b"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u001b\u0000\u0000\u0094\u009b"+
		"\u0003\b\u0004\u0006\u0095\u009b\u0005\t\u0000\u0000\u0096\u009b\u0005"+
		"/\u0000\u0000\u0097\u009b\u0005\u000b\u0000\u0000\u0098\u009b\u0005\f"+
		"\u0000\u0000\u0099\u009b\u0005\b\u0000\u0000\u009aF\u0001\u0000\u0000"+
		"\u0000\u009aJ\u0001\u0000\u0000\u0000\u009aZ\u0001\u0000\u0000\u0000\u009a"+
		"b\u0001\u0000\u0000\u0000\u009ah\u0001\u0000\u0000\u0000\u009ar\u0001"+
		"\u0000\u0000\u0000\u009a\u0089\u0001\u0000\u0000\u0000\u009a\u008b\u0001"+
		"\u0000\u0000\u0000\u009a\u008d\u0001\u0000\u0000\u0000\u009a\u008f\u0001"+
		"\u0000\u0000\u0000\u009a\u0093\u0001\u0000\u0000\u0000\u009a\u0095\u0001"+
		"\u0000\u0000\u0000\u009a\u0096\u0001\u0000\u0000\u0000\u009a\u0097\u0001"+
		"\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u00c9\u0001\u0000\u0000\u0000\u009c\u009d\n\r"+
		"\u0000\u0000\u009d\u009e\u0005\'\u0000\u0000\u009e\u00c8\u0003\b\u0004"+
		"\u000e\u009f\u00a0\n\f\u0000\u0000\u00a0\u00a1\u0005*\u0000\u0000\u00a1"+
		"\u00c8\u0003\b\u0004\r\u00a2\u00a3\n\u000b\u0000\u0000\u00a3\u00a4\u0005"+
		"(\u0000\u0000\u00a4\u00c8\u0003\b\u0004\f\u00a5\u00a6\n\n\u0000\u0000"+
		"\u00a6\u00a7\u0005)\u0000\u0000\u00a7\u00c8\u0003\b\u0004\u000b\u00a8"+
		"\u00a9\n\t\u0000\u0000\u00a9\u00aa\u0005,\u0000\u0000\u00aa\u00c8\u0003"+
		"\b\u0004\n\u00ab\u00ac\n\b\u0000\u0000\u00ac\u00ad\u0005+\u0000\u0000"+
		"\u00ad\u00c8\u0003\b\u0004\t\u00ae\u00af\n\u0007\u0000\u0000\u00af\u00b0"+
		"\u0005-\u0000\u0000\u00b0\u00c8\u0003\b\u0004\b\u00b1\u00b4\n\u0016\u0000"+
		"\u0000\u00b2\u00b3\u0005&\u0000\u0000\u00b3\u00b5\u0005\u0007\u0000\u0000"+
		"\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005%\u0000\u0000\u00b7"+
		"\u00b8\u0005\b\u0000\u0000\u00b8\u00c3\u0005\u001c\u0000\u0000\u00b9\u00be"+
		"\u0003\b\u0004\u0000\u00ba\u00bb\u0005$\u0000\u0000\u00bb\u00bd\u0003"+
		"\b\u0004\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000"+
		"\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c1\u00b9\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c8\u0005\u001d\u0000\u0000\u00c7\u009c\u0001\u0000"+
		"\u0000\u0000\u00c7\u009f\u0001\u0000\u0000\u0000\u00c7\u00a2\u0001\u0000"+
		"\u0000\u0000\u00c7\u00a5\u0001\u0000\u0000\u0000\u00c7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00c7\u00ab\u0001\u0000\u0000\u0000\u00c7\u00ae\u0001\u0000"+
		"\u0000\u0000\u00c7\u00b1\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000"+
		"\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ca\t\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000"+
		"\u0000\u0013\r\u0015\u001d*/>@QVnx\u0080\u0084\u009a\u00b4\u00be\u00c3"+
		"\u00c7\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}