package com.evive.mealordering.model;

import java.util.List;
import java.util.Map;

public class Breakfast extends Meal {

    private static final Map<Integer, String> foodNames = Map.of(
            1, "Eggs",
            2, "Toast",
            3, "Coffee"
    );

    private Integer numberOfCoffees = 0;
    private boolean isSideAdded = false;

    public Breakfast(List<Integer> foodItems) {
        super(foodItems);
    }

    @Override
    public String getFoodName(Integer foodId) {
        return foodNames.get(foodId);
    }

    @Override
    public void addDrink(String drinkItem) {
        // can be: "coffee"
        numberOfCoffees++;
    }

    @Override
    public String getDrinks() {
        if (numberOfCoffees == 0) {
            return "Water";
        } else if (numberOfCoffees == 1) {
            return "Coffee";
        }
        return "Coffee(" + numberOfCoffees + ")";
    }

    @Override
    public void addSide(String foodItem) {
        if (isSideAdded) {
            throw new RuntimeException(foodItem + " is already ordered");
        }
        isSideAdded = true;
    }

    @Override
    public String getSides() {
        if (!isSideAdded) {
            throw new RuntimeException("side is missing");
        }
        return "Toast";
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
