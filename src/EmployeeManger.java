import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class EmployeeManger {

        private static final String EMPLOYEES_FOLDER = "src/users/user.txt";

        public static void addEmployeeByAdmin() {
            Employee employee = getEmployeeInfoFromAdmin();
            System.out.println(employee.toString());
            addEmployee(employee);
        }

    public static void updateEmployeeByAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID to update: ");
        String id = scanner.nextLine();
        Employee newEmployee = getEmployeeInfoFromAdmin();
        updateEmployee(id, newEmployee);
    }


    public static void deleteEmployeeByAdmin() {
        Scanner scanner = new Scanner(System.in);
        displayAllEmployees();

        System.out.print("Enter employee ID to delete: ");
        String id = scanner.nextLine();
        deleteEmployee(id);
    }


    private static void addEmployee(Employee employee) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(EMPLOYEES_FOLDER, true))) {
            writer.println(employee.toString());
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("Error writing to user file.");
            e.printStackTrace();
        }
    }

    private static void updateEmployee(String id, Employee newEmployee) {
            System.out.println(EMPLOYEES_FOLDER);
        File employeeFile = new File(EMPLOYEES_FOLDER);

        try (BufferedReader reader = new BufferedReader(new FileReader(employeeFile))) {
            List<String> lines = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(id + ",")) {
                    lines.add(newEmployee.toString());
                } else {
                    lines.add(line);
                }
            }

            // Write the updated content back to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter(employeeFile))) {
                for (String updatedLine : lines) {
                    writer.println(updatedLine);
                }
            }

            System.out.println("Employee updated successfully!");
        } catch (IOException e) {
            System.out.println("Error updating employee.");
            e.printStackTrace();
        }
    }



    private static void deleteEmployee(String id) {
        File employeeFile = new File(EMPLOYEES_FOLDER);

        try (BufferedReader reader = new BufferedReader(new FileReader(employeeFile))) {
            List<String> lines = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(id + ",")) {
                    lines.add(line);
                }
            }

            // Write the updated content back to the file
            try (PrintWriter writer = new PrintWriter(new FileWriter(employeeFile))) {
                for (String updatedLine : lines) {
                    writer.println(updatedLine);
                }
            }

            System.out.println("Employee deleted successfully!");
        } catch (IOException e) {
            System.out.println("Error deleting employee.");
            e.printStackTrace();
        }
    }


    private static Employee getEmployeeInfoFromAdmin() {
            String email;
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter employee role: ");
            String role = scanner.nextLine();

            System.out.print("Enter employee ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter employee Password: ");
            String password = scanner.nextLine();

            do {
                System.out.print("Enter valid Email: ");
                email = scanner.nextLine();
            }while (email != null && !email.contains("@"));
            Employee employee = new Employee(id, name, password, email, role);
            return employee;
        }
    public static void displayAllEmployees() {
        File employeesFile = new File(EMPLOYEES_FOLDER);

        try (BufferedReader reader = new BufferedReader(new FileReader(employeesFile))) {
            System.out.println("Employee List:");

            String line;
            while ((line = reader.readLine()) != null) {
                Employee employee = createEmployeeFromLine(line);
                System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Role: " + employee.getRole());
            }

        } catch (IOException e) {
            System.out.println("Error reading employee data from file: " + employeesFile.getName());
            e.printStackTrace();
        }
    }
    private static Employee createEmployeeFromLine(String line) {
        String[] parts = line.split(",");

        if (parts.length == 5) {
            String id = parts[0];
            String name = parts[1];
            String password = parts[2];
            String email = parts[3];
            String role = parts[4];

            return new Employee(id, name, password, email, role);
        } else {
            return null; // Handle the error appropriately
        }
    }




    // ... (other methods)
}
