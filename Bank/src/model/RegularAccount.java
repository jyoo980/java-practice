package model;

public class RegularAccount {

    private static final double INITAL_DEBIT_LIMIT = 1500.00;

    private String owner;
    private Bank bank;
    private double chequingBalance;
    private double savingsBalance;
    private double debitLimit;

    public RegularAccount(String owner, Bank bank) {
        this.owner = owner;
        this.bank = bank;
        bank.registerRegularAccount(this);
        chequingBalance = 0.0;
        savingsBalance = 0.0;
        debitLimit = INITAL_DEBIT_LIMIT;
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

    public double getDebitLimit() {
        return debitLimit;
    }

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