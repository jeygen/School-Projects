package com.coe528;
import java.util.ArrayList;
import java.util.HashSet;

public class QueueOfDistinctStrings {
    
 // Overview: QueueOfDistinctStrings are mutable, bounded 
 // collection of distinct strings that operate in 
 // FIFO (First-In-First-Out) order. 
 //
 // The abstraction function is:
 // a) Write the abstraction function here
 // 
 //     AF(q) = An abstract queue of non-null distinct strings where d is a queue of distinct strings. (Mapping concrete to abstraction)
 //             Where d.items = q.items, an array list of distinct string elements with no null elements.
 //             Where d.list.get(i) == a distinct string element, i is an integer index for the q.list with a size [1..n]
 //             Where d.list.get(0) == the front of the q.list
 //             Where d.list.get((d.list.size()-1)) == the end of the q.list
 //
 // The rep invariant is:
 // b) Write the rep invariant here
 //     
 //     RI(q) = if q.list.get(i) == null return false
 //             if q.list.get(i) != <String> return false 
 //             if q.list.get(i) contains duplicate elements return false 
 //             return true if all elements in q.list are unique, non-null, and String type.
 
    //the rep
    private ArrayList<String> items;

    // constructor
    // EFFECTS: Creates a new QueueOfDistinctStrings object
    public QueueOfDistinctStrings () {
        items = new ArrayList<String>();
    }
    
    // MODIFIES: this
    // EFFECTS: Appends the element at the end of the queue
    // if the element is not in the queue, otherwise
    // does nothing.
    public void enqueue(String element) throws Exception {
        if(element == null) throw new Exception();
        if(false == items.contains(element)) 
            items.add(element);
    }
    
    // MODIFIES: this
    // EFFECTS: Removes an element from the front of the queue
    public String dequeue() throws Exception {
        if (items.size() == 0) throw new Exception();
        return items.remove(0);
    }

    // EFFECTS: Returns true if the rep invariant holds for this 
    // object; otherwise returns false 
    public boolean repOK() {
    // c) Write the code for the repOK() here

        ArrayList<String> copy = new ArrayList<String>(); // Making copy of items
        for (String s : items) {
            copy.add(s);
        }
        
        if (copy.contains(null)) // Checking for null elements
            return false;

        HashSet<String> compItems = new HashSet<String>(copy); // Eliminating duplicates by turning copy into a set via Hashset()  
        
        if (compItems.size() == this.items.size()) // Comparing the size of items with the set version
            return true;

        return false;
        }
    
    // EFFECTS: Returns a string that contains the strings in the 
    // queue, the front element and the end element. 
    // Implements the abstraction function. 
    public String toString() {
    // d) Write the code for the toString() here

        String a = "Printing queue of distinct strings: " + '\n'; 

        String b = "";
        for (String e : items) 
            b += e + '\n';
            
        String c = "The front elements is: " + this.items.get(0) + " and the end element is: " + this.items.get(this.items.size() - 1);

        return a + b + c;
    }
    
    /*
    public static void main(String [] args) throws Exception {
        QueueOfDistinctStrings q = new QueueOfDistinctStrings();
        String o = new String("one");
        q.enqueue(o);
        q.enqueue("two");
        q.enqueue("three");
        q.enqueue("four");
        System.out.println(q);
        System.out.println(q.repOK());
        q.dequeue();
        System.out.println(q);
        System.out.println(q.repOK());
    }
    */
}
