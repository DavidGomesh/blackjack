
import java.util.ArrayList;
import java.util.List;

public class Tray { 

    private final List<Card> cards;

    public Tray(List<Card> cards) {
        this.cards = cards;
    }

    public static Tray empty() {
        return new Tray(new ArrayList<>());
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void log() {
        System.out.println(
            "Tray | amount: " + cards.size() + " - cards: " + cards
        );
    }
}
