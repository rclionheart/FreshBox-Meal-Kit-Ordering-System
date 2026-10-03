package com.freshbox.service;

import com.freshbox.exception.MealKitNotFoundException;
import com.freshbox.model.MealKit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogService {

    private Map<Integer, MealKit> mealKits = new HashMap<>();

    private int nextId = 0;

    public void addMealKit(MealKit mealKit) {
        int id = ++nextId;
        mealKit.setId(id);
        mealKits.put(id, mealKit);
    }

    public MealKit getMealKit(int id) throws MealKitNotFoundException {
        MealKit mealKit = mealKits.get(id);

        if (mealKit == null) {
            throw new MealKitNotFoundException(id);
        }

        return mealKit;
    }

    public List<MealKit> getAllMealKits() {
        return new ArrayList<>(mealKits.values());
    }

    public int size() {
        return mealKits.size();
    }

    // LEARNER_TODO: Implement search(String query) to find meal kits whose name contains
    // the query string (case-insensitive). Return a list of matching meal kits.
    //
    // Hints:
    //   - Convert both the query and kit name to lowercase for case-insensitive comparison
    //   - Use String's contains() method to check for partial matches
    //   - Use getAllMealKits() to get the list to search through
    //   - Use a loop with 'continue' to skip kits that don't match, then add matching kits to the result list
    public List<MealKit> search(String query) {
        return new ArrayList<>();
    }

    // LEARNER_TODO: Implement search(String query, boolean inStockOnly) — an overloaded
    // version of search that also filters by stock availability.
    //
    // This demonstrates method overloading: same method name, different parameters.
    // When inStockOnly is true, only include kits where isInStock() returns true.
    // Use 'continue' to skip non-matching items (guard clause pattern).
    public List<MealKit> search(String query, boolean inStockOnly) {
        return new ArrayList<>();
    }

    public void displayCatalog() {
        IO.println("=== Meal Kit Catalog ===");

        List<MealKit> allKits = getAllMealKits();
        int counter = 1;

        for (MealKit kit : allKits) {
            IO.println(counter + ". " + kit.toDisplayString());
            counter++;
        }

        IO.println();
    }

    // LEARNER_TODO: Implement getInStockKits() to return only meal kits where isInStock() is true.
    // Loop through getAllMealKits() and use 'continue' to skip out-of-stock kits, adding only in-stock kits to the result list.
    public List<MealKit> getInStockKits() {
        return new ArrayList<>();
    }
}
