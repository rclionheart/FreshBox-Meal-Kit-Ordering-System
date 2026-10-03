package com.freshbox.model;

import java.util.List;

public class PremiumKit extends MealKit {

    // LEARNER_TODO: Declare a private static final double constant called PREMIUM_MULTIPLIER
    // and set it to 1.5. This will be used to calculate the premium price.

    public PremiumKit(String name, String description, Recipe recipe,
                      List<Ingredient> ingredients, double basePrice,
                      int stockQuantity, int servings) {
        super(name, description, recipe, ingredients, basePrice, stockQuantity, servings);
    }

    // LEARNER_TODO: Override calculatePrice() to return the base price multiplied
    // by PREMIUM_MULTIPLIER. Premium kits cost 1.5x the base price.
    public double calculatePrice() {
        return 0.0;
    }

    // LEARNER_TODO: Override getDefaultServings() to return 2.
    // Premium kits serve 2 people by default.
    public int getDefaultServings() {
        return 0;
    }
}
