package com.javarush.test.level25.lesson16.big01;

/**
 Задание 14
 Теперь перейдем к методам draw, move
 В методе move() надо:
 а) увеличить x на dx
 б) проверить, не вылез ли корабль за границы космоса [0, Space.game.getWidth()]
 Учти, что ширина корабля равна двум его радиусам.

 Метод draw я напишу сам - просто объяви пустой метод.

 Еще нам понадобится метод fire(), ведь корабль умеет стрелять.
 Этот метод вызывается, когда надо произвести выстрел.
 В этом методе надо
 а) создать две ракеты
 б) установить им координаты левого края корабля и правого края корабля (пушки корабля находятся по краям)
 в) добавить эти ракеты в список ракет объекта game.

 Его можно получить так:
 Space.game.getRockets()
 }

 */
public class SpaceShip extends BaseObject
{
    public SpaceShip(double x, double y)
    {
        super(x, y, 3);
    }

    public SpaceShip(int x, int y)
    {
        super(x, y, 3);
    }

    double dx=0;
    public void moveLeft(){
     dx=-1;
    }
    public void moveRight(){
        dx=1;
    }

    public void move(){
        x+=dx;
    }

    public void draw(){

    }

    /*Еще нам понадобится метод fire(), ведь корабль умеет стрелять.
 Этот метод вызывается, когда надо произвести выстрел.
 В этом методе надо
 а) создать две ракеты
 б) установить им координаты левого края корабля и правого края корабля (пушки корабля находятся по краям)
 в) добавить эти ракеты в список ракет объекта game.

 Его можно получить так:
 Space.game.getRockets()*/

    public void fire(){
        Rocket rc1=new Rocket(this.x,this.y);
        Rocket rc2=new Rocket(this.x,this.y);
    }


}
