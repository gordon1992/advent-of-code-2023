package com.gordonreid.adventofcode2023.december05;

import java.util.*;

record MappedRange(Range sourceRange, Range destinationRange) {

    private static MappedRange getRange(String line) {
        List<Long> values = Arrays.stream(line.split(" "))
                .map(Long::parseLong)
                .toList();
        return new MappedRange(
                Range.closedOpen(values.get(1), values.get(1) + values.get(2)),
                Range.closedOpen(values.get(0), values.get(0) + values.get(2))
        );
    }

    static List<Set<MappedRange>> getRanges(List<String> input) {
        List<Set<MappedRange>> ranges = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            String line = input.get(i);
            if (line.contains("map:")) {
                ranges.add(new HashSet<>());
            } else if (!line.isBlank()) {
                ranges.getLast().add(getRange(line));
            }
        }
        return ranges;
    }
}
