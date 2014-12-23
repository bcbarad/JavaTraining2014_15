package com.vl.training.sample;
class C {
    public synchronized void f1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread value" + i);
        }
    }
}
