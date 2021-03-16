//The numerical value of the card, in text and number format. If the name is Ace isAce should be true.
public class CardValue {
    private String name;
    private int value;
    private boolean isAce;

    public CardValue(String name, int value) {
        this.name = name;
        this.value = value;
        this.isAce = name.toLowerCase().equals("Ace");
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean isAce() {
        return isAce;
    }
}
