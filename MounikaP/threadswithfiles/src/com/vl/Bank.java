package com.vl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
class Test {
    synchronized Map customerDepositAndWithdrawl() {
        Scanner sc = new Scanner();
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
    synchronized void display() {
        final Map cusTransactionAmt;
        Set<Entry<String, Integer>> cus = cusTransactionAmt.entrySet();
        System.out.println("cusID"   + "    " + "amount");
        System.out.println("-----------------------------");
        for (Entry<String, Integer> c : cus) {
            System.out.println(c.getKey() + "     " + c.getValue());
        }
    }
}
class Processor implements Runnable {
    private Test file;
    public Processor(Test file) {
        this.file = file;
    }
    public void run() {
        file.customerDepositAndWithdrawl();
        file.display();
        //writeFile(p,file.getAbsolutePath(),outputDir);
    }
}
class Bank implements Runnable {
    void crawlDirectoryAndProcessFiles(File inputDir) {
        for (File file : inputDir.listFiles()) {
            if (file.isDirectory()) {
                crawlAndProcessFile(file);
            } else {
                Process p = new Processor(file);
                Thread t = new Thread(p);
                p.start();
            }
        }
    }
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("provide file as arguments");
            } else {
                Scanner sc = new Scanner(new File(args[0]));
                Bank b = new Bank();
                //ExecutorService executor = Executors.newFixedThreadPool(2);
                //Processor p = new Processor(file);
                //Thread t = new Thread(p);
                //t.start();
                //b.crawlDirectoryAndProcessFiles(inputDir, executor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

