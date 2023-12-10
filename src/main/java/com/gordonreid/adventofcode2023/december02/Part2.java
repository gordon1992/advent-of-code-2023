package com.gordonreid.adventofcode2023.december02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

final class Part2 {

    static long run(List<String> input) {
        return input.stream()
                .mapToLong(Part2::getSetPower)
                .sum();
    }

    private static long getSetPower(String line) {
        return getColourToMinimumCount(line)
                .values().stream()
                .mapToLong(count -> count)
                .reduce(1L, (a, b) -> a * b);
    }

    private static Map<String, Long> getColourToMinimumCount(String line) {
        Map<String, Long> colourToMinimumCount = new HashMap<>();
        Matcher cubeMatcher = Common.CUBE_PATTERN.matcher(line);
        while (cubeMatcher.find()) {
            long cubeCount = Long.parseLong(cubeMatcher.group(1));
            String cubeColour = cubeMatcher.group(2);
            long minimumCubeColour = Math.max(cubeCount, colourToMinimumCount.getOrDefault(cubeColour, 0L));
            colourToMinimumCount.put(cubeColour, minimumCubeColour);
        }
        return colourToMinimumCount;
    }
}
