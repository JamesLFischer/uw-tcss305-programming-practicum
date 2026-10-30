// ItemTest.java
// Test class for Item
package model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    void testItemConstruction() {
        Item item = new Item("Test Item", BigDecimal.valueOf(10.00));
        assertEquals("Test Item", item.getName());
        assertEquals(BigDecimal.valueOf(10.00), item.getPrice());
        assertEquals(0, item.getBulkQuantity());
        assertEquals(BigDecimal.ZERO, item.getBulkPrice());
    }

    @Test
    void testBulkItemConstruction() {
        Item item = new Item("Bulk Item", BigDecimal.valueOf(10.00), 5, BigDecimal.valueOf(45.00));
        assertEquals(5, item.getBulkQuantity());
        assertEquals(BigDecimal.valueOf(45.00), item.getBulkPrice());
        assertTrue(item.isBulk());
    }

    @Test
    void testCompareTo() {
        Item item1 = new Item("Item 1", BigDecimal.valueOf(10.00));
        Item item2 = new Item("Item 2", BigDecimal.valueOf(15.00));
        assertTrue(item1.compareTo(item2) < 0);
        assertTrue(item2.compareTo(item1) > 0);
    }

    @Test
    void testCompareToEqual() {
        Item item1 = new Item("Item 1", BigDecimal.valueOf(10.00));
        Item item2 = new Item("Item 2", BigDecimal.valueOf(10.00));
        assertEquals(0, item1.compareTo(item2));
    }
}

