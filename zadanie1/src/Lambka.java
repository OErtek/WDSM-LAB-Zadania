public class Lamp {
    private boolean isOn;
    private int intensity;
    private Bulb bulb;

    public Lamp() {
        isOn = false;
        intensity = 0;
        bulb = new Bulb();
    }

    public void turnOn() {
        isOn = true;
        bulb.turnOn();
    }

    public void turnOff() {
        isOn = false;
        bulb.turnOff();
    }

    public void increaseIntensity() {
        if (isOn && intensity < 10) {
            intensity++;
            bulb.turnOn();
        }
    }

    public void decreaseIntensity() {
        if (intensity > 0) {
            intensity--;
            if (intensity == 0) {
                bulb.turnOff();
            }
        }
    }

    public String replaceBulb() {
        if (!isOn) {
            bulb = new Bulb();
            return "Bulb replaced.";
        } else {
            return "Cannot replace bulb while lamp is on.";
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public boolean isBulbBurning() {
        return bulb.isBurning();
    }
}
