import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;


public class Services {
    private static final String REPORTS_FOLDER = "src/reports";
    private static final String REPORT_FILE_EXTENSION = ".txt";

    public void createReport() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the report content: ");
        String content = scanner.nextLine();

        String fileName = generateReportFileName();
        String filePath = REPORTS_FOLDER + "/" + fileName;

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Report Date: " + getCurrentDateTime());
            writer.println("Content: " + content);
            System.out.println("Report created successfully!");
        } catch (IOException e) {
            System.out.println("Error creating report.");
            e.printStackTrace();
        }
    }
    public String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
    public String generateReportFileName() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return "Report_" + dateFormat.format(new Date()) + REPORT_FILE_EXTENSION;
    }
    public void displayReportContent(File reportFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(reportFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading report content: " + reportFile.getName());
            e.printStackTrace();
        }
    }
    public void viewAllReports() {
        File reportsFolder = new File(REPORTS_FOLDER);

        if (reportsFolder.exists() && reportsFolder.isDirectory()) {
            File[] reportFiles = reportsFolder.listFiles();

            if (reportFiles != null && reportFiles.length > 0) {
                System.out.println("\nAll Reports:");
                for (File reportFile : reportFiles) {
                    System.out.println("Report: " + reportFile.getName());
                    displayReportContent(reportFile);
                    System.out.println("------------------------------");
                }
            } else {
                System.out.println("No reports found.");
            }
        } else {
            System.out.println("Reports folder does not exist.");
        }
    }
}