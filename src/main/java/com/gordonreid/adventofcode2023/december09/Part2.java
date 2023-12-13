package com.gordonreid.adventofcode2023.december09;

import java.util.List;

public class Part2 {

    static long run(List<String> input) {
        return input.stream()
                .mapToLong(Part2::nextValueInHistory)
                .sum();
    }

    private static long nextValueInHistory(String line) {
        List<List<Long>> sequencies = Common.getSequencies(line);
        long nextValue = 0;
        for (int i = sequencies.size() - 1; i >= 0; i--) {
            if (i != sequencies.size() - 1) {
                nextValue = sequencies.get(i).getFirst() - nextValue;
            }
            sequencies.get(i).addFirst(nextValue);
        }
        return nextValue;
    }

}
