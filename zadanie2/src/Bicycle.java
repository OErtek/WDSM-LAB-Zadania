public class Bicycle extends Vehicle {
    public Bicycle(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Bicycle: " + name + " (ID: " + getId() + ")";
    }
}
