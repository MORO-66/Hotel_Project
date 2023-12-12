import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {

    private static final String CUSTOMER_FILE_PATH = "customers.txt";

    public Customer() {
        super();
    }

    public void addCustomer(Scanner scanner) {
        try {
            System.out.print("Enter customer name: ");
            String name = scanner.next();
            System.out.print("Enter customer email: ");
            String email = scanner.next();
            System.out.print("Enter customer password: ");
            String password = scanner.next();

            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPassword(password);

            // Save customer data to file
            saveCustomerToFile(customer);

            System.out.println("Customer added successfully!");
        } catch (IOException e) {
            System.out.println("Error adding customer: " + e.getMessage());
            // Handle the exception or log it as needed
        }
    }

    public void updateCustomer(Scanner scanner) {
        try {
            System.out.print("Enter customer ID to update: ");
            int id = scanner.nextInt();

            Customer customer = getCustomerById(id);
            if (customer != null) {
                System.out.print("Enter updated customer name: ");
                String name = scanner.next();
                System.out.print("Enter updated customer email: ");
                String email = scanner.next();
                System.out.print("Enter updated customer password: ");
                String password = scanner.next();

                customer.setName(name);
                customer.setEmail(email);
                customer.setPassword(password);

                // Update customer data in file
                updateCustomerInFile(customer);

                System.out.println("Customer updated successfully!");
            } else {
                System.out.println("Customer not found with ID: " + id);
            }
        } catch (IOException e) {
            System.out.println("Error updating customer: " + e.getMessage());
            // Handle the exception or log it as needed
        }
    }

    private Customer getCustomerById(int id) {
        return null;
    }

    public void deleteCustomer(Scanner scanner) {
        try {
            System.out.print("Enter customer ID to delete: ");
            int id = scanner.nextInt();

            // Delete customer data from file
            deleteCustomerFromFile(id);

            System.out.println("Customer deleted successfully!");
        } catch (IOException e) {
            System.out.println("Error deleting customer: " + e.getMessage());
            // Handle the exception or log it as needed
        }
    }

    // Helper method to save customer data to file
    private void saveCustomerToFile(Customer customer) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CUSTOMER_FILE_PATH, true))) {
            writer.println(customer.getId() + "," + customer.getName() + "," + customer.getEmail() + "," + customer.getPassword());
        }
    }

    // Helper method to update customer data in file
    private void updateCustomerInFile(Customer updatedCustomer) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);

                if (id == updatedCustomer.getId()) {
                    // Replace the line with updated data
                    lines.add(updatedCustomer.getId() + "," + updatedCustomer.getName() + "," + updatedCustomer.getEmail() + "," + updatedCustomer.getPassword());
                } else {
                    lines.add(line);
                }
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(CUSTOMER_FILE_PATH))) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }

    // Helper method to delete customer data from file
    private void deleteCustomerFromFile(int customerId) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);

                if (id != customerId) {
                    // Keep the line (customer) in the list
                    lines.add(line);
                }
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(CUSTOMER_FILE_PATH))) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }
}



///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
////package com.mycompany.projectpl2;
//
///**
// *
// * @author user
// */
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Customer extends User {
//
//    private static final String CUSTOMER_FILE_PATH = "customers.txt";
//    private List<Reservation> reservations;
//    private Invoice invoice;
//
//    public Customer() {
//        super();
//        this.reservations = new ArrayList<>();
//        this.invoice = new Invoice();
//    }
//
//    public void addCustomer(Scanner scanner) {
//        try {
//            System.out.print("Enter customer name: ");
//            String name = scanner.next();
//            System.out.print("Enter customer email: ");
//            String email = scanner.next();
//            System.out.print("Enter contact details: ");
//            String contactDetails = scanner.next();
//            System.out.print("Enter customer address: ");
//            String address = scanner.next();
//
//            int newId = super.generateUserId();
//            Customer customer = new Customer(newId, name, email, contactDetails, address, "customer");
//            super.addUser(customer);
//
//            System.out.println("Customer added successfully!");
//        } catch (IOException e) {
//            System.out.println("Error adding customer: " + e.getMessage());
//
//        }
//    }
//
////    public Customer updateCustomer(Scanner scanner) {
////        try {
////            System.out.print("Enter customer ID to update: ");
////            int id = scanner.nextInt();
////            Customer customer = getCustomerById(id);
////
////            System.out.print("Enter updated customer name: ");
////            String name = scanner.next();
////            System.out.print("Enter updated customer email: ");
////            String email = scanner.next();
////            System.out.print("Enter updated contact details: ");
////            String contactDetails = scanner.next();
////            System.out.print("Enter updated customer address: ");
////            String address = scanner.next();
////
////            customer.setName(name);
////            customer.setEmail(email);
////            customer.setContactDetails(contactDetails);
////            customer.setAddress(address);
////
////            super.updateUser(customer);
////
////            System.out.println("Customer updated successfully!");
////            return customer;
////        } catch (IOException e) {
////            System.out.println("Error updating customer: " + e.getMessage());
////            // Handle the exception or log it as needed
////            return null;
////        }
////    }
//
////    public void deleteCustomer(Scanner scanner) {
////        try {
////            System.out.print("Enter customer ID to delete: ");
////            int id = scanner.nextInt();
////            super.deleteUser(id);
////            System.out.println("Customer deleted successfully!");
////        } catch (IOException e) {
////            System.out.println("Error deleting customer: " + e.getMessage());
////
////        }
////    }
//
//
//
//    public void runCustomerMenu() {
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//        do {
//            Menu.displayMenu();
//            System.out.print("Enter your choice: ");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    addCustomer(scanner);
//                    break;
//                case 2:
//                    //updateCustomer(scanner);
//                    break;
//                case 3:
//                    //deleteCustomer(scanner);
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//
//        } while (choice != 4);
//
//        scanner.close();
//    }
//}
//
