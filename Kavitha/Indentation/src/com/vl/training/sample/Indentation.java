package com.vl.training.sample;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

public class Indentation {
    public static void main(final String []args) throws FileNotFoundException {
        if (args.length > 0) {
            File f = new File(args[0]);
            Indentation.indent(f, args);
        } else {
            System.out.println("Please add the text file");
        }
    }
    static void indent(final File f, final String []args) {
        if (!f.exists()) {
            System.out.println(args[0] + "does not exists");
            return;
        }
        if (!(f.isFile() && f.canRead())) {
            System.out.println(f.getName() + "Can't be read");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(f);
            char current, next, nextchar;
            boolean flag = false;
            int depth = 0;
            while (fis.available() > 0) {
                current = (char) fis.read();
                if (current == ' ' && !flag) {
                    System.out.print(current);
                }
                while (current == ' ') {
                    current = (char) fis.read();
                }
                if (current == '{') {
                    System.out.print(current + "\n");
                    depth += 1;
                    displaySpace(depth);
                    current = (char) fis.read();
                    if (current == '\n') {
                        flag = true;
                    }
                    continue;
                } else if (current == '}') {
                    depth -= 1;
                    displaySpace(depth);
                    System.out.print(current);
                    continue;
                } else if (current == '/') {
                    displaySpace(depth);
                    System.out.print(current);
                    next = (char) fis.read();
                    if (next == '/') {
                        System.out.print(next);
                        while (next != '\n') {
                            next = (char) fis.read();
                            System.out.print(next);
                        }
                        flag = true;
                        displaySpace(depth);
                        continue;
                    }
                    if (next == '*') {
                        System.out.print(next);
                        next = (char) fis.read();
                        nextchar = (char) fis.read();
                        while (next != '*' && nextchar != '/') {
                            System.out.print(next);
                            System.out.print(nextchar);
                            if (nextchar == '\n') {
                                displaySpace(depth);
                            }
                            next = (char) fis.read();
                            nextchar = (char) fis.read();
                        }
                        System.out.print(next);
                        System.out.print(nextchar);
                        continue;
                    }
                } else if (current == '\'') {
                    System.out.print(current);
                    current = (char) fis.read();
                    while (current != '\n') {
                        if (current == '{' || current == '}') {
                            System.out.print(current);
                        }
                        current = (char) fis.read();
                        System.out.print(current);
                    }
                    displaySpace(depth);
                    continue;
                }
                if (current == '\"') {
                    System.out.print(current);
                    current = (char) fis.read();
                    if (current == '{' || current == '}') {
                        System.out.print(current);
                        while (current != '\"') {
                            current = (char) fis.read();
                            System.out.print(current);
                        }
                    }
                    continue;
                } else {
                    System.out.print(current);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void displaySpace(final int space) {
        int i = 1;
        while (i <= 4 * space) {
            System.out.print(' ');
            i++;
        }
    }
}

