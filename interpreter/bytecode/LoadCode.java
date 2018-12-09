package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class LoadCode extends ByteCode {

    private int loadValue;
    private String variName = "";

    /**
     * ByteCode for loading a variable onto the top of the stack
     */
    public LoadCode() {

    }

    public void init(Vector<String> args) {
        loadValue = Integer.parseInt(args.get(0));
        variName = args.get(1);
    }

  
    public void execute(VirtualMachine vm) {
        vm.load(loadValue);
    }
    public String toString() {
        return String.format("LOAD %d %s",loadValue,variName);
    }
}
