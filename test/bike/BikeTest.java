package bike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    private Bike myBike;

    @BeforeEach
    public void startWith() {
        myBike = new Bike();
    }

    @Test void testThatIHaveABike_AndMyBikeIsOff() {
        assertFalse(myBike.checkBikeState());
    }

    @Test void testThatTheBikeIsOff_ThenIOnItCheckIfItIsOn() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());
    }

    @Test void testThatTheBikeIsOff_ThenIOnItCheckIfItIsOn_ThenITurnItOffAndItTurnOff() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());

        myBike.turnBikeOff();
        assertFalse(myBike.checkBikeState());
    }

    @Test
    public void testThatTheBikeIsOff_ThenITurnItOnICheckIfItIsOn_ThenIIncreaseTheAccelerationABy1AndCheckIfItIncreasesBy1() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());

        assertEquals(0, myBike.checkAccelerationState());

        myBike.increaseAcceleration();
        assertEquals(1, myBike.checkAccelerationState());
    }

    @Test
    public void testThatTheBikeIsOff_ThenITurnItOnAndCheckIfItIsOn_ThenIIncreaseItBy2AndCheckIfItIncreasesBy2() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 0; count <= 20; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(21, myBike.checkAccelerationState());

        for(int count = 21; count <= 25; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(31, myBike.checkAccelerationState());

    }

    @Test
    public void testThatTheBikeIsOff_ThenITurnItOnAndCheckIfItOn_ThenIIncreaseItBy3AndCheckIfItIncreasesBy3() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 0; count <= 20; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(21, myBike.checkAccelerationState());

        for(int count = 21; count <= 25; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(31, myBike.checkAccelerationState());

        for(int count = 31; count <= 34; count++) {
            myBike.increaseAcceleration();
        }

        assertEquals(43, myBike.checkAccelerationState());

    }

    @Test
    public void testThatTheBikeIsOff_ThenITurnItOnAndCheckIfItIsOn_ThenIIncreaseItBy4AndCheckIfItIncreasesBy4() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 0; count <= 20; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(21, myBike.checkAccelerationState());

        for(int count = 21; count <= 25; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(31, myBike.checkAccelerationState());

        for(int count = 31; count <= 34; count++) {
            myBike.increaseAcceleration();
        }

        assertEquals(43, myBike.checkAccelerationState());

        myBike.increaseAcceleration();

        assertEquals(47, myBike.checkAccelerationState());

    }

    @Test
    public void testThatTheBikeIsOff_ThenITurnItOnICheckIfItIsOn_ThenIIncreaseTheAccelerationAByGear1AndCheckIfItIncreasesBy1_ThenIDecreaseTheAccelerationBy1AndICheckIfItDecreasesBy1() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 0; count < 5; count++) {
            myBike.increaseAcceleration();
        }

        assertEquals(5, myBike.checkAccelerationState());

        for(int count = 5; count > 0; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(0, myBike.checkAccelerationState());

    }

    @Test
    public void testThatTheBikeIsOff_ThenITurnItOnICheckIfItIsOn_ThenIIncreaseTheAccelerationByGear2AndCheckIfItIncreasesBy2_ThenIDecreaseTheAccelerationBy2AndICheckIfItDecreasesBy2() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 0; count <= 20; count++) {
            myBike.increaseAcceleration();
        }

        assertEquals(21, myBike.checkAccelerationState());

        myBike.decreaseAcceleration();

        assertEquals(19, myBike.checkAccelerationState());

        for(int count = 1; count <= 19; count++) {
            myBike.decreaseAcceleration();
        }

        assertEquals(0, myBike.checkAccelerationState());
    }

    @Test
    public void testThatTheBikeIsOff_ThenITurnItOnICheckIfItIsOn_ThenIIncreaseTheAccelerationBy3AndCheckIfItIncreasesByGear3_ThenIDecreaseTheAccelerationBy3AndICheckIfItDecreasesBy3() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 0; count <= 20; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(21, myBike.checkAccelerationState());

        for(int count = 21; count <= 25; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(31, myBike.checkAccelerationState());

        myBike.decreaseAcceleration();

        assertEquals(28, myBike.checkAccelerationState());

        for(int count = 28; count >= 25; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(20, myBike.checkAccelerationState());

        for(int count = 20; count > 0; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(0, myBike.checkAccelerationState());
    }

    @Test
    public void testThatTheBikeIsOff_ThenITurnItOnICheckIfItIsOn_ThenIIncreaseTheAccelerationBy4AndCheckIfItIncreasesBy4_ThenIDecreaseTheAccelerationBy4AndICheckIfItDecreasesBy4() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOn();
        assertTrue(myBike.checkBikeState());

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 0; count <= 20; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(21, myBike.checkAccelerationState());

        for(int count = 21; count <= 25; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(31, myBike.checkAccelerationState());

        for(int count = 31; count <= 36; count++) {
            myBike.increaseAcceleration();
        }

        assertEquals(51, myBike.checkAccelerationState());

        for(int count = 51; count >= 49; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(39, myBike.checkAccelerationState());

        for(int count = 39; count >= 37; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(30, myBike.checkAccelerationState());

        for(int count = 30; count >= 26; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(20, myBike.checkAccelerationState());

        for(int count = 20; count > 0; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(0, myBike.checkAccelerationState());
    }


    @Test
    public void testThatTheBikeIsOff_ThenIIncreaseTheAccelerationBy4AndCheckIfItIncreasesBy4_ThenIDecreaseTheAccelerationBy4AndICheckIfItDecreasesBy4_WhenTheBikeIsOff() {
        assertFalse(myBike.checkBikeState());

        myBike.turnBikeOff();
        assertFalse(myBike.checkBikeState());

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 0; count <= 20; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 21; count <= 25; count++) {
            myBike.increaseAcceleration();
        }
        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 31; count <= 36; count++) {
            myBike.increaseAcceleration();
        }

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 51; count >= 49; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 39; count >= 37; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 30; count >= 26; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(0, myBike.checkAccelerationState());

        for(int count = 20; count > 0; count--) {
            myBike.decreaseAcceleration();
        }

        assertEquals(0, myBike.checkAccelerationState());
    }

}






