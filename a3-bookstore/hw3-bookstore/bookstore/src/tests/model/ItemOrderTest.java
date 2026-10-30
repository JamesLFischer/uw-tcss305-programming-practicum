// ItemOrderTest.java
// Test class for ItemOrder
package model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ItemOrderTest {

    @Test
    void testItemOrderConstruction() {
        Item item = new Item("Test Item", BigDecimal.valueOf(10.00));
        ItemOrder order = new ItemOrder(item, 3);
        assertEquals(3, order.getQuantity());
        assertEquals(item, order.getItem());
    }

    @Test
    void testCompareTo() {
        Item item = new Item("Test Item", BigDecimal.valueOf(10.00));
        ItemOrder order1 = new ItemOrder(item, 3);
        ItemOrder order2 = new ItemOrder(item, 5);
        assertTrue(order1.compareTo(order2) < 0);
        assertTrue(order2.compareTo(order1) > 0);
    }

    @Test
    void testCompareToEqual() {
        Item item = new Item("Test Item", BigDecimal.valueOf(10.00));
        ItemOrder order1 = new ItemOrder(item, 3);
        ItemOrder order2 = new ItemOrder(item, 3);
        assertEquals(0, order1.compareTo(order2));
    }
}

