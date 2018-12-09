package interpreter.bytecode;
import java.io.*;
import java.util.Vector;
import VirtualMachine.*;

public abstract class ByteCode {
    public ByteCode() {
        
    }
    public abstract void init(Vector<String> args);
    
    public abstract void execute(VirtualMachine vm);
}
