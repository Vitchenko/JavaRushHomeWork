package com.javarush.test.level22.lesson18.big01;

/**
 * Created by viv on 26.10.2016.
 */
public class Tetris extends Thread
{
    private Field field;
    private Figure figure;
    public static Tetris game;

    public static void main(String[] args)
    {
        game = new Tetris();
        game.run();
    }


    public Field getField()
    {
        return field;
    }

    public Figure getFigure()
    {
        return figure;
    }

    public void run(){    }

    public void step(){

    }



}
