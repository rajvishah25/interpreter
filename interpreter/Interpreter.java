package interpreter;

import codetable.*;
import java.io.IOException;
import bytecodeloader.*;
import program.*;
import VirtualMachine.*;

public class Interpreter {

    ByteCodeLoader bytecodeloader;

    public Interpreter(String codeFile) {
        try {
            CodeTable.init();
            bytecodeloader = new ByteCodeLoader(codeFile);
        } catch (IOException e) {
            System.out.println("**** " + e);
        }
    }

    void run() {
        Program program = bytecodeloader.loadCodes();
        VirtualMachine vm = new VirtualMachine(program);
        vm.executeProgram();
    
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("**Incorrect usage, use java interpreter.Interpreter <file>**");
            System.exit(1);
        }
        (new Interpreter(args[0])).run();
    }
}
