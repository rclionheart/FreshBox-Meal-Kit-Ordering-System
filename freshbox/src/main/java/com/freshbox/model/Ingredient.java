package com.freshbox.model;

import java.util.HashSet;
import java.util.Set;

public class Ingredient {

    private final String name;
    private final String quantity;
    private final Set<String> allergens;

    public Ingredient(String name, String quantity, Set<String> allergens) {
        this.name = name;
        this.quantity = quantity;
        this.allergens = new HashSet<>(allergens);
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public Set<String> getAllergens() {
        return new HashSet<>(allergens);
    }

    public boolean hasAllergen(String allergen) {
        return allergens.contains(allergen);
    }
}
