/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */
public class Customer extends User {
  String address;
  String phone;
  List<Reservation> reservations;

  // constructor
  Customer(int id, String name, String email, String password, String address, String phone) {
    super(id, name, email, password, "customer");
    this.address = address;
    this.phone = phone;
    this.reservations = new ArrayList<>();
  
  }
  // getters and setters
  // ...

  // methods
  void makeReservation(Reservation r); // make a new reservation and add it to the list
  void cancelReservation(int id); // cancel a reservation by id and remove it from the list
  void viewReservations(); // view all the reservations made by the customer
  void viewInvoice(); // view the detailed bill for the customer

}