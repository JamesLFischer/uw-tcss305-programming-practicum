/*
 * TCSS 305 - Winter 2024
 * ClockTests.java
 * Assignment 1
 * Instructor: Tom Capaul
 */

import java.time.LocalTime;

/**
 * The ClockTests class serves as a test suite for the Clock class,
 * providing unit tests to validate its behavior. It includes tests 
 * for various constructors, methods, and expected functionalities of 
 * the Clock class.
 */
public class ClockTests {

    /**
     * The main method serves as the entry point for executing all unit tests
     * for the Clock class. It invokes various test methods to ensure the 
     * correct functionality of the Clock class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("---CLOCK TESTS---");
        testDefaultConstructor();
        testToString();
        testExplicitValueConstructor();
        testSetHour();
        testSetMinute();
        testSetSecond();
        testAdvanceHour();
        testAdvanceMinute();
        testEquals();
        testCompareTo();
        // The below method call is for the extra credit
        testSetToCurrentTime();
        System.out.println("---END CLOCK TESTS---");
    }

    /**
     * Tests the setToCurrentTime() method of the Clock class to ensure
     * it correctly sets the clock to the current system time.
     */
    private static void testSetToCurrentTime() {
        System.out.println("CLOCK SETTOCURRENTTIME TESTS");

        // Create a clock and set it to the current system time
        Clock clock = new Clock();
        clock.setToCurrentTime();

        // Get the current system time for comparison
        LocalTime now = LocalTime.now();

        // Test if the clock's time is the same as the system time (allowing a small range to account for milliseconds)
        if (Math.abs(clock.getHour() - now.getHour()) <= 1 &&
                Math.abs(clock.getMinute() - now.getMinute()) <= 1 &&
                Math.abs(clock.getSecond() - now.getSecond()) <= 1) {
            System.out.println("\tPASSED - Clock set to current time: " + clock);
        } else {
            System.out.println("\tFAILED - Clock not set to current time: " + clock + ", expected: " + now);
        }

        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the compareTo() method of the Clock class to ensure proper
     * comparisons between different Clock objects.
     */
    private static void testCompareTo() {
        Clock clock1 = new Clock(0, 0, 0);
        Clock clock2 = new Clock(0, 0, 0);
        Clock clock3 = new Clock(0, 0, 5);
        Clock clock4 = new Clock(0, 10, 0);
        Clock clock5 = new Clock(3, 0, 0);

        System.out.println("CLOCK COMPARETO TESTS");
        System.out.println("Testing two different Clock objects that are the same for equality");
        if (clock1.compareTo(clock2) == 0)
            System.out.println("\tPASSED two equal clocks");
        else
            System.out.println("\tFAILED two equal clocks");

        System.out.println("Testing first clock less than third clock (seconds)");
        if (clock1.compareTo(clock3) < 0)
            System.out.println("\tPASSED first clock less than");
        else
            System.out.println("\tFAILED first clock less than");

        System.out.println("Testing first clock less than fourth clock (minutes)");
        if (clock1.compareTo(clock4) < 0)
            System.out.println("\tPASSED first clock less");
        else
            System.out.println("\tFAILED first clock less");

        System.out.println("Testing first clock less than fifth clock (hours)");
        if (clock1.compareTo(clock5) < 0)
            System.out.println("\tPASSED first clock less");
        else
            System.out.println("\tFAILED first clock less");

        System.out.println("Testing third clock greater than first clock (seconds)");
        if (clock3.compareTo(clock1) > 0)
            System.out.println("\tPASSED third clock greater");
        else
            System.out.println("\tFAILED third clock greater");

        System.out.println("Testing fourth clock greater than first clock (minutes)");
        if (clock4.compareTo(clock1) > 0)
            System.out.println("\tPASSED fourth clock greater");
        else
            System.out.println("\tFAILED fourth clock greater");

        System.out.println("Testing fifth clock greater than first clock (hours)");
        if (clock5.compareTo(clock1) > 0)
            System.out.println("\tPASSED fifth clock greater");
        else
            System.out.println("\tFAILED fifth clock greater");

        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the equals() method of the Clock class to ensure proper
     * equality checks between different Clock objects.
     */
    private static void testEquals() {
        Clock clock1 = new Clock(0, 0, 0);
        Clock clock2 = new Clock(0, 0, 0);
        Clock clock3 = new Clock(0, 0, 11);
        Clock clock4 = new Clock(0, 41, 0);
        Clock clock5 = new Clock(11, 0, 0);

        System.out.println("CLOCK EQUALS TESTS");

        System.out.println("Testing two clocks equal");
        if (clock1.equals(clock2))
            System.out.println("\tPASSED two equal clocks");
        else
            System.out.println("\tFAILED two equal clocks");

        System.out.println("Testing two clocks not equal -- clock 3 11 seconds different");
        if (clock1.equals(clock3))
            System.out.println("\tFAILED third clock 11 seconds different");
        else
            System.out.println("\tPASSED third clock 11 seconds different");

        System.out.println("Testing two clocks not equal -- clock 4 41 minutes different");
        if (clock1.equals(clock4))
            System.out.println("\tFAILED fourth clock 41 minutes different");
        else
            System.out.println("\tPASSED fourth clock 41 minutes different");

        System.out.println("Testing two clocks not equal -- clock 5 11 hours different");
        if (clock1.equals(clock5))
            System.out.println("\tFAILED fifth clock 11 hours different");
        else
            System.out.println("\tPASSED fifth clock 11 hours different");

        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the advanceMinute() method of the Clock class to ensure it
     * correctly advances the clock's minute and handles edge cases.
     */
    private static void testAdvanceMinute() {

        System.out.println("CLOCK ADVANCEMINUTE TESTS");

        Clock clock = new Clock(0, 0, 0);

        System.out.println("Testing with negative value, should throw an exception");
        try {
            clock.advanceMinute(-1);
            System.out.println("\tFAILED to throw IllegalArgumentException for -1");
        }
        catch (IllegalArgumentException e){
            System.out.println("\tPASSED throwing an IllegalArgumentException for -1");
        }

        System.out.println("Testing with value of zero, minute should be the same");
        clock.advanceMinute(0);
        if (clock.getMinute() == 0) {
            System.out.println("\tPASSED for value of 0");
        }
        else {
            System.out.println("\tFAILED for value of 0: " + clock.getMinute());
        }

        System.out.println("Testing with value of 59 when minute is 0");
        clock.advanceMinute(59);
        if (clock.getMinute() == 59) {
            System.out.println("\tPASSED for 59");
        }
        else {
            System.out.println("\tFAILED for 59: " + clock.getMinute());
        }

        System.out.println("Testing with value of 60, minute should be the same, hour should be +1");
        clock.setMinute(0);
        clock.advanceMinute(60);
        if (clock.getHour() == 1 && clock.getMinute() == 0) {
            System.out.println("\tPASSED for 60 -- hour advanced by 1");
        }
        else {
            System.out.println("\tFAILED for 60: " + clock.getHour() + ", "+ clock.getMinute());
        }

        System.out.println("Testing with value of 1440, minute and hour should be the same");
        clock.setMinute(0);
        clock.setHour(0);
        clock.advanceMinute(1440);
        if (clock.getHour() == 0 && clock.getMinute() == 0) {
            System.out.println("\tPASSED for 1440");
        }
        else {
            System.out.println("\tFAILED for 1440: " + clock.getHour() + ", "+ clock.getMinute());
        }

        System.out.println("Testing with value of 1501, minute and hour should be 1");
        clock.setMinute(0);
        clock.setHour(0);
        clock.advanceMinute(1501);
        if (clock.getHour() == 1 && clock.getMinute() == 1) {
            System.out.println("\tPASSED for 1501");
        }
        else {
            System.out.println("\tFAILED for 1501: " + clock.getHour() + ", "+ clock.getMinute());
        }

        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the advanceHour() method of the Clock class to ensure it
     * correctly advances the clock's hour and handles edge cases.
     */
    private static void testAdvanceHour() {

        System.out.println("CLOCK ADVANCEHOUR TESTS");

        Clock clock = new Clock(0, 0, 0);

        System.out.println("Testing with negative value, should throw an exception");
        try {
            clock.advanceHour(-1);
            System.out.println("\tFAILED to throw IllegalArgumentException for -1");
        }
        catch (IllegalArgumentException e){
            System.out.println("\tPASSED throwing an IllegalArgumentException for -1");
        }

        System.out.println("Testing with value of zero, hour should be the same");
        clock.advanceHour(0);
        if (clock.getHour() == 0) {
            System.out.println("\tPASSED for value of 0");
        }
        else {
            System.out.println("\tFAILED for value of 0: " + clock.getHour());
        }

        System.out.println("Testing with value of 23, hour should be the same");
        clock.advanceHour(23);
        if (clock.getHour() == 23) {
            System.out.println("\tPASSED for 23");
        }
        else {
            System.out.println("\tFAILED for 23: " + clock.getHour());
        }

        System.out.println("Testing with value of 24, hour should be the same, minute should be 0");
        clock.setHour(0);
        clock.advanceHour(24);
        if (clock.getHour() == 0 && clock.getMinute() == 0) {
            System.out.println("\tPASSED for 24");
        }
        else {
            System.out.println("\tFAILED for 24: " + clock.getHour() + ", "+ clock.getMinute());
        }

        System.out.println("Testing with value of 25, hour should be 1, minute should be 0");
        clock.setHour(0);
        clock.advanceHour(25);
        if (clock.getHour() == 1 && clock.getMinute() == 0) {
            System.out.println("\tPASSED for 25");
        }
        else {
            System.out.println("\tFAILED for 25: " + clock.getHour() + ", "+ clock.getMinute());
        }

        System.out.println("Testing with value of 100, hour should be 4, minute should be 0");
        clock.setHour(0);
        clock.advanceHour(100);
        if (clock.getHour() == 4 && clock.getMinute() == 0) {
            System.out.println("\tPASSED for 100");
        }
        else {
            System.out.println("\tFAILED for 100: " + clock.getHour() + ", "+ clock.getMinute());
        }

        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the setSecond() method of the Clock class to ensure it correctly
     * sets the seconds while handling invalid values.
     */
    private static void testSetSecond() {
        System.out.println("CLOCK SETSECOND TESTS");
        Clock clock = new Clock(0, 0, 0);
        System.out.println("Testing valid second value 59");
        clock.setSecond(59);
        if (clock.getSecond() == 59) {
            System.out.println("\tPASSED valid second value 59");
        }
        else {
            System.out.println("\tFAILED valid second value 59: " + clock.getSecond());
        }

        System.out.println("Testing invalid second value 60");
        try {
            clock.setSecond(60);
            System.out.println("\tFAILED to throw IllegalArgumentException for 60");
        }
        catch (IllegalArgumentException e){
            System.out.println("\tPASSED throwing an IllegalArgumentException for 60");
        }

        System.out.println("Testing invalid second value -1");
        try {
            clock.setSecond(-1);
            System.out.println("\tFAILED to throw IllegalArgumentException for -1");
        }
        catch (IllegalArgumentException e){
            System.out.println("\tPASSED throwing an IllegalArgumentException for -1");
        }
        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the setMinute() method of the Clock class to ensure it correctly
     * sets the minutes while handling invalid values.
     */
    private static void testSetMinute() {
        System.out.println("CLOCK SETMINUTE TESTS");
        Clock clock = new Clock(0, 0, 0);
        System.out.println("Testing valid minute value 59");
        clock.setMinute(59);
        if (clock.getMinute() == 59) {
            System.out.println("\tPASSED valid minute value 59");
        }
        else {
            System.out.println("\tFAILED valid minute value 59: " + clock.getMinute());
        }

        System.out.println("Testing invalid minute value 60");
        try {
            clock.setMinute(60);
            System.out.println("\tFAILED to throw IllegalArgumentException for 60");
        }
        catch (IllegalArgumentException e){
            System.out.println("\tPASSED throwing an IllegalArgumentException for 60");
        }

        System.out.println("Testing invalid minute value -1");
        try {
            clock.setMinute(-1);
            System.out.println("\tFAILED to throw IllegalArgumentException for -1");
        }
        catch (IllegalArgumentException e){
            System.out.println("\tPASSED throwing an IllegalArgumentException for -1");
        }
        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the setHour() method of the Clock class to ensure it correctly
     * sets the hours while handling invalid values.
     */
    private static void testSetHour() {
        System.out.println("CLOCK SETHOUR TESTS");
        Clock clock = new Clock(0, 0, 0);
        System.out.println("Testing valid hour value 23");
        clock.setHour(23);
        if (clock.getHour() == 23) {
            System.out.println("\tPASSED valid hour value 23");
        }
        else {
            System.out.println("\tFAILED valid hour value 23: " + clock.getHour());
        }

        System.out.println("Testing invalid hour value 24");
        try {
            clock.setHour(24);
            System.out.println("\tFAILED to throw IllegalArgumentException for 24");
        }
        catch (IllegalArgumentException e){
            System.out.println("\tPASSED throwing an IllegalArgumentException for 24");
        }

        System.out.println("Testing invalid hour value -1");
        try {
            clock.setHour(-1);
            System.out.println("\tFAILED to throw IllegalArgumentException for -1");
        }
        catch (IllegalArgumentException e){
            System.out.println("\tPASSED throwing an IllegalArgumentException for -1");
        }
        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the toString() method of the Clock class to ensure it returns
     * the correct string representation of the clock time.
     */
    private static void testToString() {
        System.out.println("CLOCK TOSTRING TESTS");
        Clock clock = new Clock(0, 0, 0);
        if (clock.toString().equals("00:00:00")) {
            System.out.println("\tPASSED - Clock time is correct for 00:00:00");
        } else {
            System.out.println("\tFAILED - Clock time: " + clock.toString());
        }

        clock.setHour(1);
        clock.setMinute(1);
        clock.setSecond(1);
        if (clock.toString().equals("01:01:01")) {
            System.out.println("\tPASSED - Clock time is correct for 01:01:01");
        } else {
            System.out.println("\tFAILED - Clock time: " + clock.toString());
        }

        clock.setHour(10);
        clock.setMinute(10);
        clock.setSecond(10);
        if (clock.toString().equals("10:10:10")) {
            System.out.println("\tPASSED - Clock time is correct for 10:10:10");
        } else {
            System.out.println("\tFAILED - Clock time: " + clock.toString());
        }

        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the explicit value constructor of the Clock class to ensure it 
     * initializes the clock with specified hour, minute, and second values.
     */
    private static void testExplicitValueConstructor() {
        System.out.println("CLOCK EXPLICIT VALUE CONSTRUCTOR TESTS");
        Clock clock = new Clock(1, 1, 1);
        if (clock.getHour() == 1 && clock.getMinute() == 1 && clock.getSecond() == 1) {
            System.out.println("\tPASSED - Clock initialized to 01:01:01");
        } else {
            System.out.println("\tFAILED - Clock initialized: " + clock);
        }

        clock = new Clock(23, 59, 59);
        if (clock.getHour() == 23 && clock.getMinute() == 59 && clock.getSecond() == 59) {
            System.out.println("\tPASSED - Clock initialized to 23:59:59");
        } else {
            System.out.println("\tFAILED - Clock initialized: " + clock);
        }

        System.out.println("-------------------------------------------");
    }

    /**
     * Tests the default constructor of the Clock class to ensure it initializes 
     * the clock to 00:00:00.
     */
    private static void testDefaultConstructor() {
        System.out.println("CLOCK DEFAULT CONSTRUCTOR TEST");
        Clock clock = new Clock();
        if (clock.getHour() == 0 && clock.getMinute() == 0 && clock.getSecond() == 0) {
            System.out.println("\tPASSED - Default constructor initializes to 00:00:00");
        } else {
            System.out.println("\tFAILED - Default constructor initializes to: " + clock);
        }
        System.out.println("-------------------------------------------");
    }
}
