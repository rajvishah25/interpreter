package program;

import interpreter.bytecode.*;
import java.util.*;

public class Program extends Object {

    private ArrayList<ByteCode> list;
    private HashMap<String, Integer> addresses;
    private int byteCodeNumber;

  
    public Program() {
        list = new ArrayList<>();
        byteCodeNumber = 0;
        addresses = new HashMap<>();
    }

    //adds a bytecode to program class
    public void addCode(ByteCode code) {
        if (code instanceof interpreter.bytecode.LabelCode) {
//gets the label
        	BranchCode branch = (BranchCode) code;
        	//adds label to addresses with line no
            addresses.put(branch.getLabel(), byteCodeNumber);
        }
        byteCodeNumber++;
        list.add(code);
    }

    public ByteCode getCode(int index) {
        return list.get(index);
    }

    
    public void resolveAddress() {
    	
        for (int i = 0; i < byteCodeNumber; i++) {
            if (list.get(i) instanceof interpreter.bytecode.FalseBranchCode || list.get(i) instanceof interpreter.bytecode.GotoCode || 
                    list.get(i) instanceof interpreter.bytecode.CallCode)
            {
                BranchCode bc = (BranchCode) list.get(i);
                int address = addresses.get(bc.getLabel());
                bc.setLineNo(address);
            }
        }
       System.out.println("resolved Bytecode Vector");
        for(int i =0;i<list.size();i++)
        	
        System.out.println(this.list.get(i));
    }
}
