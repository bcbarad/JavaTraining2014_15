package com.vl.training.sample;

class Number {
    public static  synchronized void printNumber(final int n) {
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
    private Number n;
    public ThreadOne(final Number n) {
        this.n = n;
    }
    public void run() {
        n.printNumber(5);
    }
}

class ThreadTwo extends Thread {
    private Number n;
    public ThreadTwo(final Number n) {
        this.n = n;
    }
    public void run() {
        n.printNumber(10);
    }
}

public class TestNumber extends Thread {
    public static void main(final String []args) {
        Number num1 = new Number();
        ThreadOne t1 = new ThreadOne(num1);
        Number num2 = new Number();
        ThreadTwo t2 = new ThreadTwo(num2);
        t1.start();
        t2.start();
    }
}
