/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */
public class Service {
  int id;
  String name;
  String description;
  double price;

  // constructor
  Service(int id, String name, String description, double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  // getters and setters
  // ...

  // methods
  void addService(Service s); // add a new service to the system
  void updateService(int id, Service s); // update an existing service by id
  void deleteService(int id); // delete a service by id
  void generateReport(); // generate a statistical report for the service usage
}