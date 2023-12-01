/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */
public class Employee extends User {
  double salary;
  String department;
  Employee(int id, String name, String password, String role, double salary, String department);
  void assignRoom(Room room, Customer customer);
  void checkOutRoom(Room room, Customer customer);
  void addService(Service service, Customer customer);
  void generateInvoice(Customer customer);
}