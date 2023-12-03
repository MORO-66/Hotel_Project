/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */


 public class Customer extends User{
   
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
    
     public String setContactDetails(String contactDetails) {
        return this.contactDetails=contactDetails;
    }
      public String setaddress(String address) {
        return this.address= address;
    }
public int getId() {
    return this.id;
}

public String getName() {
    return this.name;
}

 public String getpassword(){
 return this.password;
 }
  public String getrole(){
  return this.role;
      }
}
  // getters and setters
  // ...

  // methods
  void makeReservation(Reservation r); // make a new reservation and add it to the list
  void cancelReservation(int id); // cancel a reservation by id and remove it from the list
  void viewReservations(); // view all the reservations made by the customer
  void viewInvoice(); // view the detailed bill for the customer

}