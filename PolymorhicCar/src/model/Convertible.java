package model;

public class Convertible {

    public static final double CONVERTIBLE_TOP_SPEED = 150.00;
    public static final int CONVERTIBLE_GAS_CAPACITY = 80;

    private int year;
    private String make;
    private boolean isTopDown;
    private int currentSpeed;
    private int currentGasCapacity;

    public Convertible(int year, String make) {
        this.year = year;
        this.make = make;
        isTopDown = false;
        currentSpeed = 0;
        currentGasCapacity = 0;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public boolean isTopDown() {
        return isTopDown;
    }

    public void putTopDown() { isTopDown = true; }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getCurrentGasCapacity() {
        return currentGasCapacity;
    }

    public void brake() {
        currentSpeed = 0;
    }

    // MODIFIES: this
    // REQUIRES: this car's top needs to be down if the current speed is greater than 50
    //           otherwise, you can freely accelerate
    // EFFECTS: this car's currentSpeed
    public void accelerate(int delta) {
        if (canAccelerate()) {
            currentSpeed += delta;
            currentGasCapacity--;
        }
    }

    private boolean canAccelerate() {
        return currentGasCapacity > 0 && currentSpeed <= 50 && !isTopDown;
    }

    public boolean fillGas(int amount) {
        if (canFillUp(amount)) {
            currentGasCapacity += amount;
            return true;
        } else {
            return false;
        }
    }

    private boolean canFillUp(int amount) {
        return currentGasCapacity + amount < CONVERTIBLE_GAS_CAPACITY;
    }

}