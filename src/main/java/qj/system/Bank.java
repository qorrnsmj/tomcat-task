package qj.system;

import java.util.Hashtable;

public class Bank {
    private final Hashtable<String, Account> customer;

    public Bank() {
        customer = new Hashtable<>();
    }

    public int open(String name) {
        if (customer.containsKey(name)) {
            return -7;
        }
        customer.put(name, new Account(name));
        return 0;
    }

    public int close(String name) {
        int result = checkCustomer(name);
        if (result != 0) {
            return result;
        }

        Account acc = customer.get(name);
        if (acc.getBalance() != 0) {
            return -1;
        }

        customer.remove(name);
        return 0;
    }

    public int deposit(String name, String amountStr) {
        int amount = checkInput(name, amountStr);
        if (amount < 0) {
            return amount;
        }

        Account acc = customer.get(name);
        acc.deposit(amount);
        return 0;
    }

    public int withdraw(String name, String amountStr) {
        int amount = checkInput(name, amountStr);
        if (amount < 0) {
            return amount;
        }

        Account acc = customer.get(name);
        if (acc.getBalance() < amount) {
            return -1;
        }

        acc.withdraw(amount);
        return 0;
    }

    public int showBalance(String name) {
        int result = checkCustomer(name);
        if (result < 0) {
            return result;
        }

        return customer.get(name).getBalance();
    }

    /* private */

    private int checkCustomer(String name) {
        // 顧客が存在するかチェック
        if (!customer.containsKey(name)) {
            return -7;
        }

        return 0;
    }

    private int checkInput(String name, String amountStr) {
        int result = checkCustomer(name);
        if (result < 0) return result;

        // 金額を数値にパース
        int amount;
        try {
            amount = Integer.parseInt(amountStr);
        } catch (NumberFormatException e) {
            return -4;
        }
//test
        // 金額が0以下の場合
        if (amount < 0) {
            return -3;
        }

        return amount;
    }
}