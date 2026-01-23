// Name: Summer Star Isakson
// Lab Date: 2026-01-22

import java.util.Scanner;

//public class DemoBook {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); 

        // Get Title
        System.out.println("Input title of book: ");
        String title = input.nextLine();

        // Get number of pages
        System.out.println("Input number of pages: ");
        int pages = input.nextInt();
        input.nextLine(); // Clear buffer

        // Get book type
        System.out.println("Input Type, Pleasure or Textbook (p/t): ");
        String type = input.nextLine().toLowerCase();

        Book book; // Polymorphism happens here

        if (type.equals("t")) {
            System.out.print("Recommended for grade level: ");
            int gradeLevel = input.nextInt();

            book = new Textbook(title, pages, gradeLevel);

            System.out.println("\nBook is " + book.getTitle() +
                " with " + book.getPages() +
                " pages. It is recommended for grade level " +
                ((Textbook) book).getGradeLevel());
      
        } else {
            book = new Book(title, pages);
            System.out.println("\nBook is " + book.getTitle() +
            " with " + book.getPages() + " pages.");
        }

        input.close();

    }
   