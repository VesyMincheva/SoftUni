package cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rankString = scanner.nextLine();
        String suitString = scanner.nextLine();

        CardRank rank = CardRank.valueOf(rankString);
        CardSuit suit = CardSuit.valueOf(suitString);
        Card card = new Card(rank, suit);

        System.out.printf("Card name: %s of %s; Card power: %d", rank.name(), suit.name(), card.getPower());
    }
}
