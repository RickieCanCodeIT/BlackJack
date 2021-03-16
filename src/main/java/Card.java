//A card in the standard 52 card deck
public class Card {
    private CardValue cardValue;
    private Suit suit;

    public Card(CardValue cardValue, Suit suit) {
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return cardValue.getName() + " of " + suit.getName();
    }
}
