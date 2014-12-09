package com.vl.training.sample;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
public final class FileIndent {
    public static void main(final String[] args) throws IOException {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            if (args.length > 1) {
                fr = new FileReader(args[0]);
                fw = new FileWriter(args[1]);
                FileIndent f = new FileIndent();
                f.indentation(fr, fw);
            } else {
                System.out.println("enter file as a command line argument\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fr.close();
            fw.close();
        }
    }
    void indentation(final FileReader fr, final FileWriter fw) {
        try {
            int a, b;
            int noofopens = 0;
            while ((a = fr.read()) != -1) {
                if (a == '{') {
                    fw.write(a);
                    fw.append('\n');
                    noofopens++;
                    display(fw, noofopens);
                } else if (a == '}') {
                    fw.append('\n');
                    noofopens--;
                    display(fw, noofopens);
                    fw.write(a);
                } else if ((a == '\'') || (a == '"')) {
                    fw.write(a);
                    b = fr.read();
                    while ((b != '\'') && (b != '"')) {
                        fw.write(b);
                        b = fr.read();
                    }
                    fw.write(b);
                } else {
                    if (a == '/') {
                        b = fr.read();
                        check(fr, fw, a, b);
                        display(fw, noofopens);
                    } else if (a == '\n') {
                        fw.write(a);
                        display(fw, noofopens);
                    } else {
                        fw.write(a);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    void display(final FileWriter fw, final int n) throws IOException {
        int indent = 4;
        for (int k = 0; k < indent * n; k++) {
            fw.write(' ');
        }
    }
    void check(final FileReader fr, final FileWriter fw, final int a, final int b) throws IOException {
        if (b == '/') {
            fw.write(a);
            fw.write(b);
            char c;
            c = (char) fr.read();
            while (c != '\n') {
                fw.write(c);
                c = (char) fr.read();
            }
            fw.write(c);
        } else if (b == '*') {
            fw.write(a);
            fw.write(b);
            char c, d;
            c = (char) fr.read();
            d = (char) fr.read();
            while ((c != '*') || (d != '/')) {
                fw.write(c);
                c = d;
                d = (char) fr.read();
            }
            fw.write(c);
            fw.write(d);
        }
    }
}

