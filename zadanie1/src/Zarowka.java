public class Bulb {
    private boolean isOn;

    public Bulb() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isBurning() {
        return isOn;
    }
}
