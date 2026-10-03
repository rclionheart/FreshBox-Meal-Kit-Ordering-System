package com.freshbox.model;

public class Recipe {

    private final String title;
    private final String instructions;
    private final int prepTimeMinutes;
    private final int cookTimeMinutes;
    private final String difficulty;

    public Recipe(String title, String instructions, int prepTimeMinutes,
                  int cookTimeMinutes, String difficulty) {
        this.title = title;
        this.instructions = instructions;
        this.prepTimeMinutes = prepTimeMinutes;
        this.cookTimeMinutes = cookTimeMinutes;
        this.difficulty = difficulty;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getPrepTimeMinutes() {
        return prepTimeMinutes;
    }

    public int getCookTimeMinutes() {
        return cookTimeMinutes;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getTotalTimeMinutes() {
        return prepTimeMinutes + cookTimeMinutes;
    }
}
