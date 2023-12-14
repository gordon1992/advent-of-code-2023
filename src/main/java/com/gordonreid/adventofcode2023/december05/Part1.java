package com.gordonreid.adventofcode2023.december05;

import java.util.*;

public class Part1 {

    static long run(List<String> input) {
        List<Long> seeds = getSeeds(input.getFirst());
        List<Set<MappedRange>> ranges = MappedRange.getRanges(input);
        return getLowestLocation(seeds, ranges);
    }

    private static long getLowestLocation(List<Long> seeds, List<Set<MappedRange>> ranges) {
        long result = Long.MAX_VALUE;
        for (Long seed : seeds) {
            long location = seed;
            for (Set<MappedRange> mappedRangeSet : ranges) {
                for (MappedRange mappedRange : mappedRangeSet) {
                    if (mappedRange.sourceRange().contains(location)) {
                        location += mappedRange.destinationRange().getLower() - mappedRange.sourceRange().getLower();
                        break;
                    }
                }
            }
            result = Math.min(result, location);
        }
        return result;
    }

    private static List<Long> getSeeds(String line) {
        return Arrays.stream(line.replaceAll("[a-zA-Z:]", "")
                        .split(" "))
                .filter(value -> !value.isBlank())
                .map(Long::parseLong)
                .toList();
    }
}
