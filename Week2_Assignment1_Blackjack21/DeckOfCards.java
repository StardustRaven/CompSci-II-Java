// Name: Summer Star Isakson
// Lab Date: 2026-01-20

// DeckOfCards.java
// DeckOfCards class represent a deck of playing cards
import java.security.SecureRandom;

public class DeckOfCards  {
    // Random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;

    private Card[] deck = new Card[NUMBER_OF_CARDS]; //Card references
    private int currentCard = 0; //index of next Card to be delt (0-51)
    
    // Contructor fills deck of Cards
    public DeckOfCards() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        
        // Populate deck with Card objects
        for (int count = 0; count < deck.length; count++) {
            deck[count] =
                new Card(faces[count % 13], suits[count / 13]);
        } // End of for loop
    } // End of DeckOfCards Constructor

    // Shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // Next call to method dealCard should start at deck[0] again
        currentCard = 0;

        // For each Card, pick another random Card (0-51) and swap them
        for ( int first = 0; first < deck.length; first++) {
            // Select a random number between 0 - 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // Swap current Card with randomly selected Card
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;      
         } // End for loop
} // End of shuffle method

// Deal one card
    public Card dealCard() {
        // Determine whether Cards remain to be dealt
        if (currentCard < deck.length) {
            return deck[currentCard++]; // Return current Card in array
        }
    else {
            return null; // Return null to indicate that all Cards were dealt
        }// End if/else

   }// End of dealCard method

}// End of DeckOfCards class