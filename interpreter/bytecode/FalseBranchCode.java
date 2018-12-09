package interpreter.bytecode;

import VirtualMachine.*;

public class FalseBranchCode extends BranchCode {
    
   
    public FalseBranchCode() {

    }
    public void execute(VirtualMachine vm) {
        int val = vm.popRunStack();
        if (val == 0) {
            vm.setPC(lineNo);
        }
    }
  
    
    public String toString() {
        return "FALSEBRANCH " + lineNo + " (" + branchLabel + ")";
    }
}
