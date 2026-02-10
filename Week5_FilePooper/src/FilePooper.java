// Import classes needed for reading files
import java.io.BufferedReader;
import java.io.FileReader;

// Import classes needed for writing files
import java.io.BufferedWriter;
import java.io.FileWriter;

// Import exception class for handling I/O errors
import java.io.IOException;

public class FilePooper {

    public static void main(String[] args) {

        // Path to the input file (relative to project root)
        String inputFile = "data/input.txt";

        // Path to the output file (will be created or overwritten)
        String outputFile = "data/output.txt";

        // Flag to track whether we are inside the [WatcherNotes] section
        boolean inWatcherNotes = false;

        // Used to build the hidden bonus message
        StringBuilder secretMessage = new StringBuilder();

        // Try-with-resources ensures BOTH reader and writer
        // are automatically closed when the program finishes
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {

            // Variable to hold each line read from the input file
            String line;

            // Read the input file one line at a time
            while ((line = reader.readLine()) != null) {

                // Write the line to the output file exactly as-is
                writer.write(line);
                writer.newLine();

                // Also print the line to the console (optional but useful)
                System.out.println(line);

                // Trim whitespace to make comparisons easier
                String trimmedLine = line.trim();

                // Detect the start of the WatcherNotes section
                if (trimmedLine.equals("[WatcherNotes]")) {
                    inWatcherNotes = true;
                    continue;
                }

                // Detect the end of the log
                if (trimmedLine.startsWith("=== END LOG")) {
                    inWatcherNotes = false;
                }

                // Only scan for the hidden message inside WatcherNotes
                if (inWatcherNotes) {

                    // Convert line to lowercase for case-insensitive searching
                    String lowerCaseLine = trimmedLine.toLowerCase();

                    // Check for the word "coffee"
                    if (lowerCaseLine.contains("coffee")) {
                        secretMessage.append("COFFEE ");
                    }

                    // Check for the word "required"
                    if (lowerCaseLine.contains("required")) {
                        secretMessage.append("REQUIRED ");
                    }
                }
            }

            // Write a blank line before the bonus message
            writer.newLine();

            // Write the bonus message header to the output file
            writer.write("--- BONUS MESSAGE (WatcherNotes Scan) ---");
            writer.newLine();

            // Write the extracted message (or a fallback message)
            if (secretMessage.length() > 0) {
                writer.write(secretMessage.toString().trim());
            } else {
                writer.write("(No hidden message found.)");
            }

            // Also print the bonus message to the console
            System.out.println();
            System.out.println("--- BONUS MESSAGE (WatcherNotes Scan) ---");
            System.out.println(secretMessage.toString().trim());

        } catch (IOException e) {
            // Handle any errors related to file access
            System.out.println("Something went sideways: " + e.getMessage());
        }
    }
}
