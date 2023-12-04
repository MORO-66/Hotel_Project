/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */

  public class Rooms{
  
    private List<Room> rooms;
  
    public Rooms(){
  
      this.rooms = new ArrayList<>();
  
  }
  
public class Room {
  private int number;
  private String type;
  private double price;
  private boolean status;

   public Room(int number, String type, double price, boolean status){
            this.number = number;
            this.type = type;
            this.price = price;
            this.status = status;

  };
  
  public void setNumber(int number){
      this.number=number;
  };

    public int getNumber(){
      return number;
  };

  public String setType(String type){
      this.type=type;
  };

    public String getType(){
      return type;
  };
  
  public void setPrice(double price){
      this.price=price;
  };
  
  public double getPrice(){
      return price;
  };

 public void setStatus(boolean status){
      this.status=status;
  }  

  public boolean getStatus(){
      return status;
  }

  public void addRoom(Room room){
      
      rooms.add(room);
      
  };
 public void updateRoom(Room room){
for (Room r : rooms){
    if (r.getNumber() == room.getNumber()){
        r.setType(room.getType());
        r.setPrice(room.getPrice());
        r.setStatus(room.getStatus());
        break;
        }
    }
 };
 public void deleteRoom(int number){
        rooms.removeIf(room -> room.getNumber() == number);
  };
 public Room getRoomByNumber(int number){
       for (Room room : rooms) {
            if (room.getNumber() == number) {
                return room;
            }
        }
        return null;
  };
public List<Room> getRoomsByFilter(String filter){
      List<Room> filteredRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getType().equalsIgnoreCase(filter) || String.valueOf(room.getStatus()).equalsIgnoreCase(filter)) {
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }
}
}

