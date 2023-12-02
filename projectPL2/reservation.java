// Importing the necessary packages
import java.io.*; // For file input and output
import java.time.*; // For date and time manipulation
import java.util.*; // For collections and utilities

// Creating a class for reservation
class Reservation {
  int id;
  Customer customer;
  Room room;
  Date checkInDate;
  Date checkOutDate;

  // constructor
  Reservation(int id, Customer customer, Room room, Date checkInDate, Date checkOutDate) {
    this.id = id;
    this.customer = customer;
    this.room = room;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
  }

  // getters and setters
  // ...


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
      bw.write(this.customerId + "\n" + this.roomId + "\n" + this.checkIn + "\n" + this.checkOut + "\n" + this.total + "\n");

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
        String[] data = line.split("\n");

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