package com.vl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
public class Bank extends Thread {
    public static void main(final String[] args) throws FileNotFoundException {
        try {
            if (args.length != 0) {
                Processor p = null;
                Transaction bt = new Transaction();
                File dir = new File(args[0]);
                File[] list = dir.listFiles();
                Thread[] threads = new Thread[list.length];
                for (int i = 0; i < list.length; i++) {
                    Scanner sc = new Scanner(list[i]);
                    System.out.println("file name:" + list[i].getName());
                    threads[i] = new Processor(bt, sc);
                    threads[i].start();
                    System.out.println("thread " + i +  "started");
                }
                for (int i = 0; i < list.length; i++) {
                    try {
                        threads[i].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Transaction.display();
            } else {
                System.out.println("pass file as arguments");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
