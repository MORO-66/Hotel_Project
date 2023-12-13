import java.io.*;
import java.util.Scanner;

public class Login extends User {
    public static String[] userData;
    private static final String BASE_PATH = "src/users/";
    private static String user_file = BASE_PATH;

    public static UserData login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------LOGIN-----------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        UserData userType = authenticateUser(username, password);
        System.out.println(userType);
        if (userType != null) {
            System.out.println("Login successful! Welcome, " + username + ".");
        } else {
            System.out.println("Login failed. Invalid username or password.");

        }
        return userType;
    }


    static UserData authenticateUser(String username, String password) {
        // Check if the user exists and the password is correct
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you an \n1)Admin\n2)User\n3)Customer\nI am a :");
        int who = scanner.nextInt();
        System.out.println(user_file);
        switch (who) {
            case 1:
                if(!user_file.equals("src/users/admin.txt")){
                user_file += "admin.txt";}
                break;
            case 2:
                if(!user_file.equals("src/users/admin.txt")){
                    user_file += "user.txt";}
                break;
            case 3:
                if(!user_file.equals("src/users/admin.txt")){
                    user_file += "customer.txt";}
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
        }
        System.out.println(user_file);
        try (BufferedReader reader = new BufferedReader(new FileReader(user_file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userData = line.split(",");
                if (userData.length > 3) {
                    String storedUsername = userData[1];
                    String storedPassword = userData[2];
                    String userType = userData[4];

                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return new UserData(userData[0], userData[1], userData[2], userData[3], userData[4]);// User authenticated, return the user type
                    }
//                    else {
//                        System.out.println("wrong username or password");
//                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data during authentication.");
            e.printStackTrace();
        }

        return null;
    }
}