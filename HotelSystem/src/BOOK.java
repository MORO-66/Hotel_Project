import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


    class BOOK {
    private int roomNumber;
    private int customerId;
    private String checkInDate;
    private String checkOutDate;

    public BOOK(int roomNumber, int customerId, String checkInDate, String checkOutDate) {
        this.roomNumber = roomNumber;
        this.customerId = customerId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return roomNumber + "," + customerId + "," + checkInDate + "," + checkOutDate;
    }
        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public String getCheckInDate() {
            return checkInDate;
        }

        public void setCheckInDate(String checkInDate) {
            this.checkInDate = checkInDate;
        }

        public String getCheckOutDate() {
            return checkOutDate;
        }

        public void setCheckOutDate(String checkOutDate) {
            this.checkOutDate = checkOutDate;
        }

       // @Override
//        public String toString() {
//            return roomNumber + "," + customerId + "," + checkInDate + "," + checkOutDate;
//        }
}