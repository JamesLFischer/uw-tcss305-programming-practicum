/*
 * TCSS 305 - Winter 2024
 * Circle.java
 * Assignment 2
 * Instructor; Tom Capaul
 */
 
package shapes;

/**
 * Represents a circle with a specific radius.
 * Extends AbstractShape to provide area and name functionality.
 */
public final class Circle extends AbstractShape {

    /** The radius of the circle. */
    private final double myRadius;

    /**
     * Constructor for Circle. Validates that the radius is greater than 0.
     * 
     * @param theRadius the radius of the circle
     * @throws IllegalArgumentException if the radius is less than or equal to 0
     */
    Circle(final double theRadius) {
        if (theRadius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0. Given: " + theRadius);
        }
        myRadius = theRadius;
    }

    /**
     * Returns the radius of the circle.
     * 
     * @return the radius as a double
     */
    public double getRadius() {
        return myRadius;
    }

    /**
     * Calculates and returns the area of the circle.
     * 
     * @return the area of the circle
     */
    @Override
    public double area() {
        return Math.PI * myRadius * myRadius;
    }

    /**
     * Returns the name of the shape, which is "Circle".
     * 
     * @return the name of the shape as a String
     */
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    /**
     * Returns a hash code value for the circle.
     * 
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Double.hashCode(myRadius);
    }
}
