package com.freshbox.service;

import com.freshbox.exception.InvalidOrderException;
import com.freshbox.exception.OutOfStockException;
import com.freshbox.model.Customer;
import com.freshbox.model.MealKit;
import com.freshbox.model.Order;
import com.freshbox.model.OrderItem;
import com.freshbox.model.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private static final int MIN_LEAD_TIME_DAYS = 2;

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("MMM d, yyyy");

    private Map<Integer, Order> orders = new HashMap<>();

    private int nextId = 0;

    // LEARNER_TODO: Implement createOrder to validate the delivery date and create a new order.
    //
    // Steps:
    //   1. Validate that the delivery date is far enough in the future.
    //      Use the MIN_LEAD_TIME_DAYS constant to determine the earliest allowed date.
    //   2. If the date is too soon, throw InvalidOrderException with a message that
    //      tells the user the earliest available date.
    //   3. Create a new Order, assign an ID (++nextId), store it in the map, and return it.
    public Order createOrder(Customer customer, LocalDate deliveryDate)
            throws InvalidOrderException {

        Order order = new Order(customer, deliveryDate);

        // todo - add logic here

        return order;
    }

    public Order getOrder(int id) throws InvalidOrderException {
        Order order = orders.get(id);

        if (order == null) {
            throw new InvalidOrderException("Order with ID " + id + " not found");
        }

        return order;
    }

    // LEARNER_TODO: Implement getOrdersForCustomer to return all orders belonging to
    // a specific customer. Loop through all orders and compare customer IDs.
    // Hint: Each Order knows which Customer it belongs to.
    public List<Order> getOrdersForCustomer(Customer customer) {
        return new ArrayList<>();
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    public int size() {
        return orders.size();
    }

    public void registerOrder(Order order) {
        int id = ++nextId;
        order.setId(id);
        orders.put(id, order);
    }

    public String formatDate(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    public int getMinLeadTimeDays() {
        return MIN_LEAD_TIME_DAYS;
    }

    // LEARNER_TODO: Implement addItemToOrder to validate stock availability before adding.
    // If the requested quantity exceeds available stock, throw an OutOfStockException.
    // Otherwise, add the item to the order.
    //
    // Hint: MealKit has methods to check stock quantity.
    // NOTE: This stub adds items without checking stock. Your task is to ADD the stock check.
    public void addItemToOrder(Order order, MealKit mealKit, int quantity)
            throws OutOfStockException {

        order.addItem(mealKit, quantity);
    }

    // LEARNER_TODO: Implement submitOrder to reduce stock for each item in the order.
    // Loop through the order's items and reduce stock for each meal kit by its quantity.
    // This method propagates OutOfStockException if any kit doesn't have enough stock.
    public void submitOrder(Order order) throws OutOfStockException {
    }

    public void cancelOrder(Order order) {
        order.setStatus(OrderStatus.CANCELLED);
    }
}
