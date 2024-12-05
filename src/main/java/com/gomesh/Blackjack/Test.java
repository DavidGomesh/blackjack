package com.gomesh.Blackjack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gomesh.Blackjack.model.Shoe;
import com.gomesh.Blackjack.model.Tray;

@Component
public class Test implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        var shoe = Shoe.of(1);
        var tray = Tray.empty();
        
        shoe.shuffle();
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
        tray.addCard(shoe.getOne());
    }
    
}
