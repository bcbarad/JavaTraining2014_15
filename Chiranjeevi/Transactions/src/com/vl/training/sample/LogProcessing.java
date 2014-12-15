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
            logProcessing.processLog(sc);
        }
    }

    public void processLog(Scanner sc) {
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
        for(Map.Entry m : log.entrySet()) {
            System.out.println("Account no.: " + m.getKey() + "    Amount: " + m.getValue());
        }
    }
}
