//package com.mycompany.projectpl2;
import java.io.*;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Menu.printWelcomeMessage();
        while (true) {
            Menu.Loginmenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Register.registerUser();
                    break;
                case 2:
                    Login.login();
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

}

