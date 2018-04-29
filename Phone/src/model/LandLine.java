package model;

public class LandLine implements Communicator {

    private String owner;

    public LandLine(String name) {
        this.owner = name;
    }

    @Override
    public void makeCall(Contact c) {
        System.out.println("Calling: " + c.getName() + " from a landline.\n");
        c.receiveCall();
    }

    @Override
    public void answerCall(Contact c) {
        System.out.println("Receiving a call from: " + c.getNumber() + "\n");
    }
}
