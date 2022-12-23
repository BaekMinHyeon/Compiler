package listener;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import generated.MiniGoParser;
import generated.MiniGoParser.*;
import listener.SymbolTable.Type;
import static listener.BytecodeGenListenerHelper.*;


public class SymbolTable {
	enum Type {
		INT, INTARRAY, VOID, ERROR
	}
	
	static public class VarInfo {
		Type type; 
		int id;
		int initVal;
		
		public VarInfo(Type type,  int id, int initVal) {
			this.type = type;
			this.id = id;
			this.initVal = initVal;
		}
		public VarInfo(Type type,  int id) {
			this.type = type;
			this.id = id;
			this.initVal = 0;
		}
	}
	
	static public class FInfo {
		public String sigStr;
	}
	
	private Map<String, VarInfo> _lsymtable = new HashMap<>();	// local v.
	private Map<String, VarInfo> _gsymtable = new HashMap<>();	// global v.
	private Map<String, FInfo> _fsymtable = new HashMap<>();	// function 
		
	private int _globalVarID = 0;
	private int _localVarID = 0;
	private int _labelID = 0;
	private int _tempVarID = 0;
	
	SymbolTable(){
		initFunDecl();
		initFunTable();
	}
	
	void initFunDecl(){		// at each func decl
		_localVarID = 0;
		_labelID = 0;
		_tempVarID = 32;		
	}
	
	void putLocalVar(String varname, Type type){
		//<Fill here>
		VarInfo var = new VarInfo(type, _localVarID++);
		_lsymtable.put(varname, var);
	}
	
	void putGlobalVar(String varname, Type type){
		//<Fill here>
		VarInfo var = new VarInfo(type, _globalVarID++);
		_gsymtable.put(varname, var);
	}
	
	void putLocalVarWithInitVal(String varname, Type type, int initVar){
		//<Fill here>
		VarInfo var = new VarInfo(type, _localVarID++, initVar);
		_lsymtable.put(varname, var);
	}
	
	void putGlobalVarWithInitVal(String varname, Type type, int initVar){
		//<Fill here>
		VarInfo var = new VarInfo(type, _globalVarID++, initVar);
		_gsymtable.put(varname, var);
	}
	
	void putParams(MiniGoParser.ParamsContext params) {
		for(int i = 0; i < params.param().size(); i++) {
		//<Fill here>
			// 수정 필요
			String varname = getParamName(params.param(i));
			Type type = Type.VOID; // 기본 앱실론 type void
			
			if(getTypeText(params.param(i).type_spec()).equals("I")) {
				type = Type.INT;
			}
			else if(getTypeText(params.param(i).type_spec()).equals("[I")) {
				type = Type.INTARRAY;
			}
			
			putLocalVar(varname, type);
		}
	}
	
	private void initFunTable() {
		FInfo printlninfo = new FInfo();
		printlninfo.sigStr = "java/io/PrintStream/println(I)V";
		
		FInfo maininfo = new FInfo();
		maininfo.sigStr = "main([Ljava/lang/String;)V";
		_fsymtable.put("_print", printlninfo);
		_fsymtable.put("main", maininfo);
	}
	
	public String getFunSpecStr(String fname) {		
		// <Fill here>
		return _fsymtable.get(fname).sigStr;
	}

	public String getFunSpecStr(Fun_declContext ctx) {
		// <Fill here>	
		String fname = getFunName(ctx);
		return _fsymtable.get(fname).sigStr;
	}
	
	public String putFunSpecStr(Fun_declContext ctx) {
		String fname = getFunName(ctx);
		String argtype = "";	
		String rtype = "";
		String res = "";
		
		// <Fill here>
		argtype = getParamTypesText(ctx.params());
		rtype = getTypeText(ctx.type_spec());
		
		res =  fname + "(" + argtype + ")" + rtype;
		
		FInfo finfo = new FInfo();
		finfo.sigStr = res;
		_fsymtable.put(fname, finfo);
		
		return res;
	}
	
	String getVarId(String name){
		// <Fill here>	
		VarInfo lvar = (VarInfo) _lsymtable.get(name);
		if (lvar != null) {
			return Integer.toString(lvar.id);
		}
		
		VarInfo gvar = (VarInfo) _gsymtable.get(name);
		if (gvar != null) {
			return Integer.toString(gvar.id);
		}
		
		return "";	
	}
	
	Type getVarType(String name){
		VarInfo lvar = (VarInfo) _lsymtable.get(name);
		if (lvar != null) {
			return lvar.type;
		}
		
		VarInfo gvar = (VarInfo) _gsymtable.get(name);
		if (gvar != null) {
			return gvar.type;
		}
		
		return Type.ERROR;	
	}
	
	String newLabel() {
		return "label" + ++_labelID;
	}
	
	String newTempVar() {
		String id = "";
		return id + _tempVarID--;
	}

	// global
	public String getVarId(Var_declContext ctx) {
		// <Fill here>	
		return getVarId(ctx.IDENT().getText());
	}

	// local
	public String getVarId(Local_declContext ctx) {
		// <Fill here>
		return getVarId(ctx.var_decl().IDENT().getText());
	}
}
