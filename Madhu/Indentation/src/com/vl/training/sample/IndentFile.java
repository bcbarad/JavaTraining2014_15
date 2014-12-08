package com.vl.training.sample;
import java.io.*; 
public class IndentFile {
    private IndentFile() {
    }
    public static void main(String[] args) {
        try {
            IndentFile.changeIndentation(args);
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }
    public static void changeIndentation(String[] args) throws IOException  {
        FileReader input = null;
        FileWriter output = null;
        try {
            input = new FileReader(args[0]);
            output = new FileWriter("output.txt");
            int c, depth = 0;
            boolean checkspace = false;
            while ((c = input.read()) != -1) {
                char ch = (char) c;
                if (ch == '{') {
                    depth += 4;
                    output.write(ch);
                    
                } else if (ch == '}') {
                    depth -= 4;
                    for (int i = 0; i < depth; i++) {
                        output.write(" ");
                    }
                    output.write(ch);
                } else if (ch == ' ') {
                    if (!checkspace) {
                        output.write(' ');
                    }
                } else if (ch == '\n') {
                    output.write(ch);
                    checkspace = true;
                } else {
                    if (checkspace) {
                        for (int i = 0; i < depth; i++) {
                            output.write(' ');
                        }
                        checkspace = false;
                    }
                    output.write(ch);
                }
            }
        } catch (IOException ie) {
            System.out.println(ie);
        }  finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}











