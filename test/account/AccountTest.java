package account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountTest {

    private Account myAccount;

    @BeforeEach
    public void startWith (){
        myAccount = new Account();
    }

    @Test
    public void testThatIHaveAnAccountAndTheBalanceIsZero() {
        assertEquals(0, myAccount.getBalance());

    }

    @Test
    public void testThatWhenIDeposit5KTheBalanceChangesTo5k() {
        assertEquals(0 , myAccount.getBalance());
        myAccount.deposit(5000);

        assertEquals(5000, myAccount.getBalance());
    }

    @Test
    public void testThatWhenIDepositANegativeAmountMyBalanceShouldRemainZero() {
        assertEquals(0 , myAccount.getBalance());
        myAccount.deposit(-1000);

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void testThatWhenIWithdraw3kMyBalanceShouldRemainZero() {
        assertEquals(0 , myAccount.getBalance());
        myAccount.withdraw(3000);

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void testThatWhenIDeposit5kAndWithdraw3kMyBalanceIs2k() {
        assertEquals(0 , myAccount.getBalance());

        myAccount.deposit(5000);
        assertEquals(5000 , myAccount.getBalance());

        myAccount.withdraw(3000);

        double actual = myAccount.getBalance();

        assertEquals(2000, actual);
    }

    @Test
    public void testThatWhenIWithdrawNegativeAmount_MyBalanceIsStillZero() {
        assertEquals(0 , myAccount.getBalance());
        myAccount.withdraw(-3000);

        assertEquals(0, myAccount.getBalance());
    }

    @Test
    public void testThatWhenIDeposit5kAndWithdrawNegativeAmountMyBalanceIsStill5k() {
        assertEquals(0 , myAccount.getBalance());

        myAccount.deposit(5000);
        assertEquals(5000 , myAccount.getBalance());

        myAccount.withdraw(-3000);

        double actual = myAccount.getBalance();

        assertEquals(5000, actual);
    }

}
