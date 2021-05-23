package com.evive.mealordering.model;

import java.util.List;
import java.util.Map;

public class Dinner extends Meal {

    private static final Map<Integer, String> foodNames = Map.of(
            1, "Steak",
            2, "Potatoes",
            3, "Wine",
            4, "Cake"
    );

    private boolean isDrinkAdded = false;
    private boolean isSideAdded = false;
    private boolean isDesertAdded = false;

    public Dinner(List<Integer> foodItems) {
        super(foodItems);
    }

    @Override
    public String getFoodName(Integer foodId) {
        return foodNames.get(foodId);
    }

    @Override
    public void addSide(String foodItem) {
        if (isSideAdded) {
            throw new RuntimeException("potatoes can't ordered twice");
        }
        isSideAdded = true;
    }

    @Override
    public String getSides() {
        if (!isSideAdded) {
            throw new RuntimeException("side is missing");
        }
        return "Potatoes";
    }

    @Override
    public void addDrink(String drinkItem) {
        if (isDrinkAdded) {
            throw new RuntimeException("potatoes can't ordered twice");
        }
        isDrinkAdded = true;
    }

    @Override
    public String getDrinks() {
        if (!isDrinkAdded) {
            return "Water";
        }
        return "Water, Wine";
    }

    @Override
    public void addDesert(String desertName) {
        if (isDesertAdded) {
            throw new RuntimeException("You already added a desert.");
        }
        isDesertAdded = true;
    }

    @Override
    public String getDeserts() {
        if (!isDesertAdded) {
            throw new RuntimeException("dessert is missing");
        }
        return "Cake";
    }

}
