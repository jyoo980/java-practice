package model;

public class RegularAccount extends Account {

    private static final double INITAL_DEBIT_LIMIT = 1500.00;

    private String owner;
    private Bank bank;
    private double chequingBalance;
    private double savingsBalance;
    private double debitLimit;

    public RegularAccount(String owner, Bank bank) {
       super(bank, owner);
       this.debitLimit = INITAL_DEBIT_LIMIT;
    }

}