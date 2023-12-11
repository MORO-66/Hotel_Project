
//package com.mycompany.pl3;


import com.sun.jdi.IntegerType;

// constructor
  public class Employee {
    private int id;
    private String name;
    private String role;
    private String email;
    private String password;

    public Employee(String id, String name, String email
            , String password, String role) {
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

    @Override
    public String toString() {
      return id + "," + name + "," + role;
    }
    public String getFileName() {
      return "src/users/user/" + name + ".txt";
    }
  }




