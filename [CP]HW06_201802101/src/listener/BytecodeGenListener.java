package listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.MiniGoBaseListener;
import generated.MiniGoParser;
import generated.MiniGoParser.*;


import static listener.BytecodeGenListenerHelper.*;
import static listener.SymbolTable.*;

public class BytecodeGenListener extends MiniGoBaseListener implements ParseTreeListener {
    ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
    SymbolTable symbolTable = new SymbolTable();

    boolean local = false;

    @Override
    public void enterFun_decl(MiniGoParser.Fun_declContext ctx) {
        symbolTable.initFunDecl();

        String fname = getFunName(ctx);
        ParamsContext params;

        if (fname.equals("main")) {
            symbolTable.putLocalVar("args", Type.INTARRAY);
        } else {
            symbolTable.putFunSpecStr(ctx);
            params = (MiniGoParser.ParamsContext) ctx.getChild(3);
            symbolTable.putParams(params);
        }
    }


    // var_decl	:  dec_spec IDENT  type_spec
    //		| dec_spec IDENT type_spec '=' LITERAL
    //		| dec_spec IDENT '[' LITERAL ']' type_spec
    @Override
    public void enterVar_decl(MiniGoParser.Var_declContext ctx) {
        String varName = ctx.IDENT().getText();

        if (isArrayDecl(ctx)) {
        	if(local == false)
        		symbolTable.putGlobalVar(varName, Type.INTARRAY);
        	else
        		symbolTable.putLocalVar(varName, Type.INTARRAY);
        }
        else if (isDeclWithInit(ctx)) {
            // Fill here
        	if(local == false)
        		symbolTable.putGlobalVarWithInitVal(varName, Type.INT, Integer.parseInt(ctx.LITERAL().getText()));
        	else
        		symbolTable.putLocalVarWithInitVal(varName, Type.INT, Integer.parseInt(ctx.LITERAL().getText()));
        }
        else  { // simple decl
        	if(local == false)
        		symbolTable.putGlobalVar(varName, Type.INT);
        	else
        		symbolTable.putLocalVar(varName, Type.INT);
        }
    }
    
    
    @Override
    public void enterLocal_decl(MiniGoParser.Local_declContext ctx) {
        local = true;
    }
    

