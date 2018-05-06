package model;

import exceptions.IllegalValueException;
import exceptions.IncorrectAgeException;
import exceptions.NoFareException;

public class BusFareCard {

    private static final int AGE_CUTOFF = 18;
    public static final double ADULT_FARE = 2.75;
    public static final double CONCESSION_FARE = 1.75;
    private String ownerName;
    private int ownerAge;
    private double balance;
    private boolean fareLoaded;

    public BusFareCard(String nm, int age, double initialLoad) throws IllegalValueException {
        if (nm.equals("") || age <= 0 || initialLoad <= 0) {
            throw new IllegalValueException("Invalid name, age, or initial balance");
        } else {
            ownerName = nm;
            ownerAge = age;
            balance = initialLoad;
            fareLoaded = true;
        }
    }

    // getters
    public String getName() { return ownerName; }
    public int getAge() { return ownerAge; }
    public double getBalance() { return balance; }
    public boolean isFareLoaded() { return fareLoaded; }

    public void purchaseAdultFare() throws IllegalValueException, IncorrectAgeException {
        if (ownerAge < AGE_CUTOFF) {
            throw new IncorrectAgeException("You are under 18, purchase a concession ticket!");
        } else if (balance - ADULT_FARE < 0) {
            throw new IllegalValueException("Not enough money to purchase a fare!");
        } else {
            balance -= ADULT_FARE;
            fareLoaded = true;
        }
    }

    public void purchaseConcessionTicket() {
        if (ownerAge <= AGE_CUTOFF && balance - CONCESSION_FARE >= 0) {
            balance -= CONCESSION_FARE;
            fareLoaded = true;
        }
    }

    public void reloadBalance(double amount) throws IllegalValueException {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalValueException("Invalid reload amount");
        }
    }

    public void boardBus() throws NoFareException {
        if (fareLoaded) {
            fareLoaded = false;
        } else {
            throw new NoFareException("No fare! Cannot board bus!\n");
        }
    }
}
