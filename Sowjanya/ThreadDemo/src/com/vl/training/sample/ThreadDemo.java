package com.vl.training.sample;
final public class ThreadDemo {
    private ThreadDemo() {
    }
    public static void main(final String[] args) {
        EvenNumbers en = new EvenNumbers();
        Thread1 t1 = new Thread1(en);
        Thread2 t2 = new Thread2(en);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
