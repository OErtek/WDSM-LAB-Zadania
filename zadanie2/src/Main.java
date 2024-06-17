public class Main {
    public static void main(String[] args) {
        VehicleRental rental = new VehicleRental(5); // 5 garajı olan bir kiralama sistemi
        rental.loadVehicles("vehicles.xml"); // Başlangıçta XML dosyasından araçları yükle
        rental.printVehicles(); // Tüm araçları yazdır
        
        // Test eklemeleri
        rental.addVehicle(new Bicycle("New Bicycle"));
        rental.printVehicles();
        rental.saveVehicles("vehicles_updated.xml");
    }
}
