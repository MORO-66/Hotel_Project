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
  String email;
  Customer(int id, String name, String password, String role, String address, String phone, String email);
  List<Room> getRooms();
  List<Service> getServices();
  double getTotalAmount();
}
