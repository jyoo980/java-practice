package test;

import model.Car;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CarTest {

    private final double DELTA = 0.001;
    private Car car;

    @Before
    public void setUp() {
        car = new Car("Honda", 2016);
    }

    @Test
    public void testConstructor() {
        assertEquals(car.getManufacturer(), "Honda");
        assertEquals(car.getYear(), 2016);
        assertEquals(car.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testsetSpeedSuccess() {
        assertEquals(car.getCurrentSpeed(), 0, DELTA);
        car.setSpeed(88);
        assertEquals(car.getCurrentSpeed(), 88, DELTA);
    }

    @Test
    public void testsetSpeedFail() {
        assertEquals(car.getCurrentSpeed(),0,DELTA);
        car.setSpeed(Car.MAX_SPEED+1);
        assertEquals(car.getCurrentSpeed(),0,DELTA);
    }

    @Test
    public void testaccelerateSuccess() {
        assertEquals(car.getCurrentSpeed(), 0, DELTA);
        car.setSpeed(50);
        car.accelerate(30);
        assertEquals(car.getCurrentSpeed(), 80, DELTA);
    }

    @Test
    public void testaccelerateFail() {
        assertEquals(car.getCurrentSpeed(), 0, DELTA);
        car.setSpeed(50);
        car.accelerate(1000);
        assertEquals(car.getCurrentSpeed(), 50, DELTA);
    }

    @Test
    public void testbrake() {
        assertEquals(car.getCurrentSpeed(), 0, DELTA);
        car.setSpeed(50);
        car.brake();
        assertEquals(car.getCurrentSpeed(), 0 , DELTA);
    }
}
