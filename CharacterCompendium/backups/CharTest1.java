// CharTest1.java
// Using the Account constructor to initalze the name instance
// variable at the time each Account object is created.

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; 
import java.io.File;

public class CharTest1 {
        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            ArrayList<Char1> characters = new ArrayList<>();

            // prompt for user data
            while(true) {
                System.out.print("Add Name (or type 'done'): ");
                String name = input.nextLine().trim();

                if (name.equalsIgnoreCase("done") || name.isEmpty()) {
                    break;
                }
        
            System.out.print("Add type: ");
            String type = input.nextLine().trim();

            System.out.print("Add relationship: ");
            String relationship = input.nextLine().trim();

            System.out.print("Add Bio (1-2 lines): ");
            String bio = input.nextLine().trim();

            Char1 char1 = new Char1(name, type, relationship, bio);
            characters.add(char1);

            System.out.println("\nEntry saved.\n");
         }    
           
            // summary
            System.out.println("\n--- Character Summary ---");
            for (int i = 0; i < characters.size(); i++) {
                Char1 c = characters.get(i);
                System.out.println((i + 1) + ". " + c.getName());
                System.out.println("   Type: " + c.getType());
                System.out.println("   Relationship: " + c.getRelationship());
                System.out.println("   Bio: " + c.getBio());
 }

 // write CSV "spreadsheet"
 File csvFile = new File("CharacterSummary.csv");
boolean fileExists = csvFile.exists();

try (PrintWriter out = new PrintWriter(new FileWriter(csvFile, true))) {

    // write header only if file is new
    if (!fileExists) {
        out.println("Name,Type,Relationship,Bio");
     }

    for (Char1 c : characters) {
        out.printf("%s,%s,%s,%s%n",
                csv(c.getName()),
                csv(c.getType()),
                csv(c.getRelationship()),
                csv(c.getBio()));
    }

    System.out.println("\nCharacters appended to Wheelhaven Compendium.");

 } catch (IOException e) {
    System.out.println("Could not save CSV file: " + e.getMessage());
 }
 
 input.close();

 } //end of main method
 //helper to make CSV file save (handles commas/quotes)
 private static String csv(String value) {
    if (value == null) {
        return"";
    }
    String escaped = value.replace("\"", "\"\"");
    return "\"" + escaped + "\"";
 }
 } // end of CharTest1 class     