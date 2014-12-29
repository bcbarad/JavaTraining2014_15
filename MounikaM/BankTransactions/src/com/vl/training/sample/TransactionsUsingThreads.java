package com.vl.tarining.sample;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TransactionsUsingThreads {
    publis static void main(String[] args) {
        try {
            if(args.length >= 1) {
                File directory = new File(args[0]);
                File[] listofFiles = directory.listFiles();
                int numofThreads = listofFiles.length;

                Thread[] thread = new Thread[i];

                for (i = 0; i < numofThreads; i++) {
                    thread[i] = new Thread(new ListofFiles[i].getAbsolutePath());
                }
                for (int i = 0; i < numofThreads; i++) {
                    thread[i].start();
                }
            }
        } catch(IOException io) {
            System.err.println(io);
        }
    }
}

public class ListofFiles implements Runnable {
    String fileName;
    Map<String, Float> m;

    public ListofFiles(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        Transaction t = new Transaction();
        m = t.accountCalculation(filename);
        t. printHashMap(hm);
    }
}

