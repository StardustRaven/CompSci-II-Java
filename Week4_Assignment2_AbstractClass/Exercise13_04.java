// Name: Summer Isakson
// Lab: Exercise 13.4
// Date: 02/03/2026
//
// Program Description:
// This program receives a month and year from the command line
// and displays a formatted calendar for that month.

// How to Run:
// Compile: javac Exercise13_04.java MyCalendar.java
// Run: java Exercise13_04 <month> <year>
// Example: java Exercise13_04 2 2026

public class Exercise13_04 {

    public static void main(String[] args) {

        // Check that two command-line arguments were provided
        if (args.length != 2) {
            System.out.println("Usage: java Exercise13_04 <month> <year>");
            return;
        }

        // Convert command-line arguments to integers
        int month = Integer.parseInt(args[0]); // 1–12
        int year = Integer.parseInt(args[1]);

        // Call calendar display class
        MyCalendar.printMonth(month, year);
    }
}
