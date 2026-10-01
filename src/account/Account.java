package account;

public class Account {

    private double accountBalance;
    private final String pin;
    private final String accountName;
    private final int accountNumber;

    public Account(String pin, String name, int accountNumber) {
        this.pin = pin;
        this.accountName = name;
        this.accountNumber = accountNumber;
    }

    public double getBalance(String pin) {
        if(this.pin.equals(pin))
            return accountBalance;
        throw new IllegalArgumentException("Wrong Pin");
    }

    private boolean isValid(double amount) {
        return amount > 0;
    }

    public void deposit(double amount) {
        if(isValid(amount))
            accountBalance += amount;

    }

    public void withdraw(String pin, double amount) {
        if(this.pin.equals(pin) && accountBalance > amount && isValid(amount)) {
            accountBalance -= amount;
        }
        else {
            throw new IllegalArgumentException("Invalid");
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

