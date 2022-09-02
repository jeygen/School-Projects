package com.coe528;

public class Member extends Passenger {
    private int yearsOfMembership;

    public Member(String name, int age, int yearsOfMem) {
        super(name, age);
        if (yearsOfMem < 0)
            throw new IllegalArgumentException("Years of membership cannot be negative.");
        this.yearsOfMembership = yearsOfMem;
    }
    
    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }

    @Override 
    public double applyDiscount(double p) {
        if (this.getYearsOfMembership() > 5) 
            return (0.5 * p);
        else if (this.getYearsOfMembership() > 1 && this.getYearsOfMembership() <= 5) 
            return (0.9 * p);
        return p;
    }
    
}
