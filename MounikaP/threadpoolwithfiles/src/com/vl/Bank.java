package com.vl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Bank {
    public static void main(final String[] args) throws FileNotFoundException {
        try {
            if (args.length != 0) {
                Processor p = null;
                Transaction bt = new Transaction();
                File dir = new File(args[0]);
                File[] list = dir.listFiles();
                ExecutorService executor = Executors.newFixedThreadPool(2);
                for (int i = 0; i < list.length; i++) {
                    Scanner sc = new Scanner(list[i]);
                    System.out.println("file name:" + list[i].getName());
                    p = new Processor(bt, sc);
                    executor.execute(p);
                }
                executor.shutdown();
                while (!executor.isTerminated()) {
                }
                System.out.println("finish all threads");
                Transaction.display();
            } else {
                System.out.println("pass file as arguments");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
