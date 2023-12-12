package com.gordonreid.adventofcode2023.december07;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Hand {

    private static final String CARD_VALUE_ORDER = "J23456789TQKA";

    Part2(List<Integer> cards, int type, long bet) {
        super(cards, type, bet);
    }

    static long run(List<String> input) {
        return calculateWinnings(input.stream().map(Part2::createHand));
    }

    private static Hand createHand(String line) {
        int jokerCount = 0;
        List<Integer> cards = new ArrayList<>();
        for (Character c : line.split(" ")[0].toCharArray()) {
            if (c == 'J') {
                jokerCount++;
            }
            cards.add(CARD_VALUE_ORDER.indexOf(c));
        }
        int type = Hand.inferType(cards, jokerCount);
        long bet = Long.parseLong(line.split(" ")[1]);
        return new Hand(cards, type, bet);
    }
}
