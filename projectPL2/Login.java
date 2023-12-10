import java.io.*;
import java.util.Scanner;

public class Login {

    private static final String BASE_PATH = "src/users";
    private static String user_file = BASE_PATH + File.separator;
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------LOGIN-----------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String userType = authenticateUser(username, password);

        if (userType != null) {
            System.out.println("Login successful! Welcome, " + userType + " " + username + ".");
            // HERE THE CODE TO WHAT BE NEXT
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }



    static String authenticateUser(String username, String password) {
        // Check if the user exists and the password is correct
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you an \n1)Admin\n2)User\n3)Customer\nI am a :");
        int who = scanner.nextInt();
        switch (who) {
            case 1:
                user_file += "admin" + File.separator + username + ".txt";
                break;
            case 2:
                user_file += "user" + File.separator + username + ".txt";
                break;
            case 3:
                user_file += "customer" + File.separator + username + ".txt";
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
        }
        System.out.println(user_file);
        try (BufferedReader reader = new BufferedReader(new FileReader(user_file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 3) {
                    String storedUsername = userData[0];
                    String storedPassword = userData[1];
                    String userType = userData[2];

                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return userType.trim(); // User authenticated, return the user type
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data during authentication.");
            e.printStackTrace();
        }

        return null; // Authentication failed
    }
}
