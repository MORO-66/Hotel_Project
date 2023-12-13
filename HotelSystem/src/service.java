//package com.mycompany.projectpl2;
/*
 *
 * @author user
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class service {
    private int id;
    private String name;
    private String description;
    private double price;
    private List<ServiceUsage> serviceUsages;
    private static final String DATA_FILE = "src/users/services.txt";

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
    // Constructor
    public service(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.serviceUsages = new ArrayList<>();
    }

    // Getters and setters (you might need to add setters for id, name, description, and price)

    // Methods
    public void addService(service s) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE, true))) {
            writer.println(s.getID() + "\n" + s.getName() + "\n" + s.getDescription() + "\n" + s.getPrice());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update service usages
        serviceUsages.add(new ServiceUsage(s.getID()));
    }

    public void updateService(int id, service s) {
        // ... (your existing code)

        // Update service usages
        for (ServiceUsage usage : serviceUsages) {
            if (usage.serviceId == id) {
                usage.serviceId = s.getID();
                break;
            }
        }
    }

    public void deleteService(int id) {
        // ... (your existing code)

        // Update service usages
        serviceUsages.removeIf(usage -> usage.serviceId == id);
    }

    public void generateReport() {
        System.out.println("Service Usage Report:");
        for (ServiceUsage usage : serviceUsages) {
            System.out.println("Service ID: " + usage.serviceId + ", Usage Count: " + usage.usageCount);
        }
    }
}
