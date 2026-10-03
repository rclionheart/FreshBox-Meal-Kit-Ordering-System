package com.freshbox.model;

public class OrderItem implements Displayable {

    private MealKit mealKit;
    private int quantity;

    // LEARNER_TODO: Implement this constructor with validation.
    // It should:
    //   1. Throw IllegalArgumentException if mealKit is null
    //   2. Throw IllegalArgumentException if quantity is less than or equal to 0
    //   3. Assign both fields
    public OrderItem(MealKit mealKit, int quantity) {
        this.mealKit = mealKit;
        this.quantity = quantity;
    }

    // LEARNER_TODO: Implement getLineTotal() to return the total cost for this line item.
    // Multiply the meal kit's calculated price by the quantity.
    public double getLineTotal() {
        return 0.0;
    }

    public MealKit getMealKit() {
        return mealKit;
    }

    public int getQuantity() {
        return quantity;
    }

    // LEARNER_TODO: Implement toDisplayString() to return a formatted string like:
    // "Kit Name x2 - $45.98"
    // Hint: Use String.format() to format the dollar amount to two decimal places.
    @Override
    public String toDisplayString() {
        return "";
    }
}
