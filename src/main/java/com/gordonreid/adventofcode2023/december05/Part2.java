package com.gordonreid.adventofcode2023.december05;

import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Part2 {

    static long run(List<String> input) {
        List<Range<Long>> seeds = getSeeds(input.getFirst());
        List<Set<MappedRange>> ranges = MappedRange.getRanges(input);
        long lowestLocationToThousands = getLowestLocation(seeds, ranges, 0, 1000) - 1000;
        return getLowestLocation(seeds, ranges, lowestLocationToThousands, 1);
    }

    private static long getLowestLocation(List<Range<Long>> seeds, List<Set<MappedRange>> originalRanges, long start, int stepping) {
        List<Set<MappedRange>> ranges = originalRanges.reversed();
        long maxLocation = 0;
        for (MappedRange mappedRange : ranges.getFirst()) {
            maxLocation = Math.max(maxLocation, mappedRange.destinationRange().upperEndpoint());
        }
        for (long location = start; location <= maxLocation; location += stepping) {
            long seed = location;
            for (Set<MappedRange> mappedRangeSet : ranges) {
                for (MappedRange mappedRange : mappedRangeSet) {
                    if (mappedRange.destinationRange().contains(seed)) {
                        seed += mappedRange.sourceRange().lowerEndpoint() - mappedRange.destinationRange().lowerEndpoint();
                        break;
                    }
                }
            }
            for (Range<Long> seedRange : seeds) {
                if (seedRange.contains(seed)) {
                    return location;
                }
            }
        }
        return 0;
    }

    private static List<Range<Long>> getSeeds(String line) {
        List<Long> seedPairs = Arrays.stream(line.replaceAll("[a-zA-Z:]", "")
                        .split(" "))
                .filter(value -> !value.isBlank())
                .map(Long::parseLong)
                .toList();
        List<Range<Long>> seeds = new ArrayList<>();
        for (int i = 0; i < seedPairs.size(); i += 2) {
            long startRange = seedPairs.get(i);
            long rangeLength = seedPairs.get(i + 1);
            seeds.add(Range.closedOpen(startRange, startRange + rangeLength));
        }
        return seeds;
    }
}
