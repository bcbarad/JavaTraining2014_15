package com.vl.training.sample;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;


public class Indentation {
    public static void main(String[] args) {
        File file1 = null;
        File file2 = null;
        try {
            if (args.length == 2) {
                file1 = new File(args[0]);
                file2 = new File(args[1]);
                Indentation in = new Indentation();
                in.indentMethod(file1, file2);
            } else {
                System.out.println("\n enetr  only two files one is source file and another one is destination");
            }
        } catch (FileNotFoundException nfe) {
            System.err.println(" Source file not present: Please give Corect file name");
        } catch (IOException io) {
            System.err.println(io);
        }

    }
    public void indentMethod(File file1, File file2) throws IOException {
        FileReader reader = null;
        FileWriter writer = null;
        int a = 0, depth = 0;
        char c;
        boolean isSpace = false;
        boolean isBracesinSpecialSymbols = false;
        try {
            reader = new FileReader(file1);
            writer = new FileWriter(file2);

            while ((a = reader.read()) != -1) {
                c = (char) a;

                if (c == '{') {
                    if (!isBracesinSpecialSymbols) {
                        depth += 4;
                        writer.write(c);
                        isSpace = true;
                    } else {
                        writer.write(c);
                        isSpace = false;
                    }
                } else if (c == '}') {
                    if (!isBracesinSpecialSymbols) {
                        depth = depth - 4;
                        writer.write('\n');
                        printSpaces(depth, writer);
                        writer.write(c);
                        isSpace = true;
                    } else {
                        writer.write(c);
                    }
                } else if (c == ' ') {
                    if (!isSpace) {
                        writer.write(" ");
                    }
                } else if (c == '\n') {
                    isSpace = true;
                    isBracesinSpecialSymbols = false;
                } else if (c == '"' || c == '\'') {
                    writer.write(c);
                    isBracesinSpecialSymbols = true;
                } else if (c == '/') {
                    writer.write(c);
                    char ch = (char) reader.read();
                    if (ch == '/') {
                        writer.write(ch);
                        isBracesinSpecialSymbols = true;
                    }
                    if (ch == '*') {
                        writer.write(ch);
                        ch = (char) reader.read();
                        char nextc = (char) reader.read();
                        while (ch != '*' && nextc != '/') {
                            ch = nextc;
                            nextc = (char) reader.read();
                            writer.write(ch);
                        }
                        writer.write(nextc);
                    }
                } else {
                    if (isSpace) {
                        writer.write('\n');
                        printSpaces(depth, writer);
                        isSpace = false;
                    }
                    writer.write(c);
                }
            }
        } catch (FileNotFoundException nfe) {
            nfe.printStackTrace();
            throw nfe;
        } catch (IOException io) {
            io.printStackTrace();
            throw io;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
    public void printSpaces(int depth, FileWriter writer)throws IOException {
        for (int i = 0; i < depth; i++) {
            writer.write(' ');
        }
    }
}



