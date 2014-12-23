package com.vl.training.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

public final class LogProcessing  {
    HashMap<String, Long> log = new HashMap<String, Long>();
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
//                            TransactionLogger.processLog(new Scanner(file), log);
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
                System.out.println(m.getKey() + " \t " + m.getValue());
            }
        } else {
            System.out.println("Log is empty");
        }
    }
}
