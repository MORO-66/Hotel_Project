package com.mycompany.projectpl2;

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
        return this.address=address;
    }
