package creditCardValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidatorTest {

    private CreditCardValidator myCreditCard;

    @BeforeEach
    public void startWith() {
        myCreditCard = new CreditCardValidator();
    }

    @Test
    public void testThatTheGivenCreditCardIsNotAcceptedWhenItIs17Digit() {

        myCreditCard.setCreditCardLength(43885760140262668L);

        assertFalse(myCreditCard.getCreditCardLength());
    }

    @Test
    public void testThatTheGivenCreditCardIsAcceptedWhenItIs16Digits() {

        myCreditCard.setCreditCardLength(4388576018402626L);

        assertTrue(myCreditCard.getCreditCardLength());
    }

    @Test
    public void testThatTheGivenCreditCardIsAcceptedWhenItIs15Digits() {

        myCreditCard.setCreditCardLength(438857601840262L);

        assertTrue(myCreditCard.getCreditCardLength());
    }

    @Test
    public void testThatTheGivenCreditCardIsAcceptedWhenItIs14Digits() {

        myCreditCard.setCreditCardLength(43885760184026L);

        assertTrue(myCreditCard.getCreditCardLength());
    }

    @Test
    public void testThatTheGivenCreditCardIsAcceptedWhenItIs13Digits() {

        myCreditCard.setCreditCardLength(4388576018402L);

        assertTrue(myCreditCard.getCreditCardLength());
    }

    @Test
    public void testThatTheGivenCreditCardIsNotAcceptedWhenItIs12Digits() {

        myCreditCard.setCreditCardLength(438857601840L);

        assertFalse(myCreditCard.getCreditCardLength());
    }


    @Test
    public void testThatTheCreditCardIsAcceptedIfItIsWithInTheRangeOf13To16_AndTheCreditCardIsAVisaCardBecauseItBeginsWith4() {

        long number = 4388576018402626L;

        myCreditCard.setCreditCardLength(number);
        assertTrue(myCreditCard.getCreditCardLength());

        myCreditCard.setCreditCardType(number);
        assertEquals("Visa Card", myCreditCard.getCreditCardType());
    }

    @Test
    public void testThatTheCreditCardIsAcceptedIfItIsWithInTheRangeOf13To16_AndTheCreditCardIsAMasterCardBecauseItBeginsWith5() {

        long number = 5388576018402626L;

        myCreditCard.setCreditCardLength(number);
        assertTrue(myCreditCard.getCreditCardLength());

        myCreditCard.setCreditCardType(number);
        assertEquals("MasterCard", myCreditCard.getCreditCardType());
    }

    @Test
    public void testThatTheCreditCardIsAcceptedIfItIsWithInTheRangeOf13To16_AndTheCreditCardIsAmericanExpressCardBecauseItBeginsWith37() {

        long number = 37576018402626L;

        myCreditCard.setCreditCardLength(number);
        assertTrue(myCreditCard.getCreditCardLength());

        myCreditCard.setCreditCardType(number);
        assertEquals("American Express Card", myCreditCard.getCreditCardType());
    }

    @Test
    public void testThatTheCreditCardIsAcceptedIfItIsWithInTheRangeOf13To16_AndTheCreditCardIsADiscoverCardBecauseItBeginsWith6() {

        long number = 69576018402626L;

        myCreditCard.setCreditCardLength(number);
        assertTrue(myCreditCard.getCreditCardLength());

        myCreditCard.setCreditCardType(number);
        assertEquals("Discover Card", myCreditCard.getCreditCardType());
    }

    @Test
    public void testThatIfTheCreditCardIsANegativeNumberItWillNotBeAccepted() {

        long number = -69576018402626L;

        myCreditCard.setCreditCardLength(number);
        assertFalse(myCreditCard.getCreditCardLength());

    }


    @Test
    public void testThatTheCreditCardIsAcceptedIfItIsWithInTheRangeOf13To16_AndTheCreditCardTypeIsValidated_ThenIDoubleEverySecondDigitsFromRightToLeftIfItResultsToASingleNumber_AndSumAllTheFirstNumbersInTheOddPlaceFromRightToLeft_TheSumTheResult_AndReturnTheResult() {

        long number = 4388576018402626L;

        myCreditCard.setCreditCardLength(number);
        assertTrue(myCreditCard.getCreditCardLength());

        myCreditCard.setCreditCardType(number);
        assertEquals("Visa Card", myCreditCard.getCreditCardType());

        myCreditCard.setSumOfSecondDigitsAndALlDigitsInOddPlaces(number);
        assertEquals(75, myCreditCard.getSumOfSecondDigitsAndALlDigitsInOddPlaces());
    }

    @Test
    public void testThatTheCreditCardIsAcceptedIfItIsWithInTheRangeOf13To16_AndTheCreditCardTypeIsValidated_AndISumAndConfirmIfTheCardIsAValidCardByIfItIsDivisibleBy10() {

        long number = 4388576018402626L;

        myCreditCard.setCreditCardLength(number);
        assertTrue(myCreditCard.getCreditCardLength());

        myCreditCard.setCreditCardType(number);
        assertEquals("Visa Card", myCreditCard.getCreditCardType());

        myCreditCard.setSumOfSecondDigitsAndALlDigitsInOddPlaces(number);

        myCreditCard.setCreditCardValidation();
        assertEquals("Invalid", myCreditCard.getCreditCardValidation());

    }

    @Test
    public void testThatTheCreditCardIsAcceptedIfItIsWithInTheRangeOf13To16_AndTheCreditCardTypeIsValidated_AndISumAndConfirmIfTheCardIsAValidCardByIfItIsDivisibleBy10ByCheckingAValidNumber() {

        long number = 4388576018410707L;

        myCreditCard.setCreditCardLength(number);
        assertTrue(myCreditCard.getCreditCardLength());

        myCreditCard.setCreditCardType(number);
        assertEquals("Visa Card", myCreditCard.getCreditCardType());

        myCreditCard.setSumOfSecondDigitsAndALlDigitsInOddPlaces(number);

        myCreditCard.setCreditCardValidation();
        assertEquals("Valid", myCreditCard.getCreditCardValidation());

    }
}
