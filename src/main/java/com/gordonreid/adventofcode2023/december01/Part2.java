package com.gordonreid.adventofcode2023.december01;

import java.util.List;
import java.util.Map;

final class Part2 {

    private static final Map<String, String> DIGIT_AS_STRING_TO_REPLACEMENT = Map.of(
            "one", "o1e",
            "two", "t2o",
            "three", "t3e",
            "four", "f4r",
            "five", "f5e",
            "six", "s6x",
            "seven", "s7n",
            "eight", "e8t",
            "nine", "n9e"
    );

    static int run(List<String> input) {
        return input.stream()
                .map(Part2::replaceSpeltOutDigits)
                .map(Common::stripNonDigits)
                .map(Common::getFirstAndLastDigitAsString)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String replaceSpeltOutDigits(String line) {
        for (Map.Entry<String, String> replacement : DIGIT_AS_STRING_TO_REPLACEMENT.entrySet()) {
            line = line.replaceAll(replacement.getKey(), replacement.getValue());
        }
        return line;
    }
}
