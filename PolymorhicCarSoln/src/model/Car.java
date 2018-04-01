package model;

public class Car {

    protected int year;
    protected String make;
    protected int currentSpeed;
    protected int currentGasCapacity;

    public Car(int year, String make) {
        this.year = year;
        this.make = make;
        currentSpeed = 0;
        currentGasCapacity = 0;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getCurrentGasCapacity() {
        return currentGasCapacity;
    }

    public void brake() {
        currentSpeed = 0;
    }

    public void accelerate(int delta) {
        currentSpeed += delta;
        currentGasCapacity--;
    }

    public boolean fillGas(int amount) {
        currentGasCapacity += amount;
        return true;
    }










}
