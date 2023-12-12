
import java.awt.geom.QuadCurve2D;
import java.io.*;
import java.util.*;
class ReservationManager extends User{
    private static final String RESERVATION_FILE = "reservations.txt";

    public static void findAndReserveRoom(String name, String type, double minPrice, double maxPrice, String checkInDate, String checkOutDate) {

        try (FileReader fr = new FileReader(RoomFileManager.ROOM_FILE);
             BufferedReader br = new BufferedReader(fr)) {

            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                Room room = new Room(Integer.parseInt(parts[0]), parts[1], parts[2], Double.parseDouble(parts[3]));
                if (room.getType().equals(type) && room.getPrice() >= minPrice && room.getPrice() <= maxPrice && room.getStatus().equals("true")) {
                    int id = (int) (Math.random() * 1000) + 1;
                    reservation Reservation = new reservation(id, name, room.getNumber(), checkInDate, checkOutDate);
                    addReservation(Reservation);
                    room.setStatus("false");
                    RoomFileManager.updateRoom(room.getNumber(), room);
                    System.out.println("Room reserved successfully. Your reservation id is " + id + ".");

                    return;
                }
                // Read the next line
                line = br.readLine();
            }
            // Close the file
            br.close();
            // Print a message that no room was found
            System.out.println("No room found that matches the filter and is available.");
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    public static void seeMyReservation(int id) {
        try (FileReader fr = new FileReader(RESERVATION_FILE);
             BufferedReader br = new BufferedReader(fr)) {

            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                reservation Reservation = new reservation(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
                if (Reservation.getId() == id) {

                    System.out.println("Your reservation details are:");
                    System.out.println("Name: " + Reservation.getName());
                    System.out.println("Room number: " + Reservation.getRoomNumber());
                    System.out.println("Check-in date: " + Reservation.getCheckInDate());
                    System.out.println("Check-out date: " + Reservation.getCheckOutDate());
                    return;
                }
                // Read the next line
                line = br.readLine();
            }
            // Close the file
            br.close();
            // Print a message that no reservation was found
            System.out.println("No reservation found with the given id.");
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    // A method to write and add a reservation to the reservation file
    public static void writeAndAddReservation(String name, int roomNumber, String checkInDate, String checkOutDate) {
        // Generate a random reservation id
        int id = (int) (Math.random() * 1000) + 1;
        // Create a reservation object with the given name and dates
        reservation Reservation = new reservation(id, name, roomNumber, checkInDate, checkOutDate);
        // Add the reservation to the reservation file
        addReservation(Reservation);
        // Print a success message
        System.out.println("Reservation written and added successfully. Your reservation id is " + id + ".");
    }

    // A method to add a reservation to the reservation file
    private static void addReservation(reservation Reservation) {
        // Try to open the reservation file in append mode
        try (FileWriter fw = new FileWriter(RESERVATION_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            // Write the reservation object as a string to the file
            pw.println(Reservation.toString());
            // Close the file
            pw.close();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    // A method to show all reservations from the reservation file
    public static void showAllReservations() {
        // Try to open the reservation file in read mode
        try (FileReader fr = new FileReader(RESERVATION_FILE);
             BufferedReader br = new BufferedReader(fr)) {
            // Print a header
            System.out.println("All reservations are:");
            // Read each line from the file
            String line = br.readLine();
            while (line != null) {
                // Split the line by comma
                String[] parts = line.split(",");
                // Create a reservation object from the parts
                reservation Reservation = new reservation(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
                // Print the reservation details
                System.out.println("Reservation id: " + Reservation.getId());
                System.out.println("Name: " + Reservation.getName());
                System.out.println("Room number: " + Reservation.getRoomNumber());
                System.out.println("Check-in date: " + Reservation.getCheckInDate());
                System.out.println("Check-out date: " + Reservation.getCheckOutDate());
                System.out.println();
                // Read the next line
                line = br.readLine();
            }
            // Close the file
            br.close();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
}