// Import classes needed to read text files line by line
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePooper {

    public static void main(String[] args) {

        // Relative path to the input file.
        // This assumes the program is run from the project root folder.
        String fileName = "data/input.txt";

        // Boolean flag used to track whether we are currently
        // inside the [WatcherNotes] section of the file.
        boolean inWatcherNotes = false;

        // StringBuilder is used instead of String so we can
        // efficiently build the hidden message word by word.
        StringBuilder secretMessage = new StringBuilder();

        // Try-with-resources automatically closes the file
        // when we are done reading it (even if an error occurs).
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            // Variable to hold each line read from the file
            String line;

            // Read the file one line at a time until there are no lines left
            while ((line = reader.readLine()) != null) {

                // Print the current line exactly as it appears in the file
                System.out.println(line);

                // Remove leading and trailing whitespace for easier comparisons
                String trimmedLine = line.trim();

                // Check if we have reached the WatcherNotes section
                if (trimmedLine.equals("[WatcherNotes]")) {
                    inWatcherNotes = true;
                    // Skip further processing of this line
                    continue;
                }

                // Check if we have reached the end of the log
                if (trimmedLine.startsWith("=== END LOG")) {
                    inWatcherNotes = false;
                }

                // Only scan for the hidden message if we are
                // currently inside the WatcherNotes section
                if (inWatcherNotes) {

                    // Convert the line to lowercase so our search
                    // is case-insensitive
                    String lowerCaseLine = trimmedLine.toLowerCase();

                    // Look for the word "coffee" anywhere in the line
                    if (lowerCaseLine.contains("coffee")) {
                        secretMessage.append("COFFEE ");
                    }

                    // Look for the word "required" anywhere in the line
                    if (lowerCaseLine.contains("required")) {
                        secretMessage.append("REQUIRED ");
                    }
                }
            }

            // After the file has been fully read,
            // print the extracted bonus message
            System.out.println();
            System.out.println("--- BONUS MESSAGE (WatcherNotes Scan) ---");

            // If we found any hidden words, print them
            if (secretMessage.length() > 0) {
                System.out.println(secretMessage.toString().trim());
            } else {
                // Otherwise, explicitly state that no message was found
                System.out.println("(No hidden message found.)");
            }

        } catch (IOException e) {
            // Catch and report any file-related errors,
            // such as file not found or read permissions issues
            System.out.println("Something went sideways: " + e.getMessage());
        }
    }
}
