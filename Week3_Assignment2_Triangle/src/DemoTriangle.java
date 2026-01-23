// Name: Summer Star Isakson
// Lab Date: 2026-01-22
// Description: Test program that creates a Triangle object
//              and displays its area and perimeter.

import java.util.Scanner;

public class DemoTriangle {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Prompt user for triangle side lengths
        System.out.print("Enter side1: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side2: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side3: ");
        double side3 = input.nextDouble();

        // Create Triangle object
        Triangle triangle = new Triangle(side1, side2, side3);

        // Display triangle information
        System.out.println();
        System.out.println(triangle);
        if (!triangle.isValid()) {
            System.out.println("The sides entered do not form a valid traingle.");
        } else {
     
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Area: " + triangle.getArea());
        }
        input.close();
    }
}