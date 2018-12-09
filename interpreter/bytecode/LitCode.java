package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class LitCode extends ByteCode {
    
    private int literal;
    private String variName = "";
   
    public LitCode() {
        
    }
    
    public void init(Vector<String> args) {
        literal = Integer.parseInt(args.get(0));
        if (args.size() == 2) {
            variName = args.get(1);
        }
    }
    public void execute(VirtualMachine vm) {
        vm.pushRunStack(literal);
    }
 
    public String toString() {
        return String.format("LIT %d %s",literal,variName);
    }
}
