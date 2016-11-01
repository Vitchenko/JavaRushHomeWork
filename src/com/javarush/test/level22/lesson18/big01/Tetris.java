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

//        int[][] matrix=new int[10][8];
//        matrix[3][4]=1;
//        matrix[4][4]=1;
//        Field fl=new Field(8,10,matrix);
//        fl.print();
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
