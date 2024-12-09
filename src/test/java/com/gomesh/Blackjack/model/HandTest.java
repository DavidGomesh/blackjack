package com.gomesh.Blackjack.model;

import static com.gomesh.Blackjack.model.Card.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.gomesh.Blackjack.model.hand.Hand;

public class HandTest {

    @Test
    void addCardTest() {
        var hand = Hand.empty();
        assertEquals(0, hand.value());
        
        hand.addCard(ACE_OF_HEARTS);
        assertEquals(11, hand.value());

        hand.addCard(TWO_OF_DIAMONDS);
        assertEquals(13, hand.value());

        hand.addCard(FOUR_OF_SPADES);
        assertEquals(17, hand.value());

        hand.addCard(TEN_OF_CLUBS);
        assertEquals(17, hand.value());

        hand.addCard(THREE_OF_SPADES);
        assertEquals(20, hand.value());

        hand.addCard(ACE_OF_SPADES);
        assertEquals(21, hand.value());

        hand.addCard(SEVEN_OF_CLUBS);
        assertEquals(28, hand.value());
    }

    @Test
    void bustedHands() {
        assertTrue(Hand.of(List.of(THREE_OF_CLUBS, NINE_OF_DIAMONDS, QUEEN_OF_HEARTS)).isBusted());
        assertTrue(Hand.of(List.of(KING_OF_CLUBS, JACK_OF_CLUBS, TWO_OF_DIAMONDS)).isBusted());
        assertTrue(Hand.of(List.of(SEVEN_OF_CLUBS, ACE_OF_CLUBS, FIVE_OF_CLUBS, NINE_OF_DIAMONDS)).isBusted());

        assertFalse(Hand.of(List.of(THREE_OF_CLUBS, NINE_OF_DIAMONDS, NINE_OF_CLUBS)).isBusted());
        assertFalse(Hand.of(List.of(KING_OF_CLUBS, JACK_OF_CLUBS, ACE_OF_HEARTS)).isBusted());
        assertFalse(Hand.of(List.of(SEVEN_OF_CLUBS, ACE_OF_CLUBS, FIVE_OF_CLUBS, EIGHT_OF_CLUBS)).isBusted());
    }

    @Test
    void isSoftHand() {
        assertFalse(Hand.of(List.of(ACE_OF_HEARTS, ACE_OF_CLUBS, KING_OF_CLUBS, NINE_OF_CLUBS)).isSoftHand());

        assertTrue(Hand.of(List.of(ACE_OF_CLUBS, FIVE_OF_HEARTS)).isSoftHand());
        assertTrue(Hand.of(List.of(ACE_OF_CLUBS, ACE_OF_HEARTS)).isSoftHand());
        assertTrue(Hand.of(List.of(ACE_OF_HEARTS, JACK_OF_SPADES)).isSoftHand());

        assertFalse(Hand.of(List.of(ACE_OF_CLUBS, ACE_OF_HEARTS, KING_OF_DIAMONDS)).isSoftHand());
        assertFalse(Hand.of(List.of(ACE_OF_CLUBS, JACK_OF_SPADES, KING_OF_DIAMONDS)).isSoftHand());
        assertFalse(Hand.of(List.of(ACE_OF_CLUBS, SEVEN_OF_CLUBS, KING_OF_DIAMONDS)).isSoftHand());
    }

    @Test
    void isDoublable() {
        assertFalse(Hand.of(List.of(ACE_OF_CLUBS)).isDoublable());
        assertTrue (Hand.of(List.of(ACE_OF_CLUBS, TWO_OF_CLUBS)).isDoublable());
        assertFalse(Hand.of(List.of(ACE_OF_CLUBS, TWO_OF_CLUBS, THREE_OF_CLUBS)).isDoublable());
    }

    @Test
    void isSplittableHand() {
        assertTrue(Hand.of(List.of(ACE_OF_CLUBS, ACE_OF_HEARTS)).isSplittableHand());
        assertTrue(Hand.of(List.of(TEN_OF_DIAMONDS, TEN_OF_SPADES)).isSplittableHand());
        assertTrue(Hand.of(List.of(TEN_OF_DIAMONDS, JACK_OF_CLUBS)).isSplittableHand());
        
        assertFalse(Hand.of(List.of(ACE_OF_HEARTS, TWO_OF_CLUBS)).isSplittableHand());
        assertFalse(Hand.of(List.of(ACE_OF_HEARTS, ACE_OF_DIAMONDS, THREE_OF_CLUBS)).isSplittableHand());
        assertFalse(Hand.of(List.of(TEN_OF_HEARTS, SEVEN_OF_CLUBS, THREE_OF_HEARTS)).isSplittableHand());
    }

