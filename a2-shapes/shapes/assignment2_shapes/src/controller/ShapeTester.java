/*
 * TCSS 305 - Winter 2024
 * ShapeTester.java
 * Assignment 2
 * Instructor; Tom Capaul
 */
 
package controller;

import shapes.AbstractShape;
import shapes.ShapeFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShapeTester {
    public static void main(String[] args) {
        ArrayList<AbstractShape> shapes = new ArrayList<>();

        // Create shapes using ShapeFactory
        for (int i = 0; i < 5; i++) {
            shapes.add(ShapeFactory.createCircle(1.0 + i)); // Circles with radius 1.0, 2.0, 3.0, 4.0, 5.0
            shapes.add(ShapeFactory.createSquare(1.0 + i)); // Squares with side length 1.0, 2.0, 3.0, 4.0, 5.0
            shapes.add(ShapeFactory.createTriangle(1.0 + i, 2.0 + i)); // Triangles with base and height
            shapes.add(ShapeFactory.createRectangle(1.0 + i, 2.0 + i)); // Rectangles with length and width
        }

        // Print shapes before sorting
        System.out.println("Shapes before sorting:");
        printShapes(shapes);

        // Sort shapes
        Collections.sort(shapes);

        // Print shapes after sorting
        System.out.println("\nShapes after sorting:");
        printShapes(shapes);
    }

    private static void printShapes(ArrayList<AbstractShape> shapes) {
        for (AbstractShape shape : shapes) {
            System.out.println(shape);
        }
    }
}
