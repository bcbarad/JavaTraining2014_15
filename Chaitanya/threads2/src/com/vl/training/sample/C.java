package com.vl.training.sample;
class C {
    public synchronized void f1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread value" + i);
        }
    }
    public synchronized void f2() {
        for (int i = 0; i < 5 ; i++) {
            System.out.println("synchronize 2 is " + i);
        }
    }
}
