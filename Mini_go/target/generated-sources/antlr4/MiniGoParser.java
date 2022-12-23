// Generated from MiniGo.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniGoParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__17=1, T__16=2, T__15=3, T__14=4, T__13=5, T__12=6, T__11=7, T__10=8, 
		T__9=9, T__8=10, T__7=11, T__6=12, T__5=13, T__4=14, T__3=15, T__2=16, 
		T__1=17, T__0=18, VAR=19, FUNC=20, INT=21, FOR=22, IF=23, ELSE=24, RETURN=25, 
		OR=26, AND=27, LE=28, GE=29, EQ=30, NE=31, IDENT=32, LITERAL=33, DecimalConstant=34, 
		OctalConstant=35, HexadecimalConstant=36, NilConstant=37, WildCardConstant=38, 
		WS=39;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'{'", "'['", "'<'", "'++'", "'--'", "'}'", "']'", 
		"'='", "'>'", "'!'", "'%'", "'('", "')'", "'*'", "'+'", "','", "'-'", 
		"'var'", "'func'", "'int'", "'for'", "'if'", "'else'", "'return'", "'or'", 
		"'and'", "'<='", "'>='", "'=='", "'!='", "IDENT", "LITERAL", "DecimalConstant", 
		"OctalConstant", "HexadecimalConstant", "NilConstant", "'_'", "WS"
	};
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_dec_spec = 3, 
		RULE_type_spec = 4, RULE_fun_decl = 5, RULE_params = 6, RULE_param = 7, 
		RULE_stmt = 8, RULE_expr_stmt = 9, RULE_for_stmt = 10, RULE_compound_stmt = 11, 
		RULE_local_decl = 12, RULE_if_stmt = 13, RULE_return_stmt = 14, RULE_expr = 15, 
		RULE_args = 16;
	public static final String[] ruleNames = {
		"program", "decl", "var_decl", "dec_spec", "type_spec", "fun_decl", "params", 
		"param", "stmt", "expr_stmt", "for_stmt", "compound_stmt", "local_decl", 
		"if_stmt", "return_stmt", "expr", "args"
	};

	@Override
	public String getGrammarFileName() { return "MiniGo.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniGoParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34); decl();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR || _la==FUNC );
			System.out.println("201802101 Rule 0");
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

	public static class DeclContext extends ParserRuleContext {
		public Fun_declContext fun_decl() {
			return getRuleContext(Fun_declContext.class,0);
		}
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(47);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); var_decl();
				System.out.println("201802101 Rule 1-1");
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(44); fun_decl();
				System.out.println("201802101 Rule 1-2");
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

	public static class Var_declContext extends ParserRuleContext {
		public Dec_specContext dec_spec() {
			return getRuleContext(Dec_specContext.class,0);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(MiniGoParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49); dec_spec();
				setState(50); match(IDENT);
				setState(51); type_spec();
				System.out.println("201802101 Rule 2-1");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54); dec_spec();
				setState(55); match(IDENT);
				setState(56); type_spec();
				setState(57); match(T__9);
				setState(58); match(LITERAL);
				System.out.println("201802101 Rule 2-2");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61); dec_spec();
				setState(62); match(IDENT);
				setState(63); match(T__15);
				setState(64); match(LITERAL);
				setState(65); match(T__10);
				setState(66); type_spec();
				System.out.println("201802101 Rule 2-3");
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

	public static class Dec_specContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MiniGoParser.VAR, 0); }
		public Dec_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterDec_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitDec_spec(this);
		}
	}

	public final Dec_specContext dec_spec() throws RecognitionException {
		Dec_specContext _localctx = new Dec_specContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dec_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); match(VAR);
			System.out.println("201802101 Rule 3");
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

	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniGoParser.INT, 0); }
		public TerminalNode LITERAL() { return getToken(MiniGoParser.LITERAL, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitType_spec(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type_spec);
		try {
			setState(82);
			switch (_input.LA(1)) {
			case EOF:
			case T__16:
			case T__13:
			case T__12:
			case T__11:
			case T__9:
			case T__7:
			case T__5:
			case T__4:
			case T__2:
			case T__1:
			case T__0:
			case VAR:
			case FUNC:
			case FOR:
			case IF:
			case RETURN:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				System.out.println("201802101 Rule 4-1");
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(75); match(INT);
				System.out.println("201802101 Rule 4-2");
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(77); match(T__15);
				setState(78); match(LITERAL);
				setState(79); match(T__10);
				setState(80); match(INT);
				System.out.println("201802101 Rule 4-3");
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

	public static class Fun_declContext extends ParserRuleContext {
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode FUNC() { return getToken(MiniGoParser.FUNC, 0); }
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Fun_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterFun_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitFun_decl(this);
		}
	}

	public final Fun_declContext fun_decl() throws RecognitionException {
		Fun_declContext _localctx = new Fun_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fun_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); match(FUNC);
			setState(85); match(IDENT);
			setState(86); match(T__5);
			setState(87); params();
			setState(88); match(T__4);
			setState(89); type_spec();
			setState(90); compound_stmt();
			System.out.println("201802101 Rule 5");
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_params);
		int _la;
		try {
			setState(104);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				System.out.println("201802101 Rule 6-1");
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); param();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(95); match(T__1);
					setState(96); param();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				System.out.println("201802101 Rule 6-2");
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

	public static class ParamContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_param);
		try {
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106); match(IDENT);
				System.out.println("201802101 Rule 7-1");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108); match(IDENT);
				setState(109); type_spec();
				System.out.println("201802101 Rule 7-2");
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

	public static class StmtContext extends ParserRuleContext {
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		try {
			setState(129);
			switch (_input.LA(1)) {
			case T__13:
			case T__12:
			case T__7:
			case T__5:
			case T__2:
			case T__0:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(114); expr_stmt();
				System.out.println("201802101 Rule 8-1");
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(117); compound_stmt();
				System.out.println("201802101 Rule 8-2");
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(120); if_stmt();
				System.out.println("201802101 Rule 8-3");
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(123); for_stmt();
				System.out.println("201802101 Rule 8-4");
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(126); return_stmt();
				System.out.println("201802101 Rule 8-5");
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

	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitExpr_stmt(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); expr(0);
			System.out.println("201802101 Rule 9");
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

	public static class For_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FOR() { return getToken(MiniGoParser.FOR, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitFor_stmt(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(FOR);
			setState(135); expr(0);
			setState(136); stmt();
			System.out.println("201802101 Rule 10");
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

	public static class Compound_stmtContext extends ParserRuleContext {
		public List<Local_declContext> local_decl() {
			return getRuleContexts(Local_declContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public Local_declContext local_decl(int i) {
			return getRuleContext(Local_declContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitCompound_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_compound_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(T__16);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(140); local_decl();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__13) | (1L << T__12) | (1L << T__7) | (1L << T__5) | (1L << T__2) | (1L << T__0) | (1L << FOR) | (1L << IF) | (1L << RETURN) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(146); stmt();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152); match(T__11);
			System.out.println("201802101 Rule 11");
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

	public static class Local_declContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Local_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterLocal_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitLocal_decl(this);
		}
	}

	public final Local_declContext local_decl() throws RecognitionException {
		Local_declContext _localctx = new Local_declContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_local_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); var_decl();
			System.out.println("201802101 Rule 12");
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

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MiniGoParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(MiniGoParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_if_stmt);
		try {
			setState(170);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158); match(IF);
				setState(159); expr(0);
				setState(160); stmt();
				System.out.println("201802101 Rule 13-1");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163); match(IF);
				setState(164); expr(0);
				setState(165); stmt();
				setState(166); match(ELSE);
				setState(167); stmt();
				System.out.println("201802101 Rule 13-2");
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

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniGoParser.RETURN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_return_stmt);
		try {
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172); match(RETURN);
				System.out.println("201802101 Rule 14-1");
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174); match(RETURN);
				setState(175); expr(0);
				System.out.println("201802101 Rule 14-2");
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178); match(RETURN);
				setState(179); expr(0);
				setState(180); match(T__1);
				setState(181); expr(0);
				System.out.println("201802101 Rule 14-3");
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public TerminalNode GE() { return getToken(MiniGoParser.GE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LE() { return getToken(MiniGoParser.LE, 0); }
		public TerminalNode AND() { return getToken(MiniGoParser.AND, 0); }
		public TerminalNode EQ() { return getToken(MiniGoParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MiniGoParser.NE, 0); }
		public TerminalNode OR() { return getToken(MiniGoParser.OR, 0); }
		public TerminalNode LITERAL() { return getToken(MiniGoParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniGoParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitExpr(this);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(187);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__12) | (1L << T__7) | (1L << T__2) | (1L << T__0))) != 0)) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(188); expr(5);
				System.out.println("201802101 Rule 15-5");
				}
				break;
			case 2:
				{
				setState(191); match(IDENT);
				setState(192); match(T__9);
				setState(193); expr(2);
				System.out.println("201802101 Rule 15-8");
				}
				break;
			case 3:
				{
				setState(196);
				_la = _input.LA(1);
				if ( !(_la==IDENT || _la==LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				System.out.println("201802101 Rule 15-1");
				}
				break;
			case 4:
				{
				setState(198); match(T__5);
				setState(199); expr(0);
				setState(200); match(T__4);
				System.out.println("201802101 Rule 15-2");
				}
				break;
			case 5:
				{
				setState(203); match(IDENT);
				setState(204); match(T__15);
				setState(205); expr(0);
				setState(206); match(T__10);
				System.out.println("201802101 Rule 15-3");
				}
				break;
			case 6:
				{
				setState(209); match(IDENT);
				setState(210); match(T__5);
				setState(211); args();
				setState(212); match(T__4);
				System.out.println("201802101 Rule 15-4");
				}
				break;
			case 7:
				{
				setState(215); match(IDENT);
				setState(216); match(T__15);
				setState(217); expr(0);
				setState(218); match(T__10);
				setState(219); match(T__9);
				setState(220); expr(0);
				System.out.println("201802101 Rule 15-9");
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(235);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(226);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__6) | (1L << T__3) | (1L << T__2) | (1L << T__0))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(227); ((ExprContext)_localctx).right = expr(5);
						System.out.println("201802101 Rule 15-6");
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(231);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__8) | (1L << OR) | (1L << AND) | (1L << LE) | (1L << GE) | (1L << EQ) | (1L << NE))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(232); ((ExprContext)_localctx).right = expr(4);
						System.out.println("201802101 Rule 15-7");
						}
						break;
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniGoListener ) ((MiniGoListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_args);
		int _la;
		try {
			setState(251);
			switch (_input.LA(1)) {
			case T__13:
			case T__12:
			case T__7:
			case T__5:
			case T__2:
			case T__0:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(240); expr(0);
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(241); match(T__1);
					setState(242); expr(0);
					}
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				System.out.println("201802101 Rule 16-1");
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				System.out.println("201802101 Rule 16-2");
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);
		case 1: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u0100\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\62\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4H\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6U\n\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bd\n\b\f\b\16\b"+
		"g\13\b\3\b\3\b\5\bk\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\ts\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0084\n\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\r\u0090\n\r\f\r\16\r\u0093\13\r\3"+
		"\r\7\r\u0096\n\r\f\r\16\r\u0099\13\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ad\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00bb"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e2\n\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00ee\n\21\f\21\16"+
		"\21\u00f1\13\21\3\22\3\22\3\22\7\22\u00f6\n\22\f\22\16\22\u00f9\13\22"+
		"\3\22\3\22\3\22\5\22\u00fe\n\22\3\22\2\3 \23\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"\2\6\6\2\7\b\r\r\22\22\24\24\3\2\"#\6\2\3\3\16\16\21\22"+
		"\24\24\5\2\6\6\f\f\34!\u010a\2%\3\2\2\2\4\61\3\2\2\2\6G\3\2\2\2\bI\3\2"+
		"\2\2\nT\3\2\2\2\fV\3\2\2\2\16j\3\2\2\2\20r\3\2\2\2\22\u0083\3\2\2\2\24"+
		"\u0085\3\2\2\2\26\u0088\3\2\2\2\30\u008d\3\2\2\2\32\u009d\3\2\2\2\34\u00ac"+
		"\3\2\2\2\36\u00ba\3\2\2\2 \u00e1\3\2\2\2\"\u00fd\3\2\2\2$&\5\4\3\2%$\3"+
		"\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\b\2\1\2*\3\3\2\2\2"+
		"+,\5\6\4\2,-\b\3\1\2-\62\3\2\2\2./\5\f\7\2/\60\b\3\1\2\60\62\3\2\2\2\61"+
		"+\3\2\2\2\61.\3\2\2\2\62\5\3\2\2\2\63\64\5\b\5\2\64\65\7\"\2\2\65\66\5"+
		"\n\6\2\66\67\b\4\1\2\67H\3\2\2\289\5\b\5\29:\7\"\2\2:;\5\n\6\2;<\7\13"+
		"\2\2<=\7#\2\2=>\b\4\1\2>H\3\2\2\2?@\5\b\5\2@A\7\"\2\2AB\7\5\2\2BC\7#\2"+
		"\2CD\7\n\2\2DE\5\n\6\2EF\b\4\1\2FH\3\2\2\2G\63\3\2\2\2G8\3\2\2\2G?\3\2"+
		"\2\2H\7\3\2\2\2IJ\7\25\2\2JK\b\5\1\2K\t\3\2\2\2LU\b\6\1\2MN\7\27\2\2N"+
		"U\b\6\1\2OP\7\5\2\2PQ\7#\2\2QR\7\n\2\2RS\7\27\2\2SU\b\6\1\2TL\3\2\2\2"+
		"TM\3\2\2\2TO\3\2\2\2U\13\3\2\2\2VW\7\26\2\2WX\7\"\2\2XY\7\17\2\2YZ\5\16"+
		"\b\2Z[\7\20\2\2[\\\5\n\6\2\\]\5\30\r\2]^\b\7\1\2^\r\3\2\2\2_k\b\b\1\2"+
		"`e\5\20\t\2ab\7\23\2\2bd\5\20\t\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2"+
		"\2\2fh\3\2\2\2ge\3\2\2\2hi\b\b\1\2ik\3\2\2\2j_\3\2\2\2j`\3\2\2\2k\17\3"+
		"\2\2\2lm\7\"\2\2ms\b\t\1\2no\7\"\2\2op\5\n\6\2pq\b\t\1\2qs\3\2\2\2rl\3"+
		"\2\2\2rn\3\2\2\2s\21\3\2\2\2tu\5\24\13\2uv\b\n\1\2v\u0084\3\2\2\2wx\5"+
		"\30\r\2xy\b\n\1\2y\u0084\3\2\2\2z{\5\34\17\2{|\b\n\1\2|\u0084\3\2\2\2"+
		"}~\5\26\f\2~\177\b\n\1\2\177\u0084\3\2\2\2\u0080\u0081\5\36\20\2\u0081"+
		"\u0082\b\n\1\2\u0082\u0084\3\2\2\2\u0083t\3\2\2\2\u0083w\3\2\2\2\u0083"+
		"z\3\2\2\2\u0083}\3\2\2\2\u0083\u0080\3\2\2\2\u0084\23\3\2\2\2\u0085\u0086"+
		"\5 \21\2\u0086\u0087\b\13\1\2\u0087\25\3\2\2\2\u0088\u0089\7\30\2\2\u0089"+
		"\u008a\5 \21\2\u008a\u008b\5\22\n\2\u008b\u008c\b\f\1\2\u008c\27\3\2\2"+
		"\2\u008d\u0091\7\4\2\2\u008e\u0090\5\32\16\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0097\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0096\5\22\n\2\u0095\u0094\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\t\2\2\u009b\u009c\b\r\1\2\u009c"+
		"\31\3\2\2\2\u009d\u009e\5\6\4\2\u009e\u009f\b\16\1\2\u009f\33\3\2\2\2"+
		"\u00a0\u00a1\7\31\2\2\u00a1\u00a2\5 \21\2\u00a2\u00a3\5\22\n\2\u00a3\u00a4"+
		"\b\17\1\2\u00a4\u00ad\3\2\2\2\u00a5\u00a6\7\31\2\2\u00a6\u00a7\5 \21\2"+
		"\u00a7\u00a8\5\22\n\2\u00a8\u00a9\7\32\2\2\u00a9\u00aa\5\22\n\2\u00aa"+
		"\u00ab\b\17\1\2\u00ab\u00ad\3\2\2\2\u00ac\u00a0\3\2\2\2\u00ac\u00a5\3"+
		"\2\2\2\u00ad\35\3\2\2\2\u00ae\u00af\7\33\2\2\u00af\u00bb\b\20\1\2\u00b0"+
		"\u00b1\7\33\2\2\u00b1\u00b2\5 \21\2\u00b2\u00b3\b\20\1\2\u00b3\u00bb\3"+
		"\2\2\2\u00b4\u00b5\7\33\2\2\u00b5\u00b6\5 \21\2\u00b6\u00b7\7\23\2\2\u00b7"+
		"\u00b8\5 \21\2\u00b8\u00b9\b\20\1\2\u00b9\u00bb\3\2\2\2\u00ba\u00ae\3"+
		"\2\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00b4\3\2\2\2\u00bb\37\3\2\2\2\u00bc"+
		"\u00bd\b\21\1\2\u00bd\u00be\t\2\2\2\u00be\u00bf\5 \21\7\u00bf\u00c0\b"+
		"\21\1\2\u00c0\u00e2\3\2\2\2\u00c1\u00c2\7\"\2\2\u00c2\u00c3\7\13\2\2\u00c3"+
		"\u00c4\5 \21\4\u00c4\u00c5\b\21\1\2\u00c5\u00e2\3\2\2\2\u00c6\u00c7\t"+
		"\3\2\2\u00c7\u00e2\b\21\1\2\u00c8\u00c9\7\17\2\2\u00c9\u00ca\5 \21\2\u00ca"+
		"\u00cb\7\20\2\2\u00cb\u00cc\b\21\1\2\u00cc\u00e2\3\2\2\2\u00cd\u00ce\7"+
		"\"\2\2\u00ce\u00cf\7\5\2\2\u00cf\u00d0\5 \21\2\u00d0\u00d1\7\n\2\2\u00d1"+
		"\u00d2\b\21\1\2\u00d2\u00e2\3\2\2\2\u00d3\u00d4\7\"\2\2\u00d4\u00d5\7"+
		"\17\2\2\u00d5\u00d6\5\"\22\2\u00d6\u00d7\7\20\2\2\u00d7\u00d8\b\21\1\2"+
		"\u00d8\u00e2\3\2\2\2\u00d9\u00da\7\"\2\2\u00da\u00db\7\5\2\2\u00db\u00dc"+
		"\5 \21\2\u00dc\u00dd\7\n\2\2\u00dd\u00de\7\13\2\2\u00de\u00df\5 \21\2"+
		"\u00df\u00e0\b\21\1\2\u00e0\u00e2\3\2\2\2\u00e1\u00bc\3\2\2\2\u00e1\u00c1"+
		"\3\2\2\2\u00e1\u00c6\3\2\2\2\u00e1\u00c8\3\2\2\2\u00e1\u00cd\3\2\2\2\u00e1"+
		"\u00d3\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e2\u00ef\3\2\2\2\u00e3\u00e4\f\6"+
		"\2\2\u00e4\u00e5\t\4\2\2\u00e5\u00e6\5 \21\7\u00e6\u00e7\b\21\1\2\u00e7"+
		"\u00ee\3\2\2\2\u00e8\u00e9\f\5\2\2\u00e9\u00ea\t\5\2\2\u00ea\u00eb\5 "+
		"\21\6\u00eb\u00ec\b\21\1\2\u00ec\u00ee\3\2\2\2\u00ed\u00e3\3\2\2\2\u00ed"+
		"\u00e8\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0!\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f7\5 \21\2\u00f3\u00f4"+
		"\7\23\2\2\u00f4\u00f6\5 \21\2\u00f5\u00f3\3\2\2\2\u00f6\u00f9\3\2\2\2"+
		"\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7"+
		"\3\2\2\2\u00fa\u00fb\b\22\1\2\u00fb\u00fe\3\2\2\2\u00fc\u00fe\b\22\1\2"+
		"\u00fd\u00f2\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe#\3\2\2\2\23\'\61GTejr\u0083"+
		"\u0091\u0097\u00ac\u00ba\u00e1\u00ed\u00ef\u00f7\u00fd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}