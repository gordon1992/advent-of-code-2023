package com.gordonreid.adventofcode2023.december10;

import com.gordonreid.adventofcode2023.helpers.Coordinate;

import java.util.List;

public class Part1 {

    static long run(List<String> input) {
        Coordinate animalLocation = Common.getAnimalLocation(input);
        List<Coordinate> loop = Common.getLoop(input, animalLocation);
        return (loop.size() + 1) / 2;
    }
}
