package com.gordonreid.adventofcode2023.december06;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Part1 {

    static long run(List<String> input) {
        return getTimesToDistances(input)
                .entrySet().stream()
                .map(Part1::numberOfWaysToWin)
                .reduce(1L, (a, b) -> a * b);
    }

    private static long numberOfWaysToWin(Map.Entry<Long, Long> race) {
        long time = race.getKey();
        long distance = race.getValue();
        return Common.numberOfWaysToWin(time, distance);
    }

    private static Map<Long, Long> getTimesToDistances(List<String> input) {
        List<Long> times = Arrays.stream(input.getFirst().replaceAll("[^\\d ]", "")
                        .split("\\s+"))
                .filter(s -> !s.isBlank())
                .map(Long::parseLong)
                .toList();
        List<Long> distances = Arrays.stream(input.getLast().replaceAll("[^\\d ]", "")
                        .split("\\s+"))
                .filter(s -> !s.isBlank())
                .map(Long::parseLong)
                .toList();
        return IntStream.range(0, times.size())
                .boxed()
                .collect(Collectors.toMap(times::get, distances::get));
    }
}
