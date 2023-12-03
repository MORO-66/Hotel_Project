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
  private int id;
  private String name;
  private String email;
  private String password;
  private String role; // employee or customer

  // constructor
  User(int id, String name, String email, String password, String role) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  // getters and setters
  // ...

}