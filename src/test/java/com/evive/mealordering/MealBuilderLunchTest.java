package com.evive.mealordering;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MealBuilderLunchTest {

    private static final MealBuilder meal = new MealBuilder();

    @Test
    void testValidLunch() {
        String result = meal.process("Lunch", List.of(1, 2, 3));
        assertEquals("Salad, Chips, Soda", result);
    }

    @Test
    void testValidLunchWithoutSoda() {
        String result = meal.process("Lunch", List.of(1, 2 ));
        assertEquals("Salad, Chips, Water", result);
    }

    @Test
    void testValidLunchWith2Chips() {
        String result = meal.process("Lunch", List.of(1, 2, 2, 3));
        assertEquals("Salad, Chips (2), Soda", result);
    }

    @Test
    void testInvalidMainSideMissingLunch() {
        String result = meal.process("Lunch", List.of(3));
        assertEquals("Unable to process: main is missing, side is missing", result);
    }

    @Test
    void testInvalidMainMissingLunch() {
        String result = meal.process("Lunch", List.of(2, 3));
        assertEquals("Unable to process: main is missing", result);
    }

    @Test
    void testSideMissingLunch() {
        String result = meal.process("Lunch", List.of(1, 3));
        assertEquals("Unable to process: side is missing", result);
    }

    @Test
    void testInvalidTwoMain() {
        String result = meal.process("Lunch", List.of(1, 1, 2, 3));
        assertEquals("Unable to process: Salad cannot be ordered twice.", result);
    }

    @Test
    void testinvalidDifferenceOrder() {
        String result = meal.process("Lunch", List.of(1, 2, 1, 3));
        assertEquals("Unable to process: Salad cannot be ordered twice.", result);
    }

    @Test
    void testValidDifferentOrder() {
        String result = meal.process("Lunch", List.of(3, 2, 1 ));
        assertEquals("Salad, Chips, Soda", result);
    }
}