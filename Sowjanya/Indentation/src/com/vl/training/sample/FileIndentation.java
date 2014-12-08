package com.vl.traning.sample;
import java.io.*;
final class FileIndentation {
    private FileIndentation() {
    }
    private static char space = ' ';
    public static void main(final String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("/home/sowjanya/PrjTest/JavaTraining2014_15 /Sowjanya/Indentation/src/com/vl/training/sample/Example.java");
        FileOutputStream fout = new FileOutputStream("/home/sowjanya/PrjTest/JavaTraining2014_15 /Sowjanya/Indentation/src/com/vl/training/sample/Output.java" , true);
        int i = 0;
        byte[] b = new byte[fin.available()];
        int depth = 0;
        fin.read(b);
        try {
            for (int p = 0; p < b.length - 1; p++) {
                char ch = (char) b[p];
                fout.write(ch);
                if (ch == '{') {
                    depth = depth + 4;
                    print(depth , fout);
                }
                char ch1 = (char) b[p + 1];
                if (ch1 == '}') {
                    depth = depth - 4;
                    print(depth , fout);
                    fout.write(ch);
                }
                if (ch == '\n') {
                    print(depth , fout);
                }
                if (ch == ' ') {
                    fout.write(ch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fin.close();
            fout.close();
        }
    }
    public static void print(final int depth , final FileOutputStream fout) throws IOException {
        for (int j = 0; j < depth; j++) {
            fout.write(space);
        }
    }
}
