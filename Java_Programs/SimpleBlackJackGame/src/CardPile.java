package com.coe318;

import java.util.ArrayList;
import java.util.Random; //imported Random as I couldnt get Math.random() to work

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;

    public CardPile() {
        //Initialize the instance variable.
        this.cards = new ArrayList<Card>(); //assigned AL to cards

    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card anotherCard) {
        //FIX THIS //add a card object to the AL cards (note that cards is AL and card is object)
        cards.add(anotherCard); 
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        Random randomNum = new Random(); //made new random object
        int randomInt = randomNum.nextInt(cards.size()); //random int between (0)inclusive and AL (size)exclusive
        return cards.remove(randomInt);
        //double random = (int)(Math.random() * (cards.size()-1)); //couldnt get Math to work?should have cast full expression
        //System.out.println("" + random);
        //System.out.println("" + cards.size());
        //return cards.remove((int)random); //FIX THIS
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        //FIX THIS
        String answer = " "; //had to initialize as it didn't like just having the loop
        for (Card element : cards) { //enhanced loop cycles through the AL, and makes a long string of cards
            answer += element.getSuitString() + element.getRankString() + " ,"; //
        }
        return answer; 
        
        // alterantive method
    //    for (int i = 0; i < cards.size(); i++) {
    //        return cards.get(i) + " ,";
    //    }
    //    return "";
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());

        }
    }


}