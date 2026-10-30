// CartTest.java
// Test class for Cart
package model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class CartTest {

    @Test
    void testAddItem() {
        Cart cart = new Cart();
        Item item = new Item("Test Item", BigDecimal.valueOf(10.00));
        cart.addItem(item, 2);
        assertEquals(1, cart.getItems().size());
    }

    @Test
    void testCalculateTotal() {
        Cart cart = new Cart();
        Item item1 = new Item("Item 1", BigDecimal.valueOf(10.00), 5, BigDecimal.valueOf(45.00));
        Item item2 = new Item("Item 2", BigDecimal.valueOf(15.00));
        cart.addItem(item1, 3); // 3 items at bulk price
        cart.addItem(item2, 2); // 2 items at normal price
        assertEquals(BigDecimal.valueOf(55.00), cart.calculateTotal());
    }

    @Test
    void testSortItemsByPrice() {
        Cart cart = new Cart();
        Item item1 = new Item("Item 1", BigDecimal.valueOf(15.00));
        Item item2 = new Item("Item 2", BigDecimal.valueOf(10.00));
        Item item3 = new Item("Item 3", BigDecimal.valueOf(20.00));
        cart.addItem(item1, 1);
        cart.addItem(item2, 1);
        cart.addItem(item3, 1);

        ArrayList<ItemOrder> itemOrders = new ArrayList<>(cart.getItems());
        Collections.sort(itemOrders);

        assertEquals(item2, itemOrders.get(0).getItem()); // Item 2 should be first
        assertEquals(item1, itemOrders.get(1).getItem()); // Item 1 should be second
        assertEquals(item3, itemOrders.get(2).getItem()); // Item 3 should be last
    }
}

