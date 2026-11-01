/*
 * TCSS 305 - Winter 2024
 * Rectangle.java
 * Assignment 2
 * Instructor; Tom Capaul
 */
 
package shapes;

/**
 * Represents a rectangle with a specific length and width.
 * Extends AbstractShape to provide area and name functionality.
 */
public final class Rectangle extends AbstractShape {

    /** The length of the rectangle. */
    private final double myLength;

    /** The width of the rectangle. */
    private final double myWidth;

    /**
     * Constructor for Rectangle. Validates that both length and width are greater than 0.
     * 
     * @param theLength the length of the rectangle
     * @param theWidth the width of the rectangle
     * @throws IllegalArgumentException if either length or width is less than or equal to 0
     */
    Rectangle(final double theLength, final double theWidth) {
        if (theLength <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0. Given: " + theLength);
        }
        if (theWidth <= 0) {
            throw new IllegalArgumentException("Width must be greater than 0. Given: " + theWidth);
        }
        myLength = theLength;
        myWidth = theWidth;
    }

    /**
     * Returns the length of the rectangle.
     * 
     * @return the length as a double
     */
    public double getLength() {
        return myLength;
    }

    /**
     * Returns the width of the rectangle.
     * 
     * @return the width as a double
     */
    public double getWidth() {
        return myWidth;
    }

    /**
     * Calculates and returns the area of the rectangle.
     * Area formula: length * width
     * 
     * @return the area of the rectangle
     */
    @Override
    public double area() {
        return myLength * myWidth;
    }

    /**
     * Returns the name of the shape, which is "Rectangle".
     * 
     * @return the name of the shape as a String
     */
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    /**
     * Returns a hash code value for the rectangle.
     * 
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Double.hashCode(myLength) + Double.hashCode(myWidth);
    }
}
