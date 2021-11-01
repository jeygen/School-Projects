package main.java.coe318.lab4;

public class Account {
    private int number;
    private String name;
    private double balance;

    public Account(String name, int number, double initialBalance) {//fill in
        this.name = name;
        this.number = number;
        this.balance = initialBalance;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }
    
    public double getBalance() {
        return this.balance;
    }

   
    public boolean deposit(double amount) {
        if (amount >= 0) { //can not deposit neg value
            this.balance += amount;
            return true;
        }
        return false;
    }


    public boolean withdraw(double amount) {
        if (this.balance - amount >= 0 && amount > 0) { //no overdraft and cant withdraw neg
            this.balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + getName() + ", " + getNumber() + ", " + String.format("$%.2f", getBalance()) + ")";
    }
}
