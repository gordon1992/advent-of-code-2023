package com.gordonreid.adventofcode2023.december01;

import java.util.List;

final class Part1 {

    static int run(List<String> input) {
        return input.stream()
                .map(Common::stripNonDigits)
                .map(Common::getFirstAndLastDigitAsString)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}