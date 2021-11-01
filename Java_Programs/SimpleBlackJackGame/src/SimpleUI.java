package com.coe318;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        //FIX THIS //game is name of BlackjackGame object that is used in this class
        System.out.println("----------------------------------");
        System.out.println("House Cards: " + game.getHouseCards()); //use getter to access respective cards
        System.out.println("Your Cards: " + game.getYourCards());

    }

  @Override
    public boolean hitMe() {
        //FIX THIS
        System.out.println("----------------------------------");
        System.out.println("Would you like another card? (YES or NO)");
        String hitAnswer = user.next();
        if (hitAnswer.toUpperCase().equals("YES")){
          return true;
        } //returns true if user string matches
        return false;
    }

  @Override
    public void gameOver() {
        //FIX THIS
        int yourScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());
        //String housemessage = "House score is: " + houseScore;
        String win = "You win with a score of: " + yourScore;
        String lose = "You lose with a score of: " + yourScore;

        if (yourScore > 21) {
          System.out.println(lose);
          System.out.println("Auto lose as you have busted");
        }
        else if(houseScore > 21) {
          System.out.println(win);
          System.out.println("Auto win as house has busted");
        }
        else if(yourScore == houseScore) {
          System.out.println("Tie goes to house, so you lose :( ");
        }
        else if(21 - yourScore < 21 - houseScore) {
          System.out.println(win);
          System.out.println("Win as you are closer to 21");
        }
        else {
          System.out.println(lose); 
          System.out.println("Lose as house is closer to 21");
        }
          
    }

}