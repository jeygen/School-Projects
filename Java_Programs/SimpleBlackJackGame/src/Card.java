package com.coe318;

public class Card implements Comparable {
    //Symbolic constants
  
    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    //Intance Var
    private int rank;
    private int suit;
    private boolean faceUp;
  
    /**
     * Construct a card of the given rank, suit and whether it is faceup or
     * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
     * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
     * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
     * Clubs, Diamonds, Hearts and Spades respectively.
     *
     * @param rank
     * @param suit
     * @param faceUp
     */
    public Card(int rank, int suit, boolean faceUp) {
      //FIX THIS done //assigned instance variables in constructor
      this.rank = rank;
      this.suit = suit;
      this.faceUp = faceUp;
    }
  
    /**
     * @return the faceUp
     */
    public boolean isFaceUp() {
      return (this.faceUp ? true : false); //FIX THIS done //return true/fasle if card is faceup/down
    }
  
    /**
     * @param faceUp the faceUp to set
     */
    public void setFaceUp(boolean faceUp) {
      //FIX THIS done //made setter function for card orientation
      this.faceUp = faceUp;
    }
  
    /**
     * @return the rank
     */
    public int getRank() {
      if(this.rank == 14) {
        return 1;
      }
      else if (this.rank > 10) {
        return 10;
      }
      else { 
        return this.rank; //FIX THIS done //getter for rank which is card value
      }
    }
  
    /**
     * @return the suit
     */
    public int getSuit() {
      return this.suit; //FIX THIS done //getter for suit
    }
  
    @Override
    public boolean equals(Object ob) {
      if (!(ob instanceof Card)) { //instanceof is a java operator that checks if object is of specified class
        return false;
      }
      Card c = (Card) ob;
      if (getRank() == c.getRank() && getSuit() == c.getSuit()) {
        return true;
      }
      else {
        return false;
      }
        //FIX THIS this function is checking to see if card is of same class, rank and suit
    }
  
    @Override
    public int hashCode() {//DO NOT MODIFY
      int hash = 7;
      hash = 31 * hash + this.getRank();
      hash = 31 * hash + this.getSuit();
      return hash;
    }
  
    @Override
    public int compareTo(Object obj) {//DO NOT MODIFY
      return compareTo((Card) obj);
    }
  
    public int compareTo(Card c) { //function returns diff of rank, if rank equal returns diff of suit
      if(getSuit() != c.getSuit()) {
        return getRank() - c.getRank();
      }
      else {
        return getSuit() - c.getSuit();
      }
    }
  
    /**
     * Return the rank as a String. For example, the 3 of Hearts produces the
     * String "3". The King of Diamonds produces the String "King".
     *
     * @return the rank String
     */
    public String getRankString() {
      switch(getRank()) {
        case 11:
          return "Jack";
        case 12:
          return "Queen";
        case 13: 
          return "King";
        case 1:  //covering my bases
        case 14:
          return "Ace";
        default:
        return "" + getRank();
      }

      //FIX THIS Converts int into string via overloading
    }
  
    /**
     * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
     *
     * @return the suit String
     */
    public String getSuitString() {
      switch(getSuit()) {
        case 0:
          return "Clubs";
        case 1:
          return "Diamonds";
        case 2: 
          return "Hearts";
        case 3:
          return "Spades";
        default:
          return "Error";
      }
     // made a switch statement to convert the suit into strings 
    }
  
    /**
     * Return "?" if the card is facedown; otherwise, the rank and suit of the
     * card.
     *
     * @return the String representation
     */
    @Override
    public String toString() {
      if (isFaceUp()) {
        return getRankString() + getSuitString();
      }
      else {
        return "?";
      }
      //FIX THIS returns rank and suit string if card is faceup otherwise ?
    }
  
    public static void main(String[] args) {
      //Create 5 of clubs
      Card club5 = new Card(5, 0, true);
      System.out.println("club5: " + club5);
      Card spadeAce = new Card(14, SPADE, true);
      System.out.println("spadeAce: " + spadeAce);
      System.out.println("club5 compareTo spadeAce: "
              + club5.compareTo(spadeAce));
      System.out.println("club5 compareTo club5: "
              + club5.compareTo(club5));
      System.out.println("club5 equals spadeAce: "
              + club5.equals(spadeAce));
      System.out.println("club5 equals club5: "
              + club5.equals(club5));
    }
  }
  