package nlvk.snake_game;

class Apple {
    private static int applePositionX = 5;
    private static int applePositionY = 5;

    static void SetRandomPositionXY(){
        applePositionX = (int) (Math.random()*20);
        applePositionY = (int) (Math.random()*20);
    }

    static int getApplePositionX() {
        return applePositionX;
    }

    static int getApplePositionY() {
        return applePositionY;
    }
}
