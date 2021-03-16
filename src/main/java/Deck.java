import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        makeFreshDeck();
    }

    public void makeFreshDeck() {
        cards = new ArrayList<>();
        Suit[] suits = { new Suit("Spades", 'S'), new Suit("Clubs", 'C'),
                new Suit("Hearts", 'H'), new Suit("Diamonds", 'D')};
        CardValue[] cardValues = { new CardValue("Two", 2),
                new CardValue("Three", 3),new CardValue("Four", 4), new CardValue("Five", 5),
                new CardValue("Six", 6), new CardValue("Seven", 7), new CardValue("Eight", 8),
                new CardValue("Nine", 9), new CardValue("Ten", 10), new CardValue("Jack", 10),
                new CardValue("Queen", 10), new CardValue("King", 10), new CardValue("Ace", 11)};
        for (Suit tempSuit : suits) {
            for (CardValue tempCardValue : cardValues) {
                cards.add(new Card(tempCardValue, tempSuit));
            }
        }
        shuffle();
    }

    public void shuffle() {
        for (int counter = 0; counter < 5; counter++) {
            List<Card> tempCardList = new ArrayList<>();
            while (cards.size() > 0) {
                int cardIndex = (int)Math.floor(Math.random() * cards.size());
                Card tempCard = cards.remove(cardIndex);
                tempCardList.add(tempCard);
            }
            cards = tempCardList;
        }

    }

    public Card drawCard() {
        Card returnCard = cards.remove(0);
        if (cards.size() == 0) {
            makeFreshDeck();
        }
        return returnCard;
    }
}
