package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountTest {

    private Account myAccount;

    @BeforeEach
    public void startWith (){
        myAccount = new Account(1234);
    }

    @Test
    public void testThatIHaveAnAccountAndTheBalanceIsZero() {
        assertEquals(0, myAccount.getBalance(1234));

    }

    @Test
    public void testThatWhenIDeposit5KTheBalanceChangesTo5k() {
        assertEquals(0 , myAccount.getBalance(1234));
        myAccount.deposit(5000);

        assertEquals(5000, myAccount.getBalance(1234));
    }

    @Test
    public void testThatWhenIDepositANegativeAmountMyBalanceShouldRemainZero() {
        assertEquals(0 , myAccount.getBalance(1234));
        myAccount.deposit(-1000);

        assertEquals(0, myAccount.getBalance(1234));
    }

    @Test
    public void testThatIWithdraw3kFromAnEmptyBalance_AndItThrowsError() {
        assertEquals(0 , myAccount.getBalance(1234));

        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(1234, 3000));
    }

    @Test
    public void testThatWhenIDeposit5kAndWithdraw3kMyBalanceIs2k() {
        assertEquals(0 , myAccount.getBalance(1234));

        myAccount.deposit(5000);
        assertEquals(5000 , myAccount.getBalance(1234));

        myAccount.withdraw(1234, 3000);

        double actual = myAccount.getBalance(1234);

        assertEquals(2000, actual);
    }

    @Test
    public void testThatWhenIWithdrawNegativeAmount_AndItThrowsAnError() {
        assertEquals(0 , myAccount.getBalance(1234));

        assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(1234, -3000));
    }

    @Test
    public void testThatWhenIDeposit5kAndWithdrawNegativeAmount_ItThrowsAnErrorForWithdrawalAndMyBalanceIsStill5k() {
        assertEquals(0 , myAccount.getBalance(1234));

        myAccount.deposit(5000);

        assertThrows(IllegalArgumentException.class, () -> myAccount. withdraw(1234, -3000));
        assertEquals(5000 , myAccount.getBalance(1234));

    }

}
