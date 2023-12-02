/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */

// Creating a class for room management
class RoomManagement {
  // Attributes of room management
  ArrayList<User> users; // List of users
  ArrayList<Room> rooms; // List of rooms
  ArrayList<Reservation> reservations; // List of reservations

  // Constructor of room management
  public RoomManagement(ArrayList<User> users, ArrayList<Room> rooms, ArrayList<Reservation> reservations) {
    this.users = users;
    this.rooms = rooms;
    this.reservations = reservations;
  }

  // Method to enter user/guest data if not available
  public void enterUserData() {
    // Creating a scanner object to take user input
    Scanner sc = new Scanner(System.in);

    // Asking the user to enter the customer id
    System.out.print("Enter the customer id: ");
    int customerId = sc.nextInt();

    // Checking if the customer id exists in the users list
    boolean exists = false;
    for (User user : users) {
      if (user.id == customerId && user.role.equals("customer")) {
        exists = true;
        break;
      }
    }

    // If the customer id does not exist, asking the user to enter the customer details
    if (!exists) {
      // Asking the user to enter the customer name
      System.out.print("Enter the customer name: ");
      sc.nextLine(); // Consuming the newline character
      String customerName = sc.nextLine();

      // Asking the user to enter the customer phone
      System.out.print("Enter the customer phone: ");
      String customerPhone = sc.nextLine();

      // Asking the user to enter the customer email
      System.out.print("Enter the customer email: ");
      String customerEmail = sc.nextLine();

      // Creating a user object for the customer
      User customer = new User(customerId, customerName, "customer", customerPhone, customerEmail);

      // Adding the customer to the users list
      users.add(customer);

      // Adding the customer to the database
      customer.addUser();
    }

    // Closing the scanner object
    sc.close();
  }

  
}