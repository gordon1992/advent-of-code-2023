package com.gordonreid.adventofcode2023.december12;

import java.util.*;
import java.util.stream.IntStream;

public class Common {
    private static final String OPERATIONAL = ".";
    private static final String DAMAGED = "#";
    private static final Set<String> KNOWN = Set.of(OPERATIONAL, DAMAGED);
    private static final char UNKNOWN = '?';

    static long arrangements(String line, int copies) {
        String givenSprings = line.split("\\s+")[0];
        List<Integer> givenNumbers = Arrays.stream(line.split("\\s+")[1].split(","))
                .map(Integer::parseInt)
                .toList();
        StringBuilder springsBuilder = new StringBuilder();
        springsBuilder.append(givenSprings);
        for (int i = 0; i < copies - 1; i++) {
            springsBuilder.append(UNKNOWN);
            springsBuilder.append(givenSprings);
        }
        String springs = springsBuilder.toString();
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(0, copies).forEach(i -> numbers.addAll(givenNumbers));
        Map<CacheKey, Long> cache = new HashMap<>();
        return combinations(springs, numbers, cache, 0, 0, 0);
    }

    private static long combinations(String springs, List<Integer> numbers, Map<CacheKey, Long> cache, int springPosition, int numberPosition, int damagedBlockLength) {
        CacheKey cacheKey = new CacheKey(springPosition, numberPosition, damagedBlockLength);
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        if (springPosition == springs.length()) {
            if (numberPosition == numbers.size() && damagedBlockLength == 0) {
                return 1;
            } else if (numberPosition == numbers.size() - 1 && numbers.get(numberPosition) == damagedBlockLength) {
                return 1;
            } else {
                return 0;
            }
        }
        long combinations = 0;
        for (String spring : KNOWN) {
            if (springs.charAt(springPosition) == spring.charAt(0) || springs.charAt(springPosition) == UNKNOWN) {
                if (spring.equals(OPERATIONAL) && damagedBlockLength == 0) {
                    combinations += combinations(springs, numbers, cache, springPosition + 1, numberPosition, 0);
                } else if (spring.equals(OPERATIONAL) && damagedBlockLength > 0 && numberPosition < numbers.size() && numbers.get(numberPosition) == damagedBlockLength) {
                    combinations += combinations(springs, numbers, cache, springPosition + 1, numberPosition + 1, 0);
                } else if (spring.equals(DAMAGED)) {
                    combinations += combinations(springs, numbers, cache, springPosition + 1, numberPosition, damagedBlockLength + 1);
                }
            }
        }
        cache.put(cacheKey, combinations);
        return combinations;
    }

    private record CacheKey(int springPosition, int numberPosition, int damagedBlockLength) {
    }
}
