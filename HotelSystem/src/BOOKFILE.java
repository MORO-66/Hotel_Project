import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;




class BOOKFILE{
    static final String BILL_FOLDER = "src/BILL/";
    static final String ROOM_FILE = "src/users/rooms.txt";
    static final String BOOKINGS_FILE = "src/users/booking.txt";
    static void bookRoom(User u) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();

        List<Room> rooms = getRoomsFromFile();
        Room selectedRoom = findRoomByNumber(rooms, roomNumber);

        if (selectedRoom != null && selectedRoom.getStatus().equals("true")) {
            System.out.print("Enter check-in date (yyyy-MM-dd): ");
            String checkInDate = scanner.next();

            System.out.print("Enter check-out date (yyyy-MM-dd): ");
            String checkOutDate = scanner.next();
            int  id = u.getId() + 1;
            BOOK booking = new BOOK(roomNumber, id, checkInDate, checkOutDate);
            addBooking(booking);
            updateRoomAvailability(rooms, roomNumber, false);
            generateCustomerBillFile(u.getName(), selectedRoom.getPrice(), checkInDate, checkOutDate);
            System.out.println("Room booked successfully!");
        } else {
            System.out.println("Room is not available or does not exist.");
        }
    }
    private static void generateCustomerBillFile(String name, double roomPrice, String checkInDate, String checkOutDate) {
        String customerBillFileName = BILL_FOLDER + name + "_bill.txt";

        File billFile = new File(customerBillFileName);

        try {
            if (billFile.exists()) {
                // If the file exists, read the existing price and add the new room price
                double existingPrice = readExistingPrice(billFile);
                roomPrice += existingPrice;
            } else {
                // If the file doesn't exist, create a new file
                billFile.createNewFile();
            }

            // Write the updated or new price to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter(billFile))) {
                writer.println(roomPrice);
                System.out.println("Customer-specific bill file generated/updated: " + customerBillFileName);
            } catch (IOException e) {
                System.out.println("Error generating/updating customer-specific bill file.");
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.out.println("Error accessing the bill file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static double readExistingPrice(File billFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(billFile))) {
            String line = reader.readLine();
            return Double.parseDouble(line.trim());
        }
    }
    private static void generateCustomerBookingFile(int customerId, BOOK booking) {
        String customerBookingFileName = "src/BILL/" + customerId + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(customerBookingFileName))) {
            writer.println("Room Number: " + booking.getRoomNumber());
            writer.println("Check-in Date: " + booking.getCheckInDate());
            writer.println("Check-out Date: " + booking.getCheckOutDate());
            // Add more details as needed

            System.out.println("Customer-specific booking file generated: " + customerBookingFileName);
        } catch (IOException e) {
            System.out.println("Error generating customer-specific booking file.");
            e.printStackTrace();
        }
    }


    private static void updateRoomAvailability(List<Room> rooms, int roomNumber, boolean isAvailable) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                String av = String.valueOf(isAvailable);
                room.setStatus(av);
                break;
            }
        }

        writeRoomsToFile(rooms);
    }

    private static Room findRoomByNumber(List<Room> rooms, int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private static void writeRoomsToFile(List<Room> rooms) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ROOM_FILE))) {
            for (Room room : rooms) {
                writer.println(room.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing to rooms file.");
            e.printStackTrace();
        }
    }

     private static List<Room> getRoomsFromFile() {
        List<Room> rooms = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ROOM_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int roomNumber = Integer.parseInt(parts[0]);
                String Type = parts[1];
                String av = parts[2];
                Double price = Double.parseDouble(parts[3]);
                rooms.add(new Room(roomNumber, Type ,av, price));
            }
        } catch (IOException e) {
            System.out.println("Error reading rooms data from file: " + ROOM_FILE);
            e.printStackTrace();
        }

        return rooms;
    }
    private static void addBooking(BOOK booking) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(BOOKINGS_FILE, true))) {
            writer.println(booking.toString());
        } catch (IOException e) {
            System.out.println("Error writing to bookings file.");
            e.printStackTrace();
        }
    }

    static void viewMyBookings(User customer) {
        List<BOOK> bookings = getCustomerBookings(customer.getId());

        if (bookings.isEmpty()) {
            System.out.println("No bookings found for " + customer.getName());
        } else {
            System.out.println("My Bookings:");
            for (BOOK booking : bookings) {
                System.out.println("Room: " + booking.getRoomNumber() +
                        ", Check-in Date: " + booking.getCheckInDate() +
                        ", Check-out Date: " + booking.getCheckOutDate());
            }
        }
    }

    private static List<BOOK> getCustomerBookings(int customerId) {
        List<BOOK> bookings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKINGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                BOOK booking = createBookingFromLine(line);
                if (booking != null && booking.getCustomerId() == customerId) {
                    bookings.add(booking);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading bookings data from file: " + BOOKINGS_FILE);
            e.printStackTrace();
        }

        return bookings;
    }

    private static BOOK createBookingFromLine(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            int roomNumber = Integer.parseInt(parts[0]);
            int customerId = Integer.parseInt(parts[1]);
            String checkInDate = parts[2];
            String checkOutDate = parts[3];
            return new BOOK(roomNumber, customerId, checkInDate, checkOutDate);
        }
        return null;
    }

    public static void checkOut(User customer) {
        List<BOOK> bookings = getCustomerBookings(customer.getId());

        if (bookings.isEmpty()) {
            System.out.println("No bookings found for " + customer.getName());
        } else {
            System.out.println("Select a booking to check out:");
            for (int i = 0; i < bookings.size(); i++) {
                System.out.println((i + 1) + ". Room: " + bookings.get(i).getRoomNumber() +
                        ", Check-in Date: " + bookings.get(i).getCheckInDate() +
                        ", Check-out Date: " + bookings.get(i).getCheckOutDate());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of the booking to check out: ");
            int selectedBookingIndex = scanner.nextInt() - 1;

            if (selectedBookingIndex >= 0 && selectedBookingIndex < bookings.size()) {
                BOOK selectedBooking = bookings.get(selectedBookingIndex);
                int roomNumber = selectedBooking.getRoomNumber();

                // Calculate charges, update records, or perform other checkout-related tasks
                double charges = calculateCharges(selectedBooking);
                System.out.println("Total charges: $" + charges);

                // Update room availability status
                updateRoomAvailability(roomNumber, true);

                // Remove the booking from the bookings file
                removeBooking(selectedBooking);

                System.out.println("Check-out successful!");
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    private static double calculateCharges(BOOK booking) {
        // Example: Calculate charges based on the room rate, duration, or other factors
        // This is a placeholder, you should replace it with your actual charging logic
        return 100.0; // Replace with the actual calculation
    }

    private static void updateRoomAvailability(int roomNumber, boolean isAvailable) {
        List<Room> rooms = getRoomsFromFile();

        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                room.setStatus(String.valueOf(isAvailable));
                break;
            }
        }

        writeRoomsToFile(rooms);
    }

    private static void removeBooking(BOOK booking) {
        List<BOOK> allBookings = getBookingsFromFile();
        allBookings.remove(booking);
        writeBookingsToFile(allBookings);
    }

    private static List<BOOK> getBookingsFromFile() {
        List<BOOK> bookings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(BOOKINGS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                BOOK booking = createBookingFromLine(line);
                if (booking != null) {
                    bookings.add(booking);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading bookings data from file: " + BOOKINGS_FILE);
            e.printStackTrace();
        }

        return bookings;
    }

    private static void writeBookingsToFile(List<BOOK> bookings) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(BOOKINGS_FILE))) {
            for (BOOK booking : bookings) {
                writer.println(booking.toString());
            }
        } catch (IOException e) {
            System.out.println("Error writing to bookings file.");
            e.printStackTrace();
        }
    }




}