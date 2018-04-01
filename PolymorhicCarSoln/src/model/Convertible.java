package model;

public class Convertible extends Car {

    public static final double CONVERTIBLE_TOP_SPEED = 150.00;
    public static final int CONVERTIBLE_GAS_CAPACITY = 80;

    private boolean isTopDown;

    public Convertible(int year, String make) {
        super(year, make);
        isTopDown = false;

    }

    public boolean isTopDown() {
        return isTopDown;
    }

    public void putTopDown() { isTopDown = true; }

    // MODIFIES: this
    // REQUIRES: this car's top needs to be down if the current speed is greater than 50
    //           otherwise, you can freely accelerate
    // EFFECTS: this car's currentSpeed
    public void accelerate(int delta) {
        if (canAccelerate()) {
            super.accelerate(delta);
        }
    }

    private boolean canAccelerate() {
        return currentGasCapacity > 0 && currentSpeed <= 50 && !isTopDown;
    }

    public boolean fillGas(int amount) {
        if (canFillUp(amount)) {
           return super.fillGas(amount);
        } else {
            return false;
        }
    }

    private boolean canFillUp(int amount) {
        return currentGasCapacity + amount < CONVERTIBLE_GAS_CAPACITY;
    }

}