    @Override
    public void exitProgram(MiniGoParser.ProgramContext ctx) {
        String classProlog = getFunProlog();
        String constructor = ".method public <init>()V" + "\n"
							+ "aload_0" + "\n"
							+ "invokenonvirtual java/lang/Object/<init>()V" + "\n"
							+ "return" + "\n"
							+ ".end method" + "\n";
        
        String fun_decl = "", var_decl = "";

        for(int i = 0; i < ctx.getChildCount(); i++) {
            if(isFunDecl(ctx, i))
                fun_decl += newTexts.get(ctx.decl(i));
            else
                var_decl += newTexts.get(ctx.decl(i));
        }

        newTexts.put(ctx, classProlog + var_decl + "\n" + constructor + "\n" + fun_decl);

		File file = new File(String.format("test.j")); // 파일 생성
		
		try {
			FileWriter fw = new FileWriter(file); // FileWriter 객체 생성
			fw.write(newTexts.get(ctx)); // 파일에 입력
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    // decl	: var_decl | fun_decl
    @Override
    public void exitDecl(MiniGoParser.DeclContext ctx) {
        String decl = "";
        if(ctx.getChildCount() == 1)
        {
            if(ctx.var_decl() != null)				//var_decl
                decl += newTexts.get(ctx.var_decl());
            else							//fun_decl
                decl += newTexts.get(ctx.fun_decl());
        }
        newTexts.put(ctx, decl);
    }

    // stmt	: expr_stmt | compound_stmt | if_stmt | for_stmt | return_stmt
    @Override
    public void exitStmt(MiniGoParser.StmtContext ctx) {
        String stmt = "";
        if(ctx.getChildCount() > 0)
        {
            if(ctx.expr_stmt() != null)				// expr_stmt
                stmt += newTexts.get(ctx.expr_stmt());
            else if(ctx.compound_stmt() != null)	// compound_stmt
                stmt += newTexts.get(ctx.compound_stmt());
            // <(0) Fill here>
            else if(ctx.if_stmt() != null)
            	stmt += newTexts.get(ctx.if_stmt());
            else if(ctx.for_stmt() != null)
            	stmt += newTexts.get(ctx.for_stmt());
            else if(ctx.return_stmt() != null)
            	stmt += newTexts.get(ctx.return_stmt());
        }
        newTexts.put(ctx, stmt);
    }

    // expr_stmt	: expr ';'
    @Override
    public void exitExpr_stmt(MiniGoParser.Expr_stmtContext ctx) {
        String stmt = "";
        if(ctx.getChildCount() == 1)
        {
            stmt += newTexts.get(ctx.expr());	// expr
        }
        newTexts.put(ctx, stmt);
    }

    // fun_decl	: FUNC IDENT '(' params ')' type_spec compound_stmt ; 
    @Override
    public void exitFun_decl(MiniGoParser.Fun_declContext ctx) {
        // <(2) Fill here!>
    	String stmt = "";
    	String fname = getFunName(ctx);
    	
    	String fheader = funcHeader(ctx, fname);
    	stmt += fheader;
    	stmt += newTexts.get(ctx.compound_stmt());
    	stmt += "label0:\n";
    	String f = symbolTable.getFunSpecStr(fname);
    	if(f.charAt(f.length()-1) == 'V') {
    		stmt += "return" + "\n";
    	}
    	if(f.charAt(f.length()-1) == 'I') {
    		stmt += "ireturn" + "\n";
    	}
    	stmt += ".end method" + "\n\n";
    	newTexts.put(ctx, stmt);
    }


    private String funcHeader(MiniGoParser.Fun_declContext ctx, String fname) {
        return ".method public static " + symbolTable.getFunSpecStr(fname) + "\n"
                + ".limit stack " 	+ getStackSize(ctx) + "\n"
                + ".limit locals " 	+ getLocalVarSize(ctx) + "\n";

    }

    // var_decl	:  dec_spec IDENT  type_spec
	//				| dec_spec IDENT type_spec '=' LITERAL
	//				| dec_spec IDENT '[' LITERAL ']' type_spec  ;
    @Override
    public void exitVar_decl(MiniGoParser.Var_declContext ctx) {
        String varName = ctx.IDENT().getText();
        String varDecl = "";

        if (isDeclWithInit(ctx)) {
        	
        	int Id = Integer.parseInt(symbolTable.getVarId(ctx));
        	if(local == false) {
        		varDecl += ".field " + varName + " I" + "\n";
        	}
        	else {
        		varDecl += "ldc " + ctx.LITERAL().getText() + "\n";
        		if(Id > 3) {
        			varDecl += "istore " + Id + "\n";
        		}
        		else {
        			varDecl += "istore_" + Id + "\n";
        		}
        	}
        	
        }
        newTexts.put(ctx, varDecl);
    }
    
    // local_decl	: var_decl	;
    @Override
    public void exitLocal_decl(MiniGoParser.Local_declContext ctx) {
        local = false;
        String localDecl = newTexts.get(ctx.var_decl());
        newTexts.put(ctx, localDecl);
    }

    // compound_stmt	: '{' local_decl* stmt* '}'
    @Override
    public void exitCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {
        // <(3) Fill here>
    	String stmt = "";
		
		// local_delc* 부분
		for(int i = 0; i < ctx.local_decl().size(); i++) {
			stmt += newTexts.get(ctx.local_decl(i)); // ctx의 local_decl(지역 변수 선언)를 가져와 s에 이어붙여줌
		} // *라서 몇개가 있는지 몰라 local_decl().size()로 크기 구하고 크기만큼 반복
		
		// stmt* 부분
		for(int i = 0; i < ctx.stmt().size(); i++) {
			stmt += newTexts.get(ctx.stmt(i)); // 들여쓰기 후 ctx의 stmt를 가져와 s에 이어붙여주고 1줄 내림
		} // *라서 몇개가 있는지 몰라 stmt().size()로 크기 구하고 크기만큼 반복
		
		newTexts.put(ctx, stmt); // newTexts에 s넣어줌
    }

    // if_stmt		:  IF  expr  stmt
    //		| IF  expr  stmt ELSE stmt   ;
    @Override
    public void exitIf_stmt(MiniGoParser.If_stmtContext ctx) {
        String stmt = "";
        String condExpr= newTexts.get(ctx.expr());
        String thenStmt = newTexts.get(ctx.stmt(0));

        String lend = symbolTable.newLabel();
        String lelse = symbolTable.newLabel();


        if(noElse(ctx)) {
            stmt += condExpr + "\n"
                    + "ifeq " + lend + "\n"
                    + thenStmt + "\n"
                    + lend + ":"  + "\n";
        }
        else {
            String elseStmt = newTexts.get(ctx.stmt(1));
            stmt += condExpr + "\n"
                    + "ifeq " + lelse + "\n"
                    + thenStmt + "\n"
                    + "goto " + lend + "\n"
                    + lelse + ": " + "\n"
                    + elseStmt + "\n"
                    + lend + ":"  + "\n";
        }

        newTexts.put(ctx, stmt);
    }
    
    // for_stmt	: FOR expr stmt
    @Override
    public void exitFor_stmt(MiniGoParser.For_stmtContext ctx) {
    	String stmt = "";
    	String lbeg = symbolTable.newLabel();
        String lend = symbolTable.newLabel();
        
        stmt += lbeg + ": " + "\n"
        		+ newTexts.get(ctx.expr())
        		+ "ifeq " + lend + "\n"
        		+ newTexts.get(ctx.stmt())
        		+ "goto " + lbeg + "\n"
        		+ lend + ": " + "\n";
        newTexts.put(ctx, stmt);
    }
    
    // return_stmt	: RETURN
    //		| RETURN expr
    //		| RETURN expr ',' expr	 ; <- 만들지 않음
    @Override
    public void exitReturn_stmt(MiniGoParser.Return_stmtContext ctx) {
        // <(4) Fill here>
    	String stmt = "";
		switch(ctx.getChildCount()) {
		case 1: // RETURN
			// GO는 RETURN을 void에서 사용안 함
			break;
		case 2: // RETURN expr의 경우
			stmt += newTexts.get(ctx.expr(0)) + "\n";
			break;
		}
		stmt += "goto label0\n";
		newTexts.put(ctx, stmt); // newTexts에 s넣어줌
    }


    // warning! Too many holes. You should check the rules rather than use them as is.
    @Override
    public void exitExpr(MiniGoParser.ExprContext ctx) {
        String expr = "";

        if(ctx.getChildCount() <= 0) {
            newTexts.put(ctx, "");
            return;
        }
        if(ctx.getChildCount() == 1) { // IDENT | LITERAL
            if(ctx.IDENT() != null) {
                String idName = ctx.IDENT().getText();
                if(symbolTable.getVarType(idName) == Type.INT) {
                	int Id = Integer.parseInt(symbolTable.getVarId(idName));
                	if (Id > 3) {
                		expr += "iload " + symbolTable.getVarId(idName) + " \n";
                	}
                	else {
                		expr += "iload_" + symbolTable.getVarId(idName) + " \n";
                	}
                }
                //else	// Type int array => Later! skip now..
                //	expr += "           lda " + symbolTable.get(ctx.IDENT().getText()).value + " \n";
            } else if (ctx.LITERAL() != null) {
                String literalStr = ctx.LITERAL().getText();
                expr += "ldc " + literalStr + " \n";
            }
        } else if(ctx.getChildCount() == 2) { // UnaryOperation
            expr = handleUnaryExpr(ctx, expr);
        } else if(ctx.getChildCount() == 3) {
            if(ctx.getChild(0).getText().equals("(")) { 		// '(' expr ')'
                expr = newTexts.get(ctx.expr(0));
            } else if(ctx.getChild(1).getText().equals("=")) { 	// IDENT '=' expr
            	expr = newTexts.get(ctx.expr(0));
            	int id = Integer.parseInt(symbolTable.getVarId(ctx.IDENT().getText()));
            	if(id > 3) {
            		expr += "istore " + Integer.toString(id) + "\n";
            	}
            	else {
            		expr += "istore_" + Integer.toString(id) + " \n";
            	}
            } else { 											// binary operation
                expr = handleBinExpr(ctx, expr);
            }
        }
        // IDENT '(' args ')' |  IDENT '[' expr ']'
        else if(ctx.getChildCount() == 4) {
            if(ctx.args() != null){		// function calls
                expr = handleFunCall(ctx, expr);
            } else { // expr
                // Arrays: TODO
            	// 배열은 없다고 가정
            }
        }
        // IDENT '[' expr ']' '=' expr
        else { // Arrays: TODO			*/
        	// 배열은 없다고 가정
        }
        newTexts.put(ctx, expr);
    }

    private String handleUnaryExpr(MiniGoParser.ExprContext ctx, String expr) {
        String l1 = symbolTable.newLabel();
        String l2 = symbolTable.newLabel();
        String lend = symbolTable.newLabel();
        

        expr += newTexts.get(ctx.expr(0));
        boolean big;
        String s [];
        if(newTexts.get(ctx.expr(0)).charAt(5) == ' ') {
        	s = newTexts.get(ctx.expr(0)).split(" ");
        	big = true;
        }
        else {
        	s = newTexts.get(ctx.expr(0)).split("_");
        	big = false;
        }
        switch(ctx.getChild(0).getText()) {
            case "-":
                expr += "ineg \n"; break;
            case "--":
                expr += "ldc 1" + "\n"
                        + "isub" + "\n";
                if(big == false) {
                	expr += "istore_" + s[1] + "\n";
                }
                else {
                	expr += "istore " + s[1] + "\n";
                }
                break;
            case "++":
                expr += "ldc 1" + "\n"
                        + "iadd" + "\n";
                if(big == false) {
                	expr += "istore_" + s[1] + "\n";
                }
                else {
                	expr += "istore " + s[1] + "\n";
                }
                break;
            case "!":
                expr += "ifeq " + l2 + "\n"
                        + l1 + ": " + "\n"
                		+ "ldc 0" + "\n"
                        + "goto " + lend + "\n"
                        + l2 + ": " + "\n"
                        + "ldc 1" + "\n"
                        + lend + ": " + "\n";
                break;
        }
        return expr;
    }

    private String handleBinExpr(MiniGoParser.ExprContext ctx, String expr) {
        String l2 = symbolTable.newLabel();
        String lend = symbolTable.newLabel();

        expr += newTexts.get(ctx.expr(0));
        expr += newTexts.get(ctx.expr(1));

        switch (ctx.getChild(1).getText()) {
            case "*":
                expr += "imul \n"; break;
            case "/":
                expr += "idiv \n"; break;
            case "%":
                expr += "irem \n"; break;
            case "+":		// expr(0) expr(1) iadd
                expr += "iadd \n"; break;
            case "-":
                expr += "isub \n"; break;

            case "==":
                expr += "isub " + "\n"
                        + "ifeq " + l2 + "\n"
                        + "ldc 0" + "\n"
                        + "goto " + lend + "\n"
                        + l2 + ": " + "\n"
                        + "ldc 1" + "\n"
                        + lend + ": " + "\n";
                break;
            case "!=":
                expr += "isub " + "\n"
                        + "ifne " + l2 + "\n"
                        + "ldc 0" + "\n"
                        + "goto " + lend + "\n"
                        + l2 + ": " + "\n"
                        + "ldc 1" + "\n"
                        + lend + ": " + "\n";
                break;
            case "<=":
                // <(5) Fill here>
            	expr += "isub " + "\n"
                        + "ifle " + l2 + "\n"
                        + "ldc 0" + "\n"
                        + "goto " + lend + "\n"
                        + l2 + ": " + "\n"
                        + "ldc 1" + "\n"
                        + lend + ": " + "\n";
                break;
            case "<":
                // <(6) Fill here>
            	expr += "isub " + "\n"
                        + "iflt " + l2 + "\n"
                        + "ldc 0" + "\n"
                        + "goto " + lend + "\n"
                        + l2 + ": " + "\n"
                        + "ldc 1" + "\n"
                        + lend + ": " + "\n";
                break;

            case ">=":
                // <(7) Fill here>
            	expr += "isub " + "\n"
                        + "ifge " + l2 + "\n"
                        + "ldc 0" + "\n"
                        + "goto " + lend + "\n"
                        + l2 + ": " + "\n"
                        + "ldc 1" + "\n"
                        + lend + ": " + "\n";
                break;

            case ">":
                // <(8) Fill here>
            	expr += "isub " + "\n"
                        + "ifgt " + l2 + "\n"
                        + "ldc 0" + "\n"
                        + "goto " + lend + "\n"
                        + l2 + ": " + "\n"
                        + "ldc 1" + "\n"
                        + lend + ": " + "\n";
                break;

            case "and":
                expr +=  "ifne "+ lend + "\n"
                        + "pop" + "\n" + "ldc 0" + "\n"
                        + lend + ": " + "\n"; break;
            case "or":
                // <(9) Fill here>
            	expr +=  "ifeq "+ lend + "\n"
                        + "pop" + "\n" + "ldc 0" + "\n"
                        + lend + ": " + "\n";
                break;

        }
        return expr;
    }
    
    private String handleFunCall(MiniGoParser.ExprContext ctx, String expr) {
        String fname = getFunName(ctx);

        if (fname.equals("_print")) {		// System.out.println	
            expr = "getstatic java/lang/System/out Ljava/io/PrintStream; " + "\n"
                    + newTexts.get(ctx.args())
                    + "invokevirtual " + symbolTable.getFunSpecStr("_print") + "\n";
        } else {
            expr = newTexts.get(ctx.args())
                    + "invokestatic " + getCurrentClassName()+ "/" + symbolTable.getFunSpecStr(fname) + "\n";
        }

        return expr;

    }

    // args	: expr (',' expr)* | ;
    @Override
    public void exitArgs(MiniGoParser.ArgsContext ctx) {

        String argsStr = "\n";

        for (int i=0; i < ctx.expr().size() ; i++) {
            argsStr += newTexts.get(ctx.expr(i)) ;
        }
        newTexts.put(ctx, argsStr);
    }

}
