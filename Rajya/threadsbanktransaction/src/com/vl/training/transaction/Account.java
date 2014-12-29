package com.vl.training.transaction;

public class Account {

    private float amount;
    private String id;

    Account(final String accNo, final float amt) {
        this.id = accNo;
        this.amount = amt;
    }

    final void deposit(final float amt) {
        this.amount += amt;
    }

    final void withdraw(final float amt) {
        this.amount -= amt;
    }

    final float getAmount() {
        return amount;
    }

    final String getId() {
        return id;
    }
}
