package com.gordonreid.adventofcode2023.december01;

import com.gordonreid.adventofcode2023.helpers.FileHelpers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class December01Test {

    private static List<String> EXAMPLE_INPUT_1;
    private static List<String> EXAMPLE_INPUT_2;
    private static List<String> ACTUAL_INPUT;

    @BeforeAll
    public static void setup() throws Exception {
        EXAMPLE_INPUT_1 = FileHelpers.getResourceLines("day-1-test-input-part-1");
        EXAMPLE_INPUT_2 = FileHelpers.getResourceLines("day-1-test-input-part-2");
        ACTUAL_INPUT = FileHelpers.getResourceLines("day-1-input");
    }

    @Test
    public void part1_given_example() {
        long expectedResult = 142;

        long actualResult = Part1.run(EXAMPLE_INPUT_1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part1_actual() {
        long expectedResult = 54634;

        long actualResult = Part1.run(ACTUAL_INPUT);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part2_given_example() {
        long expectedResult = 281;

        long actualResult = Part2.run(EXAMPLE_INPUT_2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part2_actual() {
        long expectedResult = 53855;

        long actualResult = Part2.run(ACTUAL_INPUT);

        assertEquals(expectedResult, actualResult);
    }
}