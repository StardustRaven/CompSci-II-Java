// Name: Summer Star Isakson
// Lab Date: 2026-01-22
// Description: Triangle class that extends GeometricObject.
//              Represents a triangle using three side lengths
//              and provides methods to calculate area and perimeter.



public class Triangle extends GeometricObject {

    // Lengths of the three sides of the triangle
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    // No-argument constructor that creates a default triangle
    public Triangle() {
        super();
    }

    // Constructor that creates a triangle with specified side lengths
    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Returns side1
    public double getSide1() {
        return side1;
    }

    // Returns side2
    public double getSide2() {
        return side2;
    }

    // Returns side3
    public double getSide3() {
        return side3;
    }

    // Behavior methods
    public boolean isValid() {
        return (side1 + side2 > side3) &&
               (side1 + side3 > side2) &&
               (side2 + side3 > side1);
    }

    // Calculates and returns the perimeter of the triangle
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Calculates and returns the area of the triangle
    // Uses Heron's formula
    public double getArea() {
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Returns a string description of the triangle
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 +
               " side2 = " + side2 +
               " side3 = " + side3;
    }
}