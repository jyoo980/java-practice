package model;

public class Food {

    public static final int INITIAL_NUTRITIONAL_VAL = 100;
    public static final int DECAY_AMOUNT = 10;

    private Cell position;
    private int nutritionalVal;

    public Food(Cell position) {
        this.position = position;
        nutritionalVal = INITIAL_NUTRITIONAL_VAL;
    }

    // Notice we have two constructors, example of method overloading
    public Food (Cell position, int nutritionalVal) {
        this.position = position;
        this.nutritionalVal = nutritionalVal;
    }

    public Cell getPosition() {
        return position;
    }

    public int getNutritionalVal() {
        return nutritionalVal;
    }

    public void decay() {
        if (nutritionalVal - DECAY_AMOUNT <= 0) {
            nutritionalVal = 0;
        } else {
            nutritionalVal -= DECAY_AMOUNT;
        }
    }
}