package com.vl.training.sample;
import java.io.FileReader;
import java.io.IOException;


public class Indentation {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;

        reader = new FileReader("../src/com/vl/training/sample/Sum.java");
        int a = 0, depth = 0;
        char c;
        boolean flag = false;

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
        reader.close();
    }
}



