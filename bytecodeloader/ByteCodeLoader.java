package bytecodeloader;

import java.io.*;
import java.util.*;
import program.*;
import codetable.*;
import interpreter.bytecode.*;


public class ByteCodeLoader extends Object {

    private BufferedReader buffer;
    private String nextline;
    Vector<ByteCode> alist = new Vector<>();

    /**
     * The ByteCodeLoader loads a ByteCode file and creates instances of ByteCode
     * classes accordingly.
     * @param programFile the filename of the ByteCode file to be read
     * @throws IOException in case opening the buffer fails
     */
    public ByteCodeLoader(String programFile) throws IOException {
        try {
            this.buffer = new BufferedReader(new FileReader(programFile));
        } catch (Exception e) {
            System.out.println("Failed to open file: " + programFile);
        }
    }

    
    //loadcode method to load ByteCode classes into a Program object
     
     
    public Program loadCodes() {
        Program prog = new Program();

        try {
            nextline = buffer.readLine(); //read first line
            while (nextline != null) { //while there is still text being read
                //read first word
                StringTokenizer tokens = new StringTokenizer(nextline);
                String codetoken = tokens.nextToken();
                //look up in codetable
                String codename = CodeTable.get(codetoken);
                //create correct bytecode class
                ByteCode bytecode = (ByteCode) (Class.forName("interpreter.bytecode." + codename).newInstance());
                //read rest of the line for args
                this.alist.add(bytecode);
                Vector<String> args = new Vector<>();
                while (tokens.hasMoreTokens()) {
                    codetoken = tokens.nextToken();
                    args.add(codetoken);
                }
                //initialize class w/ args
                bytecode.init(args);
                //add to program
                prog.addCode(bytecode);
                
                //read next line
                nextline = buffer.readLine();
            }
          System.out.println("Actual addresses of bytecode vector");

            for(int i =0;i<alist.size();i++)
            System.out.println(this.alist.get(i));

            
            prog.resolveAddress();
        } catch (Exception e) {
            System.out.println("There was an error reading the program.");
            return null;
        }

        // return programs
                return prog;
    }
}
