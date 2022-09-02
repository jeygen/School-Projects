/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

/**
 *
 * @author josh
 */
public class Customer {
    private String userName;
    private String password;
    private int points;
    // I added 
    private Status myStatus;

    public Customer(String userName, String password, int points) {
        this.userName = userName;
        this.password = password;
        this.points = points;
        this.myStatus = new SilverStatus();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    /*
    public String getStatus() {
        if (points < 1000)
            return "Silver";
        else
            return "Gold";
    }
    */
    
    //I added
    public String getStatus() {
        if (points < 1000) {
            this.myStatus = new SilverStatus();
            return myStatus.getType();
        }
        else {
            this.myStatus = new GoldStatus();              
            return myStatus.getType();
        }
    }
    
    public void setStatus(Status s) {
        this.myStatus = s;
    }
    
    /*
    public void turnSilver() {
        myStatus.turnSilver(this);
    }
    
    public void turnGold() {
        myStatus.turnGold(this);
    }
    */


    
}