package com.gordonreid.adventofcode2023.december08;

import com.gordonreid.adventofcode2023.december08.Common.Pair;

import java.util.List;
import java.util.Map;

public class Part2 {

    static long run(List<String> input) {
        String instructions = Common.getInstructions(input);
        Map<String, Pair> nodes = Common.getNodes(input);
        List<Long> stepCounts = nodes.keySet().stream()
                .filter(location -> location.endsWith("A"))
                .map(location -> Common.getSteps(location, l -> l.endsWith("Z"), instructions, nodes))
                .toList();
        return lcm(stepCounts);
    }

    private static long lcm(List<Long> numbers) {
        return numbers.stream().reduce(1L, (acc, n) -> (acc * n) / gcd(acc, n));
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
