package com.javarush.test.level24.lesson14.big01;

import java.util.ArrayList;

/**
 Задание 5
 Чего еще не хватает классу Arcanoid?
 Ну во-первых ему нужен метод run(), в котором будет описана основная логика программы
 Еще нужен метод move() - который будет двигать на один шаг все объекты требующие движения.
 Создай методы run() и move().

 Еще нам понадобится статическая переменная game типа Arcanoid, которая будет хранить ссылку
 на созданный экземпляр класса Arcanoid.
 Выглядеть это должно примерно так:
 public static Arcanoid game;


 */
public class Arcanoid
{
    int width;
    int height;

    Ball ball;
    Stand stand;
    ArrayList<Brick> bricks=new ArrayList<>();

    public Ball getBall()
    {
        return ball;
    }

    public void setBall(Ball ball)
    {
        this.ball = ball;
    }

    public Stand getStand()
    {
        return stand;
    }

    public void setStand(Stand stand)
    {
        this.stand = stand;
    }

    public ArrayList<Brick> getBricks()
    {
        return bricks;
    }

    public void setBricks(ArrayList<Brick> bricks)
    {
        this.bricks = bricks;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Arcanoid(int width, int height)
    {

        this.width = width;
        this.height = height;
    }

    public static Arcanoid game;

    public static void main(String[] args)
    {

    }

    public void run(){

    }
    public void move(){

    }
}
