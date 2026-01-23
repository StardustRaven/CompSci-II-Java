// Name: Summer Star Isakson
// Lab Date: 2026-01-20


// Blackjack21.java
// Card shuffling and dealing

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack21 {
    public static void main(String[] args) {

        DeckOfCards deck = new DeckOfCards();
        deck.shuffle(); // one shuffle, one deck

        Scanner input = new Scanner(System.in);
        boolean playAgain = true;
        boolean outOfCards = false;

        while (playAgain) {
            ArrayList<Card> playerHand = new ArrayList<>();
            ArrayList<Card> dealerHand = new ArrayList<>();

            // Deal two cards to player, two to dealer
            Card c;

            c = dealOrQuit(deck);
            if (c == null) { outOfCards = true; break; }
            playerHand.add(c);

            c= dealOrQuit(deck);
            if (c == null) { outOfCards = true; break; }
            dealerHand.add(c);

            c = dealOrQuit(deck);
            if (c == null) { outOfCards = true; break; }
            playerHand.add(c);

            c = dealOrQuit(deck);
            if (c == null) { outOfCards = true; break; }
            dealerHand.add(c);

            if (outOfCards) {
                playAgain = false;
                break;
            }
            // Display hands (dealer shows only first card for now)
            System.out.println("\n=== New Hand ===");
            System.out.println("Player has: " + playerHand.get(0) + " and " + playerHand.get(1));
            System.out.println("Dealer shows: " + dealerHand.get(0));
            System.out.println("Dealer has a hidden card");

            int playerTotal = getHandValue(playerHand);

        // Player turn
        while (playerTotal < 21) {
            System.out.println("Player total: " + playerTotal);
            System.out.print("Hit or stand (h/s): ");
            String choice = input.nextLine().trim().toLowerCase();

            if (choice.equals("h")) {
                Card newCard = deck.dealCard();
                playerHand.add(newCard);
                System.out.println("You drew: " + newCard);
                playerTotal = getHandValue(playerHand);
            } else if (choice.equals("s")) {
                break;
            } else {
                System.out.println("Type 'h' to hit or 's' to stand.");
            }
        }
        System.out.println("Final player total: " + playerTotal);

        // Dealer turn
        int dealerTotal = getHandValue(dealerHand);
        if (playerTotal <= 21) {
            System.out.println("Dealer reveals: " + dealerHand.get(1));
            System.out.println("Dealer total: " + dealerTotal);

            while (dealerTotal < 17) {
                Card dealerNew = deck.dealCard();
                dealerHand.add(dealerNew);
                System.out.println("Dealer drew: " + dealerNew);
                dealerTotal = getHandValue(dealerHand);
                System.out.println("Dealer total: " + dealerTotal);
            }
        }
        // Result
        if (playerTotal > 21) {
            System.out.println("Bust. You lose - go cry to yo mama.");
        } else if (dealerTotal > 21) {
            System.out.println("Dealer busts. You win!");
        } else if (playerTotal == 21) {
            System.out.println("Winna Winna Chikkin' Dinna! Nice!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Sad Trombone - You lose.");
        } else if (playerTotal == dealerTotal) { //tie
            if (playerTotal == 21) {
                System.out.println("Push on 21!");
            } else {
                System.out.println("Push it Real Good - push (aka tie).");
            }
        }

            System.out.println("Dealer hand: " + dealerHand);
            System.out.println("Dealer total: " + getHandValue(dealerHand));

            // Ask to play again
            System.out.println("\nPlay again? (y/n):");
            String again = input.nextLine().trim().toLowerCase();
            if (!again.equals("y")) {
                playAgain = false;
        }  
    }
    }
    private static Card dealOrQuit(DeckOfCards deck) {
        Card c = deck.dealCard();
        if (c == null) {
            System.out.println("\n*** Ruh Rho: the deck is out of cards. ***");
            System.out.println("No more cards to deal. Game over. Good bye");
        }
        return c;
    }
    public static int getCardValue(Card card) {
        String face = card.getFace();

        switch (face) {
            case "Ace":
                return 11;
            case "King":
            case "Queen":
            case "Jack":
            case "Ten":
                return 10;
            case "Deuce":
                return 2;
            case "Three":
                return 3;
            case "Four":
                return 4;
            case "Five":
                return 5;
            case "Six":
                return 6;
            case "Seven":
                return 7;
            case "Eight":
                return 8;
            case "Nine":
                return 9;

            default:
                throw new IllegalArgumentException("Unknown card face: " + face);
        }
    }

    public static int getHandValue(ArrayList<Card> hand) {
        int total = 0;
        int aceCount = 0;

        for (Card card : hand) {
            total += getCardValue(card);

            if (card.getFace().equals("Ace")) {
                aceCount++;
            }
        }

        // Soften Aces: turn 11 into 1 as needed
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }
        return total;
    }
}