package com.vl.training.sample;
class Transaction {
    double amount;
    public Transaction(final double amount) {
        this.amount = amount;
    }
    public void deposit(final double money) {
        amount = amount + money;
    }
    public void withdraw(final double money) {
        amount = amount - money;
    }
}
