package com.vl.training.sample;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
final public class TransactionUsingThreadPool {
    private TransactionUsingThreadPool() {
    }
    public static void main(final String[] args) throws IOException {
        String name = Thread.currentThread().getName();
        System.out.println("Thread : " + name + " Thread started ");
        //reading directory as input file from commandline arguments
        File directory = new File(args[0]);
        //storing list of files in an array named File
        File[] listfiles = directory.listFiles();
        System.out.print("no of files in the given directory : ");
        System.out.println(listfiles.length);
        int noofthreadsinpool = Integer.parseInt(args[1]);
        ExecutorService executor = Executors.newFixedThreadPool(noofthreadsinpool);
        for (int i = 0; i < listfiles.length; i++) {
            String filename = listfiles[i].getName();
            if (filename.endsWith(".txt") || filename.endsWith(".TXT")) {
                Scanner sc = new Scanner(listfiles[i]);
                Runnable threadpool = new ThreadTransactions(sc);
                executor.execute(threadpool);
                //System.out.print("file " + i + " name : ");
                //System.out.println(listfiles[i].getName());
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
        //displaying the total transactions at end
        ThreadTransactions.printDetails();
        System.out.println("main thread ended");
    }
}

