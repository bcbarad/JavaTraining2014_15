package com.vl;
import java.io.File;
public class Lock {
    public static void main(String args[]) {
        ReadProcessor p = null;
        WriteProcessor p1 = null;
        try {
            if (args.length > 0) {
                File file = new File(args[0]);
                Thread[] threads = new Thread[5];
                Thread[] threads1 = new Thread[5];
                FileReadWrite f = new FileReadWrite(file);
                for (int i = 0; i < 5; i++) {
                    threads[i] = new Thread(new ReadProcessor(f));
                    threads1[i] = new Thread(new WriteProcessor(f));
                    threads[i].start();
                    threads1[i].start();
                    System.out.println("thread " + i +  "started");

                }
                for (int i = 0; i < 5; i++) {
                    try {
                        threads[i].join();
                        threads1[i].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("pass file as arguments");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

