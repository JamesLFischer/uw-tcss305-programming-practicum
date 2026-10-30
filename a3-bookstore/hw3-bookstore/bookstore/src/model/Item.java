/*
 * TCSS 305 - Fall 2024
 * Item.java
 * Assignment 3
 * Instructor; Tom Capaul
 */

// Represents an item for sale with bulk pricing option
package model;

import java.math.BigDecimal;
import java.util.Objects;

public final class Item implements Comparable<Item> {

    /** The name of the item. */
    private final String myName;

    /** The price of the item. */
    private final BigDecimal myPrice;

    /** The quantity for bulk discount. */
    private final int myBulkQuantity;

    /** The price for bulk quantity. */
    private final BigDecimal myBulkPrice;

    /**
     * Constructs an item with no bulk pricing.
     * 
     * @param theName the name of the item
     * @param thePrice the price of the item
     */
    public Item(final String theName, final BigDecimal thePrice) {
        this(theName, thePrice, 0, BigDecimal.ZERO); // No bulk option
    }

    /**
     * Constructs an item with bulk pricing.
     * 
     * @param theName the name of the item
     * @param thePrice the price of the item
     * @param theBulkQuantity the bulk quantity for discount
     * @param theBulkPrice the bulk price
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity, final BigDecimal theBulkPrice) {
        Objects.requireNonNull(theName, "Item name cannot be null.");
        Objects.requireNonNull(thePrice, "Item price cannot be null.");
        
        if (thePrice.compareTo(BigDecimal.ZERO) < 0 || theBulkPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;
    }

    /** @return the price of the item. */
    public BigDecimal getPrice() {
        return myPrice;
    }

    /** @return the bulk quantity for discount. */
    public int getBulkQuantity() {
        return myBulkQuantity;
    }

    /** @return the bulk price for the item. */
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }

    /** @return whether the item has bulk pricing. */
    public boolean isBulk() {
        return myBulkQuantity > 0;
    }

    @Override
    public String toString() {
        return "Item[name=" + myName + ", price=" + myPrice + ", bulkQuantity=" + myBulkQuantity
                + ", bulkPrice=" + myBulkPrice + "]";
    }

    @Override
    public boolean equals(final Object theOther) {
        if (this == theOther) {
            return true;
        }
        if (!(theOther instanceof Item)) {
            return false;
        }
        final Item other = (Item) theOther;
        return myName.equals(other.myName) && myPrice.equals(other.myPrice)
                && myBulkQuantity == other.myBulkQuantity && myBulkPrice.equals(other.myBulkPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
    }

    @Override
    public int compareTo(final Item theOther) {
        Objects.requireNonNull(theOther, "Item to compare cannot be null.");
        return this.myPrice.compareTo(theOther.myPrice); // Compare by price
    }
}


