// Name: Summer Star Isakson
// Lab Date: 2026-01-22

// Extra credit - added ability to enter multiple books | See lines 17 - 19
// Extra credit - added 'author' to input strings | See lines 29 - 30

import java.util.Scanner;
import java.util.ArrayList;

public class DemoBook {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        
        // How many books?
        System.out.print("How many books do you want to enter? ");
        int count = input.nextInt();
        input.nextLine(); // Clear buffer

        for (int i = 0; i < count; i++) {
            System.out.println("\nBook #" + (i + 1));

        // Get Title
        System.out.println("Input title of book: ");
        String title = input.nextLine();

        // Get Author
        System.out.println("Input author of book: ");
        String author = input.nextLine();

        // Get number of pages
        System.out.println("Input number of pages: ");
        int pages = input.nextInt();
        input.nextLine(); // Clear buffer

        // Get book type
        System.out.println("Input Type, Pleasure or Textbook (p/t): ");
        String type = input.nextLine().toLowerCase();

        // Book book; // Polymorphism happens here

        if (type.equals("t")) {
            System.out.print("Recommended for grade level: ");
            int gradeLevel = input.nextInt();
            input.nextLine(); // Clear buffer

            books.add(new Textbook(title, author, pages, gradeLevel));
        } else {
            books.add(new Book(title, author, pages));
        }    
    }
            // Output phase
            System.out.println("\n----- Book List -----");
            for (Book book : books) {
                if (book instanceof Textbook) {
                    Textbook tb = (Textbook) book;
                    System.out.println("Book is " + tb.getTitle() +
                        " by " + tb.getAuthor() +
                        " with " + tb.getPages() +
                        " pages. It is recommended for grade level " +
                        tb.getGradeLevel());
            
            } else {
                System.out.println("Book is " + book.getTitle() +
                    " by " + book.getAuthor() +
                    " with " + book.getPages() + " pages."); 
            }
        }

        input.close();

    }
}    