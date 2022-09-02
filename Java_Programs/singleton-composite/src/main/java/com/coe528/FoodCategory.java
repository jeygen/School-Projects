package com.coe528;

/*
Composite – Composite stores child components and implements child related operations in the component interface.
Source: https://www.geeksforgeeks.org/composite-design-pattern/
*/

import java.util.ArrayList;
import java.util.List;

public class FoodCategory extends FoodComponent {
    // this will print everytin private static List<FoodComponent> list = new ArrayList<FoodComponent>();
    private List<FoodComponent> list = new ArrayList<FoodComponent>();
    private String name;
    private double price;
    public static int counter = 0;
    private int level = 0;

    public FoodCategory(String name) {
        this.name = name;
        this.level = counter;
        counter++;
    }

    public void print(int level) {
        double p = 0;
        for (FoodComponent f : list) {
            p += f.getPrice();
        }
        System.out.println("FoodCategory (" + this.getName() + ", " + p + ") contains:");
        for (FoodComponent f : list) {
            if (f.getLevel() > 0)
                System.out.print("    ");
            f.print(level);
        }
       /*
        if (this.level == level) {
            System.out.println("FoodCategory (" + this.getName() + ", " + this.getPrice() + ") contains:");
            for (FoodComponent f : list) {
                //System.out.println("FoodCategory (" + f.getName() + "," + f.getPrice() + ") contains:");
                if (f instanceof FoodCategory) {
                    System.out.println("FoodCategory (" + f.getName() + ", " + f.getPrice() + ") contains:");
                    //((FoodCategory)f).print(0);
                }
                    
                if (f instanceof FoodItem) {
                    ((FoodItem)f).print(0);
                }
            
            }
        }
        */
    
       


        
        
    }
    
    public void add(FoodComponent fComp) {  
        this.list.add(fComp);
        if (fComp instanceof FoodItem) {
            ((FoodItem)fComp).setLevel(this.getLevel());
            this.setPrice(fComp.getPrice() + this.getPrice());
        }
        
    }
    
    public void remove(FoodComponent fComp) {
        this.list.remove(fComp);
    }

    protected String getName() {
        return this.name;
    }

    protected double getPrice() {
        return this.price;
    }

    protected void setPrice(double p) {
        this.price = p;
    }

    protected int getLevel() {
        return this.level;
    }

    protected List<FoodComponent> getList() {
        return this.list;
    }



    
    
}
