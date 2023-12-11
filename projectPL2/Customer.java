/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pl2test;

import static com.mycompany.pl2test.Customer.AddCustomer.FILE_NAME;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Customer extends User{

    public Customer(int id, String name, String email, String password, String role) {
        super(id, name, email, password, role);
    }

    @Override
    public String toString() {
        return  id+"و"+ name+"و"+ email+"و"+password+"و"+role; 
    }

    @Override
    public void setRole(String role) {
        super.setRole(role); 
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); 
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setId(int id) {
        super.setId(id); 
    }

    @Override
    public String getRole() {
        return super.getRole();
    }

    @Override
    public String getPassword() {
        return super.getPassword(); //
    }

    @Override
    public String getEmail() {
        return super.getEmail(); // Generated from 
    }

    @Override
    public String getName() {
        return super.getName(); 
    }

    @Override
    public int getId() {
        return super.getId(); 
    }

    @Override
    public void UserNumbers() {
        super.UserNumbers(); 
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }

    @Override
    public boolean equals(Object obj) {
        return equals(obj); 
    }


   
    Scanner sc=new Scanner(System.in);
    public class AddCustomer {

  // Define a constant for the file name
  public static final String FILE_NAME = "customer.txt";

 
  public static void addCustomer(Customer customer) {
    File file = new File(FILE_NAME);

    try {
      FileWriter writer = new FileWriter(file, true);

      writer.write(customer.toString());

      writer.close();

      // Print a success message
      System.out.println("Customer added successfully.");
    } catch (IOException e) {
      // Handle the exception
      e.printStackTrace();
    }
  }

 

    private void displayCustomerMenu() {
        System.out.println("\nCustomer Menu:");
        System.out.println("1. Add Customer");
        System.out.println("2. Update Customer");
        System.out.println("3. Delete Customer");
        System.out.println("4. Exit");
    }

    public void runCustomerMenu() {

        int choice;

        do {
            displayCustomerMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addCustomer(sc);
                    break;
                case 2:
                    updateCustomer(sc);
                    break;
                case 3:
                    deleteCustomer(sc);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
    
   // Define a main method to test the function
   public static void main(String[] args) {
    // Create some customer objects
    Customer c1 = new Customer(1,"Alice", "alice@example.com", "123","accuntant");
    Customer c2 = new Customer(2,"Bob", "bob@example.com","214","cook");

    // Call the function to add the customers to the file
    addCustomer(c1);
    addCustomer(c2);
        System.out.println("Enter the name of the customer to delete: ");
    Scanner sc=new Scanner(System.in);
    String email = sc.nextLine();

    // Call the function to delete the customer by name
    deleteCustomer(email);
  }
    }

    
}