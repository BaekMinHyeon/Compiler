// Generated from MiniGo.g4 by ANTLR 4.4
package generated;
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
			setState(43);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); var_decl();
				}
				break;
			case FUNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(42); fun_decl();
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
			setState(62);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45); dec_spec();
				setState(46); match(IDENT);
				setState(47); type_spec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49); dec_spec();
				setState(50); match(IDENT);
				setState(51); type_spec();
				setState(52); match(T__9);
				setState(53); match(LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55); dec_spec();
				setState(56); match(IDENT);
				setState(57); match(T__15);
				setState(58); match(LITERAL);
				setState(59); match(T__10);
				setState(60); type_spec();
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
			setState(64); match(VAR);
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
			setState(72);
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
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(67); match(INT);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(68); match(T__15);
				setState(69); match(LITERAL);
				setState(70); match(T__10);
				setState(71); match(INT);
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
			setState(74); match(FUNC);
			setState(75); match(IDENT);
			setState(76); match(T__5);
			setState(77); params();
			setState(78); match(T__4);
			setState(79); type_spec();
			setState(80); compound_stmt();
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
			setState(91);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); param();
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(84); match(T__1);
					setState(85); param();
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); match(IDENT);
				setState(95); type_spec();
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
			setState(103);
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
				setState(98); expr_stmt();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(99); compound_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(100); if_stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(101); for_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(102); return_stmt();
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
			setState(105); expr(0);
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
			setState(107); match(FOR);
			setState(108); expr(0);
			setState(109); stmt();
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
			setState(111); match(T__16);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(112); local_decl();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__13) | (1L << T__12) | (1L << T__7) | (1L << T__5) | (1L << T__2) | (1L << T__0) | (1L << FOR) | (1L << IF) | (1L << RETURN) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(118); stmt();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124); match(T__11);
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
			setState(126); var_decl();
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
			setState(138);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); match(IF);
				setState(129); expr(0);
				setState(130); stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132); match(IF);
				setState(133); expr(0);
				setState(134); stmt();
				setState(135); match(ELSE);
				setState(136); stmt();
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
			setState(148);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140); match(RETURN);
				setState(141); expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); match(RETURN);
				setState(143); expr(0);
				setState(144); match(T__1);
				setState(145); expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147); match(RETURN);
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
			setState(178);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(151);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__12) | (1L << T__7) | (1L << T__2) | (1L << T__0))) != 0)) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(152); expr(6);
				}
				break;
			case 2:
				{
				setState(153); match(IDENT);
				setState(154); match(T__9);
				setState(155); expr(3);
				}
				break;
			case 3:
				{
				setState(156); match(T__5);
				setState(157); expr(0);
				setState(158); match(T__4);
				}
				break;
			case 4:
				{
				setState(160); match(IDENT);
				setState(161); match(T__5);
				setState(162); args();
				setState(163); match(T__4);
				}
				break;
			case 5:
				{
				setState(165); match(IDENT);
				setState(166); match(T__15);
				setState(167); expr(0);
				setState(168); match(T__10);
				}
				break;
			case 6:
				{
				setState(170); match(IDENT);
				setState(171); match(T__15);
				setState(172); expr(0);
				setState(173); match(T__10);
				setState(174); match(T__9);
				setState(175); expr(0);
				}
				break;
			case 7:
				{
				setState(177);
				_la = _input.LA(1);
				if ( !(_la==IDENT || _la==LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(186);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(180);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(181);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__6) | (1L << T__3) | (1L << T__2) | (1L << T__0))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(182); ((ExprContext)_localctx).right = expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(184);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__8) | (1L << OR) | (1L << AND) | (1L << LE) | (1L << GE) | (1L << EQ) | (1L << NE))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(185); ((ExprContext)_localctx).right = expr(5);
						}
						break;
					}
					} 
				}
				setState(190);
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
			setState(200);
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
				setState(191); expr(0);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(192); match(T__1);
					setState(193); expr(0);
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
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
		case 0: return precpred(_ctx, 5);
		case 1: return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u00cd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\2\3\2\3\3\3\3\5\3.\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4A\n\4\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6K\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\7\bY\n\b\f\b\16\b\\\13\b\5\b^\n\b\3\t\3\t\3\t\5\tc\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\5\nj\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\7\rt\n\r\f\r"+
		"\16\rw\13\r\3\r\7\rz\n\r\f\r\16\r}\13\r\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u008d\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0097\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b5\n\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u00bd\n\21\f\21\16\21\u00c0\13\21\3\22\3\22\3\22"+
		"\7\22\u00c5\n\22\f\22\16\22\u00c8\13\22\3\22\5\22\u00cb\n\22\3\22\2\3"+
		" \23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\6\6\2\7\b\r\r\22\22\24"+
		"\24\3\2\"#\6\2\3\3\16\16\21\22\24\24\5\2\6\6\f\f\34!\u00d7\2%\3\2\2\2"+
		"\4-\3\2\2\2\6@\3\2\2\2\bB\3\2\2\2\nJ\3\2\2\2\fL\3\2\2\2\16]\3\2\2\2\20"+
		"b\3\2\2\2\22i\3\2\2\2\24k\3\2\2\2\26m\3\2\2\2\30q\3\2\2\2\32\u0080\3\2"+
		"\2\2\34\u008c\3\2\2\2\36\u0096\3\2\2\2 \u00b4\3\2\2\2\"\u00ca\3\2\2\2"+
		"$&\5\4\3\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\b\2"+
		"\1\2*\3\3\2\2\2+.\5\6\4\2,.\5\f\7\2-+\3\2\2\2-,\3\2\2\2.\5\3\2\2\2/\60"+
		"\5\b\5\2\60\61\7\"\2\2\61\62\5\n\6\2\62A\3\2\2\2\63\64\5\b\5\2\64\65\7"+
		"\"\2\2\65\66\5\n\6\2\66\67\7\13\2\2\678\7#\2\28A\3\2\2\29:\5\b\5\2:;\7"+
		"\"\2\2;<\7\5\2\2<=\7#\2\2=>\7\n\2\2>?\5\n\6\2?A\3\2\2\2@/\3\2\2\2@\63"+
		"\3\2\2\2@9\3\2\2\2A\7\3\2\2\2BC\7\25\2\2C\t\3\2\2\2DK\3\2\2\2EK\7\27\2"+
		"\2FG\7\5\2\2GH\7#\2\2HI\7\n\2\2IK\7\27\2\2JD\3\2\2\2JE\3\2\2\2JF\3\2\2"+
		"\2K\13\3\2\2\2LM\7\26\2\2MN\7\"\2\2NO\7\17\2\2OP\5\16\b\2PQ\7\20\2\2Q"+
		"R\5\n\6\2RS\5\30\r\2S\r\3\2\2\2T^\3\2\2\2UZ\5\20\t\2VW\7\23\2\2WY\5\20"+
		"\t\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2]T\3"+
		"\2\2\2]U\3\2\2\2^\17\3\2\2\2_c\7\"\2\2`a\7\"\2\2ac\5\n\6\2b_\3\2\2\2b"+
		"`\3\2\2\2c\21\3\2\2\2dj\5\24\13\2ej\5\30\r\2fj\5\34\17\2gj\5\26\f\2hj"+
		"\5\36\20\2id\3\2\2\2ie\3\2\2\2if\3\2\2\2ig\3\2\2\2ih\3\2\2\2j\23\3\2\2"+
		"\2kl\5 \21\2l\25\3\2\2\2mn\7\30\2\2no\5 \21\2op\5\22\n\2p\27\3\2\2\2q"+
		"u\7\4\2\2rt\5\32\16\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v{\3\2\2"+
		"\2wu\3\2\2\2xz\5\22\n\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2"+
		"\2\2}{\3\2\2\2~\177\7\t\2\2\177\31\3\2\2\2\u0080\u0081\5\6\4\2\u0081\33"+
		"\3\2\2\2\u0082\u0083\7\31\2\2\u0083\u0084\5 \21\2\u0084\u0085\5\22\n\2"+
		"\u0085\u008d\3\2\2\2\u0086\u0087\7\31\2\2\u0087\u0088\5 \21\2\u0088\u0089"+
		"\5\22\n\2\u0089\u008a\7\32\2\2\u008a\u008b\5\22\n\2\u008b\u008d\3\2\2"+
		"\2\u008c\u0082\3\2\2\2\u008c\u0086\3\2\2\2\u008d\35\3\2\2\2\u008e\u008f"+
		"\7\33\2\2\u008f\u0097\5 \21\2\u0090\u0091\7\33\2\2\u0091\u0092\5 \21\2"+
		"\u0092\u0093\7\23\2\2\u0093\u0094\5 \21\2\u0094\u0097\3\2\2\2\u0095\u0097"+
		"\7\33\2\2\u0096\u008e\3\2\2\2\u0096\u0090\3\2\2\2\u0096\u0095\3\2\2\2"+
		"\u0097\37\3\2\2\2\u0098\u0099\b\21\1\2\u0099\u009a\t\2\2\2\u009a\u00b5"+
		"\5 \21\b\u009b\u009c\7\"\2\2\u009c\u009d\7\13\2\2\u009d\u00b5\5 \21\5"+
		"\u009e\u009f\7\17\2\2\u009f\u00a0\5 \21\2\u00a0\u00a1\7\20\2\2\u00a1\u00b5"+
		"\3\2\2\2\u00a2\u00a3\7\"\2\2\u00a3\u00a4\7\17\2\2\u00a4\u00a5\5\"\22\2"+
		"\u00a5\u00a6\7\20\2\2\u00a6\u00b5\3\2\2\2\u00a7\u00a8\7\"\2\2\u00a8\u00a9"+
		"\7\5\2\2\u00a9\u00aa\5 \21\2\u00aa\u00ab\7\n\2\2\u00ab\u00b5\3\2\2\2\u00ac"+
		"\u00ad\7\"\2\2\u00ad\u00ae\7\5\2\2\u00ae\u00af\5 \21\2\u00af\u00b0\7\n"+
		"\2\2\u00b0\u00b1\7\13\2\2\u00b1\u00b2\5 \21\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b5\t\3\2\2\u00b4\u0098\3\2\2\2\u00b4\u009b\3\2\2\2\u00b4\u009e\3\2"+
		"\2\2\u00b4\u00a2\3\2\2\2\u00b4\u00a7\3\2\2\2\u00b4\u00ac\3\2\2\2\u00b4"+
		"\u00b3\3\2\2\2\u00b5\u00be\3\2\2\2\u00b6\u00b7\f\7\2\2\u00b7\u00b8\t\4"+
		"\2\2\u00b8\u00bd\5 \21\b\u00b9\u00ba\f\6\2\2\u00ba\u00bb\t\5\2\2\u00bb"+
		"\u00bd\5 \21\7\u00bc\u00b6\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bd\u00c0\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf!\3\2\2\2\u00c0\u00be"+
		"\3\2\2\2\u00c1\u00c6\5 \21\2\u00c2\u00c3\7\23\2\2\u00c3\u00c5\5 \21\2"+
		"\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\u00cb\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca"+
		"\u00c1\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb#\3\2\2\2\23\'-@JZ]biu{\u008c"+
		"\u0096\u00b4\u00bc\u00be\u00c6\u00ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}