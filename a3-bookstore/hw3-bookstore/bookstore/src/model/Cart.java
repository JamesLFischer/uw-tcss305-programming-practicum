/*
 * TCSS 305 - Fall 2024
 * Cart.java
 * Assignment 3
 * Instructor; Tom Capaul
 */

// Represents a shopping cart that holds ItemOrder objects and calculates total costs
package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {

    /** The list of item orders in the cart. */
    private final List<ItemOrder> myOrders;
    
    /** The membership status for the customer. */
    private boolean myMembership;

    /** Constructs an empty cart. */
    public Cart() {
        myOrders = new ArrayList<>();
        myMembership = false;
    }
    
    /**
     * Adds an order to the cart. If the order already exists, it replaces the existing order.
     * 
     * @param theOrder the item order to add
     */
    public void add(final ItemOrder theOrder) {
        Objects.requireNonNull(theOrder, "Order cannot be null.");
        for (int i = 0; i < myOrders.size(); i++) {
            if (myOrders.get(i).getItem().equals(theOrder.getItem())) {
                myOrders.set(i, theOrder); // Replace the existing order
                return;
            }
        }
        myOrders.add(theOrder); // Add a new order if it doesn't exist
    }
    
    /**
     * Sets the membership status for the customer.
     * 
     * @param theMembership true for members, false for non-members
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

    /**
     * Calculates the total cost of the cart with respect to membership discounts.
     * 
     * @return the total cost of all items in the cart
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (final ItemOrder order : myOrders) {
            final Item item = order.getItem();
            BigDecimal itemTotal;
            
            if (item.isBulk() && order.getQuantity() >= item.getBulkQuantity()) {
                int bulkCount = order.getQuantity() / item.getBulkQuantity();
                int remainder = order.getQuantity() % item.getBulkQuantity();
                itemTotal = item.getBulkPrice().multiply(BigDecimal.valueOf(bulkCount))
                            .add(item.getPrice().multiply(BigDecimal.valueOf(remainder)));
            } else {
                itemTotal = item.getPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
            }
            
            total = total.add(itemTotal);
        }
        
        // Apply membership discount if applicable
        if (myMembership) {
            total = total.multiply(BigDecimal.valueOf(0.9)); // 10% discount for members
        }
        
        return total;
    }
    
    /** Clears all the orders from the cart. */
    public void clear() {
        myOrders.clear();
    }

    /** 
     * Returns the size of the cart, i.e., the number of distinct item orders.
     * 
     * @return the number of item orders in the cart
     */
    public int getCartSize() {
        return myOrders.size();
    }

    @Override
    public String toString() {
        return "Cart[orders=" + myOrders + ", membership=" + myMembership + "]";
    }
}
