package interpreter.bytecode;
import java.util.Vector;
import VirtualMachine.*;


public class HaltCode extends ByteCode {
    
    /**
     * ByteCode for halting the Virtual Machine
     */
    public HaltCode() {
        
    }
    
    public void init(Vector<String> args) {
        //haltcode accepts no args, so do nothing
    }
    
      public void execute(VirtualMachine vm) {
        vm.halt();
    }
    
    public String toString() {
        return "HALT";
    }
}
