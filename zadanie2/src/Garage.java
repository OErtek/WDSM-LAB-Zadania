public class Garage {
    private boolean isEmpty = true;
    private Parkable parkedVehicle = null;

    public boolean park(Parkable vehicle) {
        if (isEmpty) {
            parkedVehicle = vehicle;
            isEmpty = false;
            return true;
        }
        return false;
    }

    public boolean unpark() {
        if (!isEmpty) {
            parkedVehicle = null;
            isEmpty = true;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
