package com.gordonreid.adventofcode2023.december12;

import java.util.List;

public class Part2 {

    static long run(List<String> input) {
        return input.stream()
                .mapToLong(line -> Common.arrangements(line, 5))
                .sum();
    }
}
