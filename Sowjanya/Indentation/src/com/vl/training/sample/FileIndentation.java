package com.vl.training.sample;
import java.io.*;
final public class FileIndentation {
    private FileIndentation() {
    }
    public static void main(final String[] args) throws IOException {
        //check to see whether user entered command line arguments or not
        if (args.length == 0) {
            System.err.println("pass any text file as input to indent");
            return;
        }
        try {
            //pass args[0] as input file
            FileInputStream fin = new FileInputStream(args[0]);
            //pass args[1] as output file
            FileOutputStream fout = new FileOutputStream(args[1]);
            //do indentation by calling method
            FileIndentation.doingIndentation(fin , fout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void doingIndentation(final FileInputStream fin , final FileOutputStream fout) throws IOException {
        try {
            while (fin.available() > 0) {
                int c , depth = 0 , space = 0;
                while ((c = fin.read()) != -1) {
                    char ch = (char) c;
                    if (ch == '{') {
                        depth++;
                        fout.write(ch);
                    } else if (ch == '}') {
                        depth--;
                        printSpaces(depth , fout);
                        fout.write(ch);
                    } else if (ch == ' ') {
                        if (space == 0) {
                            fout.write(ch);
                        }
                    } else if (ch == '/') {
                        printSpaces(depth , fout);
                        fout.write(ch);
                        if ((ch = (char) fin.read()) == '/') {
                            fout.write(ch);
                            char nextc = (char) fin.read();
                            while (nextc != '\n') {
                                fout.write(nextc);
                                nextc = (char) fin.read();
                            }
                            fout.write(nextc);
                        }
                        if (ch == '*') {
                            fout.write(ch);
                            char nextch1 = (char) fin.read();
                            char nextch2 = (char) fin.read();
                            while (nextch1 != '*' || nextch2 != '/') {
                                nextch1 = nextch2;
                                nextch2 = (char) fin.read();
                                fout.write(nextch1);
                            }
                            fout.write(nextch2);
                        }
                    } else if (ch == '\'') {
                        fout.write(ch);
                        ch = (char) fin.read();
                        while (ch != '\'') {
                            fout.write(ch);
                            ch = (char) fin.read(); 
                        }
                        fout.write(ch);               
                    } else if (ch == '"') {
                        fout.write(ch);
                        ch = (char) fin.read();
                        while (ch != '"') {
                            fout.write(ch);
                            ch = (char) fin.read();
                        }
                        fout.write(ch);
                    } else if (ch == '\n') {
                        fout.write(ch);
                        space = 1;
                    } else {
                        if (space == 1) {
                            printSpaces(depth , fout);
                            space = 0;
                        }
                        fout.write(ch);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (fin != null) { //checking for input file is open or not
                fin.close();
            }
            if (fout != null) { //checking for output file is open or not
                fout.close();
            }
        }
    }
    public static void printSpaces(final int depth , final FileOutputStream fout) throws IOException {
        //print method is used to print spaces
        for (int i = 0; i < 4 * depth; i++) {
            fout.write(' ');
        }
    }
}
