package model;

public class StudentAccount extends Account {

    private static final double STUDENT_DEBIT_LIMIT = 200.00;

    private String university;

    public StudentAccount(String owner, Bank bank, String university) {
        super(bank, owner);
        bank.registerAccount(this);
        this.university = university;
        debitLimit = STUDENT_DEBIT_LIMIT;
    }

    public String getUniversity() {
        return university;
    }

}