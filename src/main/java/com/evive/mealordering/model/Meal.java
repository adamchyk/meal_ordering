package com.evive.mealordering.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Meal {

    private final List<Integer> foodIds;
    private String main;

    public Meal(List<Integer> foodItems) {
        foodIds = foodItems;
    }

    abstract public String getFoodName(Integer foodId);

    abstract public void addDesert(String foodItem);

    abstract public String getDeserts();

    abstract public void addDrink(String foodItem);

    abstract public String getDrinks();

    abstract public void addSide(String foodItem);

    abstract public String getSides();

    public void addMain(String foodItem) {
        if (main != null) {
            throw new RuntimeException(main + " cannot be ordered twice.");
        }
        main = foodItem;
    }

    public String getMain() {
        if (main == null) {
            throw new RuntimeException("main is missing");
        }
        return main;
    }

    public String printOrder() {
        try {
            process();
        } catch (Exception e) {
            return "Unable to process: " + e.getMessage();
        }

        StringBuilder sb = new StringBuilder();
        List<String> error = new ArrayList<>();
        boolean isSuccess = true;

        try {
            sb.append(getMain());
        } catch (Exception e) {
            isSuccess = false;
            error.add(e.getMessage());
        }

        try {
            String side = getSides();
            if (!side.isBlank()) {
                sb.append(", ").append(side);
            }
        } catch (Exception e) {
            isSuccess = false;
            error.add(e.getMessage());
        }

        try {
            String drink = getDrinks();
            if (!drink.isBlank()) {
                sb.append(", ").append(drink);
            }
        } catch (Exception e) {
            isSuccess = false;
            error.add(e.getMessage());
        }

        try {
            String desert = getDeserts();
            if (!desert.isBlank()) {
                sb.append(", ").append(desert);
            }
        } catch (Exception e) {
            isSuccess = false;
            error.add(e.getMessage());
        }

        if (!isSuccess) {
            return "Unable to process: " + String.join(", ", error);
        }

        return sb.toString();
    }

    private void process() {
        for (Integer itemId : foodIds) {
            switch (itemId) {
                case 1:
                    addMain(getFoodName(itemId));
                    break;
                case 2:
                    addSide(getFoodName(itemId));
                    break;
                case 3:
                    addDrink(getFoodName(itemId));
                    break;
                case 4:
                    addDesert(getFoodName(itemId));
                    break;
            }
        }
    }

}



