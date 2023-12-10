package com.gordonreid.adventofcode2023.december03;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.LongStream;

public class Part1 {

    static long run(List<String> input) {
        return InputTriple.getInputAsTriples(input)
                .flatMapToLong(Part1::getPartNumbers)
                .sum();
    }

    private static LongStream getPartNumbers(InputTriple inputTriple) {
        Matcher digitMatcher = inputTriple.getDigitMatcher();
        List<String> partNumbers = new ArrayList<>();
        while (digitMatcher.find()) {
            Matcher symbolMatcher = inputTriple.getSymbolsSurrounding(digitMatcher.start() - 1, digitMatcher.end() + 1);
            if (symbolMatcher.find()) {
                partNumbers.add(digitMatcher.group());
            }
        }
        return partNumbers.stream().mapToLong(Long::parseLong);
    }
}
