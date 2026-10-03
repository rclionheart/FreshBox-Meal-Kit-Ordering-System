package com.freshbox.exception;

public class MealKitNotFoundException extends Exception {

    // LEARNER_TODO: Update this constructor to create a formatted message that includes
    // the ID, like: "Meal kit with ID 5 not found"
    // Then pass that message to super().
    public MealKitNotFoundException(int id) {
        super("Meal kit with ID " + id + " not found");
    }
}
