// Name: Summer Star Isakson
// Lab Date: 2026-01-20

//Card.java
//Card class represents a playing card

public class Card {
    private final String face; // Face of card ("Ace, "Deuce", etc)
    private final String suit; // Suit of card ("Hearts", "Spades", etc)

    // Two-argument constructor initializes cards face and suit
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // Initialize face of card
        this.suit = cardSuit; // Initialize suit of card
    }// End of card constructor

    public String getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

    // Return String representation of Card
    public String toString() {
        return face + " of " + suit;

    } // End of toString method
    
}// End class card