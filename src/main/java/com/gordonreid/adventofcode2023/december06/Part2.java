package com.gordonreid.adventofcode2023.december06;

import java.util.List;

public class Part2 {

    static long run(List<String> input) {
        long time = Long.parseLong(input.getFirst().replaceAll("\\D", ""));
        long distance = Long.parseLong(input.getLast().replaceAll("\\D", ""));
        return Common.numberOfWaysToWin(time, distance);
    }
}
