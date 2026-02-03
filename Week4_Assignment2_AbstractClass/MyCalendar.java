// Name: Star Isakson
// Lab: Exercise 13.4 (Calendar Display using Calendar/GregorianCalendar)
// Date: 02/03/2026
//
// Program Description:
// This class prints a calendar for a specified month and year.
// It uses Calendar and GregorianCalendar and is designed to be called
// from a main method (Exercise13_04.java) that passes month/year from
// the command line.

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyCalendar {

    // Prints a calendar for a specific month/year
    // month: 1-12 (human month)
    // year:  any valid year (e.g., 2026)
    public static void printMonth(int month, int year) {

        // Convert human month (1-12) to Calendar month (0-11)
        int calMonth = month - 1;

        // Create calendar set to the 1st day of the requested month/year
        Calendar cal = new GregorianCalendar(year, calMonth, 1);

        // Print month title + year
        printMonthTitle(cal, month, year);

        // Print week day headers
        printWeekTitle();

        // Print calendar body
        printMonthBody(cal);
    }

    // Prints the month name + year header
    private static void printMonthTitle(Calendar cal, int month, int year) {
        String monthName = getMonthName(month);

        System.out.println("         " + monthName + " " + year);
        System.out.println("-----------------------------------");
    }

    // Prints the weekday headings
    private static void printWeekTitle() {
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    // Prints the actual day grid
    private static void printMonthBody(Calendar cal) {

        // Calendar is currently set to the 1st of the month
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 1=Sunday ... 7=Saturday
        int startOffset = firstDayOfWeek - Calendar.SUNDAY;  // 0-6 spaces before day 1

        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Print leading spaces for first week
        for (int i = 0; i < startOffset; i++) {
            System.out.print("    ");
        }

        // Print all days
        for (int day = 1; day <= daysInMonth; day++) {

            // Print day right-aligned in 3 spaces
            System.out.printf("%4d", day);

            // Move calendar forward one day to track day-of-week
            cal.set(Calendar.DAY_OF_MONTH, day);

            // If Saturday, start new line
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                System.out.println();
            }
        }

        System.out.println(); // final line break
    }

    // Returns month name for 1-12
    private static String getMonthName(int month) {
        switch (month) {
            case 1:  return "January";
            case 2:  return "February";
            case 3:  return "March";
            case 4:  return "April";
            case 5:  return "May";
            case 6:  return "June";
            case 7:  return "July";
            case 8:  return "August";
            case 9:  return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Invalid Month";
        }
    }
}
