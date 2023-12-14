package com.gordonreid.adventofcode2023.december10;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Common {
    private static final String ANIMAL = "S";
    private static final String NORTH = "S|LJ";
    private static final String EAST = "S-LF";
    private static final String WEST = "S-J7";
    private static final String SOUTH = "S|7F";

    static Coordinate getAnimalLocation(List<String> input) {
        Coordinate animalLocation = null;
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.getFirst().length(); x++) {
                if (input.get(y).charAt(x) == ANIMAL.charAt(0)) {
                    animalLocation = new Coordinate(x, y);
                }
            }
        }
        return animalLocation;
    }

    static List<Coordinate> getLoop(List<String> input, Coordinate animalLocation) {
        Set<Coordinate> loop = new LinkedHashSet<>();
        List<Coordinate> queue = new ArrayList<>();
        queue.add(animalLocation);
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.removeLast();
            loop.add(coordinate);
            getAdjacent(input, coordinate).stream()
                    .filter(adjacent -> isConnected(coordinate, adjacent, input))
                    .filter(c -> !loop.contains(c))
                    .forEach(queue::add);
        }
        return loop.stream().toList();
    }

    private static boolean isConnected(Coordinate current, Coordinate adjacent, List<String> input) {
        char v1 = input.get(current.y()).charAt(current.x());
        char v2 = input.get(adjacent.y()).charAt(adjacent.x());
        if (current.y() == adjacent.y()) {
            if (adjacent.x() - current.x() == 1 && EAST.indexOf(v1) != -1 && WEST.indexOf(v2) != -1) {
                return true;
            }
            if (current.x() - adjacent.x() == 1 && WEST.indexOf(v1) != -1 && EAST.indexOf(v2) != -1) {
                return true;
            }
        }
        if (current.x() == adjacent.x()) {
            if (adjacent.y() - current.y() == 1 && SOUTH.indexOf(v1) != -1 && NORTH.indexOf(v2) != -1) {
                return true;
            }
            return current.y() - adjacent.y() == 1 && NORTH.indexOf(v1) != -1 && SOUTH.indexOf(v2) != -1;
        }
        return false;
    }

    private static List<Coordinate> getAdjacent(List<String> input, Coordinate coordinate) {
        List<Coordinate> adjacent = new ArrayList<>();
        if (coordinate.x() > 0) {
            adjacent.add(new Coordinate(coordinate.x() - 1, coordinate.y()));
        }
        if (coordinate.y() > 0) {
            adjacent.add(new Coordinate(coordinate.x(), coordinate.y() - 1));
        }
        if (coordinate.x() < input.getFirst().length() - 1) {
            adjacent.add(new Coordinate(coordinate.x() + 1, coordinate.y()));
        }
        if (coordinate.y() < input.size() - 1) {
            adjacent.add(new Coordinate(coordinate.x(), coordinate.y() + 1));
        }
        return adjacent;
    }

    record Coordinate(int x, int y) {
    }
}
