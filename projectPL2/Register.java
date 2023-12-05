import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {

    private static final String USER_FILE = "users.txt";

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Are you an admin? (yes/no): ");
        boolean isAdmin = scanner.nextLine().equalsIgnoreCase("yes");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true))) {
            writer.write(username + "," + password + "," + (isAdmin ? "admin" : "customer") + "\n");
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("Error occurred during registration.");
            e.printStackTrace();
        }
    }
}
