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
public class GoldStatus extends Status {
    private String type = "Gold";
    
    @Override
    public void turnGold(Customer c) {
        c.setStatus(new GoldStatus());
    }
    
    @Override
    public void turnSilver(Customer c){};
    
    public String getType() {
        return this.type;
    }
    
}
