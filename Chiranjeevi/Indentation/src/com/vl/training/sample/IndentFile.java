package com.vl.training.sample;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileInputStream;

public final class IndentFile {
    private IndentFile() {
    }

    private static int indentate = 0;

    public static void main(final String[] arr) throws IOException {
        if (arr.length != 1) {
            System.out.println("Input file should be specified");
            return;
        }
        FileInputStream fis = null;
        PrintStream print = null;
        //FileOutputStream fos = null;
        try {
            if (arr.length == 1) {
                fis = new FileInputStream(new File(arr[0]));
                //PrintStream can take 'System.out' or FileOutputstream
                print = new PrintStream(System.out);
                indentate(fis, print);
            } else {
                System.out.println("Needed to Specify exactly one parameter");
                return;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                print.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void indentate(final FileInputStream fis, final PrintStream out) throws IOException {
        int s = 0;
        boolean flag = false, multiLineComment = false;
        boolean singleQuote = false, doubleQuote = false;
        boolean line = false;
        char c = '\0';
        while (fis.available() > 0) {
            c = (char) fis.read();
            if (c == ' ' || !line) {
                out.print(c);
            }
            while (c == ' ') {
                //do nothing
                c = (char) fis.read();
            }
            //ignoring input between singleQuotes
            if (c == '\'') {
                out.print(c);
                if (singleQuote) {
                    singleQuote = false;
                } else {
                    singleQuote = true;
                }
                continue;
            }
            //ignoring input between doubleQuotes
            if (c == '"') {
                out.print(c);
                if (doubleQuote) {
                    doubleQuote = false;
                } else {
                    doubleQuote = true;
                }
                continue;
            }
            //check whether multiLineComment is set or not
            if (c == '*' && multiLineComment) {
                out.print(c);
                c = (char) fis.read();
                if (c == '/') {
                    out.print(c);
                    multiLineComment = false;
                    continue;
                }
            }
            //knowing which type of comment is  ahead
            if (c == '/' && !singleQuote && !doubleQuote) {
                out.print(c);
                if (!flag) {
                    c = (char) fis.read();
                    out.print(c);
                    if (c == '*') {
                        multiLineComment = true;
                    } else if (c == '/') {
                        flag = true;
                    }
                }
                continue;
            }
            //indentating when open paranthesis appears
            if (c == '{' && !flag && !multiLineComment && !singleQuote && !doubleQuote) {
                indentate++;
                out.print(" " + c);
                printSpaces(out);
                continue;
            }
            //indentating untill the block closes
            if (c == '}' && !flag && !multiLineComment && !singleQuote && !doubleQuote) {
                indentate--;
                //out.println();
                printSpaces(out);
                out.print(c);
                continue;
            }
            //indentating lines by trailing symbols ';'
            if (c == ';' && !flag && !multiLineComment && !singleQuote && !doubleQuote) {
                out.print(";");
                printSpaces(out);
                continue;
            }
            //indentating when a new line character is read
            if (c == '\n') {
                //out.println();
                printSpaces(out);
                flag = false;
                line = true;
                continue;
            }
            out.print(c);
        }
    }

    public static void printSpaces(final PrintStream out) {
        out.println();
        for (int i = 0; i < 4 * indentate; i++) {
            out.print(" ");
        }
        return;
    }
}
