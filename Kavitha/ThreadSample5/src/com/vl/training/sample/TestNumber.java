package com.vl.training.sample;
//with static  synchnronization
class Number {
    synchronized static void printNumber(final int n) {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1 / 2);
            } catch (final InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i * n);
        }
    }
}

class ThreadOne extends Thread {
    public void run() {
        Number.printNumber(5);
    }
}

class ThreadTwo extends Thread {
    public void run() {
        Number.printNumber(10);
    }
}

public class TestNumber extends Thread {
    public static void main(final String []args) {
        //Number num = new Number();
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        t1.start();
        t2.start();
    }
}
