package model;

import java.util.*;

public class SnakeGame {

    public static final int BOARD_COLS = 10;
    public static final int BOARD_ROWS = BOARD_COLS;

    private Random randomNumberGenerator;
    private Snake snake;
    private Food food;

    public SnakeGame() {
        randomNumberGenerator = new Random();
        snake = new Snake(new Cell(BOARD_ROWS/2, BOARD_COLS/2));
        food = createFood();
    }

    public void update() {
        if (!isOver()) {
            snake.move();
            food.decay();
            if (canSnakeEat()) {
                eatFood();
                food = createFood();
            }
        }
    }

    public Cell getSnakeHeadPosition() {
        return snake.getPosition();
    }

    public List<Cell> getSnakeBodyPositions() {
        return snake.getBodyPositions();
    }

    public Direction getSnakeDirection() {
        return snake.getDirection();
    }

    public int getSnakeLength() {
        return snake.length();
    }

    public Cell getFoodPosition() {
        return food.getPosition();
    }

    public int getFoodNutritionalValue() {
        return food.getNutritionalVal();
    }

    public boolean isOver() {
        return !isInBounds(snake.getPosition());
    }

    private boolean isInBounds(Cell cell) {
        return cell.getColumn() >= 0 && cell.getColumn() < BOARD_COLS
                && cell.getRow() >= 0 && cell.getRow() < BOARD_ROWS;
    }

    private boolean canSnakeEat() {
        return snake.getPosition().equals(food.getPosition());
    }

    private void eatFood() {
        snake.eat(food);
    }

    private Food createFood() {
        Cell position = randomCell();

        while (position.equals(snake.getPosition()))
            position = randomCell();

        return new Food(position);
    }

    public void rotateSnakeLeft() {
        snake.rotateLeft();
    }

    public void rotateSnakeRight() {
        snake.rotateRight();
    }

    private Cell randomCell() {
        return new Cell(randomNumberGenerator.nextInt(BOARD_ROWS), randomNumberGenerator.nextInt(BOARD_COLS));
    }

}
