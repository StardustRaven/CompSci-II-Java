 // Name: Star Isakson
 // Lab: Week 4 – Assignment 1 (Exercise 12.19)
 // Date: 01/30/2026
 
 // Program:
 // Counts the number of words in Abraham Lincoln’s Gettysburg Address
 // by reading text from a URL (I/O) and handling exceptions properly.
 
 // Extra Credit - Added line count see lines 24, 46, 66

import java.net.URL;            // Represents a web address
import java.util.Scanner;       // Reads text from input streams (including URL streams)
import java.io.IOException;     // Checked exception for input/output failures

public class Exercise12_19 {

    public static void main(String[] args) {

        // The assignment-provided URL where the text file lives
        String urlString = "https://liveexample.pearsoncmg.com/data/Lincoln.txt";

        // We'll store our results in these variables
        int wordCount = 0;
        int lineCount = 0;

        // Scanner starts as null so we can safely close it later in finally
        Scanner input = null;

        // try/catch/finally is the core of "Exception Handling"
        // try = attempt risky code
        // catch = what to do if it fails
        // finally = cleanup that runs no matter what
        try {

            // Create a URL object from the string
            URL url = new URL(urlString);

            // openStream() creates a connection and gives us a stream of data (I/O)
            // Scanner can read that stream like it would read from the keyboard
            input = new Scanner(url.openStream());

            // Read the file line-by-line until there is no more text
            while (input.hasNextLine()) {

                String line = input.nextLine();
                lineCount++;

                // trim() removes leading/trailing whitespace
                // This prevents empty lines from counting as "1 word"
                String trimmed = line.trim();

                // If the line isn't empty after trimming, split into words
                if (!trimmed.isEmpty()) {
                    // \\s+ means "one or more whitespace characters"
                    // This treats multiple spaces/tabs as a single separator
                    String[] words = trimmed.split("\\s+");
                    wordCount += words.length;
                }
            }

            // If we got here, the URL read worked without throwing an exception
            System.out.println("====================================");
            System.out.println(" Gettysburg Address Word Counter");
            System.out.println("====================================");
            System.out.println("Source: " + urlString);
            System.out.println("Lines read: " + lineCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("====================================");

        } catch (IOException e) {

            // IOException is a "checked exception" for I/O problems:
            // - can't connect to the URL
            // - internet issue
            // - site down
            // - stream can't be opened
            System.out.println("ERROR: Could not read from the URL.");
            System.out.println("Reason: " + e.getMessage());

            // This prints the full stack trace (useful for debugging)
            e.printStackTrace();

        } finally {

            // finally ALWAYS runs, success or failure.
            // It is used for cleanup: closing files, scanners, streams, etc.
            if (input != null) {
                input.close();
            }
        }
    }
}
