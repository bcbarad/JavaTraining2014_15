package com.vl.training.sample;
final public class SynDifferent {
    public static void main(final String[] args) {
        C c = new C();
        T1 t1 = new T1(c);
        t1.start();
        T2 t2 = new T2(c);
        t2.start();
    }
}
