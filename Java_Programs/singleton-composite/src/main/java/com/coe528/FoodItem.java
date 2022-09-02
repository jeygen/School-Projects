package com.coe528;

// Leaf - no objects below it

public class FoodItem extends FoodComponent {
    private String name;
    private double price;
    private int level;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    protected void print(int level) {
        System.out.println("    " + "Food Item: " + this.getName() + ", " + this.getPrice());
    }


    protected String getName() {
        return this.name;
    }

    protected double getPrice() {
        return this.price;
    }

    @Override
    protected int getLevel() {
        return this.level;
    }

    void setLevel(int l) {
        this.level = l;
    }

}