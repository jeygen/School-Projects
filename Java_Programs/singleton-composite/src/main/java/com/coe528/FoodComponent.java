package com.coe528;



// "Component" declares the interface for objects in the composition and for accessing and managing its child components. 
// It also implements default behavior for the interface common to all classes as appropriate.

public abstract class FoodComponent {
    protected abstract void print(int level);
    protected abstract String getName();
    protected abstract double getPrice();
    protected abstract int getLevel();
    
}