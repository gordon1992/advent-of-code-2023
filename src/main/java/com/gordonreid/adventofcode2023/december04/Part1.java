package com.gordonreid.adventofcode2023.december04;

import java.util.List;

public class Part1 {

    static long run(List<String> input) {
        return input.stream()
                .map(Common::getWinningNumberCount)
                .mapToLong(Part1::getPointsFromCard)
                .sum();
    }

    private static Long getPointsFromCard(long count) {
        return count > 0 ? 1L << count - 1 : 0L;
    }
}
