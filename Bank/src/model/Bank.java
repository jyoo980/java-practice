package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private String location;
    private double totalHoldings;
    private List<RegularAccount> regularAccounts;
    private List<StudentAccount> studentAccounts;

    public Bank(String name, String location) {
        this.name = name;
        this.location = location;
        totalHoldings = 0.0;
        regularAccounts = new ArrayList<>();
        studentAccounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<RegularAccount> getRegularAccounts() {
        return regularAccounts;
    }

    public List<StudentAccount> getStudentAccounts() {
        return studentAccounts;
    }

    public void registerRegularAccount(RegularAccount acct) {
        if (acct.getBank() == null) {
            regularAccounts.add(acct);
            acct.registerBank(this);
        }
    }

    public void registerStudentAccount(StudentAccount acct) {
        if (acct.getBank() == null) {
            studentAccounts.add(acct);
            acct.registerBank(this);
        }
    }

    public double computeTotalHoldings() {
        double totalHoldings = 0;

        totalHoldings += getTotalHoldingsStudent();
        totalHoldings += getTotalHoldingsRegular();

        this.totalHoldings = totalHoldings;
        return totalHoldings;
    }

    private double getTotalHoldingsStudent() {
        double totalStudentHoldings = 0.0;

        for (StudentAccount stdAcct : studentAccounts) {
            totalStudentHoldings += stdAcct.getChequingBalance();
            totalStudentHoldings += stdAcct.getSavingsBalance();
        }

        return totalStudentHoldings;
    }

    private double getTotalHoldingsRegular() {
        double totalHoldings = 0.0;

        for (RegularAccount regAcct : regularAccounts) {
            totalHoldings += regAcct.getChequingBalance();
            totalHoldings += regAcct.getSavingsBalance();
        }
        return totalHoldings;
    }
}