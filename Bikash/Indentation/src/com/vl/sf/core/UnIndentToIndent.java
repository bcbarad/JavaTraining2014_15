package com.vl.sf.core;
import java.io.*;
public class UnIndentToIndent {
	
    public static void printSpaces(int depth, FileOutputStream out)
        throws IOException {
            out.write('\n');
            System.out.println();
            for (int i = 0; i < depth; i++) {
                out.write(' ');
                System.out.print(' ');
            }
    }
    
    public static void getIndented( FileInputStream in, FileOutputStream out) throws IOException{
        int current;
        int depth = 0;
        boolean checkNewLine=false;
        boolean skipSpace = true;
        while ((current = in.read()) != -1) {
           if (current == ' ' && skipSpace) {
                continue;
            } else if (current == '{') {
                printSpaces(depth, out);
                out.write(current);
                System.out.print((char)current);
                skipSpace = true;
                depth+=4;
            } else if (current == '}') {
                depth-=4;
                printSpaces(depth, out);
                out.write(current);
                System.out.print((char)current);
                skipSpace = true;
            } else if(current=='\n'){
                skipSpace = true;
                checkNewLine=true;
            }else{
            	if(checkNewLine){
                    printSpaces(depth, out);
            	    checkNewLine=false;
            	}
                out.write(current);
                System.out.print((char)current);
                skipSpace = false;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            //in = new FileInputStream("unIndented.txt");
            //TODO: Check that args[0] is passed
        	if(args.length>0){
        		in = new FileInputStream(args[0]);
                //TODO: Check that args[1] is passed
                out = new FileOutputStream(args[1]);
                getIndented(in, out);
        	}
            
            
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

