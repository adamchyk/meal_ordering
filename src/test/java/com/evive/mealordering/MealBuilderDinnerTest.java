package com.evive.mealordering;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MealBuilderDinnerTest {

    private static final MealBuilder meal = new MealBuilder();

    @Test
    void testInvalidDinnerWithoutDessert() {
        String result = meal.process("Dinner", List.of(1, 2, 3));
        assertEquals("Unable to process: dessert is missing", result);
    }

    @Test
    void testInvalidDinnerWith2Potatoes() {
        String result = meal.process("Dinner", List.of(1, 2, 2, 3, 4));
        assertEquals("Unable to process: potatoes can't ordered twice", result);
    }

    @Test
    void testValidDinnerWithoutDrink() {
        String result = meal.process("Dinner", List.of(1, 2, 4));
        assertEquals("Steak, Potatoes, Water, Cake", result);
    }

    @Test
    void testMainSideMissingDinner() {
        String result = meal.process("Dinner", List.of(3,4));
        assertEquals("Unable to process: main is missing, side is missing", result);
    }

    @Test
    void testMainMissingDinner() {
        String result = meal.process("Dinner", List.of(2, 3, 4));
        assertEquals("Unable to process: main is missing", result);
    }

    @Test
    void testSideMissingDinner() {
        String result = meal.process("Dinner", List.of(1, 3, 4));
        assertEquals("Unable to process: side is missing", result);
    }

    @Test
    void testValidDinner() {
        String result = meal.process("Dinner", List.of(1, 2, 3, 4));
        assertEquals("Steak, Potatoes, Water, Wine, Cake", result);
    }

}