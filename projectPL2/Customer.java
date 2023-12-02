/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */


public class Customer {
    private final String customerId;
    private final String name;
    private final String contactDetails;
    private final String address;

    public Customer(String name, String contactDetails, String address) {
        this.customerId = UUID.randomUUID().toString();
        this.name = name;
        this.contactDetails = contactDetails;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public String getAddress() {
        return address;
    }
}
