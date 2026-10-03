package com.freshbox.model;

// ============================================================================
// REFERENCE EXAMPLE: VegetarianKit
// ============================================================================
// This file is FULLY IMPLEMENTED as a reference for you to study.
// Use it as a pattern when implementing FamilyKit and PremiumKit.
//
// Key concepts demonstrated:
//   - Extending an abstract class (MealKit)
//   - Calling the superclass constructor with super()
//   - Overriding abstract methods (calculatePrice, getDefaultServings)
// ============================================================================

import java.util.List;

public class VegetarianKit extends MealKit {

    public VegetarianKit(String name, String description, Recipe recipe,
                         List<Ingredient> ingredients, double basePrice,
                         int stockQuantity, int servings) {
        super(name, description, recipe, ingredients, basePrice, stockQuantity, servings);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice();
    }

    @Override
    public int getDefaultServings() {
        return 2;
    }
}
