package com.vl.training.sample;
import java.io.File;

public class TransactionsUsingThreads {
    public static void main(String[] args) {
        if (args.length >= 1) {
            File directory = new File(args[0]);
            File[] listofFiles = directory.listFiles();
            int numofThreads = listofFiles.length;
            System.out.println(numofThreads);
            Thread[] thread = new Thread[numofThreads];
            for (int i = 0; i < numofThreads; i++) {
                thread[i] = new Thread(new ListOfFiles(listofFiles[i].getAbsolutePath()));
            }
            for (int i = 0; i < numofThreads; i++) {
                thread[i].start();
                System.out.println("thread" + i);
            }
            try {
                for (int i = 0; i < numofThreads; i++) {
                    //System.out.println("joining the threads");
                    thread[i].join();
                }
            } catch (Exception e) {
                System.err.println(e);
            }
            Transaction.printAccountDetails();
        } else {
            System.out.println("\n enter only one argument that is Directory");
        }
    }
}


