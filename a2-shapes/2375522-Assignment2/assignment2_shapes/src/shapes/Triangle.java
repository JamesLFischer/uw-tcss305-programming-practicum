/*
 * TCSS 305 - Winter 2024
 * Triangle.java
 * Assignment 2
 * Instructor; Tom Capaul
 */
 
package shapes;

/**
 * Represents a triangle with a specific base and height.
 * Extends AbstractShape to provide area and name functionality.
 */
public final class Triangle extends AbstractShape {

    /** The base of the triangle. */
    private final double myBase;

    /** The height of the triangle. */
    private final double myHeight;

    /**
     * Constructor for Triangle. Validates that both base and height are greater than 0.
     * 
     * @param theBase the base of the triangle
     * @param theHeight the height of the triangle
     * @throws IllegalArgumentException if either base or height is less than or equal to 0
     */
    Triangle(final double theBase, final double theHeight) {
        if (theBase <= 0) {
            throw new IllegalArgumentException("Base must be greater than 0. Given: " + theBase);
        }
        if (theHeight <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0. Given: " + theHeight);
        }
        myBase = theBase;
        myHeight = theHeight;
    }

    /**
     * Returns the base of the triangle.
     * 
     * @return the base as a double
     */
    public double getBase() {
        return myBase;
    }

    /**
     * Returns the height of the triangle.
     * 
     * @return the height as a double
     */
    public double getHeight() {
        return myHeight;
    }

    /**
     * Calculates and returns the area of the triangle.
     * Area formula: (1/2) * base * height
     * 
     * @return the area of the triangle
     */
    @Override
    public double area() {
        return 0.5 * myBase * myHeight;
    }

    /**
     * Returns the name of the shape, which is "Triangle".
     * 
     * @return the name of the shape as a String
     */
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    /**
     * Returns a hash code value for the triangle.
     * 
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Double.hashCode(myBase) + Double.hashCode(myHeight);
    }
}
