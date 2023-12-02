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

  Service(int id, String name, String description, double price){
  int S_Id=id;
  String S_Name=name;
  String S_Description=description;
  double S_Price=price;


  }
  void addService(Service service);
  void updateService(Service service);
  void deleteService(int id);
  Service getServiceById(int id);
  List<Service> getAllServices();
  void generateReport();
}