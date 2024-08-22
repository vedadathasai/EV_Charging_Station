// Java Code for EV Charging Station Finder and Slot Booking System

import java.util.*;

class ChargingStation {
    int id;
    String location;
    String chargerType;
    Map<String, Boolean> slots;

    public ChargingStation(int id, String location, String chargerType, Map<String, Boolean> slots) {
        this.id = id;
        this.location = location;
        this.chargerType = chargerType;
        this.slots = slots;
    }
}

public class EVChargingSystem {
    private static List<ChargingStation> chargingStations = new ArrayList<>();

    static {
        chargingStations.add(new ChargingStation(1, "Downtown", "Fast", new HashMap<>(Map.of("slot1", true, "slot2", false))));
        chargingStations.add(new ChargingStation(2, "Uptown", "Standard", new HashMap<>(Map.of("slot1", true, "slot2", true))));
        chargingStations.add(new ChargingStation(3, "Midtown", "Fast", new HashMap<>(Map.of("slot1", true, "slot2", true))));
        chargingStations.add(new ChargingStation(4, "Suburb", "Standard", new HashMap<>(Map.of("slot1", false, "slot2", true))));
    }

    public static Set<String> getAvailableLocations() {
        Set<String> locations = new HashSet<>();
        for (ChargingStation station : chargingStations) {
            locations.add(station.location);
        }
        return locations;
    }

    public static List<ChargingStation> findChargingStations(String location, String chargerType) {
        List<ChargingStation> results = new ArrayList<>();
        for (ChargingStation station : chargingStations) {
            if (location != null && !station.location.equals(location)) {
                continue;
            }
            if (chargerType != null && !station.chargerType.equals(chargerType)) {
                continue;
            }
            results.add(station);
        }
        return results;
    }

    public static String bookSlot(int stationId, String slotName) {
        for (ChargingStation station : chargingStations) {
            if (station.id == stationId) {
                Boolean slotAvailable = station.slots.get(slotName);
                if (slotAvailable != null && slotAvailable) {
                    station.slots.put(slotName, false); // Mark slot as booked
                    return "Slot booked successfully!";
                } else {
                    return "Slot already booked. Please wait or choose another slot.";
                }
            }
        }
        return "Station or slot not found.";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the EV Charging Station Finder and Slot Booking System");
        
        System.out.println("\nAvailable locations:");
        Set<String> locations = getAvailableLocations();
        for (String location : locations) {
            System.out.println(location);
        }

        System.out.print("\nEnter location to search for stations: ");
        String location = scanner.nextLine();
        
        System.out.print("Enter charger type (Fast/Standard): ");
        String chargerType = scanner.nextLine();

        List<ChargingStation> stations = findChargingStations(location, chargerType);
        if (stations.isEmpty()) {
            System.out.println("No stations found.");
            return;
        }

        for (ChargingStation station : stations) {
            System.out.println("\nStation ID: " + station.id + ", Location: " + station.location + ", Charger Type: " + station.chargerType);
            for (Map.Entry<String, Boolean> slot : station.slots.entrySet()) {
                String status = slot.getValue() ? "Available" : "Booked";
                System.out.println("  Slot " + slot.getKey() + ": " + status);
            }
        }
        
        System.out.print("\nEnter Station ID to book a slot: ");
        int stationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Slot Name to book: ");
        String slotName = scanner.nextLine();

        String result = bookSlot(stationId, slotName);
        System.out.println(result);
        
        scanner.close();
    }
}
