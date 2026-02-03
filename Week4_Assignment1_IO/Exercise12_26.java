 // Name: Star Isakson
 // Lab: Week 4 – Assignment 2 (Exercise 12.26)
 // Date: 01/30/2026]
 
 // Program Description:
 // This program prompts the user to enter a directory name
 // and attempts to create that directory using the File.mkdirs() method.
 

import java.io.File;          // File class handles files and directories
import java.util.Scanner;     // Scanner reads user input
import java.lang.SecurityException; // Handles permission issues

public class Exercise12_26 {

    public static void main(String[] args) {

        // Scanner for reading user input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a directory name
        System.out.print("Enter a directory name: ");
        String directoryName = scanner.nextLine();

        // Create a File object representing the directory
        // This does NOT create the directory yet — it just points to it
        File directory = new File(directoryName);

        try {
            // Check if the directory already exists
            if (directory.exists()) {

                // Directory already exists
                System.out.println("Directory already exists");

            } else {
                // Attempt to create the directory (and parent directories if needed)
                boolean created = directory.mkdirs();

                // mkdirs() returns true if the directory was created
                if (created) {
                    System.out.println("Directory created successfully");
                } else {
                    // This case is rare but possible if creation fails silently
                    System.out.println("Directory could not be created");
                }
            }

        } catch (SecurityException e) {

            // This exception occurs if the program does not have
            // permission to create the directory
            System.out.println("Permission denied. Unable to create directory.");
            e.printStackTrace();

        } finally {
            // Always close the scanner to free system resources
            scanner.close();
        }
    }
}