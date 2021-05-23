package com.evive.mealordering;

import com.evive.mealordering.model.Breakfast;
import com.evive.mealordering.model.Dinner;
import com.evive.mealordering.model.Lunch;
import com.evive.mealordering.model.Meal;

import java.util.List;

public class MealBuilder {

    public String process(String menu, List<Integer> foodIds) {
        Meal meal;
        switch (menu) {
            case "Breakfast":
                meal = new Breakfast(foodIds);
                break;
            case "Lunch":
                meal = new Lunch(foodIds);
                break;
            case "Dinner":
                meal = new Dinner(foodIds);
                break;
            default:
                return "Invalid menu type";
        }
        return meal.printOrder();
    }

}
