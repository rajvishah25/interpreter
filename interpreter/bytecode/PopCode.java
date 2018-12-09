package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class PopCode extends ByteCode {
    
    private int popNum;
    
    /**
     * ByteCode for popping the designated number of values from the stack
     */
    public PopCode() {
        
    }
    
    public void init(Vector<String> args) {
        popNum = Integer.parseInt(args.get(0));
    }
   
    public void execute(VirtualMachine vm) {
        for (int i = 0; i < popNum; i++) {
            vm.popRunStack();
        }
    }
    public String toString() {
        return String.format("POP %s",popNum);
    }
}
