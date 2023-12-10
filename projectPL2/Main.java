package com.mycompany.projectpl2;
public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Hello , my Dear we are pleased to present our service");
            
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Register.registerUser();
                    break;
                case 2:
                    Login.loginUser();
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
