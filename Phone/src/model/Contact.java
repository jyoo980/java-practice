package model;

public class Contact {

    private String name;
    private String number;
    private int callCount;
    private int textCount;
    private int id;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
        callCount = 0;
        textCount = 0;
        id = Integer.parseInt(number) * 31;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public void receiveCall() {
        callCount++;
    }

    public void receiveText() {
        textCount++;
    }

}