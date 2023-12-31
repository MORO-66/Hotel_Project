
import java.io.IOException;
import java.util.*;

public class  Menu {
    public static void Loginmenu() {
        System.out.println("Hello , my Dear we are pleased to present our service");

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    public static void printWelcomeMessage() {
        System.out.println("  ____            _    ____  _     _     _     \n" +
                " / ___| _   _ ___| | _| __ )| |   (_)___| |__  \n" +
                " \\___ \\| | | / __| |/ /  _ \\| |   | / __| '_ \\ \n" +
                "  ___) | |_| \\__ \\   <| |_) | |___| \\__ \\ | | |\n" +
                " |____/ \\__,_|___/_|\\_\\____/|_____|_|___/_| |_|");
        System.out.println("Welcome to the program with Java!");
    }

    public static void printAdminMenu() {
        int c = 1;

        while (c != 0) {
            System.out.println("Please choose an option from the menu:");
            System.out.println("1. Manage Employee");
            System.out.println("2. Manage Customer");
            System.out.println("3. Manage Rooms");
            System.out.println("4. Show all Reports");
            System.out.println("5. Log out");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {

                case 1:

                    adminEmployeeMenu();
                    break;
                case 2:
                    AdminCustomerMenu();
                    break;
                case 3:
                    adminRoommenu();
                    break;
                case 4:
                    Services s = new Services();
                    s.viewAllReports();
                    break;
                case 5:
                    System.out.println("Good Bye");
                    c = 0;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void adminRoommenu() {
        System.out.println("Please choose an option from the menu:");
        System.out.println("1. Add a room");
        System.out.println("2. Update a room");
        System.out.println("3. Delete a room");
        System.out.println("4. Show all rooms");
        System.out.println("6. previous");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                RoomFileManager.addRoomByAdmin();
                break;
            case 2:
                RoomFileManager.updateRoomByAdmin();
                break;
            case 3:
                RoomFileManager.deleteRoomByAdmin();
                break;
            case 4:
                RoomFileManager.displayAllRooms();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    }

    public static void adminEmployeeMenu() {
        int exit = 1;
        while (exit != 0) {
            System.out.println("Please choose an option from the menu:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Update an Employee");
            System.out.println("3. Delete an Employee");
            System.out.println("4. Show all Employee");
            System.out.println("5. previous");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    EmployeeManger.addEmployeeByAdmin();
                    break;
                case 2:
                    EmployeeManger.updateEmployeeByAdmin();
                    break;
                case 3:
                    EmployeeManger.deleteEmployeeByAdmin();
                    break;
                case 4:
                    EmployeeManger.displayAllEmployees();
                    break;
                case 5:
                    exit = 0;
                    return;
            }
        }
    }

    public static void AdminCustomerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Show Customers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CustomerFileManager.addCustomerByAdmin();
                    break;
                case 2:
                    CustomerFileManager.updateCustomerByAdmin();
                    break;
                case 3:
                    CustomerFileManager.deleteCustomerByAdmin();

                    break;
                case 4:
                    CustomerFileManager.displayAllCustomer();
                    break;
                case 5:
                    System.out.println("شرفنا يا باشا");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();

    }

    public static void displayCustomerMenu(User e) {

        int choice;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nHELLO THERE");
            System.out.println("1. BOOK ROOM");
            System.out.println("2. Request Service");
            System.out.println("3. Show Bill");
            System.out.println("4. LOG OUT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayBookMenu(e);
                    break;
                case 2:
                    displayServiceMenu(e);
                    break;
                case 3:
                    try {
                        System.out.println("you total price is :" + BOOKFILE.readExistingPrice(UserData.getName()));
                    }catch (IOException ee){System.out.println("all good");}
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

    }


    static void displayBookMenu(Object e) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View Room Availability");
            System.out.println("2. Book a Room");
            System.out.println("3. View My Bookings");
            System.out.println("4. Check-out");
            System.out.println("5. previous");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    RoomFileManager.displayAllRooms();
                    break;
                case 2:
                    BOOKFILE.bookRoom((User)e);
                    break;
                case 3:
                    BOOKFILE.viewMyBookings((User)e);
                    break;
                case 4:
                    BOOKFILE.checkOut((User)e);
                    break;
                case 5:
                    System.out.println("Logging out. Goodbye, ");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayServiceMenu(Object e){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View all services");
            System.out.println("2. Request Service");
            System.out.println("3. View My Bookings");
            System.out.println("4. generate reports");
            System.out.println("5. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Services n = new Services();
                    n.displayServices();
                    break;
                case 2:
                    Services na = new Services();
                    Object c = new Customer();
                    na.requestService((User) e);
                    break;
                case 3:

                    BOOKFILE.viewMyBookings((User) e);
                    break;
                case 4:
                    Services s = new Services();
                    s.createReport();
                    break;
                case 5:
                    System.out.println("Logging out. Goodbye, ");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    static void displayEmployeeeMenu(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nService Management:");
            System.out.println("1. Add Service");
            System.out.println("2. Update Service");
            System.out.println("3. Delete Service");
            System.out.println("4. Display Services");
            System.out.println("5. Display Requests Services");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Services s = new Services();
                    s.addService();
                    break;
                case 2:
                    Services se = new Services();
                    se.updateService();
                    break;
                case 3:
                    Services sa = new Services();
                    sa.deleteService();
                    break;
                case 4:
                    Services so = new Services();
                    so.displayServices();
                    break;
                case 5:
                    Services v = new Services();
                    v.viewRequestedServices();
                    break;
                case 6:
                    System.out.println("Exiting service management. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}