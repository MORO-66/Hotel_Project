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
Customer(){  
int id;
String name;
String password;
String role;
String address;
String phone;
String email;
}
  Customer(int id, String name, String password, String role, String address, String phone, String email)
  {
   int customer_Id=id;
   String Customer_Name=name;
   String Customer_Password=password;
   String Customer_Role=role;
   String Address=address;
   String Phone=phone;
   String Email=email;
  
  
  }
  
  List<Room> getRooms();
  List<Service> getServices();
  double getTotalAmount();

}
