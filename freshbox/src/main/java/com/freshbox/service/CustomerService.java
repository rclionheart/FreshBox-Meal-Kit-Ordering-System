package com.freshbox.service;

// ============================================================================
// REFERENCE EXAMPLE: CustomerService
// ============================================================================
// This file is FULLY IMPLEMENTED as a reference for you to study.
// Use it as a pattern when implementing CatalogService and OrderService.
//
// Key concepts demonstrated:
//   - Using a Map<Integer, T> for storing entities by ID
//   - Auto-incrementing ID assignment
//   - Throwing custom exceptions when validation fails
//   - Iterating over map values to search/filter
//   - Returning defensive copies with new ArrayList<>(collection)
// ============================================================================

import com.freshbox.exception.InvalidCustomerException;
import com.freshbox.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {

    private Map<Integer, Customer> customers = new HashMap<>();

    private int nextId = 0;

    public void addCustomer(Customer customer) throws InvalidCustomerException {
        String email = customer.getEmail();
        if (email == null || email.isBlank()) {
            throw new InvalidCustomerException("Customer email cannot be empty");
        }

        int id = ++nextId;
        customer.setId(id);
        customers.put(id, customer);
    }

    public Customer getCustomer(int id) throws InvalidCustomerException {
        Customer customer = customers.get(id);

        if (customer == null) {
            throw new InvalidCustomerException("Customer with ID " + id + " not found");
        }

        return customer;
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer findByEmail(String email) {
        for (Customer customer : customers.values()) {
            if (customer.getEmail().equalsIgnoreCase(email)) {
                return customer;
            }
        }

        return null;
    }

    public int size() {
        return customers.size();
    }
}
