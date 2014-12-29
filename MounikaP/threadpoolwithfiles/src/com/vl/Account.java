package com.vl;
class Account {
    int account;
    public Account(final int account) {
        this.account = account;
    }
    public void deposit(final int amt) {
        account = account + amt;
    }
    public void withdrawl(final int amt) {
        account = account - amt;
    }
}

