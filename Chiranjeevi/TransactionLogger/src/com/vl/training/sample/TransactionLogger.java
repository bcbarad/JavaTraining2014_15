package com.vl.training.sample;

import java.util.Scanner;
import java.util.Map;
import java.util.concurrent.*;
import java.util.HashMap;
import java.util.Hashtable;

class TransactionLogger extends Thread {
    public Map processLog(final Scanner sc,
            final Hashtable<String, Long> log) {
        while (sc.hasNext()) {
            System.out.print("Log1 : In thread " + Thread.currentThread().getId());
            String acc = sc.next();
            String remarks = sc.next();
            Long amount = sc.nextLong();
            System.out.println(" Account : " + acc + "Amount : " + amount);
            //synchronizing on the Hashtable
            synchronized(acc) {
                Long value = log.get(acc);
                if (value == null) {
                    value = amount;
                } else {
                    if (remarks.equals("D")) {
                        value += amount;
                    } else if (remarks.equals("W")) {
                        value -= amount;
                    }
                }
                log.put(acc, value);
            }
        }
        return log;
    }
}
