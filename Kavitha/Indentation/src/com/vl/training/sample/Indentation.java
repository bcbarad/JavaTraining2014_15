package com.vl.training.sample;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

public class Indentation {
    public static void main(String []args) throws FileNotFoundException {
        File f = new File(args[0]);
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
            char current = '\0';
            int depth = 0,openCount = 0,closeCount = 0;
            while (fis.available() > 0) {
                current = (char) fis.read();
                if (current== ' ') {
                    System.out.print(current);
                }
                while (current == ' ') {
                    current = (char) fis.read();
                }   
                if (current == '{') {
                    System.out.print(current + "\n");
                    depth += 4;
                    openCount = depth;
                    while (openCount > 0) {
                        System.out.print(" ");
                        openCount --;
                    }
                    current = (char) fis.read();
                    continue;
                }
                if (current == '}') {
                    depth -= 4;
                    closeCount = depth;
                    while(closeCount > 0) {
                        System.out.print(' ');
                        closeCount --; 
                    }
                    System.out.print(current);
                    continue;
                } else {
                      System.out.print(current);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
