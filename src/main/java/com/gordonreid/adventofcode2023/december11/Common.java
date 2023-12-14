package com.gordonreid.adventofcode2023.december11;


import com.gordonreid.adventofcode2023.helpers.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Common {
    static final char GALAXY = '#';

    static long getDistanceWithExpansion(List<Coordinate> galaxies, Set<Integer> columnsToExpand, Set<Integer> rowsToExpand, long expansion) {
        long distance = 0;
        for (int i = 0; i < galaxies.size(); i++) {
            for (int j = i + 1; j < galaxies.size(); j++) {
                long smallerX = Math.min(galaxies.get(i).x(), galaxies.get(j).x());
                long greaterX = Math.max(galaxies.get(i).x(), galaxies.get(j).x());
                long smallerY = Math.min(galaxies.get(i).y(), galaxies.get(j).y());
                long greaterY = Math.max(galaxies.get(i).y(), galaxies.get(j).y());
                long extraXDistance = columnsToExpand.stream().filter(c -> c > smallerX && c < greaterX).count() * (expansion - 1);
                long extraYDistance = rowsToExpand.stream().filter(c -> c > smallerY && c < greaterY).count() * (expansion - 1);
                long shortestPath = (greaterX - smallerX + extraXDistance) + (greaterY - smallerY + extraYDistance);
                distance += shortestPath;
            }
        }
        return distance;
    }

    static List<Coordinate> getGalaxyCoordinates(List<String> galaxyMap) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int y = 0; y < galaxyMap.size(); y++) {
            for (int x = 0; x < galaxyMap.get(y).length(); x++) {
                if (galaxyMap.get(y).charAt(x) == GALAXY) {
                    coordinates.add(new Coordinate(x, y));
                }
            }
        }
        return coordinates;
    }

    static boolean columnEmpty(int i, List<String> input) {
        for (String row : input) {
            if (row.charAt(i) == GALAXY) {
                return false;
            }
        }
        return true;
    }

    static Set<Integer> getColumnsToExpand(List<String> input) {
        return IntStream.range(0, input.getFirst().length())
                .filter(i -> columnEmpty(i, input))
                .boxed()
                .collect(Collectors.toSet());
    }

    static Set<Integer> getRowsToExpand(List<String> input) {
        return IntStream.range(0, input.size())
                .filter(i -> input.get(i).indexOf(GALAXY) == -1)
                .boxed()
                .collect(Collectors.toSet());
    }
}
