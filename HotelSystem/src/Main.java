import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int c = 0;
        Menu.printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        User user = null;


        //ReservationManager.writeAndAddReservation();
        while (true) {
            Menu.Loginmenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Register.registerUser();
                    break;
                case 2:
                    UserData userData = Login.login();
                    user = new User(userData);
                    c = 1;
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            if (c == 1 && user.getRole().equals("admin")){
                Menu.printAdminMenu();
            }
            //System.out.println(user.getRole());
            if (c == 1 && user.getRole().equals("user")){
                Menu.displayEmployeeeMenu();
            }
            if (c == 1 && user.getRole().equals("customer")){
                Menu.displayCustomerMenu(user);
            }


        }
    }
}