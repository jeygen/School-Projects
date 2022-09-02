package com.coe528;

public abstract class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age cannot be negative"); 
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double applyDiscount(double p);
    
}
