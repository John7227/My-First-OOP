package account;

public class Account {

    private double accountBalance;

    public double getBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        if(amount > 0)
            accountBalance += amount;

    }

    public void withdraw(double amount) {
        if(amount > 0 && accountBalance > amount)
            accountBalance -= amount;

    }
}
