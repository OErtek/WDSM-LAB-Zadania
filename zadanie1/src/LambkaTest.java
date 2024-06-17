public class LampTest {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();

        System.out.println("Is lamp on? " + lamp.isOn());  // false
        System.out.println("Is bulb burning? " + lamp.isBulbBurning());  // false

        lamp.turnOn();
        System.out.println("Is lamp on? " + lamp.isOn());  // true
        System.out.println("Is bulb burning? " + lamp.isBulbBurning());  // true

        lamp.increaseIntensity();
        System.out.println("Intensity level: " + lamp.getIntensity());  // 1

        lamp.decreaseIntensity();
        System.out.println("Intensity level: " + lamp.getIntensity());  // 0
        System.out.println("Is bulb burning? " + lamp.isBulbBurning());  // false

        System.out.println(lamp.replaceBulb());  // Bulb replaced
        System.out.println("Is bulb burning? " + lamp.isBulbBurning());  // false
    }
}
