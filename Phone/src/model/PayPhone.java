package model;

public class PayPhone implements Communicator {

    public static final int CREDIT_PER_CALL = 5;

    private String location;
    private int credits;

    public PayPhone(String location) {
        this.location = location;
        credits = 0;
    }

    public String getLocation() {
        return location;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public void makeCall(Contact c) {
        if (hasSufficientCredits()) {
            System.out.println("Making a payphone call to:" + c.getName() + "\n");
            c.receiveCall();
            deductCallCredit();
        } else {
            System.out.println("Insufficient credits, please insert more.\n");
        }
    }

    @Override
    public void answerCall(Contact c) {
        System.out.println("ERROR: a payphone cannot answer calls!\n");
    }

    public void insertCredits(int credits) {
        this.credits += credits;
    }

    private boolean hasSufficientCredits() {
        return credits - CREDIT_PER_CALL >= 0;
    }

    private void deductCallCredit() {
        credits -= CREDIT_PER_CALL;
    }
}