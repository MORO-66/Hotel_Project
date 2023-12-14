import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RoomFileManager {
public static Room getRoomInfoFromAdmin() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter room number: ");
    int number = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter room type: ");
    String type = scanner.nextLine();

    System.out.print("Enter room status: ");
    String status = scanner.nextLine();

    System.out.print("Enter room price: ");
    double price = scanner.nextDouble();
    return new Room(number, type, status,price);
}

public static void addRoomByAdmin() {
    displayAllRooms();
    Room room = getRoomInfoFromAdmin();
    addRoom(room);
}

public static void updateRoomByAdmin() {
    Scanner scanner = new Scanner(System.in);
    displayAllRooms();
    System.out.print("Enter room number to update: ");
    int number = scanner.nextInt();
    scanner.nextLine();

    Room newRoom = getRoomInfoFromAdmin();
    updateRoom(number, newRoom);
}

public static void deleteRoomByAdmin() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter room number to delete: ");
    int number = scanner.nextInt();
    scanner.nextLine();

    deleteRoom(number);
}
static final String ROOM_FILE = "src/users/rooms.txt";
public static void addRoom(Room room){
    try (PrintWriter writer = new PrintWriter(new FileWriter(ROOM_FILE, true))) {
        writer.println(room.toString());
        System.out.println("Room added successfully!");
    } catch (IOException e) {
        System.out.println("Error occurred while adding the room.");
        e.printStackTrace();
    }
}
public static void updateRoom(int number, Room newRoom) {
    List<String> lines = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(ROOM_FILE))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int currentNumber = Integer.parseInt(parts[0]);
            if (currentNumber == number) {
                lines.add(newRoom.toString());
            } else {
                lines.add(line);
            }
        }
    } catch (IOException e) {
        System.out.println("Error occurred while updating the room.");
        e.printStackTrace();
        return;
    }

    writeLinesToFile(lines);
    System.out.println("Room updated successfully!");
}

public static void deleteRoom(int number) {
    List<String> lines = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(ROOM_FILE))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int currentNumber = Integer.parseInt(parts[0]);
            if (currentNumber != number) {
                lines.add(line);
            }
        }
    } catch (IOException e) {
        System.out.println("Error occurred while deleting the room.");
        e.printStackTrace();
        return;
    }

    writeLinesToFile(lines);
    System.out.println("Room deleted successfully!");
}

private static void writeLinesToFile(List<String> lines) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(ROOM_FILE))) {
        for (String line : lines) {
            writer.println(line);
        }
    } catch (IOException e) {
        System.out.println("Error occurred while writing to the file.");
        e.printStackTrace();
    }
}
public static void displayAllRooms() {
    try (BufferedReader reader = new BufferedReader(new FileReader(ROOM_FILE))) {
        String line;
        System.out.println("Room List:");
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int number = Integer.parseInt(parts[0]);
            String type = parts[1];
            String status = parts[2];
            String price = parts[3];

            System.out.println("Number: " + number + ", Type: " + type + ", Status: " + status + ", price: " + price);
        }
    } catch (IOException e) {
        System.out.println("Error occurred while reading room data.");
        e.printStackTrace();
    }
}
}
