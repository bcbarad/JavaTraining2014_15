package com.vl;
import java.util.Scanner;
class Processor extends Thread {
    private BankTransaction t;
    Scanner sc;
    public Processor(final BankTransaction t, final Scanner sc) {
        this.t = t;
        this.sc = sc;
    }
    public void run() {
        t.customerDepositAndWithdrawl(sc);
    }
}

