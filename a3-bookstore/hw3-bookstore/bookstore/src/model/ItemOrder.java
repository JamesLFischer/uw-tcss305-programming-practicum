/*
 * TCSS 305 - Fall 2024
 * ItemOrder.java
 * Assignment 3
 * Instructor; Tom Capaul
 */

// Represents an order of a specific item and quantity
package model;

import java.util.Objects;

public final class ItemOrder implements Comparable<ItemOrder> {

    /** The item being ordered. */
    private final Item myItem;

    /** The quantity of the item being ordered. */
    private final int myQuantity;

    /**
     * Constructs an item order with the specified item and quantity.
     * 
     * @param theItem the item being ordered
     * @param theQuantity the quantity being ordered
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        Objects.requireNonNull(theItem, "Item cannot be null.");
        if (theQuantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        myItem = theItem;
        myQuantity = theQuantity;
    }

    /** @return the item being ordered. */
    public Item getItem() {
        return myItem;
    }

    /** @return the quantity of the item being ordered. */
    public int getQuantity() {
        return myQuantity;
    }

    @Override
    public String toString() {
        return "ItemOrder[item=" + myItem + ", quantity=" + myQuantity + "]";
    }

    @Override
    public int compareTo(final ItemOrder theOther) {
        Objects.requireNonNull(theOther, "ItemOrder to compare cannot be null.");
        return Integer.compare(this.myQuantity, theOther.myQuantity); // Compare by quantity
    }
}

