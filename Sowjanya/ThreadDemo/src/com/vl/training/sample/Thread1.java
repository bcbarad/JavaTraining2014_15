package com.vl.training.sample;
class Thread1 extends Thread {
    EvenNumbers en;
    Thread1(final EvenNumbers en) {
        this.en = en;
    }
    public void run() {
        en.display(10);
    }
}
