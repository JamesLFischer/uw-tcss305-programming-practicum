/*
 * TCSS 305 - Winter 2024
 * Clock.java
 * Assignment 1
 * Instructor: Tom Capaul
 */

import java.util.Calendar;
import java.util.Objects;

/**
 * Represents a clock with hours, minutes, and seconds.
 * The Clock class allows for the creation and manipulation of time in a 24-hour format.
 */
public class Clock implements Comparable<Clock> {

    /** The hour value of the clock (0-23). */
    private int myHour;
    
    /** The minute value of the clock (0-59). */
    private int myMinute;
    
    /** The second value of the clock (0-59). */
    private int mySecond;

    /**
     * Default constructor: initializes the clock to 00:00:00.
     */
    public Clock() {
        this(0, 0, 0); // Call the parameterized constructor
    }

    /**
     * Constructor that initializes the clock to a specified time.
     * 
     * @param hour   The hour to set (0-23).
     * @param minute The minute to set (0-59).
     * @param second The second to set (0-59).
     * @throws IllegalArgumentException if the provided hour, minute, or second is invalid.
     */
    public Clock(int hour, int minute, int second) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            throw new IllegalArgumentException("Invalid time value");
        }
        this.myHour = hour;
        this.myMinute = minute;
        this.mySecond = second;
    }

    /**
     * Sets the time of the clock.
     * 
     * @param hour   The hour to set (0-23).
     * @param minute The minute to set (0-59).
     * @param second The second to set (0-59).
     * @throws IllegalArgumentException if the provided hour, minute, or second is invalid.
     */
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || second < 0 || second > 59) {
            throw new IllegalArgumentException("Invalid time value");
        }
        this.myHour = hour;
        this.myMinute = minute;
        this.mySecond = second;
    }

    /**
     * Sets the hour of the clock.
     * 
     * @param hour The hour to set (0-23).
     * @throws IllegalArgumentException if the provided hour is invalid.
     */
    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Invalid hour value");
        }
        this.myHour = hour;
    }

    /**
     * Sets the minute of the clock.
     * 
     * @param minute The minute to set (0-59).
     * @throws IllegalArgumentException if the provided minute is invalid.
     */
    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid minute value");
        }
        this.myMinute = minute;
    }

    /**
     * Sets the second of the clock.
     * 
     * @param second The second to set (0-59).
     * @throws IllegalArgumentException if the provided second is invalid.
     */
    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Invalid second value");
        }
        this.mySecond = second;
    }

    /**
     * Sets the time to the current system time.
     * This method retrieves the current hour, minute, and second from the system clock.
     */
    public void setToCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        this.myHour = calendar.get(Calendar.HOUR_OF_DAY);
        this.myMinute = calendar.get(Calendar.MINUTE);
        this.mySecond = calendar.get(Calendar.SECOND);
    }

    /**
     * Advances the hour by the specified number of hours, adjusting for overflow.
     * 
     * @param hours The number of hours to advance (must be non-negative).
     * @throws IllegalArgumentException if the provided hours are negative.
     */
    public void advanceHour(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Cannot advance hour by a negative value");
        }
        this.myHour = (this.myHour + hours) % 24;
    }

    /**
     * Advances the minute by the specified number of minutes, adjusting for overflow.
     * 
     * @param minutes The number of minutes to advance (must be non-negative).
     * @throws IllegalArgumentException if the provided minutes are negative.
     */
    public void advanceMinute(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Cannot advance minute by a negative value");
        }
        if (minutes == 0) {
            return; // Do nothing if minutes is zero
        }

        int totalMinutes = this.myMinute + minutes;
        int extraHours = totalMinutes / 60;
        this.myMinute = totalMinutes % 60;
        advanceHour(extraHours);
    }

    /**
     * Returns a string representation of the clock in the format HH:MM:SS.
     * 
     * @return A formatted string representing the current time of the clock.
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.myHour, this.myMinute, this.mySecond);
    }

    /**
     * Compares this clock to another clock for ordering.
     * 
     * @param other The other clock to compare against.
     * @return A negative integer, zero, or a positive integer as this clock
     *         is less than, equal to, or greater than the specified clock.
     */
    @Override
    public int compareTo(Clock other) {
        if (this.myHour != other.myHour) {
            return Integer.compare(this.myHour, other.myHour);
        } else if (this.myMinute != other.myMinute) {
            return Integer.compare(this.myMinute, other.myMinute);
        } else {
            return Integer.compare(this.mySecond, other.mySecond);
        }
    }

    /**
     * Checks if this clock is equal to another object.
     * 
     * @param obj The object to compare with.
     * @return true if the specified object is equal to this clock; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Clock)) return false;
        Clock other = (Clock) obj;
        return this.myHour == other.myHour && this.myMinute == other.myMinute && this.mySecond == other.mySecond;
    }

    /**
     * Returns a hash code value for the clock.
     * 
     * @return A hash code value based on the hour, minute, and second.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.myHour, this.myMinute, this.mySecond);
    }

    /**
     * Gets the hour of the clock.
     * 
     * @return The hour value of the clock.
     */
    public int getHour() {
        return this.myHour;
    }

    /**
     * Gets the minute of the clock.
     * 
     * @return The minute value of the clock.
     */
    public int getMinute() {
        return this.myMinute;
    }

    /**
     * Gets the second of the clock.
     * 
     * @return The second value of the clock.
     */
    public int getSecond() {
        return this.mySecond;
    }
}