    @Test
    void hardHandsValues() {
        assertEquals(4, Hand.of(List.of(TWO_OF_HEARTS, TWO_OF_DIAMONDS)).value());
        assertEquals(5, Hand.of(List.of(TWO_OF_CLUBS, THREE_OF_SPADES)).value());

        assertEquals(6, Hand.of(List.of(TWO_OF_CLUBS, FOUR_OF_CLUBS)).value());
        assertEquals(6, Hand.of(List.of(THREE_OF_DIAMONDS, THREE_OF_SPADES)).value());

        assertEquals(7, Hand.of(List.of(FOUR_OF_SPADES, THREE_OF_CLUBS)).value());
        assertEquals(7, Hand.of(List.of(TWO_OF_CLUBS, TWO_OF_DIAMONDS, THREE_OF_CLUBS)).value());

        assertEquals(15, Hand.of(List.of(TEN_OF_CLUBS, TWO_OF_DIAMONDS, THREE_OF_CLUBS)).value());
        assertEquals(15, Hand.of(List.of(TEN_OF_CLUBS, FIVE_OF_SPADES)).value());

        assertEquals(16, Hand.of(List.of(TEN_OF_CLUBS, FIVE_OF_SPADES, ACE_OF_HEARTS)).value());
        assertEquals(16, Hand.of(List.of(TEN_OF_CLUBS, TWO_OF_DIAMONDS, THREE_OF_CLUBS, ACE_OF_HEARTS)).value());

        assertEquals(20, Hand.of(List.of(TEN_OF_CLUBS, QUEEN_OF_DIAMONDS)).value());
        assertEquals(20, Hand.of(List.of(SEVEN_OF_HEARTS, THREE_OF_HEARTS, SIX_OF_HEARTS, FOUR_OF_CLUBS)).value());

        assertEquals(21, Hand.of(List.of(SEVEN_OF_HEARTS, THREE_OF_HEARTS, SIX_OF_HEARTS, FIVE_OF_DIAMONDS)).value());
        assertEquals(21, Hand.of(List.of(TEN_OF_HEARTS, TEN_OF_SPADES, ACE_OF_HEARTS)).value());

        assertEquals(30, Hand.of(List.of(TEN_OF_HEARTS, TEN_OF_SPADES, JACK_OF_DIAMONDS)).value());
        assertEquals(31, Hand.of(List.of(TEN_OF_HEARTS, TEN_OF_SPADES, JACK_OF_DIAMONDS, ACE_OF_CLUBS)).value());
    }

    @Test
    void softHandsValues() {
        assertEquals(12, Hand.of(List.of(ACE_OF_CLUBS, ACE_OF_DIAMONDS)).value());
        assertEquals(12, Hand.of(List.of(ACE_OF_CLUBS, ACE_OF_DIAMONDS, KING_OF_HEARTS)).value());
        assertEquals(12, Hand.of(List.of(ACE_OF_DIAMONDS, KING_OF_SPADES, ACE_OF_HEARTS)).value());

        assertEquals(13, Hand.of(List.of(ACE_OF_CLUBS, ACE_OF_DIAMONDS, ACE_OF_SPADES)).value());
        assertEquals(13, Hand.of(List.of(ACE_OF_DIAMONDS, TWO_OF_CLUBS)).value());
        assertEquals(13, Hand.of(List.of(ACE_OF_DIAMONDS, TWO_OF_CLUBS, KING_OF_SPADES)).value());

        assertEquals(21, Hand.of(List.of(ACE_OF_DIAMONDS, ACE_OF_HEARTS, NINE_OF_DIAMONDS)).value());
        assertEquals(21, Hand.of(List.of(ACE_OF_DIAMONDS, SEVEN_OF_DIAMONDS, THREE_OF_DIAMONDS)).value());
        assertEquals(21, Hand.of(List.of(ACE_OF_DIAMONDS, KING_OF_SPADES)).value());
    }

    @Test
    void emptyHandValue() {
        assertEquals(0, Hand.empty().value());
    }
}
