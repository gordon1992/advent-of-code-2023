package com.gordonreid.adventofcode2023.december02;

import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Part1 {

    private static final Pattern GAME_ID_PATTERN = Pattern.compile("^Game (\\d+): *");

    private static final Map<String, Integer> CUBE_COLOUR_TO_NUMBER = Map.of(
            "red", 12,
            "green", 13,
            "blue", 14
    );

    static long run(List<String> input) {
        return input.stream()
                .filter(Part1::isValidGame)
                .mapToLong(Part1::getGameId)
                .sum();
    }

    private static boolean isValidGame(String line) {
        Matcher cubeMatcher = Common.CUBE_PATTERN.matcher(line);
        while (cubeMatcher.find()) {
            long cubeCount = Long.parseLong(cubeMatcher.group(1));
            String cubeColour = cubeMatcher.group(2);
            if (cubeCount > CUBE_COLOUR_TO_NUMBER.get(cubeColour)) {
                return false;
            }
        }
        return true;
    }

    private static long getGameId(String line) {
        Matcher idMatcher = GAME_ID_PATTERN.matcher(line);
        Preconditions.checkArgument(idMatcher.find(), "Failed to get Game ID from {}", line);
        return Long.parseLong(idMatcher.group(1));
    }
}