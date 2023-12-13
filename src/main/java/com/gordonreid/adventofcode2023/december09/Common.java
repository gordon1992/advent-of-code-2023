package com.gordonreid.adventofcode2023.december09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Common {
    static List<List<Long>> getSequencies(String line) {
        List<List<Long>> sequencies = new ArrayList<>();
        sequencies.add(
                Arrays.stream(line.split(" "))
                        .map(Long::parseLong)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        while (!sequencies.getLast().stream().allMatch(a -> a == 0)) {
            List<Long> nextSequence = new ArrayList<>();
            for (int i = 0; i < sequencies.getLast().size() - 1; i++) {
                nextSequence.add(sequencies.getLast().get(i + 1) - sequencies.getLast().get(i));
            }
            sequencies.add(nextSequence);
        }
        return sequencies;
    }
}
