package qj.system;

public class Account {
    private final String name;
    private int balance;

    public Account(String name) {
        this.name = name;
        this.balance = 0;
    }

    int deposit(int amount) {
        balance += amount;
        return 0;
    }

    public int withdraw(int amount) {
        balance -= amount;
        return 0;
    }

    public int getBalance() {
        return balance;
    }
}