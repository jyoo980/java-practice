package model;

public class Cell {

    public static final int CELL_PIXELS = 30;

    private int column;
    private int row;

    public Cell(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getHorizontalScreenCoord() {
        return column * CELL_PIXELS;
    }

    public int getVerticalScreenCoord() {
        return row * CELL_PIXELS;
    }

    // Don't worry too much about the Equals and Hashcode methods here, we'll cover these later

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Cell)) return false;

        Cell objAsCell = (Cell) obj;
        return (objAsCell.column == column && objAsCell.row == row);
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        return result;
    }
}