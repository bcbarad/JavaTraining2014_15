// This program demonstrate even though function has synchronized keyword and threads are created with respect to same object but their run methods use different  object references of SynchronizationEx1 class hence threads are not synchronized
package com.vl.training.sample.SynchronizationExample1;

public class SynchronizationEx1 {
    public synchronized void multiplicationTable(int n) {
        int k = 0;
        for ( int i = 1; i < 10; i++) {
            k = i * n;
            System.out.println(k);
        }
    }

    public static void main(String[] args) {
        SynchronizationEx1 syn = new SynchronizationEx1();

        FirstThread threadt1 = new FirstThread(syn);

        SecondThread threadt2 = new SecondThread(syn);

        threadt1.start();
        threadt2.start();
        try {
            threadt1.join();
            threadt2.join();
        } catch(Exception e) {
            System.err.println(e);
        }
    }
}
