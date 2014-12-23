// This program demonstrate Synchronization will occure calling threads with respect to same object but in different methods.

package com.vl.training.sample;


public class SynchronizationEx2 {
    public synchronized void display(int n) { // It is called with respect to FirstThread calss
        for (int i = 0; i < n ; i++) {
            System.out.println(i);
        }
    }
    public synchronized void displayGreeting(String s) { // It is called with respect to SecondThread classs
        for (int i = 0; i < 10 ; i++) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        SynchronizationEx2 syn = new SynchronizationEx2();
        FirstThread firstT1 = new FirstThread(syn);   // creatong FirstThread object by passing SynchonizationEx2 object as parameter
        SecondThread secondT2 = new SecondThread(syn); // Creating Second THread object by passing SynchronizationEx2 object as parameter
        firstT1.start();
        secondT2.start();
    }
}
