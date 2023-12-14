package com.gordonreid.adventofcode2023.december05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Part2 {

    static long run(List<String> input) {
        List<Range> seeds = getSeeds(input.getFirst());
        List<Set<MappedRange>> ranges = MappedRange.getRanges(input);
        long lowestLocation = 0;
        for (int stepping = 100_000; stepping > 0; stepping /= 10) {
            lowestLocation = getLowestLocation(seeds, ranges, lowestLocation, stepping) - stepping;
        }
        return lowestLocation + 1; // The last step, 1, was removed in the loop, so we add it back in.
    }

    private static long getLowestLocation(List<Range> seeds, List<Set<MappedRange>> originalRanges, long start, int stepping) {
        List<Set<MappedRange>> ranges = originalRanges.reversed();
        long maxLocation = 0;
        for (MappedRange mappedRange : ranges.getFirst()) {
            maxLocation = Math.max(maxLocation, mappedRange.destinationRange().getUpper());
        }
        for (long location = start; location <= maxLocation; location += stepping) {
            long seed = location;
            for (Set<MappedRange> mappedRangeSet : ranges) {
                for (MappedRange mappedRange : mappedRangeSet) {
                    if (mappedRange.destinationRange().contains(seed)) {
                        seed += mappedRange.sourceRange().getLower() - mappedRange.destinationRange().getLower();
                        break;
                    }
                }
            }
            for (Range seedRange : seeds) {
                if (seedRange.contains(seed)) {
                    return location;
                }
            }
        }
        return 0;
    }

    private static List<Range> getSeeds(String line) {
        List<Long> seedPairs = Arrays.stream(line.replaceAll("[a-zA-Z:]", "")
                        .split(" "))
                .filter(value -> !value.isBlank())
                .map(Long::parseLong)
                .toList();
        List<Range> seeds = new ArrayList<>();
        for (int i = 0; i < seedPairs.size(); i += 2) {
            long startRange = seedPairs.get(i);
            long rangeLength = seedPairs.get(i + 1);
            seeds.add(Range.closedOpen(startRange, startRange + rangeLength));
        }
        return seeds;
    }
}
