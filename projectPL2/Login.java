package com.mycompany.projectpl2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login extends User{

    private static void loginUser() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
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
        private static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Are you an admin? (yes/no): ");
        boolean isAdmin = scanner.nextLine().equalsIgnoreCase("yes");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(username + "," + password + "," + (isAdmin ? "admin" : "customer") + "\n");
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("Error occurred during registration.");
            e.printStackTrace();
        }
    }
}
