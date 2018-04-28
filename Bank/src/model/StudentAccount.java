package model;

public class StudentAccount extends Account {

    public static final double STUDENT_DEBIT_LIMIT = 200.00;

    private String university;

    public StudentAccount(String owner, Bank bank, String university) {
        super(bank, owner, STUDENT_DEBIT_LIMIT);
        bank.registerAccount(this);
        this.university = university;
        debitLimit = STUDENT_DEBIT_LIMIT;
    }

    public String getUniversity() {
        return university;
    }
}