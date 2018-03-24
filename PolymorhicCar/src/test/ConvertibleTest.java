package test;

import model.Convertible;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static model.Convertible.CONVERTIBLE_GAS_CAPACITY;

public class ConvertibleTest {

    private Convertible car;

    @Before
    public void setUp() {
        car = new Convertible(2018, "Honda");
    }

    @Test
    public void testConstructor() {
        assertEquals(car.getYear(), 2018);
        assertEquals(car.getMake(), "Honda");
        assertEquals(car.getCurrentSpeed(), 0);
        assertEquals(car.getCurrentGasCapacity(), 0);
        assertFalse(car.isTopDown());
    }

    @Test
    public void testaccelerateSuccessful() {
        car.fillGas(CONVERTIBLE_GAS_CAPACITY - 1);
        car.accelerate(30);
        assertEquals(car.getCurrentSpeed(), 30);
        assertEquals(car.getCurrentGasCapacity(), CONVERTIBLE_GAS_CAPACITY - 2);
    }

    @Test
    public void testaccelerateNoGas() {
        car.accelerate(30);
        assertEquals(car.getCurrentGasCapacity(), 0);
        assertEquals(car.getCurrentSpeed(), 0);
    }

    @Test
    public void testFillGasSuccess() {
        assertEquals(car.getCurrentGasCapacity(), 0);
        assertTrue(car.fillGas(40));
        assertEquals(car.getCurrentGasCapacity(), 40);
    }

    @Test
    public void testFillGasTooFull() {
        assertEquals(car.getCurrentGasCapacity(), 0);
        assertFalse(car.fillGas(CONVERTIBLE_GAS_CAPACITY + 1));
        assertEquals(car.getCurrentGasCapacity(), 0);
    }

    @Test
    public void testBrake() {
        car.fillGas(CONVERTIBLE_GAS_CAPACITY - 1);
        car.accelerate(30);
        assertEquals(car.getCurrentSpeed(), 30);
        car.brake();
        assertEquals(car.getCurrentSpeed(), 0);
    }
}