package com.gordonreid.adventofcode2023.december03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record InputTriple(Optional<String> before, String line, Optional<String> after) {

    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d+");
    private static final Pattern SYMBOL_PATTERN = Pattern.compile("[^0-9.]");

    private InputTriple(List<String> input, int i) {
        this(getLineBefore(input, i), input.get(i), getLineAfter(input, i));
    }

    public static Stream<InputTriple> getInputAsTriples(List<String> input) {
        return IntStream.range(0, input.size())
                .mapToObj(i -> new InputTriple(input, i));
    }

    private static Optional<String> getLineBefore(List<String> input, int i) {
        return i > 0 ? Optional.of(input.get(i - 1)) : Optional.empty();
    }

    private static Optional<String> getLineAfter(List<String> input, int i) {
        return i < (input.size() - 1) ? Optional.of(input.get(i + 1)) : Optional.empty();
    }

    private String beforeBetween(int startIndex, int endIndex) {
        return before.map(contents -> contents.substring(startIndex, endIndex)).orElse("");
    }

    private String lineBetween(int startIndex, int endIndex) {
        return line.substring(startIndex, endIndex);
    }

    private String afterBetween(int startIndex, int endIndex) {
        return after.map(contents -> contents.substring(startIndex, endIndex)).orElse("");
    }

    private String adjacentText(int startIndex, int endIndex) {
        return beforeBetween(startIndex, endIndex) +
                lineBetween(startIndex, endIndex) +
                afterBetween(startIndex, endIndex);
    }

    public Matcher getSymbolsSurrounding(int start, int end) {
        int symbolStartIndex = Math.max(0, start);
        int symbolEndIndex = Math.min(line.length(), end);
        return SYMBOL_PATTERN.matcher(adjacentText(symbolStartIndex, symbolEndIndex));
    }

    public Matcher getDigitMatcher() {
        return DIGIT_PATTERN.matcher(line);
    }

    public List<Long> getDigitsSurrounding(int asteriskLocation) {
        List<Long> digits = new ArrayList<>();
        before.ifPresent(input -> digits.addAll(getLongs(asteriskLocation, input)));
        digits.addAll(getLongs(asteriskLocation, line));
        after.ifPresent(input -> digits.addAll(getLongs(asteriskLocation, input)));
        return digits;
    }

    private List<Long> getLongs(int asteriskLocation, String input) {
        List<Long> digits = new ArrayList<>();
        Matcher lineBeforeDigits = DIGIT_PATTERN.matcher(input);
        while (lineBeforeDigits.find()) {
            int digitStart = lineBeforeDigits.start();
            int digitEnd = lineBeforeDigits.end() - 1;
            if (Math.abs(asteriskLocation - digitStart) <= 1 || Math.abs(asteriskLocation - digitEnd) <= 1) {
                digits.add(Long.valueOf(lineBeforeDigits.group()));
            }
        }
        return digits;
    }
}
