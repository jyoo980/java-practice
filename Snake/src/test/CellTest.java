package test;

import model.Cell;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static model.Cell.CELL_PIXELS;

public class CellTest {

    private Cell c1, c2;

    @Before
    public void setUp() {
        c1 = new Cell(0, 0);
        c2 = new Cell(3, 3);
    }

    @Test
    public void testConstructor() {
        assertEquals(c1.getColumn(), 0);
        assertEquals(c1.getRow(), 0);
        assertEquals(c2.getColumn(), 3);
        assertEquals(c2.getRow(), 3);
    }

    @Test
    public void testgetHorizontalScreenCoord() {
        assertEquals(c1.getHorizontalScreenCoord(), 0);
        assertEquals(c2.getHorizontalScreenCoord(), 3 * CELL_PIXELS);
    }

    @Test
    public void testgetVerticalScreenCoord() {
        assertEquals(c1.getVerticalScreenCoord(), 0);
        assertEquals(c2.getVerticalScreenCoord(), 3 * CELL_PIXELS);
    }

    @Test
    public void testEquals() {
        assertFalse(c1.equals(c2));
        assertFalse(c2.equals(c1));
        Cell c1Copy = new Cell(0, 0);
        assertTrue(c1.equals(c1Copy));
    }
}