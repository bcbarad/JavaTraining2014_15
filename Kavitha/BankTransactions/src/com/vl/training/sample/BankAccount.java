package com.vl.training.sample;
class BankAccount {
    private double  amount = 0;
    private String accNo;
    public BankAccount(String accNo, double amount) {
        this.accNo = accNo;
        this.amount = amount;
    }
    public double getValue() {
        return amount;
    }
    public void deposit(double amount) {
        this.amount += amount;
    }
    public void withdraw(double amount) {
        this.amount -= amount;
    }
}
