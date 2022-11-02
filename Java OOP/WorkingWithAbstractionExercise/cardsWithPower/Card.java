package cardsWithPower;

public class Card {
    private CardRank rank;
    private CardSuit suit;
    private int power;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        this.power = rank.getPower() + suit.getPower();
    }

    public int getPower() {
        return power;
    }

}
