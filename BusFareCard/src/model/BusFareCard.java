package model;

public class BusFareCard {

    private static final int AGE_CUTOFF = 18;
    public static final double ADULT_FARE = 2.75;
    public static final double CONCESSION_FARE = 1.75;
    private String ownerName;
    private int ownerAge;
    private double balance;
    private boolean fareLoaded;

    public BusFareCard(String nm, int age, double initialLoad) {
        ownerName = nm;
        ownerAge = age;
        balance = initialLoad;
        fareLoaded = true;
    }

    // getters
    public String getName() { return ownerName; }
    public int getAge() { return ownerAge; }
    public double getBalance() { return balance; }
    public boolean isFareLoaded() { return fareLoaded; }

    public void purchaseAdultFare() {
        if (ownerAge >= AGE_CUTOFF && balance - ADULT_FARE >= 0) {
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

    public void reloadBalance(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void boardBus() {
        if (fareLoaded) {
            fareLoaded = false;
        }
    }
}
