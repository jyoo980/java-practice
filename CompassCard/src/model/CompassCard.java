package model;

public class CompassCard {

    private static final int POINTS_PER_CENT = 2;
    private static final int POINTS_PER_TRIP = 100;
    private static final double BUS_FARE_CHILD = 175;
    private static final double BUS_FARE_ADULT = 275;
    private static final double BUS_FARE_SENIOR = 200;

    private int storedTrip;
    private double storedValue;
    private int storedPoints;

    public CompassCard() {

    }

    public int getStoredTrip() {
        return -1;
    }

    public double getStoredValue() {
        return -1.0;
    }

    public int getStoredPoints() {
        return -1;
    }

    public void loadValue(double value) {

    }

    public boolean rideBus(Rider r) {
        return false;
    }

    private boolean payCorrectFare(Rider r) {
        return false;
    }

    private boolean deductFare(double fare) {
        return false;
    }

}
