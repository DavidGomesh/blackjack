import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {
    private final List<Card> cards;

    public Shoe(List<Card> cards) {
        this.cards = cards;
    }

    public static Shoe of(int decksAmount) {
        var cards = new ArrayList<Card>();
        for(int i=0; i<decksAmount; i++) {
            cards.addAll(Card.getDeck());
        }

        return new Shoe(cards);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getOne() {
        return cards.removeFirst();
    }

    public List<Card> cards() {
        return cards;
    }

    public int amount() {
        return cards.size();
    }

    public void log() {
        System.out.println(
            "Shoe | amount: " + cards.size() + " - cards: " + cards
        );
    }
}
