// A class to represent an admin user
class Admin extends User {
  // Attributes of an admin user
  private String role; // The role of the admin user
  private String password; // The password of the admin user

  // A constructor to create an admin user object
  public Admin(String name, String email, String role, String password) {
    // Call the super class constructor
    super(name, email);
    // Initialize the admin attributes
    this.role = role;
    this.password = password;
  }

  // A method to get the role of the admin user
  public String getRole() {
    return role;
  }

  // A method to get the password of the admin user
  public String getPassword() {
    return password;
  }

  // A method to print the admin menu
  public void printAdminMenu() {
    // Print a welcome message
    System.out.println("Welcome, " + getName() + ". You are logged in as " + getRole() + ".");
    // Print the menu options
    System.out.println("Please choose an option from the menu:");
    System.out.println("1. Add a room");
    System.out.println("2. Update a room");
    System.out.println("3. Delete a room");
    System.out.println("4. Show all rooms");
    System.out.println("5. Show all reservations");
    System.out.println("6. Log out");
    // Create a scanner object to read the user input
    Scanner scanner = new Scanner(System.in);
    // Read the user choice
    int choice = scanner.nextInt();
    // Use a switch case to execute the corresponding function
    switch (choice) {
      case 1:
        // Call the addRoom function
        addRoom();
        break;
      case 2:
        // Call the updateRoom function
        updateRoom();
        break;
      case 3:
        // Call the deleteRoom function
        deleteRoom();
        break;
      case 4:
        // Call the showAllRooms function
        showAllRooms();
        break;
      case 5:
        // Call the showAllReservations function
        showAllReservations();
        break;
      case 6:
        // Call the logOut function
        logOut();
        break;
      default:
        // Print an invalid choice message
        System.out.println("Invalid choice. Please try again.");
        // Call the printAdminMenu function again
        printAdminMenu();
        break;
    }
  }

  // A method to add a room
  public void addRoom() {
    // Create a scanner object to read the user input
    Scanner scanner = new Scanner(System.in);
    // Prompt the user to enter the room details
    System.out.println("Please enter the room number:");
    int number = scanner.nextInt();
    System.out.println("Please enter the room type:");
    String type = scanner.next();
    System.out.println("Please enter the room price:");
    double price = scanner.nextDouble();
    System.out.println("Please enter the room availability (true or false):");
    boolean available = scanner.nextBoolean();
    // Create a room object with the given details
    Room room = new Room(number, type, price, available);
    // Call the addRoom method from the RoomManager class
    RoomManager.addRoom(room);
    // Print a confirmation message
    System.out.println("Room added successfully.");
    // Call the printAdminMenu function again
    printAdminMenu();
  }

  // A method to update a room
  public void updateRoom() {
    // Create a scanner object to read the user input
    Scanner scanner = new Scanner(System.in);
    // Prompt the user to enter the room number
    System.out.println("Please enter the room number to update:");
    int number = scanner.nextInt();
    // Prompt the user to enter the new room details
    System.out.println("Please enter the new room type:");
    String type = scanner.next();
    System.out.println("Please enter the new room price:");
    double price = scanner.nextDouble();
    System.out.println("Please enter the new room availability (true or false):");
    boolean available = scanner.nextBoolean();
    // Call the updateRoom method from the RoomManager class
    RoomManager.updateRoom(number, type, price, available);
    // Print a confirmation message
    System.out.println("Room updated successfully.");
    // Call the printAdminMenu function again
    printAdminMenu();
  }

  // A method to delete a room
  public void deleteRoom() {
    // Create a scanner object to read the user input
    Scanner scanner = new Scanner(System.in);
    // Prompt the user to enter the room number
    System.out.println("Please enter the room number to delete:");
    int number = scanner.nextInt();
    // Call the deleteRoom method from the RoomManager class
    RoomManager.deleteRoom(number);
    // Print a confirmation message
    System.out.println("Room deleted successfully.");
    // Call the printAdminMenu function again
    printAdminMenu();
  }

  // A method to show all rooms
  public void showAllRooms() {
    // Call the showAllRooms method from the RoomManager class
    RoomManager.showAllRooms();
    // Call the printAdminMenu function again
    printAdminMenu();
  }

  // A method to show all reservations
  public void showAllReservations() {
    // Call the showAllReservations method from the ReservationManager class
    ReservationManager.showAllReservations();
    // Call the printAdminMenu function again
    printAdminMenu();
  }

  // A method to log out
  public void logOut() {
    // Print a goodbye message
    System.out.println("Thank you for using the hotel management system. Goodbye.");
    // Exit the program
    System.exit(0);
  }
}