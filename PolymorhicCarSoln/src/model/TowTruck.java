package model;

public class TowTruck extends Car{

    public static final int TRUCK_MAX_TONNAGE = 2000;
    public static final int TRUCK_MAX_GAS_CAPACITY = 200;

    private double currentWeight;

    public TowTruck(int year, String make) {
       super(year,make);
        currentWeight = 0;
    }

    // MODIFIES: this
    // REQUIRES: the current weight should be less than or equal to this truck's
    //           max tonnage subtracted by 1000
    // EFFECTS: this
    public void accelerate(int delta) {
        if (canAccelerate()) {
           super.accelerate(delta);
        }
    }

    private boolean canAccelerate() {
        return currentWeight <= TRUCK_MAX_TONNAGE - 1000 && currentGasCapacity > 0;
    }

    public boolean fillGas(int amount) {
        if (canFillUp(amount)) {
           return super.fillGas(amount);
        } else {
            return false;
        }
    }

    private boolean canFillUp(int amount) {
        return currentGasCapacity + amount < TRUCK_MAX_GAS_CAPACITY;
    }

    public boolean loadTruck(int load) {
        if (canLoad(load)) {
            currentWeight += load;
            return true;
        } else {
            return false;
        }
    }

    private boolean canLoad(int load) {
        return currentWeight + load <= TRUCK_MAX_TONNAGE;
    }

}