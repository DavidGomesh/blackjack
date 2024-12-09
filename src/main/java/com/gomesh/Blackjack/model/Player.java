package com.gomesh.Blackjack.model;

import java.util.ArrayList;
import java.util.List;

import com.gomesh.Blackjack.model.hand.Hand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    
    private final List<Hand> hands;

    public static Player newPlayer() {
        return new Player(new ArrayList<>());
    }

    public void clearHands() {
        hands.clear();
    }
}
