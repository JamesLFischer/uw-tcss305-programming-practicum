/*
 * TCSS 305 - Winter 2024
 * Square.java
 * Assignment 2
 * Instructor; Tom Capaul
 */
 
package shapes;

/**
 * Represents a square with a specific side length.
 * Extends AbstractShape to provide area and name functionality.
 */
public final class Square extends AbstractShape {

    /** The side length of the square. */
    private final double mySideLength;

    /**
     * Constructor for Square. Validates that the side length is greater than 0.
     * 
     * @param theSideLength the side length of the square
     * @throws IllegalArgumentException if the side length is less than or equal to 0
     */
    Square(final double theSideLength) {
        if (theSideLength <= 0) {
            throw new IllegalArgumentException("Side length must be greater than 0. Given: " + theSideLength);
        }
        mySideLength = theSideLength;
    }

    /**
     * Returns the side length of the square.
     * 
     * @return the side length as a double
     */
    public double getSideLength() {
        return mySideLength;
    }

    /**
     * Calculates and returns the area of the square.
     * 
     * @return the area of the square
     */
    @Override
    public double area() {
        return mySideLength * mySideLength;
    }

    /**
     * Returns the name of the shape, which is "Square".
     * 
     * @return the name of the shape as a String
     */
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    /**
     * Returns a hash code value for the square.
     * 
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Double.hashCode(mySideLength);
    }
}
