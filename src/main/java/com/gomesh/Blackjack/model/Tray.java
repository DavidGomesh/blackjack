package com.gomesh.Blackjack.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Tray {

    private final List<Card> cards;

    public static Tray empty() {
        return new Tray(new ArrayList<>());
    }

    public Integer cardsAmount() {
        return cards.size();
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
