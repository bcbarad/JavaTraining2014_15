package bankpool.code;
class Account {
    Integer id;
    double amount;
    Account(Integer id, double amount) {
        this.id = id;
        this.amount = amount;
    }
    Integer getId() {
        return this.id;
    }

    double getAmount() {
        return this.amount;
    }

    void deposit(double amount) {
        this.amount = this.amount + amount;
    }

    void withdraw(double amount) {
        this.amount = this.amount - amount;
    }
}
