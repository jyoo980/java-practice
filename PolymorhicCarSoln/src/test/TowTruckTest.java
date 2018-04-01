package test;

import model.TowTruck;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static model.TowTruck.TRUCK_MAX_TONNAGE;

public class TowTruckTest {

    private TowTruck towTruck;

    @Before
    public void setUp() {
        towTruck = new TowTruck(2005, "Ford");
    }

    @Test
    public void testConstructor() {
        assertEquals(towTruck.getYear(), 2005);
        assertEquals(towTruck.getMake(), "Ford");
        assertEquals(towTruck.getCurrentSpeed(), 0);
        assertEquals(towTruck.getCurrentGasCapacity(), 0);
    }

    @Test
    public void testaccelerateSuccessful() {
        towTruck.fillGas(100);
        towTruck.accelerate(10);
        assertEquals(towTruck.getCurrentSpeed(), 10);
        assertEquals(towTruck.getCurrentGasCapacity(), 100 - 1);
    }

    @Test
    public void testaccelerateNoGas() {
        towTruck.accelerate(10);
        assertEquals(towTruck.getCurrentSpeed(), 0);
        assertEquals(towTruck.getCurrentGasCapacity(), 0);
    }

    @Test
    public void canLoadSuccess() {
        assertTrue(towTruck.loadTruck(TRUCK_MAX_TONNAGE));
    }

    @Test
    public void canLoadFail() {
        towTruck.loadTruck(TRUCK_MAX_TONNAGE);
        assertFalse(towTruck.loadTruck(1));
    }

}