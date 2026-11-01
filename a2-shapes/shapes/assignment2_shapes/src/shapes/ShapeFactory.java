/*
 * TCSS 305 - Winter 2024
 * ShapeFactory.java
 * Assignment 2
 * Instructor; Tom Capaul
 */
 
package shapes;

/**
 * A factory class for creating instances of various shapes.
 */
public final class ShapeFactory {

    /**
     * Creates a Circle with the specified radius.
     *
     * @param radius the radius of the Circle, must be greater than 0
     * @return a new Circle object
     * @throws IllegalArgumentException if the radius is not greater than 0
     */
    public static Circle createCircle(final double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0. Provided: " + radius);
        }
        return new Circle(radius);
    }

    /**
     * Creates a Square with the specified side length.
     *
     * @param sideLength the side length of the Square, must be greater than 0
     * @return a new Square object
     * @throws IllegalArgumentException if the side length is not greater than 0
     */
    public static Square createSquare(final double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Side length must be greater than 0. Provided: " + sideLength);
        }
        return new Square(sideLength);
    }

    /**
     * Creates a Triangle with the specified base and height.
     *
     * @param base the base length of the Triangle, must be greater than 0
     * @param height the height of the Triangle, must be greater than 0
     * @return a new Triangle object
     * @throws IllegalArgumentException if the base or height is not greater than 0
     */
    public static Triangle createTriangle(final double base, final double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be greater than 0. Provided: base=" + base + ", height=" + height);
        }
        return new Triangle(base, height);
    }

    /**
     * Creates a Rectangle with the specified length and width.
     *
     * @param length the length of the Rectangle, must be greater than 0
     * @param width the width of the Rectangle, must be greater than 0
     * @return a new Rectangle object
     * @throws IllegalArgumentException if the length or width is not greater than 0
     */
    public static Rectangle createRectangle(final double length, final double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be greater than 0. Provided: length=" + length + ", width=" + width);
        }
        return new Rectangle(length, width);
    }
}
