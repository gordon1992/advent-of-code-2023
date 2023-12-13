package com.gordonreid.adventofcode2023.december08;

import com.gordonreid.adventofcode2023.helpers.FileHelpers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class December08Test {

    private static List<String> EXAMPLE_INPUT_PART_1_1;
    private static List<String> EXAMPLE_INPUT_PART_1_2;
    private static List<String> EXAMPLE_INPUT_PART_2;
    private static List<String> ACTUAL_INPUT;

    @BeforeAll
    public static void setup() throws Exception {
        EXAMPLE_INPUT_PART_1_1 = FileHelpers.getResourceLines("day-8-test-input-part-1-1");
        EXAMPLE_INPUT_PART_1_2 = FileHelpers.getResourceLines("day-8-test-input-part-1-2");
        EXAMPLE_INPUT_PART_2 = FileHelpers.getResourceLines("day-8-test-input-part-2");
        ACTUAL_INPUT = FileHelpers.getResourceLines("day-8-input");
    }

    @Test
    public void part1_given_example1() {
        long expectedResult = 2;

        long actualResult = Part1.run(EXAMPLE_INPUT_PART_1_1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part1_given_example2() {
        long expectedResult = 6;

        long actualResult = Part1.run(EXAMPLE_INPUT_PART_1_2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part1_actual() {
        long expectedResult = 13301;

        long actualResult = Part1.run(ACTUAL_INPUT);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part2_given_example() {
        long expectedResult = 6;

        long actualResult = Part2.run(EXAMPLE_INPUT_PART_2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part2_actual() {
        long expectedResult = 7309459565207L;

        long actualResult = Part2.run(ACTUAL_INPUT);

        assertEquals(expectedResult, actualResult);
    }
}