package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    private Account myAccount;
    private final String VALID_PIN = "0124";
    private final String INVALID_PIN = "1234";

    @BeforeEach
    public void startWith (){
        myAccount = new Account(VALID_PIN, "Daniel", 23456);
    }

    @Test
    public void testThatIHaveAnAccountAndTheBalanceIsEmpty() {
        assertEquals(0, myAccount.getBalance(VALID_PIN));

    }

    @Test
    public void testThatWhenIDeposit5KTheBalanceChangesTo5k() {
        assertEquals(0 , myAccount.getBalance(VALID_PIN));
        myAccount.deposit(5000);

        assertEquals(5000, myAccount.getBalance(VALID_PIN));
    }

    @Test
    public void testThatWhenIDepositANegativeAmountMyBalanceShouldStillBeEmpty() {
        assertEquals(0 , myAccount.getBalance(VALID_PIN));
        myAccount.deposit(-1000);

        assertEquals(0, myAccount.getBalance(VALID_PIN));
    }

    @Test
    public void testThatIWithdraw3kFromAnEmptyBalance_AndItThrowsError() {
        assertEquals(0 , myAccount.getBalance(VALID_PIN));

        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(VALID_PIN, 3000));
    }

    @Test
    public void testThatWhenIDeposit5kAndWithdraw3kMyBalanceIs2k() {
        assertEquals(0 , myAccount.getBalance(VALID_PIN));

        myAccount.deposit(5000);
        assertEquals(5000 , myAccount.getBalance(VALID_PIN));

        myAccount.withdraw(VALID_PIN, 3000);

        double actual = myAccount.getBalance(VALID_PIN);

        assertEquals(2000, actual);
    }

    @Test
    public void testThatWhenIWithdrawNegativeAmount_AndItThrowsAnError() {
        assertEquals(0 , myAccount.getBalance(VALID_PIN));

        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(VALID_PIN, -3000));
    }

    @Test
    public void testThatWhenIDeposit5kAndWithdrawNegativeAmount_ItThrowsAnErrorForWithdrawalAndMyBalanceIsStill5k() {
        assertEquals(0 , myAccount.getBalance(VALID_PIN));

        myAccount.deposit(5000);

        assertThrows(IllegalArgumentException.class, () -> myAccount. withdraw(VALID_PIN, -3000));
        assertEquals(5000 , myAccount.getBalance(VALID_PIN));

    }

    @Test
    public void testThatWhenITryToWithdrawWithAnIncorrectPIN_ItThrowsIllegalException() {
        assertEquals(0 , myAccount.getBalance(VALID_PIN));

        myAccount.deposit(5000);
        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(INVALID_PIN, 3000));
    }

    @Test
    public void testThatAccountShouldSuccessfullyReturnTheHolderName_AndAccountNumber() {
        assertEquals("Daniel", myAccount.getAccountName());
        assertEquals(23456, myAccount.getAccountNumber());
    }

}

