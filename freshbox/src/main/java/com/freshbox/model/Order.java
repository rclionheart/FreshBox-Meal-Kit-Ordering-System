package com.freshbox.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order implements Displayable {

    private int id;
    private Customer customer;
    private List<OrderItem> items;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private OrderStatus status;

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy");

    public Order(Customer customer, LocalDate deliveryDate) {
        this.items = new ArrayList<>();
        this.orderDate = LocalDate.now();
        this.status = OrderStatus.ACTIVE;
        this.customer = customer;
        this.deliveryDate = deliveryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    // LEARNER_TODO: Implement this convenience overload of addItem.
    // Create a new OrderItem from the kit and quantity, then call the other addItem method.
    // Hint: This method should delegate to addItem(OrderItem).
    public void addItem(MealKit kit, int quantity) {
    }

    // LEARNER_TODO: Implement calculateTotal() to sum all order item line totals.
    // Loop through the items list and add up each item's getLineTotal().
    public double calculateTotal() {
        return 0.0;
    }

    // LEARNER_TODO: Implement toDisplayString() to return a summary like:
    // "Order #1: 3 items, $45.99, Status: ACTIVE"
    // Hint: Use String.format() to format the dollar amount to two decimal places.
    @Override
    public String toDisplayString() {
        return "Order #" + id;
    }

    // LEARNER_TODO: Implement toSummary() using StringBuilder to build a detailed order summary.
    // The summary should include:
    //   - Order ID, customer name, delivery date (formatted with DATE_FORMATTER)
    //   - A numbered list of each item's toDisplayString()
    //   - Total price and status
    // If items is empty, return "Order #ID: No items"
    //
    // Hint: Use StringBuilder to efficiently build strings with multiple append() calls.
    // Dates can be formatted using the format() method with a DateTimeFormatter.
    public String toSummary() {
        if (items.isEmpty()) {
            return "Order #" + id + ": No items";
        }
        return "Order #" + id;
    }
}
