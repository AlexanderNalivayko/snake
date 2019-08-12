package nlvk.snake_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Objects extends JPanel implements ActionListener {

    private static final int SCALE = 20;
    static final int WIDTH = 20;
    static final int HEIGHT = 20;
    static float speed = 4;
    static boolean gameStatus = true;
    private static TheSnake instance;


    static TheSnake Create() {
        if (instance == null) {
            instance = new TheSnake(10, 10, 10, 11);
        }
        return instance;
    }

    private TheSnake snake = Create();

    private Timer t = new Timer((int) (1000 / speed), this);

    public void paint(Graphics g) {
        g.setColor(new Color(49, 100, 79));
        g.fillRect(0, 0, SCALE * WIDTH, SCALE * HEIGHT);
        g.setColor(new Color(100, 100, 79));
        for (int i = 0; i < SCALE + 1; i++) {
            g.fillRect(i * SCALE - 2, 0, 2, SCALE * HEIGHT);
            g.fillRect(0, i * SCALE - 2, SCALE * WIDTH, 2);
        }
        g.setColor(new Color(25, 255, 25));
        for (int i = 0; i < snake.length; i++) {
            g.fillRect(snake.SnakeX[i] * SCALE, snake.SnakeY[i] * SCALE, 17, 17);
        }
        g.setColor(new Color(255, 0, 25));
        g.fillRect(Apple.getApplePositionX() * 20, Apple.getApplePositionY() * 20, 17, 17);
    }

    private Objects() {
        t.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(SCALE * WIDTH + 6, SCALE * HEIGHT + 6);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Objects());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class KeyBoard extends KeyAdapter {
        public void keyPressed(KeyEvent k) {
            int key = k.getKeyCode();
            if ((key == KeyEvent.VK_RIGHT) & snake.direction != 3) snake.direction = 1;
            if ((key == KeyEvent.VK_DOWN) & snake.direction != 0) snake.direction = 2;
            if ((key == KeyEvent.VK_LEFT) & snake.direction != 1) snake.direction = 3;
            if ((key == KeyEvent.VK_UP) & snake.direction != 2) snake.direction = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
}
