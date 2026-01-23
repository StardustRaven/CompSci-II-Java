// Name: Summer Star Isakson
// Lab Date: 2026-01-22
// Description: Base class representing a generic geometric object.
//              Stores color and filled status.

public class GeometricObject {

    // Color of the geometric object
    private String color = "white";

    // Indicates whether the object is filled
    private boolean filled = false;

    // No-argument constructor
    public GeometricObject() {
    }

    // Constructor with specified color and filled status
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Returns the color
    public String getColor() {
        return color;
    }

    // Sets the color
    public void setColor(String color) {
        this.color = color;
    }

    // Returns whether the object is filled
    public boolean isFilled() {
        return filled;
    }

    // Sets the filled status
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}