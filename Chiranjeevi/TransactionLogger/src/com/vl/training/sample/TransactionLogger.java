package com.vl.training.sample;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class TransactionLogger extends Thread {
    public synchronized Map processLog(final Scanner sc,
            final HashMap<String, Long> log) {
        while (sc.hasNext()) {
            String acc = sc.next();
            String remarks = sc.next();
            long amount = sc.nextLong();
            Long value = log.get(acc);
            if (value == null) {
                // do nothing
            } else {
 //           synchronized(log) {
                    if (remarks.equals("D")) {
                        amount += value;
                    } else if (remarks.equals("W")) {
                        amount = value - amount;
                    }
  //              }
            }
            log.put(acc, amount);
        }
        return log;
    }
}
