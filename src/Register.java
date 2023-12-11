
import java.io.*;
import java.util.Scanner;
public class Register extends User{
    private static final String BASE_PATH = "src/users";
    //private static final String USER_FILE = BASE_PATH + File.separator + "users.txt";
    private static int latestId = 0;
    //private int id ;
    public static void registerUser() {
        String email;
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------Register-----------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        do {
            System.out.print("Enter valid Email: ");
            email = scanner.nextLine();
        }while (email != null && !email.contains("@"));
        System.out.println("Are you an \n1)Admin\n2)Employee\n3)Customer\nI am a :");
        int who = scanner.nextInt();
        switch (who) {
            case 1:
                registerAdmin(username, password, email);
                break;
            case 2:
                registerUser(username, password, email);
                break;
            case 3:
                registerCustomer(username, password, email);
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
        }
    }

    private static void registerAdmin(String username, String password, String email) {
        registerUserWithType(username, password, email,"admin");
    }

    private static void registerUser(String username, String password, String email) {
        registerUserWithType(username, password, email, "user");
    }

    private static void registerCustomer(String username, String password, String email) {
        registerUserWithType(username, password, email, "customer");
    }

    private static void registerUserWithType(String username, String password, String email,String userType) {
        String userPath = BASE_PATH + File.separator + userType;
        String userFileName = userPath + File.separator + username + ".txt";
        File userFile = new File(userFileName);
        if (userFile.exists()) {
            System.out.println("You are already registered before.");
            Login.authenticateUser(username, password);
        }
        else{
            try {
                //User n = new User();
                // Write user information to the file
                latestId++;
                try (PrintWriter writer = new PrintWriter(new FileWriter(userFile, true))) {
                    writer.println(latestId + "," + username + "," + password + "," + email + "," + userType);
                    System.out.println("Registration successful!");
                }

            } catch (IOException e) {
                System.out.println("Error creating user directory or file.");
                e.printStackTrace();
            }
        }

    }


}
