import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {

        // Scanner reads input from the keyboard
        Scanner scanner = new Scanner(System.in);

        try {
            // Ask the user for a number
            System.out.print("Enter a number: ");

            // This line can THROW an exception if the input is not a number
            int number = Integer.parseInt(scanner.nextLine());

            // This can also throw an exception if number is 0
            int result = 10 / number;

            // If we reach this line, everything worked
            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {

            // Happens when the user types something that is not a number
            System.out.println("That was not a valid number.");

        } catch (ArithmeticException e) {

            // Happens when dividing by zero
            System.out.println("You cannot divide by zero. Math says no.");

        } finally {

            // This ALWAYS runs, no matter what happens above
            // Used for cleanup like closing scanners, files, etc.
            scanner.close();
            System.out.println("Program finished safely.");
        }
    }
}
