package com.gordonreid.adventofcode2023.december02;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class Common {
    static final Pattern CUBE_PATTERN = Pattern.compile("(\\d+) (red|green|blue)");
}
