package com.gomesh.Blackjack.model;

import static com.gomesh.Blackjack.model.PlayerAction.DOUBLE_DOWN;
import static com.gomesh.Blackjack.model.PlayerAction.HIT;
import static com.gomesh.Blackjack.model.PlayerAction.SPLIT;
import static com.gomesh.Blackjack.model.PlayerAction.STAND;

import com.gomesh.Blackjack.model.hand.Hand;

public class BasicStrategyBehavior {

    // public static PlayerAction play(Hand playerHand, Hand dealerHand) {
    //     return playerAction(playerHand, dealerHand);
    // }

    public static PlayerAction playerAction(Hand playerHand, Hand dealerHand) {
        if (playerHand.isSplittableHand()) {
            return switch (playerHand.value()) {

                // (2,2), (3,3)
                case 4, 6 -> switch (dealerHand.firstCardValue()) {
                    case  2, 3, 4, 5, 6, 7 -> SPLIT;
                    case  8, 9, 10, 1      -> HIT;
                    default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                };

                // (4,4)
                case 8 -> switch (dealerHand.firstCardValue()) {
                    case  2, 3, 7, 8, 9, 10, 1 -> HIT;
                    case  5, 6                 -> SPLIT;
                    default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                };
                
                // (5,5)
                case 10 -> switch (dealerHand.firstCardValue()) {
                    case  2, 3, 4, 5, 6, 7, 8, 9 -> DOUBLE_DOWN; // TODO: Double or hit?
                    case  10, 1                  -> HIT;
                    default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                };

                // (6,6), (A,A)
                case 12 -> (
                    playerHand.firstCardValue() == 1 ? SPLIT : switch (dealerHand.firstCardValue()) {
                        case  2, 3, 4, 5, 6, 7 -> SPLIT;
                        case  8, 9, 10, 1      -> HIT;
                        default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                    }
                );

                // (7,7)
                case 14 -> switch (dealerHand.firstCardValue()) {
                    case  2, 3, 4, 5, 6, 7, 8 -> SPLIT;
                    case  9, 10, 1            -> HIT;
                    default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                };
                
                // (8,8, A,A)
                case 16 -> SPLIT;

                // (9,9)
                case 18 -> switch (dealerHand.firstCardValue()) {
                    case  2, 3, 4, 5, 6, 8, 9 -> SPLIT;
                    case  7, 10, 1            -> STAND;
                    default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                };

                // (10,10)
                case 20 -> STAND;

                default -> throw new IllegalArgumentException("Unexpected value: " + playerHand.value());
            };
        }

        if (playerHand.isSoftHand()) {
            return switch (playerHand.value()) {
                case 13, 14 -> switch (dealerHand.firstCardValue()) {
                    case  2, 3, 4, 7, 8, 9, 10, 1 -> HIT;
                    case  5, 6                    -> playerHand.isDoublable() ? DOUBLE_DOWN : HIT;
                    default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                };

                case 15, 16 -> switch (dealerHand.firstCardValue()) {
                    case  2, 3, 7, 8, 9, 10, 1 -> HIT;
                    case  4, 5, 6              -> playerHand.isDoublable() ? DOUBLE_DOWN : HIT;
                    default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                };

                case 17 -> switch (dealerHand.firstCardValue()) {
                    case  2, 7, 8, 9, 10, 1 -> HIT;
                    case  3, 4, 5, 6        -> playerHand.isDoublable() ? DOUBLE_DOWN : HIT;
                    default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                };

                case 18 -> switch (dealerHand.firstCardValue()) {
                    case  2, 7, 8    -> STAND;
                    case  3, 4, 5, 6 -> playerHand.isDoublable() ? DOUBLE_DOWN : STAND;
                    case  9, 10, 1   -> HIT;
                    default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
                };

                case 19, 20, 21 -> STAND;

                default -> throw new IllegalArgumentException("Unexpected value: " + playerHand.value());
            };
        }

        return switch (playerHand.value()) {
            case 4, 5, 6, 7, 8 -> HIT;

            case 9 -> switch (dealerHand.firstCardValue()) {
                case  2, 3, 4, 5, 6  -> playerHand.isDoublable() ? DOUBLE_DOWN : HIT;
                case  7, 8, 9, 10, 1 -> HIT;
                default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
            };

            case 10 -> switch (dealerHand.firstCardValue()) {
                case  2, 3, 4, 5, 6, 7, 8, 9 -> playerHand.isDoublable() ? DOUBLE_DOWN : HIT;
                case  10, 1                  -> HIT;
                default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
            };
            
            case 11 -> playerHand.isDoublable() ? DOUBLE_DOWN : HIT;

            case 12 -> switch (dealerHand.firstCardValue()) {
                case  2, 3, 7, 8, 9, 10, 1 -> HIT;
                case  4, 5, 6              -> STAND;
                default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
            };

            case 13, 14, 15, 16 -> switch (dealerHand.firstCardValue()) {
                case  2, 3, 4, 5, 6  -> STAND;
                case  7, 8, 9, 10, 1 -> HIT;
                default -> throw new IllegalArgumentException("Unexpected value: " + dealerHand.firstCardValue());
            };

            case 17, 18, 19, 20, 21 -> STAND;

            default -> throw new IllegalArgumentException("Unexpected value: " + playerHand.value());
        };   
    }
}
