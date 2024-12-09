package com.gomesh.Blackjack.model.hand;

import static com.gomesh.Blackjack.model.hand.HandStatus.BUSTED;
import static com.gomesh.Blackjack.model.hand.HandStatus.FINISHED;
import static com.gomesh.Blackjack.model.hand.HandStatus.OPENED;
import static com.gomesh.Blackjack.model.hand.HandType.HARD;
import static com.gomesh.Blackjack.model.hand.HandType.SOFT;

import java.util.ArrayList;
import java.util.List;

import com.gomesh.Blackjack.model.Card;

public class Hand {

    private final List<Card> cards;
    private Integer value = 0;
    private HandStatus status = OPENED;
    private HandType type = HARD;

    private Hand(List<Card> cards) {
        this.cards = cards;
    }

    public static Hand of(List<Card> cards) {
        var hand = Hand.empty();
        cards.forEach(hand::addCard);
        return hand;
    }

    public static Hand empty() {
        return new Hand(new ArrayList<>());
    }

    public void addCard(Card card) {
        cards.add(card);

        updateType();
        updateValue();
        updateStatus();
    }

    public void finish() {
        status = FINISHED;
    }

    public void bust() {
        status = BUSTED;
    }

    public Boolean isOpen() {
        return status == OPENED;
    }

    public Boolean isFinished() {
        return status == FINISHED;
    }

    public Boolean isBusted() {
        return status == BUSTED;
    }

    public Boolean isSoftHand() {
        return type == SOFT;
    }

    public Boolean isDoublable() {
        return cards.size() == 2;
    }

    public Boolean isSplittableHand() {
        return (cards.size() == 2 && (
            firstCardValue() == secondCardValue()
        ));
    }

    public Integer value() {
        return value;
    }

    public Integer firstCardValue() {
        return Card.value(cards.getFirst());
    }

    private Integer secondCardValue() {
        return Card.value(cards.get(1));
    }

    // UPDATE METHODS
    private void updateType() {
        var aceCardsAmount = aceCardsAmount();
        var cardsValuesSum = cardsValuesSum();

        type = (aceCardsAmount > 0 && cardsValuesSum + 10 <= 21 ?
            SOFT : HARD
        );
    }

    private void updateValue() {
        var cardsValuesSum = cardsValuesSum();
        value = isSoftHand() ? cardsValuesSum + 10 : cardsValuesSum;
    }

    private void updateStatus() {
        if (value == 21) {
            finish();
        } else if (value > 21) {
            bust();
        }
    }


    // AUXILIAR METHODS
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
