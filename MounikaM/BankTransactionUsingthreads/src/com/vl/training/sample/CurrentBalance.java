package com.vl.training.sample;

class CurrentBalance {
    int amount;
    public CurrentBalance(int amount) {
        this.amount = amount;
    }
    public void deposit(int money) {
        amount = amount + money;
    }
    public void withdraw(int money) {
        amount = amount - money;
    }
}
