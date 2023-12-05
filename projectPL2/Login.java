package com.mycompany.projectpl2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    private static final String USER_FILE = "users.txt";

    public static void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    System.out.println("Login successful!");
                    if (parts[2].equals("admin")) {
                        System.out.println("Welcome, Admin!");
                    } else {
                        System.out.println("Welcome, Customer!");
                    }
                    return;
                }
            }
            System.out.println("Invalid username or password. Please try again.");
        } catch (IOException e) {
            System.out.println("Error occurred during login.");
            e.printStackTrace();
        }
    }
}
