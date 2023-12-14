package com.gordonreid.adventofcode2023.december01;

public final class Common {

    static String stripNonDigits(String line) {
        return line.replaceAll("[^\\d.]", "");
    }

    static String getFirstAndLastDigitAsString(String line) {
        return line.charAt(0) + String.valueOf(line.charAt(line.length() - 1));
    }
}
