package airConditioner;

public class AirConditioner {

    private boolean powerState;
    private int temperature;

    public int checkTemperature() {
        return temperature;
    }


    public boolean checkState() {
        return powerState;
    }

    public void turnOn() {
        powerState = true;
        temperature = 16;
    }

    public void turnOff() {
        powerState = false;
    }

    public void increaseTemperature() {
        if(powerState) {
            if (temperature < 30)
                temperature = temperature + 1;

        }
    }

    public void decreaseTemperature() {
        if (temperature > 16)
            temperature = temperature - 1;

    }
}
