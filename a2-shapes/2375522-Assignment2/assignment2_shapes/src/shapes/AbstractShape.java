/*
 * TCSS 305 - Winter 2024
 * AbstractShape.java
 * Assignment 2
 * Instructor; Tom Capaul
 */
 
package shapes;

/**
 * Abstract class representing a generic shape.
 * Provides methods to get the name and area of the shape.
 * Implements Comparable to compare shapes by name and area.
 * Provides equals and hashCode implementations based on shape properties.
 */
public abstract class AbstractShape implements Comparable<AbstractShape> {

    /**
     * Returns the area of the shape.
     * 
     * @return the area as a double
     */
    public abstract double area();

    /**
     * Returns the name of the shape.
     * 
     * @return the name of the shape as a String
     */
    public abstract String name();

    /**
     * Returns a string representation of the shape including its name and area.
     * The area is formatted to two decimal places.
     * 
     * @return a formatted string representation of the shape
     */
    @Override
    public String toString() {
        return String.format("Name: %s, Area: %.2f", name(), area());
    }

    /**
     * Compares this shape to another shape by name and area.
     * 
     * @param theOtherShape the shape to compare against
     * @return an integer indicating the comparison result: negative if this shape
     *         is smaller, positive if larger, and 0 if equal
     */
    @Override
    public int compareTo(final AbstractShape theOtherShape) {
        int nameComparison = this.name().compareTo(theOtherShape.name());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Double.compare(this.area(), theOtherShape.area());
    }

    /**
     * Checks whether this shape is equal to another object.
     * Uses getClass() to compare classes and compareTo to compare properties.
     * 
     * @param theOtherObject the object to compare against
     * @return true if the shapes are the same, false otherwise
     */
    @Override
    public boolean equals(final Object theOtherObject) {
        if (this == theOtherObject) {
            return true;
        }
        if (theOtherObject == null || getClass() != theOtherObject.getClass()) {
            return false;
        }
        AbstractShape theOtherShape = (AbstractShape) theOtherObject;
        return compareTo(theOtherShape) == 0;
    }

    /**
     * Returns a hash code value for the shape.
     * 
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Double.hashCode(area()) * 31 + name().hashCode();
    }
}
