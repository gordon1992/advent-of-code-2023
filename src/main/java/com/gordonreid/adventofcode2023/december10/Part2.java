package com.gordonreid.adventofcode2023.december10;

import com.gordonreid.adventofcode2023.december10.Common.Coordinate;

import java.util.List;

public class Part2 {

    static long run(List<String> input) {
        Coordinate animalLocation = Common.getAnimalLocation(input);
        List<Coordinate> loop = Common.getLoop(input, animalLocation);
        return shoelaceArea(loop) - (loop.size() / 2) + 1;
    }

    private static long shoelaceArea(List<Coordinate> loop) {
        double area = 0.0;
        for (int i = 0; i < loop.size() - 1; i++) {
            area += loop.get(i).x() * loop.get(i + 1).y() - loop.get(i + 1).x() * loop.get(i).y();
        }
        return (long) Math.abs(area + loop.getLast().x() * loop.getFirst().y() - loop.getFirst().x() * loop.getLast().y()) / 2;
    }
}
