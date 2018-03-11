package model;

public class Car {

    // Attributes: what our CAR IS - DONE!
    // Behaviour: what our Car CAN DO

    public static final double MAX_SPEED = 120.00;

    private String manufacturer;
    private int year;
    private double currentSpeed;

    public Car(String manufacturer, int year) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.currentSpeed = 0.0;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setSpeed(double speed) {
        if (speed <= 120.00) {
            this.currentSpeed = speed;
        }
    }

    public void accelerate(double delta) {
        if (this.currentSpeed + delta <= MAX_SPEED) {
            this.currentSpeed += delta;
        }
    }

    public void brake() {
        this.currentSpeed = 0;
    }

}