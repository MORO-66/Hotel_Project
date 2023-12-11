import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManger {
    //private static final String EMPLOYEE_FILE = "employees.txt";

        private static final String EMPLOYEES_FOLDER = "src/users/user.txt";

        public static void addEmployeeByAdmin() {
            Employee employee = getEmployeeInfoFromAdmin();
            addEmployee(employee);
        }

        public static void updateEmployeeByAdmin() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter employee ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Employee newEmployee = getEmployeeInfoFromAdmin();
            updateEmployee(id, newEmployee);
        }

        public static void deleteEmployeeByAdmin() {
            Scanner scanner = new Scanner(System.in);
            displayAllEmployees();

            System.out.print("Enter employee ID to delete: ");
            String name = scanner.nextLine();
            scanner.nextLine(); // Consume the newline character

            deleteEmployee(name);
        }

        private static void addEmployee(Employee employee) {
            File employeeFile = new File(employee.getFileName());
            System.out.println(employeeFile);
            try (PrintWriter writer = new PrintWriter(new FileWriter(employeeFile))) {
                writer.println(employee.toString());
                System.out.println("Employee added successfully!");
            } catch (IOException e) {
                System.out.println("Error occurred while adding the employee.");
                e.printStackTrace();
            }
        }

        private static void updateEmployee(int id, Employee newEmployee) {
            File oldEmployeeFile = new File(newEmployee.getName().replace(" ", "_") + ".txt");
            System.out.println(oldEmployeeFile);
            File newEmployeeFile = new File(newEmployee.getFileName());

            if (oldEmployeeFile.renameTo(newEmployeeFile)) {
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("Error occurred while updating the employee.");
            }
        }

        private static void deleteEmployee(String name) {
            File employeeFile = new File("src/users/user", name + ".txt");

            if (employeeFile.delete()) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Error occurred while deleting the employee.");
            }
        }

        private static Employee getEmployeeInfoFromAdmin() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter employee role: ");
            String role = scanner.nextLine();

            System.out.print("Enter employee ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter employee Password: ");
            String password = scanner.nextLine();

            System.out.print("Enter employee email: ");
            String email = scanner.nextLine();

            return new Employee(id, name,password,email, role);
        }
    public static void displayAllEmployees() {
        File folder = new File(EMPLOYEES_FOLDER);

        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            System.out.println("Employee List:");
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    Employee employee = readEmployeeFromFile(file);
                    System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Role: " + employee.getRole());
                }
            }
        } else {
            System.out.println("No employees found.");
        }
    }

    private static Employee readEmployeeFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            String[] parts = line.split(",");
            String id = parts[0];
            String name = parts[1];
            String password = parts[2];
            String email = parts[3];
            String role = parts[4];

            return new Employee(id, name,password,email, role);
        } catch (IOException e) {
            System.out.println("Error occurred while reading employee data from file: " + file.getName());
            e.printStackTrace();
            return null;
        }
    }

    // ... (other methods)
}
