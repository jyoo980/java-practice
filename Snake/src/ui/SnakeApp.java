package ui;

import model.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static model.Cell.CELL_PIXELS;
import static model.SnakeGame.BOARD_COLS;
import static model.SnakeGame.BOARD_ROWS;

class SnakeApp extends JFrame {
    private static final int WIDTH = BOARD_COLS * CELL_PIXELS;
    private static final int HEIGHT = BOARD_ROWS * CELL_PIXELS;
    private static final Color GAME_OVER_COLOUR = new Color(80, 40, 80);
    private static final int INTERVAL = 500;
    private SnakeGame game;
    private SnakeGameRenderer renderer;

    SnakeApp() {
        super("Snake");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        game = new SnakeGame();
        renderer = new SnakeGameRenderer(game);
        addKeyListener(new KeyHandler());
        centreOnScreen();
        addTimer();
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(game.isOver() ? GAME_OVER_COLOUR : getBackground());
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        renderer.draw(graphics);
    }

    private void addTimer() {
        final Timer t = new Timer(INTERVAL, null);
        t.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (game.isOver()) {
                    t.stop();
                }

                game.update();
                repaint();
            }
        });

        t.start();
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_KP_LEFT:
                    game.rotateSnakeLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_KP_RIGHT:
                    game.rotateSnakeRight();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new SnakeApp();
    }
}
