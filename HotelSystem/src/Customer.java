import java.io.*;
import java.util.*;

public class Customer  extends User {

    private int id;
    private String name;
    private String role;
    private String email;
    private String password;
        private int customerId;
        private double totalBill;
    private static final String BILL = "src/BILL";
    private static final String SERVICES_FILE = "src/services/services.txt";

        public Customer(int customerId) {
            this.customerId = customerId;
            this.totalBill = loadTotalBill();
        }
    public Customer() {
        super();
    }

    public Customer(String id, String name, String email, String password, String role) {
        super(name, email, password, role);
        this.id =Integer.parseInt(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString() {
        return id + "," + name + "," +email + "," + password + "," + role;
    }
    private double loadTotalBill() {
        String billFilePath = BILL + customerId + "_bill.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(billFilePath))) {
            String line = reader.readLine();
            if (line != null) {
                return Double.parseDouble(line);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading total bill for customer " + customerId);
            e.printStackTrace();
        }

        return 0.0;
    }private void saveTotalBill() {
        String billFilePath = BILL + customerId + "_bill.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(billFilePath))) {
            writer.println(totalBill);
        } catch (IOException e) {
            System.out.println("Error saving total bill for customer " + customerId);
            e.printStackTrace();
        }
    } public static double getServicePrice(String serviceName, List<String> availableServices) {
        for (String service : availableServices) {
            String[] parts = service.split(",");
            if (parts.length == 3) {
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[2].trim());

                if (name.equalsIgnoreCase(serviceName)) {
                    return price;
                }
            }
        }
        return 0.0; // Service not found or has no cost
    }

}