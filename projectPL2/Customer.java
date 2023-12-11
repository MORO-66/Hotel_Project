/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {

    private static final String CUSTOMER_FILE_PATH = "customers.txt";
    private List<Reservation> reservations;
    private Invoice invoice;

    public Customer() {
        super();
        this.reservations = new ArrayList<>();
        this.invoice = new Invoice(); // Assuming you have an Invoice class
    }

    public void addCustomer(Scanner scanner) {
        try {
            System.out.print("Enter customer name: ");
            String name = scanner.next();
            System.out.print("Enter customer email: ");
            String email = scanner.next();
            System.out.print("Enter contact details: ");
            String contactDetails = scanner.next();
            System.out.print("Enter customer address: ");
            String address = scanner.next();

            int newId = super.generateUserId();
            Customer customer = new Customer(newId, name, email, contactDetails, address, "customer");
            super.addUser(customer);

            System.out.println("Customer added successfully!");
        } catch (IOException e) {
            System.out.println("Error adding customer: " + e.getMessage());
            // Handle the exception or log it as needed
        }
    }

    public Customer updateCustomer(Scanner scanner) {
        try {
            System.out.print("Enter customer ID to update: ");
            int id = scanner.nextInt();
            Customer customer = getCustomerById(id);

            System.out.print("Enter updated customer name: ");
            String name = scanner.next();
            System.out.print("Enter updated customer email: ");
            String email = scanner.next();
            System.out.print("Enter updated contact details: ");
            String contactDetails = scanner.next();
            System.out.print("Enter updated customer address: ");
            String address = scanner.next();

            customer.setName(name);
            customer.setEmail(email);
            customer.setContactDetails(contactDetails);
            customer.setAddress(address);

            super.updateUser(customer);

            System.out.println("Customer updated successfully!");
            return customer;
        } catch (IOException e) {
            System.out.println("Error updating customer: " + e.getMessage());
            // Handle the exception or log it as needed
            return null;
        }
    }

    public void deleteCustomer(Scanner scanner) {
        try {
            System.out.print("Enter customer ID to delete: ");
            int id = scanner.nextInt();
            super.deleteUser(id);
            System.out.println("Customer deleted successfully!");
        } catch (IOException e) {
            System.out.println("Error deleting customer: " + e.getMessage());
            // Handle the exception or log it as needed
        }
    }

    private void displayMenu() {
        System.out.println("\nCustomer Menu:");
        System.out.println("1. Add Customer");
        System.out.println("2. Update Customer");
        System.out.println("3. Delete Customer");
        System.out.println("4. Exit");
    }

    public void runCustomerMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    updateCustomer(scanner);
                    break;
                case 3:
                    deleteCustomer(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}

