package com.vl.sf.core;

import java.io.*;

public class UnIndentToIndent {
    public static void printSpaces(int depth, FileOutputStream out) throws IOException {
        out.write('\n');
	for (int i = 0; i < depth; i++) {
	    out.write(' ');
	}
    }

    public static void getIndented(FileInputStream in, FileOutputStream out) throws IOException {
        int current;
	int depth = 0;
	boolean checkNewLine = false;
	boolean skipSpace = true;
	while ((current = in.read()) != -1) {
	    if (current == ' ' && skipSpace) {
	        continue;
	    } else if (current == '/') {
	        out.write(current);
		if ((current = in.read()) == '/') {// logic for single line comment
		    do{
		        out.write(current);
		    }while ((current = in.read()) != '\n'); 
		    out.write(current);
		} else if (current == '*') {// logic for multiline line comment
		    out.write(current);
		    int next = 0;
		    while ((current = in.read()) != -1) {
		        if (current == '*' && (next = in.read()) != -1 && next == '/') {
			    out.write(current);
			    out.write(next);
			    break;
		        } else {
			    out.write(current);
			}
		    }
	        }
		} else if (current == '"') {// logic for multiline line comment
		    out.write(current);
		    while ((current = in.read()) != '"') {
		        out.write(current);
		    }
		    out.write(current);
		    checkNewLine = false;
		} else if (current == '{') {
	            printSpaces(depth, out);
		    out.write(current);
		    skipSpace = true;
		    depth += 4;
		    checkNewLine = false;
		} else if (current == '}') {
		    depth -= 4;
		    printSpaces(depth, out);
		    out.write(current);
	            skipSpace = true;
		    checkNewLine = false;
		} else if (current == '\n') {
		    skipSpace = true;
		    checkNewLine = true;
		} else {
		    if (checkNewLine) {
		        printSpaces(depth, out);
			checkNewLine = false;
		    }
		    out.write(current);
		    skipSpace = false;
		}
	}
    }

    public static void main(String args[]) throws IOException {
        FileInputStream in = null;
	FileOutputStream out = null;
	try {
	    if (args.length > 0) {
	        // TODO: Check that args[0] is passed
		in = new FileInputStream(args[0]);
		// TODO: Check that args[1] is passed
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
