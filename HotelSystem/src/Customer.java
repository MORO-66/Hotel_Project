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
        return id + "," + name + "," +password + "," + email + "," + role;
    }
    public double addServiceAndUpdateBill(String serviceName, List<String> availableServices) {
        double servicePrice = Services.getServicePrice(serviceName, availableServices);
        if (servicePrice > 0.0) {
            totalBill += servicePrice;
            saveTotalBill();
        }
        return totalBill;
    }
    private double loadTotalBill() {
        String billFilePath = BILL + customerId + "_bill.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(billFilePath))) {
            String line = reader.readLine();
            if (line != null) {
                return Double.parseDouble(line);
            }
        } catch (IOException | NumberFormatException e) {
            // Handle the exception (e.g., file not found, invalid format)
            System.out.println("Error loading total bill for customer " + customerId);
            e.printStackTrace();
        }

        return 0.0; // Default to 0.0 if loading fails
    }private void saveTotalBill() {
        String billFilePath = BILL + customerId + "_bill.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(billFilePath))) {
            writer.println(totalBill);
        } catch (IOException e) {
            // Handle the exception (e.g., file not found, write error)
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
    public void customerInteraction() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your customer ID: ");
        int customerId = getId();
        scanner.nextLine(); // Consume the newline character

        Customer customer = new Customer(customerId);
        Services s = new Services();
        // Display available services
        List<String> services = s.readServicesFromFile();
        if (services != null && !services.isEmpty()) {
            s.displayServices();

            // Select services
            while (true) {
                System.out.print("Enter the name of the service you want to add (or 'done' to finish): ");
                String selectedService = scanner.nextLine();

                if (selectedService.equalsIgnoreCase("done")) {
                    break;
                }

                if (services.contains(selectedService)) {
                    double totalBill = customer.addServiceAndUpdateBill(selectedService, services);
                    System.out.println("Service added to your account. Your updated total bill is: $" + totalBill);
                } else {
                    System.out.println("Invalid service name. Please try again.");
                }
            }
        } else {
            System.out.println("No services available.");
        }
    }
}