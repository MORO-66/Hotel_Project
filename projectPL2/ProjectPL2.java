/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projectpl2;
import com.mycompany.projectpl2.*;

import java.util.Scanner;

/**
 *
 * @author Mohamed Hassanin
 */
public class ProjectPL2 {
    public static void main(String[] args) {

    }


    // A function that displays the hotel menu and calls the appropriate function based on the user's choice
public static void hotelMenu() {
    // Create a scanner object to read user input
    Scanner scanner = new Scanner(System.in);
  
    // Declare a variable to store the user's choice
    int choice;
  
    // Use a do-while loop to repeat the menu until the user chooses to exit
    do {
      // Display the menu options
      System.out.print("\nWelcome to the Hotel Reservation Application\n" +
                  "--------------------------------------------\n" +
                  "1. Find and reserve a room\n" +
                  "2. See my reservations\n" +
                  "3. Create an Account\n" +
                  "4. Admin\n" +
                  "5. Exit\n" +
                  "--------------------------------------------\n" +
                  "Please select a number for the menu option:\n");
  
      // Read the user's choice as an integer
      choice = scanner.nextInt();
  
      // Use a switch case to execute the corresponding function based on the choice
      switch (choice) {
        case 1:
          // Call the function that finds and reserves a room
          findAndReserveRoom();
          break;
        case 2:
          // Call the function that shows the user's reservations
          seeMyReservations();
          break;
        case 3:
          // Call the function that creates an account for the user
          createAnAccount();
          break;
        case 4:
          // Call the function that allows the admin to perform some tasks
          admin();
          break;
        case 5:
          // Display a farewell message and exit the loop
          System.out.println("Thank you for using the Hotel Reservation Application. Have a nice day!");
          break;
        default:
          // Display an error message for invalid input and repeat the menu
          System.out.println("Invalid input. Please enter a number between 1 and 5.");
          break;
      }
    } while (choice != 5); // Repeat the loop until the user chooses to exit
  }
}
     
