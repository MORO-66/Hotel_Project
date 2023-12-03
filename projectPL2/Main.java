//package com.mycompany.projectpl2;

public class Main {
    public static void main(String[] args) {
        // Creating a user
        User user1 = new User(1, "John Doe", "john.doe@example.com", "password123", "customer");

        // Accessing user information using getters
        System.out.println("User ID: " + user1.getId());
        System.out.println("User Name: " + user1.getName());
        System.out.println("User Email: " + user1.getEmail());
        System.out.println("User Password: " + user1.getPassword());
        System.out.println("User Role: " + user1.getRole());

        // Modifying user information using setters
        user1.setEmail("john.doe.updated@example.com");

        // Displaying updated user information
        System.out.println("Updated User Email: " + user1.getEmail());
    }
}
