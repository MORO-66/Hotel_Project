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
     private String contactDetails;
    private  String address;
   
    public Customer(int id, String name, String email, String password, String contactDetails,String address) {
        super(id, name, email, password, "employee");
        this.contactDetails = contactDetails;
        this.address=address;
    }

    public String getContactDetails() {
        return this.contactDetails;
    }

    public String getAddress() {
        return this.address;
    }
    
     public void setContactDetails(String contactDetails) {
        this.contactDetails=contactDetails;
    }
      public void setaddress(String address) {
         this.address=address;
    }
}
