package VirtualMachine;
import program.*;
import runtimestack.*;
import java.util.Stack;
import interpreter.bytecode.*;

public class VirtualMachine {
    private Program program;
    private Stack<Integer> returnAddress;
    private boolean isRunning;
    private RunTimeStack runStack;
    private boolean dump_Switch = true;
    private int pc;

    
    
    public VirtualMachine(Program prog) {
        program = prog;
    }
    
 
     //executeProgram executes program in VM
    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddress = new Stack();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if (dump_Switch) {
                System.out.println(pc + "  " + code.toString());
                runStack.dump(); 
            }
            pc++;
        }
    }
    
    public int getPC() {
        return pc;
    }
    
    
    public void setPC(int val) {
        pc = val;
    }
    
    
    //pushes a return address onto return addresses
    public void pushAddrs(int address) {
        returnAddress.push(address);
    }
    
    
    //pops a returnaddress
    public int popAddrs() {
        int addrs = returnAddress.pop();
        return addrs;
    }
    
    
    public void halt() {//halts the VM
        isRunning = false;
    }
    
   
    //pops from the top of runtime stack and returns the values
    public int popRunStack() {
        return runStack.pop();
    }
    
    
    //pushes values on runtimestack
    public void pushRunStack(int val) {
        runStack.push(val);
    }
    
   
    //peeks at top of runtime stack and returns values
    public int peekRunStack() {
        return runStack.peek();
    }
    
    //offsets values form top that makes up the frame
    public void newFrame(int offset) {
        runStack.newFrameAt(offset);
    }
    
   //pops the top of frame
    public void popFrame() {
        runStack.popFrame();
    }
   
    //stores values in variables
    public int store(int val) {
        return runStack.store(val);
    }
    

    //loads variables in stack and returns values on top of stack
    public int load(int val) {
        return runStack.load(val);
    }
    
    //dump switched on
    public void dumpON() {
        dump_Switch = true;
    }
   //dump switched off
    public void dumpOFF() {
        dump_Switch = false;
    }
}
