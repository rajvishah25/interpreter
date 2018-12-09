package interpreter.bytecode;

import java.util.Vector;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import VirtualMachine.*;

public class ReadCode extends ByteCode {

    /**
     * ByteCode for prompting the user for input
     */
    public ReadCode() {

    }

    public void init(Vector<String> args) {
       //since no arguments
    }


    public void execute(VirtualMachine vm) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = in.readLine();
            int val = Integer.parseInt(line);
            vm.pushRunStack(val);
        } catch (Exception ex) {
            System.out.println("Failed to read input correctly: " + ex);
            System.exit(1);
        }
    }
    
    public String toString() {
        return "READ";
    }
}
