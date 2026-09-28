package account;

public class Account {

    private double accountBalance;
    private int PIN = 1234;

    public Account(int PIN) {
        this.PIN = PIN;
    }

    public double getBalance(int PIN) {
        if(this.PIN == PIN)
            return accountBalance;
        throw new IllegalArgumentException("Wrong PIN");
    }

    public void deposit(double amount) {
        if(amount > 0)
            accountBalance += amount;

    }

    public void withdraw(int PIN, double amount) {
        if(this.PIN == PIN && amount > 0 && accountBalance > amount) {
            accountBalance -= amount;
        }
        else {
            throw new IllegalArgumentException("Invalid");
        }
    }
}
