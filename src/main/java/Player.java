import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    public Card getSpecificCard(int index) {
        return hand.get(index);
    }

    public int getHandSize() {
        return hand.size();
    }

    public void addCardToHand(Card inCard) {
        hand.add(inCard);
    }

    public int getHandValue() {
        int handValue = 0;
        for (Card tempCard: hand) {
            if (!tempCard.getCardValue().isAce()) {
                handValue += tempCard.getCardValue().getValue();
            }
        }
        for (Card tempCard: hand) {
            if (tempCard.getCardValue().isAce() && handValue <= 10) {
                handValue += tempCard.getCardValue().getValue();
            }
            else if (tempCard.getCardValue().isAce()) {
                handValue += 1;
            }
        }
        return handValue;
    }

    @Override
    public String toString() {
        String handString = "Your hand is:\n";
        for (Card tempCard: hand) {
            handString += tempCard.toString() + "\n";
        }
        handString += "Your hand is currently worth " + getHandValue() + " points.";
        return handString;
    }
}
