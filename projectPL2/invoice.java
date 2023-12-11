/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20109
 */


import java.io.FileWriter;
import java.io.IOException;

class Invoice extends Customer {
    private int invoiceId;
    private double totalAmount;
    String roomType = Room.getType;
    double roomPriceperday = Room.getPrice;
    String checkInDate=Reservation.getCheckInDate; 
    String checkOutDate=Reservation.getCheckOutDate;
    
  public Invoice(int id, String name, String email, String contactDetails, String address, String role,
                   int invoiceId, double totalAmount) {
        super(id, name, email, contactDetails, address, role);
        this.invoiceId = invoiceId;
        this.totalAmount = totalAmount;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

     public void generateInvoice(String roomType,double roomPriceperday) {
        try (FileWriter writer = new FileWriter("invoice_" + getInvoiceId() + ".txt")) {
            writer.write("Customer: " + getName() + "\n");
            writer.write("Customer ID: " + getId() + "\n");
            writer.write("Email: " + getEmail() + "\n");
            writer.write("Invoice ID: " + invoiceId + "\n");
            writer.write("Total Amount: " + totalAmount + "\n");
            writer.write("Room Type: " + roomType + "\n");
            writer.write("Checkin: " + getCheckInDate() + "\n");
            writer.write("Checkout: " + getCheckOutDate() + "\n");
            writer.write("Room Price Per Day : " + roomPriceperday + "\n");
            double roomPrice = roomPriceperday * calculateDays(checkInDate , checkOutDate);
            writer.write("Room Price: " + roomPrice + "\n");
        } catch (IOException e) {
            System.out.println("Error generating invoice file: " + e.getMessage());
        }
    }
     
      private int calculateDays(String checkInDate, String checkOutDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate startDate = LocalDate.parse(checkInDate, formatter);
        LocalDate endDate = LocalDate.parse(checkOutDate, formatter);

        return (int) startDate.until(endDate).getDays();
    }

}

