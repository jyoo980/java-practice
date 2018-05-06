package test;

import exceptions.IllegalValueException;
import exceptions.IncorrectAgeException;
import exceptions.NoFareException;
import model.BusFareCard;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class BusFareCardTest {

    private BusFareCard card;

    @Before
    public void setUp() {
        try {
            card = new BusFareCard("Paul", 18, 500);
        } catch (Exception e) {
            System.out.println("Inproper values inputted");
        }
    }

    @Test (expected = IllegalValueException.class)
    public void testConstructorThrowsException() throws IllegalValueException {
            card = new BusFareCard("Paul", -1, 500);
    }

    @Test
    public void testConstructorThrowsException2() {
        try {
            card = new BusFareCard("Paul", -1, 500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testConstructorDoesNotThrowException() {
        try {
            card = new BusFareCard("Paul", 10, 500);
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void testReloadDoesNotThrowException() {
        try {
            card.reloadBalance(200);
        } catch (Exception e) {
            fail();
        }
    }

    @Test (expected = IllegalValueException.class)
    public void testReloadDoesThrowException() throws IllegalValueException {
        card.reloadBalance(-1);
    }

    @Test (expected = NoFareException.class)
    public void testBoardBusThrowsException() throws NoFareException {
        card.boardBus();
        card.boardBus();
    }

    @Test
    public void testBoardBusDoesNotThrowException() {
        try {
            card.boardBus();
        } catch (Exception e) {
            fail();
        }
    }

    @Test (expected = IncorrectAgeException.class)
    public void testPurchaseAdultFareIncorrectAge() throws IncorrectAgeException,IllegalValueException{
        BusFareCard card2= new BusFareCard("Jake",10,200);
        card2.purchaseAdultFare();
    }
}