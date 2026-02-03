// Name: Summer Isakson
// Lab: Week 4 – Assignment 2 (Exercise 12.26)
// Date: 01/30/2026

// Program Description:
// This program prompts the user to enter a directory name
// and attempts to create that directory using the File.mkdirs() method.

 // ===== Extra Credit Additions =====
 // 1. Input validation to prevent empty directory names (lines 41–48)
 // 2. Display of absolute path for clarity (line 57)
 // 3. Comma-separated multiple directory creation (lines 61–101)
 // 4. Detection of file vs directory when path already exists (lines 111–118)
 // 5. User confirmation before creating nested directories (lines 124–135)
 // 6. Clear program completion message (lines 162, 170)


import java.io.File;                  // File class handles files and directories
import java.util.Scanner;             // Scanner reads user input
import java.lang.SecurityException;   // Handles permission issues

public class Exercise12_26 {

    public static void main(String[] args) {

        // Scanner for reading user input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory name
        // Extra credit: tells user how commas vs slashes are interpreted
        System.out.print(
            "Enter a directory name.\n" +
            "Use commas for multiple directories (cats,dogs)\n" +
            "or slashes for nested directories (cats/dogs): "
        );

        String directoryName = scanner.nextLine();

        // ===== Extra Credit: Input Validation =====
        // Prevents attempting to create a directory with an empty name
        if (directoryName.trim().isEmpty()) {
            System.out.println("Directory name cannot be empty.");
            scanner.close();
            System.out.println("Program finished.");
            return;
        }

        // ===== Extra Credit: Comma-Separated Multiple Directory Creation =====
        // If the user enters names separated by commas, treat them as separate sibling directories
        // Example input: cats,dogs,raccoons  -> creates cats/ dogs/ raccoons/
        if (directoryName.contains(",")) {

            // Split the input by commas
            String[] directories = directoryName.split(",");

            // Process each directory name
            for (String dir : directories) {

                // Trim whitespace so "cats, dogs" works nicely
                String trimmedDir = dir.trim();

                // Skip blank segments like "cats,,dogs"
                if (trimmedDir.isEmpty()) {
                    System.out.println("Skipped an empty directory entry.");
                    continue;
                }

                File multiDir = new File(trimmedDir);

                // Show where it will be created
                System.out.println("Target path: " + multiDir.getAbsolutePath());

                // If it already exists, identify what it is
                if (multiDir.exists()) {
                    if (multiDir.isDirectory()) {
                        System.out.println("Directory already exists: " + multiDir.getName());
                    } else {
                        System.out.println("A file with that name already exists: " + multiDir.getName());
                    }
                    continue;
                }

                // Attempt to create the directory
                boolean created = multiDir.mkdirs();

                if (created) {
                    System.out.println("Created directory: " + multiDir.getName());
                } else {
                    System.out.println("Could not create directory: " + multiDir.getName());
                }
            }

            // End program after handling comma-separated list
            scanner.close();
            System.out.println("Program finished.");
            return;
        }

        // Create a File object representing the directory (single or nested path)
        File directory = new File(directoryName);

        // ===== Extra Credit: Show absolute path =====
        System.out.println("Target path: " + directory.getAbsolutePath());

        try {
            // Check if the directory already exists
            if (directory.exists()) {

                // ===== Extra Credit: File vs Directory Detection =====
                if (directory.isDirectory()) {
                    System.out.println("Directory already exists.");
                } else {
                    System.out.println("A file with that name already exists.");
                }

            } else {

                // ===== Extra Credit: Nested Directory Confirmation =====
                // If the user entered a nested path (contains a separator),
                // confirm before creating multiple levels.
                if (directoryName.contains(File.separator)) {
                    System.out.print("This will create multiple nested directories. Continue? (y/n): ");
                    String confirm = scanner.nextLine();

                    if (!confirm.equalsIgnoreCase("y")) {
                        System.out.println("Operation cancelled.");
                        scanner.close();
                        System.out.println("Program finished.");
                        return;
                    }
                }

                // Attempt to create the directory (and parent directories if needed)
                boolean created = directory.mkdirs();

                if (created) {
                    System.out.println("Directory created successfully.");
                } else {
                    System.out.println("Directory could not be created.");
                }
            }

        } catch (SecurityException e) {

            // Permission-related exception
            System.out.println("Permission denied. Unable to create directory.");
            e.printStackTrace();

        } finally {
            // Always close the scanner to free system resources
            scanner.close();
        }

        // ===== Extra Credit: Program completion message =====
        System.out.println("Program finished.");
    }
}
