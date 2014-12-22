package com.vl;
import java.io.File;
import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Set;
import java.io.FileNotFoundException;
public final class Bank {
    public static void main(final String[] args) {
        try {
            if (args.length == 1) {
                Scanner sc = new Scanner(new File(args[0]));
                Map cusTransactionAmt = customerDepositAndWithdrawl(sc);
                display(cusTransactionAmt);
            } else {
                System.out.println("enter the file name");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Map customerDepositAndWithdrawl(final Scanner sc) {
        Map<String, Integer> cusTransactionAmt = new HashMap<String, Integer>();
        while (sc.hasNext()) {
            String cusId = sc.next();
            String status = sc.next();
            Integer amt = sc.nextInt();
            Integer totAmt = cusTransactionAmt.get(cusId);
            if (totAmt == null) {
                cusTransactionAmt.put(cusId, amt);
            } else {
                if (status.equals("D")) {
                    Integer preAmt = totAmt + amt;
                    cusTransactionAmt.put(cusId, preAmt);
                } else {
                    if (status.equals("w")) {
                        Integer preAmt = totAmt - amt;
                        cusTransactionAmt.put(cusId, preAmt);
                    }
                }
            }
        }
        return cusTransactionAmt;
    }
    public static void display(final Map cusTransactionAmt) {
        Set<Entry<String, Integer>> cus = cusTransactionAmt.entrySet();
        System.out.println("cusID"   + "    " + "amount");
        System.out.println("-----------------------------");
        for (Entry<String, Integer> c : cus) {
            System.out.println(c.getKey() + "     " + c.getValue());
        }
    }
}






