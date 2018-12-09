package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;

public class ReturnCode extends ByteCode {
    
    private String returnAddress = "";
    
    public ReturnCode() {
        
    }
    
    public void init(Vector<String> args) {
        if (args.size() > 0) {
            returnAddress = args.get(0);
        }
    }
    public void execute(VirtualMachine vm) {
        int newPC = vm.popAddrs();
        vm.popFrame();
        vm.setPC(newPC);
    }
    
   
    public String toString() {
        return "RETURN " + returnAddress;
    }
}
