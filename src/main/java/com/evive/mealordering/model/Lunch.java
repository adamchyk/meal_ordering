package com.evive.mealordering.model;

import java.util.List;
import java.util.Map;

public class Lunch extends Meal {

    private static final Map<Integer, String> foodNames = Map.of(
            1, "Salad",
            2, "Chips",
            3, "Soda"
    );

    private boolean isDrinkAdded = false;
    private Integer sidesNumber = 0;

    public Lunch(List<Integer> foodItems) {
        super(foodItems);
    }

    @Override
    public String getFoodName(Integer foodId) {
        return foodNames.get(foodId);
    }

    @Override
    public void addDrink(String drinkItem) {
        // drinkItem can be: "soda"
        if (isDrinkAdded) {
            throw new RuntimeException("soda ordered twice");
        }
        isDrinkAdded = true;
    }

    @Override
    public String getDrinks() {
        if (!isDrinkAdded) {
            return "Water";
        }
        return "Soda";
    }

    @Override
    public void addSide(String foodItem) {
        sidesNumber++;
    }

    @Override
    public String getSides() {
        if (sidesNumber == 0) {
            throw new RuntimeException("side is missing");
        } else if (sidesNumber == 1) {
            return "Chips";
        }
        return "Chips (" + sidesNumber + ")";
    }

    @Override
    public void addDesert(String desertName) {
        // not supported
    }

    @Override
    public String getDeserts() {
        // not supported
        return "";
    }

}
