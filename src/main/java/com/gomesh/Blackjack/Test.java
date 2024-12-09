package com.gomesh.Blackjack;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gomesh.Blackjack.model.Card;
import com.gomesh.Blackjack.model.Game;
import com.gomesh.Blackjack.model.hand.Hand;

@Component
public class Test implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n\n\n\n\n");

        // var hand = Hand.empty();
        // hand.addCard(Card.KING_OF_CLUBS);
        // hand.addCard(Card.THREE_OF_CLUBS);
        // hand.addCard(Card.THREE_OF_CLUBS);
        // hand.addCard(Card.THREE_OF_CLUBS);
        // hand.addCard(Card.THREE_OF_CLUBS);
        
        var game = Game.newGame(8);

        game.shuffle();
        game.nextRound();
        game.showGameDetails();

        System.out.println("\n\n\n\n\n");
    }
    
}
