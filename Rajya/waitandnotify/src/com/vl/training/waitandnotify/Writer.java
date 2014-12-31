package com.vl.training.waitandnotify;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Writer extends Thread {

    private String fileName;

    Writer(final String name) {
        this.fileName = name;
    }

    @Override
    public void run() {
        writeFile();
    }

    public final void writeFile() {
        ReadWriteReleaseLocks readWrite = new ReadWriteReleaseLocks();
        try {
            readWrite.getWriteLock();
            PrintWriter out = new PrintWriter(new BufferedWriter(
                        new FileWriter(fileName, true)));
            System.out.println(Thread.currentThread().getName()
                    + " Writting is started ");
            out.println("hello");
            System.out.println(Thread.currentThread().getName()
                    + "'s writing is over ");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWrite.releaseLock();
        }
    }
}
