package com.vl.training.waitandnotify;

import java.io.BufferedReader;
import java.io.FileReader;

public class Reader extends Thread {

    private String fileName;

    Reader(final String name) {
        this.fileName = name;
    }

    @Override
    public void run() {
        readFile();
    }

    public final void readFile() {
        String line;
        BufferedReader reader = null;
        ReadWriteReleaseLocks readWriteLock = null;
        try {
            readWriteLock = new ReadWriteReleaseLocks();
            readWriteLock.getReadLock();
            reader = new BufferedReader(new FileReader(fileName));
            System.out.println(Thread.currentThread().getName()
                    + "'s Reading is started ");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println(Thread.currentThread().getName()
                    + "'s Reading is over ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.releaseLock();
        }
    }
}
