//package com.mycompany.projectpl2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Menu.printWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        User user = null;

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
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            if (user.getRole().equals("admin") ){
                Menu.printAdminMenu();
            }


        }
    }
}