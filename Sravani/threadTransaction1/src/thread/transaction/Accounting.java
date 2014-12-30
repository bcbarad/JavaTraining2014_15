package thread.transaction;
class Accounting {
    private int amount;
    private String accountId;
    String getId() {
        return this.accountId;
    }
    int getAmount() {
        return this.amount;
    }
    Accounting(final int amount , final String accountId) {
        this.amount = amount;
        this.accountId = accountId;
    }
    public  void deposit(final int amount) {
        this.amount = this.amount + amount;
    }
    public  void withDrawl(final int amount) {
        this.amount = this.amount - amount;
    }
}
