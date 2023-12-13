//]package com.mycompany.projectpl2;

/**
 *
 * @author user
 */
public class User {
    private static int latestId = 0;
    private static int id;
    private String name;
    private String email;
    private String password;
    private String role; // employee or customer

    // constructor

    public User(String name, String email, String password, String role) {
        this.id = ++latestId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User() {
        this.id = ++latestId;
    }

    public User(UserData userData) {

        this.id = userData.getId();
        this.name = userData.getName();
        this.email = userData.getEmail();
        this.password = userData.getPassword();
        this.role = userData.getRole();
    }

    // getters
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