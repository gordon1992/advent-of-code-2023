package com.gordonreid.adventofcode2023.december06;

public class Common {
    static long numberOfWaysToWin(long time, long distance) {
        long minimumButtonPressedTime = (long) ((time - Math.sqrt(time * time - 4 * distance)) / 2) + 1;
        return time - (2 * minimumButtonPressedTime) + 1;
    }
}
