
package interpreter.bytecode;
import java.util.*;
import VirtualMachine.*;


public abstract class BranchCode extends ByteCode {
    protected int lineNo;
    protected String branchLabel;
    
    public String getLabel() {
        return branchLabel;
    }
    
    public int getLineNo() {
        return lineNo;
    }
    
    public void setLineNo(int no) {
        lineNo = no;
    }
    
    public void init(Vector<String> args) {
        branchLabel = args.get(0);
    }
    
}
