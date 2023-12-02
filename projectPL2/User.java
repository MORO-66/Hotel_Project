/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */
public class User {

  int id;
  String name;
  String password;
  String role;
  User(int id, String name, String password, String role){
  int user_Id= id;
  String user_Name= name;
  String  user_Password =password;
  String user_Rule = role;


  }
  void addUser(User user);
  void updateUser(User user);
  void deleteUser(int id);
  User getUserById(int id);

}
