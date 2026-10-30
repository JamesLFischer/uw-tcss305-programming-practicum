/*
 * TCSS 305 - Winter 2024
 * ClockShop.java
 * Assignment 1
 * Instructor: Tom Capaul
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Represents a collection of clocks in a clock shop.
 * The ClockShop class manages an array of Clock objects and provides methods
 * for filling the shop from a file, retrieving clocks, and searching for
 * specific clocks.
 */
public class ClockShop {
    
    /** An array to store Clock objects in the shop. */
    private Clock[] clocks;
    
    /** The current number of clocks in the shop. */
    private int count;

    /**
     * Constructor to initialize the clock shop with a maximum size.
     * The shop is initialized to hold up to 5 clocks.
     */
    public ClockShop() {
        clocks = new Clock[5]; // Assuming a maximum of 5 clocks
        count = 0;
    }

    /**
     * Fills the clock shop from a file.
     * 
     * @param filename The name of the file to read clock data from.
     */
    public void fillClockShopFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null && count < clocks.length) {
                clocks[count++] = parseClock(line); // Use the parseClock method
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Parses a clock from a string representation.
     * 
     * @param line The string representation of the clock (formatted as "HH:MM:SS").
     * @return A Clock object created from the provided string.
     * @throws IllegalArgumentException if the string format is invalid.
     */
    public static Clock parseClock(String line) {
        String[] parts = line.split(":");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid clock format");
        }

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int second = Integer.parseInt(parts[2]);
        return new Clock(hour, minute, second);
    }

    /**
     * Retrieves a clock at a specific index.
     * 
     * @param index The index of the clock to retrieve.
     * @return The Clock object at the specified index.
     * @throws IllegalArgumentException if the index is out of bounds.
     */
    public Clock getClock(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return clocks[index];
    }

    /**
     * Sets a clock at a specific index.
     * 
     * @param index The index to set the clock at.
     * @param clock The Clock object to set.
     * @throws IllegalArgumentException if the index is out of bounds.
     */
    public void setClock(int index, Clock clock) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        clocks[index] = clock;
    }

    /**
     * Finds the index of a specific clock in the shop.
     * 
     * @param clock The Clock object to find.
     * @return The index of the clock if found, or -1 if not found.
     */
    public int findClock(Clock clock) {
        for (int i = 0; i < count; i++) {
            if (clocks[i].equals(clock)) {
                return i;
            }
        }
        return -1; // Clock not found
    }

    /**
     * Returns a string representation of all clocks in the shop.
     * 
     * @return A string containing the formatted output of all clocks.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(clocks[i].toString()).append("\n");
        }
        return sb.toString();
    }
}

