package model;

public class StudentAccount {

    private static final double STUDENT_DEBIT_LIMIT = 200.00;

    private String owner;
    private Bank bank;
    private String university;
    private double chequingBalance;
    private double savingsBalance;
    private double debitLimit;

    public StudentAccount(String owner, Bank bank, String university) {
        this.owner = owner;
        this.bank = bank;
        bank.registerStudentAccount(this);
        this.university = university;
        chequingBalance = 0.0;
        savingsBalance = 0.0;
        debitLimit = STUDENT_DEBIT_LIMIT;
    }

    public String getOwner() {
        return owner;
    }

    public String getUniversity() {
        return university;
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