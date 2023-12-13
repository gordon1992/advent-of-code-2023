package com.gordonreid.adventofcode2023.december10;

import com.gordonreid.adventofcode2023.helpers.FileHelpers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class December10Test {

    private static List<String> EXAMPLE_INPUT_PART_1_1;
    private static List<String> EXAMPLE_INPUT_PART_1_2;
    private static List<String> EXAMPLE_INPUT_PART_2_1;
    private static List<String> EXAMPLE_INPUT_PART_2_2;
    private static List<String> EXAMPLE_INPUT_PART_2_3;
    private static List<String> ACTUAL_INPUT;

    @BeforeAll
    public static void setup() throws Exception {
        EXAMPLE_INPUT_PART_1_1 = FileHelpers.getResourceLines("day-10-test-input-part-1-1");
        EXAMPLE_INPUT_PART_1_2 = FileHelpers.getResourceLines("day-10-test-input-part-1-2");
        EXAMPLE_INPUT_PART_2_1 = FileHelpers.getResourceLines("day-10-test-input-part-2-1");
        EXAMPLE_INPUT_PART_2_2 = FileHelpers.getResourceLines("day-10-test-input-part-2-2");
        EXAMPLE_INPUT_PART_2_3 = FileHelpers.getResourceLines("day-10-test-input-part-2-3");
        ACTUAL_INPUT = FileHelpers.getResourceLines("day-10-input");
    }

    @Test
    public void part1_given_example1() {
        long expectedResult = 4;

        long actualResult = Part1.run(EXAMPLE_INPUT_PART_1_1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part1_given_example2() {
        long expectedResult = 8;

        long actualResult = Part1.run(EXAMPLE_INPUT_PART_1_2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part1_actual() {
        long expectedResult = 6690;

        long actualResult = Part1.run(ACTUAL_INPUT);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part2_given_example1() {
        long expectedResult = 4;

        long actualResult = Part2.run(EXAMPLE_INPUT_PART_2_1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part2_given_example2() {
        long expectedResult = 4;

        long actualResult = Part2.run(EXAMPLE_INPUT_PART_2_2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part2_given_example3() {
        long expectedResult = 8;

        long actualResult = Part2.run(EXAMPLE_INPUT_PART_2_3);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void part2_actual() {
        long expectedResult = 525;

        long actualResult = Part2.run(ACTUAL_INPUT);

        assertEquals(expectedResult, actualResult);
    }
}