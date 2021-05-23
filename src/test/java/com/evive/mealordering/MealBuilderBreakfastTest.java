package com.evive.mealordering;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MealBuilderBreakfastTest {

    private static final MealBuilder meal = new MealBuilder();

    @Test
    void testValidBreakfast() {
        String result = meal.process("Breakfast", List.of(1, 2, 3));
        assertEquals("Eggs, Toast, Coffee", result);
    }

    @Test
    void testValidBreakfastWith2Toasts() {
        String result = meal.process("Breakfast", List.of(1, 2, 2, 3));
        assertEquals("Unable to process: Toast is already ordered", result);
    }

    @Test
    void testValidBreakfastWith3Coffees() {
        String result = meal.process("Breakfast", List.of(1, 2, 3, 3, 3));
        assertEquals("Eggs, Toast, Coffee(3)", result);
    }

    @Test
    void testMainSideMissingBreakfast() {
        String result = meal.process("Breakfast", List.of(3));
        assertEquals("Unable to process: main is missing, side is missing", result);
    }

    @Test
    void testMainMissingBreakfast() {
        String result = meal.process("Breakfast", List.of(2, 3));
        assertEquals("Unable to process: main is missing", result);
    }

    @Test
    void testSideMissingBreakfast() {
        String result = meal.process("Breakfast", List.of(1, 3));
        assertEquals("Unable to process: side is missing", result);
    }

    @Test
    void testCoffeeMissingBreakfast() {
        String result = meal.process("Breakfast", List.of(1, 2));
        assertEquals("Eggs, Toast, Water", result);
    }

}