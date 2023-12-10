
import java.io.*;
import java.util.Scanner;
public class Register {

    private static final String BASE_PATH = "users";
    //private static final String USER_FILE = BASE_PATH + File.separator + "users.txt";

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------Register------------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("Are you an \n1)Admin\n2)User\n3)Customer\nI am a :");
        int who = scanner.nextInt();
        switch (who) {
            case 1:
                registerAdmin(username, password);
                break;
            case 2:
                registerUser(username, password);
                break;
            case 3:
                registerCustomer(username, password);
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
        }
    }

    private static void registerAdmin(String username, String password) {
        registerUserWithType(username, password, "admin");
    }

    private static void registerUser(String username, String password) {
        registerUserWithType(username, password, "user");
    }

    private static void registerCustomer(String username, String password) {
        registerUserWithType(username, password, "customer");
    }

    private static void registerUserWithType(String username, String password, String userType) {
        String userPath = BASE_PATH + File.separator + userType;
        String userFileName = userPath + File.separator + username + ".txt";
        File userFile = new File(userFileName);

        try {

            // Write user information to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter(userFile, true))) {
                writer.println(username + "," + password + "," + userType);
                System.out.println("Registration successful!");
            }

        } catch (IOException e) {
            System.out.println("Error creating user directory or file.");
            e.printStackTrace();
        }
    }
}
