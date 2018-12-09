package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class LabelCode extends BranchCode {
    
    /**
     * ByteCode for designating a specific place in the Program for branching
     */
    public LabelCode() {
        
    }
   
    public void execute(VirtualMachine vm) {
        //label is only a target for falsebranch and goto, it does nothing on its own
    }
    public String toString() {
        return "LABEL " + branchLabel;
    }
}