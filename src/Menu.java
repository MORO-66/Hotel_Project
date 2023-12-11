import java.io.*;
import java.util.*;

public class Menu {
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
        while (c != 0) {
            switch (choice) {
                case 1:
                    // Call the addRoom function
                    Admin.addRoomByAdmin();
                    break;
                case 2:
                    // Call the updateRoom function
                    Admin.updateRoomByAdmin();
                    break;
                case 3:
                    // Call the deleteRoom function
                    Admin.deleteRoomByAdmin();
                    break;
                case 4:
                    // Call the showAllRooms function
                    Admin.displayAllRooms();
                    break;
//            case 5:
//                // Call the showAllReservations function
//                showAllReservations();
//                break;
                case 6:
                    System.out.println("Good Bye");
                    c = 0;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}