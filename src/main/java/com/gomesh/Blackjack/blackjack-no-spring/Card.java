import java.security.PublicKey;
import java.util.List;

public enum Card {

    ACE_OF_CLUBS,     TWO_OF_CLUBS,      THREE_OF_CLUBS,    FOUR_OF_CLUBS,    FIVE_OF_CLUBS,
    SIX_OF_CLUBS,     SEVEN_OF_CLUBS,    EIGHT_OF_CLUBS,    NINE_OF_CLUBS,    TEN_OF_CLUBS,
    JACK_OF_CLUBS,    QUEEN_OF_CLUBS,    KING_OF_CLUBS,

    ACE_OF_DIAMONDS,  TWO_OF_DIAMONDS,   THREE_OF_DIAMONDS, FOUR_OF_DIAMONDS, FIVE_OF_DIAMONDS,
    SIX_OF_DIAMONDS,  SEVEN_OF_DIAMONDS, EIGHT_OF_DIAMONDS, NINE_OF_DIAMONDS, TEN_OF_DIAMONDS,
    JACK_OF_DIAMONDS, QUEEN_OF_DIAMONDS, KING_OF_DIAMONDS,

    ACE_OF_SPADES,    TWO_OF_SPADES,     THREE_OF_SPADES,   FOUR_OF_SPADES,   FIVE_OF_SPADES,
    SIX_OF_SPADES,    SEVEN_OF_SPADES,   EIGHT_OF_SPADES,   NINE_OF_SPADES,   TEN_OF_SPADES,
    JACK_OF_SPADES,   QUEEN_OF_SPADES,   KING_OF_SPADES,

    ACE_OF_HEARTS,    TWO_OF_HEARTS,     THREE_OF_HEARTS,   FOUR_OF_HEARTS,   FIVE_OF_HEARTS,
    SIX_OF_HEARTS,    SEVEN_OF_HEARTS,   EIGHT_OF_HEARTS,   NINE_OF_HEARTS,   TEN_OF_HEARTS,
    JACK_OF_HEARTS,   QUEEN_OF_HEARTS,   KING_OF_HEARTS;

    public static Boolean isAce(Card card) {
        return switch (card) {
            case ACE_OF_CLUBS, ACE_OF_DIAMONDS, ACE_OF_SPADES, ACE_OF_HEARTS -> true;
            default -> false;
        };
    }

    public static Integer value(Card card) {
        return switch (card) {
            case ACE_OF_CLUBS,   ACE_OF_DIAMONDS,   ACE_OF_SPADES,   ACE_OF_HEARTS   -> 1;
            case TWO_OF_CLUBS,   TWO_OF_DIAMONDS,   TWO_OF_HEARTS,   TWO_OF_SPADES   -> 2;
            case THREE_OF_CLUBS, THREE_OF_DIAMONDS, THREE_OF_SPADES, THREE_OF_HEARTS -> 3;
            case FOUR_OF_CLUBS,  FOUR_OF_DIAMONDS,  FOUR_OF_SPADES,  FOUR_OF_HEARTS  -> 4;
            case FIVE_OF_CLUBS,  FIVE_OF_DIAMONDS,  FIVE_OF_SPADES,  FIVE_OF_HEARTS  -> 5;
            case SIX_OF_CLUBS,   SIX_OF_DIAMONDS,   SIX_OF_SPADES,   SIX_OF_HEARTS   -> 6;
            case SEVEN_OF_CLUBS, SEVEN_OF_DIAMONDS, SEVEN_OF_SPADES, SEVEN_OF_HEARTS -> 7;
            case EIGHT_OF_CLUBS, EIGHT_OF_DIAMONDS, EIGHT_OF_SPADES, EIGHT_OF_HEARTS -> 8;
            case NINE_OF_CLUBS,  NINE_OF_DIAMONDS,  NINE_OF_SPADES,  NINE_OF_HEARTS  -> 9;
            default                                                                  -> 10;
        };
    }

    public static List<Card> getDeck() {
        return List.of(Card.values());
    }
}
