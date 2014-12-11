package com.vl;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Indentation {
    public static void main(String[] args) throws IOException {
        try {
        FileReader Source = null;
        FileWriter Dest = null;
        if (args.length == 2) {
            Source = new FileReader(args[0]);
            Dest = new FileWriter(args[1]);
            Indentation.unIndentToIndent(Source, Dest);
        } else {
            System.out.println("enter source and destination files");
        }
        } catch(FileNotFoundException e) {
           System.out.println("file not found");
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    public static void unIndentToIndent(FileReader Source, FileWriter Dest) throws IOException {
        boolean space = false;
        boolean flag = false;
        int a, depth = 0;
        char current;
        try {
        while ((a = Source.read()) != -1) {
            current = (char) a;
            if (current == '{') {
                depth = depth + 4;
                Dest.write(current);
            } else if (current == '}') {
                depth = depth - 4;
                Indentation.indent(depth, Dest);
                Dest.write(current);
            } else if (current == ' ') {
                if (!space) {
                    Dest.write(' ');
                }
            } else if(current == '\n') {
                    Dest.write(current);
                    space = true;
            } else if (space) {
                Indentation.indent(depth, Dest);
                space = false;
                Dest.write(current);
            } else if (current == '/') {
                Dest.write(current);
                current = (char) Source.read();
                while ( current != '\n') {
                    Dest.write(current);
                    current = (char) Source.read();
                }
                Dest.write(current);
                space = true;
            } else if (current == '*') {
                Dest.write(current);
                current = (char) Source.read();
                char next = (char) Source.read();
                while ((current == '*') || (next != '/')) {
                    Dest.write(current);
                    current = next;
                    next = (char) Source.read();
                }
                Dest.write(current);
                Dest.write(next);
                current = (char) Source.read();
            } else if(current == '\'' || current == '"') {
                    Dest.write(current);
                    current = (char) Source.read();
                    while (current != '\n') {
                        Dest.write(current);
                        current = (char) Source.read();
                    }
                    Dest.write(current);
                    space = true;
            } else {
                Dest.write(current);
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            if (Source != null) {
                Source.close();
            }
            if (Source != null) {
                Dest.close();
            }
        }
    }
    public static void indent(int depth, FileWriter Dest) throws IOException {
        for (int index = 0; index < depth; index++) {
            Dest.write(' ');
        }
    }
}
