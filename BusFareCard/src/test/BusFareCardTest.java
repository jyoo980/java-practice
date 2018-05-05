package test;

import model.BusFareCard;
import org.junit.Before;

public class BusFareCardTest {

    private BusFareCard card;

    @Before
    public void setUp() {
        card = new BusFareCard("Paul", 18, 500);
    }

}