package com.gordonreid.adventofcode2023.december11;

import com.gordonreid.adventofcode2023.helpers.Coordinate;

import java.util.List;
import java.util.Set;

public class Part2 {

    static long run(List<String> input) {
        Set<Integer> rowsToExpand = Common.getRowsToExpand(input);
        Set<Integer> columnsToExpand = Common.getColumnsToExpand(input);
        List<Coordinate> galaxies = Common.getGalaxyCoordinates(input);
        return Common.getDistanceWithExpansion(galaxies, columnsToExpand, rowsToExpand, 1_000_000);
    }
}
