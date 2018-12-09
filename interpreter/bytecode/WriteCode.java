package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class WriteCode extends ByteCode {
    
    /**
     * ByteCode for outputting the topmost value on the stack
     */
    public WriteCode() {
        
    }
    
    public void init(Vector<String> args) {
        //write needs no arguments
    }
    public void execute(VirtualMachine vm) {
        int val = vm.peekRunStack();
        System.out.println(val);
    }
    public String toString() {
        return "WRITE";
    }
}
