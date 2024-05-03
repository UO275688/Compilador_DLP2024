// Generated from C:/Users/mikel/OneDrive - Universidad de Oviedo/Documentos/UNIOVI/5 QUINTO/DLP/dlp/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;

    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.expressions.literals.*;
    import ast.expressions.operators.*;
    import ast.expressions.unary.*;
    import ast.statements.*;
    import ast.types.*;
    import parser.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, IGNORE=37, ONE_LINE_COMMENT=38, 
		MULTIPLE_LINE_COMMENT=39, REAL_CONSTANT=40, INT_CONSTANT=41, CHAR_CONSTANT=42, 
		ID=43;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_statements = 2, RULE_consoleInOuts = 3, 
		RULE_listExpressions = 4, RULE_functionInvocation = 5, RULE_block = 6, 
		RULE_type = 7, RULE_builtInType = 8, RULE_void = 9, RULE_struct = 10, 
		RULE_recordFields = 11, RULE_functionReturnType = 12, RULE_params = 13, 
		RULE_mainDefinition = 14, RULE_definitions = 15, RULE_funcDefinition = 16, 
		RULE_funcBody = 17, RULE_varDefinitions = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "statements", "consoleInOuts", "listExpressions", 
			"functionInvocation", "block", "type", "builtInType", "void", "struct", 
			"recordFields", "functionReturnType", "params", "mainDefinition", "definitions", 
			"funcDefinition", "funcBody", "varDefinitions"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'.'", "'-'", "'!'", "'*'", "'/'", 
			"'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", 
			"'while'", "'='", "';'", "'return'", "'if'", "'else'", "'read'", "'write'", 
			"','", "'{'", "'}'", "'int'", "'double'", "'char'", "'void'", "'struct'", 
			"'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "IGNORE", "ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENT", "REAL_CONSTANT", 
			"INT_CONSTANT", "CHAR_CONSTANT", "ID"
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
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> def = new ArrayList<Definition>();
		public DefinitionsContext d;
		public MainDefinitionContext md;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public MainDefinitionContext mainDefinition() {
			return getRuleContext(MainDefinitionContext.class,0);
		}
		public List<DefinitionsContext> definitions() {
			return getRuleContexts(DefinitionsContext.class);
		}
		public DefinitionsContext definitions(int i) {
			return getRuleContext(DefinitionsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					((ProgramContext)_localctx).d = definitions();
					_localctx.def.addAll(((ProgramContext)_localctx).d.ast);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(46);
			((ProgramContext)_localctx).md = mainDefinition();
			_localctx.def.add(((ProgramContext)_localctx).md.ast);
			setState(48);
			match(EOF);
			((ProgramContext)_localctx).ast =  new Program(((ProgramContext)_localctx).md.ast.getLine(), ((ProgramContext)_localctx).md.ast.getColumn(), _localctx.def);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public ExpressionContext e;
		public Token RC;
		public Token IC;
		public Token CC;
		public Token ID;
		public ExpressionContext expression;
		public FunctionInvocationContext f;
		public BuiltInTypeContext t;
		public Token OP;
		public ExpressionContext e2;
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(52);
				((ExpressionContext)_localctx).RC = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).RC.getLine(), ((ExpressionContext)_localctx).RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).RC!=null?((ExpressionContext)_localctx).RC.getText():null)));
				}
				break;
			case 2:
				{
				setState(54);
				((ExpressionContext)_localctx).IC = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).IC.getLine(), ((ExpressionContext)_localctx).IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).IC!=null?((ExpressionContext)_localctx).IC.getText():null))); 
				}
				break;
			case 3:
				{
				setState(56);
				((ExpressionContext)_localctx).CC = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CC.getLine(), ((ExpressionContext)_localctx).CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CC!=null?((ExpressionContext)_localctx).CC.getText():null))); 
				}
				break;
			case 4:
				{
				setState(58);
				((ExpressionContext)_localctx).ID = match(ID);
				((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
				}
				break;
			case 5:
				{
				setState(60);
				match(T__0);
				setState(61);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(62);
				match(T__1);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast;
				}
				break;
			case 6:
				{
				setState(65);
				((ExpressionContext)_localctx).f = functionInvocation();
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).f.ast;
				}
				break;
			case 7:
				{
				setState(68);
				match(T__0);
				setState(69);
				((ExpressionContext)_localctx).t = builtInType();
				setState(70);
				match(T__1);
				setState(71);
				((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(7);
				((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).t.ast, ((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 8:
				{
				setState(74);
				match(T__5);
				setState(75);
				((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(6);
				((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 9:
				{
				setState(78);
				match(T__6);
				setState(79);
				((ExpressionContext)_localctx).e = ((ExpressionContext)_localctx).expression = expression(5);
				((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).e.ast);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(84);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(85);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(86);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(5);
						 if((((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null).equals("%"))
						                          ((ExpressionContext)_localctx).ast =  new Modulus(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						                      else
						                          ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null));
						                      
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(89);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(90);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__10) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(91);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(4);
						((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null));
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(94);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(95);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 258048L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(96);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(3);
						((ExpressionContext)_localctx).ast =  new Comparator(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null));
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(100);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(101);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(2);
						((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null));
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(105);
						match(T__2);
						setState(106);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(107);
						match(T__3);
						((ExpressionContext)_localctx).ast =  new Indexing(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(111);
						match(T__4);
						setState(112);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).e.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						}
						break;
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public ExpressionContext e;
		public BlockContext b;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public ConsoleInOutsContext c;
		public FunctionInvocationContext fi;
		public BlockContext b1;
		public BlockContext b2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ConsoleInOutsContext consoleInOuts() {
			return getRuleContext(ConsoleInOutsContext.class,0);
		}
		public FunctionInvocationContext functionInvocation() {
			return getRuleContext(FunctionInvocationContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(T__19);
				setState(120);
				match(T__0);
				setState(121);
				((StatementsContext)_localctx).e = expression(0);
				setState(122);
				match(T__1);
				setState(123);
				((StatementsContext)_localctx).b = block();
				_localctx.ast.add(new While(((StatementsContext)_localctx).e.ast.getLine(), ((StatementsContext)_localctx).e.ast.getColumn(), ((StatementsContext)_localctx).e.ast, ((StatementsContext)_localctx).b.ast));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				((StatementsContext)_localctx).e1 = expression(0);
				setState(127);
				match(T__20);
				setState(128);
				((StatementsContext)_localctx).e2 = expression(0);
				setState(129);
				match(T__21);
				_localctx.ast.add(new Assignment(((StatementsContext)_localctx).e1.ast.getLine(), ((StatementsContext)_localctx).e1.ast.getColumn(), ((StatementsContext)_localctx).e1.ast, ((StatementsContext)_localctx).e2.ast));
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				((StatementsContext)_localctx).c = consoleInOuts();
				((StatementsContext)_localctx).c.ast.forEach(s -> _localctx.ast.add(s));
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				((StatementsContext)_localctx).fi = functionInvocation();
				setState(136);
				match(T__21);
				_localctx.ast.add(((StatementsContext)_localctx).fi.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(139);
				match(T__22);
				setState(140);
				((StatementsContext)_localctx).e = expression(0);
				setState(141);
				match(T__21);
				_localctx.ast.add(new Return(((StatementsContext)_localctx).e.ast.getLine(), ((StatementsContext)_localctx).e.ast.getColumn(), ((StatementsContext)_localctx).e.ast));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(144);
				match(T__23);
				setState(145);
				match(T__0);
				setState(146);
				((StatementsContext)_localctx).e = expression(0);
				setState(147);
				match(T__1);
				setState(148);
				((StatementsContext)_localctx).b1 = block();
				_localctx.ast.add(new IfElseStatement(((StatementsContext)_localctx).e.ast.getLine(), ((StatementsContext)_localctx).e.ast.getColumn(), ((StatementsContext)_localctx).e.ast, ((StatementsContext)_localctx).b1.ast));
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(151);
				match(T__23);
				setState(152);
				match(T__0);
				setState(153);
				((StatementsContext)_localctx).e = expression(0);
				setState(154);
				match(T__1);
				setState(155);
				((StatementsContext)_localctx).b1 = block();
				setState(156);
				match(T__24);
				setState(157);
				((StatementsContext)_localctx).b2 = block();
				_localctx.ast.add(new IfElseStatement(((StatementsContext)_localctx).e.ast.getLine(), ((StatementsContext)_localctx).e.ast.getColumn(), ((StatementsContext)_localctx).e.ast, ((StatementsContext)_localctx).b1.ast, ((StatementsContext)_localctx).b2.ast));
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConsoleInOutsContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public Token R;
		public ListExpressionsContext le;
		public Token W;
		public ListExpressionsContext listExpressions() {
			return getRuleContext(ListExpressionsContext.class,0);
		}
		public ConsoleInOutsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consoleInOuts; }
	}

	public final ConsoleInOutsContext consoleInOuts() throws RecognitionException {
		ConsoleInOutsContext _localctx = new ConsoleInOutsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_consoleInOuts);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				((ConsoleInOutsContext)_localctx).R = match(T__25);
				setState(163);
				((ConsoleInOutsContext)_localctx).le = listExpressions();
				setState(164);
				match(T__21);
				((ConsoleInOutsContext)_localctx).le.ast.forEach(e -> _localctx.ast.add(new Read(((ConsoleInOutsContext)_localctx).R.getLine(), ((ConsoleInOutsContext)_localctx).R.getCharPositionInLine()+1, e)));
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				((ConsoleInOutsContext)_localctx).W = match(T__26);
				setState(168);
				((ConsoleInOutsContext)_localctx).le = listExpressions();
				setState(169);
				match(T__21);
				((ConsoleInOutsContext)_localctx).le.ast.forEach(e -> _localctx.ast.add(new Write(((ConsoleInOutsContext)_localctx).W.getLine(), ((ConsoleInOutsContext)_localctx).W.getCharPositionInLine()+1, e)));
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listExpressions; }
	}

	public final ListExpressionsContext listExpressions() throws RecognitionException {
		ListExpressionsContext _localctx = new ListExpressionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listExpressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			((ListExpressionsContext)_localctx).e1 = expression(0);
			_localctx.ast.add(((ListExpressionsContext)_localctx).e1.ast);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27) {
				{
				{
				setState(176);
				match(T__27);
				setState(177);
				((ListExpressionsContext)_localctx).e2 = expression(0);
				_localctx.ast.add(((ListExpressionsContext)_localctx).e2.ast);
				}
				}
				setState(184);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionInvocationContext extends ParserRuleContext {
		public FuncInvocation ast;
		public List<Expression> expressions = new ArrayList<Expression>();
		public Token ID;
		public ListExpressionsContext le;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ListExpressionsContext listExpressions() {
			return getRuleContext(ListExpressionsContext.class,0);
		}
		public FunctionInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvocation; }
	}

	public final FunctionInvocationContext functionInvocation() throws RecognitionException {
		FunctionInvocationContext _localctx = new FunctionInvocationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			((FunctionInvocationContext)_localctx).ID = match(ID);
			setState(186);
			match(T__0);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492674416834L) != 0)) {
				{
				setState(187);
				((FunctionInvocationContext)_localctx).le = listExpressions();
				_localctx.expressions.addAll(((FunctionInvocationContext)_localctx).le.ast);
				}
			}

			setState(192);
			match(T__1);
			((FunctionInvocationContext)_localctx).ast =  new FuncInvocation(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1, new Variable(((FunctionInvocationContext)_localctx).ID.getLine(), ((FunctionInvocationContext)_localctx).ID.getCharPositionInLine()+1, (((FunctionInvocationContext)_localctx).ID!=null?((FunctionInvocationContext)_localctx).ID.getText():null)), _localctx.expressions);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementsContext s1;
		public StatementsContext s2;
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__5:
			case T__6:
			case T__19:
			case T__22:
			case T__23:
			case T__25:
			case T__26:
			case REAL_CONSTANT:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				((BlockContext)_localctx).s1 = statements();
				((BlockContext)_localctx).s1.ast.forEach(s -> _localctx.ast.add(s));
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(T__28);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492901957826L) != 0)) {
					{
					{
					setState(199);
					((BlockContext)_localctx).s2 = statements();
					((BlockContext)_localctx).s2.ast.forEach(s -> _localctx.ast.add(s));
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(207);
				match(T__29);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public ArrayType secondArray;
		public TypeContext t;
		public BuiltInTypeContext bt;
		public StructContext s;
		public Token IC;
		public Token IC2;
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> INT_CONSTANT() { return getTokens(CmmParser.INT_CONSTANT); }
		public TerminalNode INT_CONSTANT(int i) {
			return getToken(CmmParser.INT_CONSTANT, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
			case T__31:
			case T__32:
				{
				setState(211);
				((TypeContext)_localctx).bt = builtInType();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).bt.ast;
				}
				break;
			case T__34:
				{
				setState(214);
				((TypeContext)_localctx).s = struct();
				((TypeContext)_localctx).ast =  ((TypeContext)_localctx).s.ast;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(219);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					{
					setState(220);
					match(T__2);
					setState(221);
					((TypeContext)_localctx).IC = match(INT_CONSTANT);
					setState(222);
					match(T__3);
					}
					((TypeContext)_localctx).ast = new ArrayType(((TypeContext)_localctx).IC.getLine(), ((TypeContext)_localctx).IC.getCharPositionInLine()+1, ((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).IC!=null?((TypeContext)_localctx).IC.getText():null)));
					setState(231);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(225);
							match(T__2);
							setState(226);
							((TypeContext)_localctx).IC2 = match(INT_CONSTANT);
							setState(227);
							match(T__3);

							                          ((TypeContext)_localctx).secondArray =  new ArrayType(((TypeContext)_localctx).IC2.getLine(), ((TypeContext)_localctx).IC2.getCharPositionInLine()+1, ((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).IC2!=null?((TypeContext)_localctx).IC2.getText():null)));
							                          ((ArrayType) _localctx.ast).setNewDimensionType( _localctx.secondArray);
							                          
							}
							} 
						}
						setState(233);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
					}
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BuiltInTypeContext extends ParserRuleContext {
		public Type ast;
		public Token t;
		public BuiltInTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtInType; }
	}

	public final BuiltInTypeContext builtInType() throws RecognitionException {
		BuiltInTypeContext _localctx = new BuiltInTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_builtInType);
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				((BuiltInTypeContext)_localctx).t = match(T__30);
				((BuiltInTypeContext)_localctx).ast =  new IntType(((BuiltInTypeContext)_localctx).t.getLine(), ((BuiltInTypeContext)_localctx).t.getCharPositionInLine()+1);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				((BuiltInTypeContext)_localctx).t = match(T__31);
				((BuiltInTypeContext)_localctx).ast =  new DoubleType(((BuiltInTypeContext)_localctx).t.getLine(), ((BuiltInTypeContext)_localctx).t.getCharPositionInLine()+1);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
				((BuiltInTypeContext)_localctx).t = match(T__32);
				((BuiltInTypeContext)_localctx).ast =  new CharType(((BuiltInTypeContext)_localctx).t.getLine(), ((BuiltInTypeContext)_localctx).t.getCharPositionInLine()+1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VoidContext extends ParserRuleContext {
		public VoidType ast;
		public Token V;
		public VoidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_void; }
	}

	public final VoidContext void_() throws RecognitionException {
		VoidContext _localctx = new VoidContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_void);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			((VoidContext)_localctx).V = match(T__33);
			((VoidContext)_localctx).ast =  new VoidType(((VoidContext)_localctx).V.getLine(), ((VoidContext)_localctx).V.getCharPositionInLine()+1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructContext extends ParserRuleContext {
		public RecordType ast;
		public List<RecordField> fields = new ArrayList<RecordField>();
		public List<String> names = new ArrayList<String>();
		public Token ST;
		public RecordFieldsContext rf;
		public List<RecordFieldsContext> recordFields() {
			return getRuleContexts(RecordFieldsContext.class);
		}
		public RecordFieldsContext recordFields(int i) {
			return getRuleContext(RecordFieldsContext.class,i);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_struct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			((StructContext)_localctx).ST = match(T__34);
			setState(251);
			match(T__28);
			setState(255); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(252);
				((StructContext)_localctx).rf = recordFields();

				                for(RecordField field : ((StructContext)_localctx).rf.ast) {
				                    if(_localctx.names.contains(field.getName()))
				                       new ErrorType(field.getLine(), field.getColumn(), String.format("Semantic ERROR: variable %s already defined in the scope.", field.getName(), field.getLine(), field.getColumn()));
				                    else {
				                        _localctx.names.add(field.getName());
				                         _localctx.fields.add(field);
				                    }
				                }
				            
				}
				}
				setState(257); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 49392123904L) != 0) );
			setState(259);
			match(T__29);
			((StructContext)_localctx).ast =  new RecordType(((StructContext)_localctx).ST.getLine(), ((StructContext)_localctx).ST.getCharPositionInLine()+1, _localctx.fields);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecordFieldsContext extends ParserRuleContext {
		public List<RecordField> ast = new ArrayList<RecordField>();
		public TypeContext t;
		public Token id1;
		public Token id2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public RecordFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordFields; }
	}

	public final RecordFieldsContext recordFields() throws RecognitionException {
		RecordFieldsContext _localctx = new RecordFieldsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_recordFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			((RecordFieldsContext)_localctx).t = type(0);
			setState(263);
			((RecordFieldsContext)_localctx).id1 = match(ID);
			 _localctx.ast.add( new RecordField(((RecordFieldsContext)_localctx).id1.getLine(), ((RecordFieldsContext)_localctx).id1.getCharPositionInLine()+1, ((RecordFieldsContext)_localctx).t.ast, (((RecordFieldsContext)_localctx).id1!=null?((RecordFieldsContext)_localctx).id1.getText():null))); 
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27) {
				{
				{
				setState(265);
				match(T__27);
				setState(266);
				((RecordFieldsContext)_localctx).id2 = match(ID);
				 _localctx.ast.add( new RecordField(((RecordFieldsContext)_localctx).id2.getLine(), ((RecordFieldsContext)_localctx).id2.getCharPositionInLine()+1, ((RecordFieldsContext)_localctx).t.ast, (((RecordFieldsContext)_localctx).id2!=null?((RecordFieldsContext)_localctx).id2.getText():null)));
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
			match(T__21);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionReturnTypeContext extends ParserRuleContext {
		public Type ast;
		public VoidContext v;
		public BuiltInTypeContext bt;
		public VoidContext void_() {
			return getRuleContext(VoidContext.class,0);
		}
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public FunctionReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionReturnType; }
	}

	public final FunctionReturnTypeContext functionReturnType() throws RecognitionException {
		FunctionReturnTypeContext _localctx = new FunctionReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionReturnType);
		try {
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				((FunctionReturnTypeContext)_localctx).v = void_();
				((FunctionReturnTypeContext)_localctx).ast =  ((FunctionReturnTypeContext)_localctx).v.ast;
				}
				break;
			case T__30:
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				((FunctionReturnTypeContext)_localctx).bt = builtInType();
				((FunctionReturnTypeContext)_localctx).ast =  ((FunctionReturnTypeContext)_localctx).bt.ast;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public BuiltInTypeContext bt1;
		public Token id1;
		public BuiltInTypeContext bt2;
		public Token id2;
		public List<BuiltInTypeContext> builtInType() {
			return getRuleContexts(BuiltInTypeContext.class);
		}
		public BuiltInTypeContext builtInType(int i) {
			return getRuleContext(BuiltInTypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15032385536L) != 0)) {
				{
				{
				setState(283);
				((ParamsContext)_localctx).bt1 = builtInType();
				setState(284);
				((ParamsContext)_localctx).id1 = match(ID);
				_localctx.ast.add(new VarDefinition(((ParamsContext)_localctx).id1.getLine(), ((ParamsContext)_localctx).id1.getCharPositionInLine()+1, ((ParamsContext)_localctx).bt1.ast, (((ParamsContext)_localctx).id1!=null?((ParamsContext)_localctx).id1.getText():null)));
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__27) {
					{
					{
					setState(286);
					match(T__27);
					setState(287);
					((ParamsContext)_localctx).bt2 = builtInType();
					setState(288);
					((ParamsContext)_localctx).id2 = match(ID);
					_localctx.ast.add(new VarDefinition(((ParamsContext)_localctx).id2.getLine(), ((ParamsContext)_localctx).id2.getCharPositionInLine()+1, ((ParamsContext)_localctx).bt2.ast, (((ParamsContext)_localctx).id2!=null?((ParamsContext)_localctx).id2.getText():null)));
					}
					}
					setState(295);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(300);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MainDefinitionContext extends ParserRuleContext {
		public FuncDefinition ast;
		public FunctionType mainType;
		public VoidContext v;
		public FuncBodyContext fs;
		public VoidContext void_() {
			return getRuleContext(VoidContext.class,0);
		}
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public MainDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDefinition; }
	}

	public final MainDefinitionContext mainDefinition() throws RecognitionException {
		MainDefinitionContext _localctx = new MainDefinitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mainDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			((MainDefinitionContext)_localctx).v = void_();
			setState(302);
			match(T__35);
			setState(303);
			match(T__0);
			setState(304);
			match(T__1);
			setState(305);
			match(T__28);
			setState(306);
			((MainDefinitionContext)_localctx).fs = funcBody();
			setState(307);
			match(T__29);
			((MainDefinitionContext)_localctx).mainType =  new FunctionType(((MainDefinitionContext)_localctx).v.ast.getLine(), ((MainDefinitionContext)_localctx).v.ast.getColumn(), ((MainDefinitionContext)_localctx).v.ast, new ArrayList<VarDefinition>());
			((MainDefinitionContext)_localctx).ast =  new FuncDefinition(((MainDefinitionContext)_localctx).v.ast.getLine(), ((MainDefinitionContext)_localctx).v.ast.getColumn(), _localctx.mainType, "main", ((MainDefinitionContext)_localctx).fs.ast.getVarDefinitions(), ((MainDefinitionContext)_localctx).fs.ast.getStatements());
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public FuncDefinitionContext fd;
		public VarDefinitionsContext v;
		public FuncDefinitionContext funcDefinition() {
			return getRuleContext(FuncDefinitionContext.class,0);
		}
		public VarDefinitionsContext varDefinitions() {
			return getRuleContext(VarDefinitionsContext.class,0);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_definitions);
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				((DefinitionsContext)_localctx).fd = funcDefinition();
				_localctx.ast.add(((DefinitionsContext)_localctx).fd.ast);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				((DefinitionsContext)_localctx).v = varDefinitions();
				_localctx.ast.addAll(((DefinitionsContext)_localctx).v.ast);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefinitionContext extends ParserRuleContext {
		public FuncDefinition ast;
		public FunctionType ft;
		public FunctionReturnTypeContext frt;
		public Token ID;
		public ParamsContext p;
		public FuncBodyContext fs;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public FunctionReturnTypeContext functionReturnType() {
			return getRuleContext(FunctionReturnTypeContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FuncBodyContext funcBody() {
			return getRuleContext(FuncBodyContext.class,0);
		}
		public FuncDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefinition; }
	}

	public final FuncDefinitionContext funcDefinition() throws RecognitionException {
		FuncDefinitionContext _localctx = new FuncDefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_funcDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			((FuncDefinitionContext)_localctx).frt = functionReturnType();
			setState(320);
			((FuncDefinitionContext)_localctx).ID = match(ID);
			setState(321);
			match(T__0);
			setState(322);
			((FuncDefinitionContext)_localctx).p = params();
			setState(323);
			match(T__1);
			setState(324);
			match(T__28);
			setState(325);
			((FuncDefinitionContext)_localctx).fs = funcBody();
			setState(326);
			match(T__29);
			((FuncDefinitionContext)_localctx).ft =  new FunctionType(((FuncDefinitionContext)_localctx).frt.ast.getLine(), ((FuncDefinitionContext)_localctx).frt.ast.getColumn(), ((FuncDefinitionContext)_localctx).frt.ast, ((FuncDefinitionContext)_localctx).p.ast);
			((FuncDefinitionContext)_localctx).ast =  new FuncDefinition(_localctx.ft.getLine(), _localctx.ft.getColumn(), _localctx.ft, (((FuncDefinitionContext)_localctx).ID!=null?((FuncDefinitionContext)_localctx).ID.getText():null), ((FuncDefinitionContext)_localctx).fs.ast.getVarDefinitions(), ((FuncDefinitionContext)_localctx).fs.ast.getStatements());
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncBodyContext extends ParserRuleContext {
		public FuncBody ast = new FuncBody();
		public List<VarDefinition> defs = new ArrayList<VarDefinition>();
		public List<String> names = new ArrayList<String>();
		public VarDefinitionsContext vd;
		public StatementsContext s;
		public List<VarDefinitionsContext> varDefinitions() {
			return getRuleContexts(VarDefinitionsContext.class);
		}
		public VarDefinitionsContext varDefinitions(int i) {
			return getRuleContext(VarDefinitionsContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public FuncBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcBody; }
	}

	public final FuncBodyContext funcBody() throws RecognitionException {
		FuncBodyContext _localctx = new FuncBodyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_funcBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 49392123904L) != 0)) {
				{
				{
				setState(330);
				((FuncBodyContext)_localctx).vd = varDefinitions();

				            for(VarDefinition vardef : ((FuncBodyContext)_localctx).vd.ast) {
				                if(_localctx.names.contains(vardef.getName()))
				                    new ErrorType(vardef.getLine(), vardef.getColumn(), String.format("Semantic ERROR: variable %s already defined in the scope.", vardef.getName(), vardef.getLine(), vardef.getColumn()));
				                else {
				                    _localctx.names.add(vardef.getName());
				                    _localctx.defs.add(vardef);
				               }
				           }
				        
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			_localctx.ast.addVarDefinitions(_localctx.defs);
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492901957826L) != 0)) {
				{
				{
				setState(339);
				((FuncBodyContext)_localctx).s = statements();
				_localctx.ast.addStatements(((FuncBodyContext)_localctx).s.ast);
				}
				}
				setState(346);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionsContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public TypeContext t;
		public Token id1;
		public Token id2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public VarDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefinitions; }
	}

	public final VarDefinitionsContext varDefinitions() throws RecognitionException {
		VarDefinitionsContext _localctx = new VarDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			((VarDefinitionsContext)_localctx).t = type(0);
			setState(348);
			((VarDefinitionsContext)_localctx).id1 = match(ID);
			 _localctx.ast.add( new VarDefinition(((VarDefinitionsContext)_localctx).id1.getLine(), ((VarDefinitionsContext)_localctx).id1.getCharPositionInLine()+1, ((VarDefinitionsContext)_localctx).t.ast, (((VarDefinitionsContext)_localctx).id1!=null?((VarDefinitionsContext)_localctx).id1.getText():null)) ); 
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27) {
				{
				{
				setState(350);
				match(T__27);
				setState(351);
				((VarDefinitionsContext)_localctx).id2 = match(ID);
				 _localctx.ast.add( new VarDefinition(((VarDefinitionsContext)_localctx).id2.getLine(), ((VarDefinitionsContext)_localctx).id2.getCharPositionInLine()+1, ((VarDefinitionsContext)_localctx).t.ast, (((VarDefinitionsContext)_localctx).id2!=null?((VarDefinitionsContext)_localctx).id2.getText():null)) ); 
				}
				}
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(358);
			match(T__21);
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
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 7:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u0169\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001S\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001s\b\u0001\n\u0001\f\u0001"+
		"v\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002\u00a1\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u00ad\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004\u00b5\b\u0004\n\u0004\f\u0004\u00b8"+
		"\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u00bf\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u00cb\b\u0006\n\u0006\f\u0006\u00ce\t\u0006\u0001\u0006\u0003\u0006"+
		"\u00d1\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u00da\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u00e6\b\u0007\n\u0007\f\u0007\u00e9"+
		"\t\u0007\u0005\u0007\u00eb\b\u0007\n\u0007\f\u0007\u00ee\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00f6\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u0100\b\n\u000b"+
		"\n\f\n\u0101\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u010d\b\u000b\n\u000b"+
		"\f\u000b\u0110\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u011a\b\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0124\b\r\n\r\f\r\u0127\t\r"+
		"\u0005\r\u0129\b\r\n\r\f\r\u012c\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u013e\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u014e\b\u0011\n\u0011\f\u0011\u0151\t\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u0157\b\u0011\n\u0011\f\u0011\u015a\t\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u0162\b\u0012\n\u0012\f\u0012\u0165\t\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0000\u0002\u0002\u000e\u0013\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000"+
		"\u0004\u0001\u0000\b\n\u0002\u0000\u0006\u0006\u000b\u000b\u0001\u0000"+
		"\f\u0011\u0001\u0000\u0012\u0013\u017d\u0000+\u0001\u0000\u0000\u0000"+
		"\u0002R\u0001\u0000\u0000\u0000\u0004\u00a0\u0001\u0000\u0000\u0000\u0006"+
		"\u00ac\u0001\u0000\u0000\u0000\b\u00ae\u0001\u0000\u0000\u0000\n\u00b9"+
		"\u0001\u0000\u0000\u0000\f\u00d0\u0001\u0000\u0000\u0000\u000e\u00d9\u0001"+
		"\u0000\u0000\u0000\u0010\u00f5\u0001\u0000\u0000\u0000\u0012\u00f7\u0001"+
		"\u0000\u0000\u0000\u0014\u00fa\u0001\u0000\u0000\u0000\u0016\u0106\u0001"+
		"\u0000\u0000\u0000\u0018\u0119\u0001\u0000\u0000\u0000\u001a\u012a\u0001"+
		"\u0000\u0000\u0000\u001c\u012d\u0001\u0000\u0000\u0000\u001e\u013d\u0001"+
		"\u0000\u0000\u0000 \u013f\u0001\u0000\u0000\u0000\"\u014f\u0001\u0000"+
		"\u0000\u0000$\u015b\u0001\u0000\u0000\u0000&\'\u0003\u001e\u000f\u0000"+
		"\'(\u0006\u0000\uffff\uffff\u0000(*\u0001\u0000\u0000\u0000)&\u0001\u0000"+
		"\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001"+
		"\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000"+
		"./\u0003\u001c\u000e\u0000/0\u0006\u0000\uffff\uffff\u000001\u0005\u0000"+
		"\u0000\u000112\u0006\u0000\uffff\uffff\u00002\u0001\u0001\u0000\u0000"+
		"\u000034\u0006\u0001\uffff\uffff\u000045\u0005(\u0000\u00005S\u0006\u0001"+
		"\uffff\uffff\u000067\u0005)\u0000\u00007S\u0006\u0001\uffff\uffff\u0000"+
		"89\u0005*\u0000\u00009S\u0006\u0001\uffff\uffff\u0000:;\u0005+\u0000\u0000"+
		";S\u0006\u0001\uffff\uffff\u0000<=\u0005\u0001\u0000\u0000=>\u0003\u0002"+
		"\u0001\u0000>?\u0005\u0002\u0000\u0000?@\u0006\u0001\uffff\uffff\u0000"+
		"@S\u0001\u0000\u0000\u0000AB\u0003\n\u0005\u0000BC\u0006\u0001\uffff\uffff"+
		"\u0000CS\u0001\u0000\u0000\u0000DE\u0005\u0001\u0000\u0000EF\u0003\u0010"+
		"\b\u0000FG\u0005\u0002\u0000\u0000GH\u0003\u0002\u0001\u0007HI\u0006\u0001"+
		"\uffff\uffff\u0000IS\u0001\u0000\u0000\u0000JK\u0005\u0006\u0000\u0000"+
		"KL\u0003\u0002\u0001\u0006LM\u0006\u0001\uffff\uffff\u0000MS\u0001\u0000"+
		"\u0000\u0000NO\u0005\u0007\u0000\u0000OP\u0003\u0002\u0001\u0005PQ\u0006"+
		"\u0001\uffff\uffff\u0000QS\u0001\u0000\u0000\u0000R3\u0001\u0000\u0000"+
		"\u0000R6\u0001\u0000\u0000\u0000R8\u0001\u0000\u0000\u0000R:\u0001\u0000"+
		"\u0000\u0000R<\u0001\u0000\u0000\u0000RA\u0001\u0000\u0000\u0000RD\u0001"+
		"\u0000\u0000\u0000RJ\u0001\u0000\u0000\u0000RN\u0001\u0000\u0000\u0000"+
		"St\u0001\u0000\u0000\u0000TU\n\u0004\u0000\u0000UV\u0007\u0000\u0000\u0000"+
		"VW\u0003\u0002\u0001\u0005WX\u0006\u0001\uffff\uffff\u0000Xs\u0001\u0000"+
		"\u0000\u0000YZ\n\u0003\u0000\u0000Z[\u0007\u0001\u0000\u0000[\\\u0003"+
		"\u0002\u0001\u0004\\]\u0006\u0001\uffff\uffff\u0000]s\u0001\u0000\u0000"+
		"\u0000^_\n\u0002\u0000\u0000_`\u0007\u0002\u0000\u0000`a\u0003\u0002\u0001"+
		"\u0003ab\u0006\u0001\uffff\uffff\u0000bs\u0001\u0000\u0000\u0000cd\n\u0001"+
		"\u0000\u0000de\u0007\u0003\u0000\u0000ef\u0003\u0002\u0001\u0002fg\u0006"+
		"\u0001\uffff\uffff\u0000gs\u0001\u0000\u0000\u0000hi\n\t\u0000\u0000i"+
		"j\u0005\u0003\u0000\u0000jk\u0003\u0002\u0001\u0000kl\u0005\u0004\u0000"+
		"\u0000lm\u0006\u0001\uffff\uffff\u0000ms\u0001\u0000\u0000\u0000no\n\b"+
		"\u0000\u0000op\u0005\u0005\u0000\u0000pq\u0005+\u0000\u0000qs\u0006\u0001"+
		"\uffff\uffff\u0000rT\u0001\u0000\u0000\u0000rY\u0001\u0000\u0000\u0000"+
		"r^\u0001\u0000\u0000\u0000rc\u0001\u0000\u0000\u0000rh\u0001\u0000\u0000"+
		"\u0000rn\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000u\u0003\u0001\u0000\u0000\u0000"+
		"vt\u0001\u0000\u0000\u0000wx\u0005\u0014\u0000\u0000xy\u0005\u0001\u0000"+
		"\u0000yz\u0003\u0002\u0001\u0000z{\u0005\u0002\u0000\u0000{|\u0003\f\u0006"+
		"\u0000|}\u0006\u0002\uffff\uffff\u0000}\u00a1\u0001\u0000\u0000\u0000"+
		"~\u007f\u0003\u0002\u0001\u0000\u007f\u0080\u0005\u0015\u0000\u0000\u0080"+
		"\u0081\u0003\u0002\u0001\u0000\u0081\u0082\u0005\u0016\u0000\u0000\u0082"+
		"\u0083\u0006\u0002\uffff\uffff\u0000\u0083\u00a1\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0003\u0006\u0003\u0000\u0085\u0086\u0006\u0002\uffff\uffff"+
		"\u0000\u0086\u00a1\u0001\u0000\u0000\u0000\u0087\u0088\u0003\n\u0005\u0000"+
		"\u0088\u0089\u0005\u0016\u0000\u0000\u0089\u008a\u0006\u0002\uffff\uffff"+
		"\u0000\u008a\u00a1\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u0017\u0000"+
		"\u0000\u008c\u008d\u0003\u0002\u0001\u0000\u008d\u008e\u0005\u0016\u0000"+
		"\u0000\u008e\u008f\u0006\u0002\uffff\uffff\u0000\u008f\u00a1\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0005\u0018\u0000\u0000\u0091\u0092\u0005\u0001"+
		"\u0000\u0000\u0092\u0093\u0003\u0002\u0001\u0000\u0093\u0094\u0005\u0002"+
		"\u0000\u0000\u0094\u0095\u0003\f\u0006\u0000\u0095\u0096\u0006\u0002\uffff"+
		"\uffff\u0000\u0096\u00a1\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0018"+
		"\u0000\u0000\u0098\u0099\u0005\u0001\u0000\u0000\u0099\u009a\u0003\u0002"+
		"\u0001\u0000\u009a\u009b\u0005\u0002\u0000\u0000\u009b\u009c\u0003\f\u0006"+
		"\u0000\u009c\u009d\u0005\u0019\u0000\u0000\u009d\u009e\u0003\f\u0006\u0000"+
		"\u009e\u009f\u0006\u0002\uffff\uffff\u0000\u009f\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a0w\u0001\u0000\u0000\u0000\u00a0~\u0001\u0000\u0000\u0000\u00a0"+
		"\u0084\u0001\u0000\u0000\u0000\u00a0\u0087\u0001\u0000\u0000\u0000\u00a0"+
		"\u008b\u0001\u0000\u0000\u0000\u00a0\u0090\u0001\u0000\u0000\u0000\u00a0"+
		"\u0097\u0001\u0000\u0000\u0000\u00a1\u0005\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0005\u001a\u0000\u0000\u00a3\u00a4\u0003\b\u0004\u0000\u00a4\u00a5"+
		"\u0005\u0016\u0000\u0000\u00a5\u00a6\u0006\u0003\uffff\uffff\u0000\u00a6"+
		"\u00ad\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u001b\u0000\u0000\u00a8"+
		"\u00a9\u0003\b\u0004\u0000\u00a9\u00aa\u0005\u0016\u0000\u0000\u00aa\u00ab"+
		"\u0006\u0003\uffff\uffff\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac"+
		"\u00a2\u0001\u0000\u0000\u0000\u00ac\u00a7\u0001\u0000\u0000\u0000\u00ad"+
		"\u0007\u0001\u0000\u0000\u0000\u00ae\u00af\u0003\u0002\u0001\u0000\u00af"+
		"\u00b6\u0006\u0004\uffff\uffff\u0000\u00b0\u00b1\u0005\u001c\u0000\u0000"+
		"\u00b1\u00b2\u0003\u0002\u0001\u0000\u00b2\u00b3\u0006\u0004\uffff\uffff"+
		"\u0000\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\t\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005+\u0000\u0000\u00ba"+
		"\u00be\u0005\u0001\u0000\u0000\u00bb\u00bc\u0003\b\u0004\u0000\u00bc\u00bd"+
		"\u0006\u0005\uffff\uffff\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be"+
		"\u00bb\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0002\u0000\u0000\u00c1"+
		"\u00c2\u0006\u0005\uffff\uffff\u0000\u00c2\u000b\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0003\u0004\u0002\u0000\u00c4\u00c5\u0006\u0006\uffff\uffff"+
		"\u0000\u00c5\u00d1\u0001\u0000\u0000\u0000\u00c6\u00cc\u0005\u001d\u0000"+
		"\u0000\u00c7\u00c8\u0003\u0004\u0002\u0000\u00c8\u00c9\u0006\u0006\uffff"+
		"\uffff\u0000\u00c9\u00cb\u0001\u0000\u0000\u0000\u00ca\u00c7\u0001\u0000"+
		"\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d1\u0005\u001e"+
		"\u0000\u0000\u00d0\u00c3\u0001\u0000\u0000\u0000\u00d0\u00c6\u0001\u0000"+
		"\u0000\u0000\u00d1\r\u0001\u0000\u0000\u0000\u00d2\u00d3\u0006\u0007\uffff"+
		"\uffff\u0000\u00d3\u00d4\u0003\u0010\b\u0000\u00d4\u00d5\u0006\u0007\uffff"+
		"\uffff\u0000\u00d5\u00da\u0001\u0000\u0000\u0000\u00d6\u00d7\u0003\u0014"+
		"\n\u0000\u00d7\u00d8\u0006\u0007\uffff\uffff\u0000\u00d8\u00da\u0001\u0000"+
		"\u0000\u0000\u00d9\u00d2\u0001\u0000\u0000\u0000\u00d9\u00d6\u0001\u0000"+
		"\u0000\u0000\u00da\u00ec\u0001\u0000\u0000\u0000\u00db\u00dc\n\u0002\u0000"+
		"\u0000\u00dc\u00dd\u0005\u0003\u0000\u0000\u00dd\u00de\u0005)\u0000\u0000"+
		"\u00de\u00df\u0005\u0004\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e0\u00e7\u0006\u0007\uffff\uffff\u0000\u00e1\u00e2\u0005\u0003\u0000"+
		"\u0000\u00e2\u00e3\u0005)\u0000\u0000\u00e3\u00e4\u0005\u0004\u0000\u0000"+
		"\u00e4\u00e6\u0006\u0007\uffff\uffff\u0000\u00e5\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea\u00db\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u000f\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\u001f\u0000"+
		"\u0000\u00f0\u00f6\u0006\b\uffff\uffff\u0000\u00f1\u00f2\u0005 \u0000"+
		"\u0000\u00f2\u00f6\u0006\b\uffff\uffff\u0000\u00f3\u00f4\u0005!\u0000"+
		"\u0000\u00f4\u00f6\u0006\b\uffff\uffff\u0000\u00f5\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f1\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f6\u0011\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\"\u0000\u0000"+
		"\u00f8\u00f9\u0006\t\uffff\uffff\u0000\u00f9\u0013\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0005#\u0000\u0000\u00fb\u00ff\u0005\u001d\u0000\u0000\u00fc"+
		"\u00fd\u0003\u0016\u000b\u0000\u00fd\u00fe\u0006\n\uffff\uffff\u0000\u00fe"+
		"\u0100\u0001\u0000\u0000\u0000\u00ff\u00fc\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0005\u001e\u0000\u0000\u0104\u0105\u0006\n\uffff\uffff\u0000\u0105"+
		"\u0015\u0001\u0000\u0000\u0000\u0106\u0107\u0003\u000e\u0007\u0000\u0107"+
		"\u0108\u0005+\u0000\u0000\u0108\u010e\u0006\u000b\uffff\uffff\u0000\u0109"+
		"\u010a\u0005\u001c\u0000\u0000\u010a\u010b\u0005+\u0000\u0000\u010b\u010d"+
		"\u0006\u000b\uffff\uffff\u0000\u010c\u0109\u0001\u0000\u0000\u0000\u010d"+
		"\u0110\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0001\u0000\u0000\u0000\u010f\u0111\u0001\u0000\u0000\u0000\u0110"+
		"\u010e\u0001\u0000\u0000\u0000\u0111\u0112\u0005\u0016\u0000\u0000\u0112"+
		"\u0017\u0001\u0000\u0000\u0000\u0113\u0114\u0003\u0012\t\u0000\u0114\u0115"+
		"\u0006\f\uffff\uffff\u0000\u0115\u011a\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0003\u0010\b\u0000\u0117\u0118\u0006\f\uffff\uffff\u0000\u0118\u011a"+
		"\u0001\u0000\u0000\u0000\u0119\u0113\u0001\u0000\u0000\u0000\u0119\u0116"+
		"\u0001\u0000\u0000\u0000\u011a\u0019\u0001\u0000\u0000\u0000\u011b\u011c"+
		"\u0003\u0010\b\u0000\u011c\u011d\u0005+\u0000\u0000\u011d\u0125\u0006"+
		"\r\uffff\uffff\u0000\u011e\u011f\u0005\u001c\u0000\u0000\u011f\u0120\u0003"+
		"\u0010\b\u0000\u0120\u0121\u0005+\u0000\u0000\u0121\u0122\u0006\r\uffff"+
		"\uffff\u0000\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u011e\u0001\u0000"+
		"\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000"+
		"\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0129\u0001\u0000"+
		"\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u011b\u0001\u0000"+
		"\u0000\u0000\u0129\u012c\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u001b\u0001\u0000"+
		"\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012d\u012e\u0003\u0012"+
		"\t\u0000\u012e\u012f\u0005$\u0000\u0000\u012f\u0130\u0005\u0001\u0000"+
		"\u0000\u0130\u0131\u0005\u0002\u0000\u0000\u0131\u0132\u0005\u001d\u0000"+
		"\u0000\u0132\u0133\u0003\"\u0011\u0000\u0133\u0134\u0005\u001e\u0000\u0000"+
		"\u0134\u0135\u0006\u000e\uffff\uffff\u0000\u0135\u0136\u0006\u000e\uffff"+
		"\uffff\u0000\u0136\u001d\u0001\u0000\u0000\u0000\u0137\u0138\u0003 \u0010"+
		"\u0000\u0138\u0139\u0006\u000f\uffff\uffff\u0000\u0139\u013e\u0001\u0000"+
		"\u0000\u0000\u013a\u013b\u0003$\u0012\u0000\u013b\u013c\u0006\u000f\uffff"+
		"\uffff\u0000\u013c\u013e\u0001\u0000\u0000\u0000\u013d\u0137\u0001\u0000"+
		"\u0000\u0000\u013d\u013a\u0001\u0000\u0000\u0000\u013e\u001f\u0001\u0000"+
		"\u0000\u0000\u013f\u0140\u0003\u0018\f\u0000\u0140\u0141\u0005+\u0000"+
		"\u0000\u0141\u0142\u0005\u0001\u0000\u0000\u0142\u0143\u0003\u001a\r\u0000"+
		"\u0143\u0144\u0005\u0002\u0000\u0000\u0144\u0145\u0005\u001d\u0000\u0000"+
		"\u0145\u0146\u0003\"\u0011\u0000\u0146\u0147\u0005\u001e\u0000\u0000\u0147"+
		"\u0148\u0006\u0010\uffff\uffff\u0000\u0148\u0149\u0006\u0010\uffff\uffff"+
		"\u0000\u0149!\u0001\u0000\u0000\u0000\u014a\u014b\u0003$\u0012\u0000\u014b"+
		"\u014c\u0006\u0011\uffff\uffff\u0000\u014c\u014e\u0001\u0000\u0000\u0000"+
		"\u014d\u014a\u0001\u0000\u0000\u0000\u014e\u0151\u0001\u0000\u0000\u0000"+
		"\u014f\u014d\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000"+
		"\u0150\u0152\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000"+
		"\u0152\u0158\u0006\u0011\uffff\uffff\u0000\u0153\u0154\u0003\u0004\u0002"+
		"\u0000\u0154\u0155\u0006\u0011\uffff\uffff\u0000\u0155\u0157\u0001\u0000"+
		"\u0000\u0000\u0156\u0153\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000"+
		"\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000"+
		"\u0000\u0000\u0159#\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000"+
		"\u0000\u015b\u015c\u0003\u000e\u0007\u0000\u015c\u015d\u0005+\u0000\u0000"+
		"\u015d\u0163\u0006\u0012\uffff\uffff\u0000\u015e\u015f\u0005\u001c\u0000"+
		"\u0000\u015f\u0160\u0005+\u0000\u0000\u0160\u0162\u0006\u0012\uffff\uffff"+
		"\u0000\u0161\u015e\u0001\u0000\u0000\u0000\u0162\u0165\u0001\u0000\u0000"+
		"\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000"+
		"\u0000\u0164\u0166\u0001\u0000\u0000\u0000\u0165\u0163\u0001\u0000\u0000"+
		"\u0000\u0166\u0167\u0005\u0016\u0000\u0000\u0167%\u0001\u0000\u0000\u0000"+
		"\u0017+Rrt\u00a0\u00ac\u00b6\u00be\u00cc\u00d0\u00d9\u00e7\u00ec\u00f5"+
		"\u0101\u010e\u0119\u0125\u012a\u013d\u014f\u0158\u0163";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}