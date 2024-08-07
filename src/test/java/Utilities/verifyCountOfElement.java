package Utilities;

import impactHub_Pages.impactHubHomePage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.*;

public class verifyCountOfElement extends impactHubHomePage {

    public static String downloadPath = "C:/Users/Fleek/Downloads";
    public static String fileNameContains = "PB_Fleek_DashBoard";

    public static int totalBenefits=0;

    public verifyCountOfElement(WebDriver alcDriver) {
        super(alcDriver);
    }

    public void run() {
        List<String> searchTexts = impactHubHomePage.socialBenefitsInAuditTrailSummary;

        File directory = new File(downloadPath);
        File[] files = directory.listFiles((dir, name) -> name.contains(fileNameContains));

        if (files != null && files.length > 0) {
            try {
                CategoryCountResult result = countCategoryOccurrences(files[0].getAbsolutePath());
                Map<String, Integer> categoryCountMap = result.categoryCountMap;
                int totalBenefits = result.totalBenefits;

                for (Map.Entry<String, Integer> entry : categoryCountMap.entrySet()) {
                    System.out.println("'" + entry.getKey() + "' occurs " + entry.getValue() + " times.");
                }

                System.out.println("Total Benefits: " + totalBenefits);
            } catch (IOException e) {
                e.printStackTrace();
            }

            deleteFile();
        }
    }

    public static CategoryCountResult countCategoryOccurrences(String filePath) throws IOException {
        Map<String, Integer> categoryCountMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(1); // Assuming "Benefit Category" is the second column (index 1)
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    String category = cell.getStringCellValue();
                    categoryCountMap.put(category, categoryCountMap.getOrDefault(category, 0) + 1);
                    totalBenefits++;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the Excel file: " + e.getMessage());
            throw e;
        }

        return new CategoryCountResult(categoryCountMap, totalBenefits);
    }

    public static void deleteFile() {
        File directory = new File(downloadPath);

        // List all files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                // Check if the file name contains the specified string
                if (file.getName().contains(fileNameContains)) {
                    // Delete the file
                    boolean isDeleted = file.delete();
                    if (isDeleted) {
                        System.out.println("File deleted: " + file.getName());
                    } else {
                        System.out.println("Failed to delete file: " + file.getName());
                    }
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }

    // Custom class to hold the result
    public static class CategoryCountResult {
        Map<String, Integer> categoryCountMap;
        int totalBenefits;

        public CategoryCountResult(Map<String, Integer> categoryCountMap, int totalBenefits) {
            this.categoryCountMap = categoryCountMap;
            this.totalBenefits = totalBenefits;
        }
    }
}
