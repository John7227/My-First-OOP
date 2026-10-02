package account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    @Test
    public void testThatIHaveABank_ICanCreateAccount_AndAnAccountNumber() {
        Bank myBank = new Bank("First Bank");

        Account smith = myBank.createAccount("Jaden Smith", "0124");
        assertEquals("Jaden Smith" , smith.getAccountName());
        assertEquals(10001, smith.getAccountNumber());
    }

    @Test
    public void testThatIHaveABank_ICanCreateAccount_IHaveAnAccountNumber_AndCanFindMyAccountWithMyAccountNumber() {
        Bank myBank = new Bank("First Bank");

        Account smith = myBank.createAccount("Jaden Smith", "0124");
        assertEquals("Jaden Smith", smith.getAccountName());
        assertEquals(10001, smith.getAccountNumber());

        Account peter = myBank.createAccount("Jayson Peter", "5225");
        assertEquals("Jayson Peter", peter.getAccountName());
        assertEquals(10002, peter.getAccountNumber());

        Account foundAccount = myBank.findAccount(10001);
        assertEquals("Jaden Smith", foundAccount.getAccountName());

        Account found = myBank.findAccount(10002);
        assertEquals("Jayson Peter", found.getAccountName());
    }

    @Test
    public void testThatIHaveABank_ICanCreateAccount_IHaveAnAccountNumber_AndWhenAWrongAccountNumberIsEnteredToFind_An_Account_ItThrowsIllegalException() {
        Bank myBank = new Bank("First Bank");

        Account smith = myBank.createAccount("Jaden Smith", "0124");
        assertEquals("Jaden Smith", smith.getAccountName());
        assertEquals(10001, smith.getAccountNumber());

        assertThrows(IllegalArgumentException.class, ()-> myBank.findAccount(567865));

    }

    @Test
    public void testThatIHaveABank_ICanCreateAccount_AndCanCheckMyBalance() {
        Bank myBank = new Bank("First Bank");

        Account smith = myBank.createAccount("Jaden Smith", "0124");
        assertEquals("Jaden Smith", smith.getAccountName());
        assertEquals(10001, smith.getAccountNumber());

        assertEquals(0, myBank.checkBalance(10001, "0124"));
    }

    @Test
    public void testThatIHaveABank_ICanCreateAccount_AndCheckMyBalance_WithAWrongAccountNumber_AndAnExceptionIsThrown() {
        Bank myBank = new Bank("First Bank");

        Account smith = myBank.createAccount("Jaden Smith", "0124");
        assertEquals("Jaden Smith", smith.getAccountName());
        assertEquals(10001, smith.getAccountNumber());

        assertThrows(IllegalArgumentException.class, ()-> myBank.checkBalance(79976, "0124"));
    }

    @Test
    public void testThatIHaveABank_ICanCreateAccount_AndCheckMyBalance_WithAWrongPin_AndAnExceptionIsThrown() {
        Bank myBank = new Bank("First Bank");

        Account smith = myBank.createAccount("Jaden Smith", "0124");
        assertEquals("Jaden Smith", smith.getAccountName());
        assertEquals(10001, smith.getAccountNumber());

        assertThrows(IllegalArgumentException.class, ()-> myBank.checkBalance(10001, "0125"));
    }

    @Test
    public void testThatIHaveABank_ICanCreateAccount_MyBalanceIsEmpty_IDeposit2000_AndMyBalanceChangesTo2000() {
        Bank myBank = new Bank("First Bank");

        Account smith = myBank.createAccount("Jaden Smith", "0124");
        assertEquals("Jaden Smith", smith.getAccountName());
        assertEquals(10001, smith.getAccountNumber());

        assertEquals(0, myBank.checkBalance(10001, "0124"));

        myBank.deposit(10001, 2000);
        assertEquals(2000, myBank.checkBalance(10001, "0124"));
    }

    @Test
    public void testThatIHaveABank_ICanCreateAccount_MyBalanceIsEmpty_IDeposit2000_AndWithdraw1000_AndMyBalanceIs1000() {
        Bank myBank = new Bank("First Bank");

        Account smith = myBank.createAccount("Jaden Smith", "0124");
        assertEquals("Jaden Smith", smith.getAccountName());
        assertEquals(10001, smith.getAccountNumber());

        assertEquals(0, myBank.checkBalance(10001, "0124"));

        myBank.deposit(10001, 2000);
        assertEquals(2000, myBank.checkBalance(10001, "0124"));

        myBank.withdraw(10001, "0124", 1000);
        assertEquals(1000, myBank.checkBalance(10001, "0124"));
    }

    @Test
    public void testThatIHaveABank_ICanCreateAccount_MyBalanceIsEmpty_IDeposit2000_ITransfer1500_AndMyBalanceIs500() {
        Bank myBank = new Bank("First Bank");

        Account smith = myBank.createAccount("Jaden Smith", "0124");
        assertEquals("Jaden Smith", smith.getAccountName());
        assertEquals(10001, smith.getAccountNumber());

        assertEquals(0, myBank.checkBalance(10001, "0124"));

        Account peter = myBank.createAccount("Jayson Peter", "5225");
        assertEquals("Jayson Peter", peter.getAccountName());
        assertEquals(10002, peter.getAccountNumber());

        assertEquals(0, myBank.checkBalance(10002, "5225"));

        myBank.deposit(10001, 2000);
        assertEquals(2000, myBank.checkBalance(10001, "0124"));

        myBank.transfer(10001, "0124", 10002, 1500);
        assertEquals(500, myBank.checkBalance(10001, "0124"));

        assertEquals(500, myBank.checkBalance(10001, "0124"));
        assertEquals(1500, peter.getBalance("5225"));
    }
}
