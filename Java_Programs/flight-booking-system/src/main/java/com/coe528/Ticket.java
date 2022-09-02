package com.coe528;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private static int number;
    private int id;
    
    public Ticket(Passenger p, Flight flight, double price) {
        passenger = p;
        this.flight =  flight;
        this.price = price;
        ++Ticket.number;
        id = Ticket.number;
    }

    public Flight getFlight() {
        return flight;
    }
    
    public static int getNumber() {
        return number;
    }

    public int getid() {
        return id;
    }
    
    public Passenger getPassenger() {
        return passenger;
    }

    public double getPrice() {
        return price;
    }
    
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public static void setNumber(int number) { // Should probably incorporate into constructor
        Ticket.number = number;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + this.getPassenger().getName() + ", Flight Number: " + this.getFlight().getFlightNumber() + ", " 
            + this.getFlight().getOrigin() + " to " + this.getFlight().getDestination() 
            + "@" + this.getFlight().getDepartureTime() + ", Original price: $" + getFlight().getOriginalPrice() 
            + ", Discounted price: $" + this.getPrice();  
    }
}
