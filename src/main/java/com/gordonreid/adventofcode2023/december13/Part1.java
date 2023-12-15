package com.gordonreid.adventofcode2023.december13;

import java.util.List;

public class Part1 {

    static long run(List<String> input) {
        List<List<String>> patterns = Common.getPatterns(input);
        return patterns.stream()
                .mapToLong(p -> Common.reflection(p, false))
                .sum();
    }
}