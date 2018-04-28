package model;

public class RegularAccount extends Account {

    private static final double INITAL_DEBIT_LIMIT = 1500.00;

    public RegularAccount(String owner, Bank bank) {
       super(bank, owner, INITAL_DEBIT_LIMIT);
    }
}