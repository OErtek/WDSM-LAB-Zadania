public class BulbTest {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();

        System.out.println("Is bulb burning? " + bulb.isBurning());  // false

        bulb.turnOn();
        System.out.println("Is bulb burning? " + bulb.isBurning());  // true

        bulb.turnOff();
        System.out.println("Is bulb burning? " + bulb.isBurning());  // false
    }
}
