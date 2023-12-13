import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {
  private int number;
  private String type;
  private String status;

  private double price;

  public Room(int number, String type, String status, double price) {
    this.number = number;
    this.type = type;
    this.status = status;
    this.price = price;
  }


  public int getNumber() {
    return this.number;
  }

  public String getType() {
    return this.type;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status){
    this.status = status;
  }
  public double getPrice(){
    return this.price;
  }
  @Override
  public String toString() {
    return number + "," + type + "," + status + "," + price;
  }
}
