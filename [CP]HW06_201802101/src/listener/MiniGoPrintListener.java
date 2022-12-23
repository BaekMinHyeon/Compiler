package listener;
import generated.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MiniGoPrintListener extends MiniGoBaseListener{
	ParseTreeProperty<String> newTexts = new ParseTreeProperty<>();
	int count = 0; // 들여쓰기 필요한 개수
	
	public String PointPrint(int count) {
		String tab = "";
		for(int i = 0; i < count; i++) {
			tab += "....";
		}
		return tab;
	} // 들여쓰기 해야하는 만큼 ....을 넣어줌 ex) 1번이면 ...., 2번이면 ........
	
	@Override
	public void exitProgram(MiniGoParser.ProgramContext ctx) {
		String program = "";
		
		for(int i = 0; i < ctx.getChildCount(); i++) {
			newTexts.put(ctx, ctx.decl(i).getText()); // newText에 decl 넣어줌
			program += newTexts.get(ctx.getChild(i)); // ctx의 child를 가져와 program에 붙여줌
		}
		System.out.println(program); // 결과 출력
		File file = new File(String.format("[HW3]201802101.go")); // 파일 생성
		
		try {
			FileWriter fw = new FileWriter(file); // FileWriter 객체 생성
			fw.write(program); // 파일에 입력
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // 파싱 종료 후 결과를 파일에 써줌
	
	@Override
	public void exitDecl(MiniGoParser.DeclContext ctx) {
		String s = "";
		if(ctx.var_decl() != null) { // var_decl(변수 선언)의 경우
			s = newTexts.get(ctx.var_decl()); // ctx의 var_decl(변수 선언)를 가져와 s에 이어붙여줌
		}
		else if(ctx.fun_decl() != null) { // fun_decl(함수 선언)의 경우
			s = newTexts.get(ctx.fun_decl()); // ctx의 fun_decl(함수 선언)를 가져와 s에 이어붙여줌
		}
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	} // decl 파싱이 종료되었을 때 실행
	
	@Override
	public void exitVar_decl(MiniGoParser.Var_declContext ctx) {
		String s = newTexts.get(ctx.dec_spec()); // ctx의 dec_spec(var)을 가져와 s에 넣어줌
		s += " " + ctx.IDENT().getText(); // IDENT(식별자)를 읽어와서 s에 이어붙여줌
		
		switch(ctx.getChildCount()) { // ctx의 child의 개수
		case 3: // dec_spec IDENT type_spec의 경우
			s += newTexts.get(ctx.type_spec()); // ctx의 type_spec(타입 선언)을 가져와 s에 이어붙여줌
			break;
		case 5: // dec_spec IDENT type_spec '=' LITERAL의 경우
			s += newTexts.get(ctx.type_spec()); // ctx의 type_spec(타입 선언)을 가져와 s에 이어붙여줌
			s += " = ";
			s += ctx.LITERAL().getText(); // LITERAL을 읽어와서 s에 이어붙여줌
			break;
		case 6: // dec_spec IDENT '[' LITERAL ']' type_spec의 경우
			s += "[";
			s += ctx.LITERAL().getText(); // LITERAL을 읽어와서 s에 이어붙여줌
			s += "]";
			s += newTexts.get(ctx.type_spec()); // ctx의 type_spec(타입 선언)을 가져와 s에 이어붙여줌
			break;
		}
		s += "\n"; // 변수 선언 후 줄 바꿔주기
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void exitDec_spec(MiniGoParser.Dec_specContext ctx) {
		// VAR의 경우
		String s = ctx.VAR().getText(); // VAR(var)을 읽어와서 s에 넣어줌
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void exitType_spec(MiniGoParser.Type_specContext ctx) {
		String s = "";
		
		switch(ctx.getChildCount()) {
		case 0: // 엡실론의 경우
			break;
		case 1: // INT의 경우
			s += " " + ctx.INT().getText(); // INT(int)를 읽어와서 s에 이어붙여줌
			break;
		case 4: // '[' LITERAL ']' INT의 경우
			s += "[";
			s += ctx.LITERAL().getText(); // LITERAL를 읽어와서 s에 이어붙여줌
			s += "] ";
			s += ctx.INT().getText(); // INT(int)를 읽어와서 s에 이어붙여줌
			break;
		}
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void exitFun_decl(MiniGoParser.Fun_declContext ctx) {
		// FUNC IDENT '(' params ')' type_spec compound_stmt의 경우
		String s = ctx.FUNC().getText(); // FUNC(func)을 읽어와서 s에 넣어줌
		s += " " + ctx.IDENT().getText(); // IDENT(식별자)를 읽어와서 s에 이어붙여줌
		s += "(";
		s += newTexts.get(ctx.params()); // ctx의 params를 가져와 s에 이어붙여줌
		s += ")";
		s += newTexts.get(ctx.type_spec()); // ctx의 type_spec(타입 선언)을 가져와 s에 이어붙여줌
		s += "\n"; // {}에 들어가기 전에 줄을 내려준다
		s += newTexts.get(ctx.compound_stmt()); // ctx의 compound_stmt({}포함한 문장)을 가져와 s에 이어붙여줌
		s += "\n\n"; // 함수 종료 후 한 줄 띄어주고 함수가 시작하므로 2줄을 내려준다
		newTexts.put(ctx, s); // newTexts에 s를 넣어줌
	}
	
	@Override
	public void exitParams(MiniGoParser.ParamsContext ctx) {
		String s = "";
		switch(ctx.getChildCount()) {
		case 0: // 엡실론의 경우
			break;
		default: // param (',' param)*의 경우
			s += newTexts.get(ctx.param(0)); // ctx의 param의 첫번째를 가져와 s에 이어붙여줌
			// (',' param)* 부분
			for(int i = 1; i < ctx.param().size(); i++) {
				s += ", " + newTexts.get(ctx.param(i)); // ',' ctx의 param의 i번째를 가져와 s에 이어붙여줌
			} // *라서 몇개가 있는지 몰라 param().size()로 크기 구하고 크기만큼 반복
			break;
		}
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void exitParam(MiniGoParser.ParamContext ctx) {
		// IDENT의 경우
		String s = ctx.IDENT().getText(); // IDENT(식별자)를 읽어와서 s에 넣어줌
		switch(ctx.getChildCount()) {
		case 2: // IDENT type_spec의 경우
			s += newTexts.get(ctx.type_spec()); // ctx의 type_spec(타입 선언)을 가져와 s에 이어붙여줌
		}
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void exitStmt(MiniGoParser.StmtContext ctx) {
		String s = "";
		if(ctx.expr_stmt() != null) { // expr_stmt의 경우
			s += newTexts.get(ctx.expr_stmt()); // ctx의 expr_stmt(expr)을 가져와 s에 이어붙여줌
		}
		else if(ctx.compound_stmt() != null) { // compound_stmt의 경우
			s += "\n" + newTexts.get(ctx.compound_stmt()); // ctx의 compound_stmt를 가져와 s에 이어붙여줌
		}
		else if(ctx.if_stmt() != null) { // if_stmt의 경우
			s += newTexts.get(ctx.if_stmt()); // ctx의 if_stmt를 가져와 s에 이어붙여줌
		}
		else if(ctx.for_stmt() != null) { // for_stmt의 경우
			s += newTexts.get(ctx.for_stmt()); // ctx의 for_stmt를 가져와 s에 이어붙여줌
		}
		else if(ctx.return_stmt() != null) { // return_stmt의 경우
			s += newTexts.get(ctx.return_stmt()); // ctx의 return_stmt를 가져와 s에 이어붙여줌
		}
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void exitExpr_stmt(MiniGoParser.Expr_stmtContext ctx) {
		// expr의 경우
		String s = newTexts.get(ctx.expr()); // ctx의 expr를 가져와 s에 넣어줌
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void exitFor_stmt(MiniGoParser.For_stmtContext ctx) {
		String s = ctx.FOR().getText() + " "; // FOR(for)을 읽어와서 s에 넣어줌
		s += newTexts.get(ctx.expr()); // ctx의 expr를 가져와 s에 이어붙여줌
		s += newTexts.get(ctx.stmt()); // ctx의 stmt를 가져와 s에 이어붙여줌
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void enterCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {
		count++; // 들여쓰기 수 증가
	} // {}안에 들어감, 즉 ....이 늘어남
	
	@Override
	public void exitCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {
		// '{' local_decl* stmt* '}'의 경우
		String s = PointPrint(count-1) + "{\n"; // 괄호 열음
		
		// local_delc* 부분
		for(int i = 0; i < ctx.local_decl().size(); i++) {
			s += PointPrint(count) + newTexts.get(ctx.local_decl(i)); // 들여쓰기 후 ctx의 local_decl(지역 변수 선언)를 가져와 s에 이어붙여줌
		} // *라서 몇개가 있는지 몰라 local_decl().size()로 크기 구하고 크기만큼 반복
		
		// stmt* 부분
		for(int i = 0; i < ctx.stmt().size(); i++) {
			s += PointPrint(count) + newTexts.get(ctx.stmt(i)) + "\n"; // 들여쓰기 후 ctx의 stmt를 가져와 s에 이어붙여주고 1줄 내림
		} // *라서 몇개가 있는지 몰라 stmt().size()로 크기 구하고 크기만큼 반복
		
		s += PointPrint(count-1) + "}"; // 괄호 닫음
		newTexts.put(ctx, s); // newTexts에 s넣어줌
		count--; // 들여쓰기 수 감소
	}
	
	@Override
	public void exitLocal_decl(MiniGoParser.Local_declContext ctx) {
		// var_decl의 경우
		String s = newTexts.get(ctx.var_decl()); // ctx의 var_decl(변수 선언)을 가져와 s에 넣어줌
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void exitIf_stmt(MiniGoParser.If_stmtContext ctx) {
		// IF expr stmt의 경우
		String s = ctx.IF().getText(); // IF(if)를 읽어와서 s에 넣어줌
		s += " " + newTexts.get(ctx.expr()); // ctx의 expr을 가져와 s에 이어붙여줌
		s += newTexts.get(ctx.stmt(0)); // ctx의 stmt의 0번째를 가져와 s에 이어붙여줌
		
		switch(ctx.getChildCount()) {
		case 5: // IF expr stmt ELSE stmt의 경우
			s += "\n"; // else를 시작할 때 한줄 내려줌
			s += PointPrint(count) + ctx.ELSE().getText(); // 들여쓰기 후 ELSE(else)를 읽어와서 s에 이어붙여줌
			s += newTexts.get(ctx.stmt(1)); // ctx의 stmt의 1번째를 가져와 s에 이어붙여줌
			break;
		}
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
		
	@Override
	public void exitReturn_stmt(MiniGoParser.Return_stmtContext ctx) {
		// RETURN의 경우
		String s = ctx.RETURN().getText(); // RETURN(return)을 읽어와서 s에 넣어줌
		switch(ctx.getChildCount()) {
		case 2: // RETURN expr의 경우
			s += " " + newTexts.get(ctx.expr(0)); // ctx의 expr의 0번쨰를 가져와 s에 이어붙여줌
			break;
		case 4: // RETURN expr ',' expr의 경우
			s += " " + newTexts.get(ctx.expr(0)); // ctx의 expr의 0번째를 가져와 s에 이어붙여줌
			s += ", ";
			s += newTexts.get(ctx.expr(1)); // ctx의 expr의 1번째를 가져와 s에 이어붙여줌
			break;
		}
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
	@Override
	public void exitExpr(MiniGoParser.ExprContext ctx) {
		String s = "";
		switch(ctx.getChildCount()) {
		case 1: // (LITERAL|IDENT)의 경우
			if(ctx.LITERAL() != null) { // LITERAL의 경우
				s += ctx.LITERAL().getText(); // LITERAL를 읽어와서 s에 이어붙여줌
			}
			else if(ctx.IDENT() != null) { // IDENT의 경우
				s += ctx.IDENT().getText(); // IDENT(식별자)를 읽어와서 s에 이어붙여줌
			}
			break;
		case 2:
			// op=('-'|'+'|'--'|'++'|'!') expr의 경우
			s += ctx.op.getText(); // op(단항연산자)를 읽어와서 s에 이어붙여줌
			s += newTexts.get(ctx.expr(0)); // ctx의 expr의 0번째를 가져와 s에 이어붙여줌
			break;
		case 3:
			if(ctx.IDENT() != null) {
				// IDENT '=' expr의 경우
				s += ctx.IDENT().getText(); // IDENT(식별자)를 읽어와서 s에 이어붙여줌
				s += " = ";
				s += newTexts.get(ctx.expr(0)); // ctx의 expr의 0번째를 가져와 s에 이어붙여줌
			}
			else {
				if(ctx.expr().size() == 1) {
					// '(' expr ')'의 경우
					s += "(";
					s += newTexts.get(ctx.expr(0)); // ctx의 expr의 0번째를 가져와 s에 이어붙여줌
					s += ")";
				}
				else {
					// left=expr op=('*'|'/'|'%'|'+'|'-') right=expr의 경우
					// left=expr op=(EQ|NE|LE|'<'|GE|'>'|AND|OR) right=expr의 경우
					s += newTexts.get(ctx.expr(0)); // ctx의 expr의 0번쨰를 가져와 s에 이어붙여줌
					s += " " + ctx.op.getText(); // op(연산자)를 읽어와서 s에 이어붙여줌
					s += " " + newTexts.get(ctx.expr(1)); // ctx의 expr의 1번째를 가져와 s에 이어붙여줌
				}
			}
			break;
		case 4:
			s += ctx.IDENT().getText(); // IDENT(식별자)를 읽어와서 s에 이어붙여줌
			if(ctx.getChild(2).equals(ctx.expr(0))) {
				// IDENT '[' expr ']'의 경우
				s += "[";
				s += newTexts.get(ctx.expr(0)); // ctx의 expr의 0번째를 가져와 s에 이어붙여줌
				s += "]";
			}
			else if(ctx.getChild(2).equals(ctx.args())){
				// IDENT '(' args ')'의 경우
				s += "(";
				s += newTexts.get(ctx.args()); // ctx의 args를 가져와 s에 이어붙여줌
				s += ")";
			}
			break;
		case 6:
			// IDENT '[' expr ']' '=' expr의 경우
			s += ctx.IDENT().getText(); // IDENT(식별자)를 읽어와서 s에 이어붙여줌
			s += "[";
			s += newTexts.get(ctx.expr(0)); // ctx의 expr의 0번쨰를 가져와 s에 이어붙여줌
			s += "]";
			s += " = ";
			s += newTexts.get(ctx.expr(1)); // ctx의 expr의 1번째를 가져와 s에 이어붙여줌
			break;
		}
		newTexts.put(ctx, s); // newTexts에 s넣어줌
			
	}
	
	@Override
	public void exitArgs(MiniGoParser.ArgsContext ctx) {
		String s = "";
		switch(ctx.getChildCount()) {
		case 0: // 엡실론의 경우
			break;
		default: // expr (',' expr)*의 경우
			s += newTexts.get(ctx.expr(0)); // ctx의 expr의 0번째를 가져와 s에 이어붙여줌
			// (',' expr)* 부분
			for(int i = 1; i < ctx.expr().size(); i++) {
				s += ", ";
				s += newTexts.get(ctx.expr(i)); // ctx의 expr의 i번째를 가져와 s에 이어붙여줌
			} // *라서 몇개가 있는지 몰라 expr().size()로 크기 구하고 크기만큼 반복
			break;
		}
		newTexts.put(ctx, s); // newTexts에 s넣어줌
	}
	
}
