package nlvk.snake_game;

class TheSnake {
    int direction = 0;
    int length = 2;
    int[] SnakeX =new int[100];
    int[] SnakeY =new int[100];

    TheSnake(int x0, int y0, int x1, int y1){
        SnakeX[0] = x0;
        SnakeY[0] = y0;
        SnakeX[1] = x1;
        SnakeY[1] = y1;
}
    void move() {

        for (int i = length; i >0; i--) {
            SnakeX[i] = SnakeX[i - 1];
            SnakeY[i] = SnakeY[i - 1];
        }
        if (direction == 0) SnakeY[0]--;
        else if (direction == 1) SnakeX[0]++;
        else if (direction == 2) SnakeY[0]++;
        else if (direction == 3) SnakeX[0]--;

        if ((SnakeX[0] == Apple.getApplePositionX())&(SnakeY[0]==Apple.getApplePositionY())){
            Apple.SetRandomPositionXY();
            length++;
            Objects.speed =(float)(Objects.speed + 0.1);
        }

        for (int i = 0; i < length; i++) {
            if (SnakeX[0] == SnakeX[i+1] & SnakeY[0]==SnakeY[i+1]){
                length = 0;
                Objects.gameStatus = false;
            }
        }
        if (SnakeX[0]>Objects.WIDTH)SnakeX[0] = 0;
        else if (SnakeX[0]<0)SnakeX[0] = Objects.WIDTH-1;
        else if (SnakeY[0]>Objects.HEIGHT-1)SnakeY[0] = 0;
        else if (SnakeY[0]<0)SnakeY[0] = Objects.HEIGHT-1;
    }
}