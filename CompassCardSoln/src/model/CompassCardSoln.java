package model;

public class CompassCardSoln {

    private static final int POINTS_EARNED_PER_CENT = 2;
    private static final int POINTS_COST_PER_TRIP = 100;
    public static final double BUS_FARE_CHILD = 175;
    public static final double BUS_FARE_ADULT = 275;
    public static final double BUS_FARE_SENIOR = 200;

    private int storedTrip;
    private double storedValue;
    private int storedPoints;

    public CompassCardSoln() {
        storedTrip = 0;
        storedValue = 0;
        storedPoints = 0;
    }

    public int getStoredTrip() {
        return storedTrip;
    }

    public double getStoredValue() {
        return storedValue;
    }

    public int getStoredPoints() {
        return storedPoints;
    }

    public void loadValue(double value) {
        storedValue += value;
    }

    public boolean rideBus(Rider r) {
        if (storedTrip > 0) {
            storedTrip -= 1;
            return true;
        } else {
            return payCorrectFare(r);
        }
    }

    private boolean payCorrectFare(Rider r) {
        switch (r) {
            case CHILD:
                return deductFare(BUS_FARE_CHILD);
            case ADULT:
                return deductFare(BUS_FARE_ADULT);
            default:
                return deductFare(BUS_FARE_SENIOR);
        }
    }

    private boolean deductFare(double fare) {
        if (storedValue - fare >= 0) {
            storedValue -= fare;
            loadPoints(fare);
            return true;
        } else {
            return false;
        }
    }

    private void loadPoints(double cents) {
        storedPoints += cents * POINTS_EARNED_PER_CENT;
        int earnedTrips = storedPoints / POINTS_COST_PER_TRIP;
        while (earnedTrips > 0) {
            storedTrip += 1;
            storedPoints -= POINTS_COST_PER_TRIP;
            earnedTrips--;
        }
    }

}
