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
    private double slowdown = boost / 10;


    public  Rocket(double x, double y){
        super(x,y, ShapeMatrix.ROCKET);
    }

    public void move(boolean isUpPressed, boolean isLeftPressed, boolean isRightPressed){
        /*2. В методе move(boolean, boolean, boolean) полю speedX должно устанавливаться значение 0, если параметр метода
        isLeftPressed равен false и параметр метода isRightPressed равен false и значение поля speedX находится в диапазоне от (-slowdown) до slowdown включительно.

3. В методе move(boolean, boolean, boolean) поле speedX должно уменьшаться на значение slowdown, если параметр метода
isLeftPressed равен false, параметр метода isRightPressed равен false и значение поля speedX больше значения slowdown.

4. В методе move(boolean, boolean, boolean) поле speedX должно увеличиваться на значение slowdown, если параметр метода
 isLeftPressed равен false, параметр метода isRightPressed равен false и значение поля speedX меньше значения (-slowdown).

5. В методе move(boolean, boolean, boolean) поле x должно быть увеличено на значение speedX после того, как поле speedX
 было изменено, и до вызова метода checkBorders().*/
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

        if(!isLeftPressed && !isRightPressed ){
            if(speedX >= -slowdown && speedX <= slowdown){
                speedX = 0;
            } else  if(!isLeftPressed && !isRightPressed){
                if (speedX > slowdown){
                    speedX -= slowdown;
                    x += speedX;

                }else if(speedX < -slowdown){
                    speedX += slowdown;
                    x += speedX;

                }
            }
        }


        checkBorders();
    }

    private void checkBorders(){


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
