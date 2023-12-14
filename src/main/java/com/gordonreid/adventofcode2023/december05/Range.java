package com.gordonreid.adventofcode2023.december05;

class Range {

    private final long lower;
    private final boolean lowerInclusive;
    private final long upper;
    private final boolean upperInclusive;

    public Range(long lower, boolean lowerInclusive, long upper, boolean upperInclusive) {
        this.lower = lower;
        this.lowerInclusive = lowerInclusive;
        this.upper = upper;
        this.upperInclusive = upperInclusive;
    }

    public long getLower() {
        return lower;
    }

    public long getUpper() {
        return upper;
    }

    public static Range closedOpen(long lower, long upper) {
        return new Range(lower, true, upper, false);
    }

    public boolean contains(long location) {
        if (lower > location || upper < location) {
            return false;
        }
        if (!lowerInclusive && lower == location) {
            return false;
        }
        return upperInclusive || upper != location;
    }
}
