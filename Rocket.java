package com.javarush.games.moonlander;
/*
7. В классе Rocket должен существовать один публичный конструктор с двумя параметрами типа double (x и y),
 который вызывает конструктор базового класса с параметрами x, y и ShapeMatrix.ROCKET, используя ключевое слово "super".
1. В классе Rocket должно существовать приватное поле speedY типа double, проинициализированное при объявлении значением 0.
        2. В классе Rocket должно существовать приватное поле boost типа double, проинициализированное при объявлении значением 0.05.
        3. В классе Rocket должен существовать публичный метод void move().
        4. В методе move() поле speedY должно увеличиваться на значение boost.
        5. В методе move() поле y должно быть увеличено на значение speedY, после того как поле speedY было изменено.

        1. В классе Rocket должно существовать приватное поле speedX типа double, проинициализированное при объявлении значением 0.
2. В классе Rocket должен существовать публичный метод void move(boolean isUpPressed, boolean isLeftPressed, boolean isRightPressed).
3. В классе Rocket не должен существовать публичный метод void move().*/
public class Rocket extends GameObject {
    private double speedY = 0;
    private double speedX = 0;

    private double boost = 0.05;


    public  Rocket(double x, double y){
        super(x,y, ShapeMatrix.ROCKET);
    }

    public void move(boolean isUpPressed, boolean isLeftPressed, boolean isRightPressed){
        /*4. В методе move(boolean, boolean, boolean) значение поля speedY должно уменьшаться на значение boost, если параметр метода isUpPressed равен true.
        5. В методе move(boolean, boolean, boolean) значение поля speedY должно увеличиваться на значение boost, если параметр метода isUpPressed равен false.

        6. В методе move(boolean, boolean, boolean) значение поля y должно быть увеличено на значение speedY после того, как поле speedY было изменено.

        7. В методе move(boolean, boolean, boolean) значение поля speedX должно уменьшаться на значение boost, если параметр метода isLeftPressed равен true.

        8. В методе move(boolean, boolean, boolean) значение поля speedX должно увеличиваться на значение boost, если параметр метода isRightPressed равен true.

        9. В методе move(boolean, boolean, boolean) значение поля x должно быть увеличено на значение speedX после того, как поле speedX было изменено.*/
        if(isUpPressed){
            speedY -= boost;
            y += speedY;
        } else{
            speedY += boost;
            y += speedY;
        };

        if(isLeftPressed){
            speedX -= boost;
            x += speedX;
        };

        if(isRightPressed){
            speedX += boost;
            x += speedX;
        };

        checkBorders();
    }

    private void checkBorders(){
        /*2. В методе checkBorders(), если значение поля x меньше нуля, установи ему значение 0.
3. В методе checkBorders(), если значение поля x меньше нуля, установи полю speedX значение 0.
4. В методе checkBorders(), если сумма значений полей x и width больше ширины игрового поля MoonLanderGame.WIDTH, установи полю x значение (MoonLanderGame.WIDTH - width).
5. В методе checkBorders(), если сумма значений полей x и width больше ширины игрового поля MoonLanderGame.WIDTH, установи полю speedX значение 0.
6. В методе checkBorders(), если значение поля y меньше нуля, установи ему значение 0.
7. В методе checkBorders(), если значение поля y меньше нуля, установи полю speedY значение 0.*/
        if(x < 0){
            x = 0;
            speedX = 0;
        };

        if (x + width >  MoonLanderGame.WIDTH){
            x = MoonLanderGame.WIDTH - width;
            speedX = 0;
        };

        if ( y < 0 ){
            y = 0;
            speedY = 0;
        }
    }
}
