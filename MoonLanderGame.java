package com.javarush.games.moonlander;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

public class MoonLanderGame extends Game {
    public final static int WIDTH = 64;
    public final static int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;

    /* 1. В классе MoonLanderGame должно существовать приватное поле isUpPressed типа boolean.
2. В классе MoonLanderGame должно существовать приватное поле isLeftPressed типа boolean.
3. В классе MoonLanderGame должно существовать приватное поле isRightPressed типа boolean.
4. Поле isUpPressed должно быть инициализировано в методе createGame() значением false.
5. Поле isLeftPressed должно быть инициализировано в методе createGame() значением false.
6. Поле isRightPressed должно быть инициализировано в методе createGame() значением false.*/

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);

    }

    private void drawScene(){

        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                setCellColor(x, y, Color.BEIGE);
            }
        }
       rocket.draw(this);
        landscape.draw(this);
    }

    private void createGame(){
        createGameObjects();
        drawScene();
        setTurnTimer(50);
        isLeftPressed = false;
        isRightPressed = false;
        isUpPressed = false;
    }

    private void createGameObjects(){
        rocket = new Rocket((WIDTH / 2), 0);
        /*5. Поле landscape должно быть проинициализировано в методе createGameObjects()
        новым объектом типа GameObject с параметрами: 0, 25, ShapeMatrix.LANDSCAPE.*/

        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
    }

    /*10. В методе onTurn(int) класса MoonLanderGame у объекта rocket должен быть вызван
    метод move(boolean, boolean, boolean) с параметрами: isUpPressed, isLeftPressed, isRightPressed.*/
    @Override
    public void onTurn(int y){
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color){
        if(x > WIDTH -1 || y > HEIGHT-1 || x < 0 || y < 0){
            return;
        }
        super.setCellColor(x,y,color);
        /*если параметр метода x, или y находится за пределами поля, метод не должен ничего делать.
        12. В методе setCellColor(int, int, Color) должен вызываться метод базового класса, используя ключевое слово "super".*/
    }
    /*
    1. В классе MoonLanderGame должен быть переопределен метод onKeyPress(Key) родительского класса Game.
2. Метод onKeyPress(Key) должен устанавливать полю isUpPressed значение true, если параметр метода равен Key.UP.
3. Если параметр метода onKeyPress(Key) равен Key.LEFT, метод должен устанавливать полю isLeftPressed значение true, а полю isRightPressed значение false.
4. Если параметр метода onKeyPress(Key) равен Key.RIGHT, метод должен устанавливать полю isRightPressed значение true, а полю isLeftPressed значение false.
5. В классе MoonLanderGame должен быть переопределен метод onKeyReleased(Key) родительского класса Game.
6. Метод onKeyReleased(Key) должен устанавливать полю isUpPressed значение false, если параметр метода равен Key.UP.
7. Метод onKeyReleased(Key) должен устанавливать полю isLeftPressed значение false, если параметр метода равен Key.LEFT.
8. Метод onKeyReleased(Key) должен устанавливать полю isRightPressed значение false, если параметр метода равен Key.RIGHT.*/
    @Override
    public void onKeyPress(Key key){
        if(key == Key.UP){
            isUpPressed = true;
        } else if(key == Key.LEFT){
            isLeftPressed = true;
            isRightPressed = false;
        } else if(key == Key.RIGHT){
            isRightPressed = true;
            isLeftPressed = false;
        }
    }

    @Override
    public void onKeyReleased(Key key){
        if(key == Key.UP){
            isUpPressed = false;
        } else if(key == Key.LEFT){
            isLeftPressed = false;
        } else if(key == Key.RIGHT){
            isRightPressed = false;
        }
    }
}
