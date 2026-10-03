package com.freshbox.model;

import java.util.List;

public class FamilyKit extends MealKit {

    public FamilyKit(String name, String description, Recipe recipe,
                     List<Ingredient> ingredients, double basePrice,
                     int stockQuantity, int servings) {
        super(name, description, recipe, ingredients, basePrice, stockQuantity, servings);
    }

    // LEARNER_TODO: Override calculatePrice() to return the base price.
    // Family kits use the base price with no markup.
    // Hint: Use getBasePrice() inherited from MealKit.
    public double calculatePrice() {
        return getBasePrice();
    }

    // LEARNER_TODO: Override getDefaultServings() to return 4.
    // Family kits serve 4 people by default.
    public int getDefaultServings() {
        return 4;
    }

    // LEARNER_TODO: Override toDisplayString() to extend the parent's display string
    // with " | Great for families!" appended at the end.
    // Hint: You can call a parent class's version of a method using the super keyword.
    public String toDisplayString() {
        return super.toDisplayString() + " | Great for families!";
    }
}
