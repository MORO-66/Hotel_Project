/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */
public class Rooms {
  int number;
  String type;
  double price;
  boolean status;
  Room(int number, String type, double price, boolean status);
  void addRoom(Room room);
  void updateRoom(Room room);
  void deleteRoom(int number);
  Room getRoomByNumber(int number);
  List<Room> getRoomsByFilter(String filter);
}