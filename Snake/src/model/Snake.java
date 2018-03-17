package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static model.Direction.*;

public class Snake {

    public static final int NUTRITION_TO_GROW = 50; // Amount required for Snake to grow one Cell

    private Cell head;
    private List<Cell> body;
    private Direction direction;
    private int nutritionConsumed;

    public Snake(Cell head) {
        this.head = head;
        body = new LinkedList<>();
        direction = RIGHT;
        nutritionConsumed = 0;
    }

    public Cell getPosition() {
        return head;
    }

    public List<Cell> getBodyPositions() {
        return Collections.unmodifiableList(body);
    }

    public Direction getDirection() {
        return direction;
    }

    public int length() {
        return body.size() + 1; // body + head
    }

    public void eat(Food food) {
        nutritionConsumed += food.getNutritionalVal();
    }

    public boolean canGrow() {
        return nutritionConsumed >= NUTRITION_TO_GROW;
    }

    private void moveHead() {
        switch(direction) {
            case LEFT:
                head = new Cell(head.getRow(), head.getColumn() - 1);
                break;
            case RIGHT:
                head = new Cell(head.getRow(), head.getColumn() + 1);
                break;
            case UP:
                head = new Cell(head.getRow() - 1, head.getColumn());
                break;
            case DOWN:
                head = new Cell(head.getRow() + 1, head.getColumn());
                break;
        }
    }

    public void move() {
        body.add(0, new Cell(head.getRow(), head.getColumn()));

        if (canGrow()) {
            nutritionConsumed -= NUTRITION_TO_GROW;
        }
        else {
            body.remove(body.size() - 1);
        }

        moveHead();
    }

    // Rotates Snake to the left
    public void rotateLeft() {
        switch (direction) {
            case UP:
                direction = LEFT;
                break;
            case LEFT:
                direction = DOWN;
                break;
            case DOWN:
                direction = RIGHT;
                break;
            case RIGHT:
                direction = UP;
        }
    }

    // Rotates Snake to the right
    public void rotateRight() {
        switch (direction) {
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
        }
    }

}