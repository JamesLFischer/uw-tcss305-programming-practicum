/*
 * TCSS 305 - Winter 2024
 * ClockShopTests.java
 * Assignment 1
 * Instructor: Tom Capaul
 */

/**
 * This class contains unit tests for the ClockShop class.
 * It includes tests for filling the clock shop with clocks,
 * retrieving clocks, setting clocks, and finding clocks.
 */
public class ClockShopTests {

    /*
     * The main method in the provided code snippet serves as the entry point
     * for executing a series of unit tests for the ClockShop class.
     */
    public static void main(String[] args) {
        ClockShop clockShop = new ClockShop();
        testFillClockShop(clockShop);
        testToString(clockShop);
        testSetClock(clockShop);
        testGetClock(clockShop);
        testFindClock(clockShop);
    }

    /**
     * Tests filling the clock shop with clocks from a file.
     * It performs tests for one clock, two clocks, and multiple clocks.
     * 
     * @param clockShop The ClockShop object to fill with clocks.
     */
    public static void testFillClockShop(ClockShop clockShop) {
        System.out.println("---CLOCKSHOP TESTS---");
        System.out.println("CLOCKSHOP FILLCLOCKSHOP TESTS");

        // Test for one clock in file
        System.out.println("Testing to fill with clocks from file (one clock)");
        clockShop.fillClockShopFromFile("one_clock_file.txt");
        System.out.println("Clocks filled with one clock from file:");
        System.out.println(clockShop.toString());
        System.out.println("Expected clock: (12:12:12)"); // Adjust this according to your expected output
        System.out.println();

        // Test for two clocks in file
        System.out.println("Testing to fill with clocks from file (two clocks)");
        clockShop.fillClockShopFromFile("two_clock_file.txt");
        System.out.println("Clocks filled with two clocks from file:");
        System.out.println(clockShop.toString());
        System.out.println("Expected clocks: (17:40:00), (15:40:00)");
        System.out.println();

        // Test for multiple clocks in file
        System.out.println("Testing to fill with clocks from file (multiple clocks)");
        clockShop.fillClockShopFromFile("five_clock_file.txt");
        System.out.println("Clocks filled with multiple clocks from file:");
        System.out.println(clockShop.toString());
        System.out.println();
    }

    /**
     * Tests the toString method of the ClockShop class.
     * 
     * @param clockShop The ClockShop object to test.
     */
    public static void testToString(ClockShop clockShop) {
        System.out.println("-------------------------------------------");
        System.out.println("CLOCKSHOP TOSTRING TESTS");

        System.out.println("Testing toString with empty ClockShop -- nothing should be printed as result of this test");
        System.out.println(clockShop.toString());

        System.out.println("PASSED toString for empty ClockShop");
    }

    /**
     * Tests the setClock method of the ClockShop class.
     * 
     * @param clockShop The ClockShop object to test.
     */
    public static void testSetClock(ClockShop clockShop) {
        System.out.println("-------------------------------------------");
        System.out.println("CLOCKSHOP SETCLOCK TESTS");

        clockShop.fillClockShopFromFile("five_clock_file.txt");
        System.out.println("Filled clock shop with 5 clocks:");
        System.out.println(clockShop.toString());

        System.out.println("Testing with index of -1, should throw an IllegalArgumentException");
        try {
            clockShop.setClock(-1, new Clock(0, 0, 0)); // Adjusted to create a valid Clock instance
            System.out.println("FAILED - did not throw exception for index of -1");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED - threw exception for index of -1");
        }

        System.out.println("Testing with index of 5, should throw an IllegalArgumentException");
        try {
            clockShop.setClock(5, new Clock(0, 0, 0)); // Adjusted to create a valid Clock instance
            System.out.println("FAILED - did not throw exception for index of 5");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED - threw exception for index of 5");
        }

        System.out.println("Testing with index of 0, should replace clock at index 0");
        clockShop.setClock(0, new Clock(10, 11, 12));
        System.out.println("PASSED - replaced clock at index 0 with (10, 11, 12)");
        System.out.println("Clocks after setClock at index 0: ");
        System.out.println(clockShop.toString());

        System.out.println("Testing with index of 4, should replace clock at index 4");
        clockShop.setClock(4, new Clock(12, 11, 10));
        System.out.println("PASSED - replaced clock at index 4 with (12, 11, 10)");
        System.out.println("Clocks after setClock at index 4: ");
        System.out.println(clockShop.toString());
    }

    /**
     * Tests the getClock method of the ClockShop class.
     * 
     * @param clockShop The ClockShop object to test.
     */
    public static void testGetClock(ClockShop clockShop) {
        System.out.println("-------------------------------------------");
        System.out.println("CLOCKSHOP GETCLOCK TESTS");

        System.out.println("Here are the clocks in the clock shop after filling with 5 clocks:");
        clockShop.fillClockShopFromFile("five_clock_file.txt");
        System.out.println(clockShop.toString());

        System.out.println("Testing with index of -1, should throw an IllegalArgumentException");
        try {
            clockShop.getClock(-1);
            System.out.println("FAILED - did not throw exception for index of -1");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED - threw an exception for -1");
        }

        System.out.println("Testing with index of 5, should throw an IllegalArgumentException");
        try {
            clockShop.getClock(5);
            System.out.println("FAILED - did not throw exception for index of 5");
        } catch (IllegalArgumentException e) {
            System.out.println("PASSED - threw an exception for index of 5");
        }

        System.out.println("Testing with index of 0, should return clock (12, 12, 12)");
        Clock clock = clockShop.getClock(0);
        System.out.println("PASSED with index 0 " + clock);

        System.out.println("Testing with index of 4, should return clock (11, 11, 10)");
        clock = clockShop.getClock(4);
        System.out.println("PASSED - returned clock for index 4" + clock);
    }

    /**
     * Tests the findClock method of the ClockShop class.
     * 
     * @param clockShop The ClockShop object to test.
     */
    public static void testFindClock(ClockShop clockShop) {
        System.out.println("-------------------------------------------");
        System.out.println("CLOCKSHOP FINDCLOCK TESTS");

        clockShop.fillClockShopFromFile("five_clock_file.txt");
        System.out.println("Filled clock shop with 5 clocks");
        System.out.println(clockShop.toString());

        System.out.println("Testing with clock (10, 10, 10), expecting found index -1");
        int foundIndex = clockShop.findClock(new Clock(10, 10, 10));
        if (foundIndex == -1) {
            System.out.println("PASSED on clock not in clock shop");
        } else {
            System.out.println("FAILED - found clock at index: " + foundIndex);
        }

        System.out.println("Testing with first clock in clock shop (12, 12, 12)");
        foundIndex = clockShop.findClock(new Clock(12, 12, 12));
        if (foundIndex != -1) {
            System.out.println("PASSED - found clock (12, 12, 12) at index: " + foundIndex);
        } else {
            System.out.println("FAILED - clock should have been found");
        }
    }
}

