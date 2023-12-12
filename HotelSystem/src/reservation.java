//package com.mycompany.projectpl2;
// A class to represent a reservation
import java.awt.geom.QuadCurve2D;
import java.io.*;
import java.util.*;
class Reservation {
  // Attributes of a reservation
  private int id; // The reservation id
  private String name; // The name of the customer
  private int roomNumber; // The room number reserved
  private String checkInDate; // The check-in date
  private String checkOutDate; // The check-out date

  // A constructor to create a reservation object
  public Reservation(int id, String name, int roomNumber, String checkInDate, String checkOutDate) {
    this.id = id;
    this.name = name;
    this.roomNumber = roomNumber;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
  }

  // A method to get the reservation id
  public int getId() {
    return id;
  }

  // A method to get the name of the customer
  public String getName() {
    return name;
  }

  // A method to get the room number reserved
  public int getRoomNumber() {
    return roomNumber;
  }

  // A method to get the check-in date
  public String getCheckInDate() {
    return checkInDate;
  }

  // A method to get the check-out date
  public String getCheckOutDate() {
    return checkOutDate;
  }

  // A method to convert the reservation object to a string
  public String toString() {
    return id + "," + name + "," + roomNumber + "," + checkInDate + "," + checkOutDate;
  }
}

// A class to manage the reservation file
class ReservationManager {
  // A constant to store the name of the reservation file
  private static final String RESERVATION_FILE = "reservations.txt";

  // A method to find and reserve a room from the rooms file
  public static void findAndReserveRoom(String name, String type, double minPrice, double maxPrice, String checkInDate, String checkOutDate) {
    // Try to open the rooms file in read mode
    try (FileReader fr = new FileReader(RoomFileManager.ROOM_FILE);
         BufferedReader br = new BufferedReader(fr)) {
      // Read each line from the file
      String line = br.readLine();
      while (line != null) {
        // Split the line by comma
        String[] parts = line.split(",");
        // Create a room object from the parts
        Room room = new Room(Integer.parseInt(parts[0]), parts[1], parts[2], Double.parseDouble(parts[3]));
        // Check if the room matches the filter criteria and is available
        if (room.getType().equals(type) && room.getPrice() >= minPrice && room.getPrice() <= maxPrice && room.getStatus().equals("true")) {
          // Generate a random reservation id
          int id = (int) (Math.random() * 1000) + 1;
          // Create a reservation object with the given name and dates
          Reservation reservation = new Reservation(id, name, room.getNumber(), checkInDate, checkOutDate);
          // Add the reservation to the reservation file
          addReservation(reservation);
          // Set the room availability to false
          room.setStatus("false");
          // Update the room in the rooms file
          RoomFileManager.updateRoom(room.getNumber(), room);
          // Print a success message
          System.out.println("Room reserved successfully. Your reservation id is " + id + ".");
          // Return from the method
          return;
        }
        // Read the next line
        line = br.readLine();
      }
      // Close the file
      br.close();
      // Print a message that no room was found
      System.out.println("No room found that matches the filter and is available.");
    } catch (IOException e) {
      // Handle the exception
      e.printStackTrace();
    }
  }

  // A method to see my reservation from the reservation file
  public static void seeMyReservation(int id) {
    // Try to open the reservation file in read mode
    try (FileReader fr = new FileReader(RESERVATION_FILE);
         BufferedReader br = new BufferedReader(fr)) {
      // Read each line from the file
      String line = br.readLine();
      while (line != null) {
        // Split the line by comma
        String[] parts = line.split(",");
        // Create a reservation object from the parts
        Reservation reservation = new Reservation(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
        // Check if the reservation id matches the given id
        if (reservation.getId() == id) {
          // Print the reservation details
          System.out.println("Your reservation details are:");
          System.out.println("Name: " + reservation.getName());
          System.out.println("Room number: " + reservation.getRoomNumber());
          System.out.println("Check-in date: " + reservation.getCheckInDate());
          System.out.println("Check-out date: " + reservation.getCheckOutDate());
          // Return from the method
          return;
        }
        // Read the next line
        line = br.readLine();
      }
      // Close the file
      br.close();
      // Print a message that no reservation was found
      System.out.println("No reservation found with the given id.");
    } catch (IOException e) {
      // Handle the exception
      e.printStackTrace();
    }
  }

  // A method to write and add a reservation to the reservation file
  public static void writeAndAddReservation(String name, int roomNumber, String checkInDate, String checkOutDate) {
    // Generate a random reservation id
    int id = (int) (Math.random() * 1000) + 1;
    // Create a reservation object with the given name and dates
    Reservation reservation = new Reservation(id, name, roomNumber, checkInDate, checkOutDate);
    // Add the reservation to the reservation file
    addReservation(reservation);
    // Print a success message
    System.out.println("Reservation written and added successfully. Your reservation id is " + id + ".");
  }

  // A method to add a reservation to the reservation file
  private static void addReservation(Reservation reservation) {
    // Try to open the reservation file in append mode
    try (FileWriter fw = new FileWriter(RESERVATION_FILE, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw)) {
      // Write the reservation object as a string to the file
      pw.println(reservation.toString());
      // Close the file
      pw.close();
    } catch (IOException e) {
      // Handle the exception
      e.printStackTrace();
    }
  }

  // A method to show all reservations from the reservation file
  public static void showAllReservations() {
    // Try to open the reservation file in read mode
    try (FileReader fr = new FileReader(RESERVATION_FILE);
         BufferedReader br = new BufferedReader(fr)) {
      // Print a header
      System.out.println("All reservations are:");
      // Read each line from the file
      String line = br.readLine();
      while (line != null) {
        // Split the line by comma
        String[] parts = line.split(",");
        // Create a reservation object from the parts
        Reservation reservation = new Reservation(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
        // Print the reservation details
        System.out.println("Reservation id: " + reservation.getId());
        System.out.println("Name: " + reservation.getName());
        System.out.println("Room number: " + reservation.getRoomNumber());
        System.out.println("Check-in date: " + reservation.getCheckInDate());
        System.out.println("Check-out date: " + reservation.getCheckOutDate());
        System.out.println();
        // Read the next line
        line = br.readLine();
      }
      // Close the file
      br.close();
    } catch (IOException e) {
      // Handle the exception
      e.printStackTrace();
    }
  }
}