package com.gomesh.Blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Shoe {

    private final List<Card> cards;

    public static Shoe of(Integer decksAmount) {
        var cards = new ArrayList<Card>();
        for(int i=0; i<decksAmount; i++) {
            cards.addAll(Card.getDeck());
        }

        return new Shoe(cards);
    }

    public Integer cardsAmount() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getOne() {
        return cards.removeFirst();
    }
}
