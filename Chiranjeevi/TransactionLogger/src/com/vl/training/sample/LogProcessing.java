package com.vl.training.sample;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

public class LogProcessing  {
    HashMap<String, Long> log = new HashMap<String, Long>();

    public static void main(final String arr[]) throws IOException {
        if (arr.length !=1) {
            System.out.println("Required inputs not provided");
            return;
        } else {
            LogProcessing lp = new LogProcessing();
            lp.processLog(new File(arr[0]));
            lp.printAccountDetails();
        }
    }

    public void processLog(File root) throws IOException {
        File[] fileList = root.listFiles();
        if (fileList == null)
            return;
        for (File f : fileList) {
            if (f.isDirectory()) { //traverse the directory untill files to be processed are found
                processLog(f);
            }
            else { // code for creating individual thread for each input file found
                final File file = f;
                final TransactionLogger obj = new TransactionLogger();
                Thread t = new Thread() {
                    public void run() {
                        try {
                            obj.processLog(new Scanner(file), log);
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
                try {
                    t.join();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printAccountDetails() {
        if (log != null) {
        System.out.println("Account\t Amount\n-----------------------------------");
        for(Map.Entry m : log.entrySet()) {
                System.out.println(m.getKey() + " \t " + m.getValue());
        }
        }
        else System.out.println("Log is empty");
    }
}

class TransactionLogger extends Thread {
    public static synchronized Map processLog(Scanner sc, HashMap<String, Long> log) {
        while (sc.hasNext()) {
            String acc = sc.next();
            String remarks = sc.next();
            long amount = sc.nextLong();
            Long value = log.get(acc);
            if (value == null){
                // do nothing
            }
            else if(remarks.equals("D")){
                 amount += value;
            }
            else if(remarks.equals("W")){
                 amount = value - amount;
            }
            log.put(acc, amount);
        }
        return log;
    }
}
