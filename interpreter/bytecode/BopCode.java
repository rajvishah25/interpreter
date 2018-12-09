package interpreter.bytecode;

import java.util.Vector;
import VirtualMachine.*;


public class BopCode extends ByteCode {
    
    private String binaryOp;
    
    
    public BopCode() {
        
    }
    
    public void init(Vector<String> args) {
        binaryOp = args.get(0);
    }
    public void execute(VirtualMachine vm) {
        int val2 = vm.popRunStack();
        int val1 = vm.popRunStack();
        int result = 0;
        switch (binaryOp) {
            case "+":
                result = val1 + val2;
                break;
            case "-":
                result = val1 - val2;
                break;
            case "*":
                result = val1 * val2;
                break;
            case "/":
                result = val1 / val2;
                break;
            case "==":
                if (val1 == val2) {
                    result = 1;
                }
                break;
            case "!=":
                if (val1 != val2) {
                    result = 1;
                }
                break;
            case ">=":
                if (val1 >= val2) {
                    result = 1;
                }
                break;
            case "<=":
                if (val1 <= val2) {
                    result = 1;
                }
                break;
            case ">":
                if (val1 > val2) {
                    result = 1;
                }
                break;
            case "<":
                if (val1 < val2) {
                    result = 1;
                }
                break;
            case "&":
                if (val1 == 1 && val2 == 1) {
                    result = 1;
                }
                break;
            case "|":
                if (val1 == 1 || val2 == 1) {
                    result = 1;
                }
                break;
            default:
                System.out.println("Error: Invalid Binary Op");
                System.exit(1);
        }
        vm.pushRunStack(result);
    }
    
    public String toString() {
        return "BOP " + binaryOp;
    }
}
