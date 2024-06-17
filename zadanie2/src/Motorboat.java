public class Motorboat extends Vehicle implements Motorized {
    private int fuelType;

    public Motorboat(String name, int fuelType) {
        super(name);
        this.fuelType = fuelType;
    }

    @Override
    public boolean refuel(int fuelType, int amount) {
        if (this.fuelType == fuelType) {
            // Yakıt doldur
            return true;
        }
        return false;
    }

    @Override
    public int getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Motorboat: " + name + " (ID: " + getId() + ")";
    }
}
