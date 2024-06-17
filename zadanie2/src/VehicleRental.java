import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class VehicleRental {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Garage> garages = new ArrayList<>();

    public VehicleRental(int garageCount) {
        for (int i = 0; i < garageCount; i++) {
            garages.add(new Garage());
        }
    }

    public void loadVehicles(String fileName) {
        try {
            File file = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList carList = doc.getElementsByTagName("samochod");
            for (int i = 0; i < carList.getLength(); i++) {
                Element element = (Element) carList.item(i);
                String name = element.getElementsByTagName("nazwa").item(0).getTextContent();
                int fuelType = Integer.parseInt(element.getElementsByTagName("rodzajPaliwa").item(0).getTextContent());
                vehicles.add(new Car(name, fuelType));
            }

            NodeList motorboatList = doc.getElementsByTagName("motorowka");
            for (int i = 0; i < motorboatList.getLength(); i++) {
                Element element = (Element) motorboatList.item(i);
                String name = element.getElementsByTagName("nazwa").item(0).getTextContent();
                int fuelType = Integer.parseInt(element.getElementsByTagName("rodzajPaliwa").item(0).getTextContent());
                vehicles.add(new Motorboat(name, fuelType));
            }

            NodeList bicycleList = doc.getElementsByTagName("rower");
            for (int i = 0; i < bicycleList.getLength(); i++) {
                Element element = (Element) bicycleList.item(i);
                String name = element.getElementsByTagName("nazwa").item(0).getTextContent();
                vehicles.add(new Bicycle(name));
            }

            NodeList scooterList = doc.getElementsByTagName("hulajnoga");
            for (int i = 0; i < scooterList.getLength(); i++) {
                Element element = (Element) scooterList.item(i);
                String name = element.getElementsByTagName("nazwa").item(0).getTextContent();
                vehicles.add(new Scooter(name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveVehicles(String fileName) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            
            Element rootElement = doc.createElement("pojazdy");
            doc.appendChild(rootElement);

            for (Vehicle vehicle : vehicles) {
                Element vehicleElement;
                if (vehicle instanceof Car) {
                    vehicleElement = doc.createElement("samochod");
                    Element fuelType = doc.createElement("rodzajPaliwa");
                    fuelType.appendChild(doc.createTextNode(String.valueOf(((Car) vehicle).getFuelType())));
                    vehicleElement.appendChild(fuelType);
                } else if (vehicle instanceof Motorboat) {
                    vehicleElement = doc.createElement("motorowka");
                    Element fuelType = doc.createElement("rodzajPaliwa");
                    fuelType.appendChild(doc.createTextNode(String.valueOf(((Motorboat) vehicle).getFuelType())));
                    vehicleElement.appendChild(fuelType);
                } else if (vehicle instanceof Bicycle) {
                    vehicleElement = doc.createElement("rower");
                } else {
                    vehicleElement = doc.createElement("hulajnoga");
                }

                Element name = doc.createElement("nazwa");
                name.appendChild(doc.createTextNode(vehicle.name));
                vehicleElement.appendChild(name);

                rootElement.appendChild(vehicleElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(int vehicleId) {
        vehicles.removeIf(vehicle -> vehicle.getId() == vehicleId);
    }

    public void printVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void sortVehicles() {
        Collections.sort(vehicles, (v1, v2) -> {
            if (v1 instanceof Parkable && !(v2 instanceof Parkable)) {
                return -1;
            } else if (!(v1 instanceof Parkable) && v2 instanceof Parkable) {
                return 1;
            } else {
                int typeComparison = v1.getClass().getSimpleName().compareTo(v2.getClass().getSimpleName());
                if (typeComparison != 0) {
                    return typeComparison;
                } else {
                    int nameComparison = v1.name.compareTo(v2.name);
                    if (nameComparison != 0) {
                        return nameComparison;
                    } else if (v1 instanceof Motorized && v2 instanceof Motorized) {
                        return Integer.compare(((Motorized) v1).getFuelType(), ((Motorized) v2).getFuelType());
                    } else {
                        return 0;
                    }
                }
            }
        });
    }
}
