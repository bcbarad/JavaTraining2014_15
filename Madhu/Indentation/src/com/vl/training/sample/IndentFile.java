//package com.vl.training.sample;
import java.io.*; 
public class IndentFile {
    private IndentFile() {
    }
    public static void main(String[] args) {
        try {
            FileReader input = null;
            FileWriter output = null;
            if(args.length < 1) {
                System.out.println("Please make sure that pass an input text file");
            } else {
                input = new FileReader(args[0]);
                output = new FileWriter(args[1]);
                IndentFile.changeIndentation(input , output);
            }
        } catch (IOException ie) {
            System.out.println(ie);
        }
    }
    public static void changeIndentation(FileReader input , FileWriter output) throws IOException  {
        try {
            int c, depth = 0;
            boolean checkspace = false;
            while ((c = input.read()) != -1) {
                char ch = (char) c;
                if (ch == '/' || ch == '\'' || ch == '"') {
                    ch = IndentFile.checkConditions(input , output , ch);
                }
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
                        IndentFile.printSpaces(depth , output);                   
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
    public static void printSpaces(int depth , FileWriter output) throws IOException {
        for (int i = 0; i < depth; i++) {
            output.write(' ');
        }
    }
    public static  char checkConditions(FileReader input , FileWriter output , char ch) throws IOException {
        output.write(ch);
        ch=(char)input.read();
        if(ch == '/') {
            while(ch != '\n') {
                output.write(ch);
                ch = (char) input.read();
            }
        } 
        else if( ch == '*') {
            output.write(ch);
            ch = (char) input.read();
            char nextch=(char)input.read();
            while(ch!='*' && nextch!='/') {
                output.write(ch);
                ch = nextch;
                nextch = (char)input.read();
            }
            output.write(ch);
            output.write(nextch);
            ch = (char)input.read();
        } else {
            while(ch != '\'' && ch!='"') {
                output.write(ch);
                ch=(char) input.read();
             }
             output.write(ch);
             ch=(char) input.read();
        }
        return ch;
    }
}











