
//package com.mycompany.pl3;


import com.sun.jdi.IntegerType;

// constructor
  public class Employee {
    private int id;
    private String name;
    private String role;
    private String email;
    private String password;

    public Employee(String id, String name,String password,  String email, String role) {
      this.id =Integer.parseInt(id);
      this.name = name;
      this.email = email;
      this.password = password;
      this.role = role;
    }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getRole() {
    return role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

    @Override
    public String toString() {
      return id + "," + name + "," +password + "," + email + "," + role;
    }
  }




