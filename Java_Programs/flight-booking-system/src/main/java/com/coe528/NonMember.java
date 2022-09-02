package com.coe528;

public class NonMember extends Passenger {
    
    public NonMember(String name, int age) {
        super(name, age);
    }

    public double applyDiscount(double p) {
        if (this.getAge() > 65)
            return (p * 0.9);
        return p;
    }
}
