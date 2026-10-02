package account;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final String bankName;
    private int accountNumber = 10000;
    private final List<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        this.bankName = name;
    }

    public Account createAccount(String name, String pin) {
        int generatedNumber = ++accountNumber;
        Account myAccount = new Account(pin, name, generatedNumber);

        accounts.add(myAccount);
        return myAccount;
    }

    public Account findAccount(int accountNumber) {
        for(Account account: accounts) {
            if(account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public double checkBalance(int accountNumber, String pin) {
        Account myAccount = findAccount(accountNumber);

        return myAccount.getBalance(pin);
    }

    public void deposit(int accountNumber, int amount) {
        Account myAccount = findAccount(accountNumber);

        myAccount.deposit(amount);
    }

    public void withdraw(int accountNumber, String pin, int amount) {
        Account myAccount = findAccount(accountNumber);

        myAccount.withdraw(pin, amount);
    }

    public void transfer(int senderAccountNumber, String pin, int receiverAccountNumber, int amount) {
        Account senderAccount = findAccount(senderAccountNumber);
        Account receiverAccount = findAccount(receiverAccountNumber);

        senderAccount.withdraw(pin, amount);
        receiverAccount.deposit(amount);
    }
}
