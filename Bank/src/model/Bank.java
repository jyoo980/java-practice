package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private String location;
    private double totalHoldings;
    private List<Account> accounts;

    public Bank(String name, String location) {
        this.name = name;
        this.location = location;
        totalHoldings = 0.0;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Account> getAccounts() { return accounts; }

    public void registerAccount(Account acct) {
        if (acct.getBank() == null) {
            accounts.add(acct);
            acct.registerBank(this);
        }
    }

    public double computeTotalHoldings() {
        double totalHoldings = 0;

        totalHoldings += getTotalHoldings();

        this.totalHoldings = totalHoldings;
        return totalHoldings;
    }


    private double getTotalHoldings() {
        double totalHoldings = 0.0;

        for (Account acct : accounts) {
            totalHoldings += acct.getChequingBalance();
            totalHoldings += acct.getSavingsBalance();
        }
        return totalHoldings;
    }
}