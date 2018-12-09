package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class CallCode extends BranchCode {
   //code calls a function
    public CallCode() {

    }

    public void execute(VirtualMachine vm) {
        vm.pushAddrs(vm.getPC());
        vm.setPC(lineNo);
    }
    public String toString() {
        return "CALL " + lineNo + " (" + branchLabel + ")";
    }
}
