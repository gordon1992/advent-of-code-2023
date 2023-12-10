package com.gordonreid.adventofcode2023.december04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 {

    static long run(List<String> input) {
        Map<Integer, Long> cardNumberToCount = new HashMap<>();
        for (int card = 0; card < input.size(); card++) {
            long nowHave = cardNumberToCount.getOrDefault(card, 0L) + 1;
            cardNumberToCount.put(card, nowHave);
            long winningCount = Common.getWinningNumberCount(input.get(card));
            for (int cardWon = card + 1; cardWon < card + 1 + winningCount; cardWon++) {
                cardNumberToCount.compute(cardWon, (cardNumber, count) -> (count == null) ? nowHave : count + nowHave);
            }
        }
        return cardNumberToCount.values()
                .stream()
                .mapToLong(a -> a)
                .sum();
    }
}
