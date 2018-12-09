package codetable;
import java.util.*;


public class CodeTable extends Object {

    private static HashMap<String, String> CLASS_NAMES;
    
   //Codetable has all  class names of bytecodes within a hashtable. 
    //The hashtable creates instances of classes according to file.
   
    private CodeTable() {
        CodeTable.CLASS_NAMES = new HashMap<>();
        CodeTable.CLASS_NAMES.put("HALT", "HaltCode");
        CodeTable.CLASS_NAMES.put("POP", "PopCode");
        CodeTable.CLASS_NAMES.put("BOP", "BopCode");
        CodeTable.CLASS_NAMES.put("READ", "ReadCode");
        CodeTable.CLASS_NAMES.put("WRITE", "WriteCode");
        CodeTable.CLASS_NAMES.put("LABEL", "LabelCode");
        CodeTable.CLASS_NAMES.put("DUMP", "DumpCode");
        CodeTable.CLASS_NAMES.put("STORE", "StoreCode");
        CodeTable.CLASS_NAMES.put("LOAD", "LoadCode");
        CodeTable.CLASS_NAMES.put("LIT", "LitCode");
        CodeTable.CLASS_NAMES.put("FALSEBRANCH", "FalseBranchCode");
        CodeTable.CLASS_NAMES.put("GOTO", "GotoCode");
        CodeTable.CLASS_NAMES.put("ARGS", "ArgsCode");
        CodeTable.CLASS_NAMES.put("CALL", "CallCode");
        CodeTable.CLASS_NAMES.put("RETURN", "ReturnCode");
    }
    
    public static String get(String code) {
        return CodeTable.CLASS_NAMES.get(code);
    }
    
    public static void init() {
        CodeTable table = new CodeTable();
    }
}
