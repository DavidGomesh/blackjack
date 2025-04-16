import java.util.ArrayList;
import java.util.List;

public class Hand {

    public static final int DEFAULT_LEVEL = 0;
    
    private final List<Card> cards;
    private final int level;

    public Hand(List<Card> cards, int level) {
        this.cards = cards;
        this.level = level;
    }

    public static Hand empty() {
        return new Hand(new ArrayList<>(), DEFAULT_LEVEL);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int value() {
        var sum = cards.stream().mapToInt(Card::value).sum();
        return (containsAce() && sum + 10 <= 21 ? sum + 10 : sum);
    }

    private boolean containsAce() {
        return (cards.stream().anyMatch(Card::isAce));
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && value() == 21;
    }

    public List<Card> cards() {
        return cards;
    }

    public Card first() {
        return cards.getFirst();
    }

    public Boolean isBusted() {
        return value() > 21;
    }
    
    public void log() {
        System.out.println("Hand | cards: " + cards + " - value: " + value() + " - BJ: " + isBlackjack());
    }


    // public Boolean isSoftHand() {
    //     var aceCardsAmount = aceCardsAmount();
    //     var cardsValuesSum = cardsValuesSum();

    //     return aceCardsAmount > 0 && cardsValuesSum + 10 <= 21;
    // }

    // public Integer value() {
    //     var aceCardsAmount = aceCardsAmount();
    //     var cardsValuesSum = cardsValuesSum();

    //     return (aceCardsAmount > 0 && cardsValuesSum + 10 <= 21 ? 
    //         cardsValuesSum + 10 : cardsValuesSum
    //     );
    // }

    // private Integer aceCardsAmount() {
    //     return ((int) cards.stream()
    //         .filter(Card::isAce)
    //         .count()
    //     );
    // }

    // private Integer cardsValuesSum() {
    //     return (cards.stream()
    //         .mapToInt(Card::value)
    //         .sum()
    //     );
    // }
}
