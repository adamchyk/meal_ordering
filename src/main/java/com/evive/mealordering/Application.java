package com.evive.mealordering;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter MENU: ");
        String menu = input.next();
        String s = input.nextLine();
        String[] ss = s.split(",");

        List<Integer> foodItems = new ArrayList<>();
        for (String value : ss) {
            foodItems.add(Integer.parseInt(value.trim()));
        }

        MealBuilder mealBuilder = new MealBuilder();
        System.out.println(mealBuilder.process(menu, foodItems));
    }

}
