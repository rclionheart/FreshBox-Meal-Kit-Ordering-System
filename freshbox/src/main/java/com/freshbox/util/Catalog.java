package com.freshbox.util;

import com.freshbox.model.MealKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog<T extends MealKit> {

    // LEARNER_TODO: Declare a private Map<Integer, T> field named 'items'.
    // This map stores items by their integer ID.

    // LEARNER_TODO: Declare a private int field named 'nextId' for auto-incrementing IDs.

    // LEARNER_TODO: Implement the constructor to initialize 'items' as a new HashMap
    // and 'nextId' to 0.
    public Catalog() {
    }

    // LEARNER_TODO: Implement add(T item) to assign an auto-incrementing ID and store the item.
    // Use pre-increment (++nextId) to generate a new ID, set it on the item, and store the item in the map.
    public void add(T item) {
    }

    // LEARNER_TODO: Implement get(int id) to retrieve an item by its ID from the map.
    // Return null if the ID is not found.
    public T get(int id) {
        return null;
    }

    // LEARNER_TODO: Implement getAll() to return all items as a new ArrayList.
    // Hint: Consider how to convert a Map's values() into a List.
    public List<T> getAll() {
        return new ArrayList<>();
    }

    // LEARNER_TODO: Implement size() to return the number of items in the catalog.
    public int size() {
        return 0;
    }

    // LEARNER_TODO: Implement contains(int id) to check if the map contains the given ID.
    public boolean contains(int id) {
        return false;
    }

    // LEARNER_TODO: Implement isEmpty() to check if the catalog has no items.
    public boolean isEmpty() {
        return true;
    }
}
