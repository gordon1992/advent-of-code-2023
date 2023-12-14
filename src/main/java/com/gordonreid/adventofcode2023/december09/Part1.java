package com.gordonreid.adventofcode2023.december09;

import java.util.List;

public class Part1 {

    static long run(List<String> input) {
        return input.stream()
                .mapToLong(Part1::nextValueInHistory)
                .sum();
    }

    private static long nextValueInHistory(String line) {
        List<List<Long>> sequences = Common.getSequences(line);
        long nextValue = 0;
        for (int i = sequences.size() - 1; i >= 0; i--) {
            if (i != sequences.size() - 1) {
                nextValue = sequences.get(i).getLast() + nextValue;
            }
            sequences.get(i).add(nextValue);
        }
        return nextValue;
    }

}
