import java.io.*;
import java.util.*;

public class /*Menu implements*/ Menu {
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
        System.out.println("Please choose an option from the menu:");
        System.out.println("1. Manage Employee");
        System.out.println("2. Manage Customer");
        System.out.println("3. Manage Rooms");
        System.out.println("4. Log out");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (c != 0) {
            switch (choice) {
                case 1:
                    // Call the addRoom function
                    adminEmployeeMenu();
                    break;
                case 2:
                    // Call the updateRoom function
                    RoomFileManager.updateRoomByAdmin();
                    break;
                case 3:
                    // Call the deleteRoom function
                    adminRoommenu();
                    break;
                case 4:
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
                // Call the addRoom function
                RoomFileManager.addRoomByAdmin();
                break;
            case 2:
                // Call the updateRoom function
                RoomFileManager.updateRoomByAdmin();
                break;
            case 3:
                // Call the deleteRoom function
                RoomFileManager.deleteRoomByAdmin();
                break;
            case 4:
                // Call the showAllRooms function
                RoomFileManager.displayAllRooms();
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    }

    public static void adminEmployeeMenu() {
        while (true) {
            System.out.println("Please choose an option from the menu:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Update an Employee");
            System.out.println("3. Delete an Employee");
            System.out.println("4. Show all Employee");
            System.out.println("6. previous");
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
                case 6:
                    return;
            }
        }
    }

    public static void displayCustomerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Customer C = new Customer();
                    C.addCustomer(scanner);
                    break;
                case 2:
                    Customer Ca = new Customer();
                    //Ca.updateCustomer();
                    break;
                case 3:
                    Customer Cu = new Customer();
                    //Cu.deleteCustomer();
                    //deleteCustomer(scanner);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();

    }
}