package com.freshbox.model;

import com.freshbox.exception.OutOfStockException;
import java.util.ArrayList;
import java.util.List;

public abstract class MealKit implements Displayable, Comparable<MealKit> {

    private int id;
    private String name;
    private String description;
    private Recipe recipe;
    private List<Ingredient> ingredients;
    private double basePrice;
    private int stockQuantity;
    private int servings;

    public MealKit(String name, String description, Recipe recipe,
                   List<Ingredient> ingredients, double basePrice,
                   int stockQuantity, int servings) {
        this.name = name;
        this.description = description;
        this.recipe = recipe;
        this.ingredients = new ArrayList<>(ingredients);
        this.basePrice = basePrice;
        this.stockQuantity = stockQuantity;
        this.servings = servings;
    }

    public abstract double calculatePrice();

    public abstract int getDefaultServings();

    // LEARNER_TODO: Implement isInStock() to return true if stockQuantity is greater than 0.
    public boolean isInStock() {
        if (stockQuantity > 0) {
            return true;
        }
        return false;
    }

    // LEARNER_TODO: Implement reduceStock(int quantity) to subtract from stockQuantity.
    // If quantity exceeds stockQuantity, throw an OutOfStockException with the name,
    // requested quantity, and available stock. Otherwise, reduce stockQuantity by the amount.
    public void reduceStock(int quantity) throws OutOfStockException{
        //todo
        if (quantity > stockQuantity) {
            throw new OutOfStockException("Cannot reduce stock of " + quantity + " units if only " + stockQuantity + " units in stock");
        } else {
            stockQuantity -= quantity;
        }
    }

    // LEARNER_TODO: Implement compareTo() to compare meal kits by their calculated price.
    // Hint: The Double class has a static method for comparing double values.
    @Override
    public int compareTo(MealKit other) {
        return Double.compare(this.calculatePrice(), other.calculatePrice());
    }

    // LEARNER_TODO: Implement toDisplayString() to return a formatted string like:
    // "Kit Name - $XX.XX (In Stock)" or "Kit Name - $XX.XX (Out of Stock)"
    // Use a ternary operator to choose between "In Stock" and "Out of Stock" based on isInStock().
    // Hint: String.format() can format decimal numbers to a fixed number of places.
    @Override
    public String toDisplayString() {
        if (isInStock()) {
            return String.format("Kit Name - $%.2f (In Stock)", calculatePrice());
        } else {
            return String.format("Kit Name - $%.2f (Out of Stock)", calculatePrice());
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public int getServings() {
        return servings;
    }

    public void setId(int id) {
        this.id = id;
    }
}
