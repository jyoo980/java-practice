package model;

public class Account {

    protected String owner;
    protected Bank bank;
    protected double chequingBalance;
    protected double savingsBalance;
    protected double debitLimit;

    public Account(Bank bank, String owner, double debitLimit) {
        this.bank = bank;
        chequingBalance = 0.0;
        this.owner = owner;
        savingsBalance = 0.0;
        this.debitLimit = debitLimit;
    }

    public String getOwner() {
        return owner;
    }

    public double getChequingBalance() {
        return chequingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double getDebitLimit() { return debitLimit; }

    public boolean depositIntoChequing(int amount) {
        if (amount > 0) {
            chequingBalance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean depositIntoSavings(int amount) {
        if (amount > 0) {
            savingsBalance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean debitPurchase(int amount) {
        if (chequingBalance - amount >= 0) {
            chequingBalance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public Bank getBank() {
        return bank;
    }

    public void registerBank(Bank bank) {
        if (this.bank == null) {
            this.bank = bank;
        }
    }
}
