public class Car extends Vehicle implements Motorized, Parkable {
    private int fuelType;
    private Garage currentGarage = null;

    public Car(String name, int fuelType) {
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
    public boolean park(Garage garage) {
        if (garage.isEmpty()) {
            garage.park(this);
            currentGarage = garage;
            return true;
        }
        return false;
    }

    @Override
    public boolean unpark() {
        if (currentGarage != null) {
            currentGarage.unpark();
            currentGarage = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car: " + name + " (ID: " + getId() + ")";
    }
}
