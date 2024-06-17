public abstract class Vehicle {
    private static int idCounter = 0;
    private int id;
    protected String name;

    public Vehicle(String name) {
        this.name = name;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public abstract String toString();
}
