package com.gordonreid.adventofcode2023.december07;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public class Hand implements Comparable<Hand> {

    final List<Integer> cards;
    final int type;
    final long bet;

    static long calculateWinnings(Stream<Hand> handStream) {
        List<Hand> hands = handStream.sorted().toList();
        long winnings = 0;
        for (int i = 0; i < hands.size(); i++) {
            winnings += hands.get(i).getBet() * (i + 1);
        }
        return winnings;
    }

    static int inferType(List<Integer> cards) {
        return inferType(cards, 0);
    }

    static int inferType(List<Integer> cards, int jokerCount) {
        List<Long> frequencies = cards
                .stream()
                .filter(card -> jokerCount == 0 || card != 0) // Don't count jokers if there are any
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().sorted().toList().reversed();
        if (frequencies.isEmpty() || frequencies.getFirst() + jokerCount == 5) {
            return 6; // Five a kind
        } else if (frequencies.getFirst() + jokerCount == 4) {
            return 5; // Four a kind
        } else if (frequencies.getFirst() + jokerCount == 3 && frequencies.get(1) == 2) {
            return 4; // Full house
        } else if (frequencies.getFirst() + jokerCount == 3) {
            return 3; // Three a kind
        } else if (frequencies.getFirst() == 2 && (jokerCount > 0 || frequencies.get(1) == 2)) {
            return 2; // Two pair
        } else if (frequencies.getFirst() == 2 || jokerCount > 0) {
            return 1; // One pair
        } else {
            return 0; // High card
        }
    }

    @Override
    public int compareTo(Hand otherHand) {
        int thisType = this.type;
        int otherType = otherHand.type;
        if (thisType != otherType) {
            return thisType - otherType;
        }
        for (int i = 0; i < this.cards.size(); i++) {
            int thisCard = this.cards.get(i);
            int otherCard = otherHand.cards.get(i);
            if (thisCard == otherCard) {
                continue;
            }
            return thisCard - otherCard;
        }
        return 0;
    }
}
