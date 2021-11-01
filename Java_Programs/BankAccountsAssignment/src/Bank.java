package main.java.coe318.lab4;
import main.java.coe318.lab4.Account;

/**
 *
 * @author Your name
 */

public class Bank {
    private String name;
    /**
     * An array of Accounts managed by
     * this bank.
     */
    private Account [] accounts; //array of Account objects
    private int numAccounts;//number of active accounts

    public Bank(String name, int maxNumberAccounts) {
        this.name = name;
        accounts = new Account[maxNumberAccounts]; //accounts[i] makes i number of Account objects for array named accounts
        numAccounts = 0;
    }


    /**
     * @return the name
     */
    public String getName() {
        return this.name;  //Fix this DONE
    }

    /**
     * @return the numAccounts
     */
    public int getNumAccounts() {
        return this.numAccounts; //Fix this DONE
    }


    public Account[] getAccounts() {
        return this.accounts; //Fix this DONE
    }

    /**
     * Return true if the Bank already has an account
     * with this number; otherwise false.
     * @param accountNumber
     * @return
     */
    public boolean hasAccountNumber(int accountNumber) {
        for(int i = 0; i < accounts.length ; i++) { //how many elements in the accounts object array, the elements are account objects
            if (accounts[i].getNumber() == accountNumber) { //iterates through the bank class' accounts and checks the account objects in its accounts array
                return true;
            }
        }
        return false; //Fix this DONE
    }

    /**
     * Adds the specified account to the Bank if possible. If the account number
     * already exists or the Bank has reached its maximum
     * number of accounts, return false and do not add it; otherwise,
     * add it and return true.
     * @param account
     * @return true if successful
     */
    public boolean add(Account account) { //add another account object to accounts array

        if(hasAccountNumber(account.getNumber()) || numAccounts>=accounts.length)
            return false;
        for(int i=0;i<accounts.length;i++) {
            if(accounts[i]==null) {
                accounts[i]=account;
                numAccounts++;
                return true;
            }
        }
            return false;
           
        }

    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for(Account account : getAccounts()) {
            if (account == null) break;
            s += "\n  " + account;
        }
        return s;
    }
}
