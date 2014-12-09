package com.vl.training.sample;
import java.io.*;
final public class FileIndentation {
    public static void main(final String[] args) throws IOException {
        //check to see whether user entered command line arguments or not
        if (args.length==0) {
            System.err.println("pass any text file as input to indent");
            return;
        }
        try {
            FileIndentation.doingIndentation(args);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void doingIndentation(final String[] args) throws IOException {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream("Output.java");
            int c,depth = 0,space = 0;
            while ((c = fin.read()) != -1) {
                char ch = (char)c;
                if (ch == '{'){
                    depth++;
                    fout.write(ch);   
                } else if (ch == '}') {
                    depth--;
                    printSpaces(depth,fout);
                    fout.write(ch);
                } else if (ch == ' ') {
                    fout.write(ch);
                } else if (ch == '\n') {
                    fout.write(ch);
                    space = 1;
                } else {      
                    if (space == 1) {
                        printSpaces(depth,fout);
                        space = 0;
                    }              
                    fout.write(ch);
                }
                
            }  
        } catch(Exception e) {
            System.out.println(e);
            throw e; 
        } finally {
            if (fin != null)
                fin.close();
            if (fout != null)
                fout.close();
        }           
    }
    public static void printSpaces(int depth , FileOutputStream fout) throws IOException {
        for (int i=0;i<4*depth;i++) { 
             fout.write(' ');
        }    
    }
}
