# EV_charging_station


# EV Charging Station Finder and Slot Booking System

## Overview

This Java program simulates an Electric Vehicle (EV) Charging Station Finder and Slot Booking system. With the increasing adoption of electric vehicles, finding a suitable charging station and reserving a charging slot in advance has become essential. This system allows users to:

1. View a list of available charging locations.
2. Search for charging stations based on location and charger type.
3. View the availability of charging slots at each station.
4. Book a charging slot, with the system notifying users if the slot is already booked and prompting them to wait or choose another slot.

## Code Explanation

### 1. ChargingStation Class

The 'ChargingStation' class represents a charging station in the system. It contains the following attributes:
- id: A unique identifier for the charging station.
- location: The physical location of the charging station (e.g., Downtown, Uptown).
- chargerType: The type of charger available at the station (e.g., Fast, Standard).
- slots: A map representing the charging slots at the station. The key is the slot name (e.g., "slot1"), and the value is a boolean indicating availability ('true' means available, 'false' means booked).

### 2. EVChargingSystem Class

The 'EVChargingSystem' class is the core of the application, managing the list of charging stations and providing methods for searching and booking.

#### Attributes:
- chargingStations: A static list of 'ChargingStation' objects. This list is pre-populated with a few stations and their slot availability for demonstration purposes.

#### Methods:

- getAvailableLocations(): 
  - This method returns a set of all unique locations where charging stations are available. It allows users to see all available locations before searching for a specific station.

- findChargingStations(String location, String chargerType):
  - This method filters and returns a list of charging stations based on the specified location and charger type. If the location or charger type doesn't match any station, it returns an empty list.

- bookSlot(int stationId, String slotName):
  - This method attempts to book a specified slot at a station identified by 'stationId'. If the slot is available, it marks the slot as booked ('false' in the slots map) and returns a success message. If the slot is already booked, it returns a message informing the user that they need to wait or choose another slot.

#### Main Method:

The 'main' method is the entry point of the application. It guides the user through the process of finding a charging station and booking a slot:

1. Display Available Locations:
   - The program first displays a list of all available locations using the 'getAvailableLocations()' method.

2. User Input:
   - The user is prompted to enter a location and charger type to search for suitable charging stations.

3. Search Results:
   - The program calls 'findChargingStations()' to search for stations that match the user's criteria. If no stations are found, the program informs the user and terminates.

4. Display Station and Slot Details:
   - If matching stations are found, the program displays each station's ID, location, charger type, and the availability status of its slots (either "Available" or "Booked").

5. Slot Booking:
   - The user is prompted to enter the 'Station ID' and 'Slot Name' they wish to book. The program then calls 'bookSlot()' to attempt the booking.
   - The result of the booking attempt is displayed to the user, indicating whether the slot was successfully booked or if they need to wait or choose another slot.

### Example Workflow

1. The user views available locations: Downtown, Uptown, Midtown, Suburb.
2. The user searches for stations in "Downtown" with "Fast" chargers.
3. The system displays matching stations and their slot availability.
4. The user selects a station and a slot to book.
5. The system confirms the booking or notifies the user if the slot is already booked.

### Future Enhancements

This basic implementation can be extended with features such as:
- Integrating a database for persistent storage of stations and bookings.
- Implementing user authentication and session management.
- Adding a graphical user interface (GUI) for ease of use.
- Supporting real-time updates on slot availability.
