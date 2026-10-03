package com.freshbox.exception;

public class OutOfStockException extends Exception {

    private final String mealKitName;
    private final int requestedQuantity;
    private final int availableQuantity;

    // LEARNER_TODO: Update this constructor to call super() with a formatted message like:
    // "Cannot order X units of KitName - only Y in stock"
    // The field assignments below are already correct — you just need to fix the super() call.
    public OutOfStockException(String mealKitName, int requestedQuantity, int availableQuantity) {
        super("Cannot order " + requestedQuantity + " units of " + mealKitName + " - only " + availableQuantity + " in stock");

        this.mealKitName = mealKitName;
        this.requestedQuantity = requestedQuantity;
        this.availableQuantity = availableQuantity;
    }

    public OutOfStockException(String message) {
        super(message);
        this.mealKitName = "";
        this.requestedQuantity = -1;
        this.availableQuantity = -1;
    }

    public String getMealKitName() {
        return mealKitName;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    // LEARNER_TODO: Implement getShortfall() to return how many units are missing.
    // This is the difference between requestedQuantity and availableQuantity.
    public int getShortfall() {
        return requestedQuantity - availableQuantity;
    }
}
