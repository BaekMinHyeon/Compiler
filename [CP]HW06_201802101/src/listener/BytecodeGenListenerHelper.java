package listener;

import java.util.Hashtable;

import generated.MiniGoParser;
import generated.MiniGoParser.*;
import listener.SymbolTable;
import listener.SymbolTable.VarInfo;

public class BytecodeGenListenerHelper {
	
	// <boolean functions>
	
	static boolean isFunDecl(MiniGoParser.ProgramContext ctx, int i) {
		return ctx.getChild(i).getChild(0) instanceof MiniGoParser.Fun_declContext;
	}
	
	static boolean isArrayDecl(MiniGoParser.Var_declContext ctx) {
		return ctx.getChildCount() == 6;
	}
	
	static boolean isDeclWithInit(MiniGoParser.Var_declContext ctx) {
		return ctx.getChildCount() == 5 ;
	}

	// <information extraction>
	static String getStackSize(Fun_declContext ctx) {
		return "32";
	}
	static String getLocalVarSize(Fun_declContext ctx) {
		return "32";
	}
	
	static String getTypeText(Type_specContext typespec) {
			// <Fill in>
		switch(typespec.getChildCount()) {
		case 0: // 앱실론
			return "V";
		case 1: // INT
			return "I";
		default:
			return "[I";
		}
	}

	// params
	static String getParamName(ParamContext param) {
		// <Fill in>
		return param.IDENT().getText();
	}
	
	static String getParamTypesText(ParamsContext params) {
		String typeText = "";
		
		for(int i = 0; i < params.param().size(); i++) {
			MiniGoParser.Type_specContext typespec = (MiniGoParser.Type_specContext)  params.param(i).getChild(1);
			typeText += getTypeText(typespec); // + ";";
		}
		return typeText;
	}
	
	static String getLocalVarName(Local_declContext local_decl) {
		// <Fill in>
		return local_decl.var_decl().IDENT().getText();
	}
	
	static String getFunName(Fun_declContext ctx) {
		// <Fill in>
		return ctx.IDENT().getText();
	}
	
	static String getFunName(ExprContext ctx) {
		// <Fill in>
		return ctx.IDENT().getText();
	}
	
	static boolean noElse(If_stmtContext ctx) {
		return ctx.getChildCount() < 5;
	}
	
	static String getFunProlog() {
		return ".class public Test" + "\n"
				+ ".super java/lang/Object" + "\n\n";
	}
	
	static String getCurrentClassName() {
		return "Test";
	}
}
