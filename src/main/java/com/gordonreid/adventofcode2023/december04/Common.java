package com.gordonreid.adventofcode2023.december04;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class Common {

    static long getWinningNumberCount(String line) {
        String lineWithoutCardNumber = line.replaceAll("Card.*: ", "");
        Set<Long> winningNumbers = getWinningNumbers(lineWithoutCardNumber);
        Set<Long> yourNumbers = getYourNumbers(lineWithoutCardNumber);
        winningNumbers.retainAll(yourNumbers);
        return winningNumbers.size();
    }

    private static Set<Long> getYourNumbers(String withoutCardNumber) {
        String[] yourNumbersAsText = withoutCardNumber.split("\\|")[1].split("\\s+");
        return extractWhitespaceSeparatedLongs(yourNumbersAsText);
    }

    private static Set<Long> getWinningNumbers(String withoutCardNumber) {
        String[] winningNumbersAsText = withoutCardNumber.split("\\|")[0].split("\\s+");
        return extractWhitespaceSeparatedLongs(winningNumbersAsText);
    }

    private static Set<Long> extractWhitespaceSeparatedLongs(String[] text) {
        return Arrays.stream(text)
                .filter(number -> !number.isBlank())
                .map(number -> Long.parseLong(number.trim()))
                .collect(Collectors.toSet());
    }
}
