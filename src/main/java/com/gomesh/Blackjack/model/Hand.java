package com.gomesh.Blackjack.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Hand {
    
    private final List<Card> cards;

    public static Hand of(List<Card> cards) {
        return new Hand(cards);
    }

    public static Hand empty() {
        return Hand.of(new ArrayList<>());
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Boolean isBusted() {
        return value() > 21;
    }

    public Boolean isSoftHand() {
        var aceCardsAmount = aceCardsAmount();
        var cardsValuesSum = cardsValuesSum();

        return aceCardsAmount > 0 && cardsValuesSum + 10 <= 21;
    }

    public Integer value() {
        var aceCardsAmount = aceCardsAmount();
        var cardsValuesSum = cardsValuesSum();

        return (aceCardsAmount > 0 && cardsValuesSum + 10 <= 21 ? 
            cardsValuesSum + 10 : cardsValuesSum
        );
    }

    private Integer aceCardsAmount() {
        return ((int) cards.stream()
            .filter(Card::isAce)
            .count()
        );
    }

    private Integer cardsValuesSum() {
        return (cards.stream()
            .mapToInt(Card::value)
            .sum()
        );
    }
}
