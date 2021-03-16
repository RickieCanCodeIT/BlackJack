import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackApp {
    public static Deck currentDeck;
    public static Player dealer;
    public static Player user;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        currentDeck = new Deck();
        String playAgain = "yes";
        do {
            dealer = new Player("Dealer", new ArrayList<>());
            user = new Player("User", new ArrayList<>());
            user.addCardToHand(currentDeck.drawCard());
            dealer.addCardToHand(currentDeck.drawCard());
            user.addCardToHand(currentDeck.drawCard());
            dealer.addCardToHand(currentDeck.drawCard());
            String choice = "";
            while (!choice.toLowerCase().equals("stand") && user.getHandValue() < 21) {
                System.out.println(user.toString());
                System.out.println("The dealer's visible card is: " + dealer.getSpecificCard(1));
                System.out.println("Do you want to Hit or Stand?");
                choice = input.nextLine();
                if (choice.toLowerCase().equals("hit")) {
                    Card drawnCard = currentDeck.drawCard();
                    user.addCardToHand(drawnCard);
                    System.out.println("You drew the " + drawnCard.toString() + "!");
                    System.out.println("Your hand is now worth " + user.getHandValue() + " points.");
                }
            }

            while (dealer.getHandValue() < 17) {
                dealer.addCardToHand(currentDeck.drawCard());
            }

            if (user.getHandValue() == 21 && user.getHandSize() == 2) {
                System.out.println("Blackjack! You win big!");
            } else if (user.getHandValue() > 21) {
                System.out.println("You bust! Try again next time!");
            } else if (user.getHandValue() > dealer.getHandValue()) {
                System.out.println("The dealer had " + dealer.getHandValue() + ". You win! Congratulations!");
            } else if (dealer.getHandValue() <= 21) {
                System.out.println("The dealer had " + dealer.getHandValue() + ". You lost...");
            } else {
                System.out.println("The dealer busts! You win!");
            }
            System.out.println("Play again? (yes or no)");
            playAgain = input.nextLine();
        } while (playAgain.toLowerCase().equals("yes"));
    }
}
