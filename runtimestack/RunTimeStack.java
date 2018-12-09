package runtimestack;

import java.util.Vector;
import java.util.Stack;


public class RunTimeStack {
    protected Vector<Integer> runStack;
    protected Stack<Integer> framePointers;
    
    
    //Data handling during runtime
    public RunTimeStack() {
        runStack = new Vector();
        framePointers = new Stack();
        framePointers.push(0);
    }
    
   //DUMPS RUNTIME STACK INFO
    public void dump() {
        System.out.print("[ ");
        for (int i = 0; i < runStack.size(); i++) {
            System.out.print(runStack.get(i) + " ");
            if (framePointers.contains(i+1)) {
                System.out.print("] [ ");
            }
        }
        System.out.println("]");
    }
    
    //RETURNS TOP OF RUNSTACK
    public int peek() {
        return runStack.lastElement();
    }
    
   //POPS THE TOP ELEMENT OF RUN TIME STACK
    public int pop() {
        int temp = runStack.lastElement();
        runStack.remove(runStack.size()-1);
        return temp;
    }
    
    
    public int push(int i) {//pushes integer i on stack
        runStack.add(i);
        return i;
    }
    
    //starts new frame
    public void newFrameAt(int offset) {
        framePointers.push(runStack.size() - offset);
    }
    
    //pops top frame
    public void popFrame() {
        int frames = framePointers.pop();
        for (int i = runStack.size()-2; i >= frames; i--) {
            runStack.removeElementAt(i);
        }
    }
    
  // used to store vakues inside variables
    public int store(int offset) {
        int val = runStack.remove(runStack.size()-1);
        runStack.set(framePointers.peek()+offset, val);
        return val;
    }
    
    //loads variables on stack
    public int load(int offset) {
        int val = runStack.get(framePointers.peek()+offset);
        runStack.add(val);
        return val;
    }
    
    //loads literals on stack
    public Integer push(Integer i) {
        runStack.add(i);
        return i;
    }
}
