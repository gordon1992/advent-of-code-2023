package com.gordonreid.adventofcode2023.december13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Common {
    static List<List<String>> getPatterns(List<String> input) {
        List<List<String>> patterns = new ArrayList<>();
        List<String> pattern = new ArrayList<>();
        for (String line : input) {
            if (line.isBlank()) {
                patterns.add(pattern);
                pattern = new ArrayList<>();
            } else {
                pattern.add(line);
            }
        }
        patterns.add(pattern);
        return patterns;
    }

    static long reflection(List<String> pattern, boolean fixSmudge) {
        List<String> transposedPattern = transpose(pattern);
        long rowMirrorIndex = findReflection(pattern, fixSmudge);
        long columnMirrorIndex = findReflection(transposedPattern, fixSmudge);
        return (rowMirrorIndex * 100) + columnMirrorIndex;
    }

    private static List<String> transpose(List<String> pattern) {
        List<StringBuilder> transposed = new ArrayList<>();
        IntStream.range(0, pattern.getFirst().length())
                .forEach(i -> transposed.add(new StringBuilder()));
        for (String line : pattern) {
            for (int j = 0; j < line.length(); j++) {
                transposed.get(j).append(line.charAt(j));
            }
        }
        return transposed.stream().map(StringBuilder::toString).toList();
    }

    private static long findReflection(List<String> pattern, boolean fixSmudge) {
        for (int i = 1; i < pattern.size(); i++) {
            List<String> topHalf = new ArrayList<>(pattern.subList(0, i).reversed());
            List<String> bottomHalf = new ArrayList<>(pattern.subList(i, pattern.size()));
            while (topHalf.size() > bottomHalf.size()) {
                topHalf.removeLast();
            }
            while (bottomHalf.size() > topHalf.size()) {
                bottomHalf.removeLast();
            }
            String top = String.join("", topHalf);
            String bottom = String.join("", bottomHalf);
            long mismatches = findMismatchCount(top, bottom);
            if (!fixSmudge && mismatches == 0 || fixSmudge && mismatches == 1) {
                return i;
            }
        }
        return 0;
    }

    private static long findMismatchCount(String top, String bottom) {
        return IntStream.range(0, top.length())
                .filter(i -> top.charAt(i) != bottom.charAt(i))
                .count();
    }
}
