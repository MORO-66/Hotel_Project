// Importing the necessary packages
import java.io.*; // For file input and output
import java.time.*; // For date and time manipulation
import java.util.*; // For collections and utilities

// Creating a class for reservation
class Reservation {
  int customerId; 
  int roomId; 
  LocalDate checkIn; // Check-in date
  LocalDate checkOut; // Check-out date
  double total; // Total amount

  // Constructor of reservation
  public Reservation(int customerId, int roomId, LocalDate checkIn, LocalDate checkOut, double total) {
    this.customerId = customerId;
    this.roomId = roomId;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.total = total;
  }

  // Method to write a reservation to a file
  public void writeReservation() {
    try {
      // Creating a file object for the reservation file
      File file = new File("reservations.txt");

      // Creating a file writer object to append to the file
      FileWriter fw = new FileWriter(file, true);

      // Creating a buffered writer object to write to the file
      BufferedWriter bw = new BufferedWriter(fw);

      // Writing the reservation details to the file
      bw.write(this.customerId + "," + this.roomId + "," + this.checkIn + "," + this.checkOut + "," + this.total + "\n");

      // Closing the buffered writer and file writer
      bw.close();
      fw.close();

      // Printing a success message
      System.out.println("Reservation written successfully.");
    } catch (IOException e) {
      // Printing an error message
      System.out.println("Error: " + e.getMessage());
    }
  }

  // Method to read all reservations from a file
  public static ArrayList<Reservation> readAllReservations() {
    // Creating an array list to store the reservations
    ArrayList<Reservation> reservations = new ArrayList<>();

    try {
      // Creating a file object for the reservation file
      File file = new File("reservations.txt");

      // Creating a file reader object to read from the file
      FileReader fr = new FileReader(file);

      // Creating a buffered reader object to read from the file
      BufferedReader br = new BufferedReader(fr);

      // Reading a line from the file
      String line = br.readLine();

      // Looping until the end of the file
      while (line != null) {
        // Splitting the line by comma
        String[] data = line.split(",");

        // Parsing the data to create a reservation object
        int customerId = Integer.parseInt(data[0]);
        int roomId = Integer.parseInt(data[1]);
        LocalDate checkIn = LocalDate.parse(data[2]);
        LocalDate checkOut = LocalDate.parse(data[3]);
        double total = Double.parseDouble(data[4]);
        Reservation reservation = new Reservation(customerId, roomId, checkIn, checkOut, total);

        // Adding the reservation to the array list
        reservations.add(reservation);

        // Reading the next line from the file
        line = br.readLine();
      }

      // Closing the buffered reader and file reader
      br.close();
      fr.close();

      // Printing a success message
      System.out.println("Reservations read successfully.");
    } catch (IOException e) {
      // Printing an error message
      System.out.println("Error: " + e.getMessage());
    }

    // Returning the array list of reservations
    return reservations;
  }
}

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

    // Switching on the choice
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
  }}