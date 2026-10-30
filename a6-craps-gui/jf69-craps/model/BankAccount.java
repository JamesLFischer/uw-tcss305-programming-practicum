package model;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must be non-negative.");
        }
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void placeBet(double bet) {
        if (bet <= 0 || bet > balance) {
            throw new IllegalArgumentException("Invalid bet amount.");
        }
        balance -= bet;
    }

    public void updateBalance(boolean isWin, double bet) {
        if (isWin) {
            balance += 2 * bet;
        }
    }
}