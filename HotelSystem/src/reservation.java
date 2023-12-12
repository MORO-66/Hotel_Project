//package com.mycompany.projectpl2;
// A class to represent a reservation
import java.awt.geom.QuadCurve2D;
import java.io.*;
import java.util.*;
public class reservation {
  // Attributes of a reservation
  private int id; // The reservation id
  private String name; // The name of the customer
  private int roomNumber; // The room number reserved
  private String checkInDate; // The check-in date
  private String checkOutDate; // The check-out date

  // A constructor to create a reservation object
  public reservation(int id, String name, int roomNumber, String checkInDate, String checkOutDate) {
    this.id = id;
    this.name = name;
    this.roomNumber = roomNumber;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
  }

  // A method to get the reservation id
  public int getId() {
    return id;
  }

  // A method to get the name of the customer
  public String getName() {
    return name;
  }

  // A method to get the room number reserved
  public int getRoomNumber() {
    return roomNumber;
  }

  // A method to get the check-in date
  public String getCheckInDate() {
    return checkInDate;
  }

  public String getCheckOutDate() {
    return checkOutDate;
  }

  public String toString() {
    return id + "," + name + "," + roomNumber + "," + checkInDate + "," + checkOutDate;
  }
}
