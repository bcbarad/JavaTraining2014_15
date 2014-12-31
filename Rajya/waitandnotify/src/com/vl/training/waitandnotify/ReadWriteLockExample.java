package com.vl.training.waitandnotify;

public final class ReadWriteLockExample {

    private ReadWriteLockExample() {
    }

    public static void main(final String []args) {
        if (args.length == 1) {
            Thread readThread = new Thread(new Reader(args[0]));
            Thread writeThread = new Thread(new Writer(args[0]));
            readThread.start();
            writeThread.start();
            try {
                readThread.join();
                writeThread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please provide one argument");
        }
    }
}
