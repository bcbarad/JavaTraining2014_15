package com.vl.training.sample;
class Account {
    String curid;
    int amount;
    Account(final String curid, final int amount) {
        this.curid = curid;
        this.amount = amount;
    }
    public void deposit(final int amount) {
        this.amount = this.amount + amount;
    }
    public void withdraw(final int amount) {
        this.amount = this.amount - amount;
    }
}
