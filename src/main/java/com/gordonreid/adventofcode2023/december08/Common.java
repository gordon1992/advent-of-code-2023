package com.gordonreid.adventofcode2023.december08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Common {
    static Map<String, Pair> getNodes(List<String> input) {
        Map<String, Pair> nodes = new HashMap<>();
        for (int i = 2; i < input.size(); i++) {
            String location = input.get(i).substring(0, 3);
            String leftDestination = input.get(i).substring(7, 10);
            String rightDestination = input.get(i).substring(12, 15);
            nodes.put(location, new Pair(leftDestination, rightDestination));
        }
        return nodes;
    }

    static String getInstructions(List<String> input) {
        return input.getFirst();
    }

    static long getSteps(String location, Predicate<String> target, String instructions, Map<String, Pair> nodes) {
        long steps = 0;
        while (!target.test(location)) {
            char direction = instructions.charAt((int) (steps % instructions.length()));
            if (direction == 'L') {
                location = nodes.get(location).leftDestination();
            } else {
                location = nodes.get(location).rightDestination();
            }
            steps++;
        }
        return steps;
    }

    record Pair(String leftDestination, String rightDestination) {
    }
}
