package com.coe528;
import java.util.*;


public class Manager {
    private static Flight [] fList;
    private static Ticket [] tickList;
    
    // Prompts user to populate the flight option information
    public void createFlights(){ 
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please input total amount of flights:"); // Prompt user for number of Flights and create array of Flight objects.
        int numOfFlights;
        if (scan.hasNextInt()) {
            numOfFlights = scan.nextInt();
            if (numOfFlights <= 0)
                throw new IllegalArgumentException("Number of flights cannot be 0 or less");
        }
        else {
            throw new IllegalArgumentException("Number of flights must be an integer.");
        }
        
        fList = new Flight[numOfFlights];
        
        for (int i = 0; i < numOfFlights; i++) { // Prompts user to input values for Flight object and constructs Flight objects.
            System.out.println("Please input Flight Number: ");
            if (scan.hasNextInt() != true)
                throw new IllegalArgumentException("Flight number must be integer.");
            int fnum = scan.nextInt();
            System.out.println("Please input city of origin: ");
            String o = scan.next();
            System.out.println("Please input destination city: ");
            String dest = scan.next();
            System.out.println("Please input departure time: ");
            String departT = scan.next();
            System.out.println("Please input flight capacity: ");
            if (scan.hasNextInt() != true)
                throw new IllegalArgumentException("Flight capacity must be an integer.");
            int cap = scan.nextInt();
            System.out.println("Please input price per ticket: ");
            if (scan.hasNextDouble() != true)
                throw new IllegalArgumentException("Flight capacity can not be negative.");
            double origPrice = scan.nextDouble();
            fList[i] = new Flight(fnum, o, dest, departT, cap, origPrice);
            System.out.println();
        }
        
        // Gets capacity of all flights and creates Ticket[] of total capacity size
        int totalCap = 0; 
        for(int i = 0; i < fList.length; i++) 
            totalCap += fList[i].getCapacity(); 
        tickList = new Ticket[totalCap];
                
    }

    // Displays unbooked flights of specified origin, dest
    public void displayAvailableFlights(String origin, String destination) { 
            System.out.println("Printing available flights with specified origin and destination: ");
        for(int i = 0; i < fList.length; i++) {
            if (fList[i].getCapacity() > 0 && fList[i].getOrigin().toUpperCase().equals(origin.toUpperCase()) && fList[i].getDestination().toUpperCase().equals(destination.toUpperCase())) {
                System.out.println(fList[i].toString());
            }
            else if (fList[i].getOrigin().toUpperCase().equals(origin.toUpperCase()) && fList[i].getDestination().toUpperCase().equals(destination.toUpperCase()))  
                System.out.println(fList[i].getFlightNumber() + " is fully booked.");
            else 
                System.out.println("Flight " + fList[i].getFlightNumber() + " does not match the desired cities.");  
        }
    }
    
    // Returns flight object for specified flight number
    public Flight getFlight(int flightNumber) { 
        
        for(int i = 0; i < fList.length; i++) {
            if (fList[i].getFlightNumber() == flightNumber)
                return fList[i];
            else
                throw new IllegalArgumentException("No flight with that flight number available.");
        }
        return fList[0]; // dummy return
    }

    /*
        Tries to find flight with given flight number.
        If exists, tries to book seat.
        If successful applies correct discount.
        Issues ticket.
    */
    public void bookSeat(int flightNumber, Passenger p) { 
        double price = 0;

        for(int i = 0; i < fList.length; i++) {
            if (fList[i].getFlightNumber() == flightNumber) {
                fList[i].setCapacity(fList[i].getCapacity() - 1);
             
                if (p instanceof Member) {  
                    price = ((Member)p).applyDiscount(fList[i].getOriginalPrice());
                    System.out.println("Passenger with member status booked with ticket number : " + (Ticket.getNumber() + 1));
                }
                else {    
                    price = ((NonMember)p).applyDiscount(fList[i].getOriginalPrice());
                    System.out.println("Passenger with nonmember status booked with ticket number : " + (Ticket.getNumber() + 1));
                }                    
                tickList[Ticket.getNumber()] = new Ticket(p, fList[i], price);
            }
        } 
    }

    public static void main(String [] args) {
        /* 
        Suggested Input - The following inputs will demonstrate all the necessary classes and methods.

        Please input total amount of flights:
        3

        Please input Flight Number: 
        97
        Please input city of origin: 
        yyz
        Please input destination city: 
        yeg
        Please input departure time: 
        2pm
        Please input flight capacity: 
        5
        Please input price per ticket: 
        100

        Please input Flight Number: 
        98
        Please input city of origin: 
        yow
        Please input destination city: 
        yvr
        Please input departure time: 
        3pm
        Please input flight capacity: 
        3
        Please input price per ticket: 
        200

        Please input Flight Number: 
        99
        Please input city of origin: 
        yyZ
        Please input destination city: 
        yEg
        Please input departure time: 
        4pm
        Please input flight capacity: 
        3
        Please input price per ticket: 
        300
        
        */
        
        // Creating and populating flights through user input
        Manager manager = new Manager();
        manager.createFlights(); 

        // Prints total number of tickets and print current capacity for each flight booked
        System.out.println("Total number of tickets: " + Manager.tickList.length);
        for (int i = 0; i < Manager.fList.length; i++)
            System.out.println("Current flight capacity of " + Manager.fList[i].getFlightNumber() + " is " + Manager.fList[i].getCapacity());
        System.out.println();

        // Seeing all availabe flights with input origin and destination
        manager.displayAvailableFlights("YYZ", "YEG"); 
        System.out.println(); 
        
         // Creating Member and non-Member Passenger objects
        Member mem1 = new Member("Josh", 20, 3);        
        Member mem2 = new Member("Moe", 30, 10);
        NonMember nonMem1 = new NonMember("Xi", 72);
        NonMember nonMem2 = new NonMember("Karen", 52);
        NonMember nonMem3 = new NonMember("Kai", 10);
        NonMember nonMem4 = new NonMember("Debbie", 40);

        // Booking Passengers on Flight 96 to max capacity and partially booking Flight 99 
        manager.bookSeat(97, mem1);  
        manager.bookSeat(97, mem2);
        manager.bookSeat(97, nonMem1); 
        manager.bookSeat(97, nonMem2);
        manager.bookSeat(97, nonMem3);
        manager.bookSeat(99, nonMem4);
        System.out.println(); 
        
        // Print current capacity for each flight booked
        for (int i = 0; i < Manager.fList.length; i++)
            System.out.println("Current flight capacity of " + Manager.fList[i].getFlightNumber() + " is " + Manager.fList[i].getCapacity());
        System.out.println();

        // Prints out all issued tickets
        System.out.println("Printing out all issued tickets:"); 
        for(int i = 0; i < Manager.tickList.length; i++) {
            if (Manager.tickList[i] != null)
                System.out.println("Ticket " + Manager.tickList[i].getid() + ": ---> " + Manager.tickList[i]);
        }
        System.out.println();

        // Checking all available flights again
        manager.displayAvailableFlights("YYZ", "YEG");

    }
}
