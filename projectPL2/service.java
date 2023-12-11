/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Service {
 private int id;
 private String name;
 private String description;
 private double price;
 private List<ServiceUsage> serviceUsages;
 private static final String DATA_FILE = "services.txt";

private static class ServiceUsage {
        int serviceId;
        int usageCount;

        ServiceUsage(int serviceId) {
            this.serviceId = serviceId;
            this.usageCount = 1;
        }

        void incrementUsage() {
            this.usageCount++;
        }
    }
  // constructor
  Service(int id, String name, String description, double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  // getters and setters
  public void setID(int id){
      this.id=id;
  } 
  public int getID(){
      return id;
  }
  public void setName(String name){
      this.name=name;
  }
  public String getName(){
      return name;
  }
  public void setDescription(String description){
      this.description=description;
  }
  public String getDescription(){
      return description;
  }
  public void setPrice(double price){
      this.price=price;
  }
  public double getPrice(){
      return price;
  }       
  // methods
  void addService(Service s){
      
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE, true))) {
            writer.println(s.getId() + "\n" + s.getName() + "\n" + s.getDescription() + "\n" + s.getPrice());
        } catch (IOException e) {
            e.printStackTrace();
        }
  } // add a new service to the system
  void updateService(int id, Service s) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\n");
                int currentId = Integer.parseInt(parts[0]);
                if (currentId == id) {
                    lines.add(s.getId() + "\n" + s.getName() + "\n" + s.getDescription() + "\n" + s.getPrice());
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rewrite the file with updated information
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  // update an existing service by id
  void deleteService(int id){
      List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\n");
                int currentId = Integer.parseInt(parts[0]);
                if (currentId != id) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (String line : lines) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
  } // delete a service by id
  void generateReport(){
System.out.println("Service Usage Report:");
        for (ServiceUsage usage : serviceUsages) {
            System.out.println("Service ID: " + usage.serviceId + ", Usage Count: " + usage.usageCount);
        }      
    }
} // generate a statistical report for the service usage

 