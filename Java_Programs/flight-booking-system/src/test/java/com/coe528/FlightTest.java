package com.coe528;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FlightTest {
    Flight instance = new Flight();
    
    @Test
    public void testConstructor() {
        Flight instance2 = new Flight(1, "Toronto", "Edmonton", "5:00 pm", 10, 45.4);
        assertTrue(instance2 instanceof Flight); // Could also check instance variables
    }

    @Test (expected = IllegalArgumentException.class) // Test passes if exception thrown
    public void testInvalidConstructor() {
        Flight instance3 = new Flight(10, "Toronto", "Toronto", "5:00 pm", 10, 45.4);
    }

    @Test 
    public void testGetCapacity() { // Testing both getters and setters is extra work as both methods are used for each test 
        int capacity = 10;
        instance.setCapacity(capacity);
        int expected = 10;
        int actual = instance.getCapacity();
        assertEquals(expected, actual);
    }
  
    @Test 
    public void testGetDepartureTime() {
        String departTime = "2:00";
        instance.setDepartureTime(departTime);
        String expected = "2:00";
        String actual = instance.getDepartureTime();
        assertEquals(expected, actual);
    }

    @Test 
    public void testGetDestination() {
        String dest = "yyz";
        instance.setDestination(dest);
        String expected = "yyz";
        String actual = instance.getDestination();
        assertEquals(expected, actual);

    }

    @Test
    public void testGetFlightNumber() {
        int fNum = 10;
        instance.setFlightNumber(fNum);
        int expected = 10;
        int actual = instance.getFlightNumber();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetNumberOfSeatsLeft() {
        int seats = 10;
        instance.setNumberOfSeatsLeft(seats);
        int expected = 10;
        int actual = instance.getNumberOfSeatsLeft();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetOrigin() {
        String origin = "yvr";
        instance.setOrigin(origin);
        String expected = "yvr";
        String actual = instance.getOrigin();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetOriginalPrice() {
        double price = 10.99;
        instance.setOriginalPrice(price);
        double expected = 10.99;
        double actual = instance.getOriginalPrice();
        assertTrue("Original price getter error", actual - expected == 0);
    }

    @Test
    public void testSetCapacity() {
        int capacity = 11;
        instance.setCapacity(capacity);
        int expected = capacity;
        int actual = instance.getCapacity();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetDepartureTime() {
        String departTime = "2:00";
        instance.setDepartureTime(departTime);
        String expected = "2:00";
        String actual = instance.getDepartureTime();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetDestination() {
        String dest = "yyz";
        instance.setDestination(dest);
        String expected = "yyz";
        String actual = instance.getDestination();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetFlightNumber() {
        int fNum = 10;
        instance.setFlightNumber(fNum);
        int expected = 10;
        int actual = instance.getFlightNumber();
        assertEquals(expected, actual);
    }

    @Test 
    public void testSetNumberOfSeatsLeft() {
        int seats = 10;
        instance.setNumberOfSeatsLeft(seats);
        int expected = 10;
        int actual = instance.getNumberOfSeatsLeft();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetOrigin() {
        String origin = "yvr";
        instance.setOrigin(origin);
        String expected = "yvr";
        String actual = instance.getOrigin();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetOriginalPrice() {
        double price = 10.99;
        instance.setOriginalPrice(price);
        double expected = 10.99;
        double actual = instance.getOriginalPrice();
        assertTrue("Original price getter error", actual - expected == 0);
    }

    @Test
    public void testBookASeat() {
        instance.setNumberOfSeatsLeft(5);
        boolean expected = true;
        boolean actual = instance.bookAseat();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        
        Flight instance4 = new Flight(1, "yyz", "yeg", "2:00pm", 2, 10);
        String actual = instance4.toString();
        String expected = "Flight: 1, yyz to yeg, 2:00pm. Original Price: $10.0";
        assertEquals(expected, actual);
    }
            
}