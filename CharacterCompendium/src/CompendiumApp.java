// Name: Summer Star Isakson
// Lab Date: 2026-01-20

// CompendiumApp.java
// Simple console app that collects character entries and appends them to a TSV file.
// Goal: practice inheritance + polymorphism in a program I'll actually use.

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class CompendiumApp {
    public static void main(String[] args) {

        // Scanner reads user input from the console (keyboard)
        Scanner input = new Scanner(System.in);

        // Store everything as CharacterEntry so the list can hold both CharacterEntry
        // AND WatcherEntry.
        // This is the whole "polymorphism" setup: one list type, multiple object types
        // inside it.
        ArrayList<CharacterEntry> characters = new ArrayList<>();

        // Keep asking for entries until the user types 'done' or enters a blank name.
        while (true) {
            System.out.print("Add Name (or type 'done'): ");
            String name = input.nextLine().trim();

            // Exit condition for the loop
            if (name.equalsIgnoreCase("done") || name.isEmpty()) {
                break;
            }

            // Decide what kind of object to create (base class vs subclass)
            System.out.print("Is this character a Watcher? (y/n): ");
            String watcherChoice = input.nextLine().trim().toLowerCase();

            // Declare one variable that can hold either kind of entry.
            // Both CharacterEntry and WatcherEntry fit here because WatcherEntry extends
            // CharacterEntry.
            CharacterEntry character;

            if (watcherChoice.equals("y") || watcherChoice.equals("yes")) {

                System.out.print("Add type (Human, Knife, etc.): ");
                String type = input.nextLine().trim();

                System.out.print("Add relationship: ");
                String relationship = input.nextLine().trim();

                System.out.print("Add Bio (1-2 lines): ");
                String bio = input.nextLine().trim();

                System.out.print("Add Watcher rank: ");
                String rank = input.nextLine().trim();

                character = new WatcherEntry(name, type, relationship, bio, rank);

            } else {

                // Cat, Human, Spoon, etc.
                System.out.print("Add type: ");
                String type = input.nextLine().trim();
                // Bonded, Wife, Partner
                System.out.print("Add relationship: ");
                String relationship = input.nextLine().trim();
                // Short blurb about character
                System.out.print("Add Bio (1-2 lines): ");
                String bio = input.nextLine().trim();

                // Create the base class object
                character = new CharacterEntry(name, type, relationship, bio);
            }

            // From this point on, we treat everything the same (base or subclass).
            // This is the benefit of using the parent type: one add(), one list, one
            // workflow.
            characters.add(character);
            System.out.println("\nEntry saved.\n");
        }

        // Print a quick summary of what was entered this run.
        // getSummary() is overridden by WatcherEntry, so the Watcher entries format
        // differently.
        // That automatic "pick the right version" behavior is polymorphism.
        System.out.println("\n--- Character Summary ---");
        for (int i = 0; i < characters.size(); i++) {
            CharacterEntry c = characters.get(i);
            System.out.println((i + 1) + ". " + c.getSummary());
        }

        // Output folder: keeps generated files out of src/ and out of the repo root.
        File outDir = new File("output");
        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        // TSV file (tab-separated). Better than CSV for bios because commas/quotes get
        // annoying fast.
        File tsvFile = new File(outDir, "CharacterSummary.tsv");

        // Used so the header is only written once when the file is first created.
        boolean fileExists = tsvFile.exists();

        // try-with-resources automatically closes PrintWriter even if something fails.
        // (Later in class: this is basically "finally { close the file }" but cleaner.)
        try (PrintWriter out = new PrintWriter(new FileWriter(tsvFile, true))) {

            // Write the header row only for a brand-new file
            if (!fileExists) {
                out.println("Name\tType\tRelationship\tRank\tBio");
            }

            // Append each entry to the file as a TSV row
            for (CharacterEntry c : characters) {
                out.printf("%s\t%s\t%s\t%s\t%s%n",
                        tsv(c.getName()),
                        tsv(c.getType()),
                        tsv(c.getRelationship()),
                        tsv(c.getRank()),
                        tsv(c.getBio()));
            }

            System.out.println("\nCharacters appended to CharacterSummary.tsv");

        } catch (IOException e) {
            // If file writing fails (permissions, path, file locked, etc.), don't crash the
            // program.
            System.out.println("Could not save TSV file: " + e.getMessage());
        }

        // Good habit: close input when done
        input.close();

    } // end of main method

    // TSV helper:
    // Tabs and newlines inside a field will break the columns, so replace them with
    // spaces.
    // This keeps the output readable when opened in Excel/Sheets.
    private static String tsv(String value) {
        if (value == null) {
            return "";
        }
        return value
                .replace("\t", " ")
                .replace("\n", " ")
                .replace("\r", " ");
    }
} // end of CompendiumApp class
