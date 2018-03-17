package test;

import model.Cell;
import model.Food;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static model.Food.DECAY_AMOUNT;
import static model.Food.INITIAL_NUTRITIONAL_VAL;

public class FoodTest {

    private Food food;
    private Cell cell;

    @Before
    public void setUp() {
        cell = new Cell(2, 2);
        food = new Food(cell);
    }

    @Test
    public void testgetPosition() {
        assertEquals(food.getPosition(), cell);
    }

    @Test
    public void testgetNutritionalVal() {
        assertEquals(food.getNutritionalVal(), INITIAL_NUTRITIONAL_VAL);
    }

    @Test
    public void decaySuccess() {
        assertEquals(food.getNutritionalVal(), INITIAL_NUTRITIONAL_VAL);
        food.decay();
        assertEquals(food.getNutritionalVal(), INITIAL_NUTRITIONAL_VAL - DECAY_AMOUNT);
    }

    @Test
    public void testdecayFail() {
        Food food = new Food(cell, 9);
        food.decay();
        assertEquals(food.getNutritionalVal(), 0);
    }
}