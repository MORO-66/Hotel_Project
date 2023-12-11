package com.mycompany.projectpl2;

// A class to represent a hotel room
class Room {
  // Attributes of a room
  private int number; // The room number
  private String type; // The room type (single, double, etc.)
  private double price; // The room price per night
  private boolean available; // The availability status of the room

  // A constructor to create a room object
  public Room(int number, String type, double price, boolean available) {
    this.number = number;
    this.type = type;
    this.price = price;
    this.available = available;
  }

  // A method to get the room number
  public int getNumber() {
    return number;
  }

  // A method to get the room type
  public String getType() {
    return type;
  }

  // A method to get the room price
  public double getPrice() {
    return price;
  }

  // A method to get the availability status
  public boolean isAvailable() {
    return available;
  }

  // A method to set the availability status
  public void setAvailable(boolean available) {
    this.available = available;
  }

  // A method to convert the room object to a string
  public String toString() {
    return number + "," + type + "," + price + "," + available;
  }
}

// A class to manage the rooms file
class RoomManager {
  // A constant to store the name of the rooms file
  private static final String ROOMS_FILE = "rooms.txt";

  // A method to add a room to the rooms file
  public static void addRoom(Room room) {
    // Try to open the rooms file in append mode
    try (FileWriter fw = new FileWriter(ROOMS_FILE, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw)) {
      // Write the room object as a string to the file
      pw.println(room.toString());
      // Close the file
      pw.close();
      // Print a success message
      System.out.println("Room added successfully.");
    } catch (IOException e) {
      // Handle the exception
      e.printStackTrace();
    }
  }
  // A method to update a room in the rooms file
public static void updateRoom(int number, String type, double price, boolean available) {
    // Try to open the rooms file in read mode
    try (FileReader fr = new FileReader(ROOMS_FILE);
         BufferedReader br = new BufferedReader(fr)) {
      // Create a list to store the rooms
      List<Room> rooms = new ArrayList<>();
      // Read each line from the file
      String line = br.readLine();
      while (line != null) {
        // Split the line by comma
        String[] parts = line.split(",");
        // Create a room object from the parts
        Room room = new Room(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]));
        // Check if the room number matches the given number
        if (room.getNumber() == number) {
          // Update the room attributes with the given values
          room.setType(type);
          room.setPrice(price);
          room.setAvailable(available);
        }
        // Add the room to the list
        rooms.add(room);
        // Read the next line
        line = br.readLine();
      }
      // Close the file
      br.close();
      // Try to open the rooms file in write mode
      try (FileWriter fw = new FileWriter(ROOMS_FILE);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw)) {
        // Write each room from the list to the file
        for (Room room : rooms) {
          pw.println(room.toString());
        }
        // Close the file
        pw.close();
        // Print a success message
        System.out.println("Room updated successfully.");
      } catch (IOException e) {
        // Handle the exception
        e.printStackTrace();
      }
    } catch (IOException e) {
      // Handle the exception
      e.printStackTrace();
    }
  }
  
  // A method to delete a room from the rooms file
  public static void deleteRoom(int number) {
    // Try to open the rooms file in read mode
    try (FileReader fr = new FileReader(ROOMS_FILE);
         BufferedReader br = new BufferedReader(fr)) {
      // Create a list to store the rooms
      List<Room> rooms = new ArrayList<>();
      // Read each line from the file
      String line = br.readLine();
      while (line != null) {
        // Split the line by comma
        String[] parts = line.split(",");
        // Create a room object from the parts
        Room room = new Room(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]));
        // Check if the room number matches the given number
        if (room.getNumber() != number) {
          // Add the room to the list
          rooms.add(room);
        }
        // Read the next line
        line = br.readLine();
      }
      // Close the file
      br.close();
      // Try to open the rooms file in write mode
      try (FileWriter fw = new FileWriter(ROOMS_FILE);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw)) {
        // Write each room from the list to the file
        for (Room room : rooms) {
          pw.println(room.toString());
        }
        // Close the file
        pw.close();
        // Print a success message
        System.out.println("Room deleted successfully.");
      } catch (IOException e) {
        // Handle the exception
        e.printStackTrace();
      }
    } catch (IOException e) {
      // Handle the exception
      e.printStackTrace();
    }
  }
  
  // A method to get a room by filter from the rooms file
  public static Room getRoomByFilter(String type, double minPrice, double maxPrice, boolean available) {
    // Try to open the rooms file in read mode
    try (FileReader fr = new FileReader(ROOMS_FILE);
         BufferedReader br = new BufferedReader(fr)) {
      // Read each line from the file
      String line = br.readLine();
      while (line != null) {
        // Split the line by comma
        String[] parts = line.split(",");
        // Create a room object from the parts
        Room room = new Room(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]));
        // Check if the room matches the filter criteria
        if (room.getType().equals(type) && room.getPrice() >= minPrice && room.getPrice() <= maxPrice && room.isAvailable() == available) {
          // Return the room
          return room;
        }
        // Read the next line
        line = br.readLine();
      }
      // Close the file
      br.close();
      // Print a message that no room was found
      System.out.println("No room found that matches the filter.");
    } catch (IOException e) {
      // Handle the exception
      e.printStackTrace();
    }
    // Return null if no room was found
    return null;
  }
}