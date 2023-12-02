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
}