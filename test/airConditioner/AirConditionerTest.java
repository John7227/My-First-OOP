package airConditioner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {

    private AirConditioner myAirConditioner;

    @BeforeEach
    public void startWith() {
        myAirConditioner = new AirConditioner();
    }

    @Test
    public void testIHaveAnAirConditioner_AndMyAirConditionerIsOff() {

        assertFalse(myAirConditioner.checkState());
    }

    @Test
    public void testIHaveAnAirConditionerItIsOff_AndWhenITurnItOnItTurnsOn() {
        assertFalse(myAirConditioner.checkState());

        myAirConditioner.turnOn();
        assertTrue(myAirConditioner.checkState());

    }

    @Test
    public void testIHaveAnAirConditionerItIsOff_ThenTurnItOnCheckIfItOnThenTurnItOffAndCheckIfItIsOff() {
        assertFalse(myAirConditioner.checkState());

        myAirConditioner.turnOn();
        assertTrue(myAirConditioner.checkState());

        myAirConditioner.turnOff();
        assertFalse(myAirConditioner.checkState());

    }

    @Test
    public void testThatIHaveAnAirConditionerItIsOff_TurnItOnCheckIfItIsOnThenIIncreaseItAndItIncreases() {
        assertFalse(myAirConditioner.checkState());

        myAirConditioner.turnOn();
        assertTrue(myAirConditioner.checkState());

        assertEquals(16 , myAirConditioner.checkTemperature());

        myAirConditioner.increaseTemperature();
        assertEquals( 17, myAirConditioner.checkTemperature());
    }

    @Test
    public void testThatIHaveAnAirConditionerItIsOff_TurnItOnCheckIfItIsOnThenIDecreaseItAndItDecreases() {
        assertFalse(myAirConditioner.checkState());

        myAirConditioner.turnOn();
        assertTrue(myAirConditioner.checkState());

        assertEquals(16 , myAirConditioner.checkTemperature());

        myAirConditioner.increaseTemperature();
        assertEquals( 17, myAirConditioner.checkTemperature());

        myAirConditioner.decreaseTemperature();
        assertEquals(16, myAirConditioner.checkTemperature());
    }

    @Test
    public void testThatIHaveAnAirConditionerItIsOff_TurnItOnCheckIfItOn_IncreaseItTo30_CheckIfTemperatureIs30_IncreaseItBeyond30CheckIfItIsStill30() {
        assertFalse(myAirConditioner.checkState());

        myAirConditioner.turnOn();
        assertTrue(myAirConditioner.checkState());

        assertEquals(16 , myAirConditioner.checkTemperature());

        for(int count = 16; count < 30; count++) {
            myAirConditioner.increaseTemperature();
        }
        assertEquals(30, myAirConditioner.checkTemperature());

        myAirConditioner.increaseTemperature();
        assertEquals(30 , myAirConditioner.checkTemperature());

    }

    @Test
    public void testThatIHaveAnAirConditionerItIsOff_TurnItOnCheckIfItOn_checkIfIt16_decreaseItAndItShouldNotGoBeyond16() {
        assertFalse(myAirConditioner.checkState());

        myAirConditioner.turnOn();
        assertTrue(myAirConditioner.checkState());

        assertEquals(16 , myAirConditioner.checkTemperature());

        myAirConditioner.decreaseTemperature();
        assertEquals(16, myAirConditioner.checkTemperature());
    }

    @Test
    public void testThatIHaveAnAirConditionerItIsOff_AndCheckIfIt_decreaseItAndItShouldStillBeOff() {
        assertFalse(myAirConditioner.checkState());

        myAirConditioner.turnOff();
        assertFalse(myAirConditioner.checkState());

        assertFalse(myAirConditioner.checkState());

        myAirConditioner.decreaseTemperature();
        assertFalse(myAirConditioner.checkState());
    }

}
