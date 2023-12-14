package com.gordonreid.adventofcode2023.december09;

import java.util.List;

public class Part2 {

    static long run(List<String> input) {
        return input.stream()
                .mapToLong(Part2::nextValueInHistory)
                .sum();
    }

    private static long nextValueInHistory(String line) {
        List<List<Long>> sequences = Common.getSequences(line);
        long nextValue = 0;
        for (int i = sequences.size() - 1; i >= 0; i--) {
            if (i != sequences.size() - 1) {
                nextValue = sequences.get(i).getFirst() - nextValue;
            }
            sequences.get(i).addFirst(nextValue);
        }
        return nextValue;
    }

}
