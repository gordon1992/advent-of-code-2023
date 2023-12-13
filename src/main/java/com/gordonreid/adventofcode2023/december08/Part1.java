package com.gordonreid.adventofcode2023.december08;

import com.gordonreid.adventofcode2023.december08.Common.Pair;

import java.util.List;
import java.util.Map;

public class Part1 {

    static long run(List<String> input) {
        String instructions = Common.getInstructions(input);
        Map<String, Pair> nodes = Common.getNodes(input);
        return Common.getSteps("AAA", l -> l.equals("ZZZ"), instructions, nodes);
    }
}
