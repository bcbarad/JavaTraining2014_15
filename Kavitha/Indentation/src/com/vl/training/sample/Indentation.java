package com.vl.training.sample;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Indentation {
    public static void main(final String []args) throws FileNotFoundException {
        if (args.length > 1) {
            File fi = new File(args[0]);
            File fo = new File(args[1]);
            Indentation.indent(fi, fo, args);
        } else {
            System.out.println("Please add input,output text files");
        }
    }
    static void indent(final File fi, final File fo, final String []args) {
        if (!fi.exists() && !fo.exists()) {
            System.out.println(args[0] + "does not exists");
            return;
        }
        if (!(fi.isFile() && fi.canRead()) && !(fo.isFile() && fo.canRead())) {
            System.out.println(fi.getName() + "Can't be read");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(fi);
            FileOutputStream fos = new FileOutputStream(fo);
            char current, next, nextchar;
            boolean flag = false;
            int depth = 0;
            while (fis.available() > 0) {
                current = (char) fis.read();
                if (current == ' ' && !flag) {
                    fos.write(current);
                }
                while (current == ' ') {
                    current = (char) fis.read();
                }
                if (current == '{') {
                    fos.write(current);
                    depth += 1;
                    displaySpace(depth, fos);
                    current = (char) fis.read();
                    if (current == '\n') {
                        fos.write(current);
                        displaySpace(depth, fos);
                        flag = true;
                    }
                    continue;
                } else if (current == '}') {
                    depth -= 1;
                    displaySpace(depth, fos);
                    fos.write(current);
                    continue;
                } else if (current == '/') {
                    displaySpace(depth, fos);
                    fos.write(current);
                    next = (char) fis.read();
                    if (next == '/') {
                        fos.write(next);
                        while (next != '\n') {
                            next = (char) fis.read();
                            fos.write(next);
                        }
                        flag = true;
                        displaySpace(depth, fos);
                        continue;
                    } else if (next == '*') {
                        fos.write(next);
                        next = (char) fis.read();
                        nextchar = (char) fis.read();
                        while (next != '*' && nextchar != '/') {
                            fos.write(next);
                            fos.write(nextchar);
                            if (nextchar == '\n') {
                                displaySpace(depth, fos);
                            }
                            next = (char) fis.read();
                            nextchar = (char) fis.read();
                        }
                        fos.write(next);
                        fos.write(nextchar);
                        continue;
                    } else {
                        fos.write(next);
                        continue;
                    }
                } else if (current == '\'') {
                    fos.write(current);
                    current = (char) fis.read();
                    while (current != '\n') {
                        if (current == '{' || current == '}') {
                            fos.write(current);
                        }
                        current = (char) fis.read();
                        fos.write(current);
                    }
                    displaySpace(depth, fos);
                    continue;
                }
                if (current == '\"') {
                    fos.write(current);
                    current = (char) fis.read();
                    if (current == '{' || current == '}') {
                        fos.write(current);
                        while (current != '\"') {
                            current = (char) fis.read();
                            fos.write(current);
                        }
                    } else {
                        fos.write(current);
                    }
                    continue;
                } else {
                    fos.write(current);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void displaySpace(final int space, final FileOutputStream fos) {
        try {
            int i = 1;
            while (i <= 4 * space) {
                fos.write(' ');
                i++;
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}

