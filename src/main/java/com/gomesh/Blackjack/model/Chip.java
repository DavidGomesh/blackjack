package com.gomesh.Blackjack.model;

import java.util.List;

public enum Chip {

    // FIVE_CENTS, TEN_CENTS, TWENTY_FIVE_CENTS, FIFTY_CENTS,
    ONE_DOLLAR, FIVE_DOLLARS, TEN_DOLLARS, TWENTY_FIVE_DOLLARS, FIFTY_DOLLARS,
    ONE_HUNDRED_DOLLARS, FIVE_HUNDRED_DOLLARS,
    ONE_THOUSAND_DOLLARS, FIVE_THOUSAND_DOLLARS, TWENTY_FIVE_THOUSAND_DOLLARS;

    public static Double value(Chip chip) {
        return switch (chip) {
            // case FIVE_CENTS ->                       0.05;
            // case TEN_CENTS ->                        0.10;
            // case TWENTY_FIVE_CENTS ->                0.25;
            // case FIFTY_CENTS ->                      0.50;

            case ONE_DOLLAR ->                       1.00;
            case FIVE_DOLLARS ->                     5.00;
            case TEN_DOLLARS ->                     10.00;
            case TWENTY_FIVE_DOLLARS ->             25.00;
            case FIFTY_DOLLARS ->                   50.00;

            case ONE_HUNDRED_DOLLARS ->            100.00;
            case FIVE_HUNDRED_DOLLARS ->           500.00;
            
            case ONE_THOUSAND_DOLLARS ->          1000.00;
            case FIVE_THOUSAND_DOLLARS ->         5000.00;
            case TWENTY_FIVE_THOUSAND_DOLLARS -> 25000.00;
        };
    }

    public static Double value(List<Chip> chips) {
        return (chips.stream()
            .mapToDouble(Chip::value)
            .sum()
        );
    }
}
