/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pl2test;

/**
 *
 * @author user
 */
public class User {
    protected static int latestId = 0;
    int id;
    protected String name;
    protected String email;
    protected String password;
    String role; // employee or customer

    // constructor

    public void UserNumbers() {
        this.id = ++latestId;
    }

    public User(int id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return(id+","+ name+","+email+","+password+","+role  ); 
    }

  

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // setters with validation
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
            this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

