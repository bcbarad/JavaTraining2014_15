package com.vl.training.sample;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransactionsUsingThreadPool {
    public static void main(String[] args) {
        if (args.length >= 1) {
            File directory = new File(args[0]);
            File[] listofFiles = directory.listFiles();
            int numofThreads = listofFiles.length;
            int numofThreadsinPool = Integer.parseInt(args[1]);
            System.out.println(numofThreads);
            for (int i = 0; i < numofThreads; i++) {
                System.out.println(listofFiles[i]);
            }
            ListOfFiles[] lif = new ListOfFiles[numofThreads];
            ExecutorService executor = Executors.newFixedThreadPool(numofThreadsinPool);
            for (int i = 0; i < numofThreads; i++) {
                if (listofFiles[i].isFile()) {
                    lif[i] = new ListOfFiles(listofFiles[i].getAbsolutePath());
                    executor.execute(lif[i]);
                }
            }
            executor.shutdown();
            while (!executor.isTerminated()) { // wait for all threads to finish
            }
            Transaction.printAccountDetails();
        } else {
            System.out.println("\n enter only one argument that is Directory");
        }
    }
}


