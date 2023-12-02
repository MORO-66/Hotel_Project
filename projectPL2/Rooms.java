/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */
  class Room {
  int number;
  String type; // single, double, suite, etc.
  double price;
  boolean isBusy;
  List<Service> services;

  // constructor
  Room(int number, String type, double price, boolean isBusy) {
    this.number = number;
    this.type = type;
    this.price = price;
    this.isBusy = isBusy;
    this.services = new ArrayList<>();
  
  }
  // getters and setters
  // ...

  // methods
  void assignToCustomer(Customer c); // assign the room to a customer and mark it as busy
  void releaseFromCustomer(); // release the room from the customer and mark it as free
  void addService(Service s); // add a service to the room and update the price
  void removeService(Service s); // remove a service from the room and update the price
}
