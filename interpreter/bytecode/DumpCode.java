/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.bytecode;
import java.util.Vector;
import VirtualMachine.*;


public class DumpCode extends ByteCode {
    
    private String dump;
    
   
    public DumpCode() {
        
    }
    
    public void init(Vector<String> args) {
        dump = args.get(0);
    }
    public void execute(VirtualMachine vm) {
        if (dump.equals("ON")) {
            vm.dumpON();
        } else {
            vm.dumpOFF();
        }
    }
    
    public String toString() {
        return "DUMP " + dump;
    }
}
