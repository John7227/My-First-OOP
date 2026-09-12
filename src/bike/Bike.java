package bike;

public class Bike {

    private boolean powerState;
    private int speed;


    public boolean checkBikeState() {
        return powerState;
    }

    public int checkAccelerationState() {

        return speed;
    }

    public void turnBikeOn() {
        powerState = true;
    }


    public void turnBikeOff() {

        powerState = false;
    }

    public void increaseAcceleration() {
        if(powerState) {
            if (speed >= 0 && speed <= 20) {
                speed = speed + 1;
            } else if (speed >= 21 && speed <= 30) {
                speed = speed + 2;
            } else if (speed >= 31 && speed <= 40) {
                speed = speed + 3;
            } else if (speed > 40) {
                speed = speed + 4;
            }
        }
    }


    public void decreaseAcceleration() {
        if(powerState) {
            if (speed >= 0 && speed <= 20) {
                speed = speed - 1;
            } else if (speed >= 21 && speed <= 30) {
                speed = speed - 2;
            } else if (speed >= 31 && speed <= 40) {
                speed = speed - 3;
            } else if (speed >= 41) {
                speed = speed - 4;
            }
        }

    }



}
