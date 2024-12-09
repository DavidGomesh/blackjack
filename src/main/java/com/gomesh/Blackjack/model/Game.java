package com.gomesh.Blackjack.model;

import static com.gomesh.Blackjack.model.PlayerAction.SPLIT;

import java.util.List;

import com.gomesh.Blackjack.model.hand.Hand;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Game {
    
    private final Shoe shoe;
    private final Tray tray;
    private final Hand dealerHand;
    private final List<Hand> playerHands;

    public static Game newGame(Integer decksAmount) {
        return (Game.builder()
            .shoe(Shoe.of(decksAmount))
            .tray(Tray.empty())
            .dealerHand(Hand.empty())
            .playerHands(List.of(Hand.empty(), Hand.empty()))
            .build()
        );
    }

    public void nextRound() {
        distributeFirstCards();
        distributeSecondCards();

        playerHands.forEach(hand -> {
            playPlayerHand(hand);
        });

        performDealerTurn();
    }

    public void playPlayerHand(Hand playerHand) {
        while (playerHand.isOpen()) {
            var playerAction = BasicStrategyBehavior.playerAction(playerHand, dealerHand);
            switch (playerAction) {

                case HIT: playerHand.addCard(shoe.getOne()); break;
                case STAND: playerHand.finish(); break;

                case DOUBLE_DOWN: 
                    playerHand.addCard(shoe.getOne());
                    playerHand.finish();
                break;

                case SPLIT: playerHand.addCard(shoe.getOne()); break;
            }
        }
    }

    public void shuffle() {
        shoe.shuffle();
    }

    public void distributeFirstCards() {
        giveOneCardForEveryone();
    }

    public void distributeSecondCards() {
        giveOneCardForEveryone();
    }
    
    public void giveOneCardForEveryone() {
        playerHands.forEach(hand -> hand.addCard(shoe.getOne()));
        dealerHand.addCard(shoe.getOne());
    }

    public void performDealerTurn() {
        while(dealerMustHit()) {
            dealerHand.addCard(shoe.getOne());
        }
    }

    private Boolean dealerMustHit() {
        return dealerHand.value() < 17;
    }

    public void showGameDetails() {
        System.out.println("Cards amount in the shoe: " + shoe.cardsAmount());
        System.out.println("Cards amount in the tray: " + tray.cardsAmount());
        System.out.println("Dealer Hand Value: " + dealerHand.value());
        System.out.println("Players hands values:");
        playerHands.forEach(hand -> System.out.println(hand.value()));
        System.out.println("\n");
    }
}
