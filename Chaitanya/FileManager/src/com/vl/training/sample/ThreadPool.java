package com.vl.training.sample;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
public final class ThreadPool {
    private ThreadPool() {
    }
    public static void main(final String[] args) {
        if (args.length == 2) {
            Map m = new HashMap();
            FileRead fr = new FileRead();
            //Scanner sc = new Scanner(System.in);
            //System.out.println("Enter no of Threads u want in a threadpool");
            int n = Integer.parseInt(args[1]);
            ExecutorService es = Executors.newFixedThreadPool(n);
            FileManager fm = new FileManager();
            File f;
            for (int i = 0; i < fm.getLength(fm, args[0]); i++) {
                f = fm.getNext(fm, i, args[0]);
                if (f.exists()) {
                    es.execute(new FileThread(f, fr, m));
                } else {
                    break;
                }
            }
            es.shutdown();
            try {
                es.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(m);
            fr.display(m);
        } else {
            System.out.println("provide path of the directory as a one command line argument and number of threads in a thread pool");
        }
    }
}
