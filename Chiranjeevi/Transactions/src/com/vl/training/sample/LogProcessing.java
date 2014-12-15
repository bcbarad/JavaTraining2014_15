package com.vl.training.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class LogProcessing  {
    public static void main(final String arr[]) throws FileNotFoundException {
        if (arr.length !=1) {
            System.out.println("Required inputs not provided");
            return;
        } else {
            //Getting the file as input
            LogProcessing logProcessing = new LogProcessing();
            Scanner sc = new Scanner(new File(arr[0]));
            HashMap<String, Long> log = (HashMap) logProcessing.processLog(sc);
            logProcessing.printAccountDetails(log);
        }
    }

    public void printAccountDetails(HashMap<String, Long> log) {
        System.out.println("Account\t Amount\n-----------------------------------");
        for(Map.Entry m : log.entrySet()) {
                System.out.println(m.getKey() + " \t " + m.getValue());
            }
    }

    public Map processLog(Scanner sc) {
        HashMap<String, Long> log = new HashMap<String, Long>();
        while (sc.hasNext()) {
            String acc = sc.next();
            String remarks = sc.next();
            long amount = sc.nextLong();
            Long value = log.get(acc);
            if (value == null){
                log.put(acc, amount);
            }
            else if(remarks.equals("D")){
                log.put(acc, value + amount);
            }
            else if(remarks.equals("W")){
                log.put(acc, value - amount);
            }
        }
        return log;
    }
}
