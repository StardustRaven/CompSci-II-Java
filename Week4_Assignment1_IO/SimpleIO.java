// Name: Summer Star Isakson
// Lab Date: 2026-01-30
// 
// These imports tell Java which pre-built tools we want to use.
// Think of imports like grabbing tools from the supply closet
// instead of reinventing the screwdriver.

import java.io.FileWriter;   // Tool for writing characters to a file
import java.io.IOException;  // Tool for handling file-related errors
import java.io.PrintWriter;  // Tool that makes writing text easy and readable
import java.util.Scanner;    // Tool for reading input from the keyboard

// Every Java program must live inside a class.
// This class name MUST match the filename: SimpleIO.java
public class SimpleIO {

    // main() is the starting point of the program.
    // Java always begins execution here.
    public static void main(String[] args) {

        // Create a Scanner object to read user input from the keyboard.
        // System.in means "standard input" (aka the console).
        Scanner scanner = new Scanner(System.in);

        // Ask the user for input.
        System.out.print("Enter some text: ");

        // Read the entire line the user types and store it in a String.
        String userInput = scanner.nextLine();

        // The try block contains code that *might fail*,
        // especially when files are involved.
        try {

            // FileWriter connects to a file named "output.txt".
            // If the file does not exist, Java creates it.
            // If it DOES exist, Java OVERWRITES it.
            FileWriter fileWriter = new FileWriter("output.txt");

            // PrintWriter wraps around FileWriter to make
            // writing text simpler and more human-readable.
            PrintWriter writer = new PrintWriter(fileWriter);

            // Write the user's text into the file.
            writer.println(userInput);

            // VERY IMPORTANT:
            // Always close the writer so Java actually saves the file.
            writer.close();

            // Let the user know everything worked.
            System.out.println("Text successfully written to output.txt");

        } catch (IOException e) {

            // If something goes wrong with the file,
            // Java jumps here instead of crashing.
            System.out.println("File error occurred.");

            // Print the technical error details (useful for debugging).
            e.printStackTrace();
        }

        // Close the scanner to free system resources.
        scanner.close();
    }
}
