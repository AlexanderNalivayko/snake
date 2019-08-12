package nlvk.snake_game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static nlvk.snake_game.Objects.Create;

public class KeyBoard extends KeyAdapter {
    public void keyPressed(KeyEvent k){
        TheSnake snake = Create();
        int key = k.getKeyCode();
        if ((key == KeyEvent.VK_RIGHT) & snake.direction != 3) snake.direction = 1;
        if ((key == KeyEvent.VK_DOWN) & snake.direction != 0) snake.direction = 2;
        if ((key == KeyEvent.VK_LEFT) & snake.direction != 1) snake.direction = 3;
        if ((key == KeyEvent.VK_UP) & snake.direction != 2) snake.direction = 0;
    }
}
