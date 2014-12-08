package com.vl.training.sample;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;


public class Indentation {
    public static void main(String[] args) throws IOException {
        File file = null;
        file = new File(args[0]);
        Indentation in = new Indentation();
        in.indentMethod(file);

    }
    public void indentMethod(File file) throws IOException {
        FileReader reader = null;
        try {
            int a = 0, depth = 0;
            char c;
            boolean flag = false;

            reader = new FileReader(file);

            while ((a = reader.read()) != -1) {
                c = (char) a;

                if (c == '{') {
                    depth += 4;
                    System.out.print(c);
                } else if (c == '}') {
                    depth = depth - 4;
                    System.out.println();
                    for (int i = 0; i < depth; i++) {
                        System.out.print(" ");
                    }
                    System.out.print(c);
                } else if (c == ' ') {
                    if (!flag) {
                        System.out.print(" ");
                    }
                } else if (c == '\n') {
                    System.out.print(c);
                    flag = true;
                } else {
                    if (flag) {
                        for (int i = 0; i < depth; i++) {
                            System.out.print(" ");
                        }
                        flag = false;
                    }
                    System.out.print(c);
                }
            }
        } catch(FileNotFoundException nfe) {
            System.err.println("File not found in specified path: ");
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            reader.close();
        }
    }
}



