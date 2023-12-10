package com.mycompany.projectpl2;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
/**
 *
 * @author user
 */
public class Employee extends User {
  private double salary;
  private String department;
  private static List<Employee> employees = new ArrayList<>();
  private static List<Customer> customers = new ArrayList<>();
  private static List<Room> rooms = new ArrayList<>();



  // constructor
  Employee(int id, String name, String email, String password, double salary, String department) {
    super(id, name, email, password, "employee");
    this.salary = salary;
    this.department = department;
  }

  // getters and setters
  public double getSalary() {
        return salary;
    }
   public void setSalary(double salary) {
        this.salary = salary;
    }
   public String getDepartment() {
        return department;
    }
   public void setDepartment(String department) {
        this.department = department;
    }
  // methods
  
  //void addEmployee(Employee e); // add a new employee to the system
   public static void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("Employee added successfully!");
    }
 // void updateEmployee(int id, Employee e); // update an existing employee by id
   public static void updateEmployee(int id, Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                // Update the employee details
                employee.setName(updatedEmployee.getName());
                employee.setEmail(updatedEmployee.getEmail());
                employee.setPassword(updatedEmployee.getPassword());
                employee.setSalary(updatedEmployee.getSalary());
                employee.setDepartment(updatedEmployee.getDepartment());
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
 // void deleteEmployee(int id); // delete an employee by id
   public static void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
        System.out.println("Employee deleted successfully!");
    }
 // void addCustomer(Customer c); // add a new customer to the system
   public static void addCustomer(Customer c) {
        customers.add(c);
        System.out.println("Customer added successfully!");
    }
 // void updateCustomer(int id, Customer c); // update an existing customer by id
   public static void updateCustomer(int id, Customer updatedCustomer) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                // Update the customer details
                customer.setName(updatedCustomer.getName());
                customer.setEmail(updatedCustomer.getEmail());
                customer.setPassword(updatedCustomer.getPassword());
                System.out.println("Customer updated successfully!");
                return;
            }
        }
        System.out.println("Customer with ID " + id + " not found.");
    }
 // void deleteCustomer(int id); // delete a customer by id
    public static void deleteCustomer(int id) {
        customers.removeIf(customer -> customer.getId() == id);
        System.out.println("Customer deleted successfully!");
    }

 // void addRoom(Room r); // add a new room to the system (assignroom)
    public static void addRoom(Room r) {
        rooms.add(r);
        System.out.println("Room added successfully!");
    }
 // void updateRoom(int number, Room r); // update an existing room by number
    public static void updateRoom(int number, Room updatedRoom) {
        for (Room room : rooms) {
            if (room.getNumber() == number) {
                // Update the room details
                room.setType(updatedRoom.getType());
                room.setService(updatedRoom.getService());
                room.setBusy(updatedRoom.isBusy());
                System.out.println("Room updated successfully!");
                return;
            }
        }
        System.out.println("Room with number " + number + " not found.");
    }
 // void deleteRoom(int number); // delete a room by number
    public static void deleteRoom(int number) {
        rooms.removeIf(room -> room.getNumber() == number);
        System.out.println("Room deleted successfully!");
    }






  
  // Method to assign room to guest
  public void assignRoom() {
    // Creating a scanner object to take user input
    Scanner sc = new Scanner(System.in);

    // Asking the user to enter the customer id
    System.out.print("Enter the customer id: ");
    int customerId = sc.nextInt();

    // Asking the user to enter the room number
    System.out.print("Enter the room number: ");
    int roomNumber = sc.nextInt();

    // Asking the user to enter the check-in date
    System.out.print("Enter the check-in date (yyyy-mm-dd): ");
    sc.nextLine(); 
    String checkInDate = sc.nextLine();

    // Asking the user to enter the check-out date
    System.out.print("Enter the check-out date (yyyy-mm-dd): ");
    String checkOutDate = sc.nextLine();

    // Parsing the check-in and check-out dates
    LocalDate checkIn = LocalDate.parse(checkInDate);
    LocalDate checkOut = LocalDate.parse(checkOutDate);

    // Finding the room object from the rooms list
    Room room = null;
    for (Room r : rooms) {
      if (r.number == roomNumber) {
        room = r;
        break;
      }
    }

}
// Method to filter rooms via different options
public ArrayList<Room> filterRooms() {
  // Creating an array list to store the filtered rooms
  ArrayList<Room> filteredRooms = new ArrayList<>();

  // Creating a scanner object to take user input
  Scanner sc = new Scanner(System.in);

  // Asking the user to choose a filter option
  System.out.println("Choose a filter option:");
  System.out.println("1. Filter by room availability");
  System.out.println("2. Filter by room type");
  System.out.println("3. Filter by room service");
  System.out.print("Enter your choice: ");
  int choice = sc.nextInt();

  switch (choice) {
    case 1:
      // Asking the user to enter the room availability
      System.out.print("Enter the room availability (true for busy, false for free): ");
      boolean availability = sc.nextBoolean();

      // Looping through the rooms list
      for (Room room : rooms) {
        // Checking if the room availability matches the user input
        if (room.busy == availability) {
          // Adding the room to the filtered rooms list
          filteredRooms.add(room);
        }
      }
      break;
    case 2:
      // Asking the user to enter the room type
      System.out.print("Enter the room type (single, double, or suite): ");
      sc.nextLine(); // Consuming the newline character
      String type = sc.nextLine();

      // Looping through the rooms list
      for (Room room : rooms) {
        // Checking if the room type matches the user input
        if (room.type.equals(type)) {
          // Adding the room to the filtered rooms list
          filteredRooms.add(room);
        }
      }
      break;
    case 3:
      // Asking the user to enter the room service
      System.out.print("Enter the room service: ");
      sc.nextLine(); // Consuming the newline character
      String service = sc.nextLine();

      // Looping through the rooms list
      for (Room room : rooms) {
        // Checking if the room service matches the user input
        if (room.service.equals(service)) {
          // Adding the room to the filtered rooms list
          filteredRooms.add(room);
        }
      }
      break;
    default:
      // Printing an invalid choice message
      System.out.println("Invalid choice.");
      break;
  }

  // Closing the scanner object
  sc.close();

  // Returning the filtered rooms list
  return filteredRooms;
}
private static void createAccount() {
  final Scanner scanner = new Scanner(System.in);

  System.out.println("Enter Email format: name@domain.com");
  final String email = scanner.nextLine();

  System.out.println("First Name:");
  final String firstName = scanner.nextLine();

  System.out.println("Last Name:");
  final String lastName = scanner.nextLine();

  try {
      createACustomer(email, firstName, lastName);
      System.out.println("Account created successfully!");

      printMainMenu();
  } catch (IllegalArgumentException ex) {
      System.out.println(ex.getLocalizedMessage());
      createAccount();
  }
}
}