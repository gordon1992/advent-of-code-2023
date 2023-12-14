package com.gordonreid.adventofcode2023.december09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Common {
    static List<List<Long>> getSequences(String line) {
        List<List<Long>> sequences = new ArrayList<>();
        sequences.add(
                Arrays.stream(line.split(" "))
                        .map(Long::parseLong)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        while (!sequences.getLast().stream().allMatch(a -> a == 0)) {
            List<Long> nextSequence = new ArrayList<>();
            for (int i = 0; i < sequences.getLast().size() - 1; i++) {
                nextSequence.add(sequences.getLast().get(i + 1) - sequences.getLast().get(i));
            }
            sequences.add(nextSequence);
        }
        return sequences;
    }
}
