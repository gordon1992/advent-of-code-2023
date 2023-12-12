package com.gordonreid.adventofcode2023.december07;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Hand {

    private static final String CARD_VALUE_ORDER = "23456789TJQKA";

    Part1(List<Integer> cards, int type, long bet) {
        super(cards, type, bet);
    }

    static long run(List<String> input) {
        return calculateWinnings(input.stream().map(Part1::createHand));
    }

    private static Hand createHand(String line) {
        List<Integer> cards = new ArrayList<>();
        for (Character c : line.split(" ")[0].toCharArray()) {
            cards.add(CARD_VALUE_ORDER.indexOf(c));
        }
        int type = Hand.inferType(cards);
        long bet = Long.parseLong(line.split(" ")[1]);
        return new Hand(cards, type, bet);
    }

}
