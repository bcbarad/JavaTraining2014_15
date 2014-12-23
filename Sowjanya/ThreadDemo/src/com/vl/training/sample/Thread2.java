package com.vl.training.sample;
class Thread2 extends Thread {
    EvenNumbers en;
    Thread2(final EvenNumbers en) {
        this.en = en;
    }
    public void run() {
        en.display(20);
    }
}
