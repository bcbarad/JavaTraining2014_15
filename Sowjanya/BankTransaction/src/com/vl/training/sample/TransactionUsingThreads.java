package com.vl.training.sample;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
final public class TransactionUsingThreads {
    private TransactionUsingThreads() {
    }
    public static void main(final String[] args) throws IOException {
        String name = Thread.currentThread().getName();
        System.out.println("Thread : " + name + " Thread started ");
        //reading directory as input file from commandline arguments
        File directory = new File(args[0]);
        //storing list of files in an array named File
        File[] listfiles = directory.listFiles();
        //creating an arry for threads with the size as no.of.files in the directory
        ThreadTransaction[] tt = new ThreadTransaction[listfiles.length];
        System.out.print("no of files in the given directory : ");
        System.out.println(listfiles.length);
        for (int i = 0; i < listfiles.length; i++) {
            String filename = listfiles[i].getName();
            if (filename.endsWith(".txt") || filename.endsWith(".TXT")) {
                Scanner sc = new Scanner(listfiles[i]);
                tt[i] = new ThreadTransaction(sc);
                System.out.print("file " + i + " name : ");
                System.out.println(listfiles[i].getName());
                //calling thread[i] for i th file
                tt[i].start();
            }
        }
        for (int i = 0; i < listfiles.length; i++) {
            try {
                tt[i].join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        //displaying the total transactions at end
        ThreadTransaction.printDetails();
        System.out.println("main thread ended");
    }
}

