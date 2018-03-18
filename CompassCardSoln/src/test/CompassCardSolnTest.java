package test;

import model.CompassCardSoln;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static model.CompassCardSoln.BUS_FARE_CHILD;
import static model.Rider.ADULT;
import static model.Rider.CHILD;
import static model.Rider.SENIOR;

public class CompassCardSolnTest {

    private final double DELTA = 0.001;
    private CompassCardSoln card;

    @Before
    public void setUp() {
        card = new CompassCardSoln();
    }

    @Test
    public void testConstructor() {
        assertEquals(card.getStoredTrip(), 0);
        assertEquals(card.getStoredValue(), 0, DELTA);
        assertEquals(card.getStoredPoints(), 0);
    }

    @Test
    public void testloadValue() {
        assertEquals(card.getStoredValue(), 0, DELTA);
        card.loadValue(0);
        assertEquals(card.getStoredValue(), 0, DELTA);
        card.loadValue(100);
        assertEquals(card.getStoredValue(), 100, DELTA);
    }

    @Test
    public void testInsufficentValue() {
        assertFalse(card.rideBus(CHILD));
        assertFalse(card.rideBus(ADULT));
        assertFalse(card.rideBus(SENIOR));
    }

    @Test
    public void testSufficientValue() {
        card.loadValue(500);
        assertTrue(card.rideBus(CHILD));
        assertEquals(card.getStoredValue(), 500 - BUS_FARE_CHILD, DELTA);
        assertEquals(card.getStoredTrip(), 3);
        assertEquals(card.getStoredPoints(), 50);
    }

    @Test
    public void testStoredTripsUsed() {
        card.loadValue(500);
        assertTrue(card.rideBus(CHILD));
        assertEquals(card.getStoredValue(), 500 - BUS_FARE_CHILD, DELTA);
        assertEquals(card.getStoredTrip(), 3);
        assertEquals(card.getStoredPoints(), 50);
        assertTrue(card.rideBus(CHILD));
        assertEquals(card.getStoredValue(), 500 - BUS_FARE_CHILD, DELTA);
        assertEquals(card.getStoredTrip(), 2);
        assertEquals(card.getStoredPoints(), 50);
    }



}
