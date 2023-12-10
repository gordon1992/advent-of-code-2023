package com.gordonreid.adventofcode2023.december03;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

public class Part2 {

    private static final Pattern ASTERISK_PATTERN = Pattern.compile("[*]");

    static long run(List<String> input) {
        return InputTriple.getInputAsTriples(input)
                .flatMapToLong(Part2::getGearRatios)
                .sum();
    }

    private static LongStream getGearRatios(InputTriple inputTriple) {
        List<Long> ratios = new ArrayList<>();
        Matcher asteriskMatcher = ASTERISK_PATTERN.matcher(inputTriple.line());
        while (asteriskMatcher.find()) {
            ratios.add(getGearRatio(inputTriple, asteriskMatcher));
        }
        return ratios.stream().mapToLong(a -> a);
    }

    private static Long getGearRatio(InputTriple inputTriple, Matcher asteriskMatcher) {
        List<Long> partNumbers = inputTriple.getDigitsSurrounding(asteriskMatcher.start());
        if (partNumbers.size() != 2) {
            return 0L;
        }
        return partNumbers.get(0) * partNumbers.get(1);
    }
}
