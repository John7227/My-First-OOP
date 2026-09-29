package account;

public class Account {

    private double accountBalance;
    private final String PIN;

    public Account(String PIN) {
        this.PIN = PIN;
    }

    public double getBalance(String PIN) {
        if(this.PIN.equals(PIN))
            return accountBalance;
        throw new IllegalArgumentException("Wrong PIN");
    }

    public void deposit(double amount) {
        if(amount > 0)
            accountBalance += amount;

    }

    public void withdraw(String PIN, double amount) {
        if(this.PIN.equals(PIN) && amount > 0 && accountBalance > amount) {
            accountBalance -= amount;
        }
        else {
            throw new IllegalArgumentException("Invalid");
        }
    }
}

