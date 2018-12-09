package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class GotoCode extends BranchCode {
    
   
    public GotoCode() {
        
    }
    public void execute(VirtualMachine vm) {
        vm.setPC(lineNo);
    }
    
    public String toString() {
        return "GOTO " + lineNo + " (" + branchLabel + ")";
    }
}
