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
public class SilverStatus extends Status {
    private String type = "Silver";
    
    @Override
    public void turnGold(Customer c) {}
    
    @Override
    public void turnSilver(Customer c){
        c.setStatus(new SilverStatus());
    }
    
    public String getType() {
        return this.type;
    }
}