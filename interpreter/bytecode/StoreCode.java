package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class StoreCode extends ByteCode {
    
    private int value;
    private String id;
    
    /**
     * ByteCode for storing data into variables on the stack
     */
    public StoreCode() {
        
    }
    
    public void init(Vector<String> args) {
        value = Integer.parseInt(args.get(0));
        id = args.get(1);
    }
    public void execute(VirtualMachine vm) {
        vm.store(value);
    }
 
    public String toString() {
        return String.format("STORE %d %s", value, id);
    }
}
