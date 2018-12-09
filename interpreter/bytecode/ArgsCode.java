package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class ArgsCode extends ByteCode {

    private int argNo;

    
    public ArgsCode() {

    }

    public void init(Vector<String> args) {
        try {
            argNo = Integer.parseInt(args.get(0));
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Failed to parse int for Args Code");
            System.exit(1);
        }
    }
    public void execute(VirtualMachine vm) {
        vm.newFrame(argNo);
    }
   
    public String toString() {
        return String.format("ARGS %d", argNo);
    }
}
