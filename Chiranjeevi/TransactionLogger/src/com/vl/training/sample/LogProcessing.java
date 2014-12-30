package com.vl.training.sample;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.HashSet;
import java.io.File;
import java.util.Scanner;
public final class LogProcessing {
    Hashtable<String, Account> log = new Hashtable<String, Account>();
    ArrayList<Thread> tList = new ArrayList<Thread>();
    TransactionLogger tl = new TransactionLogger();
    private LogProcessing() {
    }
    public static void main(final String[] arr) throws IOException {
        if (arr.length != 1) {
            System.out.println("Required inputs not provided");
            return;
        } else {
            LogProcessing lp = new LogProcessing();
            lp.processLog(new File(arr[0]));
            lp.joinThreads();
            lp.printAccountDetails();
        }
    }
    public void processLog(final File root) throws IOException {
        File[] fileList = root.listFiles();
        if (fileList == null) {
            return;
        }
        for (File f : fileList) {
            if (f.isDirectory()) {
                //traverse the directory untill files to be processed are found
                processLog(f);
            } else {
                // code for creating individual thread for each input file found
                final File file = f;
                Thread t = new Thread() {
                    public void run() {
                        try {
                            tl.processLog(new Scanner(file), log);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
                tList.add(t);
            }
        }
    }
    public void joinThreads(){
        for (Thread t : tList) {
            try {
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void printAccountDetails() {

        if (log != null) {
            System.out.println("Account\t Amount");
            System.out.println("\n-----------------------------------");
            for (Map.Entry m : log.entrySet()) {
                Account a = (Account) m.getValue();
                System.out.println(a.getId() + " \t " + a.getAmount());
            }
        } else {
            System.out.println("Log is empty");
        }
    }
}
