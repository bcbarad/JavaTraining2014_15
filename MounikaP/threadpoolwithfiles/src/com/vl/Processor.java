package com.vl;
import java.util.Scanner;
class Processor extends Thread {
    private Transaction t;
    Scanner sc;
    public Processor(final Transaction t, final Scanner sc) {
        this.t = t;
        this.sc = sc;
    }
    public void run() {
        t.customerDepositAndWithdrawl(sc);
    }
}